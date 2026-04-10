package com.bytedance.sdk.openadsdk.core.sy;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    private SparseArray<Object> dl;
    private com.bytedance.sdk.openadsdk.ls.z g;
    private int z;

    public fo(SparseArray<Object> sparseArray, int i) {
        this.z = i;
        this.dl = sparseArray != null ? sparseArray : new SparseArray<>();
        this.g = new com.bytedance.sdk.openadsdk.ls.z(sparseArray);
    }

    public int getType() {
        return this.z;
    }

    public com.bytedance.sdk.openadsdk.ls.z dl() {
        return this.g;
    }

    public SparseArray<Object> a() {
        return this.dl;
    }

    public void setResult(SparseArray<Object> sparseArray) {
        this.g = new com.bytedance.sdk.openadsdk.ls.z(sparseArray);
    }
}
