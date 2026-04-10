package com.bytedance.sdk.openadsdk.ls.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Bridge {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Function<SparseArray<Object>, Object> function = this.z;
        if (function != null) {
            return com.bytedance.sdk.openadsdk.ls.g.dl.z.g(com.bytedance.sdk.openadsdk.ls.g.dl.z.z(function));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999977) {
            if (this.z instanceof dl) {
                T t = (T) this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(-99999977).z(Bridge.class).g());
                if (t instanceof Bridge) {
                    return t;
                }
            }
            return (T) this.z;
        }
        if (this.z == null) {
            return null;
        }
        z zVar = new z(valueSet);
        zVar.put(-99999987, Integer.valueOf(i));
        zVar.put(-99999985, cls);
        T t2 = (T) com.bytedance.sdk.openadsdk.ls.g.dl.z.g(this.z.apply(zVar));
        return t2 != null ? t2 : (T) com.bykv.z.z.z.z.dl.dl.apply(zVar);
    }
}
