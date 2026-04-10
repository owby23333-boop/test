package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends b {
    private long jY;
    private com.kwad.components.ad.reward.e.b rD;
    private com.kwad.components.core.video.m vQ;
    private com.kwad.components.core.video.m vR = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.rD.onVideoPlayStart();
            m.this.tm.ss = false;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (m.this.tm.rS && m.this.tm.rX) {
                m.this.rD.onVideoSkipToEnd(m.this.jY);
            } else {
                m.this.tm.ss = true;
                m.this.rD.onVideoPlayEnd();
            }
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(m.this.tm.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(adInfoEl) && com.kwad.sdk.core.response.b.a.aN(adInfoEl) == 1) {
                return;
            }
            f.u(m.this.tm);
            if (m.this.tm.ss) {
                com.kwad.components.ad.reward.l.j(m.this.tm);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            m.this.tm.sr = j2;
            if (m.this.tm.rX) {
                return;
            }
            m.this.jY = j2;
        }
    };
    private final com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            m.this.rD.onVideoPlayStart();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            m.this.tm.sr = j2;
            m.this.tm.ss = j - j2 < 800;
            if (m.this.tm.rX) {
                return;
            }
            m.this.jY = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            m.this.rD.onVideoPlayError(i, i2);
            m.this.iz();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            if (m.this.tm.rX) {
                m.this.rD.onVideoSkipToEnd(m.this.jY);
            } else {
                m.this.rD.onVideoPlayEnd();
            }
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(m.this.tm.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(adInfoEl) && com.kwad.sdk.core.response.b.a.aN(adInfoEl) == 1) {
                return;
            }
            f.u(m.this.tm);
            if (m.this.tm.ss) {
                com.kwad.components.ad.reward.l.j(m.this.tm);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.sr = 0L;
        this.tm.ss = false;
        this.rD = this.tm.rD;
        if (this.tm.rE.kW()) {
            this.vQ = this.vR;
        } else {
            this.vQ = this.jE;
        }
        this.tm.rE.a(this.vQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.vQ);
    }
}
