package com.bytedance.sdk.openadsdk.mediation.manager.z.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> z;

    public abstract String getAbTestId();

    public abstract String getChannel();

    public abstract Map<String, String> getCustomData();

    public abstract String getCustomSdkName();

    public abstract String getEcpm();

    public abstract String getErrorMsg();

    public abstract String getLevelTag();

    public abstract int getReqBiddingType();

    public abstract String getRequestId();

    public abstract String getRitType();

    public abstract String getScenarioId();

    public abstract String getSdkName();

    public abstract String getSegmentId();

    public abstract String getSlotId();

    public abstract String getSubChannel();

    public abstract String getSubRitType();

    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayZ = z();
        this.z = sparseArrayZ;
        return sparseArrayZ;
    }

    private SparseArray<Object> z() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(271006, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return z.this.getCustomData();
            }
        }));
        aVarZ.z(271007, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getSdkName();
            }
        }));
        aVarZ.z(271008, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getCustomSdkName();
            }
        }));
        aVarZ.z(271009, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getSlotId();
            }
        }));
        aVarZ.z(271010, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getLevelTag();
            }
        }));
        aVarZ.z(271011, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getEcpm();
            }
        }));
        aVarZ.z(271012, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(z.this.getReqBiddingType());
            }
        }));
        aVarZ.z(271013, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getErrorMsg();
            }
        }));
        aVarZ.z(271014, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getRequestId();
            }
        }));
        aVarZ.z(271015, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getRitType();
            }
        }));
        aVarZ.z(271016, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getSegmentId();
            }
        }));
        aVarZ.z(271017, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getChannel();
            }
        }));
        aVarZ.z(271018, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getSubChannel();
            }
        }));
        aVarZ.z(271019, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getAbTestId();
            }
        }));
        aVarZ.z(271020, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getScenarioId();
            }
        }));
        aVarZ.z(271051, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.getSubRitType();
            }
        }));
        return aVarZ.g();
    }

    @Override // java.util.function.Function
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
        return values();
    }
}
