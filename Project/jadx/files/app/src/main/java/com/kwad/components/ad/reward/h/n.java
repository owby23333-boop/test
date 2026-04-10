package com.kwad.components.ad.reward.h;

import com.kwad.components.core.webview.jshandler.t;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends t {
    private WeakReference<com.kwad.components.ad.reward.j> qQ;
    private long xu;

    public n(com.kwad.components.ad.reward.j jVar, long j2, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.xu = -1L;
        this.xu = j2;
        if (jVar != null) {
            this.qQ = new WeakReference<>(jVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.t
    public final void a(com.kwad.sdk.core.report.i iVar) {
        super.a(iVar);
        WeakReference<com.kwad.components.ad.reward.j> weakReference = this.qQ;
        if (weakReference != null && weakReference.get() != null) {
            iVar.R(this.qQ.get().pw.getPlayDuration());
            return;
        }
        long j2 = this.xu;
        if (j2 > 0) {
            iVar.R(j2);
        }
    }
}
