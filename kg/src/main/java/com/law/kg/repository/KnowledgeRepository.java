package com.law.kg.repository;

import com.law.kg.model.Knowledge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KnowledgeRepository extends MongoRepository<Knowledge, String> {

    long countKnowledgeByBig(String big);
    Knowledge getByBigAndNumber(String big,Integer number);
}
