package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.z.z;

/* JADX INFO: loaded from: classes2.dex */
public class MediationNativeAppInfoImpl extends z {
    private SparseArray<Object> g = new SparseArray<>();
    private MediationNativeAdAppInfo z;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.z = mediationNativeAdAppInfo;
    }

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.z;
        if (mediationNativeAdAppInfo != null) {
            this.g.put(8505, mediationNativeAdAppInfo.getAppName());
            this.g.put(8506, this.z.getAuthorName());
            this.g.put(8507, Long.valueOf(this.z.getPackageSizeBytes()));
            this.g.put(8508, this.z.getPermissionsUrl());
            this.g.put(8509, this.z.getPermissionsMap());
            this.g.put(8510, this.z.getPrivacyAgreement());
            this.g.put(8511, this.z.getVersionName());
            this.g.put(8512, this.z.getAppInfoExtra());
        }
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArrayValues = values();
        if (sparseArrayValues != null) {
            return sparseArrayValues;
        }
        return null;
    }
}
