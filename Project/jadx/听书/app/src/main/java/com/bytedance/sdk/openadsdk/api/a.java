package com.bytedance.sdk.openadsdk.api;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Initializer {
    Function<SparseArray<Object>, Object> z;

    public a(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        if (this.z == null || valueSet == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        sparseArray.put(-99999987, -999001);
        sparseArray.put(-998000, context);
        this.z.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -999002);
        Function<SparseArray<Object>, Object> function = this.z;
        if (function == null) {
            return false;
        }
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return ((Boolean) objApply).booleanValue();
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
        return new dl((Function) this.z.apply(sparseArray));
    }
}
