package com.kwad.components.offline.d;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.components.core.o.a.e.b {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return 100;
    }

    @Override // com.kwad.sdk.components.b
    public final Class<?> getComponentsType() {
        return com.kwad.components.core.o.a.e.b.class;
    }

    @Override // com.kwad.components.core.o.a.e.b
    public final void a(com.kwad.components.core.o.a.e.a aVar) {
        c.wx().a(aVar);
    }

    @Override // com.kwad.components.core.o.a.e.b
    public final void b(com.kwad.components.core.o.a.e.a aVar) {
        c.wx().b(aVar);
    }
}
