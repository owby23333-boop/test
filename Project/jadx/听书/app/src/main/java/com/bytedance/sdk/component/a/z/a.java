package com.bytedance.sdk.component.a.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements dl, Function {
    dl g;
    Function z;

    public a(dl dlVar) {
        this.g = dlVar;
    }

    public a(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        int iIntValue = ((Integer) ((SparseArray) obj).get(0)).intValue();
        if (iIntValue == 1) {
            return Float.valueOf(this.g.getLatitude());
        }
        if (iIntValue == 2) {
            return Float.valueOf(this.g.getLongitude());
        }
        if (iIntValue != 3) {
            return null;
        }
        return Long.valueOf(this.g.getLastTime());
    }

    @Override // com.bytedance.sdk.component.a.z.dl
    public long getLastTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.z.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.component.a.z.dl
    public float getLatitude() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Float) this.z.apply(sparseArray)).floatValue();
    }

    @Override // com.bytedance.sdk.component.a.z.dl
    public float getLongitude() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Float) this.z.apply(sparseArray)).floatValue();
    }
}
