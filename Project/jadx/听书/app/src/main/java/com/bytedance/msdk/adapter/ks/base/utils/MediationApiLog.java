package com.bytedance.msdk.adapter.ks.base.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MediationApiLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f347a = false;
    private static String b = "MEDIATION_LOG";

    public static void e(String str) {
        if (f347a) {
            Log.e(b, str);
        }
    }

    public static void e(String str, String str2) {
        if (f347a) {
            Log.e(str, str2);
        }
    }

    public static void i(String str) {
        if (f347a) {
            Log.i(b, str);
        }
    }

    public static void i(String str, String str2) {
        if (f347a) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        f347a = bool.booleanValue();
    }
}
