package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.core.widget.kwai.b {
    public d(@NonNull View view, int i2) {
        super(view, 70);
    }

    @Override // com.kwad.components.core.widget.kwai.b, com.kwad.components.core.widget.kwai.a
    public final boolean et() {
        com.kwad.sdk.core.b.b.we();
        if (!com.kwad.sdk.core.b.b.isEnable()) {
            return super.et();
        }
        com.kwad.sdk.core.b.b.we();
        return com.kwad.sdk.core.b.b.isAppOnForeground() && super.et();
    }
}
