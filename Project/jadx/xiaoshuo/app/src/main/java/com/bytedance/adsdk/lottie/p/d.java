package com.bytedance.adsdk.lottie.p;

import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class d<T> {
    private com.bytedance.adsdk.lottie.e.bf.e<?, ?> bf;
    private final bf<T> e;
    protected T ga;

    public d() {
        this.e = new bf<>();
        this.ga = null;
    }

    public T bf(bf<T> bfVar) {
        return this.ga;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T e(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return bf(this.e.e(f, f2, t, t2, f3, f4, f5));
    }

    public d(T t) {
        this.e = new bf<>();
        this.ga = t;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void e(com.bytedance.adsdk.lottie.e.bf.e<?, ?> eVar) {
        this.bf = eVar;
    }
}
