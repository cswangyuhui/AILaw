package com.law.criminal.service;

import com.law.criminal.comm.SecurityTableOutput;
import com.law.criminal.model.elasticsearch.SecurityLaw;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SecurityLawSearchService {
    Page<SecurityLaw> findSecurityLawByChapterNum(int chapterNumber, Integer pageSize, Integer pageNum);
    Page<SecurityLaw> findSecurityLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, Integer pageSize, Integer pageNum);
    SecurityLaw findSecurityLawByItemNum(int itemNum);
    Page<SecurityLaw> getSecurityLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    List<SecurityTableOutput> getLawTable();
}
