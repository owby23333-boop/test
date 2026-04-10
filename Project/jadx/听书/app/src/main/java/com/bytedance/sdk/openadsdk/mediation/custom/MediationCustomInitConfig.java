package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class MediationCustomInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1465a;
    private String dl;
    private String e;
    private String fo;
    private String g;
    private String gc;
    private String gz;
    private String kb;
    private String m;
    private String uy;
    private String z;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.dl = str;
        this.z = str2;
        this.g = str3;
        this.f1465a = str4;
        this.gc = str5;
        this.m = str6;
        this.e = str7;
        this.gz = str8;
        this.fo = str9;
        this.uy = str10;
        this.kb = str11;
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.dl = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.z = valueSet.stringValue(8534);
            this.g = valueSet.stringValue(8535);
            this.f1465a = valueSet.stringValue(8536);
            this.gc = valueSet.stringValue(8537);
            this.m = valueSet.stringValue(8538);
            this.e = valueSet.stringValue(8539);
            this.gz = valueSet.stringValue(8540);
            this.fo = valueSet.stringValue(8541);
            this.uy = valueSet.stringValue(8542);
            this.kb = valueSet.stringValue(8543);
        }
    }

    public String getAppId() {
        return this.z;
    }

    public String getAppKey() {
        return this.g;
    }

    public String getADNName() {
        return this.dl;
    }

    public String getAdnInitClassName() {
        return this.f1465a;
    }

    public String getBannerClassName() {
        return this.gc;
    }

    public String getInterstitialClassName() {
        return this.m;
    }

    public String getRewardClassName() {
        return this.e;
    }

    public String getFullVideoClassName() {
        return this.gz;
    }

    public String getSplashClassName() {
        return this.fo;
    }

    public String getFeedClassName() {
        return this.uy;
    }

    public String getDrawClassName() {
        return this.kb;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.z + "', mAppKey='" + this.g + "', mADNName='" + this.dl + "', mAdnInitClassName='" + this.f1465a + "', mBannerClassName='" + this.gc + "', mInterstitialClassName='" + this.m + "', mRewardClassName='" + this.e + "', mFullVideoClassName='" + this.gz + "', mSplashClassName='" + this.fo + "', mFeedClassName='" + this.uy + "', mDrawClassName='" + this.kb + "'}";
    }
}
