package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.a.x;

/* JADX INFO: loaded from: classes3.dex */
public class p extends v {
    private boolean It = true;

    public final void a(x xVar) {
        if (this.It) {
            super.b(xVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.a(str, cVar);
    }

    public final void aM(boolean z2) {
        this.It = false;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerVideoProgressListener";
    }
}
