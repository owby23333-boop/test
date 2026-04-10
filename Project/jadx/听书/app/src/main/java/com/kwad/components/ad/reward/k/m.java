package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends w {

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String name = "backPressed";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerBackPressedListener";
    }

    public final void kq() {
        b(new a());
    }
}
