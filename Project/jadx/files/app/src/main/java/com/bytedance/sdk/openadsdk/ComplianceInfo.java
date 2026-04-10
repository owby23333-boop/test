package com.bytedance.sdk.openadsdk;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ComplianceInfo {
    String getAppName();

    String getAppVersion();

    String getDeveloperName();

    String getPermissionUrl();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();
}
