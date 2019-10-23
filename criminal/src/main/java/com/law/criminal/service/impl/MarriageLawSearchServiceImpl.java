package com.law.criminal.service.impl;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.MarriageLaw;
import com.law.criminal.repository.elasticsearch.MarriageSearchReposity;
import com.law.criminal.service.MarriageLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("marriageLawSearchService")
public class MarriageLawSearchServiceImpl implements MarriageLawSearchService {

    @Autowired
    MarriageSearchReposity marriageLawSearchReposity;
    @Override
    public Page<MarriageLaw> findMarriageLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return marriageLawSearchReposity.findMarriageLawByChapterNum(chapterNum,pageable);
    }

    @Override
    public MarriageLaw findMarriageLawByItemNum(int itemNum) {
        return marriageLawSearchReposity.findMarriageLawByItemNum(itemNum);
    }

    @Override
    public Page<MarriageLaw> findMarriageLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return marriageLawSearchReposity.getMarriageLawByQueryString(queryString,pageable);
    }

    @Override
    public List<CommonTableOutput> getMarriageLawTable() {
        List<CommonTableOutput> outputList = new ArrayList<>();
        CommonTableOutput cto1 = new CommonTableOutput(1,"总则");
        outputList.add(cto1);
        CommonTableOutput cto2 = new CommonTableOutput(2,"结婚");
        outputList.add(cto2);
        CommonTableOutput cto3 = new CommonTableOutput(3,"家庭关系");
        outputList.add(cto3);
        CommonTableOutput cto4 = new CommonTableOutput(4,"离婚");
        outputList.add(cto4);
        CommonTableOutput cto5 = new CommonTableOutput(5,"救助措施与法律责任");
        outputList.add(cto5);
        CommonTableOutput cto6 = new CommonTableOutput(6,"附则");
        outputList.add(cto6);
        return outputList;
    }
}
