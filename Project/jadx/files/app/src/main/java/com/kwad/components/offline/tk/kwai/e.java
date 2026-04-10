package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.i;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements IOfflineTKCallHandler {
    private final i XE;

    public e(i iVar) {
        this.XE = iVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        i iVar = this.XE;
        if (iVar != null) {
            iVar.callJS(str);
        }
    }
}
