package com.law.kg.repository;


import com.law.kg.model.elasticsearch.QAData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface QADataSearchReposity extends ElasticsearchRepository<QAData,String> {

    List<QAData> findByQuestionMatches(String question, Pageable pageable);

}
