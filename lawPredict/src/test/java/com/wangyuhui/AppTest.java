package com.wangyuhui;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import predict.impl.PredictAyService;
import predict.impl.PredictLawService;
import predict.impl.PredictXqService;
import predict.pojo.PredictResult;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     *
     */
    PredictAyService predictAyService=new PredictAyService();
    PredictLawService predictLawService=new PredictLawService();
    PredictXqService predictXqService=new PredictXqService();


    @Before
    public void AppTestInit(){
        predictAyService.init();
        predictLawService.init();
        predictXqService.init();
    }



    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void predictLaw() {
        List<PredictResult> results=predictLawService.predict("公诉机关指控：2016年8月17日10时许，" +
                "被告人曾1某因琐事在孝感市公安局高新区分局城东派出所与被害人魏某2（已怀孕）发生口角，后被告人曾1某在派出" +
                "所一楼走廊踢了魏某2一脚，随后被害人魏某2上救护车时，被告人曾1某又在派出所门口向被害人魏某2的腹部踢了一脚，致使被害人魏某2" +
                "送医院后流产。经法医鉴定，魏某2的伤情为轻伤。为了证实上述指控，公诉机关提供了如下证据：1.办案说明、申请书、行政处罚决定书、" +
                "被告人身份信息等书证；2.孝感市公安司法鉴定中心法医鉴定书、武汉市精神病医院司法鉴定所司法鉴定意见书；3.被害人魏某2的陈述；4.证人徐某、" +
                "汤某,4的证言；5.辨认笔录；6.视听资料；7.被告人曾1某的供述和辩解。n公诉机关认为，被告人曾1某故意伤害他人身体致人轻伤，其行为" +
                "已触犯了《中华人民共和国刑法》××之规定，犯罪事实清楚，证据确实、充分，应当以××追究其刑事责任。",5);
        for(PredictResult result:results){
            System.out.println(result.getLabel()+' '+result.getScore());
        }
    }

    @Test
    public void predictCharge() {
        List<PredictResult> results=predictAyService.predict("公诉机关指控：2016年8月17日10时许，" +
                "被告人曾1某因琐事在孝感市公安局高新区分局城东派出所与被害人魏某2（已怀孕）发生口角，后被告人曾1某在派出" +
                "所一楼走廊踢了魏某2一脚，随后被害人魏某2上救护车时，被告人曾1某又在派出所门口向被害人魏某2的腹部踢了一脚，致使被害人魏某2" +
                "送医院后流产。经法医鉴定，魏某2的伤情为轻伤。为了证实上述指控，公诉机关提供了如下证据：1.办案说明、申请书、行政处罚决定书、" +
                "被告人身份信息等书证；2.孝感市公安司法鉴定中心法医鉴定书、武汉市精神病医院司法鉴定所司法鉴定意见书；3.被害人魏某2的陈述；4.证人徐某、" +
                "汤某,4的证言；5.辨认笔录；6.视听资料；7.被告人曾1某的供述和辩解。n公诉机关认为，被告人曾1某故意伤害他人身体致人轻伤，其行为" +
                "已触犯了《中华人民共和国刑法》××之规定，犯罪事实清楚，证据确实、充分，应当以××追究其刑事责任。",5);
        for(PredictResult result:results){
            System.out.println(result.getLabel()+' '+result.getScore());}

    }

    @Test
    public void predictTime() {
        String ouput=(String)predictXqService.predict("公诉机关指控：2016年8月17日10时许，" +
                "被告人曾1某因琐事在孝感市公安局高新区分局城东派出所与被害人魏某2（已怀孕）发生口角，后被告人曾1某在派出" +
                "所一楼走廊踢了魏某2一脚，随后被害人魏某2上救护车时，被告人曾1某又在派出所门口向被害人魏某2的腹部踢了一脚，致使被害人魏某2" +
                "送医院后流产。经法医鉴定，魏某2的伤情为轻伤。为了证实上述指控，公诉机关提供了如下证据：1.办案说明、申请书、行政处罚决定书、" +
                "被告人身份信息等书证；2.孝感市公安司法鉴定中心法医鉴定书、武汉市精神病医院司法鉴定所司法鉴定意见书；3.被害人魏某2的陈述；4.证人徐某、" +
                "汤某,4的证言；5.辨认笔录；6.视听资料；7.被告人曾1某的供述和辩解。n公诉机关认为，被告人曾1某故意伤害他人身体致人轻伤，其行为" +
                "已触犯了《中华人民共和国刑法》××之规定，犯罪事实清楚，证据确实、充分，应当以××追究其刑事责任。");
        System.out.println(ouput);
    }


}
