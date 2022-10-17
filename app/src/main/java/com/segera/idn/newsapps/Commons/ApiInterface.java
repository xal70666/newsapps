package com.segera.idn.newsapps.Commons;
/*
 * Copyright (c)  10 - 2022. Baihaqi
 */

import com.segera.idn.newsapps.Model.GetNewsModel;
import com.segera.idn.newsapps.Model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("everything?q=tesla&from=2022-09-17&sortBy=publishedAt&apiKey=82ad3f4bf4134406873c8097167f0580")
    Call<GetNewsModel> getNewsTeslaAPI(
    );

    @GET("top-headlines?country=us&category=business&apiKey=82ad3f4bf4134406873c8097167f0580")
    Call<GetNewsModel> getNewsBusinnessAPI(
    );

    @GET("top-headlines?sources=techcrunch&apiKey=82ad3f4bf4134406873c8097167f0580")
    Call<GetNewsModel> getNewsTechAPI(
    );
}
