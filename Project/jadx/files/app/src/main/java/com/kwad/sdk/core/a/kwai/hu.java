package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class hu implements com.kwad.sdk.core.d<AdMatrixInfo.Styles> {
    private static void a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styles.templateList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("templates");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                AdMatrixInfo.MatrixTemplate matrixTemplate = new AdMatrixInfo.MatrixTemplate();
                matrixTemplate.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                styles.templateList.add(matrixTemplate);
            }
        }
    }

    private static JSONObject b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "templates", styles.templateList);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.Styles) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.Styles) bVar, jSONObject);
    }
}
