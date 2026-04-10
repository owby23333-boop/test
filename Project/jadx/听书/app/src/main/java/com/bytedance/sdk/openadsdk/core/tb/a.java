package com.bytedance.sdk.openadsdk.core.tb;

import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.v.z {
    @Override // com.bytedance.sdk.openadsdk.v.z
    public boolean g() {
        return uy.ls().gc();
    }

    @Override // com.bytedance.sdk.openadsdk.v.z
    public boolean dl() {
        return super.dl();
    }

    @Override // com.bytedance.sdk.openadsdk.v.z
    public com.bytedance.sdk.openadsdk.v.a a() {
        return gc();
    }

    private com.bytedance.sdk.openadsdk.v.a gc() {
        String strM = com.bytedance.sdk.openadsdk.core.gz.z.m();
        strM.hashCode();
        switch (strM) {
            case "2g":
                return com.bytedance.sdk.openadsdk.v.a.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.v.a.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.v.a.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.v.a.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.v.a.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.v.a.TYPE_UNKNOWN;
        }
    }
}
