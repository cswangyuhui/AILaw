package com.law.criminal.web;

import com.law.criminal.comm.CivilTableOutput;
import com.law.criminal.model.elasticsearch.CivilLaw;
import com.law.criminal.service.CivilLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/civilsearch")
public class CivilSearchController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CivilLawSearchService civilLawSearchService;

    @RequestMapping("/getLawByChapterNum")
    public Page<CivilLaw> getLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("CivilSearchController,getLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return civilLawSearchService.findCivilLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getLawByQueryString")
    public Page<CivilLaw> getLawByQueryString(String queryString, int pageSize, int pageNum){
        logger.info("CivilSearchController,getLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return civilLawSearchService.getCivilLawByQueryString(queryString,pageSize,pageNum);
    }

    @RequestMapping("/getLawByPartNum")
    public Page<CivilLaw> getLawByPartNum(int partNum, int pageSize, int pageNum){
        logger.info("CivilSearchController,getLawByPartNum:{},{},{}",partNum,pageSize,pageNum);
        return civilLawSearchService.findCivilLawByPartNum(partNum,pageSize,pageNum);
    }

    @RequestMapping("/getLawByChapterNumAndSectionNum")
    public Page<CivilLaw> getLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, int pageSize, int pageNum){
        logger.info("CivilSearchController,getLawByChapterNumAndSectionNum:{},{},{},{}",chapterNum,sectionNum,pageSize,pageNum);
        return civilLawSearchService.findCivilLawByChapterNumAndSectionNum(chapterNum, sectionNum, pageSize, pageNum);
    }

    @RequestMapping("/getLawByItemNum")
    public CivilLaw getLawByItemNum(int itemNum){
        logger.info("CivilSearchController,getLawByItemNum:{}",itemNum);
        return civilLawSearchService.findCivilLawByItemNum(itemNum);
    }

    @RequestMapping("/getLawTable")
    public List<CivilTableOutput> getLawTable()
    {
        return civilLawSearchService.getLawTable();
    }

    @RequestMapping("/param_hello")
    public String hello(String name) {
        return "hello world, " +name;
    }


}
