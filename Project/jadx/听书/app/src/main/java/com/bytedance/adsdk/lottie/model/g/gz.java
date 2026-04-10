package com.bytedance.adsdk.lottie.model.g;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f171a;
    private final com.bytedance.adsdk.lottie.model.z.a dl;
    private final com.bytedance.adsdk.lottie.model.z.gz g;
    private final z z;

    public enum z {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public gz(z zVar, com.bytedance.adsdk.lottie.model.z.gz gzVar, com.bytedance.adsdk.lottie.model.z.a aVar, boolean z2) {
        this.z = zVar;
        this.g = gzVar;
        this.dl = aVar;
        this.f171a = z2;
    }

    public z z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.gz g() {
        return this.g;
    }

    public com.bytedance.adsdk.lottie.model.z.a dl() {
        return this.dl;
    }

    public boolean a() {
        return this.f171a;
    }
}
