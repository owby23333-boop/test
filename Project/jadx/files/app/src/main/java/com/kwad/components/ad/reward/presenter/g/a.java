package com.kwad.components.ad.reward.presenter.g;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h.kwai.d;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.j.kwai.b;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.f;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.b.c;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements h {
    private FrameLayout lC;
    private AdInfo mAdInfo;
    private boolean ud;
    private boolean ue;
    private d wh;
    private boolean xi;
    private f xj;
    private long xk;
    private j.b uf = new j.b() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.j.b
        public final boolean interceptPlayCardResume() {
            return a.this.lC != null && a.this.lC.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.j.kwai.a sD = new b() { // from class: com.kwad.components.ad.reward.presenter.g.a.2
        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            int i2 = 0;
            a.this.xi = false;
            if (a.this.xj == null) {
                return;
            }
            u uVar = new u();
            if (com.kwad.components.core.p.a.pJ().pP()) {
                com.kwad.components.core.p.a.pJ().aH(false);
                if (com.kwad.sdk.core.response.a.a.aG(a.this.mAdInfo) == 0 || com.kwad.components.core.p.a.pJ().pL()) {
                    uVar.Ve = 1;
                }
                a.this.xj.b(uVar);
            }
            if (com.kwad.components.core.p.a.pJ().pN() && com.kwad.sdk.core.response.a.a.aG(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.p.a.pJ().pO() == 1) {
                    if (aj.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.ar(a.this.mAdInfo))) {
                        i2 = 2;
                        uVar.Ve = 2;
                    }
                } else if (com.kwad.components.core.p.a.pJ().pO() != 3) {
                    return;
                } else {
                    uVar.Ve = 1;
                }
                com.kwad.components.core.p.a.pJ().aE(i2);
                a.this.xj.b(uVar);
                return;
            }
            return;
            uVar.Ve = 0;
            a.this.xj.b(uVar);
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            super.b(dVar);
            a.this.xi = true;
        }
    };
    private final com.kwad.components.core.video.j mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.g.a.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            long jA = j.a(j2, a.this.mAdInfo);
            long jAF = ((long) com.kwad.sdk.core.response.a.a.aF(a.this.mAdInfo)) * 1000;
            if (j3 <= a.this.xk || jA - j3 <= jAF || a.this.ud) {
                return;
            }
            if (com.kwad.sdk.core.response.a.a.aG(a.this.mAdInfo) == 1) {
                if (aj.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.ar(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.qS.fN) {
                return;
            }
            a.b(a.this, true);
            a.this.wh.bind(a.this.qS.getActivity(), a.this.qS.mAdTemplate, a.this);
        }
    };

    static /* synthetic */ boolean b(a aVar, boolean z2) {
        aVar.ud = true;
        return true;
    }

    private void hP() {
        if (com.kwad.components.ad.reward.presenter.h.u(this.qS)) {
            bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.g.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.qS.mAdOpenInteractionListener != null) {
                        a.this.qS.mAdOpenInteractionListener.onRewardVerify();
                    }
                    a.this.qS.pw.pause();
                    a.this.qS.ga();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.d.b bVar = this.qS.mAdOpenInteractionListener;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.qS.pw.pause();
        this.qS.ga();
    }

    private f jt() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.g.a.5
            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.xi = false;
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onBind: ");
        if (this.wh == null) {
            this.wh = new d(this.qS, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.g.a.4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.xj == null) {
                        return;
                    }
                    u uVar = new u();
                    if (com.kwad.components.core.p.a.pJ().pP()) {
                        com.kwad.components.core.p.a.pJ().aH(false);
                        if (com.kwad.sdk.core.response.a.a.aG(a.this.mAdInfo) == 0 || com.kwad.components.core.p.a.pJ().pL()) {
                            uVar.Ve = 1;
                        } else {
                            uVar.Ve = 0;
                        }
                        a.this.xj.b(uVar);
                        return;
                    }
                    if (com.kwad.components.core.p.a.pJ().pN() && com.kwad.sdk.core.response.a.a.aG(a.this.mAdInfo) == 1) {
                        if (com.kwad.components.core.p.a.pJ().pO() == 1) {
                            if (aj.ah(a.this.getContext(), com.kwad.sdk.core.response.a.a.ar(a.this.mAdInfo))) {
                                return;
                            }
                            uVar.Ve = 0;
                            a.this.xj.b(uVar);
                            return;
                        }
                        if (com.kwad.components.core.p.a.pJ().pO() == 3) {
                            uVar.Ve = 1;
                            com.kwad.components.core.p.a.pJ().aE(0);
                            a.this.xj.b(uVar);
                        }
                    }
                }
            });
        }
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        this.xk = ((long) com.kwad.sdk.core.response.a.a.aE(this.mAdInfo)) * 1000;
        this.qS.pw.a(this.mVideoPlayStateListener, null);
        this.qS.a(this.uf);
        this.qS.Kg.add(this.sD);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.lC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "getTkTemplateId: ");
        return i.b("ksad-video-task-card", this.qS.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final e getTouchCoordsView() {
        return this.qS.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        int i2;
        this.qS.mAdOpenInteractionListener.bN();
        if (com.kwad.sdk.core.response.a.a.aH(this.mAdInfo)) {
            com.kwad.components.core.p.a.pJ().aD(aVar.apI);
            if (aVar.apI == -1) {
                i2 = 0;
                com.kwad.components.core.p.a.pJ().aH(false);
            } else {
                i2 = 1;
                if (!com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
                    com.kwad.components.core.p.a.pJ().aH(true);
                    return;
                } else if (com.kwad.components.core.p.a.pJ().pO() == 2) {
                    com.kwad.components.core.p.a.pJ().aE(3);
                    return;
                }
            }
            com.kwad.components.core.p.a.pJ().aE(i2);
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onCreate: ");
        this.lC = (FrameLayout) findViewById(R.id.ksad_js_task);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        aVar.width = (int) ((bc.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((bc.getScreenHeight(getContext()) / fAG) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterLifecycleLisener(ae aeVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        this.xj = jt();
        lVar.c(this.xj);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onSkipClick(s sVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.lC.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        com.kwad.sdk.core.d.b.d("TkRewardVideoTaskPresenter", "onTkLoadSuccess: ");
        if (ah.cu(getContext())) {
            this.lC.setVisibility(0);
            this.qS.pw.pause();
            this.ue = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(this.mVideoPlayStateListener, null);
        this.qS.b(this.uf);
        this.qS.Kg.remove(this.sD);
        this.wh.unBind();
        this.wh = null;
        this.lC.setVisibility(8);
        com.kwad.components.core.p.a.pJ().clear();
        this.ud = false;
        this.ue = false;
        this.xi = false;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onUpdateMuteStatus(k kVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        this.qS.pQ = webCloseStatus != null && webCloseStatus.interactSuccess;
        j jVar = this.qS;
        if (jVar.pQ) {
            jVar.pw.ka().jW();
            if (com.kwad.components.core.p.a.pJ().pK() == 1) {
                hP();
            }
        }
        if (this.ue && !this.xi) {
            this.qS.pw.resume();
        }
        this.lC.setVisibility(8);
    }
}
