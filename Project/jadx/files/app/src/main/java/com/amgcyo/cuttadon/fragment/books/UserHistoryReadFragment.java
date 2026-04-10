package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.api.entity.other.HistoryBookBean;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class UserHistoryReadFragment extends BaseRefreshMoreRecyclerFragment<BookPresenter> implements com.amgcyo.cuttadon.g.g, BaseQuickAdapter.g {
    private LocalReadHistoryBean L;
    private com.amgcyo.cuttadon.database.a N;

    @BindView(R.id.tv_collect)
    TextView tv_collect;
    private List<LocalReadHistoryBean> K = new ArrayList();
    private int M = 1;

    private void a(List<LocalReadHistoryBean> list, int i2) {
        if (this.H == 1) {
            this.K.clear();
            for (LocalReadHistoryBean localReadHistoryBean : list) {
                localReadHistoryBean.setItemType(2);
                this.K.add(localReadHistoryBean);
            }
            this.G.b((Collection) this.K);
        } else {
            Iterator<LocalReadHistoryBean> it = list.iterator();
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

    private void b(List<LocalReadHistoryBean> list) {
        this.J = list.size();
        this.I = this.J + 1;
        a(list, this.I);
        c(false);
        s();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "add_delete_book")
    private void bookOperate(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            o();
        }
    }

    public static UserHistoryReadFragment c(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("form", i2);
        UserHistoryReadFragment userHistoryReadFragment = new UserHistoryReadFragment();
        userHistoryReadFragment.setArguments(bundle);
        return userHistoryReadFragment;
    }

    private void p() {
        try {
            showMessage("清除成功!");
            this.K.clear();
            this.G.notifyDataSetChanged();
            showEmpty();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private com.amgcyo.cuttadon.database.a q() {
        if (this.N == null) {
            this.N = ReadHistoryDatabase.b().a();
        }
        return this.N;
    }

    private void r() {
        List<LocalReadHistoryBean> listA = q().a(this.M);
        String str = "是不是空：" + com.amgcyo.cuttadon.utils.otherutils.g.a(listA);
        a(listA);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listA)) {
            b(listA);
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

    @Subscriber(mode = ThreadMode.POST, tag = "bookThemeStates")
    private void refreshDataByEvent(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            onRefresh();
        }
    }

    private void s() {
        this.tv_collect.setVisibility(0);
        this.tv_collect.setBackground(this.f3725t.getResources().getDrawable(R.drawable.back_read));
        this.tv_collect.setText("清空浏览历史");
        this.tv_collect.setTextColor(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.white));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public int a() {
        return R.layout.float_button_recycleview;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.M = arguments.getInt("form", 1);
        this.G = new com.amgcyo.cuttadon.b.c.x(this.K, this.f3728w, this);
        this.recyclerView.setItemAnimator(null);
        this.G.a(this.recyclerView);
        this.G.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.fragment.books.s0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.o();
            }
        }, this.recyclerView);
        this.G.a((BaseQuickAdapter.g) this);
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 825) {
            HistoryBookBean historyBookBean = (HistoryBookBean) message.f21202x;
            this.I = historyBookBean.getLimit();
            List<LocalReadHistoryBean> lists = historyBookBean.getLists();
            c(false);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(lists)) {
                this.J = lists.size();
                for (LocalReadHistoryBean localReadHistoryBean : lists) {
                    localReadHistoryBean.setNeedToldServer(1);
                    q().insert(localReadHistoryBean);
                }
            }
            r();
            if (1 == this.M) {
                com.amgcyo.cuttadon.utils.otherutils.g0.a().b("need_load_history_novel_data", true);
                return;
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g0.a().b("need_load_history_comics_data", true);
                return;
            }
        }
        if (i2 == 826) {
            c(false);
            r();
            return;
        }
        if (i2 != 832) {
            if (i2 == 843) {
                p();
            }
        } else {
            if (this.L == null || com.amgcyo.cuttadon.utils.otherutils.g.a(this.K)) {
                return;
            }
            int iIndexOf = this.K.indexOf(this.L);
            this.L.setInshelf(true);
            this.K.remove(iIndexOf);
            this.G.notifyItemRemoved(iIndexOf);
            this.K.add(iIndexOf, this.L);
            this.G.notifyItemInserted(iIndexOf);
            this.G.notifyItemChanged(iIndexOf);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        c(false);
    }

    public void o() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r();
            return;
        }
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("need_load_history_novel_data", false);
        if (3 == this.M) {
            zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("need_load_history_comics_data", false);
        }
        if (!zA) {
            ((BookPresenter) this.f3726u).n(Message.a(this, new Object[]{Integer.valueOf(this.H), Integer.valueOf(this.M)}));
            return;
        }
        List<LocalReadHistoryBean> listA = q().a(this.M);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listA)) {
            ((BookPresenter) this.f3726u).n(Message.a(this, new Object[]{Integer.valueOf(this.H), Integer.valueOf(this.M)}));
        } else {
            a(listA);
            b(listA);
        }
    }

    @OnClick({R.id.tv_collect})
    public void onClick() {
        com.amgcyo.cuttadon.f.o.a(this.f3725t, "温馨提示", "是否清空浏览历史记录，清空后将永久丢失，且无法找回，是否清除？", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3826s.a(view);
            }
        }, (View.OnClickListener) null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        LocalReadHistoryBean localReadHistoryBean;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.K) || (localReadHistoryBean = this.K.get(i2)) == null) {
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, localReadHistoryBean.getBook_id(), localReadHistoryBean.getForm());
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

    public /* synthetic */ void a(View view) {
        if (q().b(this.M) > 0) {
            p();
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            ((BookPresenter) this.f3726u).c(Message.a(this, new Object[]{Integer.valueOf(this.M)}));
        }
    }

    private void a(List<LocalReadHistoryBean> list) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            return;
        }
        List<MkBook> listB = com.amgcyo.cuttadon.utils.otherutils.g.b(this.M);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
            return;
        }
        for (LocalReadHistoryBean localReadHistoryBean : list) {
            Iterator<MkBook> it = listB.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getBook_id() == localReadHistoryBean.getBook_id()) {
                        localReadHistoryBean.setInshelf(true);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    @Override // com.amgcyo.cuttadon.g.g
    public void a(LocalReadHistoryBean localReadHistoryBean) {
        this.L = localReadHistoryBean;
        MkBook mkBook = new MkBook(localReadHistoryBean.getBook_id(), localReadHistoryBean.getName(), localReadHistoryBean.getAuthor(), localReadHistoryBean.getImage(), localReadHistoryBean.getCreated_at(), localReadHistoryBean.getLtype(), localReadHistoryBean.getStype(), localReadHistoryBean.getStatus(), localReadHistoryBean.getFav_count(), localReadHistoryBean.getComment_number(), localReadHistoryBean.getWords_number(), localReadHistoryBean.getLast_chapter_name(), localReadHistoryBean.getUpdated_at());
        mkBook.setSkipToDetailPage(false);
        mkBook.setForm(localReadHistoryBean.getForm());
        if (3 == localReadHistoryBean.getForm()) {
            mkBook.setList_path(localReadHistoryBean.getList_path());
            mkBook.setList_reload_path(localReadHistoryBean.getList_reload_path());
        }
        ((BookPresenter) this.f3726u).a(Message.a(this, new Object[]{mkBook}));
    }
}
