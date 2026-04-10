package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class zw implements iq {
    Function z;

    public zw(Function function) {
        this.z = function;
    }

    public void clearAllCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.z.apply(sparseArray);
    }

    public void clearCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Double.valueOf(d));
        this.z.apply(sparseArray);
    }

    public void clearDiskCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Double.valueOf(d));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.iq
    public void clearMemoryCache(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Double.valueOf(d));
        this.z.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // com.bytedance.sdk.component.m.iq
    public v from(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.z.apply(sparseArray);
        ?? pfVar = Apply;
        if (Apply != 0) {
            pfVar = new pf((Function) Apply);
        }
        return (v) pfVar;
    }

    @Override // com.bytedance.sdk.component.m.iq
    public InputStream getCacheStream(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (InputStream) this.z.apply(sparseArray);
    }

    public InputStream getDiskCacheStream(String str, String str2, String str3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return (InputStream) this.z.apply(sparseArray);
    }

    public boolean hasDiskCache(String str, String str2, String str3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }
}
