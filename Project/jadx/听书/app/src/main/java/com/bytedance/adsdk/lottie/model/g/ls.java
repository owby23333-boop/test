package com.bytedance.adsdk.lottie.model.g;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ls implements dl {
    private final boolean dl;
    private final List<dl> g;
    private final String z;

    public ls(String str, List<dl> list, boolean z) {
        this.z = str;
        this.g = list;
        this.dl = z;
    }

    public String z() {
        return this.z;
    }

    public List<dl> g() {
        return this.g;
    }

    public boolean dl() {
        return this.dl;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.a(gzVar, dlVar, this, mVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.z + "' Shapes: " + Arrays.toString(this.g.toArray()) + '}';
    }
}
