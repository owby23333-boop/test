package com.bytedance.sdk.openadsdk.core.v;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1397a = 0;
    public static int dl = 3;
    public static int g = 2;
    public static int gc = 1;
    private static long ls = 0;
    public static int m = 2;
    private static int p = 0;
    private static long pf = 0;
    public static int z = 1;
    private long e;
    private long fo;
    private long gz;
    private int i;
    private long kb;
    private long uy;
    private long v;
    private long wp;

    public long z() {
        return this.kb;
    }

    public void z(long j) {
        this.kb = j;
    }

    public long g() {
        return this.wp;
    }

    public void g(long j) {
        this.wp = j;
    }

    public static long dl() {
        return pf + m();
    }

    public static long a() {
        return ls + e();
    }

    public static void z(int i) {
        g gVar = new g();
        long jFo = dl.gc().fo();
        List<z> listZ = gVar.z(jFo);
        Collections.sort(listZ);
        HashSet hashSet = new HashSet();
        if (listZ != null && !listZ.isEmpty()) {
            pf = 0L;
            ls = 0L;
            p = 0;
            for (z zVar : listZ) {
                if (zVar.i() == g) {
                    ls += z(zVar, jFo);
                } else if (zVar.i() == dl) {
                    pf += zVar.z();
                } else if (zVar.i() == z && zVar.e == jFo) {
                    hashSet.add(Long.valueOf(zVar.uy()));
                }
            }
        }
        p = hashSet.size();
        if (i == gc) {
            p = 1;
        }
        gVar.z();
    }

    private static long z(z zVar, long j) {
        long j2 = j - 518400000;
        long jGz = zVar.gz();
        if (jGz - zVar.g() >= j2) {
            return zVar.g();
        }
        long j3 = jGz - j2;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static int gc() {
        int i = p;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static void z(int i, long j, long j2) {
        z zVar = new z();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jDl = dl.gc().dl();
        zVar.a(dl.gc().fo());
        zVar.gc(jDl);
        zVar.g(i);
        zVar.dl(jCurrentTimeMillis);
        if (i == z) {
            zVar.z(0L);
            zVar.g(0L);
            zVar.e(0L);
            zVar.m(0L);
        } else if (i == g) {
            zVar.z(0L);
            zVar.g(j2);
            zVar.e(0L);
            zVar.m(jCurrentTimeMillis);
        } else if (i == dl) {
            zVar.z(j);
            zVar.g(0L);
            zVar.e(jCurrentTimeMillis);
            zVar.m(0L);
        }
        new g().insert(zVar);
    }

    public static long m() {
        long jUy = dl.gc().uy();
        long jCurrentTimeMillis = System.currentTimeMillis() - jUy;
        if (dl.gc().kb() > jUy) {
            return 0L;
        }
        return jUy == 0 ? System.currentTimeMillis() - dl.gc().dl() : jCurrentTimeMillis;
    }

    public static long e() {
        long jKb = dl.gc().kb();
        if (dl.gc().uy() > jKb) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jKb;
        if (jKb == 0) {
            return 0L;
        }
        return jCurrentTimeMillis;
    }

    public long gz() {
        return this.v;
    }

    public void dl(long j) {
        this.v = j;
    }

    public long fo() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public long uy() {
        return this.gz;
    }

    public void gc(long j) {
        this.gz = j;
    }

    public long kb() {
        return this.fo;
    }

    public void m(long j) {
        this.fo = j;
    }

    public long wp() {
        return this.uy;
    }

    public void e(long j) {
        this.uy = j;
    }

    public int i() {
        return this.i;
    }

    public void g(int i) {
        this.i = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        z zVar = (z) obj;
        return (this.e <= zVar.e && this.fo <= zVar.fo && this.uy <= zVar.uy) ? 0 : 1;
    }
}
