package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ew implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTag> {
    private static void a(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTag.styleId = jSONObject.optInt("styleId");
        matrixTag.type = jSONObject.optString("type");
        if (matrixTag.type == JSONObject.NULL) {
            matrixTag.type = "";
        }
        matrixTag.isHide = jSONObject.optBoolean("isHide");
    }

    private static JSONObject b(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = matrixTag.styleId;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "styleId", i2);
        }
        String str = matrixTag.type;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", matrixTag.type);
        }
        boolean z2 = matrixTag.isHide;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isHide", z2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MatrixTag) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MatrixTag) bVar, jSONObject);
    }
}
