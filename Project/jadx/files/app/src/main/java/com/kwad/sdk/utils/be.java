package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class be {
    public static void a(long j2, int i2, @Nullable Context context) {
        if (j2 == 0 || context == null || i2 <= 0 || i2 > 100) {
            return;
        }
        long jCurrentTimeMillis = j2 - System.currentTimeMillis();
        (Math.abs(jCurrentTimeMillis) / 3600000 > ((long) i2) ? context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong("key_time_diff_s2c", jCurrentTimeMillis) : context.getSharedPreferences("ksadsdk_pref", 0).edit().remove("key_time_diff_s2c")).apply();
    }

    public static long v(@Nullable Context context, boolean z2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z2) {
            return jCurrentTimeMillis;
        }
        if (context != null) {
            long j2 = context.getSharedPreferences("ksadsdk_pref", 0).getLong("key_time_diff_s2c", 0L);
            if (j2 != 0) {
                return jCurrentTimeMillis + j2;
            }
        }
        return Math.abs(jCurrentTimeMillis);
    }
}
