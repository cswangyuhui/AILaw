package com.law.criminal.model.mysql;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="civil_table")
public class Civil {

    @EmbeddedId
    private CivilKey id;

    @Column(name="part")
    private String part;

    @Column(name="chapter")
    private String chapter;

    @Column(name="section")
    private String section;

    @Column(name="item")
    private String item;

    public Civil(CivilKey id, String part, String chapter, String section, String item) {
        this.id = id;
        this.part = part;
        this.chapter = chapter;
        this.section = section;
        this.item = item;
    }

    public Civil() {
    }

    @Override
    public String toString() {
        return "Civil{" +
                "id=" + id +
                ", part='" + part + '\'' +
                ", chapter='" + chapter + '\'' +
                ", section='" + section + '\'' +
                ", item='" + item + '\'' +
                '}';
    }

    public CivilKey getId() {
        return id;
    }

    public void setId(CivilKey id) {
        this.id = id;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
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
}
