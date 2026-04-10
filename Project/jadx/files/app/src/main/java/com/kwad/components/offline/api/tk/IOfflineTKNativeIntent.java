package com.kwad.components.offline.api.tk;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface IOfflineTKNativeIntent {
    void callTKBridge(String str);

    void callbackPageStatus(boolean z2, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
