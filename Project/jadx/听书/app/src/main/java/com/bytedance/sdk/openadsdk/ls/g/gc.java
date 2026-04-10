package com.bytedance.sdk.openadsdk.ls.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements EventListener {
    private Function<SparseArray<Object>, Object> z;

    public gc(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (this.z == null) {
            return null;
        }
        Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(-99999979, result != null ? com.bytedance.sdk.openadsdk.ls.gc.z().z(result.code()).z(result.isSuccess()).z(result.message()).z(new z(result.values())).g() : null).z(SparseArray.class).g());
        if (objApply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.ls.g.dl.z.g((SparseArray<Object>) objApply);
        }
        return null;
    }
}
