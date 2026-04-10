package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b acw;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public b(com.kwad.sdk.core.webview.b bVar, AdTemplate adTemplate) {
        this.acw = bVar;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            if (jSONObject.has("adTemplate")) {
                adTemplate.parseJson(new JSONObject(jSONObject.getString("adTemplate")));
            }
            if (adTemplate.adInfoList.size() != 0) {
                aO(adTemplate);
            } else {
                aO(this.mAdTemplate);
            }
            cVar.a(null);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void aO(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.e.d.a.a(new a.C0333a(this.acw.TG.getContext()).aB(adTemplate).aB(1).ap(true).an(true).as(false));
    }
}
