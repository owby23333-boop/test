package com.bykv.vk.openvk.component.video.api.vn;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static int bf = 4;
    private static String d = "";
    private static boolean e = false;

    public static boolean bf() {
        return e;
    }

    public static void d(String str, String str2) {
        if (e && str2 != null && bf <= 5) {
            Log.w(tg(str), str2);
        }
    }

    public static void e(int i) {
        bf = i;
    }

    public static void tg(String str, String str2) {
        if (e && str2 != null && bf <= 6) {
            Log.e(tg(str), str2);
        }
    }

    public static void bf(String str) {
        if (e) {
            bf("Logger", str);
        }
    }

    public static void e() {
        e = true;
        e(3);
    }

    public static void bf(String str, String str2) {
        if (e && str2 != null && bf <= 4) {
            Log.i(tg(str), str2);
        }
    }

    public static void d(String str) {
        if (e) {
            tg("Logger", str);
        }
    }

    public static void e(String str) {
        if (e) {
            e("Logger", str);
        }
    }

    private static String tg(String str) {
        if (TextUtils.isEmpty(d)) {
            return str;
        }
        return e("[" + d + "]-[" + str + "]");
    }

    public static void d(String str, String str2, Throwable th) {
        if (e) {
            if (!(str2 == null && th == null) && bf <= 6) {
                Log.e(tg(str), str2, th);
            }
        }
    }

    public static void e(String str, String str2) {
        if (e && str2 != null && bf <= 3) {
            Log.d(tg(str), str2);
        }
    }

    public static void bf(String str, String str2, Throwable th) {
        if (e) {
            if (!(str2 == null && th == null) && bf <= 4) {
                Log.i(tg(str), str2, th);
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (e) {
            if (!(str2 == null && th == null) && bf <= 3) {
                Log.d(tg(str), str2, th);
            }
        }
    }

    public static void bf(String str, Object... objArr) {
        if (e && objArr != null && bf <= 4) {
            Log.v(tg(str), e(objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (e && objArr != null && bf <= 3) {
            Log.v(tg(str), e(objArr));
        }
    }

    private static String e(Object... objArr) {
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
}
