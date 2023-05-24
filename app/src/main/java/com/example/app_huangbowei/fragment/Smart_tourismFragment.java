package com.example.app_huangbowei.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.app_huangbowei.Amusement;
import com.example.app_huangbowei.Country;
import com.example.app_huangbowei.Live;
import com.example.app_huangbowei.Play;
import com.example.app_huangbowei.R;
import com.example.app_huangbowei.Eat;

//智游页

public class Smart_tourismFragment extends BaseFragment {
    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_smart_tourism;
    }

    @Override
    public void initView(View rootView) {
        // 初始化视图组件
        imageView = rootView.findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击事件回调函数中启动目标Activity
                Intent intent = new Intent(getActivity(), Eat.class);
                startActivity(intent);
            }
        });

        imageView1 = rootView.findViewById(R.id.imageView4);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击事件回调函数中启动目标Activity
                Intent intent = new Intent(getActivity(), Live.class);
                startActivity(intent);
            }
        });
        imageView2 = rootView.findViewById(R.id.imageView5);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击事件回调函数中启动目标Activity
                Intent intent = new Intent(getActivity(), Play.class);
                startActivity(intent);
            }
        });
        imageView3 = rootView.findViewById(R.id.imageView6);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击事件回调函数中启动目标Activity
                Intent intent = new Intent(getActivity(), Amusement.class);
                startActivity(intent);
            }
        });
        imageView4 = rootView.findViewById(R.id.imageView7);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击事件回调函数中启动目标Activity
                Intent intent = new Intent(getActivity(), Country.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        // 加载数据
    }
}