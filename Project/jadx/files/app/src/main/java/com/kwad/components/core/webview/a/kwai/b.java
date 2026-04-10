package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.webview.b.a {
    protected final com.kwad.sdk.core.webview.b Sk;
    private AdTemplate mAdTemplate;

    public b(@NonNull com.kwad.sdk.core.webview.b bVar, @NonNull AdTemplate adTemplate) {
        this.Sk = bVar;
        this.mAdTemplate = adTemplate;
    }

    private void T(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.d.b.a.a(new a.C0395a(this.Sk.LI.getContext()).J(adTemplate).ap(1).an(false));
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("adTemplate")) {
                String string = jSONObject.getString("adTemplate");
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(string));
                T(adTemplate);
            } else {
                T(this.mAdTemplate);
            }
            cVar.a(null);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
