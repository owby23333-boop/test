package com.bytedance.msdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class AdLoadInfo {
    public static final String AD_LOADED = "广告加载成功";
    public static final String AD_LOADING = "广告请求中";
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14019f;

    public String getAdType() {
        return this.f14017d;
    }

    public String getAdnName() {
        return this.b;
    }

    public String getCustomAdnName() {
        return this.f14016c;
    }

    public int getErrCode() {
        return this.f14018e;
    }

    public String getErrMsg() {
        return this.f14019f;
    }

    public String getMediationRit() {
        return this.a;
    }

    public AdLoadInfo setAdType(String str) {
        this.f14017d = str;
        return this;
    }

    public AdLoadInfo setAdnName(String str) {
        this.b = str;
        return this;
    }

    public AdLoadInfo setCustomAdnName(String str) {
        this.f14016c = str;
        return this;
    }

    public AdLoadInfo setErrCode(int i2) {
        this.f14018e = i2;
        return this;
    }

    public AdLoadInfo setErrMsg(String str) {
        this.f14019f = str;
        return this;
    }

    public AdLoadInfo setMediationRit(String str) {
        this.a = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.a + "', adnName='" + this.b + "', customAdnName='" + this.f14016c + "', adType='" + this.f14017d + "', errCode=" + this.f14018e + ", errMsg=" + this.f14019f + '}';
    }
}
