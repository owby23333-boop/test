package com.bytedance.adsdk.lottie.d.bf;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private final com.bytedance.adsdk.lottie.d.e.v bf;
    private final com.bytedance.adsdk.lottie.d.e.tg d;
    private final e e;
    private final boolean tg;

    public enum e {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public v(e eVar, com.bytedance.adsdk.lottie.d.e.v vVar, com.bytedance.adsdk.lottie.d.e.tg tgVar, boolean z) {
        this.e = eVar;
        this.bf = vVar;
        this.d = tgVar;
        this.tg = z;
    }

    public com.bytedance.adsdk.lottie.d.e.v bf() {
        return this.bf;
    }

    public com.bytedance.adsdk.lottie.d.e.tg d() {
        return this.d;
    }

    public e e() {
        return this.e;
    }

    public boolean tg() {
        return this.tg;
    }
}
