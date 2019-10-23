package predict.impl;


import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import predict.IClassificationPredictService;
import predict.PredictService;
import predict.pojo.PredictResult;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredictAyService extends PredictService implements IClassificationPredictService {

    private int MAX_LENGTH = 600;
    private int HIDDEN_SIZE = 256;

    private Map<Integer, String> ayMap = new HashMap<>();

    private Graph graph;

    public void init() {
        try {
            super.init();
            graph = new Graph();
            InputStream stream = ClassLoader.getSystemResourceAsStream("predict/ay/output.pb");
            byte[] data = IOUtils.toByteArray(stream);
            graph.importGraphDef(data);

            stream = ClassLoader.getSystemResourceAsStream("predict/ay/accu.txt");
            data = IOUtils.toByteArray(stream);
            String[] labels = new String(data, "UTF-8").split("\r?\n");
            for (int index = 0; index < labels.length; index++) {
                ayMap.put(index, labels[index]);
            }
        } catch (Exception e) {
            throw new RuntimeException("读取案由预测模型出错");
        }
    }


    @Override
    public List<PredictResult> predict(String content, int k) {
        float[] scores = predict(content);
        List<Integer> kList = getKTop(scores, k);
        List<PredictResult> result = new ArrayList<>();
        for (int index : kList) {
            result.add(new PredictResult(this.ayMap.get(index), scores[index]));
        }
        return result;
    }


    private float[] predict(String text) {
        try (Session sess = new Session(graph)) {
            Session.Runner runner = sess.runner();
            int[][] wordIds = new int[1][];
            wordIds[0] = preprocess(text, MAX_LENGTH);
            runner.feed("input_x", Tensor.create(wordIds));
            runner.feed("pad", Tensor.create(new float[1][MAX_LENGTH][HIDDEN_SIZE]));
            runner.feed("keep_prob", Tensor.create(1.0f));
            runner.fetch("score/Sigmoid");
            Tensor label_pred = runner.run().get(0);
            float[][] labelIds = (float[][]) label_pred.copyTo(new float[1][this.ayMap.size()]);
            return labelIds[0];
        }
    }

}
