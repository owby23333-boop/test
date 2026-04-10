package com.bytedance.adsdk.ugeno.tg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static Resources bf;

    @SuppressLint({"StaticFieldLeak"})
    private static Context d;
    private static String e;

    public static int bf(Context context, String str) {
        return e(context, str, "drawable");
    }

    public static int d(Context context, String str) {
        return e(context, str, "id");
    }

    private static String e(Context context) {
        if (e == null) {
            e = context.getPackageName();
        }
        return e;
    }

    private static int e(Context context, String str, String str2) {
        if (bf == null) {
            bf = context.getResources();
        }
        return bf.getIdentifier(str, str2, e(context));
    }

    public static Drawable e(Context context, String str) {
        return context.getResources().getDrawable(bf(context, str));
    }
}
