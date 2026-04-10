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
public class ChangeUserPhoneActivity_ViewBinding implements Unbinder {
    private ChangeUserPhoneActivity a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2914d;

    class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ChangeUserPhoneActivity f2915s;

        a(ChangeUserPhoneActivity_ViewBinding changeUserPhoneActivity_ViewBinding, ChangeUserPhoneActivity changeUserPhoneActivity) {
            this.f2915s = changeUserPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2915s.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ChangeUserPhoneActivity f2916s;

        b(ChangeUserPhoneActivity_ViewBinding changeUserPhoneActivity_ViewBinding, ChangeUserPhoneActivity changeUserPhoneActivity) {
            this.f2916s = changeUserPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2916s.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ChangeUserPhoneActivity f2917s;

        c(ChangeUserPhoneActivity_ViewBinding changeUserPhoneActivity_ViewBinding, ChangeUserPhoneActivity changeUserPhoneActivity) {
            this.f2917s = changeUserPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f2917s.onClick(view);
        }
    }

    @UiThread
    public ChangeUserPhoneActivity_ViewBinding(ChangeUserPhoneActivity changeUserPhoneActivity, View view) {
        this.a = changeUserPhoneActivity;
        changeUserPhoneActivity.etPhoneNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_username, "field 'etPhoneNum'", EditText.class);
        changeUserPhoneActivity.etSmsCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_smsCode, "field 'etSmsCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_getCode, "field 'tv_getCode' and method 'onClick'");
        changeUserPhoneActivity.tv_getCode = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_getCode, "field 'tv_getCode'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, changeUserPhoneActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_reg, "field 'tvReg' and method 'onClick'");
        changeUserPhoneActivity.tvReg = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_reg, "field 'tvReg'", TextView.class);
        this.f2913c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, changeUserPhoneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_countryCode, "field 'tv_countryCode' and method 'onClick'");
        changeUserPhoneActivity.tv_countryCode = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_countryCode, "field 'tv_countryCode'", TextView.class);
        this.f2914d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, changeUserPhoneActivity));
        changeUserPhoneActivity.tv_change_tips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_change_tips, "field 'tv_change_tips'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangeUserPhoneActivity changeUserPhoneActivity = this.a;
        if (changeUserPhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        changeUserPhoneActivity.etPhoneNum = null;
        changeUserPhoneActivity.etSmsCode = null;
        changeUserPhoneActivity.tv_getCode = null;
        changeUserPhoneActivity.tvReg = null;
        changeUserPhoneActivity.tv_countryCode = null;
        changeUserPhoneActivity.tv_change_tips = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.f2913c.setOnClickListener(null);
        this.f2913c = null;
        this.f2914d.setOnClickListener(null);
        this.f2914d = null;
    }
}
