package com.bytedance.msdk.api.nativeAd;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TTNativeAdAppInfo {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f14164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f14166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f14169h;

    public Map<String, Object> getAppInfoExtra() {
        return this.f14169h;
    }

    public String getAppName() {
        return this.a;
    }

    public String getAuthorName() {
        return this.b;
    }

    public long getPackageSizeBytes() {
        return this.f14164c;
    }

    public Map<String, String> getPermissionsMap() {
        return this.f14166e;
    }

    public String getPermissionsUrl() {
        return this.f14165d;
    }

    public String getPrivacyAgreement() {
        return this.f14167f;
    }

    public String getVersionName() {
        return this.f14168g;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f14169h = map;
    }

    public void setAppName(String str) {
        this.a = str;
    }

    public void setAuthorName(String str) {
        this.b = str;
    }

    public void setPackageSizeBytes(long j2) {
        this.f14164c = j2;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.f14166e = map;
    }

    public void setPermissionsUrl(String str) {
        this.f14165d = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f14167f = str;
    }

    public void setVersionName(String str) {
        this.f14168g = str;
    }
}
