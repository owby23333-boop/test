package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private a acZ;
    private final com.kwad.sdk.core.webview.b acw;
    private Handler iK = new Handler(Looper.getMainLooper());

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void cK();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "dislike";
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.acw = bVar;
        this.acZ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.iK.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ad.this.acZ.cK();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.iK.removeCallbacksAndMessages(null);
    }
}
