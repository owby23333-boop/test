package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends a {
    private long gJ;

    @NonNull
    private com.kwad.components.ad.reward.d.b mAdOpenInteractionListener;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qS;
            if (jVar.pN && jVar.pS) {
                lVar.mAdOpenInteractionListener.onVideoSkipToEnd(l.this.gJ);
            } else {
                l lVar2 = l.this;
                lVar2.qS.qi = true;
                lVar2.mAdOpenInteractionListener.onVideoPlayEnd();
            }
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(l.this.qS.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.sdk.core.response.a.a.aG(adInfoCb) == 1) {
                return;
            }
            e.q(l.this.qS);
            com.kwad.components.ad.reward.j jVar2 = l.this.qS;
            if (jVar2.qi) {
                com.kwad.components.ad.reward.m.m(jVar2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            l lVar = l.this;
            com.kwad.components.ad.reward.j jVar = lVar.qS;
            jVar.qh = j2;
            if (jVar.pS) {
                return;
            }
            lVar.gJ = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
            l.this.qS.qi = false;
        }
    };
    private final com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.l.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            l lVar = l.this;
            boolean z2 = lVar.qS.pS;
            com.kwad.components.ad.reward.d.b bVar = lVar.mAdOpenInteractionListener;
            if (z2) {
                bVar.onVideoSkipToEnd(l.this.gJ);
            } else {
                bVar.onVideoPlayEnd();
            }
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(l.this.qS.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.sdk.core.response.a.a.aG(adInfoCb) == 1) {
                return;
            }
            e.q(l.this.qS);
            com.kwad.components.ad.reward.j jVar = l.this.qS;
            if (jVar.qi) {
                com.kwad.components.ad.reward.m.m(jVar);
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            l.this.mAdOpenInteractionListener.onVideoPlayError(i2, i3);
            l.this.hH();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            com.kwad.components.ad.reward.j jVar = l.this.qS;
            jVar.qh = j3;
            jVar.qi = j2 - j3 < 800;
            l lVar = l.this;
            if (lVar.qS.pS) {
                return;
            }
            lVar.gJ = j3;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.j jVar = this.qS;
        jVar.qh = 0L;
        jVar.qi = false;
        this.mAdOpenInteractionListener = jVar.mAdOpenInteractionListener;
        jVar.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
