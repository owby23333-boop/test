package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements com.kwad.sdk.core.d<AdMatrixInfo> {
    private static void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMatrixInfo.styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles.parseJson(jSONObject.optJSONObject("styles"));
        adMatrixInfo.adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
        adMatrixInfo.tag = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tag");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                AdMatrixInfo.MatrixTag matrixTag = new AdMatrixInfo.MatrixTag();
                matrixTag.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                adMatrixInfo.tag.add(matrixTag);
            }
        }
    }

    private static JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.s.a(jSONObject, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.s.a(jSONObject, "adDataV2", adMatrixInfo.adDataV2);
        com.kwad.sdk.utils.s.putValue(jSONObject, "tag", adMatrixInfo.tag);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo) bVar, jSONObject);
    }
}
