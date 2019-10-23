package com.law.kg.comm;


import com.law.kg.model.elasticsearch.QAData;

import java.util.Arrays;
import java.util.List;

public class QAOutput {
    private String result;
    private String [] demoQuestion;
    private List<QAData> successData;

    public QAOutput() {
    }

    public QAOutput(String result, String[] demoQuestion, List<QAData> successData) {
        this.result = result;
        this.demoQuestion = demoQuestion;
        this.successData = successData;
    }

    @Override
    public String toString() {
        return "QAOutput{" +
                "result='" + result + '\'' +
                ", demoQuestion=" + Arrays.toString(demoQuestion) +
                ", successData=" + successData +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String[] getDemoQuestion() {
        return demoQuestion;
    }

    public void setDemoQuestion(String[] demoQuestion) {
        this.demoQuestion = demoQuestion;
    }

    public List<QAData> getSuccessData() {
        return successData;
    }

    public void setSuccessData(List<QAData> successData) {
        this.successData = successData;
    }
}
