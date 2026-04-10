package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.j.c {
    private com.kwad.components.ad.splashscreen.e.b HH;
    private boolean HI;
    private long HK;
    private az HL;
    private ViewGroup HN;
    private KsAdWebView eN;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean HJ = false;
    private boolean HM = false;
    private final Runnable HO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.1
        @Override // java.lang.Runnable
        public final void run() {
            s.a(s.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cu(s.this.mAdTemplate), SystemClock.elapsedRealtime() - s.this.HK, 1, "");
            s.this.mA();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    static /* synthetic */ boolean a(s sVar, boolean z) {
        sVar.HM = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.Gf.Fs.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.HN = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.eN = new KsAdWebView(getContext());
            this.eN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.HN.addView(this.eN);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.Gf.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.HI = false;
        this.HJ = false;
        String strCu = com.kwad.sdk.core.response.b.b.cu(this.mAdTemplate);
        if (this.eN != null && !TextUtils.isEmpty(strCu) && !this.Gf.Fx) {
            this.HK = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ar(this.mAdTemplate);
            a(this.eN, strCu);
            bw.a(this.HO, null, com.kwad.sdk.core.response.b.b.eb(this.mAdInfo));
        } else {
            mA();
        }
        this.Gf.a(this);
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.eQ.mScreenOrientation = 0;
        this.eQ.aMN = this.Gf.mRootContainer;
        this.eQ.TG = this.Gf.mRootContainer;
        this.eQ.Ta = this.eN;
        this.eQ.mReportExtData = null;
        this.eQ.aMP = false;
        this.eQ.aMQ = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        bc();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().eJ(this.Gf.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.presenter.s.3
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                bw.c(s.this.HO);
                s.this.mA();
                com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.HK, 2, str2);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.HK);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            mA();
        }
    }

    private void a(WebView webView, String str) {
        bf();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.eP = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.eP, "KwaiAd");
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new bc(this.eQ, this.Gf.mApkDownloadHelper));
        aVar.a(mD());
        aVar.a(mC());
        aVar.a(new af(this.eQ));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new as(new as.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.4
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bw.c(s.this.HO);
                if (aVar2.status == 1) {
                    s.this.Gf.FI = SystemClock.elapsedRealtime() - s.this.mStartTime;
                    if (!s.this.HM) {
                        if (s.this.HL != null) {
                            s.this.HL.uF();
                            s.this.HL.uG();
                        }
                    } else {
                        s.this.Gf.isWebTimeout = true;
                    }
                    if (com.kwad.sdk.core.response.b.b.dZ(s.this.mAdInfo)) {
                        s.this.mz();
                        return;
                    }
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.HK, 3, "");
                s.this.mA();
            }
        }, str));
        aVar.a(new bb(new bb.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.5
            @Override // com.kwad.components.core.webview.jshandler.bb.a
            public final void cL() {
                s.this.cF();
            }
        }));
        aVar.a(new am(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.eQ));
        az azVar = new az();
        this.HL = azVar;
        aVar.a(azVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF() {
        if (this.gX != null || this.HJ) {
            return;
        }
        com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.dj(this.Gf.mAdTemplate));
        this.gX = dVar;
        dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.6
            @Override // com.kwad.sdk.core.g.b
            public final void cd() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                boolean zOW = com.kwad.components.core.e.c.b.oW();
                if (!s.this.Gf.Fs.wl() || zOW) {
                    return;
                }
                s.this.h(d);
                if (s.this.gZ == null) {
                    s sVar = s.this;
                    sVar.gZ = sVar.F(sVar.getContext());
                }
                bw.a(s.this.getContext(), s.this.gZ);
                s.this.gX.bH(s.this.getContext());
            }
        });
        this.gX.bG(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d) {
        if (this.Gf != null) {
            this.Gf.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.7
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d);
                }
            });
        }
    }

    public final void mz() {
        if (this.HI) {
            return;
        }
        this.HI = true;
        a.C0392a c0392a = new a.C0392a();
        c0392a.awX = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.Gf.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().df(123).b(c0392a));
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(123);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA() {
        this.HJ = true;
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.HN;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final Presenter presenterY = y(this.mAdInfo);
        if (presenterY != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.8
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.a(presenterY, true);
                }
            });
        } else {
            mB();
        }
    }

    private Presenter y(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.dn(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            if (com.kwad.sdk.core.response.b.b.dR(adInfo)) {
                return new m();
            }
            return null;
        }
        if (com.kwad.sdk.core.response.b.b.dP(this.mAdInfo)) {
            return new o();
        }
        if (com.kwad.sdk.core.response.b.b.dR(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.b.b.dU(this.mAdInfo)) {
            return new q();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dV(this.mAdInfo)) {
            return new l();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dW(this.mAdInfo)) {
            return new n();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dX(this.mAdInfo)) {
            return new p();
        }
        return null;
    }

    private void mB() {
        mz();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate), this.Gf.mApkDownloadHelper);
        this.HH = bVar;
        bVar.as(this.mAdTemplate);
        this.HH.a(this);
        this.HH.mA();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bG(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    private z mC() {
        return new z(this.eQ, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.c.a.a.DE()) {
                    return;
                }
                if (aVar.KY() || com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.adN, aVar.mI, aVar.adO.Pj);
                }
            }
        });
    }

    private ac mD() {
        return new ac(this.eQ, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar.adL || !com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.adL ? 1 : 3, aVar.mI, "");
                }
            }
        }, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9, int r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            com.kwad.components.ad.splashscreen.h r0 = r8.Gf
            r0.X()
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r10 != r1) goto L10
            r3 = r1
            goto L11
        L10:
            r3 = r2
        L11:
            if (r0 != 0) goto L51
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r8.Gf     // Catch: org.json.JSONException -> L4b
            if (r5 == 0) goto L51
            com.kwad.components.ad.splashscreen.h r5 = r8.Gf     // Catch: org.json.JSONException -> L4b
            com.kwad.components.ad.splashscreen.d.a r5 = r5.Fq     // Catch: org.json.JSONException -> L4b
            if (r5 == 0) goto L2f
            java.lang.String r5 = "duration"
            com.kwad.components.ad.splashscreen.h r6 = r8.Gf     // Catch: org.json.JSONException -> L4b
            com.kwad.components.ad.splashscreen.d.a r6 = r6.Fq     // Catch: org.json.JSONException -> L4b
            long r6 = r6.getCurrentPosition()     // Catch: org.json.JSONException -> L4b
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L4b
        L2f:
            if (r9 == 0) goto L34
            r2 = 153(0x99, float:2.14E-43)
            goto L38
        L34:
            if (r3 == 0) goto L38
            r2 = 132(0x84, float:1.85E-43)
        L38:
            com.kwad.sdk.core.adlog.c.b r9 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L49
            r9.<init>()     // Catch: org.json.JSONException -> L49
            com.kwad.sdk.core.adlog.c.b r9 = r9.dd(r2)     // Catch: org.json.JSONException -> L49
            com.kwad.components.ad.splashscreen.h r5 = r8.Gf     // Catch: org.json.JSONException -> L49
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate     // Catch: org.json.JSONException -> L49
            com.kwad.sdk.core.adlog.c.a(r5, r9, r4)     // Catch: org.json.JSONException -> L49
            goto L52
        L49:
            r9 = move-exception
            goto L4d
        L4b:
            r9 = move-exception
            r2 = r11
        L4d:
            com.kwad.sdk.core.d.c.printStackTrace(r9)
            goto L52
        L51:
            r2 = r11
        L52:
            com.kwad.components.core.e.d.a$a r9 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r4 = r8.Gf
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r9.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r8.Gf
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.e.d.a$a r9 = r9.aB(r4)
            com.kwad.components.ad.splashscreen.h r4 = r8.Gf
            com.kwad.components.core.e.d.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r9 = r9.b(r4)
            com.kwad.components.core.e.d.a$a r9 = r9.aq(r3)
            com.kwad.components.core.e.d.a$a r9 = r9.aB(r10)
            if (r0 == 0) goto L7a
            goto L7b
        L7a:
            r11 = r2
        L7b:
            com.kwad.components.core.e.d.a$a r9 = r9.aA(r11)
            com.kwad.components.core.e.d.a$a r9 = r9.am(r12)
            com.kwad.components.core.e.d.a$a r9 = r9.az(r1)
            com.kwad.components.core.e.d.a$a r9 = r9.as(r0)
            com.kwad.components.ad.splashscreen.presenter.s$2 r10 = new com.kwad.components.ad.splashscreen.presenter.s$2
            r10.<init>()
            com.kwad.components.core.e.d.a$a r9 = r9.a(r10)
            com.kwad.components.core.e.d.a.a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.presenter.s.a(boolean, int, int, java.lang.String):void");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.HH;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
        az azVar = this.HL;
        if (azVar != null) {
            azVar.uH();
            this.HL.uI();
        }
        if (this.Gf != null && this.Gf.Fs != null) {
            this.Gf.Fs.b(this);
        }
        bf();
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z, boolean z2) {
        com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, null);
    }
}
