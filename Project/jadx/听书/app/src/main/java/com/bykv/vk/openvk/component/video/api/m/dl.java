package com.bykv.vk.openvk.component.video.api.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static String dl = "";
    private static int g = 4;
    private static boolean z;

    public static void z(int i) {
        g = i;
    }

    public static void z() {
        z = true;
        z(3);
    }

    public static boolean g() {
        return z;
    }

    public static void z(String str) {
        if (z) {
            z("Logger", str);
        }
    }

    public static void z(String str, String str2) {
        if (z && str2 != null && g <= 4) {
            wp.z(dl(str), str2);
        }
    }

    public static void z(String str, String str2, Throwable th) {
        if (z) {
            if (!(str2 == null && th == null) && g <= 4) {
                wp.z(dl(str), str2, th);
            }
        }
    }

    public static void z(String str, Object... objArr) {
        if (z && objArr != null && g <= 4) {
            dl(str);
            z(objArr);
        }
    }

    public static void g(String str, String str2) {
        if (z && str2 != null && g <= 5) {
            wp.g(dl(str), str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        if (z) {
            if (!(str2 == null && th == null) && g <= 5) {
                wp.g(dl(str), str2, th);
            }
        }
    }

    public static void g(String str, Object... objArr) {
        if (z && objArr != null && g <= 5) {
            dl(str);
            z(objArr);
        }
    }

    public static void g(String str) {
        if (z) {
            dl("Logger", str);
        }
    }

    public static void dl(String str, String str2) {
        if (z && str2 != null && g <= 6) {
            wp.a(dl(str), str2);
        }
    }

    public static void dl(String str, String str2, Throwable th) {
        if (z) {
            if (!(str2 == null && th == null) && g <= 6) {
                wp.dl(dl(str), str2, th);
            }
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

    private static String dl(String str) {
        return TextUtils.isEmpty(dl) ? str : z("[" + dl + "]-[" + str + "]");
    }
}
