package com.law.criminal.repository.elasticsearch;

import com.law.criminal.model.elasticsearch.ContractLaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ContractLawSearchRepository extends ElasticsearchRepository<ContractLaw, Long> {
    ContractLaw findContractLawByItemNum(int itemNum);

    Page<ContractLaw> findContractLawByChapterNum(int number, Pageable pageable);

    Page<ContractLaw> findContractLawByChapterNumAndSectionNum(int number,int sectionNum,Pageable pageable);

    @Query("{ \"multi_match\": {\"query\": \"?0\",\"fields\": [\"chapter^2\",\"section^2\",\"item\"]}}")
    Page<ContractLaw> getContractLawByQueryString(String queryString, Pageable pageable);
}
