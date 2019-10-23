package com.law.criminal.service.impl;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.LaborLaw;
import com.law.criminal.repository.elasticsearch.LaborLawSearchReposity;
import com.law.criminal.service.LaborLawSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("laborLawSearchService")
public class LaborLawSearchServiceImpl implements LaborLawSearchService {

    @Autowired
    LaborLawSearchReposity laborLawSearchReposity;


    @Override
    public Page<LaborLaw> findLaborLawByChapterNum(int chapterNum, Integer pageSize, Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return laborLawSearchReposity.findLaborLawByChapterNum(chapterNum,pageable);
    }

    @Override
    public LaborLaw findLaborLawByItemNum(int itemNum) {
        return laborLawSearchReposity.findLaborLawByItemNum(itemNum);
    }

    @Override
    public Page<LaborLaw> findLaborLawByQueryString(String queryString, Integer pageSize, Integer pageNum) {
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return laborLawSearchReposity.getLaborLawByQueryString(queryString,pageable);
    }

    @Override
    public List<CommonTableOutput> getLaborLawTable() {

        List<CommonTableOutput> outputList = new ArrayList<>();
        CommonTableOutput cto1 = new CommonTableOutput(1,"总则");
        outputList.add(cto1);
        CommonTableOutput cto2 = new CommonTableOutput(2,"促进就业");
        outputList.add(cto2);
        CommonTableOutput cto3 = new CommonTableOutput(3,"劳动合同和集体合同");
        outputList.add(cto3);
        CommonTableOutput cto4 = new CommonTableOutput(4,"工作时间和休息休假");
        outputList.add(cto4);
        CommonTableOutput cto5 = new CommonTableOutput(5,"工资");
        outputList.add(cto5);
        CommonTableOutput cto6 = new CommonTableOutput(6,"劳动安全卫生");
        outputList.add(cto6);
        CommonTableOutput cto7 = new CommonTableOutput(7,"女职工和未成年工特殊保护");
        outputList.add(cto7);
        CommonTableOutput cto8 = new CommonTableOutput(8,"职业培训");
        outputList.add(cto8);
        CommonTableOutput cto9 = new CommonTableOutput(9,"社会保险和福利");
        outputList.add(cto9);
        CommonTableOutput cto10 = new CommonTableOutput(10,"劳动争议");
        outputList.add(cto10);
        CommonTableOutput cto11 = new CommonTableOutput(11,"监督检查");
        outputList.add(cto11);
        CommonTableOutput cto12 = new CommonTableOutput(12,"法律责任");
        outputList.add(cto12);
        CommonTableOutput cto13 = new CommonTableOutput(13,"附则");
        outputList.add(cto13);
        return outputList;
    }
}
