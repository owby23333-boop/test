package com.amgcyo.cuttadon.activity.user;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkCancelAccountActivity_ViewBinding implements Unbinder {
    private MkCancelAccountActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2922c;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCancelAccountActivity f2923s;

        a(MkCancelAccountActivity_ViewBinding mkCancelAccountActivity_ViewBinding, MkCancelAccountActivity mkCancelAccountActivity) {
            this.f2923s = mkCancelAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2923s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MkCancelAccountActivity f2924s;

        b(MkCancelAccountActivity_ViewBinding mkCancelAccountActivity_ViewBinding, MkCancelAccountActivity mkCancelAccountActivity) {
            this.f2924s = mkCancelAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2924s.onClick(view);
        }
    }

    @UiThread
    public MkCancelAccountActivity_ViewBinding(MkCancelAccountActivity mkCancelAccountActivity, View view) {
        this.a = mkCancelAccountActivity;
        mkCancelAccountActivity.etPhoneNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_username, "field 'etPhoneNum'", EditText.class);
        mkCancelAccountActivity.etSmsCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_smsCode, "field 'etSmsCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_getCode, "field 'tv_getCode' and method 'onClick'");
        mkCancelAccountActivity.tv_getCode = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_getCode, "field 'tv_getCode'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, mkCancelAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_reg, "field 'tvReg' and method 'onClick'");
        mkCancelAccountActivity.tvReg = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_reg, "field 'tvReg'", TextView.class);
        this.f2922c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, mkCancelAccountActivity));
        mkCancelAccountActivity.tv_countryCode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_countryCode, "field 'tv_countryCode'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkCancelAccountActivity mkCancelAccountActivity = this.a;
        if (mkCancelAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkCancelAccountActivity.etPhoneNum = null;
        mkCancelAccountActivity.etSmsCode = null;
        mkCancelAccountActivity.tv_getCode = null;
        mkCancelAccountActivity.tvReg = null;
        mkCancelAccountActivity.tv_countryCode = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2922c.setOnClickListener(null);
        this.f2922c = null;
    }
}
