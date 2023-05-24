package com.example.app_huangbowei.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.app_huangbowei.R;
import com.example.app_huangbowei.Eat;

//智游页

public class Smart_tourismFragment extends BaseFragment {
    private ImageView imageView;
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
    }

    @Override
    public void initData() {
        // 加载数据
    }
}