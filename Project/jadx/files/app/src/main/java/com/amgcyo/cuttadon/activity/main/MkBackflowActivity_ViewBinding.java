package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBackflowActivity_ViewBinding implements Unbinder {
    private MkBackflowActivity a;

    @UiThread
    public MkBackflowActivity_ViewBinding(MkBackflowActivity mkBackflowActivity, View view) {
        this.a = mkBackflowActivity;
        mkBackflowActivity.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
        mkBackflowActivity.tvMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg, "field 'tvMsg'", TextView.class);
        mkBackflowActivity.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        mkBackflowActivity.tvSubmit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
        mkBackflowActivity.notic_view = Utils.findRequiredView(view, R.id.notic_view, "field 'notic_view'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBackflowActivity mkBackflowActivity = this.a;
        if (mkBackflowActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBackflowActivity.tv_title = null;
        mkBackflowActivity.tvMsg = null;
        mkBackflowActivity.tvCancel = null;
        mkBackflowActivity.tvSubmit = null;
        mkBackflowActivity.notic_view = null;
    }
}
