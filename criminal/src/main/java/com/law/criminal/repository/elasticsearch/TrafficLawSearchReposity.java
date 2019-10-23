package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.TrafficLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TrafficLawSearchReposity extends ElasticsearchRepository<TrafficLaw, Long> {
    Page<TrafficLaw> findTrafficLawByChapterNum(int chapterNumber, Pageable pageable);
    Page<TrafficLaw> findTrafficLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, Pageable pageable);
    TrafficLaw findTrafficLawByItemNum(int itemNum);
    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"section^2\",\"item\"]}}")
    Page<TrafficLaw> getTrafficLawByQueryString(String queryString, Pageable pageable);

}
