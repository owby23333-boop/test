package com.kwad.components.offline.api.core.webview;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
