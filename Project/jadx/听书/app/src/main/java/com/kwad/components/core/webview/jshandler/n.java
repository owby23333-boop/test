package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements com.kwad.sdk.core.webview.c.a {
    com.kwad.sdk.core.webview.b acw;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "cancelAppDownloadForAd";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public n(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.download.a.dM(com.kwad.sdk.core.response.b.e.el(a(aVar)).adConversionInfo.appDownloadUrl);
            cVar.a(null);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            cVar.onError(-1, th.getMessage());
        }
    }

    private AdTemplate a(a aVar) {
        if (aVar.adTemplate != null) {
            return aVar.adTemplate;
        }
        return this.acw.dk(aVar.NN);
    }

    public static class a implements com.kwad.sdk.core.b {
        public String NN;
        public AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.NN = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.NN);
            return jSONObject;
        }
    }
}
