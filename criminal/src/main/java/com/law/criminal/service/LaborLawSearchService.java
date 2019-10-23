package com.law.criminal.service;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.LaborLaw;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LaborLawSearchService {
    Page<LaborLaw> findLaborLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum);

    LaborLaw findLaborLawByItemNum(int itemNum);

    Page<LaborLaw> findLaborLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    List<CommonTableOutput> getLaborLawTable();

}
