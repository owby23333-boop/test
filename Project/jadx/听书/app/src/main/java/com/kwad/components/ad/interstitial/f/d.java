package com.kwad.components.ad.interstitial.f;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    public static float mP = 1.3333334f;
    private static float mQ = 0.749f;
    private static float mR = 0.8f;
    private static float mS = 1.0f;
    private com.kwad.sdk.core.video.videoview.a cq;
    private com.kwad.components.core.widget.a.b fg;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean mN;
    private KSFrameLayout mO;
    private c.b mT;
    private com.kwad.sdk.core.j.d mU = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.d.5
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bt() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.mj.mn && d.this.mj.kQ != null) {
                d.this.mj.kQ.onAdShow();
                d.this.mj.kW.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.eS().a(d.this.mj.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b bVarDp = new com.kwad.sdk.core.adlog.c.b().dp(d.this.mj.mx);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.eS().D(d.this.mAdTemplate);
            }
            com.kwad.components.core.t.b.sY().a(d.this.mAdTemplate, null, bVarDp);
            d.this.mg.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bu() {
            d.this.mg.setCountDownPaused(true);
        }
    };
    private KsAutoCloseView mg;
    private c mj;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.mg = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.f.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void eg() {
                d.this.o(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void eh() {
                d.this.o(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mj.b(this.mT);
        com.kwad.components.core.widget.a.b bVar = this.fg;
        if (bVar != null) {
            bVar.b(this.mU);
            this.fg.wj();
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        this.mj = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.eS().C(this.mj.mAdTemplate);
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.mj.mAdTemplate);
        this.mAdInfo = adInfoEl;
        if (com.kwad.sdk.core.response.b.a.aX(adInfoEl).width > 0) {
            mP = r0.height / r0.width;
        }
        this.mj.fV.setBackgroundColor(Color.parseColor("#99000000"));
        this.mj.mk.setVisibility(0);
        this.mj.mk.H(this.mAdTemplate);
        this.mj.a(ed());
        ee();
        this.mj.mk.setViewListener(new com.kwad.components.ad.interstitial.h.e() { // from class: com.kwad.components.ad.interstitial.f.d.2
            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ei() {
                d.this.e(3, d.this.mj.mk.fj() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void p(boolean z) {
                if (d.this.cq != null) {
                    d.this.cq.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eh() {
                d.this.o(false);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ej() {
                d.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ek() {
                d.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void el() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void em() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void en() {
                d.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void q(boolean z) {
                d.this.mN = z;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.mO = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eo() {
                d.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ep() {
                d.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eq() {
                d.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void er() {
                d.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void es() {
                d.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void et() {
                d.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eu() {
                d.this.e(2, 35);
            }
        });
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this.mj.mk, 100);
        this.fg = bVar;
        bVar.a(this.mU);
        this.fg.wi();
        final boolean zAW = com.kwad.sdk.core.response.b.a.aW(this.mAdInfo);
        getContext();
        final boolean zQW = aq.QW();
        this.mj.mk.setRatio(b(zQW, zAW));
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.d.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ViewGroup.LayoutParams layoutParamsA = zQW ? d.a(d.this.getRootView().getWidth(), zAW) : d.N(d.this.getRootView().getHeight());
                ViewParent parent = d.this.mj.mk.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.mj.mk);
                }
                viewGroup.addView(d.this.mj.mk);
                d.this.mj.mk.f(layoutParamsA.width, layoutParamsA.height);
                viewGroup.requestLayout();
                viewGroup.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.d.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (d.this.cq != null) {
                            d.this.cq.requestLayout();
                        }
                    }
                });
            }
        });
    }

    private c.b ed() {
        c.b bVar = new c.b() { // from class: com.kwad.components.ad.interstitial.f.d.4
            @Override // com.kwad.components.ad.interstitial.f.c.b
            public final void c(long j, long j2) {
                com.kwad.components.ad.interstitial.report.a.eO().b(d.this.mAdTemplate, j, j2);
            }
        };
        this.mT = bVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i, boolean z) {
        float f;
        if (z) {
            f = mR;
        } else {
            f = mS;
        }
        int i2 = (int) (i * f);
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? mP : 0.749f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams N(int i) {
        int i2 = (int) (i * mQ);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, int i2) {
        if (this.mj.a(new c.C0284c(getContext()).l(this.mN).a(this.mO.getTouchCoords()).L(i).M(i2)) && com.kwad.components.ad.interstitial.d.b.t(this.mAdTemplate) && this.mj.kW != null) {
            c cVar = this.mj;
            cVar.a(false, -1, cVar.cq);
            this.mj.kW.dismiss();
            this.mj.Y();
        }
    }

    private void ee() {
        final com.kwad.components.ad.interstitial.h.d dVar = this.mj.mk;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.c(true, true);
            dVar.u(false);
        } else {
            dVar.u(true);
            String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
            if (!TextUtils.isEmpty(url)) {
                dVar.c(url, this.mAdTemplate);
                dVar.c(true, false);
            } else {
                dVar.c(false, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.mj.cq;
            this.cq = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.cq.getParent()).removeView(this.cq);
            }
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).height / com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).width, this.cq);
            }
            dVar.v(this.mj.bU.isVideoSoundEnable());
            final int iL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
            this.mj.a(new a.c() { // from class: com.kwad.components.ad.interstitial.f.d.6
                @Override // com.kwad.components.core.video.a.c
                public final void d(long j) {
                    int i = iL - ((int) (j / 1000));
                    if (i >= 0) {
                        dVar.A(String.valueOf(i));
                    } else {
                        dVar.ff();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.u(true);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void aq() {
                    dVar.c(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void ar() {
                    d.this.cq.setVisibility(8);
                    if (d.this.mj.M(d.this.getContext())) {
                        return;
                    }
                    dVar.fh();
                }
            });
            dVar.a(this.mAdTemplate, this.mAdInfo);
            dVar.u(true);
            this.mj.f1897ms.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.d.7
                @Override // com.kwad.components.ad.interstitial.f.c.d
                public final void eb() {
                    dVar.fi();
                    d.this.cq.setVisibility(0);
                }
            });
        }
        this.mj.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar.getBlurBgView());
        String strO = com.kwad.sdk.core.response.b.a.O(this.mAdInfo);
        if (TextUtils.isEmpty(strO)) {
            strO = com.kwad.sdk.core.response.b.a.X(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar.getTailFrameView(), strO, this.mAdTemplate);
        if (c(this.mAdInfo)) {
            this.mg.bb(true);
            ef();
        } else {
            this.mg.bb(false);
        }
    }

    private static float b(boolean z, boolean z2) {
        if (z && z2) {
            return mP;
        }
        return 0.749f;
    }

    private void ef() {
        int iMin = this.mAdInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            iMin = Math.min(iMin, com.kwad.sdk.core.response.b.a.L(this.mAdInfo));
            this.mj.mk.ff();
            this.mj.mk.fg();
        }
        this.mg.ai(iMin);
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, (JSONObject) null);
    }

    private static boolean c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.b.a.bK(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z) {
        if (!this.mj.mn && !z && !this.mj.ml && !this.mj.mm && com.kwad.components.ad.interstitial.g.a.d(this.mj)) {
            this.mj.mm = true;
            com.kwad.components.ad.interstitial.c.b.K(getContext());
            return;
        }
        this.mj.a(z, -1, this.cq);
        this.mj.kW.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            aVar.release();
        }
        this.mj.Y();
    }
}
