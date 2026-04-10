package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class aq {
    public static boolean dg(Context context) {
        Activity activityEj = com.kwad.sdk.o.m.ej(context);
        if (activityEj != null) {
            Window window = activityEj.getWindow();
            z = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void dh(Context context) {
        Activity activityEj = com.kwad.sdk.o.m.ej(context);
        if (activityEj != null) {
            activityEj.getWindow().clearFlags(1024);
        }
    }

    public static void di(Context context) {
        Activity activityEj = com.kwad.sdk.o.m.ej(context);
        if (activityEj != null) {
            activityEj.setRequestedOrientation(0);
        }
    }

    public static void dj(Context context) {
        Activity activityEj = com.kwad.sdk.o.m.ej(context);
        if (activityEj != null) {
            activityEj.setRequestedOrientation(1);
        }
    }

    public static boolean QW() {
        return isOrientationPortrait();
    }

    public static boolean isOrientationPortrait() {
        return ServiceProvider.Pp().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }

    public static void d(Context context, boolean z) {
        try {
            Activity activityEj = com.kwad.sdk.o.m.ej(context);
            if (activityEj == null) {
                return;
            }
            if (z) {
                activityEj.getWindow().getDecorView().setSystemUiVisibility(1792);
            } else {
                activityEj.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
