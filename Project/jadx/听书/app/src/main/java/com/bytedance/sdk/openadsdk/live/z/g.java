package com.bytedance.sdk.openadsdk.live.z;

import android.util.SparseArray;
import com.bykv.z.z.z.z.dl;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements ILiveHostActionParam {
    private Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.z != null) {
            this.z.apply(dl.z().z(0, z).z(1, str).z(2, str2).z(3, map).z(-99999987, 1).g().sparseArray());
        }
    }
}
