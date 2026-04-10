package com.kwad.components.ad.c;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.core.widget.a.b {
    public f(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        com.kwad.sdk.core.c.b.Ho();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.Ho();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ae();
        }
        return super.ae();
    }
}
