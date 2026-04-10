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
public class MkUserRegActivity_ViewBinding implements Unbinder {
    private MkUserRegActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f2984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f2985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f2986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f2987h;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2988s;

        a(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2988s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2988s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2989s;

        b(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2989s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2989s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2990s;

        c(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2990s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2990s.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2991s;

        d(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2991s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2991s.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2992s;

        e(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2992s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2992s.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2993s;

        f(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2993s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2993s.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUserRegActivity f2994s;

        g(MkUserRegActivity_ViewBinding mkUserRegActivity_ViewBinding, MkUserRegActivity mkUserRegActivity) {
            this.f2994s = mkUserRegActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2994s.onClick(view);
        }
    }

    @UiThread
    public MkUserRegActivity_ViewBinding(MkUserRegActivity mkUserRegActivity, View view) {
        this.a = mkUserRegActivity;
        mkUserRegActivity.etPhoneNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_username, "field 'etPhoneNum'", EditText.class);
        mkUserRegActivity.etPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_pwd, "field 'etPwd'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_reg, "field 'tvReg' and method 'onClick'");
        mkUserRegActivity.tvReg = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_reg, "field 'tvReg'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkUserRegActivity));
        mkUserRegActivity.view_codeline = Utils.findRequiredView(view, R.id.view_codeline, "field 'view_codeline'");
        mkUserRegActivity.etSmsCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_smsCode, "field 'etSmsCode'", EditText.class);
        mkUserRegActivity.et_invitation_code = (EditText) Utils.findRequiredViewAsType(view, R.id.et_invitation_code, "field 'et_invitation_code'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_getCode, "field 'tvGetCode' and method 'onClick'");
        mkUserRegActivity.tvGetCode = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_getCode, "field 'tvGetCode'", TextView.class);
        this.f2982c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkUserRegActivity));
        mkUserRegActivity.cus_info = (TextView) Utils.findRequiredViewAsType(view, R.id.cus_info, "field 'cus_info'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_countryCode, "field 'tv_countryCode' and method 'onClick'");
        mkUserRegActivity.tv_countryCode = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_countryCode, "field 'tv_countryCode'", TextView.class);
        this.f2983d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkUserRegActivity));
        mkUserRegActivity.view_line_invli = Utils.findRequiredView(view, R.id.view_line_invli, "field 'view_line_invli'");
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_tip, "field 'll_tip' and method 'onClick'");
        mkUserRegActivity.ll_tip = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_tip, "field 'll_tip'", LinearLayout.class);
        this.f2984e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, mkUserRegActivity));
        mkUserRegActivity.checkbox_private = (CheckBox) Utils.findRequiredViewAsType(view, R.id.checkbox_private, "field 'checkbox_private'", CheckBox.class);
        mkUserRegActivity.ll_valicode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_valicode, "field 'll_valicode'", LinearLayout.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_exitreg, "method 'onClick'");
        this.f2985f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, mkUserRegActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_useragree, "method 'onClick'");
        this.f2986g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, mkUserRegActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_privacy, "method 'onClick'");
        this.f2987h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(this, mkUserRegActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkUserRegActivity mkUserRegActivity = this.a;
        if (mkUserRegActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkUserRegActivity.etPhoneNum = null;
        mkUserRegActivity.etPwd = null;
        mkUserRegActivity.tvReg = null;
        mkUserRegActivity.view_codeline = null;
        mkUserRegActivity.etSmsCode = null;
        mkUserRegActivity.et_invitation_code = null;
        mkUserRegActivity.tvGetCode = null;
        mkUserRegActivity.cus_info = null;
        mkUserRegActivity.tv_countryCode = null;
        mkUserRegActivity.view_line_invli = null;
        mkUserRegActivity.ll_tip = null;
        mkUserRegActivity.checkbox_private = null;
        mkUserRegActivity.ll_valicode = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2982c.setOnClickListener(null);
        this.f2982c = null;
        this.f2983d.setOnClickListener(null);
        this.f2983d = null;
        this.f2984e.setOnClickListener(null);
        this.f2984e = null;
        this.f2985f.setOnClickListener(null);
        this.f2985f = null;
        this.f2986g.setOnClickListener(null);
        this.f2986g = null;
        this.f2987h.setOnClickListener(null);
        this.f2987h = null;
    }
}
