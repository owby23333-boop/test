package com.bytedance.adsdk.lottie.p;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.vn;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.yuewen.w51;

/* JADX INFO: loaded from: classes.dex */
public class e<T> {
    public T bf;
    private int bh;
    public final Interpolator d;
    public final T e;
    public final Interpolator ga;
    private final vn m;
    public Float p;
    private float s;
    private int t;
    public final Interpolator tg;
    public PointF v;
    public final float vn;
    private float w;
    private float wu;
    private float xu;
    public PointF zk;

    public e(vn vnVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.wu = -3987645.8f;
        this.xu = -3987645.8f;
        this.bh = 784923401;
        this.t = 784923401;
        this.s = Float.MIN_VALUE;
        this.w = Float.MIN_VALUE;
        this.v = null;
        this.zk = null;
        this.m = vnVar;
        this.e = t;
        this.bf = t2;
        this.d = interpolator;
        this.tg = null;
        this.ga = null;
        this.vn = f;
        this.p = f2;
    }

    public float d() {
        vn vnVar = this.m;
        if (vnVar == null) {
            return 0.0f;
        }
        if (this.s == Float.MIN_VALUE) {
            this.s = (this.vn - vnVar.vn()) / this.m.bh();
        }
        return this.s;
    }

    public e<T> e(T t, T t2) {
        return new e<>(t, t2);
    }

    public boolean ga() {
        return this.d == null && this.tg == null && this.ga == null;
    }

    public float p() {
        if (this.xu == -3987645.8f) {
            this.xu = ((Float) this.bf).floatValue();
        }
        return this.xu;
    }

    public float tg() {
        if (this.m == null) {
            return 1.0f;
        }
        if (this.w == Float.MIN_VALUE) {
            if (this.p == null) {
                this.w = 1.0f;
            } else {
                this.w = d() + ((this.p.floatValue() - this.vn) / this.m.bh());
            }
        }
        return this.w;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.e + ", endValue=" + this.bf + ", startFrame=" + this.vn + ", endFrame=" + this.p + ", interpolator=" + this.d + '}';
    }

    public int v() {
        if (this.bh == 784923401) {
            this.bh = ((Integer) this.e).intValue();
        }
        return this.bh;
    }

    public float vn() {
        if (this.wu == -3987645.8f) {
            this.wu = ((Float) this.e).floatValue();
        }
        return this.wu;
    }

    public int zk() {
        if (this.t == 784923401) {
            this.t = ((Integer) this.bf).intValue();
        }
        return this.t;
    }

    public boolean e(@FloatRange(from = w51.l, to = 1.0d) float f) {
        return f >= d() && f < tg();
    }

    public e(vn vnVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.wu = -3987645.8f;
        this.xu = -3987645.8f;
        this.bh = 784923401;
        this.t = 784923401;
        this.s = Float.MIN_VALUE;
        this.w = Float.MIN_VALUE;
        this.v = null;
        this.zk = null;
        this.m = vnVar;
        this.e = t;
        this.bf = t2;
        this.d = null;
        this.tg = interpolator;
        this.ga = interpolator2;
        this.vn = f;
        this.p = f2;
    }

    public e(vn vnVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.wu = -3987645.8f;
        this.xu = -3987645.8f;
        this.bh = 784923401;
        this.t = 784923401;
        this.s = Float.MIN_VALUE;
        this.w = Float.MIN_VALUE;
        this.v = null;
        this.zk = null;
        this.m = vnVar;
        this.e = t;
        this.bf = t2;
        this.d = interpolator;
        this.tg = interpolator2;
        this.ga = interpolator3;
        this.vn = f;
        this.p = f2;
    }

    public e(T t) {
        this.wu = -3987645.8f;
        this.xu = -3987645.8f;
        this.bh = 784923401;
        this.t = 784923401;
        this.s = Float.MIN_VALUE;
        this.w = Float.MIN_VALUE;
        this.v = null;
        this.zk = null;
        this.m = null;
        this.e = t;
        this.bf = t;
        this.d = null;
        this.tg = null;
        this.ga = null;
        this.vn = Float.MIN_VALUE;
        this.p = Float.valueOf(Float.MAX_VALUE);
    }

    private e(T t, T t2) {
        this.wu = -3987645.8f;
        this.xu = -3987645.8f;
        this.bh = 784923401;
        this.t = 784923401;
        this.s = Float.MIN_VALUE;
        this.w = Float.MIN_VALUE;
        this.v = null;
        this.zk = null;
        this.m = null;
        this.e = t;
        this.bf = t2;
        this.d = null;
        this.tg = null;
        this.ga = null;
        this.vn = Float.MIN_VALUE;
        this.p = Float.valueOf(Float.MAX_VALUE);
    }
}
