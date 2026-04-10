package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String playableExtraData;
    }

    public n(com.kwad.sdk.core.webview.b bVar) {
        this.Sk = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.Sk.zf()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        try {
            aVar.playableExtraData = this.Sk.getAdTemplate().adInfoList.get(0).adStyleInfo.playableExtraData;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableAdData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
