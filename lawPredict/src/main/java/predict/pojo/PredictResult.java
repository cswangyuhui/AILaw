package predict.pojo;

public class PredictResult {
    private String label;

    private double score;

    public PredictResult(String label,double score){
        this.label=label;
        this.score=score;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
