package com.amgcyo.cuttadon.fragment.books;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.adapter.bookcity.MkBanner1BeanIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkBanner2BeanIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkBookCityBaseAdIVBNew;
import com.amgcyo.cuttadon.adapter.bookcity.MkBookCityShudanListIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkCommonFooterIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkFeatureIconIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkGrid2BookData;
import com.amgcyo.cuttadon.adapter.bookcity.MkGrid3BookDataIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkGrid4BookDataIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkMultiTileNoMarginIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkOneBookListIVB;
import com.amgcyo.cuttadon.adapter.bookcity.MkV7Style2RankBookData;
import com.amgcyo.cuttadon.adapter.bookcity.MkV7Style2RankTagBookData;
import com.amgcyo.cuttadon.adapter.bookcity.MkWanyiwanIVB;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.bookcity.BookCityHeaderData;
import com.amgcyo.cuttadon.api.entity.bookcity.BookStoreMaleBean;
import com.amgcyo.cuttadon.api.entity.bookcity.ItemsGrid2Book;
import com.amgcyo.cuttadon.api.entity.bookcity.ObjectNewBook;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.api.entity.bookcity.v4.ItemsGrid3Book;
import com.amgcyo.cuttadon.api.entity.bookcity.v4.ItemsGrid4Book;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7IconBean;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.style.V7Style2Rank;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCommonFooter;
import com.amgcyo.cuttadon.api.entity.other.MultiTile;
import com.amgcyo.cuttadon.api.entity.other.WanyiwanBean;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.f.r;
import com.fatcatfat.io.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import java.util.List;
import me.drakeet.multitype.Items;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkJingXuanFragment extends com.amgcyo.cuttadon.fragment.base.a<BookPresenter> {
    me.drakeet.multitype.d G;
    public String H;
    private boolean N;

    @BindView(R.id.ll_root)
    LinearLayout ll_root;

    @BindView(android.R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    TwinklingRefreshLayout mRefreshView;

    @BindView(R.id.shimmerframelayout)
    FrameLayout shimmerframelayout;
    public int I = 1;
    private int J = -1;
    private Items K = new Items();
    private boolean L = false;
    int M = 0;
    private int O = 1;

    class a extends com.lcodecore.tkrefreshlayout.f {
        a() {
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void a(TwinklingRefreshLayout twinklingRefreshLayout) {
            twinklingRefreshLayout.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.fragment.books.g0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3813s.e();
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }

        @Override // com.lcodecore.tkrefreshlayout.f, com.lcodecore.tkrefreshlayout.e
        public void b(TwinklingRefreshLayout twinklingRefreshLayout) {
            super.b(twinklingRefreshLayout);
            String str = "recommendCategory:" + MkJingXuanFragment.this.J;
            if (MkJingXuanFragment.this.J == -1) {
                if (MkJingXuanFragment.this.p()) {
                    MkJingXuanFragment.this.G.notifyDataSetChanged();
                    return;
                }
                String str2 = "大小：" + MkJingXuanFragment.this.K.size();
                MkJingXuanFragment.this.l();
                return;
            }
            if (MkJingXuanFragment.this.O <= 10) {
                MkJingXuanFragment.f(MkJingXuanFragment.this);
                if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
                    MkJingXuanFragment mkJingXuanFragment = MkJingXuanFragment.this;
                    mkJingXuanFragment.c(mkJingXuanFragment.J);
                } else if (MkJingXuanFragment.this.N) {
                    MkJingXuanFragment.this.r();
                } else {
                    MkJingXuanFragment mkJingXuanFragment2 = MkJingXuanFragment.this;
                    mkJingXuanFragment2.c(mkJingXuanFragment2.J);
                }
            }
        }

        public /* synthetic */ void e() {
            MkJingXuanFragment mkJingXuanFragment = MkJingXuanFragment.this;
            if (mkJingXuanFragment.mRecyclerView != null) {
                mkJingXuanFragment.mRefreshView.f();
            }
        }
    }

    class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            Object obj = MkJingXuanFragment.this.K.get(i2);
            if (obj instanceof V7IconBean) {
                return 8;
            }
            if ((obj instanceof ItemsGrid2Book) || (obj instanceof V7Style2Rank)) {
                return 20;
            }
            if (obj instanceof ItemsGrid3Book) {
                return 13;
            }
            return ((obj instanceof ObjectNewBook) || (obj instanceof ItemsGrid4Book)) ? 10 : 40;
        }
    }

    static /* synthetic */ int f(MkJingXuanFragment mkJingXuanFragment) {
        int i2 = mkJingXuanFragment.O;
        mkJingXuanFragment.O = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.O = 32767;
        this.mRefreshView.setEnableLoadmore(false);
        if (this.L) {
            return;
        }
        this.L = true;
        this.K.add(new MkCommonFooter("没有更多数据了😘"));
        this.G.notifyItemRangeChanged(this.K.size() - 1, this.K.size());
    }

    private MkBookStoreFragment m() {
        return (MkBookStoreFragment) getParentFragment();
    }

    private void o() {
        FrameLayout frameLayout = this.shimmerframelayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            this.ll_root.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return com.amgcyo.cuttadon.utils.otherutils.g.l(this.H);
    }

    private void q() {
        if (TextUtils.isEmpty(this.H)) {
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            r();
        } else {
            a((List<MkBook>) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((BookPresenter) this.f3726u).y(Message.a(this, new Object[]{this.H, Integer.valueOf(this.O)}));
    }

    private void s() {
        FrameLayout frameLayout = this.shimmerframelayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.jingxuan_fragment;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 888) {
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) this.K)) {
                this.K.clear();
            }
            this.K = (Items) message.f21202x;
            Items items = this.K;
            if (items == null) {
                j();
                return;
            }
            for (Object obj : items) {
                if (obj instanceof MultiTile) {
                    MultiTile multiTile = (MultiTile) obj;
                    if (multiTile.isRecommend) {
                        this.J = multiTile.category;
                        String str = "recommendCategory:" + this.J;
                    }
                }
            }
            this.mRecyclerView.setItemViewCacheSize(this.K.size());
            me.drakeet.multitype.d dVar = this.G;
            if (dVar != null) {
                dVar.a(this.K);
                this.G.notifyDataSetChanged();
            }
            o();
            return;
        }
        if (i2 == 900) {
            List<MkBook> list = (List) message.f21202x;
            this.N = !com.amgcyo.cuttadon.utils.otherutils.g.a(list);
            me.drakeet.multitype.d dVar2 = this.G;
            if (dVar2 != null && dVar2.getItemCount() <= 0) {
                s();
                a(list);
                String str2 = "没有设置过数据，是不是有猜你喜欢数据：" + this.N;
                return;
            }
            o();
            this.mRefreshView.e();
            String str3 = "isLoadLikeData:" + this.N;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                l();
                return;
            }
            String str4 = "likeListData的大小为：" + list.size();
            this.K.addAll(list);
            this.G.notifyItemRangeChanged(this.K.size() - list.size(), this.K.size());
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void i() {
        super.i();
        q();
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.D = z2;
    }

    public static MkJingXuanFragment c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("tabName", str);
        MkJingXuanFragment mkJingXuanFragment = new MkJingXuanFragment();
        mkJingXuanFragment.setArguments(bundle);
        return mkJingXuanFragment;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments == null || this.mRecyclerView == null) {
            return;
        }
        s();
        final MkBookStoreFragment mkBookStoreFragmentM = m();
        SinaRefreshView sinaRefreshView = new SinaRefreshView(this.f3725t);
        sinaRefreshView.setHeadViewBgColor(com.amgcyo.cuttadon.f.o.b(R.color.color_EC5C07));
        this.mRefreshView.setHeaderView(sinaRefreshView);
        this.mRefreshView.setEnableLoadmore(true);
        this.mRefreshView.setEnableOverScroll(true);
        this.mRefreshView.setOverScrollRefreshShow(false);
        this.mRefreshView.setOverScrollHeight(200.0f);
        this.mRefreshView.setAutoLoadMore(true);
        this.mRefreshView.setOnRefreshListener(new a());
        this.H = arguments.getString("tabName");
        if ("comics".equals(this.H)) {
            this.I = 3;
        } else {
            this.I = 1;
        }
        this.mRecyclerView.addOnScrollListener(new com.amgcyo.cuttadon.f.r(this.f3725t, new r.a() { // from class: com.amgcyo.cuttadon.fragment.books.h0
            @Override // com.amgcyo.cuttadon.f.r.a
            public final void a(int i2) {
                this.a.a(mkBookStoreFragmentM, i2);
            }
        }));
        this.G = new me.drakeet.multitype.d();
        if (com.amgcyo.cuttadon.utils.otherutils.h.E0()) {
            this.G.a(BookCityHeaderData.class, new MkBanner1BeanIVB(this.f3728w));
        } else {
            this.G.a(BookCityHeaderData.class, new MkBanner2BeanIVB(this.f3728w));
        }
        this.G.a(MultiTile.class, new MkMultiTileNoMarginIVB());
        this.G.a(V7IconBean.class, new MkFeatureIconIVB(this.f3728w));
        this.G.a(BookStoreMaleBean.class, new MkV7Style2RankTagBookData(this.f3728w));
        this.G.a(V7Style2Rank.class, new MkV7Style2RankBookData(this.f3728w));
        this.G.a(ItemsGrid2Book.class, new MkGrid2BookData(this.f3728w));
        this.G.a(ItemsGrid3Book.class, new MkGrid3BookDataIVB(this.f3728w));
        this.G.a(MkBook.class, new MkOneBookListIVB(this.f3728w));
        this.G.a(ItemsGrid4Book.class, new MkGrid4BookDataIVB(this.f3728w));
        this.G.a(NormalAdParams.class, new MkBookCityBaseAdIVBNew(this.f3725t));
        this.G.a(WanyiwanBean.class, new MkWanyiwanIVB(this.f3728w));
        this.G.a(ShudanListData.class, new MkBookCityShudanListIVB(this.f3728w));
        this.G.a(MkCommonFooter.class, new MkCommonFooterIVB());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f3725t, 40);
        gridLayoutManager.setSpanSizeLookup(new b());
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        Items items = this.K;
        if (items == null) {
            j();
            return;
        }
        this.G.a(items);
        this.mRecyclerView.setAdapter(this.G);
        q();
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    public /* synthetic */ void a(MkBookStoreFragment mkBookStoreFragment, int i2) {
        this.M = i2;
        if (mkBookStoreFragment != null) {
            mkBookStoreFragment.a(i2, this.H, this.D);
        }
    }

    private void a(List<MkBook> list) {
        ((BookPresenter) this.f3726u).x(Message.a(this, new Object[]{this.H, list}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        ((BookPresenter) this.f3726u).w(Message.a(this, new Object[]{this.H, Integer.valueOf(i2), Integer.valueOf(this.O), 900}));
    }
}
