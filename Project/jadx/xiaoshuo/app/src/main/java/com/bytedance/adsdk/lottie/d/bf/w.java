package com.bytedance.adsdk.lottie.d.bf;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w implements d {
    private final List<d> bf;
    private final boolean d;
    private final String e;

    public w(String str, List<d> list, boolean z) {
        this.e = str;
        this.bf = list;
        this.d = z;
    }

    public List<d> bf() {
        return this.bf;
    }

    public boolean d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.e + "' Shapes: " + Arrays.toString(this.bf.toArray()) + '}';
    }

    @Override // com.bytedance.adsdk.lottie.d.bf.d
    public com.bytedance.adsdk.lottie.e.e.d e(com.bytedance.adsdk.lottie.v vVar, com.bytedance.adsdk.lottie.vn vnVar, com.bytedance.adsdk.lottie.d.d.e eVar) {
        return new com.bytedance.adsdk.lottie.e.e.tg(vVar, eVar, this, vnVar);
    }
}
