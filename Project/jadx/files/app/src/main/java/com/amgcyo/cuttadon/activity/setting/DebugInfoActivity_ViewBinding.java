package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class DebugInfoActivity_ViewBinding implements Unbinder {
    private DebugInfoActivity a;

    @UiThread
    public DebugInfoActivity_ViewBinding(DebugInfoActivity debugInfoActivity, View view) {
        this.a = debugInfoActivity;
        debugInfoActivity.scrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scrollView, "field 'scrollView'", ScrollView.class);
        debugInfoActivity.tv_ping = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ping, "field 'tv_ping'", TextView.class);
        debugInfoActivity.tv_submit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_submit, "field 'tv_submit'", TextView.class);
        debugInfoActivity.et_website = (EditText) Utils.findRequiredViewAsType(view, R.id.et_website, "field 'et_website'", EditText.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DebugInfoActivity debugInfoActivity = this.a;
        if (debugInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        debugInfoActivity.scrollView = null;
        debugInfoActivity.tv_ping = null;
        debugInfoActivity.tv_submit = null;
        debugInfoActivity.et_website = null;
    }
}
