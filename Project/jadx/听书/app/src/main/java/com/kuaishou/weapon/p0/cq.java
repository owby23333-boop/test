package com.kuaishou.weapon.p0;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static cq f1822a;
    static cq b;
    static cq c;
    private long d;
    private a e;

    static {
        c();
    }

    enum a {
        DWORD(4),
        QWORD(8);

        int c;

        a(int i) {
            this.c = i;
        }
    }

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public a b() {
        return this.e;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    private static void c() {
        f1822a = new cq();
        b = new cq();
        c = new cq();
        b.a(a.DWORD);
        int i = Build.VERSION.SDK_INT;
        if (cr.a()) {
            f1822a.a(a.QWORD);
            c.a(a.QWORD);
            switch (i) {
                case 26:
                case 27:
                    f1822a.a(40L);
                    c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    f1822a.a(32L);
                    c.a(24L);
                    b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            }
        }
        f1822a.a(a.DWORD);
        c.a(a.DWORD);
        switch (i) {
            case 26:
            case 27:
                f1822a.a(28L);
                c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                f1822a.a(24L);
                c.a(20L);
                b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
        }
    }
}
