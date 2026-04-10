package com.kuaishou.weapon.p0;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class cp {
    static cp a;
    static cp b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static cp f16663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f16665e;

    enum a {
        DWORD(4),
        QWORD(8);


        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16667c;

        a(int i2) {
            this.f16667c = i2;
        }
    }

    static {
        c();
    }

    private static void c() {
        a = new cp();
        b = new cp();
        f16663c = new cp();
        b.a(a.DWORD);
        int i2 = Build.VERSION.SDK_INT;
        if (cq.a()) {
            a.a(a.QWORD);
            f16663c.a(a.QWORD);
            switch (i2) {
                case 19:
                    a.a(32L);
                    b.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i2 + " is not supported now : (");
                case 21:
                    a.a(40L);
                    a.a(a.QWORD);
                    f16663c.a(32L);
                    f16663c.a(a.QWORD);
                    b.a(56L);
                    return;
                case 22:
                    a.a(52L);
                    f16663c.a(44L);
                    b.a(20L);
                    return;
                case 23:
                    a.a(48L);
                    f16663c.a(40L);
                    b.a(12L);
                    return;
                case 24:
                case 25:
                    a.a(48L);
                    f16663c.a(40L);
                    b.a(4L);
                    return;
                case 26:
                case 27:
                    a.a(40L);
                    f16663c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    a.a(32L);
                    f16663c.a(24L);
                    b.a(4L);
                    return;
            }
        }
        a.a(a.DWORD);
        f16663c.a(a.DWORD);
        switch (i2) {
            case 19:
                a.a(32L);
                b.a(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + i2 + " is not supported now : (");
            case 21:
                a.a(40L);
                a.a(a.QWORD);
                f16663c.a(32L);
                f16663c.a(a.QWORD);
                b.a(56L);
                return;
            case 22:
                a.a(44L);
                f16663c.a(40L);
                b.a(20L);
                return;
            case 23:
                a.a(36L);
                f16663c.a(32L);
                b.a(12L);
                return;
            case 24:
            case 25:
                a.a(32L);
                f16663c.a(28L);
                b.a(4L);
                return;
            case 26:
            case 27:
                a.a(28L);
                f16663c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                a.a(24L);
                f16663c.a(20L);
                b.a(4L);
                return;
        }
    }

    public long a() {
        return this.f16664d;
    }

    public void a(long j2) {
        this.f16664d = j2;
    }

    public void a(a aVar) {
        this.f16665e = aVar;
    }

    public a b() {
        return this.f16665e;
    }
}
