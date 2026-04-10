package com.kwad.sdk.core.a.kwai;

import com.anythink.core.common.c.m;
import com.kwad.components.ad.interstitial.monitor.InterstitialMonitorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eg implements com.kwad.sdk.core.d<InterstitialMonitorInfo> {
    private static void a(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialMonitorInfo.status = jSONObject.optInt("status");
        interstitialMonitorInfo.type = jSONObject.optInt("type");
        interstitialMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialMonitorInfo.renderType = jSONObject.optInt("render_type");
        interstitialMonitorInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialMonitorInfo.materialType = jSONObject.optInt("material_type");
        interstitialMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialMonitorInfo.downloadType = jSONObject.optInt("download_type");
        interstitialMonitorInfo.downloadSize = jSONObject.optLong(m.a.f7066e);
        interstitialMonitorInfo.errorCode = jSONObject.optInt("error_code");
        interstitialMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (interstitialMonitorInfo.errorMsg == JSONObject.NULL) {
            interstitialMonitorInfo.errorMsg = "";
        }
        interstitialMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        interstitialMonitorInfo.videoUrl = jSONObject.optString("video_url");
        if (interstitialMonitorInfo.videoUrl == JSONObject.NULL) {
            interstitialMonitorInfo.videoUrl = "";
        }
        interstitialMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialMonitorInfo.posId = jSONObject.optLong("pos_Id");
    }

    private static JSONObject b(InterstitialMonitorInfo interstitialMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = interstitialMonitorInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", i2);
        }
        int i3 = interstitialMonitorInfo.type;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i3);
        }
        long j2 = interstitialMonitorInfo.loadDataTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "load_data_duration_ms", j2);
        }
        long j3 = interstitialMonitorInfo.renderDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "render_duration_ms", j3);
        }
        int i4 = interstitialMonitorInfo.renderType;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "render_type", i4);
        }
        int i5 = interstitialMonitorInfo.expectedRenderType;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "expected_render_type", i5);
        }
        int i6 = interstitialMonitorInfo.materialType;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "material_type", i6);
        }
        long j4 = interstitialMonitorInfo.downloadDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "download_duration_ms", j4);
        }
        int i7 = interstitialMonitorInfo.downloadType;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "download_type", i7);
        }
        long j5 = interstitialMonitorInfo.downloadSize;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, m.a.f7066e, j5);
        }
        int i8 = interstitialMonitorInfo.errorCode;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "error_code", i8);
        }
        String str = interstitialMonitorInfo.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "error_msg", interstitialMonitorInfo.errorMsg);
        }
        long j6 = interstitialMonitorInfo.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "creative_id", j6);
        }
        String str2 = interstitialMonitorInfo.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "video_url", interstitialMonitorInfo.videoUrl);
        }
        long j7 = interstitialMonitorInfo.videoDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "video_duration_ms", j7);
        }
        long j8 = interstitialMonitorInfo.posId;
        if (j8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pos_Id", j8);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InterstitialMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InterstitialMonitorInfo) bVar, jSONObject);
    }
}
