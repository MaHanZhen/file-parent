package com.mhz.common.pojo;

public class TbArticlesDecs {
    private String articlesId;

    private String articlesDecs;

    public String getArticlesId() {
        return articlesId;
    }

    public void setArticlesId(String articlesId) {
        this.articlesId = articlesId == null ? null : articlesId.trim();
    }

    public String getArticlesDecs() {
        return articlesDecs;
    }

    public void setArticlesDecs(String articlesDecs) {
        this.articlesDecs = articlesDecs == null ? null : articlesDecs.trim();
    }
}