package bykvm_19do.bykvm_19do.bykvm_19do;

/* JADX INFO: loaded from: classes.dex */
abstract class t1 {
    final v1 a;
    private int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f747c;

    t1(v1 v1Var) {
        this.a = v1Var;
    }

    abstract boolean a();

    abstract long b();

    abstract long[] c();

    abstract boolean d();

    abstract String e();

    void f() {
        this.f747c = true;
    }

    boolean g() {
        return this.f747c;
    }

    final long h() {
        boolean zD;
        long jB;
        if (!(!a() || h0.a(this.a.a()))) {
            return 60000L;
        }
        long jB2 = b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jB2 > 1000 + jCurrentTimeMillis) {
            return jB2 - jCurrentTimeMillis;
        }
        try {
            zD = d();
        } catch (Exception e2) {
            l0.a(e2);
            zD = false;
        }
        if (zD) {
            this.b = 0;
            jB = b() - System.currentTimeMillis();
        } else {
            long[] jArrC = c();
            int i2 = this.b;
            this.b = i2 + 1;
            jB = jArrC[i2 % jArrC.length];
        }
        l0.d(e() + " worked:" + zD + " " + jB, null);
        return jB;
    }
}
