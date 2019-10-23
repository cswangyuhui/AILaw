package com.law.criminal.service.impl;

import com.law.criminal.model.elasticsearch.QAData;
import com.law.criminal.repository.elasticsearch.QADataSearchReposity;
import com.law.criminal.service.QASearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("qaSearchService")
public class QASearchServiceImpl implements QASearchService {
    @Autowired
    QADataSearchReposity qaDataSearchReposity;

    @Override
    public List<QAData> findQADataByQuestion(String question) {
        Pageable pageable = PageRequest.of(0,10);
        return qaDataSearchReposity.findByQuestionMatches(question,pageable);
    }
}
