package com.kwad.components.offline.tk.kwai;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.k;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements IOfflineTKRenderListener {
    private final k XF;

    public f(k kVar) {
        this.XF = kVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        k kVar = this.XF;
        if (kVar != null) {
            kVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        k kVar = this.XF;
        if (kVar != null) {
            kVar.onSuccess();
        }
    }
}
