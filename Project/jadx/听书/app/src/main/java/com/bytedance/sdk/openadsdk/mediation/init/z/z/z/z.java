package com.bytedance.sdk.openadsdk.mediation.init.z.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static final SparseArray<Object> z(final IMediationConfig iMediationConfig) {
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        if (iMediationConfig == null) {
            return null;
        }
        dlVarZ.z(264101, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getPublisherDid();
            }
        });
        dlVarZ.z(264102, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isOpenAdnTest());
            }
        });
        dlVarZ.z(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? dl.z(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        dlVarZ.z(264104, new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return iMediationConfig.getLocalExtra();
            }
        });
        dlVarZ.z(264105, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.getHttps());
            }
        });
        dlVarZ.z(264106, new Supplier<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return iMediationConfig.getCustomLocalConfig();
            }
        });
        dlVarZ.z(264107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getOpensdkVer();
            }
        });
        dlVarZ.z(264108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isWxInstalled());
            }
        });
        dlVarZ.z(264109, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportH265());
            }
        });
        dlVarZ.z(264110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportSplashZoomout());
            }
        });
        dlVarZ.z(264111, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.z.z.z.z.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.wxAppId();
            }
        });
        return dlVarZ.g().sparseArray();
    }
}
