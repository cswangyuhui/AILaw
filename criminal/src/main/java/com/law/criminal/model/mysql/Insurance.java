package com.law.criminal.model.mysql;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="insurance_table")
public class Insurance {
    @EmbeddedId
    private InsuranceKey id;

    private String chapter;

    private Integer sectionnum;

    private String section;

    private String item;

    public Insurance() {
    }

    public Insurance(InsuranceKey id, String chapter, Integer sectionnum, String section, String item) {
        this.id = id;
        this.chapter = chapter;
        this.sectionnum = sectionnum;
        this.section = section;
        this.item = item;
    }

    public InsuranceKey getId() {
        return id;
    }

    public void setId(InsuranceKey id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getSectionnum() {
        return sectionnum;
    }

    public void setSectionnum(Integer sectionnum) {
        this.sectionnum = sectionnum;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", chapter='" + chapter + '\'' +
                ", sectionnum=" + sectionnum +
                ", section='" + section + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
