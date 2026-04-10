package com.kwad.sdk.core.a.kwai;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.core.response.model.AdInfo;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ck implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    private static void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        if (downloadSafeInfo.permissionInfo == JSONObject.NULL) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appName = jSONObject.optString(DispatchConstants.APP_NAME);
        if (downloadSafeInfo.appName == JSONObject.NULL) {
            downloadSafeInfo.appName = "";
        }
        downloadSafeInfo.corporationName = jSONObject.optString("corporationName");
        if (downloadSafeInfo.corporationName == JSONObject.NULL) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        downloadSafeInfo.appVersion = jSONObject.optString("appVersion");
        if (downloadSafeInfo.appVersion == JSONObject.NULL) {
            downloadSafeInfo.appVersion = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (downloadSafeInfo.appPrivacyUrl == JSONObject.NULL) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (downloadSafeInfo.appPermissionInfoUrl == JSONObject.NULL) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean(ITagManager.STATUS_FALSE).booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (downloadSafeInfo.windowPopUrl == JSONObject.NULL) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean(ITagManager.STATUS_FALSE).booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (downloadSafeInfo.webPageTipbarText == JSONObject.NULL) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (downloadSafeInfo.autoDownloadUrl == JSONObject.NULL) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        downloadSafeInfo.complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
    }

    private static JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadSafeInfo.permissionInfo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        String str2 = downloadSafeInfo.appName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DispatchConstants.APP_NAME, downloadSafeInfo.appName);
        }
        String str3 = downloadSafeInfo.corporationName;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "corporationName", downloadSafeInfo.corporationName);
        }
        long j2 = downloadSafeInfo.packageSize;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "packageSize", j2);
        }
        String str4 = downloadSafeInfo.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appVersion", downloadSafeInfo.appVersion);
        }
        String str5 = downloadSafeInfo.appPrivacyUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        String str6 = downloadSafeInfo.appPermissionInfoUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        boolean z2 = downloadSafeInfo.secWindowPopNoWifiSwitch;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "secWindowPopNoWifiSwitch", z2);
        }
        boolean z3 = downloadSafeInfo.secWindowPopSwitch;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "secWindowPopSwitch", z3);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        String str7 = downloadSafeInfo.windowPopUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        String str8 = downloadSafeInfo.webPageTipbarText;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        String str9 = downloadSafeInfo.autoDownloadUrl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.DownloadSafeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.DownloadSafeInfo) bVar, jSONObject);
    }
}
