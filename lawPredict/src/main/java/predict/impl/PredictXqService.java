package predict.impl;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import predict.IRegressionPredictService;
import predict.PredictService;

import java.io.InputStream;

public class PredictXqService extends PredictService implements IRegressionPredictService {

    private int MAX_LENGTH = 600;
    private int HIDDEN_SIZE = 256;

    private Graph graph;


    public void init() {
        try {
            super.init();
            graph = new Graph();
            InputStream stream = ClassLoader.getSystemResourceAsStream("predict/xq/output.pb");
            byte[] data = IOUtils.toByteArray(stream);
            graph.importGraphDef(data);
        } catch (Exception e) {
            throw new RuntimeException("读取刑期预测模型出错");
        }
    }

    @Override
    public Object predict(String text) {
        Float f = predictFloat(text);
        int i = f.intValue();
        if ((f - i) >= 0.5) {
            i++;
        }
        if (i >= 325 && i <= 375) {
            return "无期徒刑";
        } else if (i > 375) {
            return "死刑";
        } else {
            int year = i / 12;
            int month = i % 12;
            if (year != 0) {
                return String.format("有期徒刑%s年%s个月", year, month);
            } else {
                return String.format("有期徒刑%s个月", month);
            }
        }
    }

    private float predictFloat(String text) {
        try (Session sess = new Session(graph)) {
            Session.Runner runner = sess.runner();
            int[][] wordIds = new int[1][];
            wordIds[0] = preprocess(text, MAX_LENGTH);
            runner.feed("input_x", Tensor.create(wordIds));
            runner.feed("pad", Tensor.create(new float[1][MAX_LENGTH][HIDDEN_SIZE]));
            runner.feed("keep_prob", Tensor.create(1.0f));
            runner.fetch("score/fc3/BiasAdd");
            Tensor pred = runner.run().get(0);
            float[][] labelIds = (float[][]) pred.copyTo(new float[1][1]);
            return labelIds[0][0];
        }
    }
}
