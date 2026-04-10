package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.Window;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class ah {
    public static boolean DI() {
        Context context;
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return eVar == null || (context = eVar.getContext()) == null || Wrapper.unwrapContextIfNeed(context).getApplicationContext().getResources().getConfiguration().orientation == 1;
    }

    public static void b(Context context, boolean z2) {
        try {
            Activity activityCv = cv(context);
            if (activityCv == null) {
                return;
            }
            if (z2) {
                if (Build.VERSION.SDK_INT < 19) {
                    activityCv.getWindow().getDecorView().setSystemUiVisibility(8);
                    return;
                } else {
                    activityCv.getWindow().getDecorView().setSystemUiVisibility(1792);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 19) {
                activityCv.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                activityCv.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean cq(Context context) {
        Activity activityCv = cv(context);
        if (activityCv != null) {
            Window window = activityCv.getWindow();
            z = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void cr(Context context) {
        Activity activityCv = cv(context);
        if (activityCv != null) {
            activityCv.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cs(Context context) {
        Activity activityCv = cv(context);
        if (activityCv != null) {
            activityCv.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void ct(Context context) {
        Activity activityCv = cv(context);
        if (activityCv != null) {
            activityCv.setRequestedOrientation(1);
        }
    }

    public static boolean cu(Context context) {
        try {
            return bo.dt(context).getResources().getConfiguration().orientation != 2;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Nullable
    private static Activity cv(Context context) {
        ?? hashSet = new HashSet();
        do {
            hashSet.add(context);
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
        } while (!hashSet.contains(context));
        return null;
    }
}
