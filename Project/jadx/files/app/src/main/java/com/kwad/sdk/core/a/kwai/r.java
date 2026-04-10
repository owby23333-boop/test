package com.kwad.sdk.core.a.kwai;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements com.kwad.sdk.core.d<AdInfo> {
    private static void a(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInfo.adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        adInfo.advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        adInfo.adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        adInfo.adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        adInfo.downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        adInfo.unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        if (adInfo.downloadFilePath == JSONObject.NULL) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (adInfo.downloadId == JSONObject.NULL) {
            adInfo.downloadId = "";
        }
        adInfo.adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        adInfo.adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        adInfo.adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        adInfo.adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        adInfo.adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        adInfo.adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        adInfo.adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        adInfo.fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        adInfo.adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        adInfo.adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        adInfo.adProductInfo = new AdProductInfo();
        adInfo.adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        adInfo.adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
        adInfo.trace = jSONObject.optString(AgooConstants.MESSAGE_TRACE);
        if (adInfo.trace == JSONObject.NULL) {
            adInfo.trace = "";
        }
    }

    private static JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.s.putValue(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.s.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        int i2 = adInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        int i3 = adInfo.progress;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i3);
        }
        long j2 = adInfo.soFarBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "soFarBytes", j2);
        }
        long j3 = adInfo.totalBytes;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j3);
        }
        String str = adInfo.downloadFilePath;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        }
        String str2 = adInfo.downloadId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadId", adInfo.downloadId);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        com.kwad.sdk.utils.s.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        com.kwad.sdk.utils.s.a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        int i4 = adInfo.ocpcActionType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ocpcActionType", i4);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        String str3 = adInfo.trace;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, AgooConstants.MESSAGE_TRACE, adInfo.trace);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo) bVar, jSONObject);
    }
}
