package com.law.criminal.comm;

public class CommonTableOutput {
    private Integer chapterNum;
    private String chapter;

    public CommonTableOutput(Integer chapterNum, String chapter) {
        this.chapterNum = chapterNum;
        this.chapter = chapter;
    }

    public CommonTableOutput() {
    }

    public Integer getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(Integer chapterNum) {
        this.chapterNum = chapterNum;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "CommonTableOutput{" +
                "chapterNum=" + chapterNum +
                ", chapter='" + chapter + '\'' +
                '}';
    }
}
