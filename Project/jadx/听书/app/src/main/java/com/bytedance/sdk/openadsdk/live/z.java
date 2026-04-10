package com.bytedance.sdk.openadsdk.live;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Callback<Object> {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.z != null) {
            this.z.apply(com.bykv.z.z.z.z.dl.z().z(0, obj).z(-99999987, 1).g().sparseArray());
        }
    }
}
