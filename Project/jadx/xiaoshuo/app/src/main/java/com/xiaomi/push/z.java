package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1071a;

    static {
        String str = ac.f7783a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f1070a = str;
        f1071a = false;
        f8337a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            f8337a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            f8337a = 3;
        } else {
            f8337a = 1;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m820a() {
        return f8337a == 2;
    }

    public static boolean b() {
        return f8337a == 3;
    }

    public static int a() {
        return f8337a;
    }

    public static void a(int i) {
        f8337a = i;
    }
}
