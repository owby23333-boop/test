package com.bytedance.sdk.openadsdk.ls.g.g;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Initializer {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        com.bytedance.sdk.openadsdk.ls.g.z zVar = new com.bytedance.sdk.openadsdk.ls.g.z(valueSet);
        zVar.put(-99999987, -999001);
        zVar.put(-99999985, Void.class);
        zVar.put(-998000, context);
        Function<SparseArray<Object>, Object> function = this.z;
        if (function != null) {
            function.apply(zVar);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        if (this.z != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -999002);
            sparseArray.put(-99999985, Boolean.TYPE);
            Object objApply = this.z.apply(sparseArray);
            if (objApply != null && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999000);
        sparseArray.put(-99999985, Function.class);
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof Function) {
            return new a((Function) objApply);
        }
        return null;
    }
}
