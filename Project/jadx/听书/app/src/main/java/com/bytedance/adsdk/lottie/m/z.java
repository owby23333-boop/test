package com.bytedance.adsdk.lottie.m;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.m;

/* JADX INFO: loaded from: classes2.dex */
public class z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f160a;
    public final Interpolator dl;
    public Float e;
    public PointF fo;
    public T g;
    public final Interpolator gc;
    public PointF gz;
    private int i;
    private float kb;
    private float ls;
    public final float m;
    private float pf;
    private final m uy;
    private int v;
    private float wp;
    public final T z;

    public z(m mVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.kb = -3987645.8f;
        this.wp = -3987645.8f;
        this.i = 784923401;
        this.v = 784923401;
        this.pf = Float.MIN_VALUE;
        this.ls = Float.MIN_VALUE;
        this.gz = null;
        this.fo = null;
        this.uy = mVar;
        this.z = t;
        this.g = t2;
        this.dl = interpolator;
        this.f160a = null;
        this.gc = null;
        this.m = f;
        this.e = f2;
    }

    public z(m mVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.kb = -3987645.8f;
        this.wp = -3987645.8f;
        this.i = 784923401;
        this.v = 784923401;
        this.pf = Float.MIN_VALUE;
        this.ls = Float.MIN_VALUE;
        this.gz = null;
        this.fo = null;
        this.uy = mVar;
        this.z = t;
        this.g = t2;
        this.dl = null;
        this.f160a = interpolator;
        this.gc = interpolator2;
        this.m = f;
        this.e = f2;
    }

    protected z(m mVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.kb = -3987645.8f;
        this.wp = -3987645.8f;
        this.i = 784923401;
        this.v = 784923401;
        this.pf = Float.MIN_VALUE;
        this.ls = Float.MIN_VALUE;
        this.gz = null;
        this.fo = null;
        this.uy = mVar;
        this.z = t;
        this.g = t2;
        this.dl = interpolator;
        this.f160a = interpolator2;
        this.gc = interpolator3;
        this.m = f;
        this.e = f2;
    }

    public z(T t) {
        this.kb = -3987645.8f;
        this.wp = -3987645.8f;
        this.i = 784923401;
        this.v = 784923401;
        this.pf = Float.MIN_VALUE;
        this.ls = Float.MIN_VALUE;
        this.gz = null;
        this.fo = null;
        this.uy = null;
        this.z = t;
        this.g = t;
        this.dl = null;
        this.f160a = null;
        this.gc = null;
        this.m = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    private z(T t, T t2) {
        this.kb = -3987645.8f;
        this.wp = -3987645.8f;
        this.i = 784923401;
        this.v = 784923401;
        this.pf = Float.MIN_VALUE;
        this.ls = Float.MIN_VALUE;
        this.gz = null;
        this.fo = null;
        this.uy = null;
        this.z = t;
        this.g = t2;
        this.dl = null;
        this.f160a = null;
        this.gc = null;
        this.m = Float.MIN_VALUE;
        this.e = Float.valueOf(Float.MAX_VALUE);
    }

    public z<T> z(T t, T t2) {
        return new z<>(t, t2);
    }

    public float dl() {
        m mVar = this.uy;
        if (mVar == null) {
            return 0.0f;
        }
        if (this.pf == Float.MIN_VALUE) {
            this.pf = (this.m - mVar.m()) / this.uy.fv();
        }
        return this.pf;
    }

    public float a() {
        if (this.uy == null) {
            return 1.0f;
        }
        if (this.ls == Float.MIN_VALUE) {
            if (this.e == null) {
                this.ls = 1.0f;
            } else {
                this.ls = dl() + ((this.e.floatValue() - this.m) / this.uy.fv());
            }
        }
        return this.ls;
    }

    public boolean gc() {
        return this.dl == null && this.f160a == null && this.gc == null;
    }

    public boolean z(float f) {
        return f >= dl() && f < a();
    }

    public float m() {
        if (this.kb == -3987645.8f) {
            this.kb = ((Float) this.z).floatValue();
        }
        return this.kb;
    }

    public float e() {
        if (this.wp == -3987645.8f) {
            this.wp = ((Float) this.g).floatValue();
        }
        return this.wp;
    }

    public int gz() {
        if (this.i == 784923401) {
            this.i = ((Integer) this.z).intValue();
        }
        return this.i;
    }

    public int fo() {
        if (this.v == 784923401) {
            this.v = ((Integer) this.g).intValue();
        }
        return this.v;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.z + ", endValue=" + this.g + ", startFrame=" + this.m + ", endFrame=" + this.e + ", interpolator=" + this.dl + '}';
    }
}
