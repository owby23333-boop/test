package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.f.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gv implements com.kwad.sdk.core.d<b.C0454b> {
    private static void a(b.C0454b c0454b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0454b.atG = jSONObject.optInt("enable_monitor");
        c0454b.atH = jSONObject.optString("c_sc_name");
        if (c0454b.atH == JSONObject.NULL) {
            c0454b.atH = "";
        }
        c0454b.atI = jSONObject.optString("c_pcl_name");
        if (c0454b.atI == JSONObject.NULL) {
            c0454b.atI = "";
        }
        c0454b.atJ = jSONObject.optString("m_gam_name");
        if (c0454b.atJ == JSONObject.NULL) {
            c0454b.atJ = "";
        }
        c0454b.atK = jSONObject.optString("m_gsv_name");
        if (c0454b.atK == JSONObject.NULL) {
            c0454b.atK = "";
        }
        c0454b.atL = jSONObject.optString("m_gpv_name");
        if (c0454b.atL == JSONObject.NULL) {
            c0454b.atL = "";
        }
    }

    private static JSONObject b(b.C0454b c0454b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = c0454b.atG;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "enable_monitor", i2);
        }
        String str = c0454b.atH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "c_sc_name", c0454b.atH);
        }
        String str2 = c0454b.atI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "c_pcl_name", c0454b.atI);
        }
        String str3 = c0454b.atJ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "m_gam_name", c0454b.atJ);
        }
        String str4 = c0454b.atK;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "m_gsv_name", c0454b.atK);
        }
        String str5 = c0454b.atL;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "m_gpv_name", c0454b.atL);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.C0454b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.C0454b) bVar, jSONObject);
    }
}
