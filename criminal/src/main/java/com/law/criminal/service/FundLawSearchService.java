package com.law.criminal.service;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.FundLaw;
import com.law.criminal.model.elasticsearch.FundLaw;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FundLawSearchService {
    Page<FundLaw> findFundLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum);

    FundLaw findFundLawByItemNum(int itemNum);

    Page<FundLaw> findFundLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    List<CommonTableOutput> getFundLawTable();
}
