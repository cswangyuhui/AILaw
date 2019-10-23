package com.law.criminal.service;

import com.law.criminal.model.elasticsearch.QAData;

import java.util.List;

public interface QASearchService {
    List<QAData> findQADataByQuestion(String question);
}
