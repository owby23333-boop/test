package com.bytedance.sdk.openadsdk.api;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Manager {
    private final Function<SparseArray<Object>, Object> z;

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        return null;
    }

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.dl.dl : function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, Function.class);
        return new g((Function) this.z.apply(sparseArray));
    }

    public Function<SparseArray<Object>, Object> z(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i == 1) {
            i = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i));
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof Function) {
            return (Function) objApply;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return com.bykv.z.z.z.z.dl.z((SparseArray<Object>) objApply).g();
        }
        return null;
    }
}
