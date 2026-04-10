package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkAboutActivity_ViewBinding implements Unbinder {
    private MkAboutActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f2814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2815h;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2816s;

        a(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2816s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2816s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2817s;

        b(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2817s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2817s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2818s;

        c(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2818s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2818s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2819s;

        d(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2819s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2819s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2820s;

        e(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2820s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2820s.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2821s;

        f(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2821s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2821s.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkAboutActivity f2822s;

        g(MkAboutActivity_ViewBinding mkAboutActivity_ViewBinding, MkAboutActivity mkAboutActivity) {
            this.f2822s = mkAboutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2822s.onClick(view);
        }
    }

    @UiThread
    public MkAboutActivity_ViewBinding(MkAboutActivity mkAboutActivity, View view) {
        this.a = mkAboutActivity;
        mkAboutActivity.tvVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_version, "field 'tvVersion'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_website, "field 'll_website' and method 'onClick'");
        mkAboutActivity.ll_website = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_website, "field 'll_website'", LinearLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkAboutActivity));
        mkAboutActivity.tv_sebsite = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sebsite, "field 'tv_sebsite'", TextView.class);
        mkAboutActivity.tv_kefu = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_kefu, "field 'tv_kefu'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_logo, "field 'iv_logo' and method 'onClick'");
        mkAboutActivity.iv_logo = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_logo, "field 'iv_logo'", ImageView.class);
        this.f2810c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkAboutActivity));
        mkAboutActivity.view_line = Utils.findRequiredView(view, R.id.view_line, "field 'view_line'");
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_update, "method 'onClick'");
        this.f2811d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkAboutActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_service, "method 'onClick'");
        this.f2812e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkAboutActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_haoping, "method 'onClick'");
        this.f2813f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkAboutActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_useragree, "method 'onClick'");
        this.f2814g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, mkAboutActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_privacy, "method 'onClick'");
        this.f2815h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, mkAboutActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkAboutActivity mkAboutActivity = this.a;
        if (mkAboutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkAboutActivity.tvVersion = null;
        mkAboutActivity.ll_website = null;
        mkAboutActivity.tv_sebsite = null;
        mkAboutActivity.tv_kefu = null;
        mkAboutActivity.iv_logo = null;
        mkAboutActivity.view_line = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2810c.setOnClickListener(null);
        this.f2810c = null;
        this.f2811d.setOnClickListener(null);
        this.f2811d = null;
        this.f2812e.setOnClickListener(null);
        this.f2812e = null;
        this.f2813f.setOnClickListener(null);
        this.f2813f = null;
        this.f2814g.setOnClickListener(null);
        this.f2814g = null;
        this.f2815h.setOnClickListener(null);
        this.f2815h = null;
    }
}
