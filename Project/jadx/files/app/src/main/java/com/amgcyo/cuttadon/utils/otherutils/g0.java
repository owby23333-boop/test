package com.amgcyo.cuttadon.utils.otherutils;

/* JADX INFO: compiled from: OldSpUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g0 {
    private static g0 a;

    private g0() {
    }

    public static g0 a() {
        if (a == null) {
            synchronized (g0.class) {
                if (a == null) {
                    a = new g0();
                }
            }
        }
        return a;
    }

    public int b(String str) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, 0).intValue();
    }

    public long c(String str) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, 0L).longValue();
    }

    public String d(String str) {
        return com.amgcyo.cuttadon.utils.comic.d.c(str);
    }

    public void b(String str, int i2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, Integer.valueOf(i2));
    }

    public void b(String str, boolean z2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, Boolean.valueOf(z2));
    }

    public void b(String str, String str2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, (Object) str2);
    }

    public void b(String str, long j2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, Long.valueOf(j2));
    }

    public void b(String str, float f2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, Float.valueOf(f2));
    }

    public boolean a(String str, boolean z2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, z2).booleanValue();
    }

    public boolean a(String str) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, false).booleanValue();
    }

    public String a(String str, String str2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, str2);
    }

    public int a(String str, int i2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, i2).intValue();
    }

    public float a(String str, float f2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, f2).floatValue();
    }

    public long a(String str, long j2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, j2).longValue();
    }
}
