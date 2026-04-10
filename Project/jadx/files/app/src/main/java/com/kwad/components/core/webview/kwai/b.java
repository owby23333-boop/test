package com.kwad.components.core.webview.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public String params;
    public String title;
    public String url;

    public final long rn() {
        try {
            return new JSONObject(this.params).optLong("creativeId", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
