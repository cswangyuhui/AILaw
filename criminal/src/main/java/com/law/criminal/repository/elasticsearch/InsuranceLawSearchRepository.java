package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.InsuranceLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InsuranceLawSearchRepository extends ElasticsearchRepository<InsuranceLaw, Long> {
    InsuranceLaw findInsuranceLawByItemNum(int itemNum);

    Page<InsuranceLaw> findInsuranceLawByChapterNum(int number, Pageable pageable);

    Page<InsuranceLaw> findInsuranceLawByChapterNumAndSectionNum(int number,int sectionNum,Pageable pageable);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"section^2\",\"item\"]}}")
    Page<InsuranceLaw> getInsuranceLawByQueryString(String queryString, Pageable pageable);
}
