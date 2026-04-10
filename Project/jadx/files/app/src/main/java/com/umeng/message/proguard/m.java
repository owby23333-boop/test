package com.umeng.message.proguard;

import android.content.Context;

/* JADX INFO: compiled from: SizeFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    private static float a = 1.0f;

    private static void a(Context context) {
        a = context.getResources().getDisplayMetrics().density;
    }

    public static int a(Context context, float f2) {
        a(context);
        return (int) ((f2 * a) + 0.5f);
    }
}
