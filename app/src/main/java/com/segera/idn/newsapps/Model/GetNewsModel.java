package com.segera.idn.newsapps.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetNewsModel {
    @SerializedName("articles")
    ArrayList<NewsModel> articles;

    public ArrayList<NewsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsModel> articles) {
        this.articles = articles;
    }
}
