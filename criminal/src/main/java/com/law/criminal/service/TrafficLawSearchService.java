package com.law.criminal.service;

import com.law.criminal.comm.TrafficTableOutput;
import com.law.criminal.model.elasticsearch.TrafficLaw;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrafficLawSearchService {
    Page<TrafficLaw> findTrafficLawByChapterNum(int chapterNumber, Integer pageSize, Integer pageNum);
    Page<TrafficLaw> findTrafficLawByChapterNumAndSectionNum(int chapterNum, int sectionNum, Integer pageSize, Integer pageNum);
    TrafficLaw findTrafficLawByItemNum(int itemNum);
    Page<TrafficLaw> getTrafficLawByQueryString(String queryString,Integer pageSize, Integer pageNum);

    List<TrafficTableOutput> getLawTable();
}
