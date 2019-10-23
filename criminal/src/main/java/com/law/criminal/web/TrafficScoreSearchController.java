package com.law.criminal.web;


import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.TrafficScoreLaw;
import com.law.criminal.model.mysql.Traffic;
import com.law.criminal.service.TrafficScoreLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trafficscoresearch")
public class TrafficScoreSearchController {

    @Autowired
    TrafficScoreLawSearchService trafficScoreLawSearchService;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getTrafficScoreLawByChapterNum")
    public Page<TrafficScoreLaw> getTrafficScoreLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("TrafficScoreSearchController,getTrafficScoreLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return trafficScoreLawSearchService.findTrafficScoreLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getTrafficScoreLawByQueryString")
    public Page<TrafficScoreLaw> getTrafficScoreLawByQueryString(String queryString, Integer pageSize, Integer pageNum){
        logger.info("TrafficScoreSearchController,getTrafficScoreLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return  trafficScoreLawSearchService.findTrafficScoreLawByQueryString(queryString, pageSize, pageNum);
    }

    @RequestMapping("/getTrafficScoreLawTable")
    public List<CommonTableOutput> getTrafficScoreLawTable(){
        return trafficScoreLawSearchService.getTrafficScoreLawTable();
    }


}
