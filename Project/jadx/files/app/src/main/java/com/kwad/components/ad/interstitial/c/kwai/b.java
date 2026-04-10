package com.kwad.components.ad.interstitial.c.kwai;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.c.i;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.r.k;
import com.kwad.components.core.webview.a.a;
import com.kwad.components.core.webview.a.a.j;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.a.w;
import com.kwad.components.core.webview.a.e;
import com.kwad.components.core.webview.a.kwai.n;
import com.kwad.components.core.webview.a.kwai.q;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.f.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bh;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    private static long jY = 400;
    private d ee;
    private Vibrator ef;
    private ae fB;

    @Nullable
    private com.kwad.components.ad.f.kwai.kwai.b kk;
    private FrameLayout lC;
    private boolean lE;
    private e lF;
    private boolean lD = false;
    private final c.a jw = new c.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.1
        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            if (b.this.lF != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UN = b.this.jq.jt ? 1 : 0;
                b.this.lF.b(aVar);
            }
        }
    };
    private i km = new i() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.10
        @Override // com.kwad.components.ad.interstitial.c.i
        public final void dA() {
            b.this.dj.aS();
        }

        @Override // com.kwad.components.ad.interstitial.c.i
        public final void dB() {
            b.this.dj.aT();
        }
    };
    private com.kwad.sdk.core.g.c dj = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.11
        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void aS() {
            if (b.this.fB != null && !b.this.lD) {
                b.a(b.this, true);
                b.this.fB.rr();
                b.this.fB.rs();
            }
            if (b.this.fB != null) {
                b.this.fB.rv();
            }
            if (b.this.kk != null) {
                b.this.kk.fe();
            }
            if (!b.this.lE) {
                b.this.jq.hR.getTimerHelper().startTiming();
            }
            if (b.this.lE || b.this.jq.jv || b.this.jq.hK == null) {
                return;
            }
            b.this.jq.hK.onAdShow();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(b.this.jq.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void aT() {
            if (b.this.fB != null) {
                b.this.fB.rw();
            }
            if (b.this.kk != null) {
                b.this.kk.fd();
            }
        }
    };

    @NonNull
    private g a(com.kwad.sdk.core.webview.b bVar) {
        return new g(bVar, this.jq.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.3
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!b.this.jq.jv && b.this.jq.hK != null) {
                        b.this.jq.hK.onAdClicked();
                    }
                    b.this.jq.jt = true;
                    if (!b.this.jq.jv) {
                        b.this.jq.cr();
                    }
                    if (b.this.jq.hR == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    b.this.jq.a(false, -1, b.this.jq.eM);
                    b.this.jq.hR.dismiss();
                }
            }
        });
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    static /* synthetic */ boolean a(b bVar, boolean z2) {
        bVar.lD = true;
        return true;
    }

    static /* synthetic */ boolean b(b bVar, boolean z2) {
        bVar.lE = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        if (getContext() != null) {
            this.ef = (Vibrator) getContext().getSystemService("vibrator");
        }
        float fBu = com.kwad.sdk.core.response.a.b.bu(this.jq.mAdTemplate);
        if (this.ee == null) {
            this.ee = new d(fBu);
            this.ee.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8
                @Override // com.kwad.sdk.core.f.b
                public final void a(double d2) {
                    if (com.kwad.sdk.b.kwai.a.m(b.this.getTKContainer(), 100)) {
                        b.this.d(d2);
                    }
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.ee.xP();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.f.b
                public final void bd() {
                }
            });
        }
        this.ee.e(fBu);
        this.ee.bi(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d2) {
        this.jq.a(new c.b(getContext()).l(true).c(d2).C(2).a(this.jq.jA.getTouchCoords()).D(157));
        if (this.ef == null || ak.al(getContext(), "android.permission.VIBRATE") != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.ef.vibrate(VibrationEffect.createOneShot(jY, -1));
        } else {
            this.ef.vibrate(jY);
        }
    }

    private com.kwad.components.core.webview.a.kwai.g dl() {
        j jVar = new j();
        jVar.UU = this.jq.jG;
        return new com.kwad.components.core.webview.a.kwai.g(jVar);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private com.kwad.components.ad.f.kwai.kwai.a m66do() {
        final com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.jq.jC.add(new c.InterfaceC0358c() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.2
            @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0358c
            public final void dg() {
                aVar.fb();
            }
        });
        return aVar;
    }

    private an du() {
        an anVar = new an(getContext(), this.jq.mAdTemplate);
        anVar.a(new an.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4
            @Override // com.kwad.components.core.webview.jshandler.an.a
            public final boolean dC() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jq.mAdTemplate);
                b.this.jq.a(true, -1, (com.kwad.sdk.core.video.videoview.a) null);
                bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.dx();
                    }
                }, 0L);
                return false;
            }
        });
        return anVar;
    }

    @NonNull
    private r dv() {
        return new r(new r.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6
            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(final r.a aVar) {
                if (b.this.jq.hR != null) {
                    b.this.jq.jA.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (aVar.type == 0 && !b.this.jq.jt && !b.this.jq.ju && com.kwad.components.ad.interstitial.d.a.c(b.this.jq)) {
                                b.this.jq.ju = true;
                                com.kwad.components.ad.interstitial.a.b.K(b.this.getContext());
                            } else {
                                b.this.er();
                                b.this.jq.a(aVar.type == 3, aVar.Ti, (com.kwad.sdk.core.video.videoview.a) null);
                                b.this.dx();
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        c cVar = this.jq;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.hR;
        if (dVar != null && a(dVar)) {
            this.jq.hR.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jq.hK;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
    }

    private com.kwad.components.core.webview.a.b en() {
        return new com.kwad.components.core.webview.a.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.16
            @Override // com.kwad.components.core.webview.a.b, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UP = com.kwad.components.ad.interstitial.b.a.cQ();
                cVar.a(cVar2);
            }
        };
    }

    private e eo() {
        return new e() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.17
            @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UN = b.this.jq.jt ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @NonNull
    private n ep() {
        return new n() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5
            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.a.a.d dVar = new com.kwad.components.core.webview.a.a.d();
                        dVar.UQ = af.isWifiConnected(b.this.getContext()) || b.this.jq.dY.isDataFlowAutoStart() || b.i(b.this.jq.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    private com.kwad.components.core.webview.jshandler.e eq() {
        return new com.kwad.components.core.webview.jshandler.e() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.7
            @Override // com.kwad.components.core.webview.jshandler.e
            public final void a(w wVar) {
                super.a(wVar);
                if (b.this.jq.jv || b.this.jq.hK == null) {
                    return;
                }
                b.this.jq.hK.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.e
            public final void b(w wVar) {
                super.b(wVar);
                if (b.this.jq.jv || b.this.jq.hK == null) {
                    return;
                }
                b.this.jq.hK.onVideoPlayEnd();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er() {
        ae aeVar = this.fB;
        if (aeVar != null) {
            aeVar.rt();
            this.fB.ru();
        }
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.kk;
        if (bVar != null) {
            bVar.fd();
        }
    }

    private x.a getOpenNewPageListener() {
        return new x.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.9
            @Override // com.kwad.components.core.webview.jshandler.x.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0405a().ar(bVar.title).as(bVar.url).ax(true).M(b.this.jq.mAdTemplate).ow());
            }
        };
    }

    public static boolean i(@NonNull AdTemplate adTemplate) {
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        return fileAN != null && fileAN.exists();
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq.a(this.km);
    }

    public final void b(AdTemplate adTemplate, boolean z2) {
        com.kwad.sdk.core.report.a.a(adTemplate, 14, -1L, -1, this.jq.hR.getTimerHelper().getTime(), null);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.lC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-interstitial-card", this.jq.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lC = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.lC.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        aVar.width = (int) ((bc.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((bc.getScreenHeight(getContext()) / fAG) + 0.5f);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.h
    public final void onRegisterLifecycleLisener(ae aeVar) {
        super.onRegisterLifecycleLisener(aeVar);
        this.fB = aeVar;
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        this.kk = com.kwad.components.ad.f.kwai.kwai.b.k(this.jq.mAdTemplate);
        com.kwad.components.ad.f.kwai.kwai.b bVar2 = this.kk;
        if (bVar2 != null) {
            bVar2.a(new b.InterfaceC0346b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.12
                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0346b
                public final void G(int i2) {
                    if (i2 == com.kwad.components.ad.f.kwai.kwai.b.nM) {
                        b.this.jq.b(b.this.getContext(), b.this.jq.mAdTemplate);
                        b bVar3 = b.this;
                        bVar3.b(bVar3.jq.mAdTemplate, true);
                    }
                    b.this.dx();
                }
            });
            lVar.c(this.kk);
            this.kk.fc();
        }
        lVar.c(dv());
        lVar.c(new x(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.cO(com.kwad.sdk.core.response.a.d.cb(this.jq.mAdTemplate))) {
            lVar.c(new ag(new ag.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.13
                @Override // com.kwad.components.core.webview.jshandler.ag.a
                public final void bJ() {
                    b.this.bB();
                }
            }));
        }
        lVar.c(ep());
        lVar.c(du());
        lVar.c(dl());
        lVar.c(a(bVar));
        lVar.c(eq());
        lVar.c(m66do());
        lVar.c(new q() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.14
            @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                k.f(b.this.getContext(), b.this.jq.mAdTemplate);
            }
        });
        this.lF = eo();
        this.jq.a(this.jw);
        lVar.c(this.lF);
        lVar.c(new com.kwad.components.core.webview.a.a(new a.InterfaceC0411a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.15
            @Override // com.kwad.components.core.webview.a.a.InterfaceC0411a
            public final void es() {
                com.kwad.components.ad.interstitial.b.a.L(b.this.getContext());
            }
        }));
        lVar.c(en());
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.h
    public final void onSkipClick(s sVar) {
        super.onSkipClick(sVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.jq.hK;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        this.lC.setVisibility(8);
        com.kwad.components.core.webview.a.d.b bVar = this.jq.jz;
        if (bVar != null) {
            bVar.u(getTkTemplateId());
        }
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        if (this.fB != null && this.jq.hI.et()) {
            this.lD = true;
            this.fB.rr();
            this.fB.rs();
        }
        this.jq.hI.a(this.dj);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.lD = false;
        this.lE = false;
        if (this.ef != null && ak.al(getContext(), "android.permission.VIBRATE") == 0) {
            this.ef.cancel();
        }
        d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        com.kwad.components.ad.interstitial.d.b bVar = this.jq.hI;
        if (bVar != null) {
            bVar.b(this.dj);
        }
        this.jq.b(this.jw);
        this.jq.b(this.km);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        b(this.jq.mAdTemplate, true);
        dx();
    }
}
