package com.miui.zeus.landingpage.sdk;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7199a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f7200b = Looper.getMainLooper().getThread().getId();
    public static String c = "zeus-lp";

    public static String a(String str) {
        String strValueOf = f7200b == Thread.currentThread().getId() ? "Main" : TextUtils.isEmpty(Thread.currentThread().getName()) ? String.valueOf(Thread.currentThread().getId()) : Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(str);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (!TextUtils.isEmpty(null)) {
            sb.append((String) null);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        if (!TextUtils.isEmpty(null)) {
            sb.append("[");
            sb.append((String) null);
            sb.append("]");
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        sb.append("[");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    public static void b(String str, String str2) {
        if (f7199a >= 0) {
            a(a(str), str2, 0);
        }
    }

    public static void a(String str, String str2) {
        if (f7199a >= 3) {
            a(a(str), str2, 3);
        }
    }

    public static void a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int length = str2.length() / 3000;
        int i2 = 0;
        while (i2 <= length) {
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

    public static void a(String str, Object... objArr) {
        if (f7199a >= 3) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            a(str, sb.toString());
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f7199a >= 0) {
            Log.e(a(str), str2 + SignatureUtils.DELIMITER + Patterns.IP_ADDRESS.matcher(Log.getStackTraceString(th)).replaceAll("*.*.*.*"));
        }
    }
}
