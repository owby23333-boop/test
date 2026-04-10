package com.dangdang.zframework.log;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class LogM {
    private static String TAG_ORDER = "com.dangdang.reader";
    private static boolean isPrintLogD = true;
    private static boolean isPrintLogE = true;
    private static boolean isPrintLogI = true;
    private static boolean isPrintLogV = true;
    private static boolean isPrintLogW = true;
    private boolean order = false;
    private String tag;

    private LogM(Class<?> cls) {
        this.tag = cls.getSimpleName();
    }

    private static String buildMessage(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClass().equals(LogM.class)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + Consts.DOT + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static LogM getLog(Class<?> cls) {
        if (cls != null) {
            return new LogM(cls);
        }
        throw new NullPointerException("[clazz can't null]");
    }

    public static void initLogLevel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        isPrintLogV = z;
        isPrintLogD = z2;
        isPrintLogI = z3;
        isPrintLogW = z4;
        isPrintLogE = z5;
    }

    public static void l(String str) {
        if (isPrintLogD) {
            e("tagg", str);
        }
    }

    public void d(boolean z, String str) {
        if (isPrintLogD) {
            if (z) {
                Log.d(TAG_ORDER, "[" + this.tag + "] " + str);
                return;
            }
            Log.d(TAG_ORDER, "[" + this.tag + "] " + str);
        }
    }

    public void e(boolean z, String str) {
        if (isPrintLogE) {
            if (z) {
                Log.e(TAG_ORDER, "[" + this.tag + "] " + str);
                return;
            }
            Log.e(TAG_ORDER, "[" + this.tag + "] " + str);
        }
    }

    public void i(boolean z, String str) {
        if (isPrintLogI) {
            if (z) {
                Log.i(TAG_ORDER, "[" + this.tag + "] " + str);
                return;
            }
            Log.i(TAG_ORDER, "[" + this.tag + "] " + str);
        }
    }

    public boolean isOrder() {
        return this.order;
    }

    public void setOrderTag(String str) {
        TAG_ORDER = str;
    }

    public void v(boolean z, String str) {
        if (isPrintLogV) {
            if (z) {
                Log.v(TAG_ORDER, "[" + this.tag + "] " + str);
                return;
            }
            Log.v(TAG_ORDER, "[" + this.tag + "] " + str);
        }
    }

    public void w(boolean z, String str) {
        if (isPrintLogW) {
            if (z) {
                Log.w(TAG_ORDER, "[" + this.tag + "] " + str);
                return;
            }
            Log.w(TAG_ORDER, "[" + this.tag + "] " + str);
        }
    }

    public static void d(String str) {
        if (isPrintLogD) {
            d("LogM", str);
        }
    }

    public static void e(String str, String str2) {
        if (isPrintLogE) {
            Log.e(TAG_ORDER, "[" + str + "] " + str2);
        }
    }

    public static void i(String str, String str2) {
        if (isPrintLogI) {
            Log.i(TAG_ORDER, "[" + str + "] " + str2);
        }
    }

    public static void v(String str, Object... objArr) {
        if (isPrintLogV) {
            Log.v(TAG_ORDER, buildMessage(str, objArr));
        }
    }

    public static void w(String str, String str2) {
        if (isPrintLogW) {
            Log.w(TAG_ORDER, "[" + str + "] " + str2);
        }
    }

    public static void d(String str, String str2) {
        if (isPrintLogD) {
            Log.d(TAG_ORDER, "[" + str + "] " + str2);
        }
    }

    public static void e(String str) {
        if (isPrintLogE) {
            Log.e(TAG_ORDER, "[" + ((Object) null) + "] " + str);
        }
    }

    public static void v(String str, String str2) {
        if (isPrintLogV) {
            Log.v(TAG_ORDER, "[" + str + "] " + str2);
        }
    }
}
