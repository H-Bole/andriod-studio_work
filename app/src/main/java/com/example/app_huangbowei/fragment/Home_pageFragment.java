package com.example.app_huangbowei.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
    private RelativeLayout bannerContainer;
    private ViewPager bannerViewPager;

    private boolean isExpanded = true; // 轮播图是否展开标志位



    @Override
    public int getLayoutResId() {
//        加载首页xml
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView(View rootView) {
        tabLayout = rootView.findViewById(R.id.category);
        viewPager = rootView.findViewById(R.id.home_viewpager);
        bannerContainer = rootView.findViewById(R.id.banner_container);
        bannerViewPager = rootView.findViewById(R.id.lunbotu);
        Button btnToggle = rootView.findViewById(R.id.btn_toggle);

        //    轮播图隐藏
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (isExpanded) {
                    bannerContainer.setVisibility(View.GONE);
                    btnToggle.setText("展开");
                    isExpanded = !isExpanded;
                }
            }
        };
        // 设置10秒后自动隐藏轮播图
        handler.postDelayed(runnable, 10000);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    // 隐藏轮播图
                    bannerContainer.setVisibility(View.GONE);
                    btnToggle.setText("展开");

                    // 取消自动隐藏
                    handler.removeCallbacks(runnable);
                } else {
                    // 显示轮播图
                    bannerContainer.setVisibility(View.VISIBLE);
                    btnToggle.setText("收起");

                    // 重新设置10秒后自动隐藏轮播图
                    handler.postDelayed(runnable, 10000);
                }
                isExpanded = !isExpanded;
            }
        });
    }

    @Override
    public void initData() {
//        首页下的fragment
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SummarizeFragment());
        fragments.add(new SimpknowFragment());
        fragments.add(new ActicityFragment());
        fragments.add(new TicketFragment());

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(this, fragments);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("概况");
                    break;
                case 1:
                    tab.setText("初识度假区");
                    break;
                case 2:
                    tab.setText("精彩活动");
                    break;
                case 3:
                    tab.setText("门票预定");
                    break;
            }
        }).attach();

        // 轮播图数据（更新）
        List<Drawable> bannerData = new ArrayList<>();
        bannerData.add(ContextCompat.getDrawable(getActivity(), R.drawable.fg1));
        bannerData.add(ContextCompat.getDrawable(getActivity(), R.drawable.fg2));
        bannerData.add(ContextCompat.getDrawable(getActivity(), R.drawable.fg1));


        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(getActivity(), bannerData);
        bannerViewPager.setAdapter(bannerPagerAdapter);
        bannerViewPager.setOffscreenPageLimit(bannerData.size());
    }

    // 轮播图PagerAdapter
    static class BannerPagerAdapter extends PagerAdapter {
        private Context mContext;
        private List<Drawable> mData;

        public BannerPagerAdapter(Context context, List<Drawable> data) {
            mContext = context;
            mData = data;
        }

        public void setData(List<Drawable> data) {
            mData = data;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(mData.get(position));
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }



    //以下是内部类（注意使用公共类）
    public static class SummarizeFragment extends BaseFragment {
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
    public static class SimpknowFragment extends BaseFragment {
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
    public static class ActicityFragment extends BaseFragment {
        public int getLayoutResId() {
            return R.layout.fragment_app_test;
        }
        public void initView(View rootView) {
            // 初始化视图组件
        }
        public void initData() {
            // 加载数据
        }
    }

    public static class TicketFragment extends BaseFragment {
        public int getLayoutResId() {
            return R.layout.fragment_app_test2;
        }
        public void initView(View rootView) {
            // 初始化视图组件
        }
        public void initData() {
            // 加载数据
        }
    }
}

