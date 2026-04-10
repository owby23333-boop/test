package com.kwad.components.ad.interstitial.d;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.core.widget.kwai.a {
    private View mRootView;

    public b(@NonNull View view, int i2) {
        super(view, 100);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public final boolean et() {
        return com.kwad.sdk.b.kwai.a.m(this.mRootView, 100);
    }
}
