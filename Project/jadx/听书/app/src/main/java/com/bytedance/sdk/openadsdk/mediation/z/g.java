package com.bytedance.sdk.openadsdk.mediation.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private final Bridge z;

    public g(Bridge bridge) {
        this.z = bridge == null ? dl.g : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        return (T) this.z.call(i, valueSet, cls);
    }

    public static Function<SparseArray<Object>, Object> z(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        if (obj instanceof Bridge) {
            return new g((Bridge) obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        if (this.z.values() == null) {
            return null;
        }
        SparseArray<Object> sparseArray = this.z.values().sparseArray();
        return sparseArray == null ? new SparseArray<>() : sparseArray;
    }
}
