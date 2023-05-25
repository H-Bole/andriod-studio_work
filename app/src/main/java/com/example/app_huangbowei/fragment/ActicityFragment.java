package com.example.app_huangbowei.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app_huangbowei.R;

// 精彩活动
public class ActicityFragment extends BaseFragment {
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;

    public int getLayoutResId() {
        return R.layout.fragment_acticity;
    }

    public void initView(View rootView) {
        // 初始化视图组件
        imageView = rootView.findViewById(R.id.activity1_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLayout(R.layout.activity_1, R.id.btn_activity1);
            }
        });
        imageView2 = rootView.findViewById(R.id.activity2_img);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLayout(R.layout.activity_2, R.id.btn_activity2);
            }
        });
        imageView3 = rootView.findViewById(R.id.activity3_img);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLayout(R.layout.activity_3, R.id.btn_activity3);
            }
        });

        imageView4 = rootView.findViewById(R.id.activity4_img);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLayout(R.layout.activity_4, R.id.btn_activity4);
            }
        });

        imageView5 = rootView.findViewById(R.id.activity5_img);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLayout(R.layout.activity_5, R.id.btn_activity5);
            }
        });

    }

    public void initData() {
        // 加载数据
    }

    private void loadLayout(int layoutResId, int backButtonResId) {
        // 加载另一个布局
        View view = LayoutInflater.from(getContext()).inflate(layoutResId, null);
        ViewGroup rootView = (ViewGroup) getView().getParent();
        rootView.addView(view);

        // 添加返回按钮的点击事件
        Button backButton = view.findViewById(backButtonResId);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回原来的布局
                ViewGroup rootView = (ViewGroup) getView().getParent();
                rootView.removeViewAt(rootView.getChildCount() - 1);
            }
        });
    }
}
