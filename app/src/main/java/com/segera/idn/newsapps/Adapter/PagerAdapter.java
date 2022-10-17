/*
 * Copyright (c) 10 - 2022. Baihaqi
 */

package com.segera.idn.newsapps.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.segera.idn.newsapps.Fragment.BussinessFragment;
import com.segera.idn.newsapps.Fragment.TechFragment;
import com.segera.idn.newsapps.Fragment.TeslaFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private int totalTabs;

    public PagerAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new TechFragment();
                break;
            case 1:
                fragment = new TeslaFragment();
                break;
            case 2:
                fragment = new BussinessFragment();
                break;
            default:
                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
