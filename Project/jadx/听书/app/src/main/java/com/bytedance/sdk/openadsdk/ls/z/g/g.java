package com.bytedance.sdk.openadsdk.ls.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTAdInteractionListener z;

    public g(TTAdInteractionListener tTAdInteractionListener) {
        this.z = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        if (valueSetG.intValue(-99999987) == 100101) {
            this.z.onAdEvent(valueSetG.intValue(0), (Map) valueSetG.objectValue(1, Map.class));
        }
        return null;
    }
}
