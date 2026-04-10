package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.b.a {
    private InterfaceC0367a xm;

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0367a {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        jl();
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    public void jl() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xm = null;
    }
}
