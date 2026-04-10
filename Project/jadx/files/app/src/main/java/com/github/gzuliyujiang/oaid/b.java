package com.github.gzuliyujiang.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: DeviceIdentifier.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static volatile boolean a;
    private static volatile String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f14888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f14889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f14890e;

    /* JADX INFO: compiled from: DeviceIdentifier.java */
    /* JADX INFO: loaded from: classes2.dex */
    static class a implements c {
        a() {
        }

        @Override // com.github.gzuliyujiang.oaid.c
        public void a(String str) {
            String unused = b.f14889d = str;
        }

        @Override // com.github.gzuliyujiang.oaid.c
        public void a(Exception exc) {
            String unused = b.f14889d = "";
        }
    }

    private b() {
    }

    public static String b(Context context) {
        if (f14888c == null) {
            synchronized (b.class) {
                if (f14888c == null) {
                    f14888c = com.github.gzuliyujiang.oaid.a.e(context);
                }
            }
        }
        if (f14888c == null) {
            f14888c = "";
        }
        return f14888c;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f14889d)) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(f14889d)) {
                    f14889d = com.github.gzuliyujiang.oaid.a.c();
                    if (f14889d == null || f14889d.length() == 0) {
                        com.github.gzuliyujiang.oaid.a.a(context, new a());
                    }
                }
            }
        }
        if (f14889d == null) {
            f14889d = "";
        }
        return f14889d;
    }

    public static void a(Application application) {
        if (a) {
            return;
        }
        synchronized (b.class) {
            if (!a) {
                com.github.gzuliyujiang.oaid.a.a(application);
                a = true;
            }
        }
    }

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(b)) {
                    b = com.github.gzuliyujiang.oaid.a.b();
                }
            }
        }
        if (b == null) {
            b = "";
        }
        return b;
    }

    public static String a(Context context) {
        if (f14890e == null) {
            synchronized (b.class) {
                if (f14890e == null) {
                    f14890e = com.github.gzuliyujiang.oaid.a.a(context);
                }
            }
        }
        if (f14890e == null) {
            f14890e = "";
        }
        return f14890e;
    }
}
