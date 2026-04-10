package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.b.a {

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean xq;
    }

    public void Y(boolean z2) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        boolean z2;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            z2 = aVar.xq;
        } catch (Exception unused) {
            z2 = false;
        }
        Y(z2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
