package com.law.criminal.model.mysql;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="law_table")
public class Law{
    @EmbeddedId
    private LawKey id;

    @Column(name="part")
    private String part;

    @Column(name="chapter")
    private String chapter;

    @Column(name="section")
    private String section;

    @Column(name="itemfield")
    private String itemfield;

    @Column(name="item")
    private String item;

    public Law() {
    }

    public Law(LawKey id, String part, String chapter, String section, String itemfield, String item) {
        this.id = id;
        this.part = part;
        this.chapter = chapter;
        this.section = section;
        this.itemfield = itemfield;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Law{" +
                "id=" + id +
                ", part='" + part + '\'' +
                ", chapter='" + chapter + '\'' +
                ", section='" + section + '\'' +
                ", itemfield='" + itemfield + '\'' +
                ", item='" + item + '\'' +
                '}';
    }

    public LawKey getId() {
        return id;
    }

    public void setId(LawKey id) {
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

    public String getItemfield() {
        return itemfield;
    }

    public void setItemfield(String itemfield) {
        this.itemfield = itemfield;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
