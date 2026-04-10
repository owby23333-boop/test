package com.bytedance.msdk.api.v2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMNetworkRequestInfo {
    public int mAdNetworkFlatFromId;
    public String mAdNetworkSlotId;
    public String mAppId;
    public String mAppKey;

    public int getAdNetworkFlatFromId() {
        return this.mAdNetworkFlatFromId;
    }

    public String getAdNetworkSlotId() {
        return this.mAdNetworkSlotId;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppKey() {
        return this.mAppKey;
    }
}
