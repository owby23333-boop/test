package com.amgcyo.cuttadon.h.i.h;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: SplashViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
