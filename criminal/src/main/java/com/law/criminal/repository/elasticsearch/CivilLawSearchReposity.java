package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.CivilLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CivilLawSearchReposity extends ElasticsearchRepository<CivilLaw, Long> {
    Page<CivilLaw> findCivilLawByChapterNum(int number, Pageable pageable);

    Page<CivilLaw> findCivilLawByChapterNumAndSectionNum(int number,int sectionNum,Pageable pageable);

    CivilLaw findCivilLawByItemNum(int itemNum);

    Page<CivilLaw> findCivilLawByPartNum(int partNum, Pageable pageable);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"part^2\",\"chapter^2\",\"section^2\",\"item\"]}}")
    Page<CivilLaw> getCivilLawByQueryString(String queryString, Pageable pageable);
}
