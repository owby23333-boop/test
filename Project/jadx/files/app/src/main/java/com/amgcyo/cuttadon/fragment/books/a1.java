package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.MkAddBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkAddBookHisBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: MkRequestBookHisFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class a1 extends BaseRefreshMoreRecyclerFragment<UserPresenter> implements BaseQuickAdapter.g {
    List<MkAddBookHisBean> K;
    private List<MkAddBookHisBean> L = new ArrayList();
    private MkUser M;

    private void a(List<MkAddBookHisBean> list, int i2) {
        if (this.H == 1) {
            this.K.clear();
            for (MkAddBookHisBean mkAddBookHisBean : list) {
                mkAddBookHisBean.setItemType(2);
                this.K.add(mkAddBookHisBean);
            }
            this.G.b((Collection) this.K);
        } else {
            this.L.clear();
            for (MkAddBookHisBean mkAddBookHisBean2 : list) {
                mkAddBookHisBean2.setItemType(2);
                this.L.add(mkAddBookHisBean2);
            }
            this.G.a((Collection) this.L);
        }
        this.G.m();
        if (this.K.size() >= i2) {
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
            MkAddBookBean mkAddBookBean = (MkAddBookBean) message.f21202x;
            List<MkAddBookHisBean> lists = mkAddBookBean.getLists();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(lists)) {
                if (this.H == 1) {
                    showEmpty();
                    return;
                } else {
                    this.G.n();
                    return;
                }
            }
            if (this.K == null) {
                this.K = new ArrayList();
            }
            if (this.L == null) {
                this.L = new ArrayList();
            }
            showLoadSuccess();
            int limit = mkAddBookBean.getLimit();
            this.recyclerView.setItemViewCacheSize(lists.size());
            a(lists, limit);
            c(false);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.G = new com.amgcyo.cuttadon.b.c.m(this.K);
        this.G.a(this.recyclerView);
        this.G.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.fragment.books.o0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.o();
            }
        }, this.recyclerView);
        this.G.a((BaseQuickAdapter.g) this);
        l();
    }

    public /* synthetic */ void o() {
        String str = "加载更多: " + this.H;
        p();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkAddBookHisBean mkAddBookHisBean;
        BaseQuickAdapter baseQuickAdapter2 = this.G;
        if (baseQuickAdapter2 == null || (mkAddBookHisBean = (MkAddBookHisBean) baseQuickAdapter2.getItem(i2)) == null) {
            return;
        }
        if (mkAddBookHisBean.getBook_id() > 0) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, mkAddBookHisBean.getBook_id(), mkAddBookHisBean.getForm());
        } else if (TextUtils.isEmpty(mkAddBookHisBean.getMsg())) {
            showMessage("该书还在处理中!请耐心等待...");
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        p();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.M = com.amgcyo.cuttadon.utils.otherutils.g.j();
    }

    public void p() {
        if (this.M != null) {
            ((UserPresenter) this.f3726u).e(Message.a(this, new Object[]{Integer.valueOf(this.H)}));
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
            c(false);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
