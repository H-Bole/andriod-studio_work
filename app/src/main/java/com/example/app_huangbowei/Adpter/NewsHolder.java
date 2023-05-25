package com.example.app_huangbowei.Adpter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_huangbowei.R;


public class NewsHolder extends RecyclerView.ViewHolder {

    ImageView Img;
    TextView biaoti;
    TextView neirong;


    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        Img = itemView.findViewById(R.id.nimg);
        biaoti = itemView.findViewById(R.id.ntitle);
        neirong = itemView.findViewById(R.id.ncontent);
    }

}
