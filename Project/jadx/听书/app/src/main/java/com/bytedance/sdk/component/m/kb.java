package com.bytedance.sdk.component.m;

import android.graphics.Bitmap;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements uy, Function {
    uy g;
    Function z;

    public kb(uy uyVar) {
        this.g = uyVar;
    }

    public kb(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return this.g.coverterTo((Bitmap) sparseArray.get(1));
    }

    @Override // com.bytedance.sdk.component.m.uy
    public Bitmap coverterTo(Bitmap bitmap) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bitmap);
        return (Bitmap) this.z.apply(sparseArray);
    }
}
