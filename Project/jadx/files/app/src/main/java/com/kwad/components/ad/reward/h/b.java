package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.webview.b.a {
    private a xn;

    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        jl();
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    public void jl() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xn = null;
    }
}
