package com.amgcyo.cuttadon.activity.user;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ShowCurrentPhoneActivity_ViewBinding implements Unbinder {
    private ShowCurrentPhoneActivity a;

    @UiThread
    public ShowCurrentPhoneActivity_ViewBinding(ShowCurrentPhoneActivity showCurrentPhoneActivity, View view) {
        this.a = showCurrentPhoneActivity;
        showCurrentPhoneActivity.tv_current_login_user = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_current_login_user, "field 'tv_current_login_user'", TextView.class);
        showCurrentPhoneActivity.btn_change = (CommonShapeButton) Utils.findRequiredViewAsType(view, R.id.btn_change, "field 'btn_change'", CommonShapeButton.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ShowCurrentPhoneActivity showCurrentPhoneActivity = this.a;
        if (showCurrentPhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        showCurrentPhoneActivity.tv_current_login_user = null;
        showCurrentPhoneActivity.btn_change = null;
    }
}
