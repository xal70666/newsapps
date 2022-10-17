package com.segera.idn.newsapps.Fragment;

import static com.segera.idn.newsapps.Commons.BaseUrl.BASE_URL;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baihaqi.ubay.newsapps.R;
import com.baihaqi.ubay.newsapps.databinding.FragmentTeslaBinding;
import com.segera.idn.newsapps.Adapter.NewsAdapter;
import com.segera.idn.newsapps.Model.DataNewsModel;
import com.segera.idn.newsapps.Model.NewsModel;
import com.segera.idn.newsapps.ViewModel.GetNewsViewModel;

import java.util.ArrayList;


public class TeslaFragment extends Fragment {
    FragmentTeslaBinding binding;
    private ArrayList<DataNewsModel> modelList;
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter adapter;
    private DataNewsModel dataNewsModel;
    ArrayList<NewsModel> newsModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponent();
        getData();
    }

    private void getData() {
        modelList.clear();
        binding.rv.setVisibility(View.GONE);
        GetNewsViewModel vm = new GetNewsViewModel(BASE_URL, "tesla");
        vm.getNewsVM().observe(getViewLifecycleOwner(), models -> {

            for (NewsModel model : models.getArticles()) {
                dataNewsModel = new DataNewsModel(
                        model.getTitle(),
                        model.getUrlToImage(),
                        model.getPublishedAt(),
                        model.getContent(),
                        model.getDescription()
                );
                modelList.add(dataNewsModel);
            }
            fillData();
        });

    }

    public void fillData() {
        binding.rv.setHasFixedSize(true);
        adapter = new NewsAdapter(modelList, getActivity(), "tesla");
        binding.rv.setLayoutManager(linearLayoutManager);
        binding.rv.setItemAnimator(new DefaultItemAnimator());
        binding.rv.setAdapter(adapter);
        binding.rv.setVisibility(View.VISIBLE);
        binding.loading.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tesla, container, false);
        return binding.getRoot();
    }

    private void initComponent() {
        modelList = new ArrayList<>();
        newsModels = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getActivity());
    }
}