package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import com.amgcyo.cuttadon.activity.bookcity.MkCategoryAllActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.bookcity.BookClassBean;
import com.amgcyo.cuttadon.api.entity.other.MkBookclassifyBean;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.drakeet.multitype.Items;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: BookclassifyFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends BaseRefreshMoreRecyclerFragment<BookPresenter> implements BaseQuickAdapter.g {
    private int K;
    List<MkBookclassifyBean> L = new ArrayList();

    public static v0 a(int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt(ArticleInfo.USER_SEX, i2);
        bundle.putInt("form", i3);
        v0 v0Var = new v0();
        v0Var.setArguments(bundle);
        return v0Var;
    }

    private void p() {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_book_city_class_index", "csj_new_position_lists");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.G);
            this.adFrameLayout.b(normalAdParamsA);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        p();
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            Items items = (Items) message.f21202x;
            if (items != null) {
                for (Object obj : items) {
                    if (obj instanceof BookClassBean) {
                        int i2 = this.K;
                        if (i2 == 1) {
                            this.L = ((BookClassBean) obj).getMale();
                        } else if (i2 == 2) {
                            this.L = ((BookClassBean) obj).getFemale();
                        } else if (i2 == 5) {
                            this.L = ((BookClassBean) obj).getComics();
                        }
                    }
                }
            }
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.L)) {
                showEmpty();
                return;
            }
            Iterator<MkBookclassifyBean> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().setItemType(2);
            }
            this.G.b((Collection) this.L);
            c(false);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void i() {
        super.i();
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.K = arguments.getInt(ArticleInfo.USER_SEX, 0);
        int i2 = arguments.getInt("form", 1);
        this.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.G = new com.amgcyo.cuttadon.adapter.other.f(this.L, this.f3728w, i2);
        this.recyclerView.setAdapter(this.G);
        this.G.a((BaseQuickAdapter.g) this);
    }

    public void o() {
        ((BookPresenter) this.f3726u).v(Message.a(this, new Object[0]));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBookclassifyBean mkBookclassifyBean;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.L) || (mkBookclassifyBean = this.L.get(i2)) == null) {
            return;
        }
        int ltype_id = mkBookclassifyBean.getLtype_id();
        String ltype_name = mkBookclassifyBean.getLtype_name();
        Bundle bundle = new Bundle();
        bundle.putInt(ArticleInfo.USER_SEX, this.K);
        bundle.putInt("ltype", ltype_id);
        bundle.putString("key_desc", mkBookclassifyBean.getLtype_desc());
        bundle.putString("title", ltype_name);
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, bundle, MkCategoryAllActivity.class);
        com.amgcyo.cuttadon.utils.otherutils.x0.c().a(this.K, ltype_id, ltype_name);
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
