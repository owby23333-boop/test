package com.bytedance.sdk.openadsdk.ls.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Loader {
    private Function<SparseArray<Object>, Object> z;

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null || this.z == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ls.g.z zVar = new com.bytedance.sdk.openadsdk.ls.g.z(valueSet);
        zVar.put(-99999987, Integer.valueOf(i));
        zVar.put(-99999982, Integer.valueOf(i));
        this.z.apply(zVar);
    }
}
