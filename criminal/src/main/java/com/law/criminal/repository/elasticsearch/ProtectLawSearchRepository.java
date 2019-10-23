package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.ProtectLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProtectLawSearchRepository extends ElasticsearchRepository<ProtectLaw, Long> {
    ProtectLaw findProtectLawByItemNum(int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"itemField^2\",\"item\"]}}")
    Page<ProtectLaw> getProtectLawByQueryString(String queryString, Pageable pageable);
}
