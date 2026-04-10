package com.kwad.components.ad.interstitial.f;

import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b implements a.c {
    private static long nb = 1000;
    private AdTemplate mAdTemplate;
    private c mj;
    private a nc;
    private int nd;

    @Override // com.kwad.components.core.video.a.c
    public final void aq() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) NN();
        this.mj = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        long j = adInfoEl.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.nd = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(adInfoEl), j);
        } else {
            this.nd = com.kwad.components.ad.interstitial.b.b.b(adInfoEl);
        }
        if (this.mj.mk != null) {
            this.mj.mk.b(true, this.nd);
        }
        if (com.kwad.sdk.core.response.b.a.bc(adInfoEl)) {
            this.nc = null;
            this.mj.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.nc = aVar;
            bw.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.mj.b(this);
        a aVar = this.nc;
        if (aVar != null) {
            aVar.r(true);
            bw.c(this.nc);
            this.nc = null;
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dR() {
        super.dR();
        a aVar = this.nc;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dS() {
        super.dS();
        a aVar = this.nc;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i) {
        if (this.mj.mk == null) {
            return;
        }
        if (i == 0) {
            if (this.mj.dV()) {
                return;
            }
            this.mj.c(getContext(), this.mAdTemplate);
            ev();
            c cVar = this.mj;
            cVar.a(true, -1, cVar.cq);
            return;
        }
        this.mj.mk.b(true, i);
    }

    private void ev() {
        if (this.mj.cq != null) {
            this.mj.cq.release();
        }
        this.mj.kW.dismiss();
        this.mj.Y();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j) {
        P(this.nd - ((int) (j / 1000)));
    }

    @Override // com.kwad.components.core.video.a.c
    public final void ar() {
        if (this.mj.dV()) {
            return;
        }
        this.mj.c(getContext(), this.mAdTemplate);
        ev();
    }

    class a implements Runnable {
        private int ne;
        private boolean nf;
        private boolean ng;

        private a() {
            this.ne = Integer.MIN_VALUE;
            this.nf = false;
            this.ng = false;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void r(boolean z) {
            this.ng = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.ng) {
                return;
            }
            if (this.nf) {
                bw.a(this, null, e.nb);
                return;
            }
            if (this.ne == Integer.MIN_VALUE) {
                this.ne = e.this.nd;
            }
            if (this.ne < 0) {
                return;
            }
            com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.ne);
            e.this.P(this.ne);
            this.ne--;
            bw.a(this, null, e.nb);
        }

        public final void s(boolean z) {
            this.nf = z;
        }
    }
}
