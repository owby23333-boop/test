package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bg implements com.kwad.sdk.core.d<y.a> {
    private static void a(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.templateId = jSONObject.optString("template_id");
        if (aVar.templateId == JSONObject.NULL) {
            aVar.templateId = "";
        }
        aVar.ajC = jSONObject.optString("template_show_type");
        if (aVar.ajC == JSONObject.NULL) {
            aVar.ajC = "";
        }
        aVar.ajD = jSONObject.optInt("award_task_name");
        aVar.ajE = jSONObject.optInt("jumps_liveroom_type");
        aVar.ajF = jSONObject.optInt("universe_feature_freg");
    }

    private static JSONObject b(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "template_id", aVar.templateId);
        }
        String str2 = aVar.ajC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "template_show_type", aVar.ajC);
        }
        int i2 = aVar.ajD;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "award_task_name", i2);
        }
        int i3 = aVar.ajE;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "jumps_liveroom_type", i3);
        }
        int i4 = aVar.ajF;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "universe_feature_freg", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((y.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((y.a) bVar, jSONObject);
    }
}
