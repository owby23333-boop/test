package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_SP_FILE = "um_rtd_conf";
    public static final String RTD_START_TIME = "startTime";
    static double[] a = null;
    private static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f19389c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f19390d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19391e = 0;
    public static boolean enable = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f19392f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f19393g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f19394h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    static void a(String str) {
        f19389c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f19392f) {
            str = f19394h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f19390d)) {
            f19390d = com.umeng.common.b.a(context).c();
        }
        return f19390d;
    }

    public static int getVerticalType(Context context) {
        if (f19391e == 0) {
            f19391e = com.umeng.common.b.a(context).d();
        }
        return f19391e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z2;
        synchronized (f19392f) {
            z2 = f19393g;
        }
        return z2;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f19392f) {
            f19393g = false;
            f19394h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f19392f) {
            f19393g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f19394h = map.get(DEBUG_KEY);
            }
        }
    }

    static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            f19390d = str;
            com.umeng.common.b.a(context).a(f19390d);
        }
    }

    static void a(Context context, int i2) {
        f19391e = i2;
        com.umeng.common.b.a(context).a(f19391e);
    }
}
