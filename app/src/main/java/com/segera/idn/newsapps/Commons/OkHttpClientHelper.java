/*
 * Copyright (c) 10/2022. Baihaqi .
 */

package com.segera.idn.newsapps.Commons;

import android.annotation.SuppressLint;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientHelper {

    @SuppressLint("NotConstructor")
    public OkHttpClient OkHttpClientHelper() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(100000, TimeUnit.MILLISECONDS)
                .readTimeout(100000, TimeUnit.MILLISECONDS)
                .writeTimeout(100000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

}
