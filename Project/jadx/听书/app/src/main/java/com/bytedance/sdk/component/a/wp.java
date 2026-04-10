package com.bytedance.sdk.component.a;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements kb {
    Function z;

    public wp(Function function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public String get(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.kb
    public boolean getBoolean(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.a.kb
    public int getInt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.a.kb
    public long getLong(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        return ((Long) this.z.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.a.kb
    public void set(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.z.apply(sparseArray);
    }
}
