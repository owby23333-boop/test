package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationCustomServiceConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1461a;
    private int dl;
    private String g;
    private String gc;
    private String z;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.z = str;
        this.g = str2;
        this.dl = i;
        this.f1461a = i2;
        this.gc = str3;
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.z = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.g = valueSet.stringValue(2);
            this.dl = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.f1461a = valueSet.intValue(8094);
            this.gc = valueSet.stringValue(8547);
        }
    }

    public String getADNNetworkName() {
        return this.z;
    }

    public String getADNNetworkSlotId() {
        return this.g;
    }

    public int getAdStyleType() {
        return this.dl;
    }

    public int getSubAdtype() {
        return this.f1461a;
    }

    public String getCustomAdapterJson() {
        return this.gc;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.z + "', mADNNetworkSlotId='" + this.g + "', mAdStyleType=" + this.dl + ", mSubAdtype=" + this.f1461a + ", mCustomAdapterJson='" + this.gc + "'}";
    }
}
