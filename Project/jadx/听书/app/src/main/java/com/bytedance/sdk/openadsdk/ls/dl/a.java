package com.bytedance.sdk.openadsdk.ls.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean g(int i) {
        return i >= 7000;
    }

    public static boolean z(int i) {
        return i >= 6803 && i < 7000;
    }

    public static <T> Object z(final Supplier<T> supplier) {
        return z(com.bykv.z.z().g()) ? new ValueSet.ValueGetter<Object>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.a.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            public T get() {
                return supplier.get();
            }
        } : supplier;
    }

    public static Object z(SparseArray<Object> sparseArray) {
        return z(com.bykv.z.z().g()) ? com.bykv.z.z.z.z.dl.z(sparseArray).g() : sparseArray;
    }

    public static PluginValueSet z(int i, PluginValueSet pluginValueSet) {
        if (z(com.bykv.z.z().g())) {
            return com.bykv.z.z.z.z.z.z(((ValueSet) pluginValueSet.objectValue(i, ValueSet.class)).sparseArray()).g();
        }
        return com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(i, SparseArray.class)).g();
    }

    public static Object z(Object obj) {
        return (com.bykv.z.z().g() < 6803 || com.bykv.z.z().g() >= 6900 || !(obj instanceof Function)) ? obj : new com.bytedance.sdk.openadsdk.ls.g.z.z((Function) obj);
    }
}
