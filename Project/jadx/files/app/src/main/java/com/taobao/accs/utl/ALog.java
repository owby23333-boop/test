package com.taobao.accs.utl;

import com.taobao.tlog.adapter.AdapterForTLog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class ALog {
    private static final String REFLECT_TLOG = "com.taobao.tlog.adapter.AdapterForTLog";
    public static volatile boolean isPrintLog = false;
    public static volatile boolean isUseTlog = false;
    private static String preTag = "NAccs.";

    /* JADX INFO: compiled from: Taobao */
    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    static {
        try {
            Class.forName(REFLECT_TLOG);
            isUseTlog = true;
        } catch (ClassNotFoundException unused) {
            isUseTlog = false;
        }
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                sb.append(formatKv(objArr[i2], objArr[i3]));
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(" ");
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return preTag + str;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (isPrintLog(Level.D)) {
            if (isUseTlog) {
                AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (isPrintLog(Level.E)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(":");
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void i(String str, String str2, Object... objArr) {
        if (isPrintLog(Level.I)) {
            if (isUseTlog) {
                AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }

    @Deprecated
    public static void initALog(String str, int i2) {
        preTag = str;
    }

    @Deprecated
    public static boolean isPrintLog() {
        return isPrintLog;
    }

    @Deprecated
    public static void setEnableTLog(boolean z2) {
    }

    @Deprecated
    public static void setPrintLog(boolean z2) {
        isPrintLog = z2;
    }

    @Deprecated
    public static void setUseTlog(boolean z2) {
        isUseTlog = z2;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (isPrintLog(Level.V)) {
            if (isUseTlog) {
                AdapterForTLog.logv(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (isPrintLog(Level.W)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }

    public static boolean isPrintLog(Level level) {
        if (!isUseTlog) {
            return isPrintLog;
        }
        Level levelValueOf = Level.L;
        try {
            levelValueOf = Level.valueOf(AdapterForTLog.getLogLevel());
        } catch (Exception unused) {
        }
        return level.ordinal() >= levelValueOf.ordinal();
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog(Level.E)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, objArr), th);
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog(Level.W)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, objArr), th);
            } else {
                buildLogTag(str);
                buildLogMsg(str2, objArr);
            }
        }
    }
}
