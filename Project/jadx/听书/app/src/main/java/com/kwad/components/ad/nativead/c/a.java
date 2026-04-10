package com.kwad.components.ad.nativead.c;

import android.content.Context;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.k.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    private KsAdVideoPlayConfig bU;
    private OfflineOnAudioConflictListener cB;
    private boolean cp;
    private a.b fD;
    private com.kwad.components.core.widget.a.b fg;
    private final c fo;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;
    private boolean pW;
    private boolean pX;
    private m pY;
    private int pZ;
    private long qa;

    static /* synthetic */ int a(a aVar, int i) {
        aVar.pZ = 3;
        return 3;
    }

    static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.cp = false;
        return false;
    }

    public a(final AdTemplate adTemplate, com.kwad.components.core.widget.a.b bVar, DetailVideoView detailVideoView, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.fo = new c() { // from class: com.kwad.components.ad.nativead.c.a.4
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                com.kwad.components.core.k.a.qp().a(a.this.getCurrentVoiceItem());
                a.this.fJ();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                com.kwad.components.core.k.a.qp().c(a.this.fD);
                a.this.pause();
            }
        };
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.nativead.c.a.6
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }
        };
        this.fg = bVar;
        AdInfo adInfoEl = e.el(this.mAdTemplate);
        this.mAdInfo = adInfoEl;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.pW = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.pW = com.kwad.sdk.core.response.b.a.ca(adInfoEl);
        }
        this.bU = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        this.pY = new m() { // from class: com.kwad.components.ad.nativead.c.a.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.p.a.se().g(adTemplate, i, i2);
            }
        };
        this.LU.c(this.pY);
        bs();
        this.LU.a(new c.e() { // from class: com.kwad.components.ad.nativead.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    if (a.this.fK() && a.this.fg.ae() && a.this.fI()) {
                        a.this.LU.a(com.kwad.sdk.contentalliance.a.a.a.bQ(a.this.mAdTemplate));
                        com.kwad.components.core.k.a.qp().a(a.this.getCurrentVoiceItem());
                        a.this.LU.start(a.this.qa);
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fI() {
        int i = this.pZ;
        return (i == 3 || i == 2) ? false : true;
    }

    public final void bo() {
        n.eM(this.mAdTemplate);
        if (this.LU.tz() == null) {
            bs();
        }
        if (fK() && this.fg.ae()) {
            this.LU.a(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
            com.kwad.components.core.k.a.qp().a(getCurrentVoiceItem());
            this.LU.start(this.qa);
        }
        this.LU.c(new m() { // from class: com.kwad.components.ad.nativead.c.a.3
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                if (j != 0) {
                    a.this.qa = j2;
                }
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                super.onMediaPlayCompleted();
                a.this.qa = 0L;
                a.a(a.this, 3);
            }
        });
        this.fg.a(this.fo);
    }

    public final void bq() {
        n.eK(this.mAdTemplate);
        this.fg.b(this.fo);
        this.LU.release();
        com.kwad.components.core.k.a.qp().c(this.fD);
        com.kwad.components.core.t.a.aC(this.mContext).b(this.cB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ() {
        int i = this.pZ;
        if (i == 1) {
            start();
            return;
        }
        if (i == 2) {
            pause();
        } else if (i == 3) {
            stop();
        } else {
            resume();
        }
    }

    private void start() {
        if (this.pX) {
            resume();
        } else {
            fL();
        }
    }

    private void stop() {
        this.LU.complete();
    }

    private void bs() {
        this.LU.a(new b.a(this.mAdTemplate).dg(e.en(this.mAdTemplate)).dh(h.b(e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).bo(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El(), true, true, this.mDetailVideoView);
        setAudioEnabled(h(this.pW));
        if (fK()) {
            this.LU.prepareAsync();
            com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        com.kwad.components.core.k.a.qp().a(getCurrentVoiceItem());
        setAudioEnabled(h(this.pW));
        if (fK()) {
            this.LU.start(this.qa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (this.fD != null) {
            com.kwad.components.core.k.a.qp();
            if (!com.kwad.components.core.k.a.b(this.fD)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.e.hC()) {
            if (com.kwad.components.core.t.a.aC(this.mContext).sX()) {
                return !com.kwad.components.core.t.a.aC(this.mContext).sW();
            }
            return com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    public final void V(int i) {
        this.pZ = i;
        if (this.fg.ae()) {
            fJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.LU.setAudioEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fK() {
        if (this.pX) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ao.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ao.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ao.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ao.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.b.a.cc(this.mAdInfo) && ao.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.cd(this.mAdInfo) && ao.isWifiConnected(this.mContext);
    }

    public final void fL() {
        this.pX = true;
        this.mAdInfo.isAllowVideoAutoPlay = true;
        if (this.fg.ae()) {
            n.eL(this.mAdTemplate);
            this.LU.a(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
            com.kwad.components.core.k.a.qp().a(getCurrentVoiceItem());
            this.LU.start(this.qa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.fD == null) {
            this.fD = new a.b(new a.c() { // from class: com.kwad.components.ad.nativead.c.a.5
                @Override // com.kwad.components.core.k.a.c
                public final void bF() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.h(aVar.pW));
                }
            });
        }
        return this.fD;
    }
}
