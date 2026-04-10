package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Loader {
    private final Function<SparseArray<Object>, Void> z;

    public g(Function<SparseArray<Object>, Void> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (this.z != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (valueSet != null) {
                sparseArray = valueSet.sparseArray();
            }
            sparseArray.put(-99999982, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            this.z.apply(sparseArray);
        }
    }
}
