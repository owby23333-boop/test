package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.b.c {
    private final IOfflineCompoCallBackFunction Xy;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.Xy = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.b.c
    public final void a(com.kwad.sdk.core.b bVar) {
        String string = new com.kwad.sdk.core.webview.b.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.Xy;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(string);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.c
    public final void onError(int i2, String str) {
        String string = new com.kwad.sdk.core.webview.b.e(i2, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.Xy;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(string);
        }
    }
}
