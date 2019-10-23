package com.law.criminal.service;

import com.law.criminal.comm.LawTableOutput;
import com.law.criminal.model.elasticsearch.CriminalLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CriminalLawSearchService {
    Page<CriminalLaw> findCriminalLawByChapterNum(int number, Integer pageSize, Integer pageNum);

    Page<CriminalLaw> findCriminalLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    Page<CriminalLaw> findCriminalLawByPartNumAndChapterNumAndSectionNum(int partNum, int number,int sectionNum, Integer pageSize, Integer pageNum);

    CriminalLaw findCriminalLawByItemNum(int itemNum);

    Page<CriminalLaw> findCriminalLawByPartNum(int partNum, Integer pageSize, Integer pageNum);

    List<LawTableOutput> getLawTable();

    Page<CriminalLaw> findCriminalLawByPartNumAndChapterNum(int partNum, int chapterNum , int pageSize, int pageNum);
}
