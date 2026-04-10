package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.c.g akF;

    f(com.kwad.sdk.core.webview.c.g gVar) {
        this.akF = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.akF;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
