package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static int g = 4;
    private static boolean z;

    public static void g(String str, String str2) {
    }

    public static void g(String str, String str2, Throwable th) {
    }

    public static void z(String str, String str2) {
    }

    public static void z(String str, String str2, Throwable th) {
    }

    public static void z(int i) {
        g = i;
    }

    public static void z() {
        z = true;
        z(3);
    }

    public static void z(String str, Object... objArr) {
        if (z && objArr != null && g <= 3) {
            z(objArr);
        }
    }

    public static void z(String str) {
        if (z) {
            dl("TTLogger", str);
        }
    }

    public static void dl(String str, String str2) {
        if (z && str2 != null && g <= 4) {
            wp.z(str, str2);
        }
    }

    public static void dl(String str, String str2, Throwable th) {
        if (z) {
            if (!(str2 == null && th == null) && g <= 4) {
                wp.z(str, str2, th);
            }
        }
    }

    public static void g(String str) {
        if (z) {
            a("TTLogger", str);
        }
    }

    public static void a(String str, String str2) {
        if (z && str2 != null && g <= 5) {
            wp.g(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (z) {
            if (!(str2 == null && th == null) && g <= 5) {
                wp.g(str, str2, th);
            }
        }
    }

    public static void g(String str, Object... objArr) {
        if (z && objArr != null && g <= 5) {
            z(objArr);
        }
    }

    public static void dl(String str) {
        if (z) {
            gc("TTLogger", str);
        }
    }

    public static void gc(String str, String str2) {
        if (z && str2 != null && g <= 6) {
            wp.a(str, str2);
        }
    }

    public static void gc(String str, String str2, Throwable th) {
        if (z) {
            if (!(str2 == null && th == null) && g <= 6) {
                wp.dl(str, str2, th);
            }
        }
    }

    public static void z(Throwable th) {
        a("TTLogger", "", th);
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
}
