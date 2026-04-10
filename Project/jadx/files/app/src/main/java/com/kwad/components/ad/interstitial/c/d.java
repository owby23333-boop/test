package com.kwad.components.ad.interstitial.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.u;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {
    private static long jY = 400;
    private static float jZ = 0.8f;
    private static float ka = 1.0f;
    private static float kb = 0.749f;
    private com.kwad.components.core.widget.kwai.b bY;

    @NonNull
    private KsAdVideoPlayConfig dY;
    private ImageView eL;
    private com.kwad.sdk.core.video.videoview.a eM;
    private com.kwad.sdk.core.f.d ee;
    private Vibrator ef;
    private ae fB;
    private boolean fF;
    private ag jX;
    private c jq;
    private KSFrameLayout kc;
    private KSFrameLayout kd;
    private Dialog ke;

    @Nullable
    private KsAdWebView kf;
    private ImageView kg;
    private a.c kh;
    private p ki;
    private c.a kj;

    @Nullable
    private com.kwad.components.ad.f.kwai.kwai.b kk;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int cU = -1;
    private boolean kl = false;
    private i km = new i() { // from class: com.kwad.components.ad.interstitial.c.d.1
        @Override // com.kwad.components.ad.interstitial.c.i
        public final void dA() {
            d.this.dj.aS();
        }

        @Override // com.kwad.components.ad.interstitial.c.i
        public final void dB() {
            d.this.dj.aT();
        }
    };
    private com.kwad.sdk.core.g.c dj = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.d.12
        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void aS() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageVisible");
            if (d.this.fB != null) {
                d.this.fB.rr();
                d.this.fB.rs();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void aT() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageInvisible");
            if (d.this.fB != null) {
                d.this.fB.rt();
                d.this.fB.ru();
            }
        }
    };
    private final Runnable kn = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.20
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "rollBackRunnable run");
            d.this.w("4");
        }
    };
    private t.a ko = new t.a() { // from class: com.kwad.components.ad.interstitial.c.d.25
        @Override // com.kwad.components.core.webview.jshandler.t.a
        public final void onAdShow() {
            if (d.this.mAdTemplate.mPvReported || d.this.jq.jv || d.this.jq.hK == null) {
                return;
            }
            d.this.jq.hK.onAdShow();
            d.this.jq.hR.getTimerHelper().startTiming();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(d.this.mAdTemplate, 2);
        }
    };
    private z.b cY = new z.b() { // from class: com.kwad.components.ad.interstitial.c.d.18
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            if (d.this.fF || d.this.kl) {
                return;
            }
            d.this.cU = aVar.status;
            if (d.this.cU != 1) {
                d.this.w("3");
                return;
            }
            d.this.kf.setVisibility(0);
            com.kwad.components.core.m.a.pr().O(d.this.mAdTemplate);
            d.this.mHandler.removeCallbacksAndMessages(null);
            bh.b(d.this.kn);
            if (d.this.kk != null) {
                d.this.kk.fc();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams E(int i2) {
        int i3 = (int) (i2 * kb);
        return new ViewGroup.LayoutParams((int) (i3 / 0.749f), i3);
    }

    private static float a(boolean z2, boolean z3) {
        return (z2 && z3) ? 1.7777778f : 0.749f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i2, boolean z2) {
        int i3 = (int) (i2 * (z2 ? jZ : ka));
        return new ViewGroup.LayoutParams(i3, (int) (i3 * (z2 ? 1.7777778f : 0.749f)));
    }

    private static ViewGroup.MarginLayoutParams a(WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.topMargin = videoPosition.topMargin;
        marginLayoutParams.leftMargin = videoPosition.leftMargin;
        marginLayoutParams.width = videoPosition.width;
        marginLayoutParams.height = videoPosition.height;
        return marginLayoutParams;
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
        marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
        marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
        marginLayoutParams2.width = marginLayoutParams.width;
        marginLayoutParams2.height = marginLayoutParams.height;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(dz());
        aVar.a(dy());
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(dr());
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(dq());
        aVar.a(dp());
        aVar.a(dv());
        this.fB = new ae();
        aVar.a(this.fB);
        this.jq.a(ds());
        aVar.a(dw());
        aVar.a(dt());
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.mJsBridgeContext));
        aVar.a(dm());
        aVar.a(new z(this.cY, str));
        aVar.a(dk());
        t tVar = new t(this.mJsBridgeContext);
        tVar.a(this.ko);
        aVar.a(tVar);
        aVar.a(du());
        aVar.a(new x(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.cO(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            aVar.a(dj());
        }
        if (dn() != null) {
            aVar.a(this.kk);
        }
        aVar.a(dl());
        aVar.a(m65do());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z2) {
        kSFrameLayout.setWidthBasedRatio(!z2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + ", " + marginLayoutParams.height);
        a(videoPosition, marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
        float fAQ = com.kwad.sdk.core.response.a.a.aQ(adInfo);
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + fAQ);
        if (!z2 || fAQ <= 0.0f) {
            kSFrameLayout.setRatio(0.0f);
        } else {
            int i2 = marginLayoutParams.width;
            int i3 = (int) (marginLayoutParams.height / fAQ);
            marginLayoutParams.width = i3;
            marginLayoutParams.leftMargin += (i2 - i3) / 2;
            if (marginLayoutParams.width != 0) {
                float f2 = marginLayoutParams.height / marginLayoutParams.width;
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "cardParams ratio: " + f2);
                kSFrameLayout.setRatio(f2);
            }
        }
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
        kSFrameLayout.setLayoutParams(marginLayoutParams);
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel = videoPosition.cornerRadius;
        if (kSAdJSCornerModel != null) {
            kSFrameLayout.setRadius((float) kSAdJSCornerModel.topLeft, (float) kSAdJSCornerModel.topRight, (float) kSAdJSCornerModel.bottomRight, (float) kSAdJSCornerModel.bottomLeft);
        } else if (marginLayoutParams.width > marginLayoutParams.height) {
            kSFrameLayout.setRadius(dimension, dimension, 0.0f, 0.0f);
        } else {
            kSFrameLayout.setRadius(dimension, dimension, dimension, dimension);
        }
        if (z2) {
            this.kg.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.kg.getLayoutParams();
            a(marginLayoutParams2, marginLayoutParams3);
            this.kg.setLayoutParams(marginLayoutParams3);
            this.jq.a(this.mContext, adInfo, this.mAdTemplate, this.kg);
        } else {
            this.kg.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            kSFrameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.kwad.components.ad.interstitial.c.d.17
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View view, Outline outline) {
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                }
            });
            kSFrameLayout.setClipToOutline(true);
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z2) {
        dVar.kl = true;
        return true;
    }

    private void aF() {
        String strBx = com.kwad.sdk.core.response.a.b.bx(this.mAdTemplate);
        if (TextUtils.isEmpty(strBx) || this.kf == null) {
            w("1");
        } else {
            v(strBx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        float fBu = com.kwad.sdk.core.response.a.b.bu(this.mAdTemplate);
        if (this.ee == null) {
            this.ee = new com.kwad.sdk.core.f.d(fBu);
            this.ee.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.c.d.19
                @Override // com.kwad.sdk.core.f.b
                public final void a(double d2) {
                    if (com.kwad.sdk.b.kwai.a.m(d.this.kc, 100)) {
                        d.this.d(d2);
                    }
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.19.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                            d.this.ee.xP();
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

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d2) {
        this.jq.a(new c.b(getContext()).l(true).c(d2).C(2).a(this.kc.getTouchCoords()).D(157));
        bh.a(getContext(), this.ef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        final boolean zAP = com.kwad.sdk.core.response.a.a.aP(this.mAdInfo);
        final boolean zCu = ah.cu(this.mContext);
        float fA = a(zCu, zAP);
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + fA);
        this.jq.jr.setRatio(fA);
        final ViewGroup viewGroup = (ViewGroup) this.kc.findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.24
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams layoutParamsA = zCu ? d.a(d.this.kc.getWidth(), zAP) : d.E(d.this.kc.getHeight());
                if (d.this.kf != null) {
                    d.this.kf.setVisibility(8);
                }
                d.this.kd.setVisibility(8);
                ViewParent parent = d.this.jq.jr.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.jq.jr);
                }
                viewGroup.addView(d.this.jq.jr);
                d.this.jq.jr.f(layoutParamsA.width, layoutParamsA.height);
                d.this.eM.requestLayout();
                d.a(d.this, true);
            }
        });
    }

    @NonNull
    private ag dj() {
        this.jX = new ag(new ag.a() { // from class: com.kwad.components.ad.interstitial.c.d.26
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void bJ() {
                d.this.bB();
            }
        });
        return this.jX;
    }

    private com.kwad.components.core.webview.jshandler.ah dk() {
        return new com.kwad.components.core.webview.jshandler.ah(this.mJsBridgeContext, this.mApkDownloadHelper);
    }

    private com.kwad.components.core.webview.a.kwai.g dl() {
        com.kwad.components.core.webview.a.a.j jVar = new com.kwad.components.core.webview.a.a.j();
        jVar.UU = this.jq.jG;
        return new com.kwad.components.core.webview.a.kwai.g(jVar);
    }

    private com.kwad.components.core.webview.jshandler.l dm() {
        com.kwad.components.core.webview.jshandler.l lVar = new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext);
        lVar.a(new l.b() { // from class: com.kwad.components.ad.interstitial.c.d.2
            @Override // com.kwad.components.core.webview.jshandler.l.b
            public final void a(l.a aVar) {
                aVar.height = com.kwad.sdk.b.kwai.a.getScreenHeight(d.this.mContext);
                aVar.width = com.kwad.sdk.b.kwai.a.getScreenHeight(d.this.mContext);
            }
        });
        return lVar;
    }

    private com.kwad.components.ad.f.kwai.kwai.b dn() {
        this.kk = com.kwad.components.ad.f.kwai.kwai.b.k(this.mAdTemplate);
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.kk;
        if (bVar != null) {
            bVar.a(new b.InterfaceC0346b() { // from class: com.kwad.components.ad.interstitial.c.d.3
                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0346b
                public final void G(int i2) {
                    if (i2 == com.kwad.components.ad.f.kwai.kwai.b.nM) {
                        d.this.jq.b(d.this.getContext(), d.this.mAdTemplate);
                        d.this.jq.a(true, -1, d.this.jq.eM);
                    }
                    d.this.dx();
                }
            });
        }
        return this.kk;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private com.kwad.components.ad.f.kwai.kwai.a m65do() {
        final com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.jq.jC.add(new c.InterfaceC0358c() { // from class: com.kwad.components.ad.interstitial.c.d.4
            @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0358c
            public final void dg() {
                aVar.fb();
            }
        });
        return aVar;
    }

    private u dp() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.interstitial.c.d.5
            @Override // com.kwad.components.core.webview.a.kwai.u.a
            public final void a(com.kwad.components.core.webview.a.a.k kVar) {
                d.this.eM.setVideoSoundEnable(!kVar.UW);
            }
        });
        return uVar;
    }

    @NonNull
    private o dq() {
        return new o() { // from class: com.kwad.components.ad.interstitial.c.d.6
            @Override // com.kwad.components.core.webview.a.kwai.o, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.k kVar = new com.kwad.components.core.webview.a.a.k();
                kVar.UW = !d.this.dY.isVideoSoundEnable();
                cVar.a(kVar);
            }
        };
    }

    @NonNull
    private s dr() {
        return new s(this.mJsBridgeContext, new s.b() { // from class: com.kwad.components.ad.interstitial.c.d.7
            @Override // com.kwad.components.core.webview.jshandler.s.b
            public final void a(s.a aVar) {
            }
        });
    }

    private a.c ds() {
        final com.kwad.components.core.webview.a.a.x xVar = new com.kwad.components.core.webview.a.a.x();
        this.kh = new a.c() { // from class: com.kwad.components.ad.interstitial.c.d.8
            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.components.core.webview.a.a.x xVar2 = xVar;
                xVar2.Vh = false;
                xVar2.Vd = true;
                xVar.nW = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.mJsBridgeContext.getAdTemplate()));
                d.this.ki.a(xVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                com.kwad.components.core.webview.a.a.x xVar2 = xVar;
                xVar2.Vh = false;
                xVar2.Vd = false;
                xVar2.nW = (int) Math.ceil(j2 / 1000.0f);
                d.this.ki.a(xVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.webview.a.a.x xVar2 = xVar;
                xVar2.Vh = false;
                xVar2.Vd = false;
                xVar2.nW = 0;
                d.this.ki.a(xVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (d.this.eL.getVisibility() == 0) {
                    d.this.eL.setVisibility(8);
                }
                com.kwad.components.core.webview.a.a.x xVar2 = xVar;
                xVar2.Vh = false;
                xVar2.Vd = false;
                xVar2.nW = (int) Math.ceil(d.this.eM.getCurrentPosition() / 1000.0f);
                d.this.ki.a(xVar);
            }
        };
        return this.kh;
    }

    @NonNull
    private WebCardVideoPositionHandler dt() {
        return new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.interstitial.c.d.9
            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + d.this.kl);
                if (d.this.kl || (adInfo = d.this.mAdInfo) == null || !com.kwad.sdk.core.response.a.a.aV(adInfo)) {
                    return;
                }
                c unused = d.this.jq;
                d dVar = d.this;
                boolean zA = c.a(dVar.mContext, dVar.mAdInfo);
                d dVar2 = d.this;
                dVar2.a(dVar2.mAdInfo, videoPosition, dVar2.kd, zA);
                d.this.kd.setVisibility(0);
                d.this.kf.setVisibility(0);
            }
        });
    }

    private an du() {
        an anVar = new an(getContext(), this.mAdTemplate);
        anVar.a(new an.a() { // from class: com.kwad.components.ad.interstitial.c.d.10
            @Override // com.kwad.components.core.webview.jshandler.an.a
            public final boolean dC() {
                if (d.this.ki != null) {
                    d.this.ki.aM(false);
                }
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.10.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.dx();
                    }
                });
                boolean z2 = !d.this.jq.jE;
                if (z2) {
                    d.this.jq.a(true, -1, d.this.jq.eM);
                }
                return z2;
            }
        });
        return anVar;
    }

    @NonNull
    private r dv() {
        return new r(new r.b() { // from class: com.kwad.components.ad.interstitial.c.d.13
            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(final r.a aVar) {
                if (d.this.ke != null) {
                    d.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.13.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (d.this.jq.jv || aVar.type != 0 || d.this.jq.jt || d.this.jq.ju || !com.kwad.components.ad.interstitial.d.a.c(d.this.jq)) {
                                d.this.jq.a(aVar.type == 3, -1, d.this.eM);
                                d.this.dx();
                            } else {
                                d.this.jq.ju = true;
                                com.kwad.components.ad.interstitial.a.b.K(d.this.mContext);
                            }
                        }
                    });
                }
            }
        });
    }

    private p dw() {
        p pVar = new p() { // from class: com.kwad.components.ad.interstitial.c.d.14
            @Override // com.kwad.components.core.webview.a.kwai.p, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                if (d.this.eM.isIdle()) {
                    com.kwad.components.core.webview.a.a.x xVar = new com.kwad.components.core.webview.a.a.x();
                    xVar.Vh = false;
                    xVar.Vd = false;
                    xVar.nW = 0;
                    cVar.a(xVar);
                }
                if (d.this.eM.isCompleted()) {
                    com.kwad.components.core.webview.a.a.x xVar2 = new com.kwad.components.core.webview.a.a.x();
                    xVar2.Vh = false;
                    xVar2.Vd = true;
                    xVar2.nW = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.mJsBridgeContext.getAdTemplate()));
                    cVar.a(xVar2);
                }
            }
        };
        this.ki = pVar;
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        Activity ownerActivity;
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Dialog dialog = this.ke;
        if (dialog == null || (ownerActivity = dialog.getOwnerActivity()) == null || ownerActivity.isFinishing()) {
            return;
        }
        this.ke.dismiss();
        c cVar = this.jq;
        if (!cVar.jv && (adInteractionListener = cVar.hK) != null) {
            adInteractionListener.onAdClosed();
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.jq.eM;
        if (aVar != null) {
            aVar.release();
        }
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.g dy() {
        return new com.kwad.components.core.webview.jshandler.g(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.d.15
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.jq.jv && d.this.jq.hK != null) {
                        d.this.jq.hK.onAdClicked();
                    }
                    d.this.jq.jt = true;
                    if (!d.this.jq.jv) {
                        d.this.jq.cr();
                    }
                    if (d.this.jq.hR == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    d.this.jq.a(false, -1, d.this.jq.eM);
                    d.this.jq.hR.dismiss();
                }
            }
        });
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.j dz() {
        return new com.kwad.components.core.webview.jshandler.j(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.d.16
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.jq.jv && d.this.jq.hK != null) {
                        d.this.jq.hK.onAdClicked();
                    }
                    d.this.jq.jt = true;
                    if (!d.this.jq.jv) {
                        d.this.jq.cr();
                    }
                    if (d.this.jq.hR == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    d.this.jq.a(false, -1, d.this.jq.eM);
                    d.this.jq.hR.dismiss();
                }
            }
        });
    }

    private x.a getOpenNewPageListener() {
        return new x.a() { // from class: com.kwad.components.ad.interstitial.c.d.11
            @Override // com.kwad.components.core.webview.jshandler.x.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(d.this.mContext, new AdWebViewActivityProxy.a.C0405a().ar(bVar.title).as(bVar.url).ax(true).M(d.this.mAdTemplate).ow());
            }
        };
    }

    @NonNull
    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.interstitial.c.d.22
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                d.this.w("1");
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.jq.mAdTemplate);
        int i2 = !ah.cu(this.mContext) ? 1 : 0;
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = i2;
        KSFrameLayout kSFrameLayout = this.kc;
        bVar.aoM = kSFrameLayout;
        bVar.LI = kSFrameLayout;
        bVar.Lk = this.kf;
        bVar.mReportExtData = null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v(String str) {
        clearJsInterfaceRegister();
        this.kj = this.kf.getClientConfig().cr(this.mAdTemplate).b(getWebListener());
        this.kf.setClientConfig(this.kj);
        this.mJsInterface = new com.kwad.components.core.webview.a(this.kf);
        a(this.mJsInterface, str);
        this.kf.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.kf.setBackgroundColor(0);
        this.kf.setVisibility(4);
        this.kf.loadUrl(str);
        bh.a(this.kn, null, com.anythink.expressad.video.module.a.a.m.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "handleWebViewError " + str);
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fF) {
            return;
        }
        this.fF = true;
        com.kwad.components.core.m.a aVarPr = com.kwad.components.core.m.a.pr();
        AdTemplate adTemplate = this.mAdTemplate;
        aVarPr.b(adTemplate, com.kwad.sdk.core.response.a.b.bx(adTemplate), str);
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.23
            @Override // java.lang.Runnable
            public final void run() {
                d.this.di();
                d.this.jq.cV();
            }
        });
        c.a aVar = this.kj;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq = (c) Bs();
        this.kl = false;
        c cVar = this.jq;
        this.ke = cVar.hR;
        this.dY = cVar.dY;
        this.mApkDownloadHelper = cVar.mApkDownloadHelper;
        this.mAdTemplate = cVar.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.eM = this.jq.eM;
        this.bY.rU();
        this.bY.a(this.dj);
        this.jq.a(this.km);
        if (com.kwad.sdk.core.response.a.b.bv(this.mAdTemplate)) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.21
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.di();
                    d.this.jq.cV();
                }
            });
        } else {
            inflateJsBridgeContext();
            aF();
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cT() {
        super.cT();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.kk;
        if (bVar != null) {
            bVar.fe();
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cU() {
        super.cU();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.kk;
        if (bVar != null) {
            bVar.fd();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kf = (KsAdWebView) getRootView().findViewById(R.id.ksad_web_card_webView);
        this.bY = new com.kwad.components.core.widget.kwai.b(getRootView(), 100);
        this.kc = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kd = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eL = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.kg = (ImageView) getRootView().findViewById(R.id.ksad_interstitial_video_blur);
        this.mContext = getContext();
        Context context = this.mContext;
        if (context != null) {
            this.ef = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.bY.b(this.dj);
        this.bY.rV();
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        c.a aVar = this.kj;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
        this.jq.b(this.km);
    }
}
