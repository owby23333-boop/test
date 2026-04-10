package com.amgcyo.cuttadon.activity.detail;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.fragment.books.x0;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.w;
import com.amgcyo.cuttadon.view.comic.SimpleRatingBar;
import com.amgcyo.cuttadon.view.comment.AppBarOverScrollViewBehavior;
import com.amgcyo.cuttadon.view.comment.NoScrollViewPager;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.amgcyo.cuttadon.view.popupview.ZhihuCommentPopup;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkCommentListActivity extends BaseTitleBarActivity<BookPresenter> {

    @BindView(R.id.back_v)
    ImageView back_v;

    @BindView(R.id.book_alis_tv)
    TextView book_alis_tv;

    @BindView(R.id.book_cover_iv)
    ImageView book_cover_iv;

    @BindView(R.id.book_status_new)
    TextView book_status_new;

    @BindView(R.id.book_title_tv)
    TextView book_title_tv;

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.appbar_layout)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.toolbar_back)
    RelativeLayout mMsgIv;

    @BindView(R.id.toolbars)
    Toolbar mToolBar;

    @BindView(R.id.uc_viewpager)
    NoScrollViewPager mViewPager;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    com.amgcyo.cuttadon.adapter.other.e f2467o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    MkBook f2468p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2469q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f2470r0;

    @BindView(R.id.ratingbar)
    SimpleRatingBar ratingbar;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    b1 f2471s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    ZhihuCommentPopup f2472t0;

    @BindView(R.id.title_center_layout)
    ViewGroup titleCenterLayout;

    @BindView(R.id.title_layout)
    ViewGroup titleContainer;

    @BindView(R.id.title_uc_title)
    TextView title_uc_title;

    @BindView(R.id.tv_coment_count)
    TextView tv_coment_count;

    @BindView(R.id.tv_score_new)
    TextView tv_score_new;

    @BindView(R.id.tv_score_number)
    TextView tv_score_number;

    @BindView(R.id.tv_tag_stype)
    TextView tv_tag_stype;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    BasePopupView f2474v0;

    @BindView(R.id.view_line)
    View view_line;

    @BindView(R.id.xtablayout)
    XTabLayout xTabLayout;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String[] f2466n0 = {"最新", "最热"};

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f2473u0 = 0;

    class a implements com.bumptech.glide.request.g<Drawable> {
        a() {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            ((BaseTitleBarActivity) MkCommentListActivity.this).G.a(((BaseTitleBarActivity) MkCommentListActivity.this).f2277w, ImageConfigImpl.builder().placeholder(R.drawable.icon_pic_def).drawable(w.a(com.amgcyo.cuttadon.f.o.a(drawable), 10)).imageView(MkCommentListActivity.this.back_v).build());
            return false;
        }
    }

    private void initListener() {
        this.mAppBarLayout.a(new AppBarLayout.d() { // from class: com.amgcyo.cuttadon.activity.detail.p
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void a(AppBarLayout appBarLayout, int i2) {
                this.a.a(appBarLayout, i2);
            }
        });
        AppBarOverScrollViewBehavior appBarOverScrollViewBehavior = (AppBarOverScrollViewBehavior) ((CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams()).getBehavior();
        if (appBarOverScrollViewBehavior == null) {
            return;
        }
        appBarOverScrollViewBehavior.a(new AppBarOverScrollViewBehavior.d() { // from class: com.amgcyo.cuttadon.activity.detail.n
            @Override // com.amgcyo.cuttadon.view.comment.AppBarOverScrollViewBehavior.d
            public final void a(float f2, boolean z2) {
                this.a.a(f2, z2);
            }
        });
    }

    private void o() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            return;
        }
        int i2 = this.f2469q0;
        if (i2 > 0) {
            this.f2473u0 = (int) com.amgcyo.cuttadon.utils.otherutils.g.f(i2);
        }
        if (this.f2472t0 == null) {
            this.f2472t0 = new ZhihuCommentPopup(a());
            this.f2472t0.setListener(new ZhihuCommentPopup.b() { // from class: com.amgcyo.cuttadon.activity.detail.o
                @Override // com.amgcyo.cuttadon.view.popupview.ZhihuCommentPopup.b
                public final void a(int i3, String str) {
                    this.a.a(i3, str);
                }
            });
        }
        this.f2472t0.setScore(this.f2473u0);
        BasePopupView basePopupView = this.f2474v0;
        if (basePopupView != null) {
            basePopupView.u();
            return;
        }
        a.b bVar = new a.b(a());
        bVar.c((Boolean) false);
        bVar.d(false);
        bVar.f(false);
        ZhihuCommentPopup zhihuCommentPopup = this.f2472t0;
        bVar.a((BasePopupView) zhihuCommentPopup);
        this.f2474v0 = zhihuCommentPopup.u();
    }

    private void p() {
        this.f2467o0 = new com.amgcyo.cuttadon.adapter.other.e(getSupportFragmentManager(), this.f2466n0, getmFragments());
        this.mViewPager.setAdapter(this.f2467o0);
        this.mViewPager.setOffscreenPageLimit(this.f2466n0.length);
        this.mViewPager.setCurrentItem(0);
        this.xTabLayout.setupWithViewPager(this.mViewPager);
    }

    private void q() {
        if (Build.VERSION.SDK_INT >= 19) {
            me.jessyan.art.f.h.a((Activity) a(), (View) null);
            int iA = me.jessyan.art.f.h.a(this.f2277w);
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) this.titleContainer.getLayoutParams();
            ((FrameLayout.LayoutParams) layoutParams).topMargin = iA;
            this.titleContainer.setLayoutParams(layoutParams);
            CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) this.mToolBar.getLayoutParams();
            ((FrameLayout.LayoutParams) layoutParams2).topMargin = iA;
            this.mToolBar.setLayoutParams(layoutParams2);
        }
    }

    private void r() {
        try {
            this.book_title_tv.setText(this.f2468p0.getName());
            this.tv_coment_count.setText(String.format(Locale.getDefault(), "评论 共 · %d条", Integer.valueOf(this.f2470r0)));
            String strA = com.amgcyo.cuttadon.f.o.a(this.f2468p0.getStatus());
            if (com.amgcyo.cuttadon.utils.otherutils.g.h(this.f2468p0.getForm())) {
                this.tv_tag_stype.setText(String.format(Locale.getDefault(), "%s · 共%d话", strA, Integer.valueOf(this.f2468p0.getChapter_count())));
            } else {
                this.tv_tag_stype.setText(String.format("%s · %s · %s", this.f2468p0.getStype(), strA, com.amgcyo.cuttadon.f.o.a(this.f2468p0.getWords_number(), (Integer) 2)));
            }
            String author = this.f2468p0.getAuthor();
            if (TextUtils.isEmpty(author)) {
                this.book_alis_tv.setVisibility(8);
            } else {
                this.book_alis_tv.setVisibility(0);
            }
            this.book_alis_tv.setText(author);
            int score_number = this.f2468p0.getScore_number();
            this.tv_score_number.setText(String.format(Locale.getDefault(), "(%s人点评)", com.amgcyo.cuttadon.f.o.a(String.valueOf(score_number), Boolean.valueOf(score_number <= 9999))));
            this.tv_score_new.setText(this.f2468p0.getScore());
            this.title_uc_title.setText(String.format("%s · 书友圈", this.f2468p0.getName()));
            this.ratingbar.setRating(new BigDecimal(Float.valueOf(this.f2468p0.getScore()).floatValue() / 2.0f).setScale(1, 4).floatValue());
            this.ratingbar.setVisibility(0);
            this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(this.f2468p0.getForm()), this.f2468p0.getImage())).form(this.f2468p0.getForm()).listener(new a()).imageView(this.book_cover_iv).build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void s() {
        if (g0.a().a("is_show_comment_rule_dialog", false)) {
            o();
            return;
        }
        if (this.f2471s0 == null) {
            this.f2471s0 = new b1(a());
            this.f2471s0.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.detail.m
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.n();
                }
            });
        }
        this.f2471s0.show();
        this.f2471s0.b();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x0.a(this.f2469q0, 1));
        arrayList.add(x0.a(this.f2469q0, 2));
        return arrayList;
    }

    public void groupChange(float f2, int i2) {
        this.mMsgIv.setAlpha(f2);
        if (i2 == 0) {
            this.img_back.setColorFilter(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.text_33));
            this.view_line.setVisibility(8);
            this.mViewPager.setNoScroll(true);
            this.titleContainer.setBackgroundColor(0);
            return;
        }
        if (i2 == 1) {
            this.view_line.setVisibility(8);
            this.img_back.setColorFilter(-1);
            this.titleContainer.setBackgroundColor(0);
            this.mViewPager.setNoScroll(false);
            return;
        }
        if (i2 != 2) {
            return;
        }
        this.view_line.setVisibility(0);
        this.img_back.setColorFilter(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.text_33));
        this.mViewPager.setNoScroll(false);
        this.titleContainer.setBackgroundColor(Color.argb(0, 255, 255, 255));
        me.jessyan.art.f.h.a((Activity) a());
        if (com.amgcyo.cuttadon.utils.otherutils.g.g0()) {
            me.jessyan.art.f.h.c(a(), Integer.MIN_VALUE);
        } else {
            me.jessyan.art.f.h.c(a(), -1);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        NoScrollViewPager noScrollViewPager;
        int i2;
        super.handleMessage(message);
        int i3 = message.f21197s;
        if (i3 != 844) {
            if (i3 != 870) {
                return;
            }
            hideLoading();
            return;
        }
        BasePopupView basePopupView = this.f2474v0;
        if (basePopupView != null) {
            basePopupView.g();
            this.f2474v0 = null;
        }
        com.amgcyo.cuttadon.adapter.other.e eVar = this.f2467o0;
        if (eVar == null || (noScrollViewPager = this.mViewPager) == null || this.f2468p0 == null) {
            return;
        }
        x0 x0Var = (x0) eVar.getItem(noScrollViewPager.getCurrentItem());
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null && (i2 = this.f2473u0) > 0) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2469q0, i2);
        }
        x0Var.H = 1;
        x0Var.p();
        this.f2470r0 = this.f2468p0.getComment_number();
        this.f2468p0.setComment_number(this.f2470r0 + 1);
        this.tv_coment_count.setText(String.format(Locale.getDefault(), "评论 共 · %d条", Integer.valueOf(this.f2470r0)));
        AppDatabase.i().a().e(this.f2470r0, this.f2469q0);
        hideLoading();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.setDiffentStatusBar = false;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2468p0 = (MkBook) extras.getSerializable("book");
        MkBook mkBook = this.f2468p0;
        if (mkBook == null) {
            showMessage("参数错误!");
            return;
        }
        this.f2469q0 = mkBook.getBook_id();
        this.f2470r0 = this.f2468p0.getComment_number();
        initListener();
        q();
        p();
        r();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_comment_list;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void n() {
        g0.a().b("is_show_comment_rule_dialog", true);
        o();
    }

    @OnClick({R.id.toolbar_back, R.id.fb_comment, R.id.book_alis_tv, R.id.tv_comment_list_edittext})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        if (id == R.id.book_alis_tv) {
            MkBook mkBook = this.f2468p0;
            if (mkBook == null) {
                return;
            }
            String author = mkBook.getAuthor();
            if (TextUtils.isEmpty(author)) {
                return;
            }
            r0.a(this.f2277w, author, this.f2468p0.getForm());
            return;
        }
        if (id != R.id.fb_comment) {
            if (id != R.id.toolbar_back) {
                return;
            }
            finish();
        } else {
            if (this.f2468p0 == null) {
                return;
            }
            s();
        }
    }

    public /* synthetic */ void a(AppBarLayout appBarLayout, int i2) {
        float fAbs = Math.abs(i2) / appBarLayout.getTotalScrollRange();
        ViewGroup viewGroup = this.titleCenterLayout;
        if (viewGroup == null || this.mMsgIv == null) {
            return;
        }
        viewGroup.setAlpha(fAbs);
        this.mMsgIv.setAlpha(fAbs);
        me.jessyan.art.f.h.a((Activity) a(), (View) null);
        if (fAbs == 0.0f) {
            groupChange(1.0f, 1);
        } else if (fAbs == 1.0f) {
            groupChange(1.0f, 2);
        } else {
            groupChange(fAbs, 0);
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }

    public /* synthetic */ void a(float f2, boolean z2) {
        RelativeLayout relativeLayout = this.mMsgIv;
        if (relativeLayout != null) {
            if (f2 == 0.0f) {
                relativeLayout.setVisibility(0);
            } else if (f2 > 0.0f) {
                relativeLayout.setVisibility(4);
            }
        }
    }

    public /* synthetic */ void a(int i2, String str) {
        this.f2473u0 = i2;
        P p2 = this.f2276v;
        if (p2 == 0 || this.f2468p0 == null) {
            return;
        }
        ((BookPresenter) p2).I(Message.a(this, new Object[]{Integer.valueOf(this.f2469q0), Integer.valueOf(i2), str, Integer.valueOf(this.f2468p0.getForm())}));
    }
}
