package com.law.criminal.web;


import com.law.criminal.comm.TrafficTableOutput;
import com.law.criminal.model.elasticsearch.InsuranceLaw;
import com.law.criminal.repository.elasticsearch.InsuranceLawSearchRepository;
import com.law.criminal.repository.mysql.LawSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/insurancesearch")
public class InsuranceSearchController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InsuranceLawSearchRepository insuranceLawSearchRepository;

    @Autowired
    LawSearchRepository lawSearchRepository;

    @RequestMapping("/getInsuranceLawByChapterNum")
    public Page<InsuranceLaw> getInsuranceLawByChapterNum(int chapterNum, int pageSize, int pageNum) {
        logger.info("InsuranceSearchController,getInsuranceByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return insuranceLawSearchRepository.findInsuranceLawByChapterNum(chapterNum,pageable);
    }

    @RequestMapping("/getInsuranceLawByChapterNumAndSectionNum")
    public Page<InsuranceLaw> getInsuranceLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, int pageSize, int pageNum) {
        logger.info("InsuranceSearchController,getInsuranceLawByChapterNumAndSectionNum:{},{},{},{}",chapterNum,sectionNum,pageSize,pageNum);
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return insuranceLawSearchRepository.findInsuranceLawByChapterNumAndSectionNum(chapterNum,sectionNum,pageable);
    }


    @RequestMapping("/getInsuranceLawByQueryString")
    public Page<InsuranceLaw> getInsuranceLawByQueryString(String queryString, int pageSize, int pageNum) {
        logger.info("InsuranceSearchController,getInsuranceLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return insuranceLawSearchRepository.getInsuranceLawByQueryString(queryString,pageable);
    }

//    @RequestMapping("/test")
//    public Page<TrafficLawNew> getTrafficLawNewByQueryString(String queryString, int pageSize, int pageNum) {
//        logger.info("TrafficSearchController,getTrafficLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
//        return trafficLawSearchService.getTrafficLawNewByQueryString(queryString,pageSize,pageNum);
//    }

    @RequestMapping("/getLawTable")
    public List<TrafficTableOutput> getLawTable()
    {
        return lawSearchRepository.getInsuranceLawTable();
    }
}
