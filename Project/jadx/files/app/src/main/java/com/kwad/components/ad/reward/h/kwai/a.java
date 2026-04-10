package com.kwad.components.ad.reward.h.kwai;

import com.kwad.components.ad.reward.j;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.core.webview.a.b.b {
    private j xw;

    public a(j jVar) {
        this.xw = jVar;
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.b.a.hi().a(((com.kwad.components.core.webview.a.b.b) this).mAdTemplate, bVar);
    }

    public final j jw() {
        return this.xw;
    }

    @Override // com.kwad.components.core.webview.a.b.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.xw = null;
    }
}
