package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
abstract class mc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f293a;
    private boolean dl;
    private int g = 0;
    final ti z;

    abstract String a();

    abstract boolean dl();

    abstract long[] g();

    abstract long z();

    mc(ti tiVar) {
        this.z = tiVar;
    }

    void gc() {
        this.dl = true;
    }

    boolean m() {
        return this.dl;
    }

    final long e() {
        boolean zDl;
        long jZ;
        long jZ2 = z();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f293a) {
            this.f293a = false;
            jZ2 = 0;
        }
        if (jZ2 > 1000 + jCurrentTimeMillis) {
            return jZ2 - jCurrentTimeMillis;
        }
        try {
            zDl = dl();
        } catch (Exception e) {
            cb.g(e);
            zDl = false;
        }
        if (zDl) {
            this.g = 0;
            jZ = z() - System.currentTimeMillis();
        } else {
            long[] jArrG = g();
            int i = this.g;
            this.g = i + 1;
            jZ = jArrG[i % jArrG.length];
        }
        cb.a(a() + " worked:" + zDl + " " + jZ, null);
        return jZ;
    }

    void gz() {
        cb.z("setImmediately, " + a());
        this.f293a = true;
    }
}
