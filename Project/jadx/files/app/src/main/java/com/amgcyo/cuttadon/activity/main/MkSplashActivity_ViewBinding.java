package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkSplashActivity_ViewBinding implements Unbinder {
    private MkSplashActivity a;

    @UiThread
    public MkSplashActivity_ViewBinding(MkSplashActivity mkSplashActivity, View view) {
        this.a = mkSplashActivity;
        mkSplashActivity.rl_root = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_root, "field 'rl_root'", RelativeLayout.class);
        mkSplashActivity.tv_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg, "field 'tv_msg'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkSplashActivity mkSplashActivity = this.a;
        if (mkSplashActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkSplashActivity.rl_root = null;
        mkSplashActivity.tv_msg = null;
    }
}
