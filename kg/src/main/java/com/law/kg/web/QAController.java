package com.law.kg.web;

import com.law.kg.comm.QAOutput;
import com.law.kg.model.elasticsearch.QAData;
import com.law.kg.repository.QADataSearchReposity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/qa")
public class QAController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QADataSearchReposity qaDataSearchReposity;

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
            "投案自首减刑多少",
            "老师体罚学生犯法吗",
            "法律对未成年人有四方面的保护是什么",
            "网购受损可在本地法院起诉",
            "强制加班合法吗",
            "车撞伤人怎么处理",
            "公司将员工辞退后会有赔偿吗",
            "社会保险是什么",
            "家暴报警怎么处理",
            "租房被骗报警会立案吗",
            "借钱后消失可以报警吗",
            "物业纠纷如何处理",
            "遗产继承顺序",
            "坐过牢的人有哪些影响",
            "民间借贷利率多少合法",
            "网络诈骗怎么报案",
            "房屋出现质量问题应怎样赔偿",
            "身份证加急多久能办好",
            "微信被骗了钱投诉有用吗",
            "基本工资和岗位工资的区别",
            "产假工资怎么算",
            "病假工资如何计算",
            "结婚证件照要求有哪些",
            "微信贷款怎么申请",
            "实习未满可以直接走人吗",
            "信用卡欠款不还会怎么样",
            "怎么打赢商标侵权官司",
            "黄灯一秒算闯红灯吗",
            "户口本丢失了如何补办",
            "职务违法和职务犯罪的区别",
            "“三方协议”与劳动合同有何区别",
            "经济补偿金是什么呢"};

    @RequestMapping("/getAnswerOfQuestion")
    QAOutput getAnswerOfQuestion(String question) {

        if(StringUtils.isEmpty(question)){
            return new QAOutput("failure",demoQuestionList,null);
        }
        Pageable pageable = PageRequest.of(0,10);
        List<QAData> result = qaDataSearchReposity.findByQuestionMatches(question,pageable);
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
        return demoQuestionList[(int)(Math.random()*40)];
    }
}