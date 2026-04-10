package com.xuexiang.xupdate.logs;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateLog {
    private static final int MAX_LOG_PRIORITY = 10;
    private static final int MIN_LOG_PRIORITY = 0;
    private static ILogger sILogger = new LogcatLogger();
    public static final String DEFAULT_LOG_TAG = "[XUpdate]";
    private static String sTag = DEFAULT_LOG_TAG;
    private static boolean sIsDebug = false;
    private static int sLogPriority = 10;

    private UpdateLog() {
        throw new UnsupportedOperationException("Do not need instantiate!");
    }

    public static void setLogger(ILogger iLogger) {
        sILogger = iLogger;
    }

    public static void setTag(String str) {
        sTag = str;
    }

    public static void setDebug(boolean z) {
        sIsDebug = z;
    }

    public static void setPriority(int i) {
        sLogPriority = i;
    }

    public static void debug(boolean z) {
        if (z) {
            debug(DEFAULT_LOG_TAG);
        } else {
            debug("");
        }
    }

    public static void debug(String str) {
        if (!TextUtils.isEmpty(str)) {
            setDebug(true);
            setPriority(0);
            setTag(str);
        } else {
            setDebug(false);
            setPriority(10);
            setTag("");
        }
    }

    public static void v(String str) {
        if (enableLog(2)) {
            sILogger.log(2, sTag, str, null);
        }
    }

    public static void vTag(String str, String str2) {
        if (enableLog(2)) {
            sILogger.log(2, str, str2, null);
        }
    }

    public static void d(String str) {
        if (enableLog(3)) {
            sILogger.log(3, sTag, str, null);
        }
    }

    public static void dTag(String str, String str2) {
        if (enableLog(3)) {
            sILogger.log(3, str, str2, null);
        }
    }

    public static void i(String str) {
        if (enableLog(4)) {
            sILogger.log(4, sTag, str, null);
        }
    }

    public static void iTag(String str, String str2) {
        if (enableLog(4)) {
            sILogger.log(4, str, str2, null);
        }
    }

    public static void w(String str) {
        if (enableLog(5)) {
            sILogger.log(5, sTag, str, null);
        }
    }

    public static void wTag(String str, String str2) {
        if (enableLog(5)) {
            sILogger.log(5, str, str2, null);
        }
    }

    public static void e(String str) {
        if (enableLog(6)) {
            sILogger.log(6, sTag, str, null);
        }
    }

    public static void eTag(String str, String str2) {
        if (enableLog(6)) {
            sILogger.log(6, str, str2, null);
        }
    }

    public static void e(Throwable th) {
        if (enableLog(6)) {
            sILogger.log(6, sTag, null, th);
        }
    }

    public static void eTag(String str, Throwable th) {
        if (enableLog(6)) {
            sILogger.log(6, str, null, th);
        }
    }

    public static void e(String str, Throwable th) {
        if (enableLog(6)) {
            sILogger.log(6, sTag, str, th);
        }
    }

    public static void eTag(String str, String str2, Throwable th) {
        if (enableLog(6)) {
            sILogger.log(6, str, str2, th);
        }
    }

    public static void wtf(String str) {
        if (enableLog(7)) {
            sILogger.log(7, sTag, str, null);
        }
    }

    public static void wtfTag(String str, String str2) {
        if (enableLog(7)) {
            sILogger.log(7, str, str2, null);
        }
    }

    private static boolean enableLog(int i) {
        return sILogger != null && sIsDebug && i >= sLogPriority;
    }
}
