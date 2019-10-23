package com.law.criminal.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "traffic_law", type = "doc", shards = 5, replicas = 1)
public class TrafficLaw {
    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private int chapterNum;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String chapter;

    @Field(type = FieldType.Integer)
    private int sectionNum;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String section;

    @Field(type = FieldType.Integer)
    private int itemNum;

    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TrafficLaw(String id, int chapterNum, String chapter, int sectionNum, String section, int itemNum, String item) {
        this.id = id;
        this.chapterNum = chapterNum;
        this.chapter = chapter;
        this.sectionNum = sectionNum;
        this.section = section;
        this.itemNum = itemNum;
        this.item = item;
    }

    public TrafficLaw() {
    }

    @Override
    public String toString() {
        return "TrafficLaw{" +
                "id='" + id + '\'' +
                ", chapterNum=" + chapterNum +
                ", chapter='" + chapter + '\'' +
                ", sectionNum=" + sectionNum +
                ", section='" + section + '\'' +
                ", itemNum=" + itemNum +
                ", item='" + item + '\'' +
                '}';
    }
}
