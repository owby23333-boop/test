package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class ag implements com.kwad.sdk.core.webview.b.a {
    private final a TS;

    public interface a {
        @MainThread
        void bJ();
    }

    public ag(a aVar) {
        this.TS = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.b.c cVar) {
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ag.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ag.this.TS != null) {
                    ag.this.TS.bJ();
                }
                cVar.a(null);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
