package com.amgcyo.cuttadon.activity.user;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkUserLoginActivity_ViewBinding implements Unbinder {
    private MkUserLoginActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f2945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2946h;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2947s;

        a(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2947s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2947s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2948s;

        b(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2948s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2948s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2949s;

        c(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2949s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2949s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2950s;

        d(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2950s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2950s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2951s;

        e(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2951s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2951s.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2952s;

        f(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2952s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2952s.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserLoginActivity f2953s;

        g(MkUserLoginActivity_ViewBinding mkUserLoginActivity_ViewBinding, MkUserLoginActivity mkUserLoginActivity) {
            this.f2953s = mkUserLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2953s.onClick(view);
        }
    }

    @UiThread
    public MkUserLoginActivity_ViewBinding(MkUserLoginActivity mkUserLoginActivity, View view) {
        this.a = mkUserLoginActivity;
        mkUserLoginActivity.etPhoneNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_username, "field 'etPhoneNum'", EditText.class);
        mkUserLoginActivity.etPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_pwd, "field 'etPwd'", EditText.class);
        mkUserLoginActivity.tvLogin = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_login, "field 'tvLogin'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_useragree, "field 'tvUseragree' and method 'onClick'");
        mkUserLoginActivity.tvUseragree = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_useragree, "field 'tvUseragree'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkUserLoginActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_privacy, "field 'tvPrivacy' and method 'onClick'");
        mkUserLoginActivity.tvPrivacy = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_privacy, "field 'tvPrivacy'", TextView.class);
        this.f2941c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkUserLoginActivity));
        mkUserLoginActivity.tv_welcome = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_welcome, "field 'tv_welcome'", TextView.class);
        mkUserLoginActivity.checkbox_private = (CheckBox) Utils.findRequiredViewAsType(view, R.id.checkbox_private, "field 'checkbox_private'", CheckBox.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_tip, "field 'll_tip' and method 'onClick'");
        mkUserLoginActivity.ll_tip = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.ll_tip, "field 'll_tip'", LinearLayout.class);
        this.f2942d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkUserLoginActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_countryCode, "field 'tv_countryCode' and method 'onClick'");
        mkUserLoginActivity.tv_countryCode = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_countryCode, "field 'tv_countryCode'", TextView.class);
        this.f2943e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkUserLoginActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_exitLogin, "method 'onClick'");
        this.f2944f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkUserLoginActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_reg, "method 'onClick'");
        this.f2945g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, mkUserLoginActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.iv_find_pwd, "method 'onClick'");
        this.f2946h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, mkUserLoginActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkUserLoginActivity mkUserLoginActivity = this.a;
        if (mkUserLoginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkUserLoginActivity.etPhoneNum = null;
        mkUserLoginActivity.etPwd = null;
        mkUserLoginActivity.tvLogin = null;
        mkUserLoginActivity.tvUseragree = null;
        mkUserLoginActivity.tvPrivacy = null;
        mkUserLoginActivity.tv_welcome = null;
        mkUserLoginActivity.checkbox_private = null;
        mkUserLoginActivity.ll_tip = null;
        mkUserLoginActivity.tv_countryCode = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2941c.setOnClickListener(null);
        this.f2941c = null;
        this.f2942d.setOnClickListener(null);
        this.f2942d = null;
        this.f2943e.setOnClickListener(null);
        this.f2943e = null;
        this.f2944f.setOnClickListener(null);
        this.f2944f = null;
        this.f2945g.setOnClickListener(null);
        this.f2945g = null;
        this.f2946h.setOnClickListener(null);
        this.f2946h = null;
    }
}
