package com.amgcyo.cuttadon.e.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.amgcyo.cuttadon.activity.search.MkSearchActivity;
import com.amgcyo.cuttadon.api.entity.comic.SearchResultListV4;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.SearchPresenter;
import com.amgcyo.cuttadon.b.c.p;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.jessyan.art.f.e;
import me.jessyan.art.mvp.Message;

/* JADX INFO: compiled from: SearchResultV4Fragment.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends BaseRefreshMoreRecyclerFragment<SearchPresenter> {
    private p K;
    private List<MkBook> L;
    private int M;
    private String N;
    private int O;

    static /* synthetic */ void a(FragmentActivity fragmentActivity) {
        if (fragmentActivity instanceof MkSearchActivity) {
            MkSearchActivity mkSearchActivity = (MkSearchActivity) fragmentActivity;
            mkSearchActivity.setClickSearch(false);
            mkSearchActivity.cleanAutoCompleteData();
        }
    }

    public static c b(String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("hot_keyword", str);
        bundle.putInt("form", i2);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.N = arguments.getString("hot_keyword");
        this.O = arguments.getInt("form", 1);
        this.L = new ArrayList();
        this.K = new p(this.L, this.f3728w);
        this.recyclerView.setAdapter(this.K);
        this.K.a(new BaseQuickAdapter.g() { // from class: com.amgcyo.cuttadon.e.a.b
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f3670s.a(baseQuickAdapter, view, i2);
            }
        });
        o();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        c(false);
        b(false);
        final FragmentActivity activity = getActivity();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.e.a.a
            @Override // java.lang.Runnable
            public final void run() {
                c.a(activity);
            }
        }, 500L);
        if (message.f21197s == 828) {
            SearchResultListV4 searchResultListV4 = (SearchResultListV4) message.f21202x;
            if (searchResultListV4 == null) {
                showEmpty();
                return;
            }
            this.L = searchResultListV4.getBook();
            List<String> author = searchResultListV4.getAuthor();
            if (g.a(this.L) && g.a(author)) {
                showEmpty();
                return;
            }
            if (!g.a(author)) {
                for (int i2 = 0; i2 < author.size(); i2++) {
                    this.L.add(i2, new MkBook(author.get(i2), 3, this.O));
                }
                this.M = author.size();
            }
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(n.K);
            if (newApiAdA != null) {
                this.L.add(this.M + 2, new MkBook(newApiAdA, 1));
            }
            p pVar = this.K;
            if (pVar != null) {
                pVar.b((Collection) this.L);
            }
        }
    }

    public void o() {
        if (this.f3726u == 0 || TextUtils.isEmpty(this.N)) {
            return;
        }
        ((SearchPresenter) this.f3726u).d(Message.a(this, new Object[]{this.N, Integer.valueOf(this.O)}));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public SearchPresenter obtainPresenter() {
        return new SearchPresenter(e.a(this.f3725t));
    }

    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        if (g.a(this.L) || (mkBook = this.L.get(i2)) == null) {
            return;
        }
        P p2 = this.f3726u;
        if (p2 != 0) {
            ((SearchPresenter) p2).f(Message.a(this, new Object[]{this.N, String.valueOf(mkBook.getBook_id()), Integer.valueOf(this.O)}));
        }
        y0.a.a.a("类型：" + mkBook.getForm(), new Object[0]);
        r0.a(this.f3725t, mkBook.getBook_id(), mkBook.getForm());
    }
}
