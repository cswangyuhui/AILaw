package com.law.kg.web;

import com.law.kg.comm.KnowledgeType;
import com.law.kg.comm.RandomUtil;
import com.law.kg.model.Knowledge;
import com.law.kg.repository.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kg")
public class HelloController {

    @Autowired
    KnowledgeRepository knowledgeRepository;

    private static List<String> names = new ArrayList<>();
    private static List<Long> counts = new ArrayList<>();

    @RequestMapping("/getKnowledges")
    public List<Knowledge> getKnowledges() {
        List<Knowledge> knowledges = new ArrayList<>();
        RandomUtil.randomSet(3,3,names.size(),1);
        for (int number : RandomUtil.set){
            number = number-1;
            String name = HelloController.names.get(number);
            long count = HelloController.counts.get(number);
            int nums = 0;
            if (count > Integer.MAX_VALUE) nums = Integer.MAX_VALUE;
            else if(count < Integer.MIN_VALUE) nums = Integer.MIN_VALUE;
            else nums = (int) count;
            //System.out.println(nums);
            if (nums == 0) nums = 1;
            int randomInt = RandomUtil.ran.nextInt(nums)+1;
            knowledges.add(knowledgeRepository.getByBigAndNumber(name, randomInt));
//            System.out.println("number "+number);
//            System.out.println("nums "+nums);
//            System.out.println("randomInt "+randomInt);
//            System.out.println("name "+name);
//            System.out.println(knowledgeRepository.getByBigAndNumber(name, randomInt));
        }
        //System.out.println("------");
        return knowledges;
    }

//    @RequestMapping("/getKnowledge")
//    public Knowledge getKnowledge() {
//        return knowledgeRepository.getByBigAndNumber(KnowledgeType.getName(1),1);
//    }

    @PostConstruct
    public void init(){
        int count = KnowledgeType.count();
        for(int i = 0; i < count; i++){
            String name = KnowledgeType.getName(i);
            names.add(name);
            counts.add(knowledgeRepository.countKnowledgeByBig(name));
//            System.out.println(name);
//            System.out.println(knowledgeRepository.countKnowledgeByBig(name));
        }
//        System.out.println(names.size());
//        System.out.println(counts.size());
    }

}