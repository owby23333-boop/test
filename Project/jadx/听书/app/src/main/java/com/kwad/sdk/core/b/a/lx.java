package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lx implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((d.b) bVar, jSONObject);
    }

    private static void a(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.abB = jSONObject.optLong("start_play_duration_ms");
        bVar.abC = jSONObject.optLong("first_frame_duration_ms");
        bVar.abD = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.abg = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong("creative_id");
        bVar.XI = jSONObject.optLong("ad_info_uid");
        bVar.abz = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(bVar.abz)) {
            bVar.abz = "";
        }
        bVar.adStyle = jSONObject.optInt("ad_style");
        bVar.abA = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.abB != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "start_play_duration_ms", bVar.abB);
        }
        if (bVar.abC != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "first_frame_duration_ms", bVar.abC);
        }
        if (bVar.abD != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "block_total_duration_ms", bVar.abD);
        }
        if (bVar.videoDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", bVar.videoDuration);
        }
        if (bVar.abg != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "block_times", bVar.abg);
        }
        if (bVar.videoUrl != null && !bVar.videoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        if (bVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", bVar.llsid);
        }
        if (bVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", bVar.creativeId);
        }
        if (bVar.XI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_uid", bVar.XI);
        }
        if (bVar.abz != null && !bVar.abz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_user_name", bVar.abz);
        }
        if (bVar.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", bVar.adStyle);
        }
        if (bVar.abA != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_media_player_type", bVar.abA);
        }
        return jSONObject;
    }
}
