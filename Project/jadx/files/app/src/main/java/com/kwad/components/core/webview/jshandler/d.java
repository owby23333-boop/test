package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.webview.b.a {
    private a Sf;

    public interface a {
        void onPlayAgainClick(boolean z2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.Sf != null) {
                    d.this.Sf.onPlayAgainClick(false);
                }
            }
        });
    }

    public final void b(a aVar) {
        this.Sf = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
