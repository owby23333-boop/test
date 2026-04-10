package com.bytedance.adsdk.lottie.e.bf;

import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class l<K, A> extends e<K, A> {
    private final A tg;

    public l(com.bytedance.adsdk.lottie.p.d<A> dVar) {
        this(dVar, null);
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    public void bf() {
        if (this.d != null) {
            super.bf();
        }
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    public void e(float f) {
        this.bf = f;
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    public A p() {
        com.bytedance.adsdk.lottie.p.d<A> dVar = this.d;
        A a2 = this.tg;
        return dVar.e(0.0f, 0.0f, a2, a2, v(), v(), v());
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    public float vn() {
        return 1.0f;
    }

    public l(com.bytedance.adsdk.lottie.p.d<A> dVar, A a2) {
        super(Collections.emptyList());
        e(dVar);
        this.tg = a2;
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    public A e(com.bytedance.adsdk.lottie.p.e<K> eVar, float f) {
        return p();
    }
}
