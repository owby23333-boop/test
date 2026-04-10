package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.v;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static final gc z = new gc();
    private final v<String, com.bytedance.adsdk.lottie.m> g = new v<>(20);

    public static gc z() {
        return z;
    }

    gc() {
    }

    public com.bytedance.adsdk.lottie.m z(String str) {
        if (str == null) {
            return null;
        }
        return this.g.z(str);
    }

    public void z(String str, com.bytedance.adsdk.lottie.m mVar) {
        if (str == null) {
            return;
        }
        this.g.z(str, mVar);
    }
}
