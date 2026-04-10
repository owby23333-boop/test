package com.bytedance.sdk.openadsdk.mediation.ad;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1458a;
    private String dl;
    private String g;
    private String z;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.z = str;
        this.g = str2;
        this.dl = str3;
        this.f1458a = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnName() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnSlotId() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppId() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppkey() {
        return this.f1458a;
    }
}
