package com.amgcyo.cuttadon.activity.detail;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.comic.TagCloudView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkBookReportActivity_ViewBinding implements Unbinder {
    private MkBookReportActivity a;

    @UiThread
    public MkBookReportActivity_ViewBinding(MkBookReportActivity mkBookReportActivity, View view) {
        this.a = mkBookReportActivity;
        mkBookReportActivity.book_cover_iv = (ImageView) Utils.findRequiredViewAsType(view, R.id.book_cover_iv, "field 'book_cover_iv'", ImageView.class);
        mkBookReportActivity.book_name = (TextView) Utils.findRequiredViewAsType(view, R.id.book_name, "field 'book_name'", TextView.class);
        mkBookReportActivity.book_author = (TextView) Utils.findRequiredViewAsType(view, R.id.book_author, "field 'book_author'", TextView.class);
        mkBookReportActivity.tcv_tag = (TagCloudView) Utils.findRequiredViewAsType(view, R.id.tcv_tag, "field 'tcv_tag'", TagCloudView.class);
        mkBookReportActivity.edit_reason = (EditText) Utils.findRequiredViewAsType(view, R.id.edit_reason, "field 'edit_reason'", EditText.class);
        mkBookReportActivity.tv_submit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_submit, "field 'tv_submit'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkBookReportActivity mkBookReportActivity = this.a;
        if (mkBookReportActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkBookReportActivity.book_cover_iv = null;
        mkBookReportActivity.book_name = null;
        mkBookReportActivity.book_author = null;
        mkBookReportActivity.tcv_tag = null;
        mkBookReportActivity.edit_reason = null;
        mkBookReportActivity.tv_submit = null;
    }
}
