package com.kwad.components.ad.reward.presenter.c.kwai;

import android.widget.FrameLayout;
import com.kwad.components.ad.i.a;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements a.b {
    private FrameLayout de;
    private volatile long vy = 0;
    private volatile boolean vz = false;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.vz = true;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            a.this.vy = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.vz = false;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.vz = false;
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            a.this.vy = j3;
            a.this.vz = j2 - j3 < 800;
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.4
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (a.this.qS.qb || a.this.qS.pC == null) {
                return;
            }
            a.this.qS.pC.az();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.5
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            a.this.qS.mAdOpenInteractionListener.bN();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.vy = 0L;
        this.vz = false;
        com.kwad.components.ad.reward.j jVar = this.qS;
        AdTemplate adTemplate = jVar.mAdTemplate;
        com.kwad.components.ad.i.a aVar = jVar.pC;
        if (aVar != null) {
            jVar.pW = true;
            aVar.a(this);
            aVar.a(this.cV);
            aVar.a(this.de, this.qS.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0352a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.a.3
                @Override // com.kwad.components.ad.i.a.InterfaceC0352a
                public final void V(boolean z2) {
                    a.this.qS.pW = z2;
                }
            });
            aVar.setActivity(this.qS.getActivity());
            aVar.aF();
            this.qS.b(this.mPlayEndPageListener);
            this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        }
    }

    @Override // com.kwad.components.ad.i.a.b
    public final void iK() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        e.a(jVar, jVar.gk());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.de = (FrameLayout) findViewById(R.id.ksad_landing_page_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.c(this.mPlayEndPageListener);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
