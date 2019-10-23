package com.law.criminal.web;

import com.law.criminal.comm.TrafficTableOutput;
import com.law.criminal.model.elasticsearch.TrafficLaw;
import com.law.criminal.service.TrafficLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trafficsearch")
public class TrafficSearchController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TrafficLawSearchService trafficLawSearchService;

    @RequestMapping("/getTrafficByChapterNum")
    public Page<TrafficLaw> getTrafficByChapterNum(int chapterNum, int pageSize, int pageNum) {
        logger.info("TrafficSearchController,getTrafficByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return trafficLawSearchService.findTrafficLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getTrafficByChapterNumAndSectionNum")
    public Page<TrafficLaw> getTrafficByChapterNumAndSectionNum(int chapterNum, int sectionNum, int pageSize, int pageNum) {
        logger.info("TrafficSearchController,getTrafficByChapterNumAndSectionNum:{},{},{},{}",chapterNum,sectionNum,pageSize,pageNum);
        return trafficLawSearchService.findTrafficLawByChapterNumAndSectionNum(chapterNum,sectionNum,pageSize,pageNum);
    }

    @RequestMapping("/getTrafficByItemNum")
    public TrafficLaw getTrafficByItemNum(int itemNum, int pageSize, int pageNum) {
        logger.info("TrafficSearchController,getTrafficByItemNum:{},{},{}",itemNum,pageSize,pageNum);
        return trafficLawSearchService.findTrafficLawByItemNum(itemNum);
    }

    @RequestMapping("/getTrafficLawByQueryString")
    public Page<TrafficLaw> getTrafficLawByQueryString(String queryString, int pageSize, int pageNum) {
        logger.info("TrafficSearchController,getTrafficLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return trafficLawSearchService.getTrafficLawByQueryString(queryString,pageSize,pageNum);
    }

//    @RequestMapping("/test")
//    public Page<TrafficLawNew> getTrafficLawNewByQueryString(String queryString, int pageSize, int pageNum) {
//        logger.info("TrafficSearchController,getTrafficLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
//        return trafficLawSearchService.getTrafficLawNewByQueryString(queryString,pageSize,pageNum);
//    }

    @RequestMapping("/getLawTable")
    public List<TrafficTableOutput> getLawTable()
    {
        return trafficLawSearchService.getLawTable();
    }

}
