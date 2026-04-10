package com.kwad.components.core.d.a;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.a.b;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c implements View.OnClickListener {

    @Nullable
    public b II;
    public b.C0394b IJ;
    private Runnable IR;
    private KsAdWebView cS;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ae mCardLifecycleHandler;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private boolean IS = false;
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.core.d.a.e.1
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.IS);
            e.a(e.this, true);
        }
    };
    private s.b cW = new s.b() { // from class: com.kwad.components.core.d.a.e.4
        @Override // com.kwad.components.core.webview.jshandler.s.b
        public final void a(s.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.cS.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    private r.b cX = new r.b() { // from class: com.kwad.components.core.d.a.e.5
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aL();
        }
    };
    private z.b cY = new z.b() { // from class: com.kwad.components.core.d.a.e.6
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            com.kwad.sdk.core.d.b.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.ng();
                return;
            }
            e.this.aL();
            if (e.this.getContext() != null) {
                u.F(e.this.getContext(), v.cb(e.this.getContext()));
            }
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new j(this.mJsBridgeContext, this.mApkDownloadHelper, this.cV, false, true));
        aVar.a(new g(this.mJsBridgeContext, this.mApkDownloadHelper, this.cV, 1));
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new s(this.mJsBridgeContext, this.cW));
        aVar.a(new z(this.cY, this.IJ.url));
        this.mCardLifecycleHandler = new ae();
        aVar.a(this.mCardLifecycleHandler);
        aVar.a(new ah(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.download.kwai.c() { // from class: com.kwad.components.core.d.a.e.3
            @Override // com.kwad.sdk.core.download.kwai.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(e.this.mAdTemplate);
                String strAr = com.kwad.sdk.core.response.a.a.ar(adInfoCb);
                if (com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.sdk.core.response.a.a.ay(adInfoCb) && aj.ah(e.this.getContext(), strAr) && com.kwad.components.core.p.a.pJ().pN() && com.kwad.sdk.core.response.a.a.aG(adInfoCb) == 1) {
                    e.this.II.dismiss();
                }
            }
        }));
        aVar.a(new r(this.cX));
        aVar.a(new t(this.mJsBridgeContext));
    }

    static /* synthetic */ boolean a(e eVar, boolean z2) {
        eVar.IS = true;
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.cS);
        a(this.mJsInterface);
        this.cS.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL() {
        com.kwad.sdk.core.d.b.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.IS);
        if (this.cS.getVisibility() != 0) {
            return;
        }
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rt();
        }
        this.cS.setVisibility(4);
        ae aeVar2 = this.mCardLifecycleHandler;
        if (aeVar2 != null) {
            aeVar2.ru();
        }
        if (this.IS) {
            com.kwad.sdk.core.report.a.aA(this.mAdTemplate);
        }
        b bVar = this.II;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.II.ak(this.IS);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.IK.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        AdBaseFrameLayout adBaseFrameLayout = this.IK.mRootContainer;
        bVar.aoM = adBaseFrameLayout;
        bVar.LI = adBaseFrameLayout;
        bVar.Lk = this.cS;
    }

    private void ne() {
        aG();
        this.cS.loadUrl(this.IJ.url);
        this.cS.postDelayed(nf(), 1500L);
        this.cS.setBackgroundColor(0);
        this.cS.getBackground().setAlpha(0);
        this.cS.setVisibility(0);
    }

    private Runnable nf() {
        if (this.IR == null) {
            this.IR = new Runnable() { // from class: com.kwad.components.core.d.a.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.aL();
                    if (e.this.getContext() != null) {
                        u.F(e.this.getContext(), v.cb(e.this.getContext()));
                    }
                }
            };
        }
        return this.IR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng() {
        Runnable runnable = this.IR;
        if (runnable != null) {
            this.cS.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.cS.setVisibility(8);
        this.cS.release();
        clearJsInterfaceRegister();
    }

    @Override // com.kwad.components.core.d.a.c, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        d dVar = this.IK;
        this.II = dVar.II;
        this.IJ = dVar.IJ;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.IK.mApkDownloadHelper;
        inflateJsBridgeContext();
        ne();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.report.a.aA(this.mAdTemplate);
        b bVar = this.II;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ng();
    }
}
