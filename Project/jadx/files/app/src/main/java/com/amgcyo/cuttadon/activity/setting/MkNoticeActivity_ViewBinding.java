package com.amgcyo.cuttadon.activity.setting;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkNoticeActivity_ViewBinding implements Unbinder {
    private MkNoticeActivity a;

    @UiThread
    public MkNoticeActivity_ViewBinding(MkNoticeActivity mkNoticeActivity, View view) {
        this.a = mkNoticeActivity;
        mkNoticeActivity.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
        mkNoticeActivity.tvMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg, "field 'tvMsg'", TextView.class);
        mkNoticeActivity.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        mkNoticeActivity.tvSubmit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
        mkNoticeActivity.notic_view = Utils.findRequiredView(view, R.id.notic_view, "field 'notic_view'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkNoticeActivity mkNoticeActivity = this.a;
        if (mkNoticeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkNoticeActivity.tv_title = null;
        mkNoticeActivity.tvMsg = null;
        mkNoticeActivity.tvCancel = null;
        mkNoticeActivity.tvSubmit = null;
        mkNoticeActivity.notic_view = null;
    }
}
