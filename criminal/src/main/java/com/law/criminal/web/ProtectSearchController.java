package com.law.criminal.web;


import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.ProtectLaw;
import com.law.criminal.repository.elasticsearch.ProtectLawSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/protectsearch")
public class ProtectSearchController {
    @Autowired
    ProtectLawSearchRepository protectLawSearchRepository;

    @RequestMapping("/getProtectLawByItemNum")
    public ProtectLaw getProtectLawByItemNum(Integer itemNum){
        return protectLawSearchRepository.findProtectLawByItemNum(itemNum);
    }

    @RequestMapping("/getProtectLawByQueryString")
    public Page<ProtectLaw> getProtectLawByQueryString(String queryString, Integer pageSize, Integer pageNum){
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return protectLawSearchRepository.getProtectLawByQueryString(queryString,pageable);
    }
    @RequestMapping("/getLawTable")
    public List<CommonTableOutput> getLawTable(){
        List<CommonTableOutput> outputList = new ArrayList<>();
        CommonTableOutput cto1 = new CommonTableOutput(1,"就业年龄");
        outputList.add(cto1);
        CommonTableOutput cto2 = new CommonTableOutput(2,"劳动者应享有的权利");
        outputList.add(cto2);
        CommonTableOutput cto3 = new CommonTableOutput(3,"劳动者应履行的义务");
        outputList.add(cto3);
        CommonTableOutput cto4 = new CommonTableOutput(4,"未成年工和女职工的特殊保护");
        outputList.add(cto4);
        CommonTableOutput cto5 = new CommonTableOutput(5,"确定劳动者最低工资标准的参考因素");
        outputList.add(cto5);
        CommonTableOutput cto6 = new CommonTableOutput(6,"对延长工作时间而支付工资报酬标准的规定");
        outputList.add(cto6);
        CommonTableOutput cto7 = new CommonTableOutput(7,"有关职工伤亡和职业病的确定及处理规定处理原则");
        outputList.add(cto7);
        CommonTableOutput cto8 = new CommonTableOutput(8,"劳动者享受社会保险的条件");
        outputList.add(cto8);
        CommonTableOutput cto9 = new CommonTableOutput(9,"哪种情况下，劳动者加班加点不受劳动法规定的限制");
        outputList.add(cto9);
        CommonTableOutput cto10 = new CommonTableOutput(10,"劳动试用期可以随意决定吗");
        outputList.add(cto10);
        CommonTableOutput cto11 = new CommonTableOutput(11,"在哪些情况下，可以辞退劳动者");
        outputList.add(cto11);
        CommonTableOutput cto12 = new CommonTableOutput(12,"在哪些情况下，用人单位辞退劳动者须提前1个月书面通知劳动者，且还要依法给予劳动者以经济补偿的。");
        outputList.add(cto12);
        CommonTableOutput cto13 = new CommonTableOutput(13,"哪些情况下，辞退劳动者是非法的");
        outputList.add(cto13);
        CommonTableOutput cto14 = new CommonTableOutput(14,"怎样办理停薪留职手续");
        outputList.add(cto14);
        CommonTableOutput cto15 = new CommonTableOutput(15,"签订劳动合同时应注意的问题");
        outputList.add(cto15);
        CommonTableOutput cto16 = new CommonTableOutput(16,"在哪种情况下，劳动者可以随时通知用人单位解除劳动合同");
        outputList.add(cto16);
        CommonTableOutput cto17 = new CommonTableOutput(17,"劳动争议的类型");
        outputList.add(cto17);
        CommonTableOutput cto18 = new CommonTableOutput(18,"遇到劳动争议时该咋办");
        outputList.add(cto18);
        return outputList;
    }
}
