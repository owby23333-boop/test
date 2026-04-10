package com.bytedance.sdk.openadsdk.core.q;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.component.a.gc, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return z();
        }
        if (iIntValue == 2) {
            return g();
        }
        if (iIntValue != 3) {
            return null;
        }
        return encrypt((byte[]) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
    }

    @Deprecated
    public String z() {
        return com.bytedance.sdk.openadsdk.core.un.uy.p();
    }

    @Deprecated
    public String g() {
        return com.bytedance.sdk.openadsdk.core.un.uy.dl(false);
    }

    @Override // com.bytedance.sdk.component.a.gc
    public byte[] encrypt(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.hh.g.z(bArr, i);
    }
}
