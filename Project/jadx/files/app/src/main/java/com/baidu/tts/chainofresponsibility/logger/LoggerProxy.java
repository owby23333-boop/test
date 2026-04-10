package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class LoggerProxy {
    private static boolean LOGSWITCH = false;
    private static final String LOGTAG = "TTSLOG";
    private static final String PREFIX = "bdtts-";
    private static final String TAG = "LoggerProxy";
    private static LoggerChain mLoggerChain;

    public static void d(String str, String str2) {
        if (LOGSWITCH || Log.isLoggable(LOGTAG, 3)) {
            String str3 = PREFIX + str;
        }
    }

    public static void e(String str, String str2) {
        if (LOGSWITCH || Log.isLoggable(LOGTAG, 6)) {
            String str3 = PREFIX + str;
        }
    }

    public static void i(String str, String str2) {
        if (LOGSWITCH || Log.isLoggable(LOGTAG, 4)) {
            String str3 = PREFIX + str;
        }
    }

    public static void printable(boolean z2) {
        LOGSWITCH = z2;
    }

    public static void v(String str, String str2) {
        if (LOGSWITCH || Log.isLoggable(LOGTAG, 2)) {
            String str3 = PREFIX + str;
        }
    }

    public static void w(String str, String str2) {
        if (LOGSWITCH || Log.isLoggable(LOGTAG, 5)) {
            String str3 = PREFIX + str;
        }
    }
}
