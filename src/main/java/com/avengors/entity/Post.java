package com.avengors.entity;

public class Post {
    private int idx;
    private int midx;
    private String title;
    private String content;
    private String category;
    private String uploadfile;
    private int viewCount;
    private boolean deleted;
    private String wdate;

    @Override
    public String toString() {
        return "Write{" +
                "idx=" + idx +
                ", midx=" + midx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", uploadfile='" + uploadfile + '\'' +
                ", viewCount=" + viewCount +
                ", deleted=" + deleted +
                ", wdate=" + wdate +
                '}';
    }

    public Post() {
    }

    public Post(int idx, int midx, String title, String content, String category, String uploadfile) {
        this.idx = idx;
        this.midx = midx;
        this.title = title;
        this.content = content;
        this.category = category;
        this.uploadfile = uploadfile;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getMidx() {
        return midx;
    }

    public void setMidx(int midx) {
        this.midx = midx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(String uploadfile) {
        this.uploadfile = uploadfile;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }
}
