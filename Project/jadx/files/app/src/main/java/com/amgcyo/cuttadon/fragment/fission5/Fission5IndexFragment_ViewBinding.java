package com.amgcyo.cuttadon.fragment.fission5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.ImageCycleView;
import com.amgcyo.cuttadon.view.smilerefresh.MkPullToRefresh;
import com.amgcyo.cuttadon.widget.ui.ObservableScrollView;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.SimpleMarqueeView;

/* JADX INFO: loaded from: classes.dex */
public class Fission5IndexFragment_ViewBinding implements Unbinder {
    private Fission5IndexFragment a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f3832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f3833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f3834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f3835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f3836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f3837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f3838i;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3839s;

        a(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3839s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3839s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3840s;

        b(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3840s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3840s.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3841s;

        c(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3841s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3841s.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3842s;

        d(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3842s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3842s.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3843s;

        e(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3843s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3843s.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3844s;

        f(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3844s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3844s.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3845s;

        g(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3845s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3845s.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5IndexFragment f3846s;

        h(Fission5IndexFragment_ViewBinding fission5IndexFragment_ViewBinding, Fission5IndexFragment fission5IndexFragment) {
            this.f3846s = fission5IndexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f3846s.onViewClicked(view);
        }
    }

    @UiThread
    public Fission5IndexFragment_ViewBinding(Fission5IndexFragment fission5IndexFragment, View view) {
        this.a = fission5IndexFragment;
        fission5IndexFragment.ll_notice = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_notice, "field 'll_notice'", LinearLayout.class);
        fission5IndexFragment.cd_notice = (CardView) Utils.findRequiredViewAsType(view, R.id.cd_notice, "field 'cd_notice'", CardView.class);
        fission5IndexFragment.laba = (ImageView) Utils.findRequiredViewAsType(view, R.id.laba, "field 'laba'", ImageView.class);
        fission5IndexFragment.marqueerewardview = (SimpleMarqueeView) Utils.findRequiredViewAsType(view, R.id.marqueerewardview, "field 'marqueerewardview'", SimpleMarqueeView.class);
        fission5IndexFragment.llBar = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_bar, "field 'llBar'", LinearLayout.class);
        fission5IndexFragment.image = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'image'", ImageView.class);
        fission5IndexFragment.text = (TextView) Utils.findRequiredViewAsType(view, R.id.text, "field 'text'", TextView.class);
        fission5IndexFragment.rlEmpty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_empty, "field 'rlEmpty'", RelativeLayout.class);
        fission5IndexFragment.iv = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv, "field 'iv'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_login, "field 'tvLogin' and method 'onViewClicked'");
        fission5IndexFragment.tvLogin = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_login, "field 'tvLogin'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5IndexFragment));
        fission5IndexFragment.llNologin = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_nologin, "field 'llNologin'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_coin, "field 'tvCoin' and method 'onViewClicked'");
        fission5IndexFragment.tvCoin = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_coin, "field 'tvCoin'", TextView.class);
        this.f3832c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission5IndexFragment));
        fission5IndexFragment.tvMoney = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_money, "field 'tvMoney'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_login_dh, "field 'tvLoginDh' and method 'onViewClicked'");
        fission5IndexFragment.tvLoginDh = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_login_dh, "field 'tvLoginDh'", TextView.class);
        this.f3833d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, fission5IndexFragment));
        fission5IndexFragment.llLogin = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_login, "field 'llLogin'", LinearLayout.class);
        fission5IndexFragment.icvTopView = (ImageCycleView) Utils.findRequiredViewAsType(view, R.id.icv_topView, "field 'icvTopView'", ImageCycleView.class);
        fission5IndexFragment.rvDaylist = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_daylist, "field 'rvDaylist'", RecyclerView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_rule_text, "field 'tvRuleText' and method 'onViewClicked'");
        fission5IndexFragment.tvRuleText = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_rule_text, "field 'tvRuleText'", TextView.class);
        this.f3834e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, fission5IndexFragment));
        fission5IndexFragment.mRefreshView = (MkPullToRefresh) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mRefreshView'", MkPullToRefresh.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_bx, "field 'tvBx' and method 'onViewClicked'");
        fission5IndexFragment.tvBx = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_bx, "field 'tvBx'", TextView.class);
        this.f3835f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, fission5IndexFragment));
        fission5IndexFragment.tv_yuan = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_yuan, "field 'tv_yuan'", TextView.class);
        fission5IndexFragment.view_line = Utils.findRequiredView(view, R.id.view_line, "field 'view_line'");
        fission5IndexFragment.tv_tipsmoney = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tipsmoney, "field 'tv_tipsmoney'", TextView.class);
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.img_box, "field 'img_box' and method 'onViewClicked'");
        fission5IndexFragment.img_box = (ImageView) Utils.castView(viewFindRequiredView6, R.id.img_box, "field 'img_box'", ImageView.class);
        this.f3836g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, fission5IndexFragment));
        fission5IndexFragment.card_view_banner = (CardView) Utils.findRequiredViewAsType(view, R.id.card_view_banner, "field 'card_view_banner'", CardView.class);
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.ll_bottom_tips, "field 'll_bottom_tips' and method 'onViewClicked'");
        fission5IndexFragment.ll_bottom_tips = (LinearLayout) Utils.castView(viewFindRequiredView7, R.id.ll_bottom_tips, "field 'll_bottom_tips'", LinearLayout.class);
        this.f3837h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, fission5IndexFragment));
        fission5IndexFragment.observableScrollView = (ObservableScrollView) Utils.findRequiredViewAsType(view, R.id.observablescrollview, "field 'observableScrollView'", ObservableScrollView.class);
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.rl_money, "method 'onViewClicked'");
        this.f3838i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(this, fission5IndexFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5IndexFragment fission5IndexFragment = this.a;
        if (fission5IndexFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5IndexFragment.ll_notice = null;
        fission5IndexFragment.cd_notice = null;
        fission5IndexFragment.laba = null;
        fission5IndexFragment.marqueerewardview = null;
        fission5IndexFragment.llBar = null;
        fission5IndexFragment.image = null;
        fission5IndexFragment.text = null;
        fission5IndexFragment.rlEmpty = null;
        fission5IndexFragment.iv = null;
        fission5IndexFragment.tvLogin = null;
        fission5IndexFragment.llNologin = null;
        fission5IndexFragment.tvCoin = null;
        fission5IndexFragment.tvMoney = null;
        fission5IndexFragment.tvLoginDh = null;
        fission5IndexFragment.llLogin = null;
        fission5IndexFragment.icvTopView = null;
        fission5IndexFragment.rvDaylist = null;
        fission5IndexFragment.tvRuleText = null;
        fission5IndexFragment.mRefreshView = null;
        fission5IndexFragment.tvBx = null;
        fission5IndexFragment.tv_yuan = null;
        fission5IndexFragment.view_line = null;
        fission5IndexFragment.tv_tipsmoney = null;
        fission5IndexFragment.img_box = null;
        fission5IndexFragment.card_view_banner = null;
        fission5IndexFragment.ll_bottom_tips = null;
        fission5IndexFragment.observableScrollView = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f3832c.setOnClickListener(null);
        this.f3832c = null;
        this.f3833d.setOnClickListener(null);
        this.f3833d = null;
        this.f3834e.setOnClickListener(null);
        this.f3834e = null;
        this.f3835f.setOnClickListener(null);
        this.f3835f = null;
        this.f3836g.setOnClickListener(null);
        this.f3836g = null;
        this.f3837h.setOnClickListener(null);
        this.f3837h = null;
        this.f3838i.setOnClickListener(null);
        this.f3838i = null;
    }
}
