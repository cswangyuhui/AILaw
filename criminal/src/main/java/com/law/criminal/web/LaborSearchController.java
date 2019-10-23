package com.law.criminal.web;


import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.LaborLaw;
import com.law.criminal.service.LaborLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laborsearch")
public class LaborSearchController {

    @Autowired
    LaborLawSearchService laborLawSearchService;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getLaborLawByChapterNum")
    public Page<LaborLaw> getLaborLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("LaborSearchController,getLaborLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return laborLawSearchService.findLaborLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getLaborLawByQueryString")
    public Page<LaborLaw> getLaborLawByQueryString(String queryString, Integer pageSize, Integer pageNum){
        logger.info("LaborSearchController,getLaborLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return  laborLawSearchService.findLaborLawByQueryString(queryString, pageSize, pageNum);
    }
    @RequestMapping("/getLaborLawTable")
    public List<CommonTableOutput> getLaborLawTable(){
        return laborLawSearchService.getLaborLawTable();
    }
}
