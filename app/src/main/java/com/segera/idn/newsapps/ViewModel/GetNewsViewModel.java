/*
 * Copyright (c) 10 - 2022. Baihaqi
 */

package com.segera.idn.newsapps.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.segera.idn.newsapps.Model.GetNewsModel;
import com.segera.idn.newsapps.Model.NewsModel;
import com.segera.idn.newsapps.Repo.GetNewsRepo;

import java.util.List;

public class GetNewsViewModel {
    private GetNewsRepo repo;
    private MutableLiveData<GetNewsModel> mutableLiveData;

    public GetNewsViewModel(String url, String from) {
        repo = new GetNewsRepo(url, from);
    }

    public LiveData<GetNewsModel> getNewsVM() {
        if (mutableLiveData == null) {
            mutableLiveData = repo.getNewsRepo();
        }
        return mutableLiveData;
    }
}
