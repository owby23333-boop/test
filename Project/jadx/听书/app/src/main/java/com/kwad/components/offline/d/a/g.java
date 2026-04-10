package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.q;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements IOfflineTKCallHandler {
    private final q akG;

    public g(q qVar) {
        this.akG = qVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        q qVar = this.akG;
        if (qVar != null) {
            qVar.callJS(str);
        }
    }
}
