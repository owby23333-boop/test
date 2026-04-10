package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJAdError;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends CSJAdError {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.g = com.bykv.z.z.z.z.dl.z;
        function = function == null ? com.bykv.z.z.z.z.dl.dl : function;
        this.z = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.g = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) objApply).g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.g.intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return this.g.stringValue(263002);
    }
}
