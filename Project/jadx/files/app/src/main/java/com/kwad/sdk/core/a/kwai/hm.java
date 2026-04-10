package com.kwad.sdk.core.a.kwai;

import com.anythink.core.api.ATAdConst;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hm implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    private static void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (splashMonitorInfo.preloadId == JSONObject.NULL) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.errorCode = jSONObject.optInt("error_code");
        splashMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (splashMonitorInfo.errorMsg == JSONObject.NULL) {
            splashMonitorInfo.errorMsg = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                splashMonitorInfo.ids.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
        splashMonitorInfo.failUrl = jSONObject.optString("fail_url");
        if (splashMonitorInfo.failUrl == JSONObject.NULL) {
            splashMonitorInfo.failUrl = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                splashMonitorInfo.creativeIds.add((String) jSONArrayOptJSONArray2.opt(i3));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                splashMonitorInfo.preloadIds.add((String) jSONArrayOptJSONArray3.opt(i4));
            }
        }
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
    }

    private static JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = splashMonitorInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        int i3 = splashMonitorInfo.type;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i3);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i4 = splashMonitorInfo.errorCode;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "error_code", i4);
        }
        String str2 = splashMonitorInfo.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "error_msg", splashMonitorInfo.errorMsg);
        }
        int i5 = splashMonitorInfo.checkStatus;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "check_status", i5);
        }
        long j2 = splashMonitorInfo.loadDataTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "load_data_duration_ms", j2);
        }
        long j3 = splashMonitorInfo.checkDataTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "check_data_duration_ms", j3);
        }
        long j4 = splashMonitorInfo.loadAndCheckDataTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "load_and_check_data_duration_ms", j4);
        }
        long j5 = splashMonitorInfo.costTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "duration_ms", j5);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i6 = splashMonitorInfo.count;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "count", i6);
        }
        long j6 = splashMonitorInfo.cacheValidTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "validity_period_ms", j6);
        }
        long j7 = splashMonitorInfo.size;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, j7);
        }
        String str3 = splashMonitorInfo.failUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "fail_url", splashMonitorInfo.failUrl);
        }
        long j8 = splashMonitorInfo.creativeId;
        if (j8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "creative_id", j8);
        }
        int i7 = splashMonitorInfo.materialType;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "material_type", i7);
        }
        int i8 = splashMonitorInfo.totalCount;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "total_count", i8);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.s.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        long j9 = splashMonitorInfo.posId;
        if (j9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pos_Id", j9);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashMonitorInfo) bVar, jSONObject);
    }
}
