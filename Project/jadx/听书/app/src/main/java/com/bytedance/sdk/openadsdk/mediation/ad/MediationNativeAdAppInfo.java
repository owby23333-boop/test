package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationNativeAdAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1457a;
    private long dl;
    private String e;
    private Map<String, Object> fo;
    private String g;
    private Map<String, String> gc;
    private String gz;
    private String m;
    private String uy;
    private String z;

    public String getAppName() {
        return this.z;
    }

    public void setAppName(String str) {
        this.z = str;
    }

    public String getAuthorName() {
        return this.g;
    }

    public void setAuthorName(String str) {
        this.g = str;
    }

    public long getPackageSizeBytes() {
        return this.dl;
    }

    public void setPackageSizeBytes(long j) {
        this.dl = j;
    }

    public String getPermissionsUrl() {
        return this.f1457a;
    }

    public void setPermissionsUrl(String str) {
        this.f1457a = str;
    }

    public Map<String, String> getPermissionsMap() {
        return this.gc;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.gc = map;
    }

    public String getPrivacyAgreement() {
        return this.m;
    }

    public void setPrivacyAgreement(String str) {
        this.m = str;
    }

    public String getVersionName() {
        return this.e;
    }

    public void setVersionName(String str) {
        this.e = str;
    }

    public String getFunctionDescUrl() {
        return this.gz;
    }

    public void setFunctionDescUrl(String str) {
        this.gz = str;
    }

    public Map<String, Object> getAppInfoExtra() {
        return this.fo;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.fo = map;
    }

    public String getRegUrl() {
        return this.uy;
    }

    public void setRegUrl(String str) {
        this.uy = str;
    }
}
