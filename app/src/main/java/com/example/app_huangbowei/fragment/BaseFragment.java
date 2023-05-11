package com.example.app_huangbowei.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//基类

public abstract class BaseFragment extends Fragment {
    // 在基类中定义所有子类必须实现的抽象方法
    public abstract int getLayoutResId();
    public abstract void initView(View rootView);
    public abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResId(), container, false);
        initView(rootView);
        initData();
        return rootView;
    }
}
