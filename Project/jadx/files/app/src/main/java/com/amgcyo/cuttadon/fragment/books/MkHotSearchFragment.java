package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.SearchPresenter;
import com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkHotSearchFragment extends BaseRefreshMoreRecyclerFragment<SearchPresenter> implements BaseQuickAdapter.g {
    private int K = 1;
    private List<MkBook> L;

    @BindView(R.id.rl_timedata)
    RelativeLayout rl_timedata;

    @BindView(R.id.tv_data)
    TextView tvData;

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_hot_search_list;
    }

    public void a(@Nullable Object obj) {
        this.K = ((Integer) obj).intValue();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        ((SearchPresenter) this.f3726u).b(Message.a(this, new Object[]{Integer.valueOf(this.K)}));
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            this.rl_timedata.setVisibility(0);
            this.L = (List) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.L)) {
                showEmpty();
                return;
            }
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(com.amgcyo.cuttadon.f.n.Q);
            if (newApiAdA != null) {
                try {
                    this.L.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.G = new com.amgcyo.cuttadon.b.c.t(this.L, this.f3728w);
            this.recyclerView.setAdapter(this.G);
            c(false);
            b(false);
            this.G.a((BaseQuickAdapter.g) this);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.tvData.setText(String.format("%s更新", new SimpleDateFormat("MM月dd日", Locale.getDefault()).format(new Date(System.currentTimeMillis()))));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.L) || (mkBook = this.L.get(i2)) == null) {
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, mkBook.getBook_id(), mkBook.getForm());
    }

    @Override // com.amgcyo.cuttadon.fragment.base.BaseRefreshMoreRecyclerFragment, me.jessyan.art.base.f.i
    @Nullable
    public SearchPresenter obtainPresenter() {
        return new SearchPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }
}
