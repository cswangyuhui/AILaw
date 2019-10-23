package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.MarriageLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MarriageSearchReposity extends ElasticsearchRepository<MarriageLaw, Long> {
    Page<MarriageLaw> findMarriageLawByChapterNum(int number, Pageable pageable);

    MarriageLaw findMarriageLawByItemNum(int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"itemField^2\",\"item\"]}}")
    Page<MarriageLaw> getMarriageLawByQueryString(String queryString, Pageable pageable);
}
