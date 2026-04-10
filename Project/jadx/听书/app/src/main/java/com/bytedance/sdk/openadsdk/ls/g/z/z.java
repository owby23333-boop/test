package com.bytedance.sdk.openadsdk.ls.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements EventListener {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        if (result != null) {
            sparseArray.put(-999900, Integer.valueOf(result.code()));
            sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
            sparseArray.put(-999901, result.message());
            sparseArray.put(-999902, result.values() != null ? result.values().sparseArray() : new SparseArray<>());
        }
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return dl.z((SparseArray<Object>) objApply).g();
        }
        return null;
    }
}
