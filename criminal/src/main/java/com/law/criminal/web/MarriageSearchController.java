package com.law.criminal.web;


import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.MarriageLaw;
import com.law.criminal.service.MarriageLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marriagesearch")
public class MarriageSearchController {
    @Autowired
    MarriageLawSearchService marriageLawSearchService;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getMarriageLawByChapterNum")
    public Page<MarriageLaw> getMarriageLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("MarriageSearchController,getMarriageLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return marriageLawSearchService.findMarriageLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getMarriageLawByQueryString")
    public Page<MarriageLaw> getMarriageLawByQueryString(String queryString, Integer pageSize, Integer pageNum){
        logger.info("MarriageSearchController,getMarriageLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return  marriageLawSearchService.findMarriageLawByQueryString(queryString, pageSize, pageNum);
    }
    @RequestMapping("/getMarriageLawTable")
    public List<CommonTableOutput> getMarriageLawTable(){
        return marriageLawSearchService.getMarriageLawTable();
    }
}
