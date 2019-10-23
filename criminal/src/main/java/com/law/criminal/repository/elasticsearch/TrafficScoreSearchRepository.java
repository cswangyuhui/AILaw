package com.law.criminal.repository.elasticsearch;


import com.law.criminal.model.elasticsearch.TrafficScoreLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TrafficScoreSearchRepository extends ElasticsearchRepository<TrafficScoreLaw, Long> {
    Page<TrafficScoreLaw> findTrafficScoreLawByChapterNum(int number, Pageable pageable);
    TrafficScoreLaw findTrafficScoreLawByChapterNumAndAndItemNum(int chapterNum, int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"item\"]}}")
    Page<TrafficScoreLaw> getTrafficScoreLawByQueryString(String queryString, Pageable pageable);
}
