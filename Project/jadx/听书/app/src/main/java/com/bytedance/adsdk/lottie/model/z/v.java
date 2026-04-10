package com.bytedance.adsdk.lottie.model.z;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class v<V, O> implements i<V, O> {
    final List<com.bytedance.adsdk.lottie.m.z<V>> z;

    v(List<com.bytedance.adsdk.lottie.m.z<V>> list) {
        this.z = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public List<com.bytedance.adsdk.lottie.m.z<V>> dl() {
        return this.z;
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public boolean g() {
        return this.z.isEmpty() || (this.z.size() == 1 && this.z.get(0).gc());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.z.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.z.toArray()));
        }
        return sb.toString();
    }
}
