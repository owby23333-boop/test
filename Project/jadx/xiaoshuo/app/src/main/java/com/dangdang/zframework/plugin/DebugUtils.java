package com.dangdang.zframework.plugin;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public class DebugUtils {
    private static Boolean isDebug;

    public static boolean isDebug() {
        Boolean bool = isDebug;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void syncIsDebug(Context context) {
        if (isDebug == null) {
            isDebug = Boolean.valueOf((context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true);
        }
    }
}
