package com.law.criminal.web;

import com.law.criminal.comm.SecurityTableOutput;
import com.law.criminal.model.elasticsearch.SecurityLaw;
import com.law.criminal.service.SecurityLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/securitysearch")
public class SecuritySearchController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecurityLawSearchService securityLawSearchService;

    @RequestMapping("/getLawByChapterNum")
    public Page<SecurityLaw> getLawByChapterNum(int chapterNum, int pageSize, int pageNum) {
        logger.info("SecurityLawSearchService,getLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return securityLawSearchService.findSecurityLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getLawByChapterNumAndSectionNum")
    public Page<SecurityLaw> getLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, int pageSize, int pageNum) {
        logger.info("SecuritySearchController,getLawsByChapterNumAndSectionNum:{},{},{},{}",chapterNum,sectionNum,pageSize,pageNum);
        return securityLawSearchService.findSecurityLawByChapterNumAndSectionNum(chapterNum,sectionNum,pageSize,pageNum);
    }

    @RequestMapping("/getLawByItemNum")
    public SecurityLaw getLawByItemNum(int itemNum, int pageSize, int pageNum) {
        logger.info("SecuritySearchController,getLawByItemNum:{},{},{}",itemNum,pageSize,pageNum);
        return securityLawSearchService.findSecurityLawByItemNum(itemNum);
    }

    @RequestMapping("/getLawByQueryString")
    public Page<SecurityLaw> getLawByQueryString(String queryString, int pageSize, int pageNum) {
        logger.info("SecuritySearchController,getLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return securityLawSearchService.getSecurityLawByQueryString(queryString,pageSize,pageNum);
    }

//    @RequestMapping("/test")
//    public Page<TrafficLawNew> getTrafficLawNewByQueryString(String queryString, int pageSize, int pageNum) {
//        logger.info("TrafficSearchController,getTrafficLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
//        return trafficLawSearchService.getTrafficLawNewByQueryString(queryString,pageSize,pageNum);
//    }

    @RequestMapping("/getLawTable")
    public List<SecurityTableOutput> getLawTable()
    {
        return securityLawSearchService.getLawTable();
    }

}
