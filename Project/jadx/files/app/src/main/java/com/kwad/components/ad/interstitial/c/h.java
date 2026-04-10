package com.kwad.components.ad.interstitial.c;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends b implements a.c {
    private static long lb = 1000;
    private c jq;

    @Nullable
    private a lc;
    private int ld;
    private AdTemplate mAdTemplate;

    class a implements Runnable {
        private int le;
        private boolean lf;
        private boolean lg;

        private a() {
            this.le = Integer.MIN_VALUE;
            this.lf = false;
            this.lg = false;
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void q(boolean z2) {
            this.lg = true;
        }

        public final void r(boolean z2) {
            this.lf = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.lg) {
                return;
            }
            if (!this.lf) {
                if (this.le == Integer.MIN_VALUE) {
                    this.le = h.this.ld;
                }
                if (this.le < 0) {
                    return;
                }
                com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", h.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.le);
                h.this.H(this.le);
                this.le = this.le + (-1);
            }
            bh.a(this, null, h.lb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i2) {
        c cVar = this.jq;
        com.kwad.components.ad.interstitial.e.f fVar = cVar.jr;
        if (fVar == null) {
            return;
        }
        if (i2 != 0) {
            fVar.b(true, i2);
        } else {
            if (cVar.da()) {
                return;
            }
            this.jq.b(getContext(), this.mAdTemplate);
            dx();
            c cVar2 = this.jq;
            cVar2.a(true, -1, cVar2.eM);
        }
    }

    private void dx() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.video.videoview.a aVar = this.jq.eM;
        if (aVar != null) {
            aVar.release();
        }
        this.jq.hR.dismiss();
        c cVar = this.jq;
        if (cVar.jv || (adInteractionListener = cVar.hK) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", this + " onBind");
        this.jq = (c) Bs();
        this.mAdTemplate = this.jq.mAdTemplate;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        long j2 = adInfoCb.adInsertScreenInfo.autoCloseTime;
        if (j2 > 0) {
            this.ld = (int) Math.min(com.kwad.components.ad.interstitial.kwai.b.b(adInfoCb), j2);
        } else {
            this.ld = com.kwad.components.ad.interstitial.kwai.b.b(adInfoCb);
        }
        com.kwad.components.ad.interstitial.e.f fVar = this.jq.jr;
        if (fVar != null) {
            fVar.b(true, -1);
        }
        if (com.kwad.sdk.core.response.a.a.aV(adInfoCb)) {
            this.lc = null;
            this.jq.a(this);
        } else {
            this.lc = new a(this, (byte) 0);
            bh.a(this.lc, null, 1000L);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void bt() {
        if (this.jq.da()) {
            return;
        }
        this.jq.b(getContext(), this.mAdTemplate);
        dx();
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cT() {
        super.cT();
        a aVar = this.lc;
        if (aVar != null) {
            aVar.r(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cU() {
        super.cU();
        a aVar = this.lc;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j2) {
        H(this.ld - ((int) (j2 / 1000)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.jq.b(this);
        a aVar = this.lc;
        if (aVar != null) {
            aVar.q(true);
            bh.b(this.lc);
            this.lc = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlaying() {
    }
}
