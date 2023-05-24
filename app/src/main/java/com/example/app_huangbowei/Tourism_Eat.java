package com.example.app_huangbowei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class Tourism_Eat extends AppCompatActivity {
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private ImageView imageView12, imageView13, imageView14, imageView15, imageView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism_eat);
        getSupportActionBar().hide();

        scrollView = findViewById(R.id.scroll_view);
        linearLayout = findViewById(R.id.linear_layout);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideImageViews();
                imageView16.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0, imageView16.getTop());
            }
        });

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideImageViews();
                imageView16.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0, imageView16.getTop());
            }
        });

        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideImageViews();
                imageView16.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0, imageView16.getTop());
            }
        });

        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideImageViews();
                imageView16.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0, imageView16.getTop());
            }
        });

        imageView16.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    showImageViews();
                    scrollView.scrollTo(0, linearLayout.getBottom());
                    return true;
                }
                return false;
            }
        });
    }

    private void hideImageViews() {
        imageView12.setVisibility(View.GONE);
        imageView13.setVisibility(View.GONE);
        imageView14.setVisibility(View.GONE);
        imageView15.setVisibility(View.GONE);
    }

    private void showImageViews() {
        imageView12.setVisibility(View.VISIBLE);
        imageView13.setVisibility(View.VISIBLE);
        imageView14.setVisibility(View.VISIBLE);
        imageView15.setVisibility(View.VISIBLE);
        imageView16.setVisibility(View.GONE);
    }
}
