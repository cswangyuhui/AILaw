package com.law.criminal.service;

import com.law.criminal.comm.CivilTableOutput;
import com.law.criminal.model.elasticsearch.CivilLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CivilLawSearchService {
    Page<CivilLaw> findCivilLawByChapterNum(int number, Integer pageSize, Integer pageNum);

    Page<CivilLaw> findCivilLawByChapterNumAndSectionNum(int number,int sectionNum,Integer pageSize, Integer pageNum);

    CivilLaw findCivilLawByItemNum(int itemNum);

    Page<CivilLaw> findCivilLawByPartNum(int partNum, Integer pageSize, Integer pageNum);

    Page<CivilLaw> getCivilLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    List<CivilTableOutput> getLawTable();
}
