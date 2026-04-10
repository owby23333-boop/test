package com.kwad.components.ad.reward.presenter;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, as.b {
    private com.kwad.components.core.webview.tachikoma.f.g jN;
    private float vY;
    private boolean wn;
    private a wo;
    private q wp;
    private o wq;
    private p wr;
    private int ws;
    private boolean wt;
    private boolean wu;
    private boolean wv;

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.ws = 0;
        this.wt = false;
        this.wu = z;
        this.wv = z2;
        if (com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            p pVar = new p();
            this.wr = pVar;
            a(pVar);
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bK(adInfoEl)) {
            if (!this.tm.rT) {
                bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        r.this.iP();
                    }
                }, 100L);
            } else {
                com.kwad.components.core.webview.tachikoma.e.c.vO().a(dh());
            }
        } else if (!com.kwad.sdk.core.response.b.a.bN(adInfoEl)) {
            com.kwad.components.core.p.a.se().aJ(this.tm.mAdTemplate);
        }
        this.tm.b(this);
        if (this.tm.rF != null) {
            this.tm.rF.a(this);
        }
        boolean zHG = com.kwad.components.ad.reward.a.b.hG();
        this.vY = com.kwad.components.ad.reward.a.b.hF();
        if (zHG) {
            this.wo = new a(this, (byte) 0);
            if (this.tm.rE != null) {
                this.tm.rE.a(this.wo);
            }
        }
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this);
        if (this.tm.rF != null) {
            this.tm.rF.b(this);
        }
        if (this.wo != null && this.tm.rE != null) {
            this.tm.rE.b(this.wo);
        }
        com.kwad.components.ad.reward.a.gg().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.jN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        if (this.wv) {
            q qVar = new q(this);
            this.wp = qVar;
            a((Presenter) qVar, true);
        }
        if (this.wu) {
            o oVar = new o(this);
            this.wq = oVar;
            a((Presenter) oVar, true);
        }
    }

    public final boolean onBackPressed() {
        boolean zGU = this.tm.gU();
        if (!this.tm.gG() || zGU) {
            return false;
        }
        com.kwad.components.ad.reward.a.gg().gh();
        this.tm.A(false);
        return true;
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        a aVar2;
        boolean zIsSuccess = aVar.isSuccess();
        this.wn = zIsSuccess;
        if (!zIsSuccess || (aVar2 = this.wo) == null) {
            return;
        }
        b(aVar2.videoDuration, this.wo.wx, false);
    }

    private com.kwad.components.core.webview.tachikoma.f.g dh() {
        if (this.jN == null) {
            this.jN = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void v(String str) {
                    r.this.iP();
                }
            };
        }
        return this.jN;
    }

    private boolean iQ() {
        return this.wn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, boolean z) {
        q qVar;
        if (iQ() && j2 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT && ((float) j2) >= ((float) j) * this.vY) {
            if (com.kwad.components.ad.reward.a.b.hH()) {
                if (this.wt || (qVar = this.wp) == null) {
                    return;
                }
                qVar.iL();
                this.ws = 1;
                this.wt = true;
                return;
            }
            o oVar = this.wq;
            if (oVar != null) {
                oVar.I(!z);
                this.ws = 2;
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        RewardActionBarControl.ShowActionBarResult showActionBarResultJr = this.tm.rG.jr();
        if (showActionBarResultJr != null) {
            showActionBarResultJr.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.wr == null || this.tm.gQ()) {
            return;
        }
        if (iQ()) {
            this.wr.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.wr.iK();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.tm.A(true);
        int i = this.ws;
        if (i == 1 && (qVar = this.wp) != null) {
            qVar.iM();
        } else {
            if (i != 2 || (oVar = this.wq) == null) {
                return;
            }
            oVar.hide();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        this.tm.A(false);
        a aVar = this.wo;
        if (aVar == null || this.ws != 2) {
            return;
        }
        b(aVar.videoDuration, this.wo.wx, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    class a extends com.kwad.components.core.video.m {
        private long videoDuration;
        private long wx;

        private a() {
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            this.wx = j2;
            this.videoDuration = j;
            if (r.this.tm.gG()) {
                return;
            }
            r.this.b(j, j2, false);
        }
    }
}
