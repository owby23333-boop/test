package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ae {
    private Map<String, com.kwad.sdk.core.webview.a> ayR;
    private Map<String, com.kwad.sdk.core.webview.b.c> ayS;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.ayR.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.b.c cVar) {
        this.ayS.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a en(String str) {
        return this.ayR.get(str);
    }

    public final com.kwad.sdk.core.webview.b.c eo(String str) {
        return this.ayS.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> it = this.ayR.values().iterator();
        while (it.hasNext()) {
            it.next().nL();
        }
        this.ayR.clear();
        this.ayS.clear();
    }
}
