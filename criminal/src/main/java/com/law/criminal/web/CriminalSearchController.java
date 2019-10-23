package com.law.criminal.web;

import com.law.criminal.comm.LawTableOutput;
import com.law.criminal.model.elasticsearch.CriminalLaw;
import com.law.criminal.service.CriminalLawSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/criminalsearch")
public class CriminalSearchController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CriminalLawSearchService criminalLawSearchService;

    @RequestMapping("/getLawByChapterNum")
    public Page<CriminalLaw> getLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("HelloController,getLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        return criminalLawSearchService.findCriminalLawByChapterNum(chapterNum,pageSize,pageNum);
    }

    @RequestMapping("/getLawByQueryString")
    public Page<CriminalLaw> getLawByQueryString(String queryString, int pageSize, int pageNum){
        logger.info("HelloController,getLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        return criminalLawSearchService.findCriminalLawByQueryString(queryString,pageSize,pageNum);
    }

    @RequestMapping("/getLawByPartNum")
    public Page<CriminalLaw> getLawByPartNum(int partNum, int pageSize, int pageNum){
        logger.info("HelloController,getLawByPartNum:{},{},{}",partNum,pageSize,pageNum);
        return criminalLawSearchService.findCriminalLawByPartNum(partNum,pageSize,pageNum);
    }

    @RequestMapping("/getLawByPartNumAndChapterNumAndSectionNum")
    public Page<CriminalLaw> getLawByPartNumAndChapterNumAndSectionNum(int partNum, int chapterNum, int sectionNum, int pageSize, int pageNum){
        logger.info("HelloController,getLawByChapterNumAndSectionNum:{},{},{},{},{}",partNum,chapterNum,sectionNum,pageSize,pageNum);
        return criminalLawSearchService.findCriminalLawByPartNumAndChapterNumAndSectionNum(partNum, chapterNum, sectionNum, pageSize, pageNum);
    }

    @RequestMapping("/getLawByPartNumAndChapterNum")
    public Page<CriminalLaw> getLawByPartNumAndChapterNum(int partNum, int chapterNum, int pageSize, int pageNum){
        logger.info("HelloController,getLawByPartNumAndChapterNum:{},{}",partNum,chapterNum);
        return criminalLawSearchService.findCriminalLawByPartNumAndChapterNum(partNum, chapterNum, pageSize, pageNum);
    }

    @RequestMapping("/getLawByItemNum")
    public CriminalLaw getLawByItemNum(int itemNum){
        logger.info("HelloController,getLawByItemNum:{}",itemNum);
        return criminalLawSearchService.findCriminalLawByItemNum(itemNum);
    }

    @RequestMapping("/getLawTable")
    public List<LawTableOutput> getLawTable()
    {
        return criminalLawSearchService.getLawTable();
    }

    @RequestMapping("/param_hello")
    public String hello(String name) {
        return "hello world, " +name;
    }

}
