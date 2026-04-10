package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static final String a = "android.permission.INTERNET";
    public static final String b = "android.permission.ACCESS_NETWORK_STATE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16723c = "android.permission.READ_PHONE_STATE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16724d = "android.permission.ACCESS_WIFI_STATE";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f16725e = "android.permission.GET_TASKS";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16726f = "android.permission.GET_ACCOUNTS";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16727g = "android.permission.ACCESS_FINE_LOCATION";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16728h = "android.permission.ACCESS_COARSE_LOCATION";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16729i = "android.permission.READ_EXTERNAL_STORAGE";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f16730j = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f16731k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    public static int a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            for (String str : strArr) {
                if (a(context, str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
