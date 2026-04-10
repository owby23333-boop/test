package com.bytedance.sdk.openadsdk.mediation.manager.z.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> z;

    public abstract int a();

    public abstract String dl();

    public abstract String g();

    public abstract String gc();

    public abstract String z();

    public SparseArray<Object> m() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayE = e();
        this.z = sparseArrayE;
        return sparseArrayE;
    }

    private SparseArray<Object> e() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(271001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.z();
            }
        }));
        aVarZ.z(271002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.g();
            }
        }));
        aVarZ.z(271003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.dl();
            }
        }));
        aVarZ.z(271004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.a());
            }
        }));
        aVarZ.z(271005, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return g.this.gc();
            }
        }));
        return aVarZ.g();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return m();
    }
}
