package com.example.app_huangbowei.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app_huangbowei.Adpter.FragmentPagerAdapter;
import com.example.app_huangbowei.Adpter.MyAdapter;
import com.example.app_huangbowei.Adpter.News;
import com.example.app_huangbowei.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Calendar;
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
        // 设置6秒后自动隐藏轮播图
        handler.postDelayed(runnable, 6000);

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
        bannerData.add(ContextCompat.getDrawable(getActivity(), R.drawable.lunbo1));
        bannerData.add(ContextCompat.getDrawable(getActivity(), R.drawable.lunbo2));
        bannerData.add(ContextCompat.getDrawable(getActivity(), R.drawable.lunbo3));


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

//    概括页
    public static class SummarizeFragment extends BaseFragment {
        @Override
        public int getLayoutResId() {
            return R.layout.fragment_summarize;
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


//    初识页
    public static class SimpknowFragment extends BaseFragment {

        RecyclerView recyclerView ;
        @Override
        public int getLayoutResId() {
            return R.layout.fragment_simpknow;
        }
        @Override
        public void initView(View rootView) {
            // 初始化视图组件
            recyclerView= rootView.findViewById(R.id.recyclerView);

            final String content1 = "都江堰景区位于四川省成都市都江堰市(原灌县)城西，坐落在成都平原西部的岷江上距成都市区约50公里，距离青城山风景区20公里。\n" +
                    "\n" +
                    "都江堰水利工程充分利用当地西北高、东南低的地理条件，根据江河出山口处特殊的地形、水脉、水势，乘势利导，无坝引水，自流灌溉，使堤防、分水、泄洪、排沙、控流相互依存，共为体系，保证了防洪、灌溉、水运和社会用水综合效益的充分发挥。它最伟大之处是建堰2274多年来经久不衰，而且发挥着愈来愈大的效益。都江堰建成后，成都平原沃野千里，“水旱从人，不知饥馑，时无荒年，谓之天府”。";
            final  String content2 ="都江堰市属中亚热带季风湿润气候区，年均气温15.2℃，年均降水量近1200毫米，年均无霜期280天。这里四季分明，夏无酷暑，最热的7、8月份平均气温为24℃左右，平均最高气温仅28℃。冬无严寒，最冷的1月份平均气温为4.6℃，平均最低气温在1℃左右。\n" +
                    "\n";
            final  String content3 ="都江堰的创建，开创了中国古代水利史上的新纪元\n" +
                    "\n" +
                    "都江堰的创建，以不破坏自然资源，充分利用自然资源为人类服务为前提，变害为利，使人、地、水三者高度协合统一，是全世界迄今为止仅存的一项伟大的“生态工程”。开创了中国古代水利史上的新纪元，标志着中国水利史进入了一个新阶段，在世界水利史上写下了光辉的一章。都江堰水利工程，是中国古代人民智慧的结晶，是中华文化划时代的杰作，更是古代水利工程沿用至今，“古为今用”、硕果仅存的奇观。与之兴建时间大致相同的古埃及和古巴比仑的灌溉系统，以及中国陕西的郑国渠和广西的灵渠，都因沧海变迁和时间的推移，或湮没、或失效，唯有都江堰独树一帜，由兴建源远流长，至今还滋润着天府之国的万顷良田。\n" +
                    "\n" +
                    "都江堰是一个科学、完整、极富发展潜力的庞大的水利工程体系\n" +
                    "李冰主持创建的都江堰，正确处理鱼嘴分水堤、飞沙堰泄洪道、宝瓶口引水口等主体工程的关系，使其相互依赖，功能互补，巧妙配合，浑然一体，形成布局合理的系统工程，联合发挥分流分沙、泄洪排沙、引水疏沙的重要作用，使其枯水不缺，洪水不淹。都江堰的三大部分，科学地解决了江水自动分流、自动排沙、控制进水流量等问题，消除了水患。\n" +
                    "李冰所创建的都江堰是一个科学、完整、极富发展潜力的庞大的水利工程体系，是巧夺天工、造福当代、惠泽未来的水利工程，是区域水利网络化的典范。后来的灵渠、它山堰、渔梁坝、戴村坝一批历史性工程，都有都江堰的印记。\n" +
                    "都江堰水利工程的科学奥妙之处，集中反映在以上三大工程组成了一个完整的大系统，形成无坝限量引水并且在岷江不同水量情况下的分洪除沙、引水灌溉的能力，使成都平原“水旱从人、不知饥馑”，适应了当时社会经济发展的需要。解放后，又增加了蓄水、暗渠供水功能，使都江堰工程的科技经济内涵得到了充分的拓展，适应了现代经济发展的需要。\n" +
                    "都江堰水利事业工程针对岷江与成都平原的悬江特点与矛盾，充分发挥水体自调、避高就下、弯道环流特性，“乘势利导、因时制宜”，正确处理悬江岷江与成都平原的矛盾，使其统一在一大工程体系中，变水害为水利。\n" +
                    "两千多年前，都江堰取得这样伟大的科学成就，世界绝无仅有，至今仍是世界水利工程的最佳作品。1872年，德国地理学家李希霍芬(Richthofen 1833-1905)称赞“都江堰灌溉方法之完善，世界各地无与伦比”。1986年，国际灌排委员会秘书长弗朗杰姆，国际河流泥沙学术会的各国专家参观都江堰后，对都江堰科学的灌溉和排沙功能给予高度评价。1999年3月，联合国人居中心官员参观都江堰后，建议都江堰水利工程参评2000年联合国\"最佳水资源利用和处理奖\"。\n" ;
            final  String content4 ="水文化\n" +
                    "\n" +
                    "由都江堰而产生的具有强烈地域色彩的都江堰水文化包括水文学、水文物、水神学等，诸如“二王庙”、“伏龙观”、“观景台”等处的人文景观；改建鱼嘴挖掘出土的东汉李冰石像和“饮水思源”石刻；歌颂李冰父子降龙治水的民间传说和具有一定宗教神学色彩的祭祀活动；以及由此而产生的祭水、祭神、祭人的诗、词、书画的水文学等，形成独具特色的都江堰水文化。都江堰有块石碑，上面刻着“深淘滩，低作堰”字样。\n" +
                    "\n" +
                    "对修建者的纪念\n" +
                    "\n" +
                    "都江堰建于公元前256年，是战国时期秦国蜀郡太守李冰及其子二郎率众修建的一座大型水利工程，是全世界至今为止，年代最久、唯一留存、以无坝引水为特征的宏大水利工程。2200多年来，至今仍发挥巨大效益，李冰治水，功在当代，利在千秋，不愧为文明世界的伟大杰作，造福人民的伟大水利工程。成都平原能够如此富饶，被人们称为“天府”乐土，从根本上说，是李冰创建都江堰的结果。所以《史记》说：“都江堰建成，使成都平原‘水旱从人，不知饥馑，时无荒年，天下谓之“天府”也’”。\n" +
                    "\n" +
                    "\n" +
                    "治水哲学思想\n" +
                    "\n" +
                    "都江堰源远流长，惠泽后代，其奥秘除了巧夺天工的工程布局外，更主要的是遵循了“乘势利导、因时制宜”的治水指导思想、“岁必一修”的管理制度，“遇难弯截角、逢正抽心”的治河原则，以及“砌鱼嘴立湃缺，深淘滩、低作堰”的引水、防沙、泄洪之管理经验和治堰准则。\n" +
                    "\n" +
                    "都江堰工程在两千多年运行中，充分发挥了工程潜能，人们在长期实践中积累了独具特色宝贵的经验。其中文化内涵丰富，反映了治水先驱和广大劳动人民的智慧，都江堰水文化的形成和发展，充分反映了“实践是检验真理的唯一标准”的正确性和长期性。都江堰水文化的内涵，反映了在工程修建、维修、管理和发展的全过程，是人类社会发展的重要遗产之一。这也是联合国评定都江堰工程为世界重要文化遗产的重要原因。\n" +
                    "\n" +
                    "\n" +
                    "治水三字经\n" +
                    "\n" +
                    "人们在长期实践中创造了都江堰水文化，其内涵深刻，是都江堰工程长盛不衰的重要因素。“乘势利导、因时制宜”的原则，是治理都江堰工程的准则，人们称之为“八字格言”。都江堰的治水三字经，更是人们治理都江堰工程的经验总结和行为准则。“深淘滩，低作堰，六字旨，千秋鉴，挖河沙，堆堤岸，砌鱼嘴，安羊圈，立湃阙，凿漏罐，笼编密，石装健，分四六，平潦旱，水画符，铁椿见，岁勤修，预防患，遵旧制，勿擅变”。\n" +
                    "\n" +
                    "治水三字经是千余年来人们治理都江堰经验的概括，有着深刻的文化内涵，是治理都江堰的行为准则。曾经有人批评《治水三字经》中的“遵旧制、勿擅变”是保守思想的反映。实践证明《治水三字经》中的每一项措施，都是人们从长期实践中总结出来的，值得珍视和继承。所谓遵旧制、勿擅变者，就是在治理都江堰时要按客观规律办事，而《治水三字经》就是千百年来治理都江堰工程的经验总结。“勿擅变”不是不变，而是要遵循客观规律办事。实践证明《治水三字经》文化内涵，是人们长期实践的结果。随着人们继续实践，《治水三字经》的意义将与时俱进，长期指导着都江堰工程的保护与发展。\n" +
                    "\n" +
                    "都江堰工程按水势和地形特征，以杩槎截流导流、卵石护岸、竹笼盛石筑堤、卧铁展示淘滩标准，以及“遇弯截角，逢正抽心”和“深淘滩，低作堰”等遗迹构成一道道独特的风景线，工艺精湛，造型优美，功能显著，显示出都江堰水文化特征，具有深远的历史和现实意义。至于降伏孽龙的传说，望娘滩的故事，更是家喻户晓，文化内涵深刻，体现了人们对都江堰的爱护和依恋之情。宝瓶口的水尺和古水则，更显示出劳动人民的智慧，指导着灌区人民正确运用都江堰水资源，使灌区工农业生产能够乘势利导，驱利避害。中华人民共和国成立之初，政府每天在《川西日报》公布都江堰宝瓶口水位，让灌区人民及时掌握都江堰水情，安排生产和防洪抗旱等工作。宝瓶口水则，至今仍具有指导灌区工农业生产和生活用水的意义。李冰神像的出土，“卧铁”的发现，展示都江堰水文化，引起人们对建设都江堰先行者的缅怀和崇敬。\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "都江堰放水节\n" +
                    "\n" +
                    "每年农历六月二十四日和六月二十六日为中心的庙会活动。李冰主持创建都江堰，使长期苦于水旱灾害的川西平原一下子成为富庶的、世人瞩目的“天府之国”，人民对他的感戴之情是没齿难忘的。两千多年来，李冰父子凿离堆，开堰建渠为天府之国带来的福泽一直为世人所崇敬、感激，二王庙从古至今不但香火鼎盛，而且在历史上一直既有官方主持的祭奠活动，也有老百姓的民间祭祀活动，官方的祭祀活动更为隆重。据史料记载，官方的祭祀活动正式颁定，是在宋开宝七年（929年），初定为每年祭祀一次，后改为每年春秋祭祀两次。早期的祭祀十分隆重，有十分隆重的血祭遗风。现代代之以“清明放水节”庆典活动，已成为都江堰特有的风俗。\n" +
                    "\n" +
                    "\n" +
                    "二王庙庙会\n" +
                    "\n" +
                    "时间：每年的农历6月24日-农历6月26日\n" +
                    "\n" +
                    "相传农历六月二十四是二郎神生日，两日后为李冰生日，正值鸟语花香之时，受到都江堰恩泽的人们纷纷走出家门，来到二王庙焚香祭祀，怀念都江堰的缔造人李冰父子，由道庙主持举行盛大的“川主清源妙道真君”祭典大会，摆设道场三天。今二王庙庙会，不仅增添了歌舞表演、川剧表演等内容，还有川剧变脸等绝活展示；每岁庙会，二王庙内烟霞蒸腾，万人朝拜，空前盛况，不减当年。\n";
            final  String content5 ="都江堰建于公元前256年，是战国时期秦国蜀郡太守李冰及其子二郎率众修建的一座大型水利工程，是全世界至今为止，年代最久、唯一留存、以无坝引水为特征的宏大水利工程。2200多年来，至今仍发挥巨大效益，李冰治水，功在当代，利在千秋，不愧为文明世界的伟大杰作，造福人民的伟大水利工程。成都平原能够如此富饶，被人们称为“天府”乐土，从根本上说，是李冰创建都江堰的结果。所以《史记》说：“都江堰建成，使成都平原‘水旱从人，不知饥馑，时无荒年，天下谓之“天府”也’”。\n" +
                    "\n" +
                    "都江堰源远流长，惠泽后代，其奥秘除了巧夺天工的工程布局外，更主要的是遵循了“乘势利导、因时制宜”的治水指导思想、“岁必一修”的管理制度，“遇难弯截角、逢正抽心”的治河原则，以及“砌鱼嘴立湃缺，深淘滩、低作堰”的引水、防沙、泄洪之管理经验和治堰准则。\n" +
                    "都江堰工程在两千多年运行中，充分发挥了工程潜能，人们在长期实践中积累了独具特色宝贵的经验。其中文化内涵丰富，反映了治水先驱和广大劳动人民的智慧，都江堰水文化的形成和发展，充分反映了“实践是检验真理的唯一标准”的正确性和长期性。都江堰水文化的内涵，反映了在工程修建、维修、管理和发展的全过程，是人类社会发展的重要遗产之一。这也是联合国评定都江堰工程为世界重要文化遗产的重要原因。\n" +
                    "\n" +
                    "江堰放水节\n" +
                    "每年农历六月二十四日和六月二十六日为中心的庙会活动。李冰主持创建都江堰，使长期苦于水旱灾害的川西平原一下子成为富庶的、世人瞩目的“天府之国”，人民对他的感戴之情是没齿难忘的。两千多年来，李冰父子凿离堆，开堰建渠为天府之国带来的福泽一直为世人所崇敬、感激，二王庙从古至今不但香火鼎盛，而且在历史上一直既有官方主持的祭奠活动，也有老百姓的民间祭祀活动，官方的祭祀活动更为隆重。据史料记载，官方的祭祀活动正式颁定，是在宋开宝七年（929年），初定为每年祭祀一次，后改为每年春秋祭祀两次。早期的祭祀十分隆重，有十分隆重的血祭遗风。现代代之以“清明放水节”庆典活动，已成为都江堰特有的风俗。\n" +
                    "\n" +
                    "二王庙庙会\n" +
                    "时间：每年的农历6月24日-农历6月26日\n" +
                    "相传农历六月二十四是二郎神生日，两日后为李冰生日，正值鸟语花香之时，受到都江堰恩泽的人们纷纷走出家门，来到二王庙焚香祭祀，怀念都江堰的缔造人李冰父子，由道庙主持举行盛大的“川主清源妙道真君”祭典大会，摆设道场三天。今二王庙庙会，不仅增添了歌舞表演、川剧表演等内容，还有川剧变脸等绝活展示；每岁庙会，二王庙内烟霞蒸腾，万人朝拜，空前盛况，不减当年。\n";
            final  String content6 ="水利工程\n" +
                    "\n" +
                    "都江堰水利工程充分利用当地西北高、东南低的地理条件，根据江河出山口处特殊的地形、水脉、水势，乘势利导，无坝引水，自流灌溉，使堤防、分水、泄洪、排沙、控流相互依存，共为体系，保证了防洪、灌溉、水运和社会用水综合效益的充分发挥。它最伟大之处是建堰2250多年来经久不衰，而且发挥着愈来愈大的效益。都江堰建成后，成都平原沃野千里，“水旱从人，不知饥馑，时无荒年，谓之天府”。都江堰渠首枢纽主要由鱼嘴、飞沙堰、宝瓶口三大主体工程构成。三者有机配合，相互制约，协调运行，引水灌田，分洪减灾，具有“分四六，平潦旱”的功效。\n" +
                    "\n" +
                    "岷江鱼嘴分水工程\n" +
                    "\n" +
                    "鱼嘴分水堤又称“鱼嘴”，是都江堰的分水工程，因其形如鱼嘴而得名，它昂头于岷江江心，包括百丈堤、杩槎、金刚堤等一整套相互配合的设施。其主要作用是把汹涌的岷江分成内外二江，西边叫外江，俗称“金马河”，是岷江正流，主要用于排洪；东边沿山脚的叫内江，是人工引水渠道，主要用于灌溉。\n" +
                    "在古代，鱼嘴是以竹笼装卵石垒砌。由于它建筑在岷江冲出山口呈弯道环流的江心，冬春季江水较枯，水流经鱼嘴上面的弯道绕行，主流直冲内江，内江进水量约6成，外江进水量约4成；夏秋季水位升高，水势不再受弯道制约，主流直冲外江，内、外江江水的比例自动颠倒：内江进水量约4成，外江进水量约6成。这就利用地形，完美地解决了内江灌区冬春季枯水期农田用水以及人民生活用水的需要和夏秋季洪水期的防涝问题。 \n" +
                    "\n" +
                    "飞沙堰溢洪排沙工程\n" +
                    "\n" +
                    "飞沙堰溢洪道又称“泄洪道”，具有泻洪、排沙和调节水量的显著功能，故又叫它“飞沙堰”。 飞沙堰是都江堰三大件之一，看上去十分平凡，其实它的功用非常之大，可以说是确保成都平原不受水灾的关键要害。飞沙堰的作用主要是当内江的水量超过宝瓶口流量上限时，多余的水便从飞沙堰自行溢出；如遇特大洪水的非常情况，它还会自行溃堤，让大量江水回归岷江正流。飞沙堰的另一作用是“飞沙”，岷江从万山丛中急驰而来，挟着大量泥沙、石块，如果让它们顺内江而下，就会淤塞宝瓶口和灌区。 古时飞沙堰，是用竹笼卵石堆砌的临时工程；如今已改用混凝土浇铸，以保一劳永逸的功效。\n" +
                    "\n" +
                    "宝瓶口引水工程\n" +
                    "\n" +
                    "宝瓶口起\"节制闸\"作用，能自动控制内江进水量，是湔山(今名灌口山、玉垒山)伸向岷江的长脊上凿开的一个口子，它是人工凿成控制内江进水的咽喉，因它形似瓶口而功能奇特，故名宝瓶口。留在宝瓶口右边的山丘，因与其山体相离，故名离堆。离堆在开凿宝瓶口以前，是湔山虎头岩的一部分。由于宝瓶口自然景观瑰丽，有“离堆锁峡”之称，属历史上著名的“灌阳十景”之一。\n" +
                    "\n" +
                    "二王庙\n" +
                    "\n" +
                    "二王庙位于岷江右岸的山坡上，前临都江堰，原为纪念蜀王的望帝祠，齐建武（公元494～498年）时改祀李冰父子，更名为“崇德祠”。宋代（公元960～1279年）以后，李冰父子相继被皇帝敕封为王，故而后人称之为“二王庙”。庙内主殿分别供奉有李冰父子的塑像，并珍藏有治水名言、诗人碑刻等。建筑群分布在都江堰渠首东岸，规模宏大，布局严谨，地极清幽。是庙宇和园林相结合的著名景区。占地约5万余平方米，主建筑约1万平方米。二王庙分东、西两菀，东菀为园林区，西菀为殿宇区。全庙为木穿逗结构建筑，庙寺完全依靠自然地理环境，依山取势，在建筑风格上不强调中轴对称。\n" +
                    "\n" +
                    "伏龙观\n" +
                    "\n" +
                    "伏龙观位于离堆公园内。其下临深潭，传说因李冰父子治水时曾在这里降伏孽龙在离堆之下，故于北宋初年改祭李冰，取名“伏龙观”。现存殿宇三重，前殿正中立有东汉时期（公元25～220年）所雕的李冰石像。殿内还有东汉堰工石像、唐代金仙和玉真公主在青城山修道时的遗物——飞龙鼎。伏龙观又名老王庙、李公词、李公庙等。清同治五年(公元1866年)四川巡抚祟实以为：“于虽齐圣，不先父食。况以公之贤：又有功于蜀，其施力程能固无待乎其子。今乃数典忘祖，于掩其父得无紊钦?”\n" +
                    "\n" +
                    "安澜索桥\n" +
                    "\n" +
                    "安澜索桥又名“安澜桥”、“夫妻桥”。位于都江堰鱼嘴之上，横跨内外两江，被誉为“中国古代五大桥梁”，是都江堰最具特征的景观。始建于宋代以前，明末（公元17世纪）毁于战火。古名“珠浦桥”，宋淳化元年改“评事桥”，清嘉庆建新桥更名为“安澜桥”。原索桥以木排石墩承托，用粗竹缆横挂江面，上铺木板为桥面，两旁以竹索为栏，全长约500米，桥为钢索混凝土桩。\n" +
                    "索桥在四川西部地区起源较早。安澜索桥修建具体年代已不从所考，但据《华阳国志·蜀志》记载李冰“能笮”。《水经注·江水》载“涪江有笮桥”，证明至少安澜桥的修建，不会晚于修筑都江堰的年代。笮，意为竹索，这是川西古代索桥的主要建筑材料，故安澜索桥又被称为竹桥、绳桥、竹藤桥等。桥为1974年重建，下移100多米，将竹索改为钢索，承托缆索的木桩桥墩改为混凝土桩。\n" +
                    "\n" +
                    "卧铁\n" +
                    "\n" +
                    "卧铁是埋在内江“凤栖窝”处的淘滩标准，也是内江每年维修清淘河床深浅的标志。相传李冰建堰时在内江河床下埋有石马，作为每年淘滩深度的标准，后来演变为卧铁。现有四根卧铁分别是明朝万历四年、清同治三年、民国十六年和1994年埋下的。游客在离堆古园内喷泉处能看到的这四根卧铁的复制品，其真品还埋在内江河床下。\n" +
                    "\n" +
                    "其他景点\n" +
                    "\n" +
                    "奎光塔、虹口景区、南桥、园明宫、清溪园、都江堰城隍庙、玉垒关、离堆公园、秦堰楼、玉垒山公园、掷笔槽、青城外山景区、青城前山景区青城后山景区两河漂流药王庙、幸福大道、翠月湖、灵岩。\n";
            final  String content7 = "都江堰距成都市39公里，20分钟高速公路车程即可到达，成都西门车站10分钟一班旅游车直达都江堰市，在都江堰市内可乘1路、4路公共汽车或出租车到达景区。\n" +
                    "\n" +
                    "从成都市驾车区经成灌高速公路到都江堰，约30分钟车程。\n" +
                    "\n" +
                    "另外，有大巴车从成都茶店子直达都江堰市客运中心，每天早6:30发班，下午7:00收班。\n" +
                    "\n" +
                    "也可在市区乘坐市域轨道交通成灌线（成灌快铁），分段计价，最高票价为15元。\n" +
                    "成都东客站有直达都江堰市客运中心汽车，但每天只有一班在下午3:00左右发车，大约2小时到达。\n" +
                    "成都双流国际机场客运站已于2013年开通至都江堰地面运输班线，该班线的开通填补了成都以西没有直达机场班线的空白，为该区域的旅客直达机场提供了一种快捷的方式，同时也满足了机场到港旅客前往都江堰、青城山一线的出行需求。\n" +
                    "成都至都江堰班线目前处于试运行阶段，每天有6个班次从机场发往都江堰，发班时间分别为11:20、12:30、13:30、14:20、15:20、17：00，都江堰有8个班次发往机场，发车时间为9:45、10:35、11:25、12:20、13:30、14:30、15:40、17:10，全程票价为24元。\n" +
                    "乘车地点：双流机场1号航站楼与2号航站楼之间（原支线航站楼出港厅）。线路、站点、时刻的调整以成都双流国际机场调度站公布信息为准，可查询成都双流国际机场官方网站。\n" +
                    "市区内有便捷的公共交通，乘公交车游客可以很方便地到达各个旅游景点。另外市区内有绿色无污染的出租车，价格便宜。如果你想领略市区内的风采，还可以乘坐人力三轮车。";
            List<News> newsList =new ArrayList<>();
            News news1 = new News("地理",content1, R.drawable.simpknow_1);
            News news2 = new News("河流",content2, R.drawable.simpknow_2);
            News news3 = new News("历史",content3, R.drawable.simpknow_3);
            News news4 = new News("文化",content4, R.drawable.simpknow_4);
            News news5 = new News("民俗",content5, R.drawable.simpknow_5);
            News news6 = new News("乡村",content6, R.drawable.simpknow_6);
            News news7 = new News("旅游资源",content7, R.drawable.simpknow_7);
            newsList.add(news1);
            newsList.add(news2);
            newsList.add(news3);
            newsList.add(news4);
            newsList.add(news5);
            newsList.add(news6);
            newsList.add(news7);




            MyAdapter newsadapter = new MyAdapter(newsList);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(newsadapter);

        }
        @Override
        public void initData() {
            // 加载数据
        }
    }

//    精彩活动
    public static class ActicityFragment extends BaseFragment {
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

    public static class TicketFragment extends BaseFragment {
        private TextView tvBirthday; // 出生年月日显示文本框
        private Button btnSelectDate; // 选择日期按钮
        // 定义日历变量，用于获取当前日期
        private Calendar calendar;
        private DatePickerDialog datePickerDialog;
        private NumberPicker numberPicker;
        public int getLayoutResId() {
            return R.layout.fragment_ticket;
        }
        public void initView(View rootView) {
            // 初始化视图组件
            //数量选择器
            numberPicker = rootView.findViewById(R.id.number_picker);

            // 设置数量选择器的最小值和最大值
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue(10);
            //时间选择器
            tvBirthday = rootView.findViewById(R.id.tvBirthday);
            btnSelectDate=rootView.findViewById(R.id.btnSelectDate);
            // 初始化日历变量，获取当前日期
            calendar = Calendar.getInstance();

            // 设置出生年月日显示文本框的默认值为当前日期，格式为年/月/日
            tvBirthday.setText(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH));

            // 设置选择日期按钮的点击事件监听器，弹出日期选择对话框，让用户选择出生年月日
            btnSelectDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 初始化日期选择对话框，参数为当前活动、监听器、年、月、日
                    datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // 当用户选择日期后，更新出生年月日显示文本框的值，格式为年/月/日
                            tvBirthday.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                        }
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.show(); // 显示日期选择对话框
                }
            });
        }
        public void initData() {
            // 加载数据
        }
    }
}

