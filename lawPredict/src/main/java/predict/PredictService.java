package predict;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.*;

public class PredictService {

    private JiebaSegmenter segmenter;

    protected static Map<String, Integer> word2Id = new HashMap<>();

    protected void init() throws Exception {
        segmenter = new JiebaSegmenter();
        if (word2Id.size() == 0) {
            InputStream stream = ClassLoader.getSystemResourceAsStream("predict/word2id");
            byte[] data = IOUtils.toByteArray(stream);
            String[] words = new String(data, "UTF-8").split("\r?\n");
            for (int index = 0; index < words.length; index++) {
                word2Id.put(words[index], index + 1);
            }
            word2Id = Collections.unmodifiableMap(word2Id);
        }
    }

    protected int[] preprocess(String text, int MAX_LENGTH) {
        int[] result = new int[MAX_LENGTH];
        List<String> wordList = segmenter.sentenceProcess(text);
        int curIndex = 0;
        for (String word : wordList) {
            if (word.matches("\\d+(/.\\d+)?")) {
                word = "$NUM";
            } else if (word.matches("[a-zA-Z\\d/.]+")) {
                word = "$CODE";
            }
            Integer id = this.word2Id.get(word);
            if (id != null) {
                result[curIndex++] = id;
            }
        }
        return result;
    }

    public static LinkedList<Integer> getKTop(float[] scores, int topK) {
        LinkedList<Integer> kList = new LinkedList<>();
        for (int index = 0; index < scores.length; index++) {
            int pos = findIndex(kList, scores[index], scores);
            if (kList.size() == 0) {
                kList.add(index);
            } else {
                if (scores[kList.get(pos)] > scores[index]) {
                    kList.add(pos + 1, index);
                } else {
                    kList.add(pos, index);
                }
                if (kList.size() > topK) {
                    kList.removeLast();
                }
            }
        }
        return kList;
    }

    private static int findIndex(LinkedList<Integer> list, float value, float[] scores) {
        if (list.size() == 0) {
            return 0;
        } else {
            int start = 0;
            int end = list.size() - 1;
            while (true) {
                if (start == end) {
                    return start;
                }
                int mid = (start + end) / 2;
                if (scores[list.get(mid)] <= value) {
                    end = mid - 1 > start ? mid - 1 : start;
                } else {
                    start = mid + 1 < end ? mid + 1 : end;
                }
            }
        }
    }
}
