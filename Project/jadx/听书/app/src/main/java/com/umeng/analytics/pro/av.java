package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TApplicationException.java */
/* JADX INFO: loaded from: classes4.dex */
public class av extends bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2181a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final ca j = new ca("TApplicationException");
    private static final bq k = new bq("message", (byte) 11, 1);
    private static final bq l = new bq("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public av() {
        this.i = 0;
    }

    public av(int i) {
        this.i = i;
    }

    public av(int i, String str) {
        super(str);
        this.i = i;
    }

    public av(String str) {
        super(str);
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public static av a(bv bvVar) throws bc {
        bvVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            bq bqVarL = bvVar.l();
            if (bqVarL.b != 0) {
                short s = bqVarL.c;
                if (s != 1) {
                    if (s == 2) {
                        if (bqVarL.b == 8) {
                            iW = bvVar.w();
                        } else {
                            by.a(bvVar, bqVarL.b);
                        }
                    } else {
                        by.a(bvVar, bqVarL.b);
                    }
                } else if (bqVarL.b == 11) {
                    strZ = bvVar.z();
                } else {
                    by.a(bvVar, bqVarL.b);
                }
                bvVar.m();
            } else {
                bvVar.k();
                return new av(iW, strZ);
            }
        }
    }

    public void b(bv bvVar) throws bc {
        bvVar.a(j);
        if (getMessage() != null) {
            bvVar.a(k);
            bvVar.a(getMessage());
            bvVar.c();
        }
        bvVar.a(l);
        bvVar.a(this.i);
        bvVar.c();
        bvVar.d();
        bvVar.b();
    }
}
