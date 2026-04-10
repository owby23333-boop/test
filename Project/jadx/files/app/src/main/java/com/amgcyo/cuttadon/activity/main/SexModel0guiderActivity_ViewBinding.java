package com.amgcyo.cuttadon.activity.main;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class SexModel0guiderActivity_ViewBinding implements Unbinder {
    private SexModel0guiderActivity a;

    @UiThread
    public SexModel0guiderActivity_ViewBinding(SexModel0guiderActivity sexModel0guiderActivity, View view) {
        this.a = sexModel0guiderActivity;
        sexModel0guiderActivity.enterApplication = (TextView) Utils.findRequiredViewAsType(view, R.id.enter_application, "field 'enterApplication'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SexModel0guiderActivity sexModel0guiderActivity = this.a;
        if (sexModel0guiderActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        sexModel0guiderActivity.enterApplication = null;
    }
}
