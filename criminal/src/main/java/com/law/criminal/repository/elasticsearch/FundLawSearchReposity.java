package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.FundLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface FundLawSearchReposity extends ElasticsearchRepository<FundLaw, Long> {
    Page<FundLaw> findFundLawByChapterNum(int number, Pageable pageable);
    FundLaw findFundLawByItemNum(int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"item\"]}}")
    Page<FundLaw> getFundLawByQueryString(String queryString, Pageable pageable);
}