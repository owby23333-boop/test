package com.amgcyo.cuttadon.fragment.books;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.bookcity.MkClassifyActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkRanIndexActivity;
import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyBean;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.SimpleMarqueeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkBookStoreFragment extends com.amgcyo.cuttadon.fragment.base.a {
    private List<Fragment> G = new ArrayList();
    private int H = 0;
    private int I = com.amgcyo.cuttadon.utils.otherutils.n.a(320.0f);
    private int J = 1;

    @BindView(R.id.banner1_head)
    RelativeLayout banner1_head;

    @BindView(R.id.banner2_head)
    LinearLayout banner2_head;

    @BindView(R.id.img_banner1)
    ImageView img_banner1;

    @BindView(R.id.img_banner2)
    ImageView img_banner2;

    @BindView(R.id.img_fenlei)
    ImageView img_fenlei;

    @BindView(R.id.img_rank)
    ImageView img_rank;

    @BindView(R.id.marqueerewardview)
    SimpleMarqueeView marqueerewardview;

    @BindView(R.id.rl_fenlei)
    RelativeLayout rl_fenlei;

    @BindView(R.id.rl_rank)
    RelativeLayout rl_rank;

    @BindView(R.id.rl_search)
    RelativeLayout rl_search;

    @BindView(R.id.tb_select_banner1)
    XTabLayout tb_select_banner1;

    @BindView(R.id.tb_select_banner2)
    XTabLayout tb_select_banner2;

    @BindView(R.id.tv_fenlei)
    TextView tv_fenlei;

    @BindView(R.id.tv_rank)
    TextView tv_rank;

    @BindView(R.id.vp_classify)
    ViewPager vp_classify;

    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            MkJingXuanFragment mkJingXuanFragment;
            MkBookStoreFragment.this.J = 1;
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) MkBookStoreFragment.this.G) && (mkJingXuanFragment = (MkJingXuanFragment) MkBookStoreFragment.this.G.get(i2)) != null) {
                MkBookStoreFragment.this.J = mkJingXuanFragment.I;
                if (3 == MkBookStoreFragment.this.J) {
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY_TAB]MH");
                } else {
                    String str = mkJingXuanFragment.H;
                    if (!TextUtils.isEmpty(str)) {
                        byte b = -1;
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1278174388) {
                            if (iHashCode != 3343885) {
                                if (iHashCode == 100346066 && str.equals("index")) {
                                    b = 0;
                                }
                            } else if (str.equals("male")) {
                                b = 1;
                            }
                        } else if (str.equals("female")) {
                            b = 2;
                        }
                        if (b == 0) {
                            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY_TAB]精选");
                        } else if (b == 1) {
                            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY_TAB]男生");
                        } else if (b == 2) {
                            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY_TAB]女生");
                        }
                    }
                }
            }
            MkBookStoreFragment.this.H = ((MkJingXuanFragment) MkBookStoreFragment.this.G.get(0)).M;
            if (MkBookStoreFragment.this.o()) {
                MkBookStoreFragment.this.tb_select_banner1.a(0, 0);
                MkBookStoreFragment.this.tb_select_banner1.setSelectedTabIndicatorColor(0);
            } else {
                MkBookStoreFragment.this.tb_select_banner2.a(0, 0);
                MkBookStoreFragment.this.tb_select_banner2.setSelectedTabIndicatorColor(0);
            }
            MkBookStoreFragment mkBookStoreFragment = MkBookStoreFragment.this;
            mkBookStoreFragment.a(mkBookStoreFragment.H, "book_store", MkBookStoreFragment.this.D);
        }
    }

    private void l() {
        com.amgcyo.cuttadon.utils.otherutils.r0.c(this.f3725t, this.J);
        com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY]搜索");
    }

    private void m() {
        if (this.marqueerewardview != null) {
            ArrayList arrayList = new ArrayList();
            String strA = com.amgcyo.cuttadon.utils.comic.d.a("hot_keyword", "");
            if (!TextUtils.isEmpty(strA)) {
                List listB = com.amgcyo.cuttadon.utils.otherutils.r.b(strA, SearchHotkeyBean.class);
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
                    Iterator it = listB.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((SearchHotkeyBean) it.next()).getKeyWord());
                    }
                }
            }
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
                arrayList.add("点击此处进行搜索~");
            }
            com.gongwen.marqueen.b bVar = new com.gongwen.marqueen.b(this.f3725t);
            bVar.a((List) arrayList);
            this.marqueerewardview.setMarqueeFactory(bVar);
            this.marqueerewardview.setOnItemClickListener(new com.gongwen.marqueen.d.b() { // from class: com.amgcyo.cuttadon.fragment.books.m
                @Override // com.gongwen.marqueen.d.b
                public final void a(View view, Object obj, int i2) {
                    this.a.a(view, obj, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        return com.amgcyo.cuttadon.utils.otherutils.h.E0();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "goto_book_city_by_type")
    private void subscriberViewPagerItem(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent == null || this.vp_classify == null || com.amgcyo.cuttadon.utils.otherutils.g.a(this.G)) {
            return;
        }
        int iF = mkCommentEvent.f();
        int size = 0;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.G) && 3 == iF) {
            size = this.G.size() - 1;
        }
        String str = "pos:" + size;
        this.vp_classify.setCurrentItem(size);
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.bookstore_fragment;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        String[] strArr;
        super.f();
        com.amgcyo.cuttadon.h.a.h.a(this.f3725t, "book_city");
        int iH = com.amgcyo.cuttadon.utils.otherutils.g.h();
        this.G.add(MkJingXuanFragment.c("index"));
        if (iH == 1) {
            this.G.add(MkJingXuanFragment.c("male"));
            this.G.add(MkJingXuanFragment.c("female"));
            if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
                strArr = new String[]{"精选 ", "男生 ", "女生 "};
            } else {
                this.G.add(MkJingXuanFragment.c("comics"));
                strArr = new String[]{"精选 ", "男生 ", "女生 ", "漫画 "};
            }
        } else {
            this.G.add(MkJingXuanFragment.c("female"));
            this.G.add(MkJingXuanFragment.c("male"));
            if (com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
                strArr = new String[]{"精选 ", "女生 ", "男生 "};
            } else {
                this.G.add(MkJingXuanFragment.c("comics"));
                strArr = new String[]{"精选 ", "女生 ", "男生 ", "漫画 "};
            }
        }
        this.J = 1;
        this.vp_classify.setOffscreenPageLimit(strArr.length);
        this.vp_classify.setAdapter(new com.amgcyo.cuttadon.adapter.other.e(getChildFragmentManager(), strArr, this.G));
        this.vp_classify.addOnPageChangeListener(new a());
        if (o()) {
            XTabLayout xTabLayout = this.tb_select_banner1;
            if (xTabLayout != null) {
                xTabLayout.setupWithViewPager(this.vp_classify);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(new Throwable("widget is null " + this.D), "store_fragment");
            }
        } else {
            XTabLayout xTabLayout2 = this.tb_select_banner2;
            if (xTabLayout2 != null) {
                xTabLayout2.setupWithViewPager(this.vp_classify);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(new Throwable("widget is null " + this.D), "store_fragment");
            }
        }
        if (o()) {
            return;
        }
        m();
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        if (o()) {
            this.banner1_head.setVisibility(0);
            this.banner2_head.setVisibility(8);
        } else {
            this.banner1_head.setVisibility(8);
            this.banner2_head.setVisibility(0);
        }
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.B = me.jessyan.art.f.h.a(this.f3725t);
        RelativeLayout relativeLayout = this.banner1_head;
        if (relativeLayout != null) {
            relativeLayout.setPadding(0, this.B, 0, 0);
        }
        LinearLayout linearLayout = this.banner2_head;
        if (linearLayout != null) {
            linearLayout.setPadding(0, this.B + com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f), 0, 0);
        }
    }

    @OnClick({R.id.img_banner1, R.id.rl_search, R.id.rl_fenlei, R.id.rl_rank})
    public void onClick(View view) {
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        if (this.f3725t == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.img_banner1 /* 2131297096 */:
            case R.id.rl_search /* 2131298268 */:
                l();
                break;
            case R.id.rl_fenlei /* 2131298258 */:
                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkClassifyActivity.class);
                com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY]分类");
                break;
            case R.id.rl_rank /* 2131298266 */:
                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkRanIndexActivity.class);
                com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[CITY]排行");
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.stopFlipping();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.startFlipping();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        Context context;
        super.setUserVisibleHint(z2);
        this.D = z2;
        if (!z2 || this.H > 0 || (context = this.f3725t) == null) {
            return;
        }
        me.jessyan.art.f.h.b((Activity) context);
    }

    public /* synthetic */ void a(View view, Object obj, int i2) {
        l();
    }

    void a(int i2, String str, boolean z2) {
        this.H = i2;
        if (!"index".equals(str) || z2) {
            if (i2 <= 0) {
                int iArgb = Color.argb(0, 255, 255, 255);
                int iB = com.amgcyo.cuttadon.f.o.b(R.color.color_F6F6F6);
                if (o()) {
                    this.tb_select_banner1.a(iB, iB);
                    this.tb_select_banner1.setSelectedTabIndicatorColor(iB);
                } else {
                    this.tb_select_banner2.a(iB, iB);
                    this.tb_select_banner2.setSelectedTabIndicatorColor(iB);
                }
                if (this.D) {
                    me.jessyan.art.f.h.b((Activity) this.f3725t);
                }
                if (o()) {
                    this.banner1_head.setBackgroundColor(iArgb);
                    this.img_banner1.setColorFilter(iB);
                    return;
                }
                this.banner2_head.setBackgroundColor(iArgb);
                this.marqueerewardview.setTextColor(iB);
                this.tv_fenlei.setTextColor(iB);
                this.tv_rank.setTextColor(iB);
                this.img_banner2.setColorFilter(iB);
                this.img_fenlei.setColorFilter(iB);
                this.img_rank.setColorFilter(iB);
                int iB2 = com.amgcyo.cuttadon.f.o.b(R.color.color_500000);
                GradientDrawable gradientDrawable = (GradientDrawable) this.rl_search.getBackground();
                GradientDrawable gradientDrawable2 = (GradientDrawable) this.rl_rank.getBackground();
                GradientDrawable gradientDrawable3 = (GradientDrawable) this.rl_fenlei.getBackground();
                gradientDrawable.setColor(iB2);
                gradientDrawable2.setColor(iB2);
                gradientDrawable3.setColor(iB2);
                this.rl_search.setBackground(gradientDrawable);
                this.rl_rank.setBackground(gradientDrawable2);
                this.rl_fenlei.setBackground(gradientDrawable3);
                return;
            }
            int i3 = this.I;
            if (i2 <= i3) {
                int i4 = (int) ((i2 / i3) * 255.0f);
                int iArgb2 = Color.argb(i4, 51, 51, 51);
                if (o()) {
                    this.tb_select_banner1.a(iArgb2, iArgb2);
                    this.tb_select_banner1.setSelectedTabIndicatorColor(iArgb2);
                } else {
                    this.tb_select_banner2.a(iArgb2, iArgb2);
                    this.tb_select_banner2.setSelectedTabIndicatorColor(iArgb2);
                }
                int iArgb3 = Color.argb(i4, 255, 255, 255);
                me.jessyan.art.f.h.a((Activity) this.f3725t);
                if (o()) {
                    this.img_banner1.setColorFilter(iArgb2);
                    this.banner1_head.setBackgroundColor(iArgb3);
                    return;
                }
                this.banner2_head.setBackgroundColor(iArgb3);
                this.img_banner2.setColorFilter(iArgb2);
                this.marqueerewardview.setTextColor(iArgb2);
                this.tv_fenlei.setTextColor(iArgb2);
                this.tv_rank.setTextColor(iArgb2);
                this.img_banner2.setColorFilter(iArgb2);
                this.img_fenlei.setColorFilter(iArgb2);
                this.img_rank.setColorFilter(iArgb2);
                return;
            }
            int iArgb4 = Color.argb(255, 255, 255, 255);
            int iArgb5 = Color.argb(255, 51, 51, 51);
            if (o()) {
                this.tb_select_banner1.a(iArgb5, iArgb5);
                this.tb_select_banner1.setSelectedTabIndicatorColor(iArgb5);
            } else {
                this.tb_select_banner2.a(iArgb5, iArgb5);
                this.tb_select_banner2.setSelectedTabIndicatorColor(iArgb5);
            }
            if (o()) {
                this.banner1_head.setBackgroundColor(iArgb4);
                return;
            }
            this.banner2_head.setBackgroundColor(iArgb4);
            int iB3 = com.amgcyo.cuttadon.f.o.b(R.color.color_3E3E3E);
            this.marqueerewardview.setTextColor(iB3);
            this.tv_fenlei.setTextColor(iB3);
            this.tv_rank.setTextColor(iB3);
            this.img_banner2.setColorFilter(iB3);
            this.img_fenlei.setColorFilter(iB3);
            this.img_rank.setColorFilter(iB3);
            GradientDrawable gradientDrawable4 = (GradientDrawable) this.rl_search.getBackground();
            GradientDrawable gradientDrawable5 = (GradientDrawable) this.rl_rank.getBackground();
            GradientDrawable gradientDrawable6 = (GradientDrawable) this.rl_fenlei.getBackground();
            int iB4 = com.amgcyo.cuttadon.f.o.b(R.color.color_5_0c000000);
            gradientDrawable4.setColor(iB4);
            gradientDrawable5.setColor(iB4);
            gradientDrawable6.setColor(iB4);
            this.rl_search.setBackground(gradientDrawable4);
            this.rl_rank.setBackground(gradientDrawable5);
            this.rl_fenlei.setBackground(gradientDrawable6);
        }
    }
}
