package com.amgcyo.cuttadon.fragment.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.setting.MkCommentDetailActivity;
import com.amgcyo.cuttadon.api.entity.other.CentertCommentBean;
import com.amgcyo.cuttadon.api.entity.other.LimitCenterListBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: MkCommentNoticeFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class y0 extends BaseRefreshMoreRecyclerFragment<UserPresenter> implements BaseQuickAdapter.f {
    private int K;
    private List<CentertCommentBean> L;

    public void a(@Nullable Object obj) {
        this.K = ((Integer) obj).intValue();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        if (this.K == 1) {
            showEmpty();
        } else {
            ((UserPresenter) this.f3726u).f(Message.a(this, new Object[]{Integer.valueOf(this.H)}));
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        c(false);
        if (message.f21197s == 825) {
            LimitCenterListBean limitCenterListBean = (LimitCenterListBean) message.f21202x;
            if (limitCenterListBean == null || com.amgcyo.cuttadon.utils.otherutils.g.a(limitCenterListBean.getLists())) {
                showEmpty();
                return;
            }
            this.L = limitCenterListBean.getLists();
            Iterator<CentertCommentBean> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().setItemType(2);
            }
            this.G = new com.amgcyo.cuttadon.b.c.w(this.L, this.f3728w);
            this.recyclerView.setAdapter(this.G);
            c(false);
            b(false);
            this.G.a((BaseQuickAdapter.f) this);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.f
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        CentertCommentBean centertCommentBean;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.L) || this.f3725t == null || (centertCommentBean = this.L.get(i2)) == null) {
            return;
        }
        int id = view.getId();
        if (id != R.id.ll_have_comment) {
            if (id == R.id.tv_book) {
                com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, centertCommentBean.getBook_id(), centertCommentBean.getForm());
                return;
            } else if (id != R.id.tv_my_comment) {
                return;
            }
        }
        a(centertCommentBean);
    }

    private void a(CentertCommentBean centertCommentBean) {
        Bundle bundle = new Bundle();
        bundle.putInt("comment_id", centertCommentBean.getComment_id());
        startActivity(new Intent(this.f3725t, (Class<?>) MkCommentDetailActivity.class).putExtras(bundle));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
