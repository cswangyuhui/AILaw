package com.law.criminal.comm;

public class SecurityTableOutput {
    private Integer chapternum;

    private String chapter;

    private Integer sectionnum;

    private String section;

    public SecurityTableOutput(Integer chapternum, String chapter, Integer sectionnum, String section) {
        this.chapternum = chapternum;
        this.chapter = chapter;
        this.sectionnum = sectionnum;
        this.section = section;
    }

    public SecurityTableOutput() {
    }

    @Override
    public String toString() {
        return "SecurityTableOutput{" +
                "chapternum=" + chapternum +
                ", chapter='" + chapter + '\'' +
                ", sectionnum=" + sectionnum +
                ", section='" + section + '\'' +
                '}';
    }

    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
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
}
