package com.kwad.components.offline.api.tk.jsbridge;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IOfflineCompoBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
