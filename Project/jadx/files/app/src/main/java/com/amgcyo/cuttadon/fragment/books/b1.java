package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.bookcity.MkThemeDetailActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListBean;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: MkShudanlistFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class b1 extends BaseRefreshMoreRecyclerFragment<BookPresenter> implements BaseQuickAdapter.g {
    private int K;
    ThemeBookListBean L;
    List<ShudanListData> M = new ArrayList();

    private void a(List<ShudanListData> list, int i2) {
        if (this.H == 1) {
            this.M.clear();
            for (ShudanListData shudanListData : list) {
                shudanListData.setItemType(2);
                this.M.add(shudanListData);
            }
            this.G.b((Collection) this.M);
        } else {
            Iterator<ShudanListData> it = list.iterator();
            while (it.hasNext()) {
                it.next().setItemType(2);
            }
            this.G.a((Collection) list);
        }
        this.G.m();
        if (this.J >= i2) {
            this.H++;
        } else {
            this.G.n();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        p();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            this.L = (ThemeBookListBean) message.f21202x;
            ThemeBookListBean themeBookListBean = this.L;
            if (themeBookListBean != null) {
                this.I = themeBookListBean.getLimit();
                List<ShudanListData> lists = this.L.getLists();
                this.J = lists.size();
                a(lists, this.I);
                c(false);
                return;
            }
            if (this.H <= 1) {
                showEmpty();
                return;
            }
            BaseQuickAdapter baseQuickAdapter = this.G;
            if (baseQuickAdapter != null) {
                baseQuickAdapter.n();
            }
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.G = new com.amgcyo.cuttadon.adapter.other.n(this.f3728w);
        this.G.c(1);
        this.G.a(this.recyclerView);
        this.G.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.fragment.books.p0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.o();
            }
        }, this.recyclerView);
        this.G.a((BaseQuickAdapter.g) this);
        com.amgcyo.cuttadon.f.o.a(this.recyclerView, 0, com.amgcyo.cuttadon.utils.otherutils.n.a(15.0f), 0, 0);
        this.recyclerView.addOnScrollListener(new com.amgcyo.cuttadon.f.q(this.f3725t));
    }

    public /* synthetic */ void o() {
        String str = "加载更多: " + this.H;
        p();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        ShudanListData shudanListData;
        String path;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.M) || (shudanListData = this.M.get(i2)) == null || (path = shudanListData.getPath()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("theme_path", path);
        bundle.putBoolean("theme_base_info", false);
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, bundle, MkThemeDetailActivity.class);
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        p();
    }

    public void p() {
        ((BookPresenter) this.f3726u).s(Message.a(this, new Object[]{Integer.valueOf(this.K), Integer.valueOf(this.H)}));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    public void a(@Nullable Object obj) {
        this.K = ((Integer) obj).intValue();
    }
}
