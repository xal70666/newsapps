package com.segera.idn.newsapps.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.baihaqi.ubay.newsapps.R;
import com.baihaqi.ubay.newsapps.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.segera.idn.newsapps.Adapter.PagerAdapter;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PagerAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initComponent();
//        initToolbar();
        setValueComponent();
    }

//    private void initToolbar() {
//        setSupportActionBar(binding.toolbar);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("");
//    }

    private void initComponent() {
        linearLayoutManager = new LinearLayoutManager(this);

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tech));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tesla));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.bussiness));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter = new PagerAdapter(getSupportFragmentManager(), this, binding.tabLayout.getTabCount());
        binding.viewPager.setAdapter(adapter);
    }

    private void setValueComponent() {
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}