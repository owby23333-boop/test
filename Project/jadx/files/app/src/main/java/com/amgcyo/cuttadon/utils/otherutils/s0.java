package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;

/* JADX INFO: compiled from: TextSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class s0 {
    public static int a(Context context, int i2) {
        return (int) ((i2 * a(context)) + 0.5f);
    }

    private static int a(Context context) {
        return (int) (context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
