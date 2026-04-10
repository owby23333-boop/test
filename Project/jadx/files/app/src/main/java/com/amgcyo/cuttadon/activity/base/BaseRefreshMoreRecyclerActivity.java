package com.amgcyo.cuttadon.activity.base;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.j.itemdecoration.a;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import me.jessyan.art.mvp.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRefreshMoreRecyclerActivity<P extends me.jessyan.art.mvp.c> extends BaseTitleBarActivity implements PullToRefreshView.j {

    @Nullable
    @BindView(R.id.fl_ad)
    protected AdFrameLayout adFrameLayout;

    @Nullable
    @BindView(R.id.ll_list_root)
    protected LinearLayout ll_list_root;

    @BindView(R.id.swipe_refresh_layout)
    protected PullToRefreshView mRefreshView;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected BaseQuickAdapter f2256n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected int f2257o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected int f2258p0;
    public int pageNo = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected String f2259q0 = "没有更多数据了😘";

    @BindView(android.R.id.list)
    protected RecyclerView recyclerView;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    protected void b(String str, int i2) {
        View viewA;
        if (this.f2256n0 == null || (viewA = a(str, i2)) == null) {
            return;
        }
        this.f2256n0.d(viewA);
    }

    protected void c(boolean z2) {
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setEnabled(z2);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    protected void d(boolean z2) {
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(z2);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        NormalAdParams normalAdParamsA;
        String str = "particularAd: " + p();
        if (!p() && (normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_lists", "csj_new_position_lists")) != null && this.adFrameLayout != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.C);
            this.adFrameLayout.b(normalAdParamsA);
        }
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.f2277w));
        this.recyclerView.setItemAnimator(null);
        this.mRefreshView.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.measure(0, 0);
        this.mRefreshView.setRefreshing(true);
        this.mRefreshView.setOnRefreshListener(this);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.fragment_list;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    public abstract void loadData();

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    protected void n() {
        a.b bVar = new a.b(this.f2277w);
        bVar.c(R.dimen.dimen10dp);
        bVar.b(R.color.vip_root_bg);
        this.recyclerView.addItemDecoration(bVar.a());
    }

    protected void o() {
        int iB = com.amgcyo.cuttadon.f.o.b(R.color.color_titlebar);
        me.jessyan.art.f.h.c(this, iB);
        me.jessyan.art.f.h.d(this, iB);
        this.f2279y.setBackgroundColor(iB);
        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.white);
        if (colorStateList != null) {
            this.C.setColorFilter(colorStateList);
        } else {
            this.C.setImageResource(R.drawable.fission5_back);
        }
        this.B.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.white));
        this.recyclerView.setItemAnimator(null);
        LinearLayout linearLayout = this.ll_list_root;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.vip_root_bg));
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        this.pageNo = 1;
        d(true);
    }

    protected abstract boolean p();
}
