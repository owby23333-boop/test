package com.bytedance.sdk.openadsdk.dl;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.dl.z;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z.InterfaceC0217z {
    private Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.openadsdk.dl.z.InterfaceC0217z
    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.z;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.dl.z.InterfaceC0217z
    public void g() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.z;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
