package com.bytedance.sdk.openadsdk.ls;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static boolean z(int i) {
        return i >= 6803 && i < 7000;
    }

    public static SparseArray<Object> z(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        Object objApply = function.apply(a.z().z(-99999986).z(SparseArray.class).g());
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static PluginValueSet g(Function<SparseArray<Object>, Object> function) {
        Object objApply;
        if (function == null) {
            return com.bykv.z.z.z.z.z.z().g();
        }
        if ((function instanceof Supplier) && z(com.bykv.z.z().g())) {
            objApply = ((Supplier) function).get();
        } else {
            objApply = function.apply(a.z().z(-99999986).z(SparseArray.class).g());
        }
        if (objApply instanceof SparseArray) {
            return com.bykv.z.z.z.z.z.z((SparseArray<Object>) objApply).g();
        }
        return com.bykv.z.z.z.z.z.z().g();
    }
}
