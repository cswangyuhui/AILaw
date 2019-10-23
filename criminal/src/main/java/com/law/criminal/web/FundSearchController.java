package com.law.criminal.web;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.FundLaw;
import com.law.criminal.service.FundLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fundsearch")
public class FundSearchController {
    @Autowired
    FundLawSearchService fundLawSearchService;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getFundLawByChapterNum")
    public Page<FundLaw> getFundLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("FundSearchController,getFundLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return fundLawSearchService.findFundLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getFundLawByQueryString")
    public Page<FundLaw> getFundLawByQueryString(String queryString, Integer pageSize, Integer pageNum){
        logger.info("FundSearchController,getFundLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return  fundLawSearchService.findFundLawByQueryString(queryString, pageSize, pageNum);
    }
    @RequestMapping("/getLaborLawTable")
    public List<CommonTableOutput> getFundLawTable(){
        return fundLawSearchService.getFundLawTable();
    }
}
