package com.java.entity;

public class ArticleCount {
    private String id;

    private String articleId;

    private Integer readingCount;

    private Integer lovingCount;

    private Integer commentCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Integer getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(Integer readingCount) {
        this.readingCount = readingCount;
    }

    public Integer getLovingCount() {
        return lovingCount;
    }

    public void setLovingCount(Integer lovingCount) {
        this.lovingCount = lovingCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}