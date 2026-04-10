package com.bytedance.sdk.component.a;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m implements gc {
    Function z;

    public m(Function function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.component.a.gc
    public byte[] encrypt(byte[] bArr, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, bArr);
        sparseArray.put(2, Integer.valueOf(i));
        return (byte[]) this.z.apply(sparseArray);
    }

    public String getDid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.z.apply(sparseArray);
    }

    public String getOAID() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.z.apply(sparseArray);
    }
}
