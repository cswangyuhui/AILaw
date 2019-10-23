package com.law.criminal.service.impl;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.FundLaw;
import com.law.criminal.repository.elasticsearch.FundLawSearchReposity;
import com.law.criminal.service.FundLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fundLawSearchService")
public class FundLawSearchServiceImpl implements FundLawSearchService {

    @Autowired
    FundLawSearchReposity fundLawSearchReposity;

    @Override
    public Page<FundLaw> findFundLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return fundLawSearchReposity.findFundLawByChapterNum(chapterNum,pageable);
    }

    @Override
    public FundLaw findFundLawByItemNum(int itemNum) {
        return fundLawSearchReposity.findFundLawByItemNum(itemNum);
    }

    @Override
    public Page<FundLaw> findFundLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return fundLawSearchReposity.getFundLawByQueryString(queryString,pageable);
    }

    @Override
    public List<CommonTableOutput> getFundLawTable() {
        List<CommonTableOutput> outputList = new ArrayList<>();
        CommonTableOutput cto1 = new CommonTableOutput(1,"总则");
        outputList.add(cto1);
        CommonTableOutput cto2 = new CommonTableOutput(2,"机构及其职责");
        outputList.add(cto2);
        CommonTableOutput cto3 = new CommonTableOutput(3,"缴存");
        outputList.add(cto3);
        CommonTableOutput cto4 = new CommonTableOutput(4,"提取和使用");
        outputList.add(cto4);
        CommonTableOutput cto5 = new CommonTableOutput(5,"监督");
        outputList.add(cto5);
        CommonTableOutput cto6 = new CommonTableOutput(6,"罚则");
        outputList.add(cto6);
        CommonTableOutput cto7 = new CommonTableOutput(7,"附则");
        outputList.add(cto7);
        return outputList;
    }
}
