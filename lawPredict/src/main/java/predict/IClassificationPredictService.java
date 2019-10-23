package predict;

import predict.pojo.PredictResult;

import java.util.List;

public interface IClassificationPredictService {
    public List<PredictResult> predict(String content, int k);
}
