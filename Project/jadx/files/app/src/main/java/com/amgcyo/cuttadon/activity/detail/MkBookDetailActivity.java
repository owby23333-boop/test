package com.amgcyo.cuttadon.activity.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkCategoryAllActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelHActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelVActivity;
import com.amgcyo.cuttadon.activity.setting.MkCommentDetailActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comment.BaseCommentBean;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.FavArrBean;
import com.amgcyo.cuttadon.api.entity.comment.ReplyArrBean;
import com.amgcyo.cuttadon.api.entity.other.ComicTags;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.api.presenter.ComicPresenter;
import com.amgcyo.cuttadon.b.c.r;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.comic.ComicCatalogDrawerPopup;
import com.amgcyo.cuttadon.view.comic.SimpleRatingBar;
import com.amgcyo.cuttadon.view.comic.TagCloudView;
import com.amgcyo.cuttadon.view.comment.c;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.amgcyo.cuttadon.view.otherview.BookStoreLinearLayoutGrid;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.amgcyo.cuttadon.view.otherview.WanyiwanView;
import com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup;
import com.amgcyo.cuttadon.view.popupview.ZhihuCommentPopup;
import com.amgcyo.cuttadon.widget.ui.ObservableScrollView;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkBookDetailActivity extends BaseTitleBarActivity<BookPresenter> implements com.amgcyo.cuttadon.g.c, ObservableScrollView.a {
    private MkBook A0;
    ComicCatalogDrawerPopup B0;
    ComicPresenter C0;
    b1 D0;
    ZhihuCommentPopup E0;
    BasePopupView G0;
    NovelSourceDrawerPopup H0;
    private BaseNewComment J0;
    com.amgcyo.cuttadon.view.comment.c N0;
    private int O0;

    @BindView(R.id.back_v)
    ImageView back_v;

    @BindView(R.id.book_alis_tv)
    TextView book_alis_tv;

    @BindView(R.id.book_cover_iv)
    ImageView book_cover_iv;

    @BindView(R.id.book_title_tv)
    TextView book_title_tv;

    @BindView(R.id.ad_end)
    AdFrameLayout bottomAdLayout;

    @BindView(R.id.card_author)
    BookStoreLinearLayoutGrid card_author;

    @BindView(R.id.card_see_see)
    BookStoreLinearLayoutGrid card_see_see;

    @BindView(R.id.fl_center)
    AdFrameLayout centerAdLayout;

    @BindView(R.id.detail_ll)
    LinearLayout detail_ll;

    @BindView(R.id.empty_view)
    View empty_view;

    @BindView(R.id.title_layout)
    RelativeLayout head;

    @BindView(R.id.img_report)
    ImageView img_report;

    @BindView(R.id.img_share)
    ImageView img_share;

    @BindView(R.id.img_back)
    ImageView iv_base_back;

    @BindView(R.id.view_line)
    View line;

    @BindView(R.id.line_detail)
    View line_detail;

    @BindView(R.id.ll_author)
    LinearLayout ll_author;

    @BindView(R.id.ll_bookcomment_title)
    LinearLayout ll_bookcomment_title;

    @BindView(R.id.ll_relevant)
    LinearLayout ll_relevant;

    @BindView(R.id.ll_root_zb)
    LinearLayout ll_root_zb;

    @BindView(R.id.ll_tocomment)
    LinearLayout ll_tocomment;

    @BindView(R.id.ll_zb_click)
    LinearLayout ll_zb_click;

    @BindView(R.id.lv_comment)
    RecyclerView lv_comment;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private MkUser f2430n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f2431o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f2432p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2433q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private Rect f2434r0;

    @BindView(R.id.ratingbar)
    SimpleRatingBar ratingbar;

    @BindView(R.id.rb_comment)
    SimpleRatingBar rb_comment;

    @BindView(R.id.rl_book_comment)
    RelativeLayout rl_book_comment;

    @BindView(R.id.scrollview)
    ObservableScrollView scrollView;

    @BindView(R.id.tcv_tag)
    TagCloudView tcv_tag;

    @BindView(R.id.fl_ad)
    AdFrameLayout topAdLayout;

    @BindView(R.id.tv_addBookShelf)
    TextView tvAddBookShelf;

    @BindView(R.id.tv_read)
    TextView tvRead;

    @BindView(R.id.tv_synopsis)
    TextView tvSynopsis;

    @BindView(R.id.tv_chapter_count)
    TextView tv_chapter_count;

    @BindView(R.id.tv_coment_count)
    TextView tv_coment_count;

    @BindView(R.id.tv_footer)
    TextView tv_footer;

    @BindView(R.id.tv_lastchapter)
    TextView tv_lastchapter;

    @BindView(R.id.tv_score_new)
    TextView tv_score_new;

    @BindView(R.id.tv_score_number)
    TextView tv_score_number;

    @BindView(R.id.tv_tag_stype)
    TextView tv_tag_stype;

    @BindView(R.id.toolbar_title)
    CustomTextView tv_title;

    @BindView(R.id.tv_word_count)
    TextView tv_word_count;

    @BindView(R.id.tv_wypf)
    TextView tv_wypf;

    @BindView(R.id.tv_zb_bookname)
    TextView tv_zb_bookname;

    @BindView(R.id.tv_zbtype)
    TextView tv_zbtype;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    int f2438v0;

    @BindView(R.id.view_ad)
    View view_ad;

    @BindView(R.id.view_fl_end)
    View view_fl_bottom;

    @BindView(R.id.view_fl_center)
    View view_fl_center;

    @BindView(R.id.view_mulu)
    View view_mulu;

    @BindView(R.id.view_zb)
    View view_zb;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    List<BaseNewComment> f2439w0;

    @BindView(R.id.wanyiwanview)
    WanyiwanView wanyiwanview;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    r f2440x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private SpannableString f2441y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private SpannableString f2442z0;

    @BindView(R.id.zb_book_cover)
    ImageView zb_book_cover;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f2435s0 = false;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    ViewTreeObserver.OnGlobalLayoutListener f2436t0 = new c();

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    ViewTreeObserver.OnGlobalLayoutListener f2437u0 = new d();
    private int F0 = 0;
    private int I0 = -1;
    private int K0 = -1;
    private int L0 = -1;
    private int M0 = -1;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MkBookDetailActivity mkBookDetailActivity = MkBookDetailActivity.this;
            if (mkBookDetailActivity.detail_ll == null || mkBookDetailActivity.scrollView == null || mkBookDetailActivity.head == null) {
                return;
            }
            me.jessyan.art.f.h.b(mkBookDetailActivity);
            MkBookDetailActivity mkBookDetailActivity2 = MkBookDetailActivity.this;
            mkBookDetailActivity2.O0 = mkBookDetailActivity2.detail_ll.getHeight() - com.amgcyo.cuttadon.utils.otherutils.n.a(MkBookDetailActivity.this.a(), 48.0f);
            MkBookDetailActivity mkBookDetailActivity3 = MkBookDetailActivity.this;
            mkBookDetailActivity3.scrollView.setScrollViewListener(mkBookDetailActivity3);
            MkBookDetailActivity.this.head.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class b extends com.amgcyo.cuttadon.j.e.a {
        b(int i2) {
            super(i2);
        }

        @Override // com.amgcyo.cuttadon.j.e.a
        public void a(View view) {
            if (MkBookDetailActivity.this.A0 == null || ((BaseTitleBarActivity) MkBookDetailActivity.this).f2276v == null) {
                return;
            }
            if (MkBookDetailActivity.this.q() != null) {
                ((BookPresenter) ((BaseTitleBarActivity) MkBookDetailActivity.this).f2276v).d(Message.a(MkBookDetailActivity.this.a(), new Object[]{MkBookDetailActivity.this.A0}));
                MkBookDetailActivity.this.zhugeIodEvent("[BOOKDETAIL]移出书架");
            } else {
                MkBookDetailActivity.this.A0.setSkipToDetailPage(false);
                ((BookPresenter) ((BaseTitleBarActivity) MkBookDetailActivity.this).f2276v).a(Message.a(MkBookDetailActivity.this.a(), new Object[]{MkBookDetailActivity.this.A0}));
                MkBookDetailActivity.this.zhugeIodEvent("[BOOKDETAIL]加入书架");
            }
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MkBookDetailActivity mkBookDetailActivity = MkBookDetailActivity.this;
            AdFrameLayout adFrameLayout = mkBookDetailActivity.centerAdLayout;
            if (adFrameLayout == null || mkBookDetailActivity.view_fl_center == null || adFrameLayout.getMeasuredHeight() <= 0) {
                return;
            }
            MkBookDetailActivity.this.centerAdLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            MkBookDetailActivity.this.view_fl_center.setVisibility(0);
        }
    }

    class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MkBookDetailActivity mkBookDetailActivity = MkBookDetailActivity.this;
            AdFrameLayout adFrameLayout = mkBookDetailActivity.bottomAdLayout;
            if (adFrameLayout == null || mkBookDetailActivity.view_fl_bottom == null) {
                return;
            }
            mkBookDetailActivity.f2438v0++;
            int measuredHeight = adFrameLayout.getMeasuredHeight();
            MkBookDetailActivity mkBookDetailActivity2 = MkBookDetailActivity.this;
            if (mkBookDetailActivity2.f2438v0 >= 10 && measuredHeight <= 0) {
                mkBookDetailActivity2.bottomAdLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (measuredHeight > 0) {
                MkBookDetailActivity.this.bottomAdLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                MkBookDetailActivity.this.view_fl_bottom.setVisibility(0);
            }
        }
    }

    class e extends LinearLayoutManager {
        e(MkBookDetailActivity mkBookDetailActivity, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    class f implements com.bumptech.glide.request.g<Drawable> {
        f() {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            com.amgcyo.cuttadon.f.o.a(drawable, MkBookDetailActivity.this.back_v);
            return false;
        }
    }

    class g implements com.amgcyo.cuttadon.view.comic.m.a {
        g() {
        }

        @Override // com.amgcyo.cuttadon.view.comic.m.a
        public void a() {
            MkBookDetailActivity.this.s();
        }

        @Override // com.amgcyo.cuttadon.view.comic.m.a
        public void a(int i2) {
            if (MkBookDetailActivity.this.A0 == null) {
                return;
            }
            MkBookDetailActivity.this.A0.setReading_chapter_key(i2);
            MkBookDetailActivity.this.A0.setRead_begin(0);
            r0.a(MkBookDetailActivity.this.a(), MkBookDetailActivity.this.A0);
        }
    }

    class h implements NovelSourceDrawerPopup.b {

        class a extends com.amgcyo.cuttadon.j.g.h.b<Object> {
            final /* synthetic */ MkBook b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(h hVar, Object obj, MkBook mkBook) {
                super(obj);
                this.b = mkBook;
            }

            @Override // com.amgcyo.cuttadon.j.g.g.a
            public Void a(Object obj) {
                AppDatabase.i().a().a(this.b.getReading_site_id(), this.b.getReading_site_path(), this.b.getReading_site_id(), this.b.getBook_id(), this.b.getSite_path_reload(), this.b.getCrawl_book_id());
                return null;
            }
        }

        h() {
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void a(MkBook mkBook) {
            if (mkBook == null || TextUtils.isEmpty(mkBook.getReading_site_path())) {
                return;
            }
            MkBookDetailActivity.this.A0.setReading_site_path(mkBook.getReading_site_path());
            MkBookDetailActivity.this.A0.setReading_site_id(mkBook.getReading_site_id());
            MkBookDetailActivity.this.A0.setSiteName(mkBook.getSiteName());
            MkBookDetailActivity.this.A0.setCrawl_book_id(mkBook.getCrawl_book_id());
            MkBookDetailActivity.this.A0.setSite_path_reload(mkBook.getSite_path_reload());
            MkBookDetailActivity mkBookDetailActivity = MkBookDetailActivity.this;
            mkBookDetailActivity.a(mkBookDetailActivity.A0);
            com.amgcyo.cuttadon.j.g.b.a(new a(this, "", mkBook));
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void b(MkBook mkBook) {
            ((BookPresenter) ((BaseTitleBarActivity) MkBookDetailActivity.this).f2276v).m(Message.a(MkBookDetailActivity.this, new Object[]{Integer.valueOf(mkBook.getBook_id())}));
        }
    }

    private void A() {
        MkBook mkBook = this.A0;
        if (mkBook == null || this.tvAddBookShelf == null) {
            return;
        }
        this.tvAddBookShelf.setText(3 == mkBook.getForm() ? "加入到漫画书架" : "加入到小说书架");
    }

    private void B() {
        if (g0.a().a("is_show_comment_rule_dialog", false)) {
            p();
            return;
        }
        if (this.D0 == null) {
            this.D0 = new b1(a());
            this.D0.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.detail.d
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.o();
                }
            });
        }
        this.D0.show();
        this.D0.b();
    }

    private void p() {
        if (this.f2430n0 == null) {
            r0.a(this.f2277w, true);
            return;
        }
        if (this.E0 == null) {
            this.E0 = new ZhihuCommentPopup(a());
            this.E0.setListener(new ZhihuCommentPopup.b() { // from class: com.amgcyo.cuttadon.activity.detail.e
                @Override // com.amgcyo.cuttadon.view.popupview.ZhihuCommentPopup.b
                public final void a(int i2, String str) {
                    this.a.a(i2, str);
                }
            });
        }
        this.E0.setScore(this.F0);
        BasePopupView basePopupView = this.G0;
        if (basePopupView == null) {
            a.b bVar = new a.b(a());
            bVar.c((Boolean) false);
            bVar.d(false);
            bVar.f(false);
            ZhihuCommentPopup zhihuCommentPopup = this.E0;
            bVar.a((BasePopupView) zhihuCommentPopup);
            this.G0 = zhihuCommentPopup.u();
        } else {
            basePopupView.u();
        }
        zhugeIodEvent("[BOOKDETAIL]写书评");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MkBook q() {
        return AppDatabase.i().a().i(this.f2432p0);
    }

    private void r() {
        ((BookPresenter) this.f2276v).z(Message.a(this, new Object[]{Integer.valueOf(this.f2432p0)}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        MkBook mkBook = this.A0;
        if (mkBook == null || TextUtils.isEmpty(mkBook.getList_path())) {
            return;
        }
        if (this.C0 == null) {
            this.C0 = new ComicPresenter(me.jessyan.art.f.e.a(this));
        }
        this.C0.d(Message.a(this, new Object[]{this.A0.getList_path(), Integer.valueOf(this.A0.getBook_id()), Integer.valueOf(this.A0.getUpdated()), 922, Integer.valueOf(this.A0.getReading_chapter_key()), true}));
    }

    private void startCatalog() {
        MkBook mkBook = this.A0;
        if (mkBook == null || TextUtils.isEmpty(mkBook.getList_path())) {
            return;
        }
        if (this.B0 != null) {
            MkBook mkBook2 = this.A0;
            mkBook2.setReading_chapter_key(mkBook2.getReading_chapter_key());
            this.B0.u();
        } else {
            a.b bVar = new a.b(this);
            bVar.e(true);
            ComicCatalogDrawerPopup comicCatalogDrawerPopup = new ComicCatalogDrawerPopup(this, this.A0, this.G, new g());
            bVar.a((BasePopupView) comicCatalogDrawerPopup);
            this.B0 = (ComicCatalogDrawerPopup) comicCatalogDrawerPopup.u();
        }
    }

    private void t() {
        if (q() == null) {
            String str = z.a(this.A0.getBook_id()) + z.a + "comic_32767.comic";
            String str2 = "目录地址：" + str;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        me.jessyan.art.d.f.a().a(new MkCommentEvent(), "comic_tag_finish_activity");
        r0.a(this.f2277w, this.A0);
    }

    private void u() {
        MkBook mkBookQ = q();
        if (mkBookQ == null) {
            MkBook mkBook = this.A0;
            if (mkBook == null) {
                return;
            }
            if (1 == mkBook.getForm()) {
                startSourcePopup();
                return;
            } else {
                t();
                return;
            }
        }
        if (1 != mkBookQ.getForm()) {
            if (this.A0 == null) {
                return;
            }
            t();
        } else if (TextUtils.isEmpty(mkBookQ.getReading_site_id())) {
            startSourcePopup();
        } else {
            a(mkBookQ);
        }
    }

    private void w() {
        NormalAdParams normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c("position_book_detail_top");
        if (normalAdParamsC != null) {
            normalAdParamsC.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3700n);
            this.topAdLayout.b(normalAdParamsC);
        }
        NormalAdParams normalAdParamsC2 = com.amgcyo.cuttadon.sdk.utils.e.c("position_book_detail_center");
        if (normalAdParamsC2 != null) {
            normalAdParamsC2.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3701o);
            this.centerAdLayout.b(normalAdParamsC2);
            this.centerAdLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f2436t0);
        }
        com.amgcyo.cuttadon.h.a.h.a(this.f2277w, "book");
        this.wanyiwanview.a(this.G, com.amgcyo.cuttadon.f.n.f3709w, this, 3);
    }

    private void x() {
        this.f2439w0 = new ArrayList();
        this.lv_comment.setLayoutManager(new e(this, this.f2277w));
        this.lv_comment.setItemAnimator(null);
        this.f2440x0 = new r(this.f2439w0, this.G, this, 0);
        this.lv_comment.setAdapter(this.f2440x0);
        this.lv_comment.setHasFixedSize(true);
        this.lv_comment.setNestedScrollingEnabled(false);
    }

    private void y() {
        this.empty_view.setVisibility(this.f2431o0 ? 0 : 8);
    }

    private void z() {
        this.img_report.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.detail.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f2486s.n();
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void addReplyComment(@NonNull BaseNewComment baseNewComment, ReplyArrBean replyArrBean, int i2, int i3) {
        this.L0 = i2;
        String str = "add_reply_position:" + this.L0;
        this.J0 = baseNewComment;
        a("回复 " + replyArrBean.getNick() + " :", baseNewComment.getComment_id(), i3, true);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "书籍详情";
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void deleteReplyComment(@NonNull BaseNewComment baseNewComment, @NonNull ReplyArrBean replyArrBean, int i2) {
        this.J0 = baseNewComment;
        this.M0 = i2;
        a(replyArrBean);
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void gotoCommentDeiailPage(@NonNull BaseNewComment baseNewComment) {
        Bundle bundle = new Bundle();
        bundle.putInt("comment_id", baseNewComment.getComment_id());
        startActivity(new Intent(this.f2277w, (Class<?>) MkCommentDetailActivity.class).putExtras(bundle));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        ComicCatalogDrawerPopup comicCatalogDrawerPopup;
        int i2;
        int i3;
        BaseNewComment baseNewComment;
        super.handleMessage(message);
        int i4 = message.f21197s;
        if (i4 == 832) {
            this.tvAddBookShelf.setText(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.already_add));
            return;
        }
        if (i4 == 833) {
            A();
            return;
        }
        if (i4 == 857) {
            hideLoading();
            a((MkBook) message.f21202x);
            return;
        }
        if (i4 == 870) {
            hideLoading();
            com.amgcyo.cuttadon.view.comment.c cVar = this.N0;
            if (cVar != null) {
                cVar.dismiss();
                this.N0 = null;
                return;
            }
            return;
        }
        if (i4 == 872) {
            MkBook mkBook = (MkBook) message.f21202x;
            if (mkBook != null && mkBook.getBook_id() > 0) {
                b(mkBook);
                x0.c().a(mkBook.getName(), mkBook.getForm(), mkBook.getLtype(), mkBook.getBook_id());
                return;
            }
            showMessage("暂无数据");
            TextView textView = this.tvAddBookShelf;
            if (textView != null) {
                textView.setText("获取书籍信息失败！");
                return;
            }
            return;
        }
        if (i4 == 897) {
            List<MkSiteBean> list = (List) message.f21202x;
            if (this.H0 != null) {
                if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                    this.H0.g();
                    return;
                } else {
                    this.H0.a(list, (com.amgcyo.cuttadon.utils.otherutils.k) null);
                    return;
                }
            }
            return;
        }
        if (i4 == 922) {
            ArrayList arrayList = (ArrayList) message.f21203y[0];
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList) || (comicCatalogDrawerPopup = this.B0) == null) {
                return;
            }
            comicCatalogDrawerPopup.setAdapterData(arrayList);
            return;
        }
        switch (i4) {
            case 844:
                hideLoading();
                com.amgcyo.cuttadon.view.comment.c cVar2 = this.N0;
                if (cVar2 != null) {
                    cVar2.dismiss();
                    this.N0 = null;
                }
                int i5 = this.F0;
                if (i5 > 0) {
                    this.rb_comment.setRating(i5);
                }
                BasePopupView basePopupView = this.G0;
                if (basePopupView != null) {
                    basePopupView.g();
                    this.G0 = null;
                }
                Object obj = message.f21202x;
                if (obj != null) {
                    String str = "内容：" + ((BaseCommentBean) obj).getContent();
                }
                if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null && (i2 = this.F0) > 0) {
                    com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2432p0, i2);
                }
                r();
                break;
            case 845:
                List list2 = (List) message.f21202x;
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list2)) {
                    this.empty_view.setVisibility(8);
                    this.lv_comment.setVisibility(0);
                    if (this.f2439w0 == null) {
                        this.f2439w0 = new ArrayList();
                    }
                    this.f2439w0.clear();
                    this.f2439w0.addAll(list2);
                    this.tv_footer.setVisibility(0);
                    this.f2440x0.notifyDataSetChanged();
                } else {
                    y();
                    this.lv_comment.setVisibility(8);
                    this.tv_footer.setVisibility(8);
                }
                break;
            case 846:
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2439w0) && (i3 = this.K0) != -1) {
                    if (i3 == 1) {
                        this.K0 = 0;
                    }
                    this.f2439w0.remove(this.K0);
                    this.f2440x0.notifyItemRemoved(this.K0);
                    this.f2440x0.notifyItemChanged(this.K0);
                    if (this.f2439w0.size() <= 0) {
                        y();
                        this.lv_comment.setVisibility(8);
                    }
                    this.lv_comment.requestLayout();
                    this.K0 = -1;
                    int itemCount = this.f2440x0.getItemCount();
                    String str2 = "itemCount：" + itemCount;
                    if (itemCount <= 0) {
                        y();
                        this.lv_comment.setVisibility(8);
                        this.tv_footer.setVisibility(8);
                    }
                    break;
                }
                break;
            case 847:
                String str3 = this.J0.getContent() + " == " + this.I0;
                BaseNewComment baseNewComment2 = this.J0;
                if (baseNewComment2 != null && this.I0 != -1) {
                    List<FavArrBean> fav_arr = baseNewComment2.getFav_arr();
                    if (com.amgcyo.cuttadon.utils.otherutils.g.a(fav_arr)) {
                        fav_arr = new ArrayList<>();
                        a(fav_arr);
                    } else {
                        if (fav_arr.size() >= 5) {
                            fav_arr.remove(0);
                        }
                        a(fav_arr);
                    }
                    this.J0.setFav_arr(fav_arr);
                    BaseNewComment baseNewComment3 = this.J0;
                    baseNewComment3.setFav(baseNewComment3.getFav() + 1);
                    this.J0.setFav_state(1);
                    this.f2440x0.notifyItemChanged(this.I0);
                    this.I0 = -1;
                    this.J0 = null;
                    break;
                }
                break;
            case 848:
                hideLoading();
                ReplyArrBean replyArrBean = (ReplyArrBean) message.f21202x;
                if (replyArrBean != null && this.L0 >= 0 && this.J0 != null) {
                    String str4 = "add_reply_position：" + this.L0;
                    List<ReplyArrBean> reply_arr = this.J0.getReply_arr();
                    if (reply_arr == null) {
                        reply_arr = new ArrayList<>();
                    }
                    if (reply_arr.size() >= 5) {
                        reply_arr.remove(0);
                    }
                    reply_arr.add(replyArrBean);
                    this.J0.setReply_arr(reply_arr);
                    BaseNewComment baseNewComment4 = this.J0;
                    baseNewComment4.setReply_count(baseNewComment4.getReply_count() + 1);
                    this.f2440x0.notifyItemChanged(this.L0);
                    this.L0 = -1;
                    com.amgcyo.cuttadon.view.comment.c cVar3 = this.N0;
                    if (cVar3 != null) {
                        cVar3.dismiss();
                        this.N0 = null;
                    }
                    break;
                }
                break;
            case 849:
                ReplyArrBean replyArrBean2 = (ReplyArrBean) message.f21202x;
                if (replyArrBean2 != null && (baseNewComment = this.J0) != null && this.M0 >= 0) {
                    List<ReplyArrBean> reply_arr2 = baseNewComment.getReply_arr();
                    if (!com.amgcyo.cuttadon.utils.otherutils.g.a(reply_arr2)) {
                        reply_arr2.remove(replyArrBean2);
                        if (reply_arr2.size() == 0) {
                            this.J0.setReply_arr(null);
                        } else {
                            this.J0.setReply_arr(reply_arr2);
                        }
                        BaseNewComment baseNewComment5 = this.J0;
                        baseNewComment5.setReply_count(baseNewComment5.getReply_count() - 1);
                        this.f2440x0.notifyItemChanged(this.M0);
                        this.M0 = -1;
                        this.J0 = null;
                        this.lv_comment.requestLayout();
                        break;
                    }
                }
                break;
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f2431o0 = com.amgcyo.cuttadon.utils.otherutils.h.L0();
        this.setDiffentStatusBar = false;
        me.jessyan.art.f.h.a((Context) this, (View) this.head);
        w();
        this.line.setVisibility(8);
        this.detail_ll.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f2432p0 = extras.getInt("book_id");
        this.f2433q0 = extras.getInt("form");
        if (this.f2433q0 == 0) {
            this.f2433q0 = 1;
        }
        ((BookPresenter) this.f2276v).l(Message.a(this, new Object[]{Integer.valueOf(this.f2432p0), Integer.valueOf(this.f2433q0)}));
        if (this.f2431o0) {
            b(this.ll_bookcomment_title, this.rl_book_comment, this.view_mulu);
            x();
            r();
        } else {
            a(this.ll_bookcomment_title, this.rl_book_comment, this.view_mulu);
        }
        this.tvAddBookShelf.setOnClickListener(new b(TTAdConstant.STYLE_SIZE_RADIO_3_2));
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.new_book_detail_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void likeCommentOperation(@NonNull BaseNewComment baseNewComment, int i2) {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            r0.a(this.f2277w, true);
            return;
        }
        if (baseNewComment.getFav_state() == 1) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.cannot_like_agian));
            return;
        }
        this.I0 = i2;
        this.J0 = baseNewComment;
        P p2 = this.f2276v;
        if (p2 != 0) {
            ((BookPresenter) p2).F(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getComment_id()), Integer.valueOf(mkUserJ.getUser_id())}));
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void n() {
        if (this.img_report != null) {
            com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(a(), "report_book_key");
            BaseTitleBarActivity baseTitleBarActivityA = a();
            ImageView imageView = this.img_report;
            fVar.a(com.amgcyo.cuttadon.f.o.a(baseTitleBarActivityA, imageView, "点击这里可以举报书籍不良信息", new com.amgcyo.cuttadon.view.showcaseview.i.d(imageView.getWidth(), this.head.getHeight()), 30, 1, 30, new q(this)));
            fVar.b();
        }
    }

    public /* synthetic */ void o() {
        g0.a().b("is_show_comment_rule_dialog", true);
        p();
    }

    @OnClick({R.id.ll_tocomment, R.id.img_share, R.id.img_report, R.id.catalog, R.id.tv_read, R.id.book_alis_tv, R.id.tv_write_comment, R.id.empty_view, R.id.tv_footer})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        switch (view.getId()) {
            case R.id.book_alis_tv /* 2131296704 */:
                String author = this.A0.getAuthor();
                if (!TextUtils.isEmpty(author)) {
                    r0.a(this.f2277w, author, this.A0.getForm());
                    zhugeIodEvent("[BOOKDETAIL]点击作者");
                }
                break;
            case R.id.catalog /* 2131296779 */:
                MkBook mkBook = this.A0;
                if (mkBook != null) {
                    if (1 != mkBook.getForm()) {
                        startCatalog();
                        zhugeIodEvent("[BOOKDETAIL]点击目录");
                    } else {
                        startSourcePopup();
                        zhugeIodEvent("[BOOKDETAIL]书籍详情选源");
                    }
                    break;
                }
                break;
            case R.id.empty_view /* 2131296965 */:
            case R.id.ll_tocomment /* 2131297978 */:
            case R.id.tv_write_comment /* 2131298886 */:
                B();
                break;
            case R.id.img_report /* 2131297115 */:
                if (this.A0 == null) {
                    showMessage("获取书籍详情数据失败，请退出重试！");
                } else if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
                    Bundle bundle = new Bundle();
                    this.A0.setUpdated(0);
                    bundle.putSerializable("book", this.A0);
                    r0.startActivity(this.f2277w, bundle, MkBookReportActivity.class);
                } else {
                    r0.a((Context) a(), true);
                }
                break;
            case R.id.img_share /* 2131297118 */:
                if (a() != null && !a().isFinishing()) {
                    com.amgcyo.cuttadon.f.o.a((Activity) a());
                }
                zhugeIodEvent("[BOOKDETAIL]分享");
                break;
            case R.id.tv_footer /* 2131298714 */:
                r0.c(this.f2277w, this.A0);
                zhugeIodEvent("[BOOKDETAIL]查看所有评论");
                break;
            case R.id.tv_read /* 2131298783 */:
                u();
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        AdFrameLayout adFrameLayout = this.centerAdLayout;
        if (adFrameLayout != null && this.f2436t0 != null) {
            adFrameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.f2436t0);
        }
        AdFrameLayout adFrameLayout2 = this.bottomAdLayout;
        if (adFrameLayout2 != null && this.f2437u0 != null) {
            adFrameLayout2.getViewTreeObserver().removeOnGlobalLayoutListener(this.f2437u0);
        }
        x0.c().a("[BOOKDETAIL]关闭书籍详情页面");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.amgcyo.cuttadon.view.comment.c cVar = this.N0;
        if (cVar != null) {
            cVar.dismiss();
            this.N0 = null;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        int i2;
        super.onResume();
        this.f2430n0 = com.amgcyo.cuttadon.utils.otherutils.g.j();
        MkBook mkBookQ = q();
        if (mkBookQ != null) {
            this.tvAddBookShelf.setText(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.already_add));
            MkBook mkBook = this.A0;
            if (mkBook != null && this.tvRead != null) {
                mkBook.setRead_begin(mkBookQ.getRead_begin());
                this.A0.setReading_chapter_key(mkBookQ.getReading_chapter_key());
                int reading_chapter_key = this.A0.getReading_chapter_key() + 1;
                if (1 == this.A0.getForm()) {
                    this.tvRead.setText(String.format(Locale.getDefault(), "续看第%d章", Integer.valueOf(reading_chapter_key)));
                } else {
                    this.tvRead.setText(String.format(Locale.getDefault(), "续看第%d话", Integer.valueOf(reading_chapter_key)));
                }
            }
        } else {
            A();
        }
        if (this.f2430n0 == null || this.rb_comment == null || (i2 = this.f2432p0) <= 0) {
            TextView textView = this.tv_wypf;
            if (textView != null) {
                textView.setText("我要评分");
                return;
            }
            return;
        }
        this.F0 = (int) com.amgcyo.cuttadon.utils.otherutils.g.f(i2);
        this.rb_comment.setRating(this.F0);
        TextView textView2 = this.tv_wypf;
        if (textView2 == null || this.F0 <= 0) {
            return;
        }
        textView2.setText("我的评分");
    }

    @Override // com.amgcyo.cuttadon.widget.ui.ObservableScrollView.a
    public void onScrollChanged(ObservableScrollView observableScrollView, int i2, int i3, int i4, int i5) {
        View view;
        if (i3 <= 0) {
            this.head.setBackgroundColor(Color.argb(0, 255, 255, 255));
            this.line.setVisibility(8);
            int color = getResources().getColor(R.color.white);
            this.tv_title.setTextColor(color);
            this.tv_title.setVisibility(8);
            this.iv_base_back.setColorFilter(color);
            this.img_share.setColorFilter(color);
            this.img_report.setColorFilter(color);
        } else {
            int i6 = this.O0;
            if (i3 <= i6) {
                this.line.setVisibility(8);
                int i7 = (int) ((i3 / i6) * 255.0f);
                int i8 = 255 - i7;
                int iRgb = Color.rgb(i8, i8, i8);
                this.tv_title.setTextColor(iRgb);
                this.tv_title.setVisibility(8);
                this.iv_base_back.setColorFilter(iRgb);
                this.img_share.setColorFilter(iRgb);
                this.img_report.setColorFilter(iRgb);
                this.head.setBackgroundColor(Color.argb(i7, 255, 255, 255));
            } else {
                this.head.setBackgroundColor(Color.argb(255, 255, 255, 255));
                this.line.setVisibility(0);
                int color2 = getResources().getColor(R.color.text_33);
                this.tv_title.setTextColor(color2);
                this.tv_title.setVisibility(0);
                this.iv_base_back.setColorFilter(color2);
                this.img_share.setColorFilter(color2);
                this.img_report.setColorFilter(color2);
            }
        }
        if (this.f2434r0 == null) {
            this.f2434r0 = new Rect();
        }
        observableScrollView.getHitRect(this.f2434r0);
        if (this.f2435s0 || this.bottomAdLayout == null || (view = this.view_ad) == null || !view.getLocalVisibleRect(this.f2434r0)) {
            return;
        }
        this.f2435s0 = true;
        NormalAdParams normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c("position_book_detail_bottom");
        if (normalAdParamsC != null) {
            normalAdParamsC.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3702p);
            this.bottomAdLayout.setVisibility(0);
            this.bottomAdLayout.b(normalAdParamsC);
            this.bottomAdLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f2437u0);
        }
    }

    public void startSourcePopup() {
        NovelSourceDrawerPopup novelSourceDrawerPopup = this.H0;
        if (novelSourceDrawerPopup != null) {
            novelSourceDrawerPopup.u();
            return;
        }
        a.b bVar = new a.b(this);
        bVar.a(PopupPosition.Left);
        bVar.e(true);
        NovelSourceDrawerPopup novelSourceDrawerPopup2 = new NovelSourceDrawerPopup(this, this.A0);
        bVar.a((BasePopupView) novelSourceDrawerPopup2);
        this.H0 = (NovelSourceDrawerPopup) novelSourceDrawerPopup2.u();
        this.H0.setListener(new h());
    }

    @Override // com.amgcyo.cuttadon.g.c
    public void submitOrDeleteComment(@NonNull BaseNewComment baseNewComment, int i2) {
        if (baseNewComment.isLoginUser()) {
            P p2 = this.f2276v;
            if (p2 != 0) {
                this.K0 = i2;
                ((BookPresenter) p2).e(Message.a(this, new Object[]{Integer.valueOf(baseNewComment.getComment_id())}));
                return;
            }
            return;
        }
        this.L0 = i2;
        String str = "add_reply_position:" + this.L0;
        this.J0 = baseNewComment;
        a("回复 " + baseNewComment.getNick() + " :", baseNewComment.getComment_id(), 0, false);
    }

    private void b(MkBook mkBook) {
        this.A0 = mkBook;
        List<Integer> shield_data = mkBook.getShield_data();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(shield_data) && shield_data.contains(Integer.valueOf(com.amgcyo.cuttadon.utils.otherutils.g.l())) && com.amgcyo.cuttadon.utils.otherutils.h.u0()) {
            c("该书籍已下架!");
            finish();
            return;
        }
        this.book_title_tv.setText(mkBook.getName());
        b(this.ll_tocomment, this.book_alis_tv, this.line_detail);
        String author = mkBook.getAuthor();
        if (TextUtils.isEmpty(author)) {
            this.book_alis_tv.setVisibility(8);
        } else {
            this.book_alis_tv.setVisibility(0);
            this.book_alis_tv.setText(author);
        }
        int score_number = mkBook.getScore_number();
        this.tv_score_number.setText(String.format(Locale.getDefault(), "(%s人点评)", com.amgcyo.cuttadon.f.o.a(String.valueOf(score_number), Boolean.valueOf(score_number <= 9999))));
        try {
            this.tv_lastchapter.setText(String.format("%s  更新  %s", new SimpleDateFormat("MM-dd", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(mkBook.getUpdated_at())), mkBook.getLast_chapter_name()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        final List listA = com.amgcyo.cuttadon.utils.otherutils.r.a(mkBook.getTags(), ComicTags.class);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listA)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(((ComicTags) it.next()).getTags_name());
            }
            this.tcv_tag.setTags(arrayList);
            this.tcv_tag.setOnTagClickListener(new TagCloudView.b() { // from class: com.amgcyo.cuttadon.activity.detail.f
                @Override // com.amgcyo.cuttadon.view.comic.TagCloudView.b
                public final void a(int i2) {
                    this.a.a(listA, i2);
                }
            });
        }
        this.ratingbar.setRating(new BigDecimal(Float.valueOf(mkBook.getScore()).floatValue() / 2.0f).setScale(1, 4).floatValue());
        this.ratingbar.setVisibility(0);
        this.tv_title.setText(mkBook.getName());
        a(this.tvSynopsis, com.amgcyo.cuttadon.utils.otherutils.g.v(mkBook.getRemark()));
        String strA = com.amgcyo.cuttadon.f.o.a(mkBook.getStatus());
        this.tv_score_new.setText(mkBook.getScore());
        this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(this.A0.getForm()), mkBook.getImage())).form(this.f2433q0).listener(new f()).imageView(this.book_cover_iv).build());
        if (com.amgcyo.cuttadon.utils.otherutils.g.h(this.f2433q0)) {
            this.tv_tag_stype.setText(String.format("%s", strA));
            this.tv_word_count.setText(String.format("%s话", Integer.valueOf(mkBook.getChapter_count())));
            b(this.tv_tag_stype, this.tv_word_count);
        } else {
            this.tv_tag_stype.setText(String.format("%s", mkBook.getLtype()));
            this.tv_word_count.setText(String.format("%s", strA));
            this.tv_chapter_count.setText(com.amgcyo.cuttadon.f.o.a(mkBook.getWords_number(), (Integer) 2));
            b(this.tv_tag_stype, this.tv_word_count, this.tv_chapter_count);
        }
        this.tv_coment_count.setText(String.format("书评 · %s", Integer.valueOf(mkBook.getComment_number())));
        int dimensionPixelSize = this.f2277w.getResources().getDimensionPixelSize(R.dimen.dimen15dp);
        List<MkBook> author_book = mkBook.getAuthor_book();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(author_book)) {
            this.ll_author.setVisibility(8);
        } else {
            this.ll_author.setVisibility(0);
            this.card_author.a(new LinearLayoutManager(this.f2277w), new com.amgcyo.cuttadon.adapter.comic.d(author_book, this.G), dimensionPixelSize);
        }
        List<MkBook> relevant_book = mkBook.getRelevant_book();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(relevant_book)) {
            this.ll_relevant.setVisibility(8);
        } else {
            this.ll_relevant.setVisibility(0);
            this.card_see_see.a(new LinearLayoutManager(this.f2277w), new com.amgcyo.cuttadon.adapter.comic.d(relevant_book, this.G), dimensionPixelSize);
        }
        String updated_at = mkBook.getUpdated_at();
        String last_chapter_name = mkBook.getLast_chapter_name();
        MkBook mkBookQ = q();
        if (mkBookQ != null) {
            this.tvAddBookShelf.setText(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.already_add));
            this.A0 = mkBookQ;
            String updated_at2 = mkBookQ.getUpdated_at();
            if (!TextUtils.isEmpty(updated_at) && !TextUtils.isEmpty(updated_at2) && !updated_at.equals(updated_at2)) {
                AppDatabase.i().a().a(updated_at, 0, last_chapter_name, mkBook.getBook_id());
            }
            int reading_chapter_key = this.A0.getReading_chapter_key() + 1;
            if (1 == this.A0.getForm()) {
                this.tvRead.setText(String.format(Locale.getDefault(), "续看第%d章", Integer.valueOf(reading_chapter_key)));
            } else {
                this.tvRead.setText(String.format(Locale.getDefault(), "续看第%d话", Integer.valueOf(reading_chapter_key)));
            }
        } else {
            A();
        }
        this.rb_comment.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.detail.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2494s.f(view);
            }
        });
        List<MkBook> related_data = mkBook.getRelated_data();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(related_data) || com.amgcyo.cuttadon.utils.otherutils.g.j0()) {
            a(this.ll_root_zb, this.view_zb);
        } else {
            double dRandom = Math.random();
            double size = related_data.size();
            Double.isNaN(size);
            final MkBook mkBook2 = related_data.get((int) (dRandom * size));
            if (mkBook2 == null) {
                a(this.ll_root_zb, this.view_zb);
            } else if (mkBook2.getForm() == 3 || mkBook2.getForm() == 1) {
                b(this.ll_root_zb, this.view_zb);
                this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook2.getForm()), mkBook2.getImage())).form(mkBook2.getForm()).imageView(this.zb_book_cover).build());
                this.tv_zbtype.setText(3 == mkBook2.getForm() ? "同名漫画" : "同名小说");
                this.tv_zb_bookname.setText(mkBook2.getName());
                this.ll_zb_click.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.detail.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2492s.a(mkBook2, view);
                    }
                });
            } else {
                a(this.ll_root_zb, this.view_zb);
            }
        }
        if (this.img_report != null) {
            z();
        }
    }

    public /* synthetic */ void e(View view) {
        if (view.isSelected()) {
            this.tvSynopsis.setText(this.f2442z0);
            this.tvSynopsis.setSelected(false);
        } else {
            this.tvSynopsis.setText(this.f2441y0);
            this.tvSynopsis.setSelected(true);
        }
    }

    public /* synthetic */ void f(View view) {
        this.rb_comment.setRating(this.F0);
        B();
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }

    private void a(List<FavArrBean> list) {
        if (this.f2430n0 != null) {
            list.add(new FavArrBean("书友" + this.f2430n0.getUser_id(), this.f2430n0.getAvatar(), this.f2430n0.getUser_id()));
        }
    }

    private void a(TextView textView, String str) {
        int color = getResources().getColor(R.color.color_EC5C07);
        StaticLayout staticLayout = new StaticLayout(str, textView.getPaint(), getResources().getDisplayMetrics().widthPixels - com.amgcyo.cuttadon.utils.otherutils.n.a(this, 40.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (staticLayout.getLineCount() > 3) {
            String str2 = str + "    收起";
            this.f2442z0 = new SpannableString(str2);
            this.f2442z0.setSpan(new ForegroundColorSpan(color), str2.length() - 2, str2.length(), 33);
            String str3 = str.substring(0, (staticLayout.getLineStart(3) - 1) - 2) + "...展开";
            this.f2441y0 = new SpannableString(str3);
            this.f2441y0.setSpan(new ForegroundColorSpan(color), str3.length() - 2, str3.length(), 33);
            textView.setText(this.f2441y0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.detail.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2485s.e(view);
                }
            });
            textView.setSelected(true);
            return;
        }
        textView.setText(str);
        textView.setOnClickListener(null);
    }

    public /* synthetic */ void a(List list, int i2) {
        ComicTags comicTags = (ComicTags) list.get(i2);
        if (comicTags == null || this.A0 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ArticleInfo.USER_SEX, 5);
        bundle.putInt("ltype", comicTags.getTags_id());
        bundle.putString("key_desc", comicTags.getTags_desc());
        bundle.putString("title", comicTags.getTags_name());
        r0.startActivity(a(), bundle, MkCategoryAllActivity.class);
    }

    public /* synthetic */ void a(MkBook mkBook, View view) {
        r0.a(this.f2277w, mkBook.getBook_id(), mkBook.getForm());
    }

    public /* synthetic */ void a(int i2, String str) {
        this.F0 = i2;
        P p2 = this.f2276v;
        if (p2 != 0) {
            ((BookPresenter) p2).I(Message.a(this, new Object[]{Integer.valueOf(this.f2432p0), Integer.valueOf(i2), str, Integer.valueOf(this.f2433q0)}));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MkBook mkBook) {
        Bundle bundle = new Bundle();
        mkBook.setUpdated(0);
        bundle.putSerializable("book", mkBook);
        if (com.amgcyo.cuttadon.view.read.page.m.a(this.f2277w)) {
            x0.c().a(1, mkBook.getBook_id(), mkBook.getRead_begin(), "水平", mkBook.getUpdated());
            r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
        } else {
            x0.c().a(1, mkBook.getBook_id(), mkBook.getRead_begin(), "上下", mkBook.getUpdated());
            r0.startActivity(this.f2277w, bundle, MkReadModelVActivity.class);
        }
    }

    private void a(final ReplyArrBean replyArrBean) {
        com.amgcyo.cuttadon.f.o.a(a(), "提示", "是否删除本条评论?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.detail.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2483s.a(replyArrBean, view);
            }
        }, (View.OnClickListener) null);
    }

    public /* synthetic */ void a(ReplyArrBean replyArrBean, View view) {
        P p2 = this.f2276v;
        if (p2 != 0) {
            ((BookPresenter) p2).f(Message.a(this, new Object[]{replyArrBean}));
        }
    }

    private void a(String str, final int i2, final int i3, final boolean z2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            return;
        }
        com.amgcyo.cuttadon.view.comment.c cVar = new com.amgcyo.cuttadon.view.comment.c(this);
        cVar.a(str);
        cVar.a(new c.InterfaceC0115c() { // from class: com.amgcyo.cuttadon.activity.detail.j
            @Override // com.amgcyo.cuttadon.view.comment.c.InterfaceC0115c
            public final void a(String str2) {
                this.a.a(i2, i3, z2, str2);
            }
        });
        this.N0 = cVar;
        this.N0.show();
    }

    public /* synthetic */ void a(final int i2, final int i3, final boolean z2, final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.detail.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f2487s.a(i2, str, i3, z2);
            }
        }, 10L);
    }

    public /* synthetic */ void a(int i2, String str, int i3, boolean z2) {
        if (this.f2276v != 0) {
            showLoading(com.amgcyo.cuttadon.f.o.d(R.string.submiting));
            ((BookPresenter) this.f2276v).H(Message.a(a(), new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}));
        }
    }
}
