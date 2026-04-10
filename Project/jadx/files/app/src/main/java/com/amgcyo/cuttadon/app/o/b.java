package com.amgcyo.cuttadon.app.o;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: MkSystemBarUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Activity activity) {
        a(activity, 5380);
    }

    public static void a(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }
    }
}
