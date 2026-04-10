package com.lcodecore.tkrefreshlayout.h;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: compiled from: DensityUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
