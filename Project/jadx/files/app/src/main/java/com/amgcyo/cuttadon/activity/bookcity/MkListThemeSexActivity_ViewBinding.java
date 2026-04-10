package com.amgcyo.cuttadon.activity.bookcity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkListThemeSexActivity_ViewBinding implements Unbinder {
    private MkListThemeSexActivity a;

    @UiThread
    public MkListThemeSexActivity_ViewBinding(MkListThemeSexActivity mkListThemeSexActivity, View view) {
        this.a = mkListThemeSexActivity;
        mkListThemeSexActivity.textView = (TextView) Utils.findRequiredViewAsType(view, R.id.toolbar_title, "field 'textView'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkListThemeSexActivity mkListThemeSexActivity = this.a;
        if (mkListThemeSexActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkListThemeSexActivity.textView = null;
    }
}
