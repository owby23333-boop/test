package com.yuewen;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes5.dex */
public class p91 extends j91 {
    public Interpolator k;
    public Interpolator l;
    public Interpolator m;
    public Interpolator n;
    public Interpolator o;

    public p91(o91 o91Var, long j) {
        this(null, o91Var, j, null);
    }

    @Override // com.yuewen.j91
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public o91 f() {
        float fJ = j();
        o91 o91Var = (o91) k();
        o91 o91Var2 = (o91) i();
        return new o91(new float[]{o91Var.d()[0] + ((o91Var2.d()[0] - o91Var.d()[0]) * b(fJ, z())), o91Var.d()[1] + ((o91Var2.d()[1] - o91Var.d()[1]) * b(fJ, z())), o91Var.d()[2]}, o91Var.e() + ((o91Var2.e() - o91Var.e()) * b(fJ, w())), o91Var.f() + ((o91Var2.f() - o91Var.f()) * b(fJ, x())), o91Var.g() + ((o91Var2.g() - o91Var.g()) * b(fJ, y())), Math.max(0.0f, Math.min(o91Var.b() + ((o91Var2.b() - o91Var.b()) * b(fJ, v())), 1.0f)));
    }

    public final Interpolator v() {
        Interpolator interpolator = this.o;
        return interpolator != null ? interpolator : g();
    }

    public final Interpolator w() {
        Interpolator interpolator = this.l;
        return interpolator != null ? interpolator : g();
    }

    public final Interpolator x() {
        Interpolator interpolator = this.m;
        return interpolator != null ? interpolator : g();
    }

    public final Interpolator y() {
        Interpolator interpolator = this.n;
        return interpolator != null ? interpolator : g();
    }

    public final Interpolator z() {
        Interpolator interpolator = this.k;
        return interpolator != null ? interpolator : g();
    }

    public p91(o91 o91Var, o91 o91Var2, long j) {
        this(o91Var, o91Var2, j, null);
    }

    public p91(o91 o91Var, long j, k91 k91Var) {
        this(null, o91Var, j, k91Var);
    }

    public p91(o91 o91Var, o91 o91Var2, long j, k91 k91Var) {
        super(o91Var, o91Var2, j, k91Var);
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }
}
