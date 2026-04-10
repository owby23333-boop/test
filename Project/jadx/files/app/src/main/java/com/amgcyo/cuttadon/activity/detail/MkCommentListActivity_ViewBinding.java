package com.amgcyo.cuttadon.activity.detail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.comic.SimpleRatingBar;
import com.amgcyo.cuttadon.view.comment.NoScrollViewPager;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public class MkCommentListActivity_ViewBinding implements Unbinder {
    private MkCommentListActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2478e;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCommentListActivity f2479s;

        a(MkCommentListActivity_ViewBinding mkCommentListActivity_ViewBinding, MkCommentListActivity mkCommentListActivity) {
            this.f2479s = mkCommentListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2479s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCommentListActivity f2480s;

        b(MkCommentListActivity_ViewBinding mkCommentListActivity_ViewBinding, MkCommentListActivity mkCommentListActivity) {
            this.f2480s = mkCommentListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2480s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCommentListActivity f2481s;

        c(MkCommentListActivity_ViewBinding mkCommentListActivity_ViewBinding, MkCommentListActivity mkCommentListActivity) {
            this.f2481s = mkCommentListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2481s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCommentListActivity f2482s;

        d(MkCommentListActivity_ViewBinding mkCommentListActivity_ViewBinding, MkCommentListActivity mkCommentListActivity) {
            this.f2482s = mkCommentListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2482s.onClick(view);
        }
    }

    @UiThread
    public MkCommentListActivity_ViewBinding(MkCommentListActivity mkCommentListActivity, View view) {
        this.a = mkCommentListActivity;
        mkCommentListActivity.mToolBar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbars, "field 'mToolBar'", Toolbar.class);
        mkCommentListActivity.titleContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.title_layout, "field 'titleContainer'", ViewGroup.class);
        mkCommentListActivity.mAppBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.appbar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
        mkCommentListActivity.titleCenterLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.title_center_layout, "field 'titleCenterLayout'", ViewGroup.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.toolbar_back, "field 'mMsgIv' and method 'onClick'");
        mkCommentListActivity.mMsgIv = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.toolbar_back, "field 'mMsgIv'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkCommentListActivity));
        mkCommentListActivity.view_line = Utils.findRequiredView(view, R.id.view_line, "field 'view_line'");
        mkCommentListActivity.img_back = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_back, "field 'img_back'", ImageView.class);
        mkCommentListActivity.tv_coment_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_coment_count, "field 'tv_coment_count'", TextView.class);
        mkCommentListActivity.mViewPager = (NoScrollViewPager) Utils.findRequiredViewAsType(view, R.id.uc_viewpager, "field 'mViewPager'", NoScrollViewPager.class);
        mkCommentListActivity.xTabLayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.xtablayout, "field 'xTabLayout'", XTabLayout.class);
        mkCommentListActivity.title_uc_title = (TextView) Utils.findRequiredViewAsType(view, R.id.title_uc_title, "field 'title_uc_title'", TextView.class);
        mkCommentListActivity.tv_tag_stype = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tag_stype, "field 'tv_tag_stype'", TextView.class);
        mkCommentListActivity.tv_score_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_score_number, "field 'tv_score_number'", TextView.class);
        mkCommentListActivity.tv_score_new = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_score_new, "field 'tv_score_new'", TextView.class);
        mkCommentListActivity.book_status_new = (TextView) Utils.findRequiredViewAsType(view, R.id.book_status_new, "field 'book_status_new'", TextView.class);
        mkCommentListActivity.book_cover_iv = (ImageView) Utils.findRequiredViewAsType(view, R.id.book_cover_iv, "field 'book_cover_iv'", ImageView.class);
        mkCommentListActivity.book_title_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.book_title_tv, "field 'book_title_tv'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.book_alis_tv, "field 'book_alis_tv' and method 'onClick'");
        mkCommentListActivity.book_alis_tv = (TextView) Utils.castView(viewFindRequiredView2, R.id.book_alis_tv, "field 'book_alis_tv'", TextView.class);
        this.f2476c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkCommentListActivity));
        mkCommentListActivity.ratingbar = (SimpleRatingBar) Utils.findRequiredViewAsType(view, R.id.ratingbar, "field 'ratingbar'", SimpleRatingBar.class);
        mkCommentListActivity.back_v = (ImageView) Utils.findRequiredViewAsType(view, R.id.back_v, "field 'back_v'", ImageView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.fb_comment, "method 'onClick'");
        this.f2477d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkCommentListActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_comment_list_edittext, "method 'onClick'");
        this.f2478e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkCommentListActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkCommentListActivity mkCommentListActivity = this.a;
        if (mkCommentListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkCommentListActivity.mToolBar = null;
        mkCommentListActivity.titleContainer = null;
        mkCommentListActivity.mAppBarLayout = null;
        mkCommentListActivity.titleCenterLayout = null;
        mkCommentListActivity.mMsgIv = null;
        mkCommentListActivity.view_line = null;
        mkCommentListActivity.img_back = null;
        mkCommentListActivity.tv_coment_count = null;
        mkCommentListActivity.mViewPager = null;
        mkCommentListActivity.xTabLayout = null;
        mkCommentListActivity.title_uc_title = null;
        mkCommentListActivity.tv_tag_stype = null;
        mkCommentListActivity.tv_score_number = null;
        mkCommentListActivity.tv_score_new = null;
        mkCommentListActivity.book_status_new = null;
        mkCommentListActivity.book_cover_iv = null;
        mkCommentListActivity.book_title_tv = null;
        mkCommentListActivity.book_alis_tv = null;
        mkCommentListActivity.ratingbar = null;
        mkCommentListActivity.back_v = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2476c.setOnClickListener(null);
        this.f2476c = null;
        this.f2477d.setOnClickListener(null);
        this.f2477d = null;
        this.f2478e.setOnClickListener(null);
        this.f2478e = null;
    }
}
