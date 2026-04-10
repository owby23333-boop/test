package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ArtGuiderDaoliuActivity_ViewBinding implements Unbinder {
    private ArtGuiderDaoliuActivity a;

    @UiThread
    public ArtGuiderDaoliuActivity_ViewBinding(ArtGuiderDaoliuActivity artGuiderDaoliuActivity, View view) {
        this.a = artGuiderDaoliuActivity;
        artGuiderDaoliuActivity.iv_step = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_step, "field 'iv_step'", ImageView.class);
        artGuiderDaoliuActivity.tv_info = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_info, "field 'tv_info'", TextView.class);
        artGuiderDaoliuActivity.btn_kown = (TextView) Utils.findRequiredViewAsType(view, R.id.btn_kown, "field 'btn_kown'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ArtGuiderDaoliuActivity artGuiderDaoliuActivity = this.a;
        if (artGuiderDaoliuActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        artGuiderDaoliuActivity.iv_step = null;
        artGuiderDaoliuActivity.tv_info = null;
        artGuiderDaoliuActivity.btn_kown = null;
    }
}
