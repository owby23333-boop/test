package com.bytedance.sdk.openadsdk.ls;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class g<E> extends SparseArray<E> {
    private final SparseArray<Object> z;

    public g(SparseArray<Object> sparseArray) {
        this.z = sparseArray;
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        Object obj;
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null && (obj = sparseArray.get(i, null)) != null) {
            e2 = (E) obj;
        }
        return e2 != null ? e2 : e;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        if (super.contains(i)) {
            return true;
        }
        SparseArray<Object> sparseArray = this.z;
        return sparseArray != null && sparseArray.indexOfKey(i) >= 0;
    }

    public SparseArray<Object> z() {
        return this.z;
    }
}
