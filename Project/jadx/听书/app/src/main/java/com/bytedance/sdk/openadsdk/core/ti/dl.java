package com.bytedance.sdk.openadsdk.core.ti;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.gk;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private g g;
    private final Function<SparseArray<Object>, Object> z;

    public void z(g gVar) {
        this.g = gVar;
    }

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    public void z(int i, SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArrayG;
        g gVar;
        if (com.bykv.z.z.z.z.z.z(sparseArray).g().booleanValue(-999903) && i == 8001 && (gVar = this.g) != null) {
            gVar.z(true);
        } else if (this.z != null) {
            if (com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl)) {
                sparseArrayG = com.bytedance.sdk.openadsdk.ls.a.z(sparseArray).z(i).z(Void.class).g();
            } else {
                sparseArrayG = com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(Void.class).z(-99999979, sparseArray).g();
            }
            this.z.apply(sparseArrayG);
        }
    }
}
