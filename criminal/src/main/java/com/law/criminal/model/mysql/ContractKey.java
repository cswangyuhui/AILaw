package com.law.criminal.model.mysql;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class ContractKey implements Serializable {
    @Column(name="chapternum")
    private Integer chapternum;

    @Column(name="itemnum")
    private Integer itemnum;

    public ContractKey(Integer chapternum, Integer itemnum) {
        this.chapternum = chapternum;
        this.itemnum = itemnum;
    }

    public ContractKey() {
    }

    @Override
    public String toString() {
        return "ContractKey{" +
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
