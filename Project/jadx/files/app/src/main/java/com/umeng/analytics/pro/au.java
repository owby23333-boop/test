package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: classes3.dex */
public class au extends bb {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f19522c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f19523d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f19524e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19525f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19526g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19527h = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final bz f19528j = new bz("TApplicationException");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final bp f19529k = new bp("message", (byte) 11, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final bp f19530l = new bp("type", (byte) 8, 2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f19531m = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f19532i;

    public au() {
        this.f19532i = 0;
    }

    public int a() {
        return this.f19532i;
    }

    public void b(bu buVar) throws bb {
        buVar.a(f19528j);
        if (getMessage() != null) {
            buVar.a(f19529k);
            buVar.a(getMessage());
            buVar.c();
        }
        buVar.a(f19530l);
        buVar.a(this.f19532i);
        buVar.c();
        buVar.d();
        buVar.b();
    }

    public static au a(bu buVar) throws bb {
        buVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bp bpVarL = buVar.l();
            byte b2 = bpVarL.b;
            if (b2 == 0) {
                buVar.k();
                return new au(iW, strZ);
            }
            short s2 = bpVarL.f19582c;
            if (s2 != 1) {
                if (s2 != 2) {
                    bx.a(buVar, b2);
                } else if (b2 == 8) {
                    iW = buVar.w();
                } else {
                    bx.a(buVar, b2);
                }
            } else if (b2 == 11) {
                strZ = buVar.z();
            } else {
                bx.a(buVar, b2);
            }
            buVar.m();
        }
    }

    public au(int i2) {
        this.f19532i = 0;
        this.f19532i = i2;
    }

    public au(int i2, String str) {
        super(str);
        this.f19532i = 0;
        this.f19532i = i2;
    }

    public au(String str) {
        super(str);
        this.f19532i = 0;
    }
}
