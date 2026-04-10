package com.bytedance.msdk.api;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdEcpmInfo {
    private int a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14109i;

    @Deprecated
    public int getAdNetworkPlatformId() {
        return this.a;
    }

    public String getAdNetworkPlatformName() {
        return this.b;
    }

    public String getAdNetworkRitId() {
        return this.f14104d;
    }

    public String getAdnName() {
        return TextUtils.isEmpty(this.f14103c) ? this.b : this.f14103c;
    }

    public String getCustomAdNetworkPlatformName() {
        return this.f14103c;
    }

    public String getErrorMsg() {
        return this.f14108h;
    }

    public String getLevelTag() {
        return this.f14105e;
    }

    public String getPreEcpm() {
        return this.f14106f;
    }

    public int getReqBiddingType() {
        return this.f14107g;
    }

    public String getRequestId() {
        return this.f14109i;
    }

    public void setAdNetworkPlatformId(int i2) {
        this.a = i2;
    }

    public void setAdNetworkPlatformName(String str) {
        this.b = str;
    }

    public void setAdNetworkRitId(String str) {
        this.f14104d = str;
    }

    public void setCustomAdNetworkPlatformName(String str) {
        this.f14103c = str;
    }

    public void setErrorMsg(String str) {
        this.f14108h = str;
    }

    public void setLevelTag(String str) {
        this.f14105e = str;
    }

    public void setPreEcpm(String str) {
        this.f14106f = str;
    }

    public void setReqBiddingType(int i2) {
        this.f14107g = i2;
    }

    public void setRequestId(String str) {
        this.f14109i = str;
    }

    public String toString() {
        return "{mSdkNum='" + this.a + "', mSlotId='" + this.f14104d + "', mLevelTag='" + this.f14105e + "', mEcpm=" + this.f14106f + ", mReqBiddingType=" + this.f14107g + "', mRequestId=" + this.f14109i + '}';
    }
}
