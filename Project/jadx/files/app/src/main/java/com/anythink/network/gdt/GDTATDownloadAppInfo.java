package com.anythink.network.gdt;

import com.anythink.core.api.ATAdAppInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATDownloadAppInfo extends ATAdAppInfo {
    public String appDownloadCount;
    public String appName;
    public String appPrivacyLink;
    public long appSize;
    public String appVersion;
    public String apppermissionLink;
    public String publisher;

    public GDTATDownloadAppInfo(NativeUnifiedADAppMiitInfo nativeUnifiedADAppMiitInfo, String str) {
        this.publisher = nativeUnifiedADAppMiitInfo.getAuthorName();
        this.appVersion = nativeUnifiedADAppMiitInfo.getVersionName();
        this.appPrivacyLink = nativeUnifiedADAppMiitInfo.getPrivacyAgreement();
        this.apppermissionLink = nativeUnifiedADAppMiitInfo.getPermissionsUrl();
        this.appName = nativeUnifiedADAppMiitInfo.getAppName();
        this.appSize = nativeUnifiedADAppMiitInfo.getPackageSizeBytes();
        this.appDownloadCount = str;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public String getAppDownloadCount() {
        return this.appDownloadCount;
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
