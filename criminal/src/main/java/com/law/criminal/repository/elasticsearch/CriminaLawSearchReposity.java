package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.CriminalLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface CriminaLawSearchReposity extends ElasticsearchRepository<CriminalLaw, Long> {

    Page<CriminalLaw> findCriminalLawByChapterNum(int number,Pageable pageable);

    Page<CriminalLaw> findCriminalLawByPartNumAndChapterNumAndSectionNum(int partNum, int number,int sectionNum,Pageable pageable);

    CriminalLaw findCriminalLawByItemNum(int itemNum);

    Page<CriminalLaw> findCriminalLawByPartNum(int partNum, Pageable pageable);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"part^2\",\"chapter^2\",\"section^2\",\"itemField^2\",\"item\"]}}")
    Page<CriminalLaw> getCriminalLawByQueryString(String queryString, Pageable pageable);

    Page<CriminalLaw> findCriminalLawByPartNumAndChapterNum(int partNum, int chapterNum, Pageable pageable);
}
