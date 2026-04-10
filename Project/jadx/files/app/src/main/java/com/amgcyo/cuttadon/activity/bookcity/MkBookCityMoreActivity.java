package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.b.c.p;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkBookCityMoreActivity extends BaseRefreshMoreRecyclerActivity<BookPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<MkBook> f2309r0 = new ArrayList();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    int f2310s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    String f2311t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    String f2312u0;

    private void a(List<MkBook> list) {
        if (this.pageNo == 1) {
            this.f2309r0.clear();
            this.f2309r0.addAll(list);
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(n.M);
            if (newApiAdA != null) {
                try {
                    this.f2309r0.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f2256n0.b((Collection) this.f2309r0);
        } else {
            this.f2256n0.a((Collection) list);
        }
        this.f2256n0.m();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        d(false);
        if (message.f21197s == 825) {
            List<MkBook> list = (List) message.f21202x;
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                a(list);
                this.pageNo++;
            } else {
                if (this.pageNo == 1) {
                    showEmpty();
                    return;
                }
                BaseQuickAdapter baseQuickAdapter = this.f2256n0;
                if (baseQuickAdapter != null) {
                    baseQuickAdapter.a(this.f2259q0);
                    this.f2256n0.n();
                }
            }
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2310s0 = extras.getInt("key_multitle");
        this.f2311t0 = extras.getString("title");
        this.f2312u0 = extras.getString(ArticleInfo.USER_SEX);
        if (TextUtils.isEmpty(this.f2311t0) || TextUtils.isEmpty(this.f2312u0)) {
            showMessage("参数错误");
            finish();
            return;
        }
        this.recyclerView.setItemAnimator(null);
        this.f2256n0 = new p(this.f2309r0, this.G);
        this.recyclerView.setAdapter(this.f2256n0);
        this.f2256n0.a((BaseQuickAdapter.g) this);
        this.recyclerView.setItemAnimator(null);
        this.B.setText(this.f2311t0);
        this.f2256n0.c(1);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.bookcity.a
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.q();
            }
        }, this.recyclerView);
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        ((BookPresenter) this.f2276v).w(Message.a(this, new Object[]{this.f2312u0, Integer.valueOf(this.f2310s0), Integer.valueOf(this.pageNo), 825}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2309r0) || (mkBook = this.f2309r0.get(i2)) == null) {
            return;
        }
        r0.a(this.f2277w, mkBook.getBook_id(), mkBook.getForm());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ void q() {
        String str = "加载更多: " + this.pageNo;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }
}
