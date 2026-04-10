package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements g, Function {
    g g;
    Function z;

    public dl(g gVar) {
        this.g = gVar;
    }

    public dl(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.g.getFileCacheSize());
            case 2:
                return Integer.valueOf(this.g.getMemoryCacheSize());
            case 3:
                return Boolean.valueOf(this.g.isMemoryCache());
            case 4:
                return Boolean.valueOf(this.g.isDiskCache());
            case 5:
                return this.g.getCacheDir();
            case 6:
                return Boolean.valueOf(this.g.isQueryAll());
            case 7:
                return Integer.valueOf(this.g.getRawMemoryCacheSize());
            case 8:
                return Boolean.valueOf(this.g.isRawMemoryCache());
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.m.g
    public File getCacheDir() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (File) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.g
    public long getFileCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.z.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.m.g
    public int getMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.m.g
    public int getRawMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isDiskCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isMemoryCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isQueryAll() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isRawMemoryCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }
}
