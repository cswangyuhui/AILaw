package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.SecurityLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SecuritylawSearchReposity extends ElasticsearchRepository<SecurityLaw, Long> {
    Page<SecurityLaw> findSecurityLawByChapterNum(int number, Pageable pageable);

    Page<SecurityLaw> findSecurityLawByChapterNumAndSectionNum(int number,int sectionNum,Pageable pageable);

    SecurityLaw findCivilLawByItemNum(int itemNum);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"section^2\",\"item\"]}}")
    Page<SecurityLaw> getSecurityLawByQueryString(String queryString, Pageable pageable);
}
