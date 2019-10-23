package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.ConsumerLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ConsumerLawSearchRepository extends ElasticsearchRepository<ConsumerLaw, Long> {
    Page<ConsumerLaw> findConsumerLawByChapterNum(int number, Pageable pageable);

    ConsumerLaw findConsumerLawByItemNum(int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"item\"]}}")
    Page<ConsumerLaw> getConsumerLawByQueryString(String queryString, Pageable pageable);
}
