package com.bytedance.adsdk.lottie.p;

import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class bf<T> {
    private float bf;
    private T d;
    private float e;
    private float ga;
    private float p;
    private T tg;
    private float vn;

    public float bf() {
        return this.bf;
    }

    public T d() {
        return this.d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public bf<T> e(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        this.e = f;
        this.bf = f2;
        this.d = t;
        this.tg = t2;
        this.ga = f3;
        this.vn = f4;
        this.p = f5;
        return this;
    }

    public float ga() {
        return this.ga;
    }

    public float p() {
        return this.p;
    }

    public T tg() {
        return this.tg;
    }

    public float vn() {
        return this.vn;
    }

    public float e() {
        return this.e;
    }
}
