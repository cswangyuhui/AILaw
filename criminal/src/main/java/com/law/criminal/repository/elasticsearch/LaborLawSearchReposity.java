package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.LaborLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LaborLawSearchReposity extends ElasticsearchRepository<LaborLaw, Long> {
    Page<LaborLaw> findLaborLawByChapterNum(int number, Pageable pageable);
    LaborLaw findLaborLawByItemNum(int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"item\"]}}")
    Page<LaborLaw> getLaborLawByQueryString(String queryString, Pageable pageable);
}
