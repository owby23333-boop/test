package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> z;

    public abstract String a();

    public abstract String dl();

    public abstract String e();

    public abstract String fo();

    public abstract String g();

    public abstract Map<String, String> gc();

    public abstract String gz();

    public abstract String m();

    public abstract String z();

    public SparseArray<Object> uy() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayKb = kb();
        this.z = sparseArrayKb;
        return sparseArrayKb;
    }

    private SparseArray<Object> kb() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(250001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.z();
            }
        }));
        aVarZ.z(250002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.g();
            }
        }));
        aVarZ.z(250003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.dl();
            }
        }));
        aVarZ.z(250004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.a();
            }
        }));
        aVarZ.z(250006, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return dl.this.gc();
            }
        }));
        aVarZ.z(250005, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.m();
            }
        }));
        aVarZ.z(250007, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.e();
            }
        }));
        aVarZ.z(250008, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.fo();
            }
        }));
        aVarZ.z(250009, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.dl.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return dl.this.gz();
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
        return uy();
    }
}
