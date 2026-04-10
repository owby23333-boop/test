package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.bookcity.BaseMaleFemaleBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkBookRankIndexFragment extends com.amgcyo.cuttadon.fragment.base.a<BookPresenter> implements BaseQuickAdapter.g {
    private int G;
    private List<BaseMaleFemaleBean> H;
    private List<MkBook> I = new ArrayList();
    private com.amgcyo.cuttadon.b.c.u J;
    private com.amgcyo.cuttadon.b.c.t K;
    private com.amgcyo.cuttadon.k.a.b L;
    private String M;

    @BindView(R.id.fl_ad)
    AdFrameLayout adFrameLayout;

    @BindView(R.id.left_rv_view)
    RecyclerView left_rv_view;

    @BindView(R.id.ll_line)
    LinearLayout ll_line;

    @BindView(R.id.swipe_refresh_layout)
    PullToRefreshView mRefreshView;

    @BindView(R.id.right_rv_view)
    RecyclerView right_rv_view;

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            showEmpty();
        } else {
            this.M = str;
            ((BookPresenter) this.f3726u).p(Message.a(this, new Object[]{Integer.valueOf(this.G), str}));
        }
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_rank_v4_list;
    }

    public void a(@Nullable Object obj) {
        this.G = ((Integer) obj).intValue();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_rank", "csj_new_position_lists");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.H);
            this.adFrameLayout.b(normalAdParamsA);
        }
        showLoading("努力加载中...");
        ((BookPresenter) this.f3726u).q(Message.a(this, new Object[]{Integer.valueOf(this.G)}));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        hideLoading();
        int i2 = message.f21197s;
        if (i2 == 825) {
            this.H = (List) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.H)) {
                showEmpty();
                return;
            }
            LinearLayout linearLayout = this.ll_line;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            BaseMaleFemaleBean baseMaleFemaleBean = this.H.get(0);
            this.M = baseMaleFemaleBean.getRank_id();
            this.J = new com.amgcyo.cuttadon.b.c.u();
            this.J.c(this.M);
            this.J.b((Collection) this.H);
            this.left_rv_view.setAdapter(this.J);
            this.mRefreshView.setRefreshing(false);
            this.mRefreshView.setEnabled(false);
            this.J.a((BaseQuickAdapter.g) this);
            c(baseMaleFemaleBean.getRank_id());
            return;
        }
        if (i2 == 902) {
            this.I = (List) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.I)) {
                if (this.L == null) {
                    this.L = new com.amgcyo.cuttadon.k.a.b(this.f3725t);
                    this.L.setStatus(4);
                }
                this.K.d(this.L);
                return;
            }
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(com.amgcyo.cuttadon.f.n.P);
            if (newApiAdA != null) {
                try {
                    this.I.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.K.b((Collection) this.I);
            this.mRefreshView.setRefreshing(false);
            this.mRefreshView.setEnabled(false);
            this.right_rv_view.scrollToPosition(0);
        }
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        this.left_rv_view.setLayoutManager(new LinearLayoutManager(this.f3725t));
        this.left_rv_view.setItemAnimator(null);
        this.right_rv_view.setLayoutManager(new LinearLayoutManager(this.f3725t));
        this.right_rv_view.setItemAnimator(null);
        this.K = new com.amgcyo.cuttadon.b.c.t(this.I, false, true, false, this.f3728w);
        this.right_rv_view.setAdapter(this.K);
        this.K.a((BaseQuickAdapter.g) this);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        BaseMaleFemaleBean baseMaleFemaleBean;
        if (baseQuickAdapter instanceof com.amgcyo.cuttadon.b.c.u) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.H) || (baseMaleFemaleBean = this.H.get(i2)) == null) {
                return;
            }
            this.J.c(baseMaleFemaleBean.getRank_id());
            c(baseMaleFemaleBean.getRank_id());
            return;
        }
        if (!(baseQuickAdapter instanceof com.amgcyo.cuttadon.b.c.t) || com.amgcyo.cuttadon.utils.otherutils.g.a(this.I) || (mkBook = this.I.get(i2)) == null) {
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, mkBook.getBook_id(), mkBook.getForm());
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
