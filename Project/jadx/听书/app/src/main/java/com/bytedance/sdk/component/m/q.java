package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class q implements tb, Function {
    tb g;
    Function z;

    public q(tb tbVar) {
        this.g = tbVar;
    }

    public q(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        Object obj2 = sparseArray.get(1);
        this.g.onStep(((Integer) obj2).intValue(), sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.m.tb
    public void onStep(int i, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, obj);
        this.z.apply(sparseArray);
    }
}
