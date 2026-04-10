package com.amgcyo.cuttadon.activity.bookcity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListDeatil;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeStates;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.b.c.p;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkThemeDetailActivity extends BaseRefreshMoreRecyclerActivity<BookPresenter> implements BaseQuickAdapter.g {
    private int A0;
    private boolean B0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    String f2335r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    ThemeBookListDeatil f2336s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private View f2337t0;

    @BindView(R.id.tv_collect)
    TextView tv_collect;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private CustomTextView f2338u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private TextView f2339v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private TextView f2340w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    List<MkBook> f2341x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    MkUser f2342y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private int f2343z0 = -1;

    private void q() {
        this.f2342y0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.f2342y0 != null) {
            ((BookPresenter) this.f2276v).E(Message.a(this, new Object[]{Integer.valueOf(this.f2343z0)}));
        } else {
            t();
        }
    }

    private void r() {
        if (this.B0) {
            me.jessyan.art.d.f.a().a(new MkCommentEvent(), "bookThemeStates");
        }
    }

    private void s() {
        this.f2337t0 = LayoutInflater.from(this.f2277w).inflate(R.layout.mk_view_head_shudandetail, (ViewGroup) null);
        this.f2338u0 = (CustomTextView) this.f2337t0.findViewById(R.id.tv_theme_title);
        this.f2339v0 = (TextView) this.f2337t0.findViewById(R.id.tv_theme_author);
        this.f2340w0 = (TextView) this.f2337t0.findViewById(R.id.tv_theme_remark);
    }

    private void t() {
        this.tv_collect.setVisibility(0);
        this.tv_collect.setBackground(this.f2277w.getResources().getDrawable(R.drawable.back_read));
        this.tv_collect.setText("添加收藏该书单");
        this.tv_collect.setTextColor(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.white));
    }

    private void u() {
        this.tv_collect.setVisibility(0);
        this.tv_collect.setBackground(this.f2277w.getResources().getDrawable(R.drawable.back_read_un));
        this.tv_collect.setText("取消收藏该书单");
        this.tv_collect.setTextColor(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.d0d0d0));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "书单详情";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 != 825) {
            switch (i2) {
                case 839:
                    this.A0 = ((ThemeStates) message.f21202x).getState();
                    if (this.A0 != 0) {
                        u();
                    } else {
                        t();
                    }
                    break;
                case 840:
                    u();
                    this.A0 = 1;
                    r();
                    break;
                case 841:
                    t();
                    this.A0 = 0;
                    r();
                    break;
            }
        }
        this.f2336s0 = (ThemeBookListDeatil) message.f21202x;
        ThemeBookListDeatil themeBookListDeatil = this.f2336s0;
        if (themeBookListDeatil == null) {
            showEmpty();
            return;
        }
        this.f2341x0 = themeBookListDeatil.getBooks();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2341x0)) {
            NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(n.O);
            if (newApiAdA != null) {
                try {
                    this.f2341x0.add(2, new MkBook(newApiAdA, 1));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f2256n0 = new p(this.f2341x0, this.G);
            this.recyclerView.setAdapter(this.f2256n0);
            this.f2256n0.a((BaseQuickAdapter.g) this);
            if (this.f2337t0 != null) {
                this.f2338u0.setText(this.f2336s0.getTitle());
                this.f2339v0.setText(this.f2336s0.getAuthor());
                this.f2340w0.setText(this.f2336s0.getRemark());
                this.f2256n0.b(this.f2337t0);
            }
            this.f2343z0 = this.f2336s0.getList_id();
            q();
        }
        d(false);
        c(false);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2335r0 = extras.getString("theme_path");
        this.B0 = extras.getBoolean("theme_base_info", false);
        if (TextUtils.isEmpty(this.f2335r0)) {
            finish();
        }
        s();
        ((BookPresenter) this.f2276v).t(Message.a(this, new Object[]{this.f2335r0}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.float_button_recycleview;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @OnClick({R.id.tv_collect})
    public void onClick() {
        if (this.f2342y0 == null) {
            r0.a(this.f2277w, true);
            return;
        }
        int i2 = this.f2343z0;
        if (i2 == -1) {
            return;
        }
        if (this.A0 == 0) {
            ((BookPresenter) this.f2276v).b(Message.a(this, new Object[]{Integer.valueOf(i2)}));
        } else {
            ((BookPresenter) this.f2276v).h(Message.a(this, new Object[]{Integer.valueOf(i2)}));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        MkBook mkBook;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2341x0) || (mkBook = this.f2341x0.get(i2)) == null) {
            return;
        }
        r0.a(this.f2277w, mkBook.getBook_id(), mkBook.getForm());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }
}
