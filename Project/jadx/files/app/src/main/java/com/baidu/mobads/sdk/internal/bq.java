package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public class bq {
    public static final String a = "logger";
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12945c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12946d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12947e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12948f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12949g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12950h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile bq f12951i;

    private bq() {
    }

    public static bq a() {
        if (f12951i == null) {
            synchronized (bq.class) {
                if (f12951i == null) {
                    f12951i = new bq();
                }
            }
        }
        return f12951i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public boolean a(String str, int i2) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                av.c().e(str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(String str) {
        b(a, str);
    }

    public void d(Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }

    public void b(Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(String str) {
        if (a(6)) {
            try {
                av.c().f(str);
            } catch (Exception unused) {
            }
        }
    }

    public void d(String str, Throwable th) {
        if (a(4)) {
            try {
                av.c().c(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, Throwable th) {
        if (a(5)) {
            try {
                av.c().d(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(String str, Throwable th) {
        if (a(6)) {
            try {
                av.c().e(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(int i2) {
        return a(a, i2);
    }

    public void b(Throwable th) {
        b("", th);
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                av.c().c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        a(a, str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                av.h(str).c(str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(String str, Throwable th) {
        if (a(3)) {
            try {
                av.h(a).b(th, str);
            } catch (Exception unused) {
            }
        }
    }
}
