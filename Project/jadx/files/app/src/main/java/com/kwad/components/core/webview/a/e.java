package com.kwad.components.core.webview.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c nK;

    @Override // com.kwad.sdk.core.webview.b.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.nK = cVar;
    }

    public final void b(final com.kwad.sdk.core.response.kwai.a aVar) {
        if (this.nK != null) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.nK.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nK = null;
    }
}
