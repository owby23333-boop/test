package com.kwad.sdk.core.b.a;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class km implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.SplashSlideInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.SplashSlideInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(splashSlideInfo.title)) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString(MediaFormat.KEY_SUBTITLE);
        if (JSONObject.NULL.toString().equals(splashSlideInfo.subtitle)) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt(TtmlNode.TAG_STYLE);
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        splashSlideInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    private static JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (splashSlideInfo.title != null && !splashSlideInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", splashSlideInfo.title);
        }
        if (splashSlideInfo.subtitle != null && !splashSlideInfo.subtitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_SUBTITLE, splashSlideInfo.subtitle);
        }
        if (splashSlideInfo.style != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TtmlNode.TAG_STYLE, splashSlideInfo.style);
        }
        if (splashSlideInfo.convertDistance != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertDistance", splashSlideInfo.convertDistance);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }
}
