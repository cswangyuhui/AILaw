package com.law.criminal.model.elasticsearch;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "marriage_law", type = "doc", shards = 5, replicas = 1)
public class MarriageLaw {
    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private int chapterNum;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String chapter;

    @Field(type = FieldType.Integer)
    private int itemNum;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String itemField;

    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String item;

    public MarriageLaw(String id, int chapterNum, String chapter, int itemNum, String itemField, String item) {
        this.id = id;
        this.chapterNum = chapterNum;
        this.chapter = chapter;
        this.itemNum = itemNum;
        this.itemField = itemField;
        this.item = item;
    }

    public MarriageLaw() {
    }

    @Override
    public String toString() {
        return "MarriageLaw{" +
                "id='" + id + '\'' +
                ", chapterNum=" + chapterNum +
                ", chapter='" + chapter + '\'' +
                ", itemNum=" + itemNum +
                ", itemField='" + itemField + '\'' +
                ", item='" + item + '\'' +
                '}';
    }

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

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemField() {
        return itemField;
    }

    public void setItemField(String itemField) {
        this.itemField = itemField;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
