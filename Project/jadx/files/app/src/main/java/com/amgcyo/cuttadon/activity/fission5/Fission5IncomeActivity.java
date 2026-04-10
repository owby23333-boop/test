package com.amgcyo.cuttadon.activity.fission5;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.popupview.WebViewPopupView;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Fission5IncomeActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.ll_tx)
    LinearLayout ll_tx;

    @BindView(R.id.tab_layout)
    XTabLayout mTabLayout;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private int f2504n0 = 2;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private List<Fragment> f2505o0 = new ArrayList();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    String f2506p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    String f2507q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private SparseArray<String> f2508r0;

    @BindView(R.id.tv_type)
    TextView tvMoneyGolde;

    @BindView(R.id.tv_earnings)
    TextView tv_earnings;

    @BindView(R.id.tv_money_type)
    TextView tv_money_type;

    class a implements XTabLayout.d {
        a() {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.XTabLayout.d
        public void a(XTabLayout.g gVar) {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.XTabLayout.d
        public void b(XTabLayout.g gVar) {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.XTabLayout.d
        public void c(XTabLayout.g gVar) {
            if (TextUtils.isEmpty(Fission5IncomeActivity.this.f2506p0) || TextUtils.isEmpty(Fission5IncomeActivity.this.f2507q0)) {
                return;
            }
            if (gVar.d() == 0) {
                Fission5IncomeActivity.this.tv_money_type.setText("金币收益(个)");
                Fission5IncomeActivity fission5IncomeActivity = Fission5IncomeActivity.this;
                fission5IncomeActivity.tvMoneyGolde.setText(String.valueOf(fission5IncomeActivity.f2506p0));
                Fission5IncomeActivity.this.mViewPager.setCurrentItem(0);
                return;
            }
            Fission5IncomeActivity.this.tv_money_type.setText("现金收益(元)");
            Fission5IncomeActivity fission5IncomeActivity2 = Fission5IncomeActivity.this;
            fission5IncomeActivity2.tvMoneyGolde.setText(fission5IncomeActivity2.f2507q0);
            Fission5IncomeActivity.this.mViewPager.setCurrentItem(1);
        }
    }

    class b extends FragmentPagerAdapter {
        b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Fission5IncomeActivity.this.f2505o0.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) Fission5IncomeActivity.this.f2505o0.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return (CharSequence) Fission5IncomeActivity.this.f2508r0.get(i2);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity<UserPresenter> a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "我的收益";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2504n0 = extras.getInt("type_id");
        this.D.setVisibility(0);
        final String strD = o.d(R.string.sysm);
        this.D.setText(strD);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2542s.a(strD, view);
            }
        });
        this.f2508r0 = new SparseArray<>();
        this.f2508r0.put(0, "金币收益");
        this.f2508r0.put(1, "现金收益");
        this.f2505o0.add(com.amgcyo.cuttadon.fragment.fission5.e.c(1));
        this.f2505o0.add(com.amgcyo.cuttadon.fragment.fission5.e.c(2));
        int size = this.f2508r0.size();
        for (int i2 = 0; i2 < size; i2++) {
            XTabLayout xTabLayout = this.mTabLayout;
            XTabLayout.g gVarA = xTabLayout.a();
            gVarA.a(this.f2508r0.get(i2));
            xTabLayout.a(gVarA);
        }
        this.mViewPager.setOffscreenPageLimit(2);
        this.mViewPager.setAdapter(new b(getSupportFragmentManager()));
        if (this.f2504n0 == 1) {
            this.mViewPager.setCurrentItem(0);
        } else {
            this.mViewPager.setCurrentItem(1);
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            com.amgcyo.cuttadon.widget.ui.a aVar = new com.amgcyo.cuttadon.widget.ui.a(this.mViewPager.getContext(), new LinearOutSlowInInterpolator());
            declaredField.set(this.mViewPager, aVar);
            aVar.a(200);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mTabLayout.setSelectedTabIndicatorWidth((int) (n.d(this) / 2.0f));
        this.mTabLayout.a(new a());
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.income5_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.ll_tx, R.id.tv_earnings})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.ll_tx) {
            r0.c(this.f2277w);
        }
    }

    public void setTextData(String str, String str2, String str3, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (i2 == 1) {
            this.tv_money_type.setText("金币收益(个)");
            this.tvMoneyGolde.setText(String.valueOf(str2));
        } else {
            this.tv_money_type.setText("现金收益(元)");
            this.tvMoneyGolde.setText(str3);
        }
        this.f2506p0 = str2;
        this.f2507q0 = str3;
        String str4 = "累计收益 " + str + "元";
        SpannableString spannableString = new SpannableString(str4);
        spannableString.setSpan(new ForegroundColorSpan(o.b(R.color.color_9B9B9B)), 0, 4, 17);
        spannableString.setSpan(new ForegroundColorSpan(o.b(R.color.color_FF5E01)), 4, str4.length(), 17);
        this.tv_earnings.setText(spannableString);
        this.ll_tx.setVisibility(0);
    }

    public /* synthetic */ void a(String str, View view) {
        String strE = com.amgcyo.cuttadon.utils.otherutils.g.e("earnings");
        String str2 = "earnings: " + strE;
        WebViewPopupView webViewPopupView = new WebViewPopupView(this.f2277w, strE, str);
        a.b bVar = new a.b(this.f2277w);
        bVar.b(true);
        bVar.d(false);
        bVar.e(true);
        bVar.a((BasePopupView) webViewPopupView);
        webViewPopupView.u();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
