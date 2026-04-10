package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationCustomServiceConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1466a;
    private int dl;
    private String g;
    private String gc;
    private Map<String, Object> m = new HashMap();
    private String z;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.z = str;
        this.g = str2;
        this.dl = i;
        this.f1466a = i2;
        this.gc = str3;
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.z = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.g = valueSet.stringValue(2);
            this.dl = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.f1466a = valueSet.intValue(8094);
            this.gc = valueSet.stringValue(8547);
            Map<? extends String, ? extends Object> map = (Map) valueSet.objectValue(8075, Map.class);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.m.putAll(map);
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
        return this.f1466a;
    }

    public String getCustomAdapterJson() {
        return this.gc;
    }

    public Map<String, Object> getExtraData() {
        return this.m;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.z + "', mADNNetworkSlotId='" + this.g + "', mAdStyleType=" + this.dl + ", mSubAdtype=" + this.f1466a + ", mCustomAdapterJson='" + this.gc + "'}";
    }
}
