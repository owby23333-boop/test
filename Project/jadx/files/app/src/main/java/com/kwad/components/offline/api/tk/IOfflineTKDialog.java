package com.kwad.components.offline.api.tk;

/* JADX INFO: loaded from: classes3.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z2, String str);

    int getDialogId();

    String getStyleTemplate();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
