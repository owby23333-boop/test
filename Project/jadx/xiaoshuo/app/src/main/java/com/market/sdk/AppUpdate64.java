package com.market.sdk;

/* JADX INFO: loaded from: classes7.dex */
public class AppUpdate64 {
    private String packageName;
    private String versionCode;
    private String versionName;

    public AppUpdate64(String str, String str2, String str3) {
        this.packageName = str;
        this.versionCode = str2;
        this.versionName = str3;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        return "AppUpdate64{packageName='" + this.packageName + "', versionCode='" + this.versionCode + "', versionName='" + this.versionName + "'}";
    }
}
