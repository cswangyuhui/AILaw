package com.law.criminal.service.impl;

import com.law.criminal.comm.TrafficTableOutput;
import com.law.criminal.model.elasticsearch.TrafficLaw;
import com.law.criminal.repository.elasticsearch.TrafficLawSearchReposity;
import com.law.criminal.repository.mysql.LawSearchRepository;
import com.law.criminal.service.TrafficLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("trafficLawSearchService")
public class TrafficLawSearchServiceImpl implements TrafficLawSearchService {

    @Autowired
    private TrafficLawSearchReposity trafficLawSearchReposity;

    @Autowired
    LawSearchRepository lawSearchRepository;


    @Override
    public Page<TrafficLaw> findTrafficLawByChapterNum(int chapterNumber,Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return trafficLawSearchReposity.findTrafficLawByChapterNum(chapterNumber,pageable);
    }

    @Override
    public Page<TrafficLaw> findTrafficLawByChapterNumAndSectionNum(int chapterNum, int sectionNum,Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return trafficLawSearchReposity.findTrafficLawByChapterNumAndSectionNum(chapterNum,sectionNum,pageable);
    }

    @Override
    public TrafficLaw findTrafficLawByItemNum(int itemNum) {
        return trafficLawSearchReposity.findTrafficLawByItemNum(itemNum);
    }

    @Override
    public Page<TrafficLaw> getTrafficLawByQueryString(String queryString,Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return trafficLawSearchReposity.getTrafficLawByQueryString(queryString,pageable);
    }

    @Override
    public List<TrafficTableOutput> getLawTable() {
        return lawSearchRepository.getTrafficTable();
    }
}
