package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction akt;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.akt = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(final com.kwad.sdk.core.b bVar) {
        if (com.kwad.sdk.core.config.e.Fr()) {
            GlobalThreadPools.Jy().submit(new Runnable() { // from class: com.kwad.components.offline.d.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final String string = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
                    bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.d.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.akt != null) {
                                a.this.akt.onSuccess(string);
                            }
                        }
                    });
                }
            });
            return;
        }
        String string = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.akt;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(string);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i, String str) {
        String string = new com.kwad.sdk.core.webview.c.e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.akt;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(string);
        }
    }
}
