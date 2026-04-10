package com.bytedance.sdk.openadsdk.ls.z.dl;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final SparseArray<Object> z(final TTCustomController tTCustomController) {
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        dlVarZ.z(262101, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseLocation());
            }
        });
        dlVarZ.z(262102, new Supplier<SparseArray<Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return dl.z(tTCustomController2 == null ? null : tTCustomController2.getTTLocation());
            }
        });
        dlVarZ.z(262103, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.alist());
            }
        });
        dlVarZ.z(262104, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePhoneState());
            }
        });
        dlVarZ.z(262105, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevImei();
            }
        });
        dlVarZ.z(262106, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWifiState());
            }
        });
        dlVarZ.z(262107, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getMacAddress();
            }
        });
        dlVarZ.z(262108, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWriteExternal());
            }
        });
        dlVarZ.z(262109, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevOaid();
            }
        });
        dlVarZ.z(262110, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseAndroidId());
            }
        });
        dlVarZ.z(262113, (tTCustomController == null || tTCustomController.getMediationPrivacyConfig() == null) ? null : com.bytedance.sdk.openadsdk.mediation.init.z.z.z.g.z(tTCustomController.getMediationPrivacyConfig()));
        dlVarZ.z(262112, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getAndroidId();
            }
        });
        dlVarZ.z(262111, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePermissionRecordAudio());
            }
        });
        dlVarZ.z(262119, new Supplier<Map>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.userPrivacyConfig();
            }
        });
        dlVarZ.z(262120, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseMessage());
            }
        });
        dlVarZ.z(262121, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.a.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController == null);
            }
        });
        return dlVarZ.g().sparseArray();
    }
}
