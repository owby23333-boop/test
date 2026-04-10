package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class wu {
    private static int bf = 4;
    private static com.bytedance.sdk.component.e d = null;
    private static boolean e = false;
    private static String tg = "";

    public static void bf() {
        e = true;
        e(3);
    }

    public static boolean d() {
        return e;
    }

    public static void e(com.bytedance.sdk.component.e eVar) {
        d = eVar;
    }

    public static void ga(String str, String str2) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.d(tg(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(tg(str), str2);
    }

    public static void tg(String str, String str2) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.tg(tg(str), str2);
        }
        if (e && str2 != null && bf <= 5) {
            Log.w(tg(str), str2);
        }
    }

    public static void vn(String str, String str2) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.ga(tg(str), str2);
        }
        if (e && str2 != null && bf <= 6) {
            Log.e(tg(str), str2);
        }
    }

    public static void d(String str, String str2) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.d(tg(str), str2);
        }
        if (e && str2 != null && bf <= 4) {
            Log.i(tg(str), str2);
        }
    }

    public static void e(int i) {
        bf = i;
    }

    public static void bf(String str, String str2) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.bf(tg(str), str2);
        }
        if (e && str2 != null && bf <= 3) {
            Log.d(tg(str), str2);
        }
    }

    public static boolean e() {
        return bf <= 3;
    }

    public static void e(String str, String str2) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.e(tg(str), str2);
        }
        if (e && str2 != null && bf <= 2) {
            Log.v(tg(str), str2);
        }
    }

    public static void tg(String str, Object... objArr) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.ga(tg(str), e(objArr));
        }
        if (e && objArr != null && bf <= 6) {
            Log.e(tg(str), e(objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.tg(tg(str), e(objArr));
        }
        if (e && objArr != null && bf <= 5) {
            Log.w(tg(str), e(objArr));
        }
    }

    public static void bf(String str, Object... objArr) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.d(tg(str), e(objArr));
        }
        if (e && objArr != null && bf <= 4) {
            Log.i(tg(str), e(objArr));
        }
    }

    public static void e(String str) {
        if (e) {
            bf("Logger", str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.bf(tg(str), str2 + Log.getStackTraceString(th));
        }
        if (e) {
            if (!(str2 == null && th == null) && bf <= 3) {
                Log.d(tg(str), str2, th);
            }
        }
    }

    public static String tg(String str) {
        if (TextUtils.isEmpty(tg)) {
            return str;
        }
        return e("[" + tg + "]-[" + str + "]");
    }

    public static void d(String str) {
        if (e) {
            vn("Logger", str);
        }
    }

    public static void bf(String str) {
        if (e) {
            tg("Logger", str);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.bf(tg(str), str2, th);
        }
        if (e) {
            if (!(str2 == null && th == null) && bf <= 6) {
                Log.e(tg(str), str2, th);
            }
        }
    }

    public static void bf(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.e(tg(str), str2, th);
        }
        if (e) {
            if (!(str2 == null && th == null) && bf <= 5) {
                Log.w(tg(str), str2, th);
            }
        }
    }

    public static void e(String str, Object... objArr) {
        com.bytedance.sdk.component.e eVar = d;
        if (eVar != null) {
            eVar.bf(tg(str), e(objArr));
        }
        if (e && objArr != null && bf <= 3) {
            Log.d(tg(str), e(objArr));
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
