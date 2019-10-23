package com.law.criminal.web;

import com.law.criminal.comm.QAOutput;
import com.law.criminal.model.elasticsearch.QAData;
import com.law.criminal.service.QASearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/qa")
public class QAController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QASearchService qaSearchService;

    private String[] demoQuestionList = new String[]{
                                        "买房被骗怎么投诉",
                                        "准备离婚 选择协议离婚还是诉讼离婚",
                                        "违章停车贴条怎么处理",
                                        "劳动合同到期不续签怎么补偿",
                                        "可以先修车再理赔吗",
                                        "员工辞职公司要赔钱吗",
                                        "殴打他人的治安处罚",
                                        "支付宝盗窃后怎么处理",
                                        "在朋友圈骂人构成侵权吗",
                                        "投案自首减刑多少"};

    @RequestMapping("/getAnswerOfQuestion")
    QAOutput getAnswerOfQuestion(String question) {

        if(StringUtils.isEmpty(question)){
            return new QAOutput("failure",demoQuestionList,null);
        }
        List<QAData>  result = qaSearchService.findQADataByQuestion(question);
        QAOutput qaOutput = new QAOutput();
        if(result.size() == 0){
            qaOutput.setResult("failure");
            qaOutput.setDemoQuestion(demoQuestionList);
            qaOutput.setSuccessData(null);
            return qaOutput;
        }
        qaOutput.setResult("success");
        qaOutput.setDemoQuestion(null);
        qaOutput.setSuccessData(result);
        return qaOutput;
    }

    @RequestMapping("/randomGetDemoQuestion")
    String randomGetDemoQuestion(String question) {
        return demoQuestionList[(int)(Math.random()*10)];
    }
}
