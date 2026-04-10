package com.bytedance.adsdk.lottie.model.g;

import com.bytedance.adsdk.lottie.z.z.q;

/* JADX INFO: loaded from: classes2.dex */
public class js implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.g f173a;
    private final com.bytedance.adsdk.lottie.model.z.g dl;
    private final z g;
    private final com.bytedance.adsdk.lottie.model.z.g gc;
    private final boolean m;
    private final String z;

    public enum z {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static z z(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public js(String str, z zVar, com.bytedance.adsdk.lottie.model.z.g gVar, com.bytedance.adsdk.lottie.model.z.g gVar2, com.bytedance.adsdk.lottie.model.z.g gVar3, boolean z2) {
        this.z = str;
        this.g = zVar;
        this.dl = gVar;
        this.f173a = gVar2;
        this.gc = gVar3;
        this.m = z2;
    }

    public String z() {
        return this.z;
    }

    public z getType() {
        return this.g;
    }

    public com.bytedance.adsdk.lottie.model.z.g g() {
        return this.f173a;
    }

    public com.bytedance.adsdk.lottie.model.z.g dl() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.g a() {
        return this.gc;
    }

    public boolean gc() {
        return this.m;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new q(dlVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.dl + ", end: " + this.f173a + ", offset: " + this.gc + "}";
    }
}
