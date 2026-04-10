package com.bytedance.android.openliveplugin.material;

/* JADX INFO: loaded from: classes2.dex */
public class TTLogger {
    private static boolean DEBUG = false;
    private static final String TAG = "TTLiveLogger";
    private static int sLevel = 4;

    public static void d(String str) {
        if (DEBUG) {
            d(TAG, str);
        }
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    public static void e(String str) {
        if (DEBUG) {
            e(TAG, str);
        }
    }

    private static String formatMsgs(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int getLogLevel() {
        return sLevel;
    }

    private static String getSimpleClassName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? str : str.substring(iLastIndexOf + 1);
    }

    public static void i(String str) {
        if (DEBUG) {
            i(TAG, str);
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logDirect(String str, String str2) {
        if (str2 == null) {
        }
    }

    public static void openDebugMode() {
        DEBUG = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i2) {
        sLevel = i2;
    }

    public static void st(String str, int i2) {
        try {
            throw new Exception();
        } catch (Exception e2) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i3 = 1; i3 < Math.min(i2, stackTrace.length); i3++) {
                if (i3 > 1) {
                    sb.append("\n");
                }
                sb.append(getSimpleClassName(stackTrace[i3].getClassName()));
                sb.append(".");
                sb.append(stackTrace[i3].getMethodName());
            }
            v(str, sb.toString());
        }
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void w(String str) {
        if (DEBUG) {
            w(TAG, str);
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void d(String str, String str2) {
        if (DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void e(String str, String str2) {
        if (DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void i(String str, String str2) {
        if (DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG && str2 != null) {
            int i2 = sLevel;
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = sLevel;
        }
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 2) {
            formatMsgs(objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 3) {
            formatMsgs(objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 6) {
            formatMsgs(objArr);
        }
    }

    public static void i(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 4) {
            formatMsgs(objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 5) {
            formatMsgs(objArr);
        }
    }
}
