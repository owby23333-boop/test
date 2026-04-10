package com.amgcyo.cuttadon.fragment.books;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.SimpleMarqueeView;

/* JADX INFO: loaded from: classes.dex */
public class MkBookStoreFragment_ViewBinding implements Unbinder {
    private MkBookStoreFragment a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f3740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f3741e;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookStoreFragment f3742s;

        a(MkBookStoreFragment_ViewBinding mkBookStoreFragment_ViewBinding, MkBookStoreFragment mkBookStoreFragment) {
            this.f3742s = mkBookStoreFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3742s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookStoreFragment f3743s;

        b(MkBookStoreFragment_ViewBinding mkBookStoreFragment_ViewBinding, MkBookStoreFragment mkBookStoreFragment) {
            this.f3743s = mkBookStoreFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3743s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookStoreFragment f3744s;

        c(MkBookStoreFragment_ViewBinding mkBookStoreFragment_ViewBinding, MkBookStoreFragment mkBookStoreFragment) {
            this.f3744s = mkBookStoreFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3744s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkBookStoreFragment f3745s;

        d(MkBookStoreFragment_ViewBinding mkBookStoreFragment_ViewBinding, MkBookStoreFragment mkBookStoreFragment) {
            this.f3745s = mkBookStoreFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3745s.onClick(view);
        }
    }

    @UiThread
    public MkBookStoreFragment_ViewBinding(MkBookStoreFragment mkBookStoreFragment, View view) {
        this.a = mkBookStoreFragment;
        mkBookStoreFragment.tb_select_banner1 = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tb_select_banner1, "field 'tb_select_banner1'", XTabLayout.class);
        mkBookStoreFragment.tb_select_banner2 = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tb_select_banner2, "field 'tb_select_banner2'", XTabLayout.class);
        mkBookStoreFragment.vp_classify = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_classify, "field 'vp_classify'", ViewPager.class);
        mkBookStoreFragment.banner1_head = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.banner1_head, "field 'banner1_head'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.img_banner1, "field 'img_banner1' and method 'onClick'");
        mkBookStoreFragment.img_banner1 = (ImageView) Utils.castView(viewFindRequiredView, R.id.img_banner1, "field 'img_banner1'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkBookStoreFragment));
        mkBookStoreFragment.banner2_head = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.banner2_head, "field 'banner2_head'", LinearLayout.class);
        mkBookStoreFragment.img_banner2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_banner2, "field 'img_banner2'", ImageView.class);
        mkBookStoreFragment.img_fenlei = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_fenlei, "field 'img_fenlei'", ImageView.class);
        mkBookStoreFragment.tv_fenlei = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fenlei, "field 'tv_fenlei'", TextView.class);
        mkBookStoreFragment.img_rank = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_rank, "field 'img_rank'", ImageView.class);
        mkBookStoreFragment.tv_rank = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_rank, "field 'tv_rank'", TextView.class);
        mkBookStoreFragment.marqueerewardview = (SimpleMarqueeView) Utils.findRequiredViewAsType(view, R.id.marqueerewardview, "field 'marqueerewardview'", SimpleMarqueeView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_search, "field 'rl_search' and method 'onClick'");
        mkBookStoreFragment.rl_search = (RelativeLayout) Utils.castView(viewFindRequiredView2, R.id.rl_search, "field 'rl_search'", RelativeLayout.class);
        this.f3739c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkBookStoreFragment));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_fenlei, "field 'rl_fenlei' and method 'onClick'");
        mkBookStoreFragment.rl_fenlei = (RelativeLayout) Utils.castView(viewFindRequiredView3, R.id.rl_fenlei, "field 'rl_fenlei'", RelativeLayout.class);
        this.f3740d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkBookStoreFragment));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_rank, "field 'rl_rank' and method 'onClick'");
        mkBookStoreFragment.rl_rank = (RelativeLayout) Utils.castView(viewFindRequiredView4, R.id.rl_rank, "field 'rl_rank'", RelativeLayout.class);
        this.f3741e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkBookStoreFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBookStoreFragment mkBookStoreFragment = this.a;
        if (mkBookStoreFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBookStoreFragment.tb_select_banner1 = null;
        mkBookStoreFragment.tb_select_banner2 = null;
        mkBookStoreFragment.vp_classify = null;
        mkBookStoreFragment.banner1_head = null;
        mkBookStoreFragment.img_banner1 = null;
        mkBookStoreFragment.banner2_head = null;
        mkBookStoreFragment.img_banner2 = null;
        mkBookStoreFragment.img_fenlei = null;
        mkBookStoreFragment.tv_fenlei = null;
        mkBookStoreFragment.img_rank = null;
        mkBookStoreFragment.tv_rank = null;
        mkBookStoreFragment.marqueerewardview = null;
        mkBookStoreFragment.rl_search = null;
        mkBookStoreFragment.rl_fenlei = null;
        mkBookStoreFragment.rl_rank = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f3739c.setOnClickListener(null);
        this.f3739c = null;
        this.f3740d.setOnClickListener(null);
        this.f3740d = null;
        this.f3741e.setOnClickListener(null);
        this.f3741e = null;
    }
}
