package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.s;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements IOfflineTKRenderListener {
    private final s akH;

    public h(s sVar) {
        this.akH = sVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        s sVar = this.akH;
        if (sVar != null) {
            sVar.onSuccess();
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        s sVar = this.akH;
        if (sVar != null) {
            sVar.onFailed(th);
        }
    }
}
