package com.taobao.aranger.logs;

import com.taobao.tlog.adapter.AdapterForTLog;

/* JADX INFO: loaded from: classes3.dex */
public final class IPCLog {
    private static final String PRE_TAG = "ARanger.";
    private static final String TLOG_CLASS = "com.taobao.tlog.adapter.AdapterForTLog";
    private static boolean isTlogValid = false;
    private static volatile boolean isUseTlog = true;

    static {
        try {
            Class.forName(TLOG_CLASS);
            isTlogValid = true;
        } catch (Exception unused) {
            isTlogValid = false;
        }
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        if (str != null) {
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
                sb.append(objArr[i2] != null ? objArr[i2] : "");
                sb.append(":");
                sb.append(objArr[i3] != null ? objArr[i3] : "");
                i2 += 2;
            }
            if (i2 < objArr.length) {
                sb.append(" ");
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return PRE_TAG + str;
    }

    public static void d(String str, String str2, String str3, Object... objArr) {
        if (isTlogValid && isUseTlog) {
            AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, objArr));
        } else {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (isTlogValid && isUseTlog) {
            AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, objArr));
        } else {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (isTlogValid && isUseTlog) {
            AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, objArr));
        } else {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    public static void setUseTlog(boolean z2) {
        isUseTlog = z2;
    }

    public static void w(String str, String str2, Object... objArr) {
        if (isTlogValid && isUseTlog) {
            AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, objArr));
        } else {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        if (isTlogValid && isUseTlog) {
            AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, objArr), th);
        } else {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    static void w(String str, String str2, Throwable th, Object... objArr) {
        if (isTlogValid && isUseTlog) {
            AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, objArr), th);
        } else {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }
}
