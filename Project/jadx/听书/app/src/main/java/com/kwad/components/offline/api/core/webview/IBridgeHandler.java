package com.kwad.components.offline.api.core.webview;

/* JADX INFO: loaded from: classes4.dex */
public interface IBridgeHandler {
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
