package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f797a = "";
    private static com.bytedance.sdk.component.z dl = null;
    private static int g = 4;
    private static boolean z;

    public static void z(com.bytedance.sdk.component.z zVar) {
        dl = zVar;
    }

    public static void z(int i) {
        g = i;
    }

    public static boolean z() {
        return g <= 3;
    }

    public static void g() {
        z = true;
        z(3);
    }

    public static boolean dl() {
        return z;
    }

    public static void z(String str) {
        if (z) {
            z("Logger", str);
        }
    }

    public static void z(String str, String str2) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.z(a(str), str2);
        }
        if (z && str2 != null && g <= 4) {
            Log.i(a(str), str2);
        }
    }

    public static void z(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.z(a(str), str2 + Log.getStackTraceString(th));
        }
        if (z) {
            if (!(str2 == null && th == null) && g <= 4) {
                Log.i(a(str), str2, th);
            }
        }
    }

    public static void z(String str, Object... objArr) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.z(a(str), z(objArr));
        }
        if (z && objArr != null && g <= 4) {
            Log.i(a(str), z(objArr));
        }
    }

    public static void g(String str) {
        if (z) {
            g("Logger", str);
        }
    }

    public static void g(String str, String str2) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.g(a(str), str2);
        }
        if (z && str2 != null && g <= 5) {
            Log.w(a(str), str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.z(a(str), str2, th);
        }
        if (z) {
            if (!(str2 == null && th == null) && g <= 5) {
                Log.w(a(str), str2, th);
            }
        }
    }

    public static void g(String str, Object... objArr) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.g(a(str), z(objArr));
        }
        if (z && objArr != null && g <= 5) {
            Log.w(a(str), z(objArr));
        }
    }

    public static void dl(String str, String str2) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.z(a(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(a(str), str2);
    }

    public static void dl(String str) {
        if (z) {
            a("Logger", str);
        }
    }

    public static void a(String str, String str2) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.dl(a(str), str2);
        }
        if (z && str2 != null && g <= 6) {
            Log.e(a(str), str2);
        }
    }

    public static void dl(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.g(a(str), str2, th);
        }
        if (z) {
            if (!(str2 == null && th == null) && g <= 6) {
                Log.e(a(str), str2, th);
            }
        }
    }

    public static void dl(String str, Object... objArr) {
        com.bytedance.sdk.component.z zVar = dl;
        if (zVar != null) {
            zVar.dl(a(str), z(objArr));
        }
        if (z && objArr != null && g <= 6) {
            Log.e(a(str), z(objArr));
        }
    }

    private static String z(Object... objArr) {
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

    public static String a(String str) {
        return TextUtils.isEmpty(f797a) ? str : z("[" + f797a + "]-[" + str + "]");
    }

    public static void z(Throwable th) {
        g(f797a, "", th);
    }

    public static void z(int i, String str, String str2) {
        z(str, str2);
    }
}
