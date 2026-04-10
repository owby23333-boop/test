package com.amgcyo.cuttadon.fragment.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.j.itemdecoration.a;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import me.jessyan.art.mvp.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRefreshMoreRecyclerFragment<P extends c> extends a implements PullToRefreshView.j {
    protected BaseQuickAdapter G;
    public int H = 1;
    protected int I;
    protected int J;

    @BindView(R.id.fl_ad)
    protected AdFrameLayout adFrameLayout;

    @BindView(R.id.swipe_refresh_layout)
    protected PullToRefreshView mRefreshView;

    @BindView(android.R.id.list)
    protected RecyclerView recyclerView;

    private View b(String str, int i2) {
        View viewInflate;
        Context context = this.f3725t;
        if (context == null || (viewInflate = ((Activity) context).getLayoutInflater().inflate(R.layout.layout_empty_list, (ViewGroup) null)) == null) {
            return null;
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.empty_iv);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_empty_msg);
        if (TextUtils.isEmpty(str)) {
            str = "暂无数据";
        }
        if (i2 == 0) {
            i2 = R.mipmap.icon_withdraw_empty;
        }
        textView.setText(str);
        imageView.setImageResource(i2);
        return viewInflate;
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_list;
    }

    protected void a(String str, int i2) {
        View viewB;
        if (this.G == null || (viewB = b(str, i2)) == null) {
            return;
        }
        this.G.d(viewB);
    }

    protected void c(boolean z2) {
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(z2);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.f3725t));
        this.recyclerView.setItemAnimator(null);
        if (m()) {
            this.mRefreshView.setColorSchemeColors(g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
            this.mRefreshView.measure(0, 0);
            this.mRefreshView.setRefreshing(true);
            this.mRefreshView.setOnRefreshListener(this);
        }
        this.adFrameLayout.setVisibility(8);
    }

    protected void l() {
        a.b bVar = new a.b(this.f3725t);
        bVar.c(R.dimen.dimen0_5dp);
        bVar.e(R.dimen.dimen0_5dp);
        bVar.b(R.color.dddddd);
        bVar.d(R.dimen.dimen15dp);
        bVar.f(R.dimen.dimen15dp);
        this.recyclerView.addItemDecoration(bVar.a());
    }

    protected boolean m() {
        return true;
    }

    @Nullable
    public c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        this.H = 1;
        c(true);
    }

    protected void b(boolean z2) {
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setEnabled(z2);
        }
    }
}
