package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class ay {
    public static boolean Eo() {
        return x.i("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void Ep() {
        x.h("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void Eq() {
        x.h("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean Er() {
        return x.i("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void Es() {
        x.h("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean Et() {
        return x.i("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void Eu() {
        x.h("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean Ev() {
        return x.i("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String ap(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String strD = com.kwad.sdk.crash.utils.h.D(file);
            return TextUtils.isEmpty(strD) ? "" : strD;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void k(final Context context, final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.ay.1
            @Override // java.lang.Runnable
            public final void run() {
                ay.l(context, str, str2);
            }
        });
    }

    public static void l(Context context, String str, String str2) {
        com.kwad.sdk.crash.utils.h.g(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        Ep();
    }
}
