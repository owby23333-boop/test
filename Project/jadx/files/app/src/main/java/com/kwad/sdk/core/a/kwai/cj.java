package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.download.DownloadParams;
import com.tencent.smtt.sdk.TbsReaderView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cj implements com.kwad.sdk.core.d<DownloadParams> {
    private static void a(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        if (downloadParams.mDownloadid == JSONObject.NULL) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (downloadParams.mAppName == JSONObject.NULL) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (downloadParams.mPkgname == JSONObject.NULL) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (downloadParams.mVersion == JSONObject.NULL) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (downloadParams.mVersionCode == JSONObject.NULL) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (downloadParams.mFileMd5 == JSONObject.NULL) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (downloadParams.mFileUrl == JSONObject.NULL) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (downloadParams.mAppIcon == JSONObject.NULL) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (downloadParams.mShortDesc == JSONObject.NULL) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString(TbsReaderView.KEY_FILE_PATH);
        if (downloadParams.filePath == JSONObject.NULL) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    private static JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadParams.mDownloadid;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        String str2 = downloadParams.mAppName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        String str3 = downloadParams.mPkgname;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        String str4 = downloadParams.mVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        String str5 = downloadParams.mVersionCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        long j2 = downloadParams.mAppSize;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mAppSize", j2);
        }
        String str6 = downloadParams.mFileMd5;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        String str7 = downloadParams.mFileUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        String str8 = downloadParams.mAppIcon;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        String str9 = downloadParams.mShortDesc;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        int i2 = downloadParams.mTaskId;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mTaskId", i2);
        }
        String str10 = downloadParams.filePath;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, TbsReaderView.KEY_FILE_PATH, downloadParams.filePath);
        }
        boolean z2 = downloadParams.requestInstallPermission;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestInstallPermission", z2);
        }
        boolean z3 = downloadParams.downloadEnablePause;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadEnablePause", z3);
        }
        int i3 = downloadParams.downloadPlace;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadPlace", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((DownloadParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((DownloadParams) bVar, jSONObject);
    }
}
