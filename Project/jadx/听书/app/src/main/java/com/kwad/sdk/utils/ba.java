package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class ba {
    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk() ? "com.kwad.sdk" : context.getPackageName();
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    public static int getAppIconId(Context context) {
        int i;
        try {
            i = y.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i = 0;
        }
        return i <= 0 ? aw(context, "ksad_notification_small_icon") : i;
    }

    public static int aw(Context context, String str) {
        Resources resourcesDn = dn(context);
        if (resourcesDn == null) {
            resourcesDn = context.getResources();
        }
        return resourcesDn.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources dn(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.Pp().getResources();
    }
}
