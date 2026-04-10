package com.kwad.components.ad.reward.presenter.e;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.h.c;
import com.kwad.components.ad.reward.h.d;
import com.kwad.components.ad.reward.h.g;
import com.kwad.components.ad.reward.h.j;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.a.x;
import com.kwad.components.core.webview.a.kwai.h;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.q;
import com.kwad.components.core.webview.a.kwai.w;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends com.kwad.components.ad.reward.presenter.a implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.h.kwai.e, w.a {
    private com.kwad.components.ad.reward.j.a gR;
    private x mVideoProgress;
    protected com.kwad.components.ad.reward.h.kwai.d wh;
    private p wi;
    private o wj;
    private com.kwad.components.ad.reward.h.h wk;
    private com.kwad.components.ad.reward.h.i wl;
    private boolean wm;
    private com.kwad.components.core.webview.a.kwai.h wn;

    @Nullable
    protected e wo;
    private am.b wp = new am.b() { // from class: com.kwad.components.ad.reward.presenter.e.c.1
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void T(int i2) {
            y.b bVar = new y.b();
            bVar.jS = i2;
            bVar.jU = c.this.qS.mRootContainer.getTouchCoords();
            com.kwad.components.core.d.b.a.a(new a.C0395a(c.this.getContext()).J(c.this.qS.mAdTemplate).b(c.this.qS.mApkDownloadHelper).al(false).a(bVar).an(true));
        }
    };
    private final h.a gS = new h.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.5
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.wj == null || com.kwad.components.ad.reward.kwai.b.gR()) {
                return;
            }
            k kVar = new k();
            kVar.UW = true;
            c.this.wj.b(kVar);
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.e.c.6
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (c.this.wk != null) {
                com.kwad.components.core.webview.a.a.h hVar = new com.kwad.components.core.webview.a.a.h();
                hVar.US = 1;
                c.this.wk.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.7
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (c.this.wl != null) {
                bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.c.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVar = new m();
                        mVar.UX = 1;
                        c.this.wl.a(mVar);
                        if (c.this.wn != null) {
                            c.this.wn.aL(c.this.qS.qn);
                        }
                    }
                }, 0L);
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.e.c.8
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            c.this.hP();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            c.this.a(30000L, j2);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            c.this.g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        }
    };
    private final com.kwad.components.core.video.j mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.e.c.9
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            c.this.hP();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            c.this.ji();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            c.this.a(j2, j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            c.this.g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPreparing() {
            c.this.g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        }
    };

    public c() {
        if (ja()) {
            this.wo = new e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) {
        c(j2, j3);
        g(j3);
    }

    private void c(long j2, long j3) {
        if (j3 < Math.min(com.kwad.sdk.core.response.a.a.Y(this.qS.mAdTemplate.adInfoList.get(0)), j2) - 800) {
            this.qS.qe = (int) (((r4 - j3) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(double d2) {
        x xVar = this.mVideoProgress;
        xVar.Vh = false;
        xVar.Vd = false;
        xVar.nW = (int) ((d2 / 1000.0d) + 0.5d);
        jj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP() {
        if (this.qS.pS) {
            ji();
        } else {
            jh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jc() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 17, jVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jd() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 18, jVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 39, jVar.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 40, jVar.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, 41, jVar.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    private void jh() {
        x xVar = this.mVideoProgress;
        xVar.Vd = true;
        xVar.Vh = false;
        xVar.nW = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate));
        jj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji() {
        x xVar = this.mVideoProgress;
        xVar.Vh = true;
        xVar.Vd = false;
        jj();
    }

    private void jj() {
        x xVar;
        p pVar = this.wi;
        if (pVar == null || (xVar = this.mVideoProgress) == null) {
            return;
        }
        pVar.a(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.qS.mAdOpenInteractionListener.onRewardVerify();
    }

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.j jVar = this.qS;
        if (jVar != null) {
            jVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.w.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.qS.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.wm = ck();
        if (this.wm) {
            this.qS.a(this);
            if (this.wh == null) {
                this.wh = new com.kwad.components.ad.reward.h.kwai.d(this.qS, -1L, getContext());
            }
            if (this.mVideoProgress == null) {
                this.mVideoProgress = new x();
            }
            this.gR = this.qS.pw.ka();
            this.wh.bind(this.qS.getActivity(), this.qS.mAdTemplate, this);
            e eVar = this.wo;
            if (eVar != null) {
                eVar.v(this.qS);
            }
        }
    }

    protected abstract boolean ck();

    @Override // com.kwad.components.core.webview.a.h
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qS.mRootContainer;
    }

    protected boolean ja() {
        return false;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        this.qS.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onCloseTKDialogClick() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.h.kwai.d dVar = this.wh;
        if (dVar == null || dVar.jB() == null) {
            return;
        }
        this.wh.jB().hn();
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterLifecycleLisener(ae aeVar) {
        e eVar = this.wo;
        if (eVar != null) {
            eVar.a(aeVar);
        }
    }

    public void onRegisterVideoMuteStateListener(o oVar) {
        this.wj = oVar;
        this.gR.a(this.gS);
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.c.4
            @Override // java.lang.Runnable
            public final void run() {
                boolean z2 = com.kwad.components.core.r.b.ar(c.this.getContext()).pY() || !c.this.qS.mVideoPlayConfig.isVideoSoundEnable();
                k kVar = new k();
                kVar.UW = z2;
                c.this.wj.b(kVar);
                c.this.gR.setAudioEnabled(!z2, false);
            }
        });
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
        this.wi = pVar;
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        com.kwad.components.ad.reward.h.j jVar = new com.kwad.components.ad.reward.h.j();
        jVar.a(new j.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.10
            @Override // com.kwad.components.ad.reward.h.j.a
            public final void d(com.kwad.components.core.webview.a.a.p pVar) {
                com.kwad.components.ad.reward.d.fG().c(pVar);
            }
        });
        lVar.c(jVar);
        long j2 = this.qS.qg;
        lVar.c(new com.kwad.components.ad.reward.h.f(j2 > 0 ? ((int) j2) / 1000 : 0));
        this.wk = new com.kwad.components.ad.reward.h.h();
        lVar.c(this.wk);
        this.wl = new com.kwad.components.ad.reward.h.i();
        lVar.c(this.wl);
        com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
        this.qS.b(this.mPlayEndPageListener);
        lVar.c(new r(new r.b() { // from class: com.kwad.components.ad.reward.presenter.e.c.11
            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
                c.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.h.c cVar = new com.kwad.components.ad.reward.h.c();
        cVar.a(new c.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.12
            @Override // com.kwad.components.ad.reward.h.c.a
            public final void a(final com.kwad.components.core.webview.a.a.o oVar) {
                com.kwad.components.core.d.b.a.a(new a.C0395a(c.this.getContext()).J(c.this.qS.mAdTemplate).b(c.this.qS.mApkDownloadHelper).ap(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.e.c.12.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (oVar.UZ) {
                            c.this.je();
                        } else {
                            c.this.jf();
                        }
                    }
                }));
            }
        });
        lVar.c(cVar);
        com.kwad.components.ad.reward.h.d dVar = new com.kwad.components.ad.reward.h.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.13
            @Override // com.kwad.components.ad.reward.h.d.a
            public final void jk() {
                com.kwad.components.core.d.b.a.a(new a.C0395a(c.this.getContext()).J(c.this.qS.mAdTemplate).b(c.this.qS.mApkDownloadHelper).ap(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.e.c.13.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        c.this.jg();
                    }
                }));
            }
        });
        lVar.c(dVar);
        lVar.c(new com.kwad.components.ad.reward.h.g(new g.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.14
            @Override // com.kwad.components.ad.reward.h.g.a
            public final void jk() {
                if (com.kwad.components.ad.reward.j.r(c.this.qS.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.j.p(c.this.qS.mAdTemplate) || c.this.qS.qc == null) {
                        if (com.kwad.components.ad.reward.j.q(c.this.qS.mAdTemplate) && c.this.qS.qd != null && !c.this.qS.qd.jO()) {
                            c.this.qS.qd.jN();
                        }
                    } else if (!c.this.qS.qc.jO()) {
                        c.this.qS.qc.jN();
                    }
                }
                c.this.notifyRewardVerify();
            }
        }));
        lVar.c(new com.kwad.components.ad.reward.h.b() { // from class: com.kwad.components.ad.reward.presenter.e.c.15
            @Override // com.kwad.components.ad.reward.h.b
            public final void jl() {
                super.jl();
                c.this.jd();
            }
        });
        lVar.c(new com.kwad.components.ad.reward.h.e() { // from class: com.kwad.components.ad.reward.presenter.e.c.16
            @Override // com.kwad.components.ad.reward.h.e
            public final void Y(boolean z2) {
                super.Y(z2);
                com.kwad.components.ad.reward.presenter.e.a(c.this.qS, c.this.qS.gk(), z2);
            }
        });
        lVar.c(new com.kwad.components.ad.reward.h.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.17
            @Override // com.kwad.components.ad.reward.h.a
            public final void jl() {
                super.jl();
                c.this.jc();
            }
        });
        lVar.c(new q() { // from class: com.kwad.components.ad.reward.presenter.e.c.2
            @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar2) {
                super.a(str, cVar2);
                com.kwad.components.core.r.k.f(c.this.getContext(), c.this.qS.mAdTemplate);
            }
        });
        lVar.c(new com.kwad.components.ad.reward.f.b(getContext(), this.qS.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        this.wn = new com.kwad.components.core.webview.a.kwai.h();
        this.wn.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.e.c.3
            @Override // com.kwad.components.core.webview.a.kwai.h.a
            public final void a(com.kwad.components.core.webview.a.kwai.h hVar) {
                hVar.aL(c.this.qS.qn);
            }
        });
        lVar.c(this.wn);
        lVar.c(new com.kwad.components.core.webview.jshandler.o());
        lVar.c(new am(bVar, this.qS.mApkDownloadHelper, this.wp));
        lVar.c(new w(this));
    }

    public void onSkipClick(s sVar) {
        com.kwad.components.ad.reward.presenter.e.a(this.qS, false);
    }

    public void onTkLoadFailed() {
        e eVar = this.wo;
        if (eVar != null) {
            eVar.onTkLoadFailed();
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onTkLoadSuccess() {
        e eVar = this.wo;
        if (eVar != null) {
            eVar.onTkLoadSuccess();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.wm) {
            e eVar = this.wo;
            if (eVar != null) {
                eVar.w(this.qS);
            }
            this.qS.b(this);
            this.wh.unBind();
            this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
            this.gR.b(this.gS);
            com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
            this.qS.c(this.mPlayEndPageListener);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onUpdateMuteStatus(k kVar) {
        com.kwad.components.ad.reward.j.a aVar = this.gR;
        if (aVar != null) {
            aVar.setAudioEnabled(!kVar.UW, true);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public void pageClose(WebCloseStatus webCloseStatus) {
    }
}
