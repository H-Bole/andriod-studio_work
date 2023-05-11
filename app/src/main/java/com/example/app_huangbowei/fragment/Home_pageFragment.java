package com.example.app_huangbowei.fragment;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app_huangbowei.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

//首页

public class Home_pageFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView(View rootView) {
        tabLayout = rootView.findViewById(R.id.tab_layout);
        viewPager = rootView.findViewById(R.id.view_pager);
    }

    @Override
    public void initData() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new AppRankingFragment());

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(this, fragments);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("推荐");
                    break;
                case 1:
                    tab.setText("应用榜");
                    break;
            }
        }).attach();
    }

    public static class RecommendFragment extends BaseFragment {
        @Override
        public int getLayoutResId() {
            return R.layout.fragment_recommend;
        }

        @Override
        public void initView(View rootView) {
            // 初始化视图组件
        }

        @Override
        public void initData() {
            // 加载数据
        }
    }

    public static class AppRankingFragment extends BaseFragment {
        @Override
        public int getLayoutResId() {
            return R.layout.fragment_app_ranking;
        }

        @Override
        public void initView(View rootView) {
            // 初始化视图组件
        }

        @Override
        public void initData() {
            // 加载数据
        }
    }

}

