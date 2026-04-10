package com.kwad.sdk.core.webview.d;

import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.core.webview.request.WebCardGetDataResponse;
import com.kwad.sdk.core.webview.request.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c aNM;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String method;
        public String params;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "requestData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        this.aNM = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            a(aVar);
        } catch (JSONException e) {
            c cVar2 = this.aNM;
            if (cVar2 != null) {
                cVar2.onError(-1, "data parse json error.");
            }
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private void a(a aVar) {
        new com.kwad.sdk.core.webview.request.b().a(aVar, new b.a() { // from class: com.kwad.sdk.core.webview.d.b.1
            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void onError(int i, String str) {
                if (b.this.aNM != null) {
                    b.this.aNM.onError(i, str);
                }
            }

            @Override // com.kwad.sdk.core.webview.request.b.a
            public final void a(WebCardGetDataResponse webCardGetDataResponse) {
                if (b.this.aNM != null) {
                    b.this.aNM.a(webCardGetDataResponse);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aNM = null;
    }
}
