package com.law.criminal.web;

import com.law.criminal.comm.CommonTableOutput;
import com.law.criminal.model.elasticsearch.ConsumerLaw;
import com.law.criminal.model.elasticsearch.FundLaw;
import com.law.criminal.repository.elasticsearch.ConsumerLawSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumersearch")
public class ConsumerSearchController {
    @Autowired
    ConsumerLawSearchRepository consumerLawSearchRepository;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getConsumerLawByChapterNum")
    public Page<ConsumerLaw> getConsumerLawByChapterNum(int chapterNum, int pageSize, int pageNum){
        logger.info("ConsumerSearchController,getFundLawByChapterNum:{},{},{}",chapterNum,pageSize,pageNum);
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(Sort.Direction.ASC,"itemNum"));
        return consumerLawSearchRepository.findConsumerLawByChapterNum(chapterNum,pageable);
    }

    @RequestMapping("/getConsumerLawByQueryString")
    public Page<ConsumerLaw> getConsumerLawByQueryString(String queryString, Integer pageSize, Integer pageNum){
        logger.info("ConsumerSearchController,getFundLawByQueryString:{},{},{}",queryString,pageSize,pageNum);
        List<Sort.Order> orders=new ArrayList< Sort.Order>();
        orders.add( new Sort.Order(Sort.Direction.DESC, "_score"));
        orders.add( new Sort.Order(Sort.Direction.ASC, "itemNum"));
        Pageable pageable = PageRequest.of(pageNum,pageSize,new Sort(orders));
        return  consumerLawSearchRepository.getConsumerLawByQueryString(queryString, pageable);
    }
    @RequestMapping("/getConsumerLawTable")
    public List<CommonTableOutput> getFundLawTable(){
        List<CommonTableOutput> outputList = new ArrayList<>();
        CommonTableOutput cto1 = new CommonTableOutput(1,"总则");
        outputList.add(cto1);
        CommonTableOutput cto2 = new CommonTableOutput(2,"消费者的权利");
        outputList.add(cto2);
        CommonTableOutput cto3 = new CommonTableOutput(3,"经营者的义务");
        outputList.add(cto3);
        CommonTableOutput cto4 = new CommonTableOutput(4,"国家对消费者合法权益的保护");
        outputList.add(cto4);
        CommonTableOutput cto5 = new CommonTableOutput(5,"消费者组织");
        outputList.add(cto5);
        CommonTableOutput cto6 = new CommonTableOutput(6,"争议的解决");
        outputList.add(cto6);
        CommonTableOutput cto7 = new CommonTableOutput(7,"法律责任");
        outputList.add(cto7);
        CommonTableOutput cto8 = new CommonTableOutput(8,"附则");
        outputList.add(cto8);
        return outputList;
    }

}
