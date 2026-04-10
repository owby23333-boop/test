package com.amgcyo.cuttadon.activity.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.view.comic.SimpleRatingBar;
import com.amgcyo.cuttadon.view.comic.TagCloudView;
import com.amgcyo.cuttadon.view.otherview.BookStoreLinearLayoutGrid;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.amgcyo.cuttadon.view.otherview.WanyiwanView;
import com.amgcyo.cuttadon.widget.ui.ObservableScrollView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBookDetailActivity_ViewBinding implements Unbinder {
    private MkBookDetailActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f2452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f2454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f2455j;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2456s;

        a(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2456s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2456s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2457s;

        b(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2457s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2457s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2458s;

        c(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2458s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2458s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2459s;

        d(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2459s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2459s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2460s;

        e(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2460s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2460s.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2461s;

        f(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2461s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2461s.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2462s;

        g(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2462s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2462s.onClick(view);
        }
    }

    class h extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2463s;

        h(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2463s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2463s.onClick(view);
        }
    }

    class i extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookDetailActivity f2464s;

        i(MkBookDetailActivity_ViewBinding mkBookDetailActivity_ViewBinding, MkBookDetailActivity mkBookDetailActivity) {
            this.f2464s = mkBookDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2464s.onClick(view);
        }
    }

    @UiThread
    public MkBookDetailActivity_ViewBinding(MkBookDetailActivity mkBookDetailActivity, View view) {
        this.a = mkBookDetailActivity;
        mkBookDetailActivity.book_cover_iv = (ImageView) Utils.findRequiredViewAsType(view, R.id.book_cover_iv, "field 'book_cover_iv'", ImageView.class);
        mkBookDetailActivity.book_title_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.book_title_tv, "field 'book_title_tv'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.book_alis_tv, "field 'book_alis_tv' and method 'onClick'");
        mkBookDetailActivity.book_alis_tv = (TextView) Utils.castView(viewFindRequiredView, R.id.book_alis_tv, "field 'book_alis_tv'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkBookDetailActivity));
        mkBookDetailActivity.back_v = (ImageView) Utils.findRequiredViewAsType(view, R.id.back_v, "field 'back_v'", ImageView.class);
        mkBookDetailActivity.card_author = (BookStoreLinearLayoutGrid) Utils.findRequiredViewAsType(view, R.id.card_author, "field 'card_author'", BookStoreLinearLayoutGrid.class);
        mkBookDetailActivity.card_see_see = (BookStoreLinearLayoutGrid) Utils.findRequiredViewAsType(view, R.id.card_see_see, "field 'card_see_see'", BookStoreLinearLayoutGrid.class);
        mkBookDetailActivity.wanyiwanview = (WanyiwanView) Utils.findRequiredViewAsType(view, R.id.wanyiwanview, "field 'wanyiwanview'", WanyiwanView.class);
        mkBookDetailActivity.tv_tag_stype = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tag_stype, "field 'tv_tag_stype'", TextView.class);
        mkBookDetailActivity.line_detail = Utils.findRequiredView(view, R.id.line_detail, "field 'line_detail'");
        mkBookDetailActivity.tv_chapter_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chapter_count, "field 'tv_chapter_count'", TextView.class);
        mkBookDetailActivity.tv_word_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_word_count, "field 'tv_word_count'", TextView.class);
        mkBookDetailActivity.ll_author = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_author, "field 'll_author'", LinearLayout.class);
        mkBookDetailActivity.ll_relevant = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_relevant, "field 'll_relevant'", LinearLayout.class);
        mkBookDetailActivity.ll_bookcomment_title = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bookcomment_title, "field 'll_bookcomment_title'", LinearLayout.class);
        mkBookDetailActivity.rl_book_comment = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_book_comment, "field 'rl_book_comment'", RelativeLayout.class);
        mkBookDetailActivity.view_mulu = Utils.findRequiredView(view, R.id.view_mulu, "field 'view_mulu'");
        mkBookDetailActivity.ll_root_zb = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root_zb, "field 'll_root_zb'", LinearLayout.class);
        mkBookDetailActivity.ll_zb_click = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_zb_click, "field 'll_zb_click'", LinearLayout.class);
        mkBookDetailActivity.zb_book_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.zb_book_cover, "field 'zb_book_cover'", ImageView.class);
        mkBookDetailActivity.tv_zbtype = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_zbtype, "field 'tv_zbtype'", TextView.class);
        mkBookDetailActivity.tv_zb_bookname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_zb_bookname, "field 'tv_zb_bookname'", TextView.class);
        mkBookDetailActivity.view_zb = Utils.findRequiredView(view, R.id.view_zb, "field 'view_zb'");
        mkBookDetailActivity.tvSynopsis = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_synopsis, "field 'tvSynopsis'", TextView.class);
        mkBookDetailActivity.tv_coment_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_coment_count, "field 'tv_coment_count'", TextView.class);
        mkBookDetailActivity.tvAddBookShelf = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_addBookShelf, "field 'tvAddBookShelf'", TextView.class);
        mkBookDetailActivity.tv_score_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_score_number, "field 'tv_score_number'", TextView.class);
        mkBookDetailActivity.tv_lastchapter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lastchapter, "field 'tv_lastchapter'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_read, "field 'tvRead' and method 'onClick'");
        mkBookDetailActivity.tvRead = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_read, "field 'tvRead'", TextView.class);
        this.f2448c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkBookDetailActivity));
        mkBookDetailActivity.lv_comment = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.lv_comment, "field 'lv_comment'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.empty_view, "field 'empty_view' and method 'onClick'");
        mkBookDetailActivity.empty_view = viewFindRequiredView3;
        this.f2449d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkBookDetailActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_footer, "field 'tv_footer' and method 'onClick'");
        mkBookDetailActivity.tv_footer = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_footer, "field 'tv_footer'", TextView.class);
        this.f2450e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkBookDetailActivity));
        mkBookDetailActivity.tv_score_new = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_score_new, "field 'tv_score_new'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_tocomment, "field 'll_tocomment' and method 'onClick'");
        mkBookDetailActivity.ll_tocomment = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.ll_tocomment, "field 'll_tocomment'", LinearLayout.class);
        this.f2451f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkBookDetailActivity));
        mkBookDetailActivity.rb_comment = (SimpleRatingBar) Utils.findRequiredViewAsType(view, R.id.rb_comment, "field 'rb_comment'", SimpleRatingBar.class);
        mkBookDetailActivity.tv_wypf = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wypf, "field 'tv_wypf'", TextView.class);
        mkBookDetailActivity.ratingbar = (SimpleRatingBar) Utils.findRequiredViewAsType(view, R.id.ratingbar, "field 'ratingbar'", SimpleRatingBar.class);
        mkBookDetailActivity.tcv_tag = (TagCloudView) Utils.findRequiredViewAsType(view, R.id.tcv_tag, "field 'tcv_tag'", TagCloudView.class);
        mkBookDetailActivity.topAdLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_ad, "field 'topAdLayout'", AdFrameLayout.class);
        mkBookDetailActivity.centerAdLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_center, "field 'centerAdLayout'", AdFrameLayout.class);
        mkBookDetailActivity.view_fl_center = Utils.findRequiredView(view, R.id.view_fl_center, "field 'view_fl_center'");
        mkBookDetailActivity.bottomAdLayout = (AdFrameLayout) Utils.findRequiredViewAsType(view, R.id.ad_end, "field 'bottomAdLayout'", AdFrameLayout.class);
        mkBookDetailActivity.view_fl_bottom = Utils.findRequiredView(view, R.id.view_fl_end, "field 'view_fl_bottom'");
        mkBookDetailActivity.head = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.title_layout, "field 'head'", RelativeLayout.class);
        mkBookDetailActivity.tv_title = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.toolbar_title, "field 'tv_title'", CustomTextView.class);
        mkBookDetailActivity.iv_base_back = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_back, "field 'iv_base_back'", ImageView.class);
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.img_share, "field 'img_share' and method 'onClick'");
        mkBookDetailActivity.img_share = (ImageView) Utils.castView(viewFindRequiredView6, R.id.img_share, "field 'img_share'", ImageView.class);
        this.f2452g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, mkBookDetailActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.img_report, "field 'img_report' and method 'onClick'");
        mkBookDetailActivity.img_report = (ImageView) Utils.castView(viewFindRequiredView7, R.id.img_report, "field 'img_report'", ImageView.class);
        this.f2453h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, mkBookDetailActivity));
        mkBookDetailActivity.line = Utils.findRequiredView(view, R.id.view_line, "field 'line'");
        mkBookDetailActivity.view_ad = Utils.findRequiredView(view, R.id.view_ad, "field 'view_ad'");
        mkBookDetailActivity.scrollView = (ObservableScrollView) Utils.findRequiredViewAsType(view, R.id.scrollview, "field 'scrollView'", ObservableScrollView.class);
        mkBookDetailActivity.detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.detail_ll, "field 'detail_ll'", LinearLayout.class);
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.catalog, "method 'onClick'");
        this.f2454i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(this, mkBookDetailActivity));
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.tv_write_comment, "method 'onClick'");
        this.f2455j = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new i(this, mkBookDetailActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBookDetailActivity mkBookDetailActivity = this.a;
        if (mkBookDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBookDetailActivity.book_cover_iv = null;
        mkBookDetailActivity.book_title_tv = null;
        mkBookDetailActivity.book_alis_tv = null;
        mkBookDetailActivity.back_v = null;
        mkBookDetailActivity.card_author = null;
        mkBookDetailActivity.card_see_see = null;
        mkBookDetailActivity.wanyiwanview = null;
        mkBookDetailActivity.tv_tag_stype = null;
        mkBookDetailActivity.line_detail = null;
        mkBookDetailActivity.tv_chapter_count = null;
        mkBookDetailActivity.tv_word_count = null;
        mkBookDetailActivity.ll_author = null;
        mkBookDetailActivity.ll_relevant = null;
        mkBookDetailActivity.ll_bookcomment_title = null;
        mkBookDetailActivity.rl_book_comment = null;
        mkBookDetailActivity.view_mulu = null;
        mkBookDetailActivity.ll_root_zb = null;
        mkBookDetailActivity.ll_zb_click = null;
        mkBookDetailActivity.zb_book_cover = null;
        mkBookDetailActivity.tv_zbtype = null;
        mkBookDetailActivity.tv_zb_bookname = null;
        mkBookDetailActivity.view_zb = null;
        mkBookDetailActivity.tvSynopsis = null;
        mkBookDetailActivity.tv_coment_count = null;
        mkBookDetailActivity.tvAddBookShelf = null;
        mkBookDetailActivity.tv_score_number = null;
        mkBookDetailActivity.tv_lastchapter = null;
        mkBookDetailActivity.tvRead = null;
        mkBookDetailActivity.lv_comment = null;
        mkBookDetailActivity.empty_view = null;
        mkBookDetailActivity.tv_footer = null;
        mkBookDetailActivity.tv_score_new = null;
        mkBookDetailActivity.ll_tocomment = null;
        mkBookDetailActivity.rb_comment = null;
        mkBookDetailActivity.tv_wypf = null;
        mkBookDetailActivity.ratingbar = null;
        mkBookDetailActivity.tcv_tag = null;
        mkBookDetailActivity.topAdLayout = null;
        mkBookDetailActivity.centerAdLayout = null;
        mkBookDetailActivity.view_fl_center = null;
        mkBookDetailActivity.bottomAdLayout = null;
        mkBookDetailActivity.view_fl_bottom = null;
        mkBookDetailActivity.head = null;
        mkBookDetailActivity.tv_title = null;
        mkBookDetailActivity.iv_base_back = null;
        mkBookDetailActivity.img_share = null;
        mkBookDetailActivity.img_report = null;
        mkBookDetailActivity.line = null;
        mkBookDetailActivity.view_ad = null;
        mkBookDetailActivity.scrollView = null;
        mkBookDetailActivity.detail_ll = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2448c.setOnClickListener(null);
        this.f2448c = null;
        this.f2449d.setOnClickListener(null);
        this.f2449d = null;
        this.f2450e.setOnClickListener(null);
        this.f2450e = null;
        this.f2451f.setOnClickListener(null);
        this.f2451f = null;
        this.f2452g.setOnClickListener(null);
        this.f2452g = null;
        this.f2453h.setOnClickListener(null);
        this.f2453h = null;
        this.f2454i.setOnClickListener(null);
        this.f2454i = null;
        this.f2455j.setOnClickListener(null);
        this.f2455j = null;
    }
}
