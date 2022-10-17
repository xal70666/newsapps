/*
 * Copyright (c) 10 - 2022. Baihaqi
 */

package com.segera.idn.newsapps.Commons;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AppsConfig extends Application {
    private static AppsConfig appsConfig;
    private static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        appsConfig = this;
    }

    public static synchronized AppsConfig getInstance() {
        return appsConfig;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static Retrofit getRetrofitClient(String url) {

        if (retrofit == null) {
            OkHttpClientHelper client = new OkHttpClientHelper();

            Gson gsonRetrofit = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .client(client.OkHttpClientHelper())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gsonRetrofit))
                    .baseUrl(url)
                    .build();
        }
        return retrofit;
    }

}
