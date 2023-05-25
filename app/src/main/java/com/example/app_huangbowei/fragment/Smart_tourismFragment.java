package com.example.app_huangbowei.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.app_huangbowei.Tourism_Amusement;
import com.example.app_huangbowei.Tourism_Country;
import com.example.app_huangbowei.Tourism_Live;
import com.example.app_huangbowei.Tourism_Play;
import com.example.app_huangbowei.R;
import com.example.app_huangbowei.Tourism_Eat;

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
                startTargetActivity(Tourism_Eat.class);
            }
        });

        imageView1 = rootView.findViewById(R.id.imageView4);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTargetActivity(Tourism_Live.class);
            }
        });
        imageView2 = rootView.findViewById(R.id.imageView5);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTargetActivity(Tourism_Play.class);
            }
        });
        imageView3 = rootView.findViewById(R.id.imageView6);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTargetActivity(Tourism_Amusement.class);
            }
        });
        imageView4 = rootView.findViewById(R.id.imageView7);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTargetActivity(Tourism_Country.class);
            }
        });
    }

    @Override
    public void initData() {
        // 加载数据
    }

    private void startTargetActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }
}
