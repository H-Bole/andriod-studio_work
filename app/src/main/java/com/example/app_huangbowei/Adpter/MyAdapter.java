package com.example.app_huangbowei.Adpter;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.app_huangbowei.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<NewsHolder> {

    private List<News> newsList ;


    public MyAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        NewsHolder newsHolder = new NewsHolder(view);

        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news = newsList.get(position);//下面的东西是NewsHolder里定义的
        holder.biaoti.setText(news.getBiaoti());
        holder.neirong.setText(news.getNeirong());
        holder.Img.setImageResource(news.getImgid());

        holder.biaoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
               builder.setTitle(news.getBiaoti());
               builder.setMessage(news.getNeirong());
               builder.setIcon(news.getImgid());
               builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(view.getContext(), "返回", Toast.LENGTH_SHORT).show();
                   }
               });
               builder.create();
               builder.show();
            }
        });
        holder.Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(news.getBiaoti());
                builder.setMessage(news.getNeirong());
                builder.setIcon(news.getImgid());
                builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "返回", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return newsList.size();
    }
}
