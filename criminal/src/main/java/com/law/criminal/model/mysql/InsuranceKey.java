package com.law.criminal.model.mysql;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InsuranceKey implements Serializable {
    @Column(name="chapternum")
    private Integer chapternum;

    @Column(name="itemnum")
    private Integer itemnum;

    public InsuranceKey(Integer chapternum, Integer itemnum) {
        this.chapternum = chapternum;
        this.itemnum = itemnum;
    }

    public InsuranceKey() {
    }

    @Override
    public String toString() {
        return "InsuranceKey{" +
                "chapternum=" + chapternum +
                ", itemnum=" + itemnum +
                '}';
    }

    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
    }

    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }
}
