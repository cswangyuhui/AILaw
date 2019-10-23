package com.law.criminal.service.impl;

import com.law.criminal.comm.CivilTableOutput;
import com.law.criminal.model.elasticsearch.CivilLaw;
import com.law.criminal.repository.elasticsearch.CivilLawSearchReposity;
import com.law.criminal.repository.mysql.LawSearchRepository;
import com.law.criminal.service.CivilLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("civilLawSearchService")
public class CivilLawSearchServiceImpl implements CivilLawSearchService {

    @Autowired
    CivilLawSearchReposity civilLawSearchReposity;

    @Autowired
    LawSearchRepository lawSearchRepository;

    @Override
    public Page<CivilLaw> findCivilLawByChapterNum(int number, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return civilLawSearchReposity.findCivilLawByChapterNum(number,pageable);
    }

    @Override
    public Page<CivilLaw> findCivilLawByChapterNumAndSectionNum(int number, int sectionNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return civilLawSearchReposity.findCivilLawByChapterNumAndSectionNum(number,sectionNum,pageable);
    }

    @Override
    public CivilLaw findCivilLawByItemNum(int itemNum) {
        return civilLawSearchReposity.findCivilLawByItemNum(itemNum);
    }

    @Override
    public Page<CivilLaw> findCivilLawByPartNum(int partNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return civilLawSearchReposity.findCivilLawByPartNum(partNum,pageable);
    }

    @Override
    public Page<CivilLaw> getCivilLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return civilLawSearchReposity.getCivilLawByQueryString(queryString,pageable);
    }

    @Override
    public List<CivilTableOutput> getLawTable() {
        return lawSearchRepository.getCivilTable();
    }
}
