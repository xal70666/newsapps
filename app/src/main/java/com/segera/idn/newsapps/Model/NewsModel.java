/*
 * Copyright (c) 10 - 2022. Baihaqi
 */

package com.segera.idn.newsapps.Model;

import com.google.gson.annotations.SerializedName;

public class NewsModel {
    @SerializedName("title")
    String title;

    @SerializedName("urlToImage")
    String urlToImage;

    @SerializedName("publishedAt")
    String publishedAt;

    @SerializedName("content")
    String content;

    @SerializedName("description")
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
