package com.amgcyo.cuttadon.activity.user;

import android.view.View;
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
public class MkUpdatePwdActivity_ViewBinding implements Unbinder {
    private MkUpdatePwdActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2933d;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUpdatePwdActivity f2934s;

        a(MkUpdatePwdActivity_ViewBinding mkUpdatePwdActivity_ViewBinding, MkUpdatePwdActivity mkUpdatePwdActivity) {
            this.f2934s = mkUpdatePwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2934s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUpdatePwdActivity f2935s;

        b(MkUpdatePwdActivity_ViewBinding mkUpdatePwdActivity_ViewBinding, MkUpdatePwdActivity mkUpdatePwdActivity) {
            this.f2935s = mkUpdatePwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2935s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkUpdatePwdActivity f2936s;

        c(MkUpdatePwdActivity_ViewBinding mkUpdatePwdActivity_ViewBinding, MkUpdatePwdActivity mkUpdatePwdActivity) {
            this.f2936s = mkUpdatePwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2936s.onClick(view);
        }
    }

    @UiThread
    public MkUpdatePwdActivity_ViewBinding(MkUpdatePwdActivity mkUpdatePwdActivity, View view) {
        this.a = mkUpdatePwdActivity;
        mkUpdatePwdActivity.etOldPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_old_pwd, "field 'etOldPwd'", EditText.class);
        mkUpdatePwdActivity.etNewPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_new_pwd, "field 'etNewPwd'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_update_pwd, "field 'tvUpdatePwd' and method 'onClick'");
        mkUpdatePwdActivity.tvUpdatePwd = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_update_pwd, "field 'tvUpdatePwd'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkUpdatePwdActivity));
        mkUpdatePwdActivity.llRoot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root, "field 'llRoot'", LinearLayout.class);
        mkUpdatePwdActivity.etPasswordConfirm = (EditText) Utils.findRequiredViewAsType(view, R.id.et_password_confirm, "field 'etPasswordConfirm'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_exitupdate_pwd, "method 'onClick'");
        this.f2932c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkUpdatePwdActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_find_pwd, "method 'onClick'");
        this.f2933d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, mkUpdatePwdActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkUpdatePwdActivity mkUpdatePwdActivity = this.a;
        if (mkUpdatePwdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkUpdatePwdActivity.etOldPwd = null;
        mkUpdatePwdActivity.etNewPwd = null;
        mkUpdatePwdActivity.tvUpdatePwd = null;
        mkUpdatePwdActivity.llRoot = null;
        mkUpdatePwdActivity.etPasswordConfirm = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2932c.setOnClickListener(null);
        this.f2932c = null;
        this.f2933d.setOnClickListener(null);
        this.f2933d = null;
    }
}
