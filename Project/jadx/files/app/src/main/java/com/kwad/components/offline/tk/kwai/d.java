package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.b.g XD;

    d(com.kwad.sdk.core.webview.b.g gVar) {
        this.XD = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.b.g gVar = this.XD;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
