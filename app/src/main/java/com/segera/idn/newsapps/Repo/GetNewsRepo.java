/*
 * Copyright (c) 10 - 2022. Baihaqi
 */

package com.segera.idn.newsapps.Repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.segera.idn.newsapps.Commons.ApiInterface;
import com.segera.idn.newsapps.Commons.AppsConfig;
import com.segera.idn.newsapps.Model.GetNewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNewsRepo {
    private String url, from;

    public GetNewsRepo(String url, String from) {
        this.url = url;
        this.from = from;
    }

    public MutableLiveData<GetNewsModel> getNewsRepo() {
        final MutableLiveData<GetNewsModel> mutableLiveData = new MutableLiveData<>();
        ApiInterface apiService = AppsConfig.getRetrofitClient(url).create(ApiInterface.class);
        switch (from) {
            case "tesla":
                apiService.getNewsTeslaAPI().enqueue(new Callback<GetNewsModel>() {
                    @Override
                    public void onResponse(Call<GetNewsModel> call, Response<GetNewsModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<GetNewsModel> call, Throwable t) {

                    }
                });
                break;
            case "tech":
                apiService.getNewsTechAPI().enqueue(new Callback<GetNewsModel>() {
                    @Override
                    public void onResponse(Call<GetNewsModel> call, Response<GetNewsModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            mutableLiveData.setValue(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<GetNewsModel> call, Throwable t) {
                        Log.d("cek", t.getMessage() + "|");

                    }
                });
                break;
            case "bussiness":
                apiService.getNewsBusinnessAPI().enqueue(new Callback<GetNewsModel>() {
                    @Override
                    public void onResponse(Call<GetNewsModel> call, Response<GetNewsModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<GetNewsModel> call, Throwable t) {

                    }
                });
                break;
        }

        return mutableLiveData;
    }
}
