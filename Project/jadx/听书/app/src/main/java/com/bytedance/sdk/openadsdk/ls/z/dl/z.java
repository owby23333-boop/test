package com.bytedance.sdk.openadsdk.ls.z.dl;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static SparseArray<Object> z(final AdConfig adConfig) {
        if (adConfig == null) {
            return new SparseArray<>();
        }
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        dlVarZ.z(261001, adConfig.getAppId());
        dlVarZ.z(261002, adConfig.getAppName());
        dlVarZ.z(261003, adConfig.isPaid());
        dlVarZ.z(261004, adConfig.getKeywords());
        dlVarZ.z(261005, adConfig.getData());
        dlVarZ.z(261006, adConfig.getTitleBarTheme());
        dlVarZ.z(261007, adConfig.isAllowShowNotify());
        dlVarZ.z(261008, adConfig.isDebug());
        dlVarZ.z(261009, adConfig.getDirectDownloadNetworkType());
        dlVarZ.z(261011, adConfig.isSupportMultiProcess());
        dlVarZ.z(261012, a.z(adConfig.getCustomController()));
        dlVarZ.z(261013, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.z.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        dlVarZ.z(261014, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.z.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        dlVarZ.z(261015, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.z.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        dlVarZ.z(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.z(adConfig.getMediationConfig()) : null);
        dlVarZ.z(261017, adConfig.isUseMediation());
        dlVarZ.z(261018, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.z.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return adConfig.getInitExtra();
            }
        });
        return dlVarZ.g().sparseArray();
    }
}
