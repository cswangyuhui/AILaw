package com.law.criminal.model.mysql;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LawKey implements Serializable {
    @Column(name="partnum")
    private Integer partnum;

    @Column(name="chapternum")
    private Integer chapternum;

    @Column(name="sectionnum")
    private Integer sectionnum;

    @Column(name="itemnum")
    private Integer itemnum;

    public LawKey() {
    }

    public LawKey(Integer partnum, Integer chapternum, Integer sectionnum, Integer itemnum) {
        this.partnum = partnum;
        this.chapternum = chapternum;
        this.sectionnum = sectionnum;
        this.itemnum = itemnum;
    }

    @Override
    public String toString() {
        return "LawKey{" +
                "partnum=" + partnum +
                ", chapternum=" + chapternum +
                ", sectionnum=" + sectionnum +
                ", itemnum=" + itemnum +
                '}';
    }

    public Integer getPartnum() {
        return partnum;
    }

    public void setPartnum(Integer partnum) {
        this.partnum = partnum;
    }

    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
    }

    public Integer getSectionnum() {
        return sectionnum;
    }

    public void setSectionnum(Integer sectionnum) {
        this.sectionnum = sectionnum;
    }

    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }
}
