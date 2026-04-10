package com.bytedance.sdk.openadsdk.mediation.init.z.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static final SparseArray<Object> z(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        dlVarZ.z(262114, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.g.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        dlVarZ.z(262115, new Supplier<List<String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.g.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public List<String> get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        dlVarZ.z(262116, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.g.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        dlVarZ.z(262117, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.g.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        dlVarZ.z(262118, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.g.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return dlVarZ.g().sparseArray();
    }
}
