package com.xiaomi.onetrack.util;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7700a = "SystemProperties";

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th) {
            Log.e(p.a("SystemProperties"), "get e" + th.getMessage());
            return str2;
        }
    }

    public static String a(String str) {
        return a(str, "");
    }

    public static long a(String str, Long l) {
        try {
            return ((Long) Class.forName("android.os.SystemProperties").getMethod("getLong", String.class, Long.TYPE).invoke(null, str, l)).longValue();
        } catch (Throwable th) {
            Log.e(p.a("SystemProperties"), "getLong e" + th.getMessage());
            return l.longValue();
        }
    }
}
