package com.bytedance.sdk.openadsdk.ls.z.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements LocationProvider {
    private ValueSet z;

    public static SparseArray<Object> z(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        dlVarZ.z(262001, locationProvider.getLatitude());
        dlVarZ.z(262002, locationProvider.getLongitude());
        return dlVarZ.g().sparseArray();
    }

    public dl(ValueSet valueSet) {
        this.z = valueSet == null ? com.bykv.z.z.z.z.dl.z : valueSet;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.z.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.z.doubleValue(262002);
    }
}
