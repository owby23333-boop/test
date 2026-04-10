package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class uf implements io, Function {
    io g;
    Function z;

    public uf(io ioVar) {
        this.g = ioVar;
    }

    public uf(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object pVar = sparseArray.get(1);
            if (pVar != null) {
                pVar = new p((Function) pVar);
            }
            this.g.onSuccess((ls) pVar);
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        this.g.onFailed(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
        return null;
    }

    @Override // com.bytedance.sdk.component.m.io
    public void onFailed(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.io
    public void onSuccess(ls lsVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (lsVar != null) {
            lsVar = new p(lsVar);
        }
        sparseArray.put(1, lsVar);
        this.z.apply(sparseArray);
    }
}
