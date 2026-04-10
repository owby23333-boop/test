package com.bytedance.sdk.openadsdk.ls.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final Bridge z;

    public dl(Bridge bridge) {
        this.z = bridge;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object objCall;
        if (sparseArray == null || this.z == null) {
            return com.bykv.z.z.z.z.dl.dl.apply(sparseArray);
        }
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        Class cls = (Class) sparseArray.get(-99999985);
        if (iIntValue == -99999977) {
            Bridge bridge = this.z;
            return (!(bridge instanceof g) || (objCall = bridge.call(-99999977, com.bykv.z.z.z.z.dl.z, Object.class)) == null) ? this.z : objCall;
        }
        if (iIntValue == -99999986) {
            ValueSet valueSetValues = this.z.values();
            if (valueSetValues == null) {
                return null;
            }
            return new z(valueSetValues);
        }
        return com.bytedance.sdk.openadsdk.ls.g.dl.z.z(this.z.call(iIntValue, com.bytedance.sdk.openadsdk.ls.g.dl.z.g(sparseArray), cls));
    }
}
