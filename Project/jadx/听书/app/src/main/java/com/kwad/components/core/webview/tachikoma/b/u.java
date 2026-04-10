package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u implements com.kwad.sdk.core.webview.c.a {
    private a agH;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void a(b bVar);
    }

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int errorCode;
        public String errorMsg;
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "splashShowStatus";
    }

    public final void a(a aVar) {
        this.agH = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.agH != null) {
            b bVar = new b();
            try {
                try {
                    bVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.agH.a(bVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agH = null;
    }
}
