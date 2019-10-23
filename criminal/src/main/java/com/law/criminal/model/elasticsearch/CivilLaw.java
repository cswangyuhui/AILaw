package com.law.criminal.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "civil_law", type = "doc", shards = 5, replicas = 1)
public class CivilLaw {
    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private int partNum;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String part;

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

    public CivilLaw(String id, int partNum, String part, int chapterNum, String chapter, int sectionNum, String section, int itemNum, String item) {
        this.id = id;
        this.partNum = partNum;
        this.part = part;
        this.chapterNum = chapterNum;
        this.chapter = chapter;
        this.sectionNum = sectionNum;
        this.section = section;
        this.itemNum = itemNum;
        this.item = item;
    }

    public CivilLaw() {
    }

    @Override
    public String toString() {
        return "CivilLaw{" +
                "id='" + id + '\'' +
                ", partNum=" + partNum +
                ", part='" + part + '\'' +
                ", chapterNum=" + chapterNum +
                ", chapter='" + chapter + '\'' +
                ", sectionNum=" + sectionNum +
                ", section='" + section + '\'' +
                ", itemNum=" + itemNum +
                ", item='" + item + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPartNum() {
        return partNum;
    }

    public void setPartNum(int partNum) {
        this.partNum = partNum;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
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
}
