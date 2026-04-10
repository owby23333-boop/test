package com.bytedance.msdk.adapter.ks.base.proto;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class AdnAdapterBridgeWrapper extends AdnAdapterBaseFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bridge f343a;

    public AdnAdapterBridgeWrapper(Bridge bridge) {
        this.f343a = bridge == null ? AdnAdapterValueSetBuilder.EMPTY_BRIDGE : bridge;
    }

    public static Function<SparseArray<Object>, Object> covertToFunction(Object obj) {
        if (obj instanceof Bridge) {
            return new AdnAdapterBridgeWrapper((Bridge) obj);
        }
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        return (T) this.f343a.call(i, AdnAdapterValueSetBuilder.create(sparseArray).build(), cls);
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return AdnAdapterValueSetBuilder.converToSparseArray(this.f343a.values());
    }

    public Bridge getBridge() {
        return this.f343a;
    }
}
