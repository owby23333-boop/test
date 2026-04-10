package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.d.b {
    private g AM;

    public a(g gVar) {
        this.AM = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hV().a(this.mAdTemplate, bVar);
    }

    public final g ks() {
        return this.AM;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.AM = null;
    }
}
