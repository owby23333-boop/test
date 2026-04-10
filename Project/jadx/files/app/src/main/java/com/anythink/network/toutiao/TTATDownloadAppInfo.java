package com.anythink.network.toutiao;

import com.anythink.core.api.ATAdAppInfo;
import com.bytedance.sdk.openadsdk.ComplianceInfo;

/* JADX INFO: loaded from: classes2.dex */
public class TTATDownloadAppInfo extends ATAdAppInfo {
    public String appName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String publisher;

    public TTATDownloadAppInfo(ComplianceInfo complianceInfo, long j2) {
        this.appPrivacyLink = complianceInfo.getPrivacyUrl();
        this.appName = complianceInfo.getAppName();
        this.publisher = complianceInfo.getDeveloperName();
        this.appVersion = complianceInfo.getAppVersion();
        this.appSize = j2;
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
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppPermissonUrl() {
        return "";
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
