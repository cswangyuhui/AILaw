package com.law.criminal.service;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.TrafficScoreLaw;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrafficScoreLawSearchService {
    Page<TrafficScoreLaw> findTrafficScoreLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum);

    TrafficScoreLaw findTrafficScoreLawByChapterNumAndItemNum(int chapterNum, int itemNum);

    Page<TrafficScoreLaw> findTrafficScoreLawByQueryString(String queryString, Integer pageSize, Integer pageNum);

    List<CommonTableOutput> getTrafficScoreLawTable();

}
