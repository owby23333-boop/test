package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkQiushuFragemnt extends com.amgcyo.cuttadon.fragment.base.a {
    private List<Fragment> G = new ArrayList();
    private int H;
    private a1 I;
    private MkRequestBookFragment J;

    @BindView(R.id.head)
    RelativeLayout head;

    @BindView(R.id.tb_select)
    XTabLayout tb_select;

    @BindView(R.id.vp_classify)
    ViewPager vp_classify;

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.qiushu_fragment;
    }

    public void a(@Nullable Object obj) {
        if (obj instanceof Integer) {
            this.H = ((Integer) obj).intValue();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        ViewPager viewPager;
        super.f();
        this.J = new MkRequestBookFragment();
        this.G.add(this.J);
        this.I = new a1();
        this.G.add(this.I);
        this.vp_classify.setOffscreenPageLimit(com.amgcyo.cuttadon.f.n.f3694h.length);
        this.vp_classify.setAdapter(new com.amgcyo.cuttadon.adapter.other.e(getChildFragmentManager(), com.amgcyo.cuttadon.f.n.f3694h, this.G));
        this.tb_select.setupWithViewPager(this.vp_classify);
        if (this.H <= 0 || (viewPager = this.vp_classify) == null) {
            return;
        }
        viewPager.setCurrentItem(1);
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
    }

    public void l() {
        MkRequestBookFragment mkRequestBookFragment = this.J;
        if (mkRequestBookFragment != null) {
            mkRequestBookFragment.m();
        }
    }

    public void m() {
        ViewPager viewPager = this.vp_classify;
        if (viewPager == null || this.I == null) {
            return;
        }
        viewPager.setCurrentItem(1);
        this.I.onRefresh();
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
        RelativeLayout relativeLayout = this.head;
        if (relativeLayout != null) {
            relativeLayout.setPadding(0, this.B, 0, 0);
        }
    }
}
