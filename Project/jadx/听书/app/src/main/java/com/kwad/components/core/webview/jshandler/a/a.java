package com.kwad.components.core.webview.jshandler.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    public static class C0355a extends com.kwad.sdk.core.response.a.a {
        public String aeH;
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "checkAppInstalled";
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String aS(String str) {
        try {
            C0355a c0355a = new C0355a();
            c0355a.parseJson(new JSONObject(str));
            return c0355a.aeH;
        } catch (Throwable unused) {
            return null;
        }
    }
}
