package com.bytedance.sdk.openadsdk.ls;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final SparseArray<Object> z;

    private a() {
        this.z = new SparseArray<>();
    }

    public a(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z().g() < 6803 ? new g(sparseArray) : sparseArray;
    }

    public static a z() {
        return new a();
    }

    public static a z(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new a(sparseArray);
    }

    public a z(int i) {
        this.z.put(-99999987, Integer.valueOf(i));
        return this;
    }

    public a z(Class<?> cls) {
        this.z.put(-99999985, cls);
        return this;
    }

    public a z(int i, Object obj) {
        this.z.put(i, obj);
        return this;
    }

    public SparseArray<Object> g() {
        return this.z;
    }
}
