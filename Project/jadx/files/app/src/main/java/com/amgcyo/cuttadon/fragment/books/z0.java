package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.MkFeedbackHisBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: MkFbHistoryFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class z0 extends BaseRefreshMoreRecyclerFragment<UserPresenter> {
    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            o();
        } else {
            showMessage("请登录后查看");
            showEmpty();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            List list = (List) message.f21202x;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((MkFeedbackHisBean) it.next()).setItemType(2);
            }
            this.G = new com.amgcyo.cuttadon.b.c.s(list, this.f3728w);
            this.recyclerView.setAdapter(this.G);
            c(false);
            b(false);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
    }

    public void o() {
        ((UserPresenter) this.f3726u).i(Message.a(this, new Object[0]));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
