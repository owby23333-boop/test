package com.bytedance.adsdk.lottie.z.g;

/* JADX INFO: loaded from: classes2.dex */
public class p<K, A> extends z<K, A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f199a;

    @Override // com.bytedance.adsdk.lottie.z.g.z
    float m() {
        return 1.0f;
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    public void z(float f) {
        this.g = f;
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    public void g() {
        if (this.dl != null) {
            super.g();
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    public A e() {
        com.bytedance.adsdk.lottie.m.dl<A> dlVar = this.dl;
        A a2 = this.f199a;
        return dlVar.z(0.0f, 0.0f, a2, a2, gz(), gz(), gz());
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    A z(com.bytedance.adsdk.lottie.m.z<K> zVar, float f) {
        return e();
    }
}
