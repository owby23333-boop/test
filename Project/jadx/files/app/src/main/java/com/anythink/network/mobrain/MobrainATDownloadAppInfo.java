package com.anythink.network.mobrain;

import com.anythink.core.api.ATAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATDownloadAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPackageName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String apppermissionLink;
    public String publisher;

    public MobrainATDownloadAppInfo(GMNativeAdAppInfo gMNativeAdAppInfo, String str) {
        this.publisher = gMNativeAdAppInfo.getAuthorName();
        this.appVersion = gMNativeAdAppInfo.getVersionName();
        this.appPrivacyLink = gMNativeAdAppInfo.getPrivacyAgreement();
        this.apppermissionLink = gMNativeAdAppInfo.getPermissionsUrl();
        this.appSize = gMNativeAdAppInfo.getPackageSizeBytes();
        this.appName = gMNativeAdAppInfo.getAppName();
        this.appPackageName = str;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppDownloadCount() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPackageName() {
        return this.appPackageName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        return this.apppermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return this.appSize;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getPublisher() {
        return this.publisher;
    }
}
