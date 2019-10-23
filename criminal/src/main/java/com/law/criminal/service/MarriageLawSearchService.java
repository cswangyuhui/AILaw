package com.law.criminal.service;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.MarriageLaw;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MarriageLawSearchService {
    Page<MarriageLaw> findMarriageLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum);

    MarriageLaw findMarriageLawByItemNum(int itemNum);

    Page<MarriageLaw> findMarriageLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    List<CommonTableOutput> getMarriageLawTable();
}
