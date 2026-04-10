package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends a {
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            m.this.hP();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.m.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            m.this.hP();
        }
    };
    private final com.kwad.components.ad.reward.d.k gr = new com.kwad.components.ad.reward.d.k() { // from class: com.kwad.components.ad.reward.presenter.m.4
        @Override // com.kwad.components.ad.reward.d.k
        public final void a(com.kwad.components.core.webview.a.a.p pVar) {
            if (pVar == null || pVar.type != 1) {
                return;
            }
            m.this.qS.pw.release();
            m.this.qS.ga();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hP() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        if (com.kwad.components.core.r.k.e(jVar.mAdTemplate, jVar.pS)) {
            com.kwad.components.ad.reward.j jVar2 = this.qS;
            com.kwad.components.core.r.k.f(jVar2.mContext, jVar2.mAdTemplate);
        }
        if (!h.u(this.qS)) {
            com.kwad.components.ad.reward.j jVar3 = this.qS;
            if (!com.kwad.components.core.r.k.e(jVar3.mAdTemplate, jVar3.pS)) {
                this.qS.ga();
                return;
            }
        }
        bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.m.1
            @Override // java.lang.Runnable
            public final void run() {
                m.this.qS.ga();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.ad.reward.d.fG().a(this.gr);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.ad.reward.d.fG().b(this.gr);
    }
}
