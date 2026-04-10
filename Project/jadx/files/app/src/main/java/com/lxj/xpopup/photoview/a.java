package com.lxj.xpopup.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: Compat.java */
/* JADX INFO: loaded from: classes3.dex */
class a {
    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
