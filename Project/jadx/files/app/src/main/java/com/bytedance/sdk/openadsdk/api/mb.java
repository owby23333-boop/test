package com.bytedance.sdk.openadsdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class mb {
    private static boolean mb = false;
    private static int ox = 4;

    public static void b(String str, String str2) {
        if (mb && str2 != null) {
            int i2 = ox;
        }
    }

    public static void h(String str, String str2) {
        if (mb && str2 != null) {
            int i2 = ox;
        }
    }

    public static void hj(String str, String str2) {
        if (mb && str2 != null) {
            int i2 = ox;
        }
    }

    public static void mb(int i2) {
        ox = i2;
    }

    public static void ox(String str, String str2) {
        if (mb && str2 != null) {
            int i2 = ox;
        }
    }

    public static void mb() {
        mb = true;
        mb(3);
    }

    public static void ox(String str, String str2, Throwable th) {
        if (mb) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = ox;
        }
    }

    public static void mb(String str, String str2) {
        if (mb && str2 != null) {
            int i2 = ox;
        }
    }

    public static void mb(String str) {
        if (mb) {
            hj("TTLogger", str);
        }
    }

    public static void mb(String str, String str2, Throwable th) {
        if (mb) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = ox;
        }
    }

    public static void mb(String str, Object... objArr) {
        if (mb && objArr != null && ox <= 5) {
            mb(objArr);
        }
    }

    private static String mb(Object... objArr) {
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
