package com.bytedance.sdk.openadsdk.ls.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Function<SparseArray<Object>, Object> {
    private EventListener z;

    public a(EventListener eventListener) {
        this.z = eventListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || this.z == null) {
            return null;
        }
        return this.z.onEvent(((Integer) sparseArray.get(-99999987)).intValue(), com.bytedance.sdk.openadsdk.ls.g.dl.z.z((SparseArray<Object>) sparseArray.get(-99999979)));
    }
}
