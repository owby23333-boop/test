package com.amgcyo.cuttadon.activity.search;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.SearchPresenter;
import com.amgcyo.cuttadon.b.c.p;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkNameResultActivity extends BaseRefreshMoreRecyclerActivity<SearchPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    String f2775r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    List<MkBook> f2776s0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "搜索结果";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 828) {
            this.f2776s0 = (List) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2776s0)) {
                showEmpty();
                return;
            }
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(n.L);
            if (newApiAdA != null) {
                try {
                    this.f2776s0.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f2256n0 = new p(this.f2776s0, this.G);
            this.recyclerView.setAdapter(this.f2256n0);
            c(false);
            d(false);
            this.f2256n0.a((BaseQuickAdapter.g) this);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2775r0 = extras.getString("book_name");
        ((SearchPresenter) this.f2276v).e(Message.a(this, new Object[]{this.f2775r0, 1}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2776s0)) {
            return;
        }
        try {
            MkBook mkBook = this.f2776s0.get(i2);
            if (mkBook == null) {
                return;
            }
            r0.a(this.f2277w, mkBook.getBook_id(), mkBook.getForm());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public SearchPresenter obtainPresenter() {
        return new SearchPresenter(me.jessyan.art.f.e.a(this));
    }
}
