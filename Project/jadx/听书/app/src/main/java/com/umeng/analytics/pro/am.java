package com.umeng.analytics.pro;

import android.util.Log;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes4.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2173a = "OpenId";
    private static boolean b;

    public static void a(boolean z) {
        Log.d(f2173a, "setDebug:" + z);
        b = z;
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            Log.d(f2173a, e(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        if (b) {
            Log.i(f2173a, e(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (b) {
            Log.w(f2173a, e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (b) {
            Log.e(f2173a, e(str, objArr));
        }
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }
}
