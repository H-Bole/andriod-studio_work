package com.example.app_huangbowei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism_play);
        getSupportActionBar().hide();
    }
}