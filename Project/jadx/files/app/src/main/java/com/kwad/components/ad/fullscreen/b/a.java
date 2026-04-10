package com.kwad.components.ad.fullscreen.b;

import com.kwad.components.ad.reward.d;
import com.kwad.components.ad.reward.d.k;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.webview.a.a.p;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.fullscreen.b.a.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            a.this.qS.ga();
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.a.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.qS.ga();
        }
    };
    private final k gr = new k() { // from class: com.kwad.components.ad.fullscreen.b.a.3
        @Override // com.kwad.components.ad.reward.d.k
        public final void a(p pVar) {
            if (pVar == null || pVar.type != 1) {
                return;
            }
            a.this.qS.pw.release();
            a.this.qS.ga();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        d.fG().a(this.gr);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        d.fG().b(this.gr);
    }
}
