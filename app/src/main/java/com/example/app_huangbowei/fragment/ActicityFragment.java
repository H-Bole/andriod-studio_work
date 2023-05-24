package com.example.app_huangbowei.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app_huangbowei.R;

//    精彩活动
public class ActicityFragment extends BaseFragment {
    private ImageView imageView;

    public int getLayoutResId() {
        return R.layout.fragment_acticity;
    }

    public void initView(View rootView) {
        // 初始化视图组件
        imageView = rootView.findViewById(R.id.activity1_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 加载另一个布局
                loadAnotherLayout();
            }
        });
    }

    private void loadAnotherLayout() {
        // 加载另一个布局
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_1, null);
        ViewGroup rootView = (ViewGroup) getView().getParent();
        rootView.addView(view);

        // 添加返回按钮的点击事件
        Button backButton = view.findViewById(R.id.btn_activity1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回原来的布局
                ViewGroup rootView = (ViewGroup) getView().getParent();
                rootView.removeViewAt(rootView.getChildCount() - 1);
            }
        });
    }

    public void initData() {
        // 加载数据
    }
}
