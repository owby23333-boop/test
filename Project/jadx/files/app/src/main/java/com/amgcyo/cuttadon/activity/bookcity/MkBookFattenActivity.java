package com.amgcyo.cuttadon.activity.bookcity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.adapter.shelf.MkFattenItem;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.other.FattenChapterNum;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.f.q;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.view.dialog.w0;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkBookFattenActivity extends BaseTitleBarActivity<BookPresenter> implements PullToRefreshView.j, com.amgcyo.cuttadon.g.a {

    @BindView(R.id.fl_ad)
    AdFrameLayout adFrameLayout;

    @BindView(R.id.feed_intro_btn)
    TextView feed_intro_btn;

    @BindView(R.id.ll_fatten_info)
    LinearLayout ll_fatten_info;

    @BindView(android.R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    PullToRefreshView mRefreshView;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    List<Object> f2313n0 = new ArrayList();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    me.drakeet.multitype.d f2314o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    com.amgcyo.cuttadon.database.f f2315p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2316q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    w0 f2317r0;

    private void n() {
        this.f2314o0 = new me.drakeet.multitype.d();
        this.f2314o0.a(MkBook.class, new MkFattenItem(this.G, this));
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f2314o0.a(this.f2313n0);
        this.mRecyclerView.setAdapter(this.f2314o0);
        this.mRecyclerView.addOnScrollListener(new q(this.f2277w));
    }

    private void o() {
        this.mRefreshView.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.measure(0, 0);
        this.mRefreshView.setRefreshing(true);
        this.mRefreshView.setOnRefreshListener(this);
        n();
        q();
    }

    private void p() {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_book_shelf_top", "csj_new_position_shelf");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(n.f3710x);
            this.adFrameLayout.b(normalAdParamsA);
        }
    }

    private void q() {
        List<MkBook> listC = com.amgcyo.cuttadon.utils.otherutils.g.c(this.f2316q0);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listC)) {
            this.mRecyclerView.setVisibility(8);
            this.mRefreshView.setRefreshing(false);
            showMessage("无数据");
            showEmpty();
            return;
        }
        if (this.f2313n0 == null) {
            this.f2313n0 = new ArrayList();
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) this.f2313n0)) {
            this.f2313n0.clear();
        }
        this.f2313n0.addAll(listC);
        this.mRecyclerView.setVisibility(0);
        if (this.f2314o0 == null) {
            n();
        }
        me.drakeet.multitype.d dVar = this.f2314o0;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(false);
        }
    }

    private void r() {
        this.ll_fatten_info.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.B.setText(o.d(R.string.fatten_str));
        this.D.setVisibility(0);
        this.D.setText(o.d(R.string.fatten_setting));
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.bookcity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2347s.f(view);
            }
        });
        p();
        o();
    }

    private void s() {
        this.f2317r0 = new w0(this.f2277w);
        this.f2317r0.show();
        this.f2317r0.a(new w0.a() { // from class: com.amgcyo.cuttadon.activity.bookcity.e
            @Override // com.amgcyo.cuttadon.view.dialog.w0.a
            public final void a(FattenChapterNum fattenChapterNum) {
                this.a.a(fattenChapterNum);
            }
        });
        this.f2317r0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.activity.bookcity.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f2346s.a(dialogInterface);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(FattenChapterNum fattenChapterNum) {
        q();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void e(View view) {
        g0.a().b("fatten_info_show", true);
        r();
    }

    public /* synthetic */ void f(View view) {
        s();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            showMessage(o.d(R.string.error_params));
            return;
        }
        this.f2316q0 = extras.getInt("form", 1);
        if (g0.a().a("fatten_info_show", false)) {
            r();
            return;
        }
        this.feed_intro_btn.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.bookcity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2348s.e(view);
            }
        });
        this.ll_fatten_info.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.B.setText("养肥说明");
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_fatten;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void moreClickListener(MkBook mkBook) {
        if (mkBook == null || this.f2276v == 0) {
            return;
        }
        if (this.f2315p0 == null) {
            this.f2315p0 = AppDatabase.i().a();
        }
        if (this.f2315p0.a(mkBook.getIs_fatten() == 1 ? 0 : 1, mkBook.getBook_id()) <= 0) {
            showMessage("移回书架出现异常~");
            return;
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            ((BookPresenter) this.f2276v).j(Message.a(this, new Object[]{Integer.valueOf(mkBook.getBook_id()), Integer.valueOf(mkBook.getForm())}));
        }
        q();
        showMessage("移回书架成功~");
        me.jessyan.art.d.f.a().a(new MkCommentEvent(), "add_delete_book");
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void onItemCategoryClick(ShelfCategory shelfCategory) {
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void onItemCategoryLongClick(ShelfCategory shelfCategory) {
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void onItemClick(MkBook mkBook) {
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(true);
            this.mRefreshView.setRefreshing(false);
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f2317r0 = null;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }
}
