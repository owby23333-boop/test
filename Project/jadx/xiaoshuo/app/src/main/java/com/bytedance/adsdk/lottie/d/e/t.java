package com.bytedance.adsdk.lottie.d.e;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class t<V, O> implements bh<V, O> {
    final List<com.bytedance.adsdk.lottie.p.e<V>> e;

    public t(List<com.bytedance.adsdk.lottie.p.e<V>> list) {
        this.e = list;
    }

    @Override // com.bytedance.adsdk.lottie.d.e.bh
    public boolean bf() {
        if (this.e.isEmpty()) {
            return true;
        }
        return this.e.size() == 1 && this.e.get(0).ga();
    }

    @Override // com.bytedance.adsdk.lottie.d.e.bh
    public List<com.bytedance.adsdk.lottie.p.e<V>> d() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.e.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.e.toArray()));
        }
        return sb.toString();
    }
}
