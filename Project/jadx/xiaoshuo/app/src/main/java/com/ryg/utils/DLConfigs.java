package com.ryg.utils;

import android.annotation.TargetApi;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class DLConfigs {
    public static final boolean LOG = true;
    public static ClassLoader sPluginClassloader = DLConstants.class.getClassLoader();

    @TargetApi(11)
    public static long getSoLastModifiedTime(Context context, String str) {
        return context.getSharedPreferences(DLConstants.PREFERENCE_NAME, 4).getLong(str, 0L);
    }

    @TargetApi(11)
    public static void setSoLastModifiedTime(Context context, String str, long j) {
        context.getSharedPreferences(DLConstants.PREFERENCE_NAME, 4).edit().putLong(str, j).apply();
    }
}
