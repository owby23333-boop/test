package com.xiaomi.ad.common.util;

import android.util.Log;
import android.util.Patterns;

/* JADX INFO: loaded from: classes5.dex */
public class MLog {
    public static final int DEBUG = 3;
    public static final int ERROR = 0;
    public static final int INFO = 2;
    public static final int MAX_CHAR_SIZE_PER_LOG = 3000;
    public static final String TAG_PREFIX = "Mediation-";
    public static final int VERBOSE = 4;
    public static final int WARN = 1;
    public static int sLogLevel = 1;

    public static String addAdPrefix(String str) {
        return TAG_PREFIX + str;
    }

    public static void d(String str, String str2) {
        if (sLogLevel >= 2) {
            log(addAdPrefix(str), str2, 2);
        }
    }

    public static void e(String str, String str2) {
        if (sLogLevel >= 0) {
            log(addAdPrefix(str), str2, 0);
        }
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static String getPatternedMsg(String str, Throwable th) {
        return str + SignatureUtils.DELIMITER + Patterns.IP_ADDRESS.matcher(Log.getStackTraceString(th)).replaceAll("*.*.*.*");
    }

    public static void i(String str, String str2) {
        if (sLogLevel >= 2) {
            log(addAdPrefix(str), str2, 2);
        }
    }

    public static void log(String str, String str2, int i) {
        int i2 = 0;
        while (i2 <= str2.length() / 3000) {
            int i3 = i2 * 3000;
            i2++;
            int iMin = Math.min(str2.length(), i2 * 3000);
            if (i3 < iMin) {
                String strSubstring = str2.substring(i3, iMin);
                if (i == 0) {
                    Log.e(str, strSubstring);
                } else if (i == 1) {
                    Log.w(str, strSubstring);
                } else if (i == 2) {
                    Log.i(str, strSubstring);
                } else if (i == 3) {
                    Log.d(str, strSubstring);
                } else if (i == 4) {
                    Log.v(str, strSubstring);
                }
            }
        }
    }

    public static void setDebugOff() {
        sLogLevel = 1;
    }

    public static void setDebugOn() {
        sLogLevel = 4;
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }

    public static void v(String str, String str2) {
        if (sLogLevel >= 4) {
            log(addAdPrefix(str), str2, 4);
        }
    }

    public static void w(String str, String str2) {
        if (sLogLevel >= 1) {
            log(addAdPrefix(str), str2, 1);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sLogLevel >= 3) {
            Log.d(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sLogLevel >= 0) {
            Log.e(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sLogLevel >= 2) {
            Log.i(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sLogLevel >= 4) {
            Log.v(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sLogLevel >= 1) {
            Log.w(addAdPrefix(str), getPatternedMsg(str2, th));
        }
    }
}
