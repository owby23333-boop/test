package com.amgcyo.cuttadon.sdk.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MyBaseAdActivity_ViewBinding implements Unbinder {
    private MyBaseAdActivity a;

    @UiThread
    public MyBaseAdActivity_ViewBinding(MyBaseAdActivity myBaseAdActivity, View view) {
        this.a = myBaseAdActivity;
        myBaseAdActivity.mSplashContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.splash_container, "field 'mSplashContainer'", FrameLayout.class);
        myBaseAdActivity.ll_root = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_root, "field 'll_root'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MyBaseAdActivity myBaseAdActivity = this.a;
        if (myBaseAdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        myBaseAdActivity.mSplashContainer = null;
        myBaseAdActivity.ll_root = null;
    }
}
