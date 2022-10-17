package com.segera.idn.newsapps.Activity;

import static com.segera.idn.newsapps.Commons.BaseUrl.BASE_URL;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.baihaqi.ubay.newsapps.R;
import com.baihaqi.ubay.newsapps.databinding.ActivityNewsDetailBinding;
import com.segera.idn.newsapps.Model.DataNewsModel;
import com.segera.idn.newsapps.Model.NewsModel;
import com.segera.idn.newsapps.ViewModel.GetNewsViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class NewsDetailActivity extends AppCompatActivity {
    ActivityNewsDetailBinding binding;
    String title, from;
    private DataNewsModel dataNewsModel;
    ArrayList<NewsModel> newsModels;
    private ArrayList<DataNewsModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        initToolbar();
        initComponent();
        getData();
    }

    private void initComponent() {
        from = getIntent().getStringExtra("from");
        title = getIntent().getStringExtra("title");
        modelList = new ArrayList<>();
        newsModels = new ArrayList<>();
    }

    private void getData() {
        GetNewsViewModel vm = new GetNewsViewModel(BASE_URL, from);
        vm.getNewsVM().observe(this, models -> {

            for (NewsModel model : models.getArticles()) {
                if (Objects.equals(model.getTitle(), title)) {
                    Picasso.get().load(model.getUrlToImage()).into(binding.img);
                    binding.time.setText(model.getPublishedAt());
                    binding.title.setText(model.getTitle());
                    binding.desc.setText(model.getContent());
                }
            }
        });

    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
    }
}