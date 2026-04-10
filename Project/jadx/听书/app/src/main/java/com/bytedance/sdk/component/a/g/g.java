package com.bytedance.sdk.component.a.g;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z, Function {
    z g;
    Function z;

    public g(z zVar) {
        this.g = zVar;
    }

    public g(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return this.g.encrypt((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return this.g.decrypt((String) sparseArray.get(1));
        }
        if (iIntValue != 3) {
            return null;
        }
        return Integer.valueOf(this.g.type());
    }

    @Override // com.bytedance.sdk.component.a.g.z
    public String decrypt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.g.z
    public String encrypt(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.a.g.z
    public int type() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }
}
