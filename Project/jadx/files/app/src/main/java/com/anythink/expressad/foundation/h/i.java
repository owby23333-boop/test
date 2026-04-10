package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final String a = "layout";
    public static final String b = "id";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10645c = "drawable";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10646d = "color";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10647e = "style";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10648f = "anim";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10649g = "string";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10650h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10651i = "ResourceUtil";

    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e2) {
                o.d(f10651i, "Resource error:" + e2.getMessage());
            }
        }
        return null;
    }

    public static int a(Context context, String str, String str2) {
        String packageName = "";
        try {
            try {
                packageName = com.anythink.expressad.foundation.b.a.b().a();
            } catch (Exception unused) {
                o.d(f10651i, "ATSDKContext.getInstance() is null resName:".concat(String.valueOf(str)));
            }
            if (w.a(packageName) && context != null) {
                packageName = context.getPackageName();
            }
            if (w.a(packageName) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, packageName);
        } catch (Exception unused2) {
            o.d(f10651i, "Resource not found resName:".concat(String.valueOf(str)));
            return -1;
        }
    }
}
