package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.f, com.kwad.components.ad.reward.d.h, z.b {
    private com.kwad.components.core.webview.a.d.b gy;
    private float sQ;
    private boolean tf;

    @Nullable
    private a tg;

    @Nullable
    private p th;

    @Nullable
    private n ti;
    private o tj;
    private int tk;
    private boolean tl;
    private boolean tm;
    private boolean tn;

    class a extends com.kwad.components.core.video.j {
        private long tp;
        private long videoDuration;

        private a() {
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            this.tp = j3;
            this.videoDuration = j2;
            if (q.this.qS.fX()) {
                return;
            }
            q.this.a(j2, j3, false);
        }
    }

    public q(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    public q(AdTemplate adTemplate, boolean z2, boolean z3) {
        this.tk = 0;
        this.tl = false;
        this.tm = true;
        this.tn = true;
        this.tm = z2;
        this.tn = z3;
        if (com.kwad.sdk.core.response.a.a.bu(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            this.tj = new o();
            a(this.tj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.d.f fVar) {
        return getPriority() - fVar.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3, boolean z2) {
        p pVar;
        if (hY() && j3 >= 10000 && ((float) j3) >= ((float) j2) * this.sQ) {
            if (!com.kwad.components.ad.reward.kwai.b.gW()) {
                n nVar = this.ti;
                if (nVar != null) {
                    nVar.M(!z2);
                    this.tk = 2;
                    return;
                }
                return;
            }
            if (this.tl || (pVar = this.th) == null) {
                return;
            }
            pVar.hT();
            this.tk = 1;
            this.tl = true;
        }
    }

    private com.kwad.components.core.webview.a.d.b bW() {
        if (this.gy == null) {
            this.gy = new com.kwad.components.core.webview.a.d.b() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // com.kwad.components.core.webview.a.d.b
                public final void u(String str) {
                    q.this.hX();
                }
            };
        }
        return this.gy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX() {
        if (this.tn) {
            this.th = new p(this);
            a((Presenter) this.th, true);
        }
        if (this.tm) {
            this.ti = new n(this);
            a((Presenter) this.ti, true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.d.a(), true);
    }

    private boolean hY() {
        return this.tf;
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.l lVar) {
        n nVar;
        p pVar;
        this.qS.B(true);
        if (this.tk == 1 && (pVar = this.th) != null) {
            pVar.hU();
        } else {
            if (this.tk != 2 || (nVar = this.ti) == null) {
                return;
            }
            nVar.hide();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z.b
    public final void a(z.a aVar) {
        a aVar2;
        this.tf = aVar.isSuccess();
        if (!this.tf || (aVar2 = this.tg) == null) {
            return;
        }
        a(aVar2.videoDuration, this.tg.tp, false);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.bu(adInfoCb)) {
            if (this.qS.pO) {
                com.kwad.components.core.webview.a.c.a.rE().a(bW());
            } else {
                bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.this.hX();
                    }
                }, 100L);
            }
        } else if (!com.kwad.sdk.core.response.a.a.bx(adInfoCb)) {
            com.kwad.components.core.m.a.pr().P(this.qS.mAdTemplate);
        }
        this.qS.b(this);
        com.kwad.components.core.playable.a aVar = this.qS.py;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean zGV = com.kwad.components.ad.reward.kwai.b.gV();
        this.sQ = com.kwad.components.ad.reward.kwai.b.gU();
        if (zGV) {
            this.tg = new a(this, (byte) 0);
            this.qS.pw.a(this.tg, null);
        }
        com.kwad.components.ad.reward.b.fz().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        RewardActionBarControl.ShowActionBarResult showActionBarResultIw = this.qS.pz.iw();
        if (showActionBarResultIw != null) {
            showActionBarResultIw.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.tj == null || this.qS.gi()) {
            return;
        }
        if (hY()) {
            this.tj.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.tj.hS();
        }
    }

    public final boolean bX() {
        boolean zGo = this.qS.go();
        if (!this.qS.fX() || zGo) {
            return false;
        }
        com.kwad.components.ad.reward.b.fz().fA();
        this.qS.B(false);
        return true;
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        this.qS.B(false);
        a aVar = this.tg;
        if (aVar == null || this.tk != 2) {
            return;
        }
        a(aVar.videoDuration, this.tg.tp, true);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.c(this);
        com.kwad.components.core.playable.a aVar = this.qS.py;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.tg;
        if (aVar2 != null) {
            this.qS.pw.b(aVar2, null);
        }
        com.kwad.components.ad.reward.b.fz().b(this);
        com.kwad.components.core.webview.a.c.a.rE().b(this.gy);
    }
}
