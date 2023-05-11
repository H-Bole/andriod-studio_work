package com.example.app_huangbowei.fragment;

import android.view.View;
import android.widget.ImageView;
//取消复用个人中心
//import com.example.app_huangbowei.My_account;
import com.example.app_huangbowei.R;

//个人中心页

public class User_centerFragment extends BaseFragment {
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_user_center;

    }
    public void initView(View rootView) {
        // 初始化视图组件
        ImageView imageView = rootView.findViewById(R.id.bg_profile);
//        取消点击图片跳转activity
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 点击事件回调函数中启动目标Activity
//                Intent intent = new Intent(getActivity(), My_account.class);
//                startActivity(intent);
//            }
//        });
    }



    @Override
    public void initData() {
        // 加载数据
    }
}

