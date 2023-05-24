package com.example.app_huangbowei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Live extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism_live);
        getSupportActionBar().hide();
    }
}