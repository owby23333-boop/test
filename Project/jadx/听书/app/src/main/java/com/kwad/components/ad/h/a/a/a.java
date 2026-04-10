package com.kwad.components.ad.h.a.a;

import com.kwad.sdk.core.webview.c.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c qn;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        this.qn = cVar;
    }

    public final void fO() {
        c cVar = this.qn;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }
}
