package com.law.criminal.service.impl;

import com.law.criminal.comm.SecurityTableOutput;
import com.law.criminal.model.elasticsearch.SecurityLaw;
import com.law.criminal.repository.elasticsearch.SecuritylawSearchReposity;
import com.law.criminal.repository.mysql.LawSearchRepository;
import com.law.criminal.service.SecurityLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("securityLawSearchService")
public class SecurityLawSearchServiceImpl implements SecurityLawSearchService {

    @Autowired
    private SecuritylawSearchReposity securitylawSearchReposity;

    @Autowired
    LawSearchRepository lawSearchRepository;
    @Override
    public Page<SecurityLaw> findSecurityLawByChapterNum(int chapterNumber, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return securitylawSearchReposity.findSecurityLawByChapterNum(chapterNumber,pageable);
    }

    @Override
    public Page<SecurityLaw> findSecurityLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return securitylawSearchReposity.findSecurityLawByChapterNumAndSectionNum(chapterNum,sectionNum,pageable);
    }

    @Override
    public SecurityLaw findSecurityLawByItemNum(int itemNum) {
        return securitylawSearchReposity.findCivilLawByItemNum(itemNum);
    }

    @Override
    public Page<SecurityLaw> getSecurityLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return securitylawSearchReposity.getSecurityLawByQueryString(queryString,pageable);
    }

    @Override
    public List<SecurityTableOutput> getLawTable() {
        return lawSearchRepository.getSecurityTable();
    }
}
