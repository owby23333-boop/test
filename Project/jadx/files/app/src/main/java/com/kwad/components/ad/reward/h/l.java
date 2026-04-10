package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.kwai.v;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends v {

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String name = "backPressed";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerBackPressedListener";
    }

    public final void ju() {
        b(new a());
    }
}
