package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends b {
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.iH();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.m jF = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.c.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            n.this.tm.rE.release();
            n.this.tm.gK();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rE.a(this.jE);
        com.kwad.components.ad.reward.c.gn().a(this.jF);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        com.kwad.components.ad.reward.c.gn().b(this.jF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH() {
        if (com.kwad.components.core.t.k.d(this.tm.mAdTemplate, this.tm.rX)) {
            com.kwad.components.core.t.k.f(this.tm.mContext, this.tm.mAdTemplate);
        }
        if (i.z(this.tm) || com.kwad.components.core.t.k.d(this.tm.mAdTemplate, this.tm.rX)) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.tm.gK();
                }
            }, 200L);
        } else {
            this.tm.gK();
        }
    }
}
