package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class UmPushBookDialogActivity_ViewBinding implements Unbinder {
    private UmPushBookDialogActivity a;

    @UiThread
    public UmPushBookDialogActivity_ViewBinding(UmPushBookDialogActivity umPushBookDialogActivity, View view) {
        this.a = umPushBookDialogActivity;
        umPushBookDialogActivity.tv_tips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tips, "field 'tv_tips'", TextView.class);
        umPushBookDialogActivity.tv_author = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_author, "field 'tv_author'", TextView.class);
        umPushBookDialogActivity.tv_word_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_word_count, "field 'tv_word_count'", TextView.class);
        umPushBookDialogActivity.btn_add_shelf = (TextView) Utils.findRequiredViewAsType(view, R.id.btn_add_shelf, "field 'btn_add_shelf'", TextView.class);
        umPushBookDialogActivity.btn_exit = (TextView) Utils.findRequiredViewAsType(view, R.id.btn_exit, "field 'btn_exit'", TextView.class);
        umPushBookDialogActivity.iv_close = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'iv_close'", ImageView.class);
        umPushBookDialogActivity.book_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.book_cover, "field 'book_cover'", ImageView.class);
        umPushBookDialogActivity.ff = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.ff, "field 'ff'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UmPushBookDialogActivity umPushBookDialogActivity = this.a;
        if (umPushBookDialogActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        umPushBookDialogActivity.tv_tips = null;
        umPushBookDialogActivity.tv_author = null;
        umPushBookDialogActivity.tv_word_count = null;
        umPushBookDialogActivity.btn_add_shelf = null;
        umPushBookDialogActivity.btn_exit = null;
        umPushBookDialogActivity.iv_close = null;
        umPushBookDialogActivity.book_cover = null;
        umPushBookDialogActivity.ff = null;
    }
}
