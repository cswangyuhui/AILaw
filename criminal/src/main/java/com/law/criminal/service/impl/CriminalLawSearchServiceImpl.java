package com.law.criminal.service.impl;

import com.law.criminal.comm.LawTableOutput;
import com.law.criminal.model.elasticsearch.CriminalLaw;
import com.law.criminal.repository.elasticsearch.CriminaLawSearchReposity;
import com.law.criminal.repository.mysql.LawSearchRepository;
import com.law.criminal.service.CriminalLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("criminalLawSearchService")
public class CriminalLawSearchServiceImpl implements CriminalLawSearchService {

    @Autowired
    CriminaLawSearchReposity criminaLawSearchReposity;

    @Autowired
    LawSearchRepository lawSearchRepository;

    @Override
    public Page<CriminalLaw> findCriminalLawByChapterNum(int number, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return criminaLawSearchReposity.findCriminalLawByChapterNum(number,pageable);
    }

    @Override
    public Page<CriminalLaw> findCriminalLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Order> orders=new ArrayList< Order>();
        orders.add( new Order(Sort.Direction.DESC, "_score"));
        orders.add( new Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return criminaLawSearchReposity.getCriminalLawByQueryString(queryString,pageable);
    }

    @Override
    public Page<CriminalLaw> findCriminalLawByPartNumAndChapterNumAndSectionNum(int partNum, int number, int sectionNum,Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return criminaLawSearchReposity.findCriminalLawByPartNumAndChapterNumAndSectionNum(partNum,number,sectionNum,pageable);
    }

    @Override
    public CriminalLaw findCriminalLawByItemNum(int itemNum) {
        return criminaLawSearchReposity.findCriminalLawByItemNum(itemNum);
    }

    @Override
    public Page<CriminalLaw> findCriminalLawByPartNum(int partNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return criminaLawSearchReposity.findCriminalLawByPartNum(partNum,pageable);
    }

    @Override
    public List<LawTableOutput> getLawTable() {
        return lawSearchRepository.getLawTable();
    }

    @Override
    public Page<CriminalLaw> findCriminalLawByPartNumAndChapterNum(int partNum, int chapterNum, int pageSize, int pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return criminaLawSearchReposity.findCriminalLawByPartNumAndChapterNum(partNum,chapterNum,pageable);
    }
}
