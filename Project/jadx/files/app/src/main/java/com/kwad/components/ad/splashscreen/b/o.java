package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g {
    private com.kwad.components.ad.splashscreen.e.b Ds;
    private boolean Dt;
    private long Dv;
    private ae Dw;

    @Nullable
    private KsAdWebView cS;
    private com.kwad.sdk.core.f.d ee;
    private Vibrator ef;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private boolean Du = false;
    private boolean Dx = false;
    private final Runnable Dy = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.1
        @Override // java.lang.Runnable
        public final void run() {
            o.a(o.this, true);
            com.kwad.components.ad.splashscreen.monitor.a.a(com.kwad.sdk.core.response.a.b.aO(o.this.mAdTemplate), SystemClock.elapsedRealtime() - o.this.Dv, 1, "");
            o.this.lD();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        clearJsInterfaceRegister();
        webView.getSettings().setAllowFileAccess(true);
        this.mJsInterface = new com.kwad.components.core.webview.a(webView);
        a(this.mJsInterface, str);
        webView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new ah(this.mJsBridgeContext, this.Cx.mApkDownloadHelper));
        aVar.a(dz());
        aVar.a(dy());
        aVar.a(new com.kwad.components.core.webview.jshandler.m(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new z(new z.b() { // from class: com.kwad.components.ad.splashscreen.b.o.7
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar2) {
                com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bh.b(o.this.Dy);
                if (aVar2.status != 1) {
                    com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dv, 3, "");
                    o.this.lD();
                    return;
                }
                if (!o.this.Dx && o.this.Dw != null) {
                    o.this.Dw.rr();
                    o.this.Dw.rs();
                }
                if (com.kwad.sdk.core.response.a.b.db(o.this.mAdInfo)) {
                    o.this.lC();
                }
            }
        }, str));
        aVar.a(new ag(new ag.a() { // from class: com.kwad.components.ad.splashscreen.b.o.8
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void bJ() {
                o.this.bB();
            }
        }));
        aVar.a(new t(this.mJsBridgeContext));
        this.Dw = new ae();
        aVar.a(this.Dw);
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.getBackground().setAlpha(0);
        ksAdWebView.setVisibility(0);
        inflateJsBridgeContext();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().cr(this.Cx.mAdTemplate).b(new com.kwad.components.a() { // from class: com.kwad.components.ad.splashscreen.b.o.6
            @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.a.d(str, SystemClock.elapsedRealtime() - o.this.Dv);
            }

            @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str2, String str3) {
                super.onReceivedHttpError(i2, str2, str3);
                bh.b(o.this.Dy);
                o.this.lD();
                com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dv, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.a.Y(str);
        ksAdWebView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9, int r10, @androidx.annotation.Nullable com.kwad.sdk.core.report.y.b r11, int r12) {
        /*
            r8 = this;
            com.kwad.components.ad.splashscreen.h r0 = r8.Cx
            r0.kM()
            r0 = 0
            r1 = 1
            if (r11 == 0) goto Lb
            r2 = 1
            goto Lc
        Lb:
            r2 = 0
        Lc:
            if (r10 != r1) goto L10
            r3 = 1
            goto L11
        L10:
            r3 = 0
        L11:
            if (r2 != 0) goto L49
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r8.Cx     // Catch: org.json.JSONException -> L43
            if (r5 == 0) goto L49
            com.kwad.components.ad.splashscreen.h r5 = r8.Cx     // Catch: org.json.JSONException -> L43
            com.kwad.components.ad.splashscreen.d.a r5 = r5.BY     // Catch: org.json.JSONException -> L43
            if (r5 == 0) goto L2f
            java.lang.String r5 = "duration"
            com.kwad.components.ad.splashscreen.h r6 = r8.Cx     // Catch: org.json.JSONException -> L43
            com.kwad.components.ad.splashscreen.d.a r6 = r6.BY     // Catch: org.json.JSONException -> L43
            long r6 = r6.getCurrentPosition()     // Catch: org.json.JSONException -> L43
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L43
        L2f:
            if (r9 == 0) goto L34
            r0 = 153(0x99, float:2.14E-43)
            goto L38
        L34:
            if (r3 == 0) goto L38
            r0 = 132(0x84, float:1.85E-43)
        L38:
            com.kwad.components.ad.splashscreen.h r9 = r8.Cx     // Catch: org.json.JSONException -> L41
            com.kwad.sdk.core.response.model.AdTemplate r9 = r9.mAdTemplate     // Catch: org.json.JSONException -> L41
            r5 = 0
            com.kwad.sdk.core.report.a.a(r9, r0, r5, r4)     // Catch: org.json.JSONException -> L41
            goto L4a
        L41:
            r9 = move-exception
            goto L45
        L43:
            r9 = move-exception
            r0 = r12
        L45:
            com.kwad.sdk.core.d.b.printStackTrace(r9)
            goto L4a
        L49:
            r0 = r12
        L4a:
            com.kwad.components.core.d.b.a$a r9 = new com.kwad.components.core.d.b.a$a
            com.kwad.components.ad.splashscreen.h r4 = r8.Cx
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r9.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r8.Cx
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.d.b.a$a r9 = r9.J(r4)
            com.kwad.components.ad.splashscreen.h r4 = r8.Cx
            com.kwad.components.core.d.b.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.d.b.a$a r9 = r9.b(r4)
            com.kwad.components.core.d.b.a$a r9 = r9.al(r3)
            com.kwad.components.core.d.b.a$a r9 = r9.ap(r10)
            com.kwad.components.core.d.b.a$a r9 = r9.a(r11)
            if (r2 == 0) goto L76
            goto L77
        L76:
            r12 = r0
        L77:
            com.kwad.components.core.d.b.a$a r9 = r9.ao(r12)
            com.kwad.components.core.d.b.a$a r9 = r9.an(r1)
            com.kwad.components.core.d.b.a$a r9 = r9.an(r2)
            com.kwad.components.ad.splashscreen.b.o$5 r10 = new com.kwad.components.ad.splashscreen.b.o$5
            r10.<init>()
            com.kwad.components.core.d.b.a$a r9 = r9.a(r10)
            com.kwad.components.core.d.b.a.a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.o.a(boolean, int, com.kwad.sdk.core.report.y$b, int):void");
    }

    static /* synthetic */ boolean a(o oVar, boolean z2) {
        oVar.Dx = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        if (this.ee != null || this.Du) {
            return;
        }
        this.ee = new com.kwad.sdk.core.f.d(com.kwad.sdk.core.response.a.b.by(this.Cx.mAdTemplate));
        this.ee.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.splashscreen.b.o.9
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d2) {
                boolean zNa = com.kwad.components.core.d.a.b.na();
                if (!o.this.Cx.BZ.rX() || zNa) {
                    o.this.lB();
                    return;
                }
                o.this.h(d2);
                o.this.lB();
                if (o.this.ef == null) {
                    o oVar = o.this;
                    oVar.ef = oVar.F(oVar.getContext());
                }
                bh.a(o.this.getContext(), o.this.ef);
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ee.bi(getContext());
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private com.kwad.components.core.webview.jshandler.g dy() {
        return new com.kwad.components.core.webview.jshandler.g(this.mJsBridgeContext, this.Cx.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.o.3
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (com.kwad.sdk.b.kwai.a.tN()) {
                    return;
                }
                if (aVar.zr() || o.o(o.this.mAdInfo)) {
                    y.b bVar = new y.b();
                    bVar.To = aVar.Tz.To;
                    o.this.a(false, aVar.Ty, bVar, aVar.jS);
                }
            }
        });
    }

    private com.kwad.components.core.webview.jshandler.j dz() {
        return new com.kwad.components.core.webview.jshandler.j(this.mJsBridgeContext, this.Cx.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.o.4
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar.Tw || !o.o(o.this.mAdInfo)) {
                    o.this.a(false, aVar.Tw ? 1 : 3, null, aVar.jS);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d2) {
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar != null) {
            hVar.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.o.11
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                    iVar.i(d2);
                }
            });
        }
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.Cx.mRootContainer;
        bVar.aoM = adBaseFrameLayout;
        bVar.LI = adBaseFrameLayout;
        bVar.Lk = this.cS;
        bVar.mReportExtData = null;
        bVar.aoO = false;
        bVar.aoP = o(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB() {
        bh.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.10
            @Override // java.lang.Runnable
            public final void run() {
                o.this.ee.xP();
            }
        }, null, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        Runnable runnable;
        this.Du = true;
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.a.b.cV(this.mAdInfo)) {
            runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.12
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new l(), true);
                }
            };
        } else if (com.kwad.sdk.core.response.a.b.cX(this.mAdInfo)) {
            runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.13
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new k(), true);
                }
            };
        } else {
            if (!com.kwad.sdk.core.response.a.b.cZ(this.mAdInfo)) {
                lE();
                return;
            }
            runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new m(), true);
                }
            };
        }
        bh.postOnUiThread(runnable);
    }

    private void lE() {
        lC();
        this.Ds = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate), this.Cx.mApkDownloadHelper);
        this.Ds.D(this.mAdTemplate);
        this.Ds.a(this);
        this.Ds.lD();
    }

    public static boolean o(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_splash_web_card_webView);
        this.mAdTemplate = this.Cx.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.Dt = false;
        this.Du = false;
        String strAO = com.kwad.sdk.core.response.a.b.aO(this.mAdTemplate);
        if (this.cS == null || TextUtils.isEmpty(strAO)) {
            lD();
        } else {
            this.Dv = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.a.kZ();
            a(this.cS, strAO);
            bh.a(this.Dy, null, com.kwad.sdk.core.response.a.b.dd(this.mAdInfo));
        }
        this.Cx.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void f(boolean z2, boolean z3) {
        com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "isClick: " + z2 + ", isActionBar: " + z3);
        a(!z2, z3 ? 1 : 2, null, TbsListener.ErrorCode.DOWNLOAD_CDN_URL_IS_NULL);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kL() {
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void lC() {
        if (this.Dt) {
            return;
        }
        this.Dt = true;
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        aVar.ajB = com.kwad.components.ad.splashscreen.local.d.p(this.mAdInfo);
        bVar.akh = aVar;
        com.kwad.sdk.core.report.a.a(this.Cx.mAdTemplate, 123, bVar, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Ds;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.f.d dVar = this.ee;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        ae aeVar = this.Dw;
        if (aeVar != null) {
            aeVar.rt();
            this.Dw.ru();
        }
        clearJsInterfaceRegister();
    }
}
