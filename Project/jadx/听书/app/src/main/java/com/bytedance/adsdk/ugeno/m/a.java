package com.bytedance.adsdk.ugeno.m;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static Context dl;
    private static Resources g;
    private static String z;

    private static String z(Context context) {
        if (z == null) {
            z = context.getPackageName();
        }
        return z;
    }

    private static int z(Context context, String str, String str2) {
        if (g == null) {
            g = context.getResources();
        }
        return g.getIdentifier(str, str2, z(context));
    }

    public static int z(Context context, String str) {
        return z(context, str, "raw");
    }

    public static int g(Context context, String str) {
        return z(context, str, "drawable");
    }

    public static int dl(Context context, String str) {
        return z(context, str, "id");
    }
}
