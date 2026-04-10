package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class an {
    private Map<String, com.kwad.sdk.core.webview.a> aZR;
    private Map<String, com.kwad.sdk.core.webview.c.c> aZS;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.aZR.put(str, aVar);
    }

    public final com.kwad.sdk.core.webview.a gZ(String str) {
        return this.aZR.get(str);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aZS.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.c.c ha(String str) {
        return this.aZS.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> it = this.aZR.values().iterator();
        while (it.hasNext()) {
            it.next().pQ();
        }
        this.aZR.clear();
        this.aZS.clear();
    }
}
