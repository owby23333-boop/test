package com.bytedance.sdk.openadsdk.ls.g.g;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Bridge, Manager {
    private final Function<SparseArray<Object>, Object> z;

    public a(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-99999985, Function.class);
        sparseArray.put(-998000, context);
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof Function) {
            return new dl((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, Function.class);
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof Function) {
            return new com.bytedance.sdk.openadsdk.ls.g.g((Function) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.ls.g.dl.z.g((SparseArray<Object>) objApply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.z == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.ls.g.z zVar = new com.bytedance.sdk.openadsdk.ls.g.z(valueSet);
        zVar.put(-99999987, Integer.valueOf(i));
        zVar.put(-99999985, cls);
        T t = (T) com.bytedance.sdk.openadsdk.ls.g.dl.z.g(this.z.apply(zVar));
        return t != null ? t : (T) com.bykv.z.z.z.z.dl.dl.apply(zVar);
    }
}
