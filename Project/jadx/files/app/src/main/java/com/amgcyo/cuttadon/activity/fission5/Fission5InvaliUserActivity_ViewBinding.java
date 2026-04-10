package com.amgcyo.cuttadon.activity.fission5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.SimpleMarqueeView;

/* JADX INFO: loaded from: classes.dex */
public class Fission5InvaliUserActivity_ViewBinding implements Unbinder {
    private Fission5InvaliUserActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2519e;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5InvaliUserActivity f2520s;

        a(Fission5InvaliUserActivity_ViewBinding fission5InvaliUserActivity_ViewBinding, Fission5InvaliUserActivity fission5InvaliUserActivity) {
            this.f2520s = fission5InvaliUserActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2520s.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5InvaliUserActivity f2521s;

        b(Fission5InvaliUserActivity_ViewBinding fission5InvaliUserActivity_ViewBinding, Fission5InvaliUserActivity fission5InvaliUserActivity) {
            this.f2521s = fission5InvaliUserActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2521s.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5InvaliUserActivity f2522s;

        c(Fission5InvaliUserActivity_ViewBinding fission5InvaliUserActivity_ViewBinding, Fission5InvaliUserActivity fission5InvaliUserActivity) {
            this.f2522s = fission5InvaliUserActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2522s.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission5InvaliUserActivity f2523s;

        d(Fission5InvaliUserActivity_ViewBinding fission5InvaliUserActivity_ViewBinding, Fission5InvaliUserActivity fission5InvaliUserActivity) {
            this.f2523s = fission5InvaliUserActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2523s.onViewClicked(view);
        }
    }

    @UiThread
    public Fission5InvaliUserActivity_ViewBinding(Fission5InvaliUserActivity fission5InvaliUserActivity, View view) {
        this.a = fission5InvaliUserActivity;
        fission5InvaliUserActivity.marqueerewardview = (SimpleMarqueeView) Utils.findRequiredViewAsType(view, R.id.marqueerewardview, "field 'marqueerewardview'", SimpleMarqueeView.class);
        fission5InvaliUserActivity.ll_notice = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_notice, "field 'll_notice'", LinearLayout.class);
        fission5InvaliUserActivity.laba = (ImageView) Utils.findRequiredViewAsType(view, R.id.laba, "field 'laba'", ImageView.class);
        fission5InvaliUserActivity.tv_mycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mycode, "field 'tv_mycode'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_copy0, "field 'tv_copy0' and method 'onViewClicked'");
        fission5InvaliUserActivity.tv_copy0 = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_copy0, "field 'tv_copy0'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, fission5InvaliUserActivity));
        fission5InvaliUserActivity.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
        fission5InvaliUserActivity.tv_day1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day1, "field 'tv_day1'", TextView.class);
        fission5InvaliUserActivity.tv_day2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day2, "field 'tv_day2'", TextView.class);
        fission5InvaliUserActivity.tv_day3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day3, "field 'tv_day3'", TextView.class);
        fission5InvaliUserActivity.tv_ruledesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ruledesc, "field 'tv_ruledesc'", TextView.class);
        fission5InvaliUserActivity.tv_desc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tv_desc'", TextView.class);
        fission5InvaliUserActivity.rl_my_code = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_my_code, "field 'rl_my_code'", RelativeLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.fr_yq, "method 'onViewClicked'");
        this.f2517c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, fission5InvaliUserActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_wx, "method 'onViewClicked'");
        this.f2518d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, fission5InvaliUserActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_qrcode, "method 'onViewClicked'");
        this.f2519e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, fission5InvaliUserActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        Fission5InvaliUserActivity fission5InvaliUserActivity = this.a;
        if (fission5InvaliUserActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        fission5InvaliUserActivity.marqueerewardview = null;
        fission5InvaliUserActivity.ll_notice = null;
        fission5InvaliUserActivity.laba = null;
        fission5InvaliUserActivity.tv_mycode = null;
        fission5InvaliUserActivity.tv_copy0 = null;
        fission5InvaliUserActivity.tv_title = null;
        fission5InvaliUserActivity.tv_day1 = null;
        fission5InvaliUserActivity.tv_day2 = null;
        fission5InvaliUserActivity.tv_day3 = null;
        fission5InvaliUserActivity.tv_ruledesc = null;
        fission5InvaliUserActivity.tv_desc = null;
        fission5InvaliUserActivity.rl_my_code = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2517c.setOnClickListener(null);
        this.f2517c = null;
        this.f2518d.setOnClickListener(null);
        this.f2518d = null;
        this.f2519e.setOnClickListener(null);
        this.f2519e = null;
    }
}
