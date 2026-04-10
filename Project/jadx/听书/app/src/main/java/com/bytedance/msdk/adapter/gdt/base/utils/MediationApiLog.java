package com.bytedance.msdk.adapter.gdt.base.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MediationApiLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f332a = false;
    private static String b = "MEDIATION_LOG";

    public static void e(String str) {
        if (f332a) {
            Log.e(b, str);
        }
    }

    public static void e(String str, String str2) {
        if (f332a) {
            Log.e(str, str2);
        }
    }

    public static void i(String str) {
        if (f332a) {
            Log.i(b, str);
        }
    }

    public static void i(String str, String str2) {
        if (f332a) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        f332a = bool.booleanValue();
    }
}
