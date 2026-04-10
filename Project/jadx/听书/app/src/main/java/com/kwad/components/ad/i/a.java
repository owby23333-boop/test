package com.kwad.components.ad.i;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.a.a {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.a.a
    public final boolean T() {
        return e.ge().T();
    }

    @Override // com.kwad.components.ad.b.a.a
    public final void a(com.kwad.components.ad.b.a.b bVar) {
        e.ge().a(bVar);
    }

    @Override // com.kwad.components.ad.b.a.a
    public final void b(com.kwad.components.ad.b.a.b bVar) {
        e.ge().b(bVar);
    }

    @Override // com.kwad.sdk.components.b
    public final Class<com.kwad.components.ad.b.a.a> getComponentsType() {
        return com.kwad.components.ad.b.a.a.class;
    }
}
