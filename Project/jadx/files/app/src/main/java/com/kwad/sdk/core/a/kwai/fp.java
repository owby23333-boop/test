package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fp implements com.kwad.sdk.core.d<PageInfo> {
    private static void a(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    private static JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = pageInfo.pageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pageType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PageInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PageInfo) bVar, jSONObject);
    }
}
