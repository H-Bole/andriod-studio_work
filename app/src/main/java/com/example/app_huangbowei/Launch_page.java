package com.example.app_huangbowei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

//启动页

public class Launch_page extends AppCompatActivity {

    private ImageView ivBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_page);
        getSupportActionBar().hide();
        // 获取 ImageView 控件
        ivBackground = findViewById(R.id.home_bg);

        // 加载GIF作为背景
        Glide.with(this)
                .asGif()
                .load(R.drawable.launch_page_bg)
                .into(ivBackground);
        //按钮声明
        Button button1 = findViewById(R.id.btn_first);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Launch_page.this, Main_program.class);
                startActivity(intent);
            }
        });

    }
}