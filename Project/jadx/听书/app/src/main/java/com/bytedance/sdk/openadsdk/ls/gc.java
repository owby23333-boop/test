package com.bytedance.sdk.openadsdk.ls;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private final SparseArray<Object> z = new SparseArray<>();

    private gc() {
    }

    public static gc z() {
        return new gc();
    }

    public gc z(int i) {
        this.z.put(-999900, Integer.valueOf(i));
        return this;
    }

    public gc z(String str) {
        this.z.put(-999901, str);
        return this;
    }

    public gc z(boolean z) {
        this.z.put(-999903, Boolean.valueOf(z));
        return this;
    }

    public gc z(SparseArray<Object> sparseArray) {
        this.z.put(-999902, sparseArray);
        return this;
    }

    public SparseArray<Object> g() {
        return this.z;
    }
}
