package com.bytedance.sdk.openadsdk.core.live.g;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Function<SparseArray<Object>, Object> {
    protected abstract void z(Object obj);

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || ((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        z(sparseArray.get(0, Object.class));
        return null;
    }
}
