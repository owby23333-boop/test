package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.utils.ax;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements IOfflineCompoBridgeHandler {
    private final com.kwad.sdk.core.webview.c.a aky;

    public b(com.kwad.sdk.core.webview.c.a aVar) {
        ax.checkNotNull(aVar);
        this.aky = aVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final String getKey() {
        return this.aky.getKey();
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void handleJsCall(String str, IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.aky.a(str, new a(iOfflineCompoCallBackFunction));
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void onDestroy() {
        this.aky.onDestroy();
    }
}
