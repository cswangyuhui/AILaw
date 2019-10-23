package com.law.criminal.repository.mysql;

import com.law.criminal.comm.CivilTableOutput;
import com.law.criminal.comm.LawTableOutput;
import com.law.criminal.comm.SecurityTableOutput;
import com.law.criminal.comm.TrafficTableOutput;
import com.law.criminal.model.mysql.Law;
import com.law.criminal.model.mysql.LawKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawSearchRepository extends JpaRepository<Law,LawKey> {

    @Query(value = "select distinct new com.law.criminal.comm.LawTableOutput(l.id.partnum,l.part,l.id.chapternum,l.chapter,l.id.sectionnum,l.section) from Law l")
    public List<LawTableOutput> getLawTable();

    @Query(value = "select distinct new com.law.criminal.comm.TrafficTableOutput(l.id.chapternum,l.chapter,l.sectionnum,l.section) from Traffic l")
    public List<TrafficTableOutput> getTrafficTable();

    @Query(value = "select distinct new com.law.criminal.comm.CivilTableOutput(l.id.partnum, l.part, l.id.chapternum,l.chapter,l.id.sectionnum,l.section) from Civil l")
    public List<CivilTableOutput> getCivilTable();

    @Query(value = "select distinct new com.law.criminal.comm.SecurityTableOutput(l.id.chapternum,l.chapter,l.sectionnum,l.section) from Security l")
    public List<SecurityTableOutput> getSecurityTable();

    @Query(value = "select distinct new com.law.criminal.comm.TrafficTableOutput(l.id.chapternum,l.chapter,l.sectionnum,l.section) from Insurance l")
    public List<TrafficTableOutput> getInsuranceLawTable();

    @Query(value = "select distinct new com.law.criminal.comm.TrafficTableOutput(l.id.chapternum,l.chapter,l.sectionnum,l.section) from Contract l")
    public List<TrafficTableOutput> getContractLawTable();

}
