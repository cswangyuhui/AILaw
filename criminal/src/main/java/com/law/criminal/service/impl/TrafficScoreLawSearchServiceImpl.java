package com.law.criminal.service.impl;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.TrafficScoreLaw;
import com.law.criminal.repository.elasticsearch.TrafficScoreSearchRepository;
import com.law.criminal.service.TrafficScoreLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("trafficScoreLawSearchService")
public class TrafficScoreLawSearchServiceImpl implements TrafficScoreLawSearchService {

    @Autowired
    TrafficScoreSearchRepository trafficScoreSearchRepository;

    @Override
    public Page<TrafficScoreLaw> findTrafficScoreLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return trafficScoreSearchRepository.findTrafficScoreLawByChapterNum(chapterNum,pageable);
    }

    @Override
    public TrafficScoreLaw findTrafficScoreLawByChapterNumAndItemNum(int chapterNum, int itemNum){
        return trafficScoreSearchRepository.findTrafficScoreLawByChapterNumAndAndItemNum(chapterNum, itemNum);
    }

    @Override
    public Page<TrafficScoreLaw> findTrafficScoreLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return trafficScoreSearchRepository.getTrafficScoreLawByQueryString(queryString, pageable);
    }

    @Override
    public List<CommonTableOutput> getTrafficScoreLawTable() {
        List<CommonTableOutput> outputList = new ArrayList<>();
        CommonTableOutput cto1 = new CommonTableOutput(1,"机动车驾驶人有下列违法行为之一，一次记12分");
        outputList.add(cto1);
        CommonTableOutput cto2 = new CommonTableOutput(2,"机动车驾驶人有下列违法行为之一，一次记6分");
        outputList.add(cto2);
        CommonTableOutput cto3 = new CommonTableOutput(3,"机动车驾驶人有下列违法行为之一，一次记3分");
        outputList.add(cto3);
        CommonTableOutput cto4 = new CommonTableOutput(4,"机动车驾驶人有下列违法行为之一，一次记2分");
        outputList.add(cto4);
        CommonTableOutput cto5 = new CommonTableOutput(5,"机动车驾驶人有下列违法行为之一，一次记1分");
        outputList.add(cto5);
        return outputList;
    }
}
