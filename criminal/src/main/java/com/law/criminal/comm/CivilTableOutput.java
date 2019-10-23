package com.law.criminal.comm;

public class CivilTableOutput {

    private Integer partnum;

    private String part;

    private Integer chapternum;

    private String chapter;

    private Integer sectionnum;

    private String section;

    public CivilTableOutput(Integer partnum, String part, Integer chapternum, String chapter, Integer sectionnum, String section) {
        this.partnum = partnum;
        this.part = part;
        this.chapternum = chapternum;
        this.chapter = chapter;
        this.sectionnum = sectionnum;
        this.section = section;
    }

    public CivilTableOutput() {
    }

    @Override
    public String toString() {
        return "CivilTableOutput{" +
                "partnum=" + partnum +
                ", part='" + part + '\'' +
                ", chapternum=" + chapternum +
                ", chapter='" + chapter + '\'' +
                ", sectionnum=" + sectionnum +
                ", section='" + section + '\'' +
                '}';
    }

    public Integer getPartnum() {
        return partnum;
    }

    public void setPartnum(Integer partnum) {
        this.partnum = partnum;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
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
