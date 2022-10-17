/*
 * Copyright (c) 10 - 2022. Baihaqi
 */

package com.segera.idn.newsapps.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baihaqi.ubay.newsapps.R;
import com.segera.idn.newsapps.Activity.NewsDetailActivity;
import com.segera.idn.newsapps.Model.DataNewsModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    ArrayList<DataNewsModel> dataNewsModels;
    Context mcontext;
    String BASE_URL, from;

    public NewsAdapter(ArrayList<DataNewsModel> dataNewsModels, Context mcontext, String from) {
        this.dataNewsModels = dataNewsModels;
        this.mcontext = mcontext;
        this.from = from;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news_contiainer_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataNewsModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPublish;
        ImageView img;
        RelativeLayout rvItem;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPublish = itemView.findViewById(R.id.tvPublish);
            img = itemView.findViewById(R.id.img);
            rvItem = itemView.findViewById(R.id.rvItem);
        }

        @SuppressLint("SetTextI18n")
        public void bind(int position) {
            tvTitle.setText(dataNewsModels.get(position).getTitle());
            tvPublish.setText("Publish : " + dataNewsModels.get(position).getPublishedAt());
            Picasso.get().load(dataNewsModels.get(position).getUrlToImage()).into(img);

            rvItem.setOnClickListener(view -> {
                Intent intent = new Intent(mcontext, NewsDetailActivity.class);
                intent.putExtra("title", dataNewsModels.get(position).getTitle());
                intent.putExtra("from", from);
                mcontext.startActivity(intent);
            });
        }
    }


}
