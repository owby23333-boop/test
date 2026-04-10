package com.bytedance.sdk.openadsdk;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface ComplianceInfo {
    String getAppName();

    String getAppVersion();

    String getDeveloperName();

    String getFunctionDescUrl();

    String getPermissionUrl();

    Map<String, String> getPermissionsMap();

    String getPrivacyUrl();
}
