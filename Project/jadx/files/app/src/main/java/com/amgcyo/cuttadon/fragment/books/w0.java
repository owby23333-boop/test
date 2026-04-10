package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkEndBookActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: EndHotCommentFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class w0 extends BaseRefreshMoreRecyclerFragment<BookPresenter> implements BaseQuickAdapter.g {
    private int L;
    private List<MkBook> K = new ArrayList();
    private int M = 1;

    public static w0 a(int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("type_id", i2);
        bundle.putInt(ArticleInfo.USER_SEX, i3);
        w0 w0Var = new w0();
        w0Var.setArguments(bundle);
        return w0Var;
    }

    private void p() {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_book_city_end_index", "csj_new_position_lists");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.F);
            this.adFrameLayout.b(normalAdParamsA);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        p();
        this.L = arguments.getInt("type_id");
        this.M = arguments.getInt(ArticleInfo.USER_SEX);
        if (this.L > 0) {
            o();
            return;
        }
        showMessage(com.amgcyo.cuttadon.f.o.d(R.string.code_id_error_params));
        FragmentActivity activity = getActivity();
        if (activity instanceof MkEndBookActivity) {
            activity.finish();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        this.mRefreshView.setRefreshing(false);
        this.mRefreshView.setEnabled(false);
        if (message.f21197s == 902) {
            this.K = (List) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.K)) {
                showEmpty();
                return;
            }
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(com.amgcyo.cuttadon.f.n.P);
            if (newApiAdA != null) {
                try {
                    this.K.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.G.b((Collection) this.K);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.G = new com.amgcyo.cuttadon.adapter.comic.d(this.K, this.f3728w);
        this.recyclerView.setAdapter(this.G);
    }

    public void o() {
        ((BookPresenter) this.f3726u).o(Message.a(this, new Object[]{Integer.valueOf(this.M), String.valueOf(this.L)}));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.K) || this.f3725t == null || (mkBook = this.K.get(i2)) == null) {
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, mkBook.getBook_id(), mkBook.getForm());
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
