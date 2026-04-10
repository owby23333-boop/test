package com.kwad.components.core.e.c;

import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c implements View.OnClickListener {
    public b OG;
    public b.C0332b OH;
    private Runnable OQ;
    private KsAdWebView eN;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private az eS;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean OR = false;
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.OR);
            e.a(e.this, true);
        }
    };
    private al.b eU = new al.b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.eN.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private ak.b eV = new ak.b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.bk();
        }
    };
    private as.b eW = new as.b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            com.kwad.sdk.core.d.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.pc();
                return;
            }
            e.this.bk();
            if (e.this.getContext() != null) {
                ac.Q(e.this.getContext(), ae.cQ(e.this.getContext()));
            }
        }
    };

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.OR = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eN = (KsAdWebView) findViewById(R.id.ksad_download_tips_web_card_webView);
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.OG = this.OI.OG;
        this.OH = this.OI.OH;
        this.mAdTemplate = this.OI.mAdTemplate;
        this.OI.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.OI.mApkDownloadHelper;
        bc();
        pa();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        pc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    private void release() {
        this.eN.setVisibility(8);
        this.eN.release();
        bf();
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.OI.mAdTemplate);
        this.eQ.aMN = this.OI.mRootContainer;
        this.eQ.TG = this.OI.mRootContainer;
        this.eQ.Ta = this.eN;
    }

    private void pa() {
        be();
        this.eN.loadUrl(this.OH.url);
        this.eN.postDelayed(pb(), 1500L);
        this.eN.setBackgroundColor(0);
        this.eN.getBackground().setAlpha(0);
        this.eN.setVisibility(0);
    }

    private Runnable pb() {
        if (this.OQ == null) {
            this.OQ = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.bk();
                    if (e.this.getContext() != null) {
                        ac.Q(e.this.getContext(), ae.cQ(e.this.getContext()));
                    }
                }
            };
        }
        return this.OQ;
    }

    private void be() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        bf();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.eN);
        this.eP = aVar;
        a(aVar);
        this.eN.addJavascriptInterface(this.eP, "KwaiAd");
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new com.kwad.components.core.webview.jshandler.ac(this.eQ, this.mApkDownloadHelper, this.eT));
        aVar.a(new z(this.eQ, this.mApkDownloadHelper, this.eT, 1));
        aVar.a(new af(this.eQ));
        aVar.a(new ai(this.eQ));
        aVar.a(new com.kwad.components.core.webview.jshandler.ae(this.eQ));
        aVar.a(new al(this.eQ, this.eU));
        aVar.a(new as(this.eW, this.OH.url));
        az azVar = new az();
        this.eS = azVar;
        aVar.a(azVar);
        aVar.a(new bc(this.eQ, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(e.this.mAdTemplate);
                String strAy = com.kwad.sdk.core.response.b.a.ay(adInfoEl);
                if (com.kwad.sdk.core.response.b.a.aO(adInfoEl) && com.kwad.sdk.core.response.b.a.aF(adInfoEl) && com.kwad.sdk.utils.as.ap(e.this.getContext(), strAy) && com.kwad.components.core.r.a.sF().sJ() && com.kwad.sdk.core.response.b.a.aN(adInfoEl) == 1) {
                    e.this.OG.dismiss();
                }
            }
        }));
        aVar.a(new ak(this.eV));
        aVar.a(new am(this.eQ));
        aVar.b(new o(this.eQ));
        aVar.b(new n(this.eQ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc() {
        Runnable runnable = this.OQ;
        if (runnable != null) {
            this.eN.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk() {
        com.kwad.sdk.core.d.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.OR);
        if (this.eN.getVisibility() != 0) {
            return;
        }
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uH();
        }
        this.eN.setVisibility(4);
        az azVar2 = this.eS;
        if (azVar2 != null) {
            azVar2.uI();
        }
        if (this.OR) {
            com.kwad.sdk.core.adlog.c.cb(this.mAdTemplate);
        }
        b bVar = this.OG;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.OG.al(this.OR);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.cb(this.mAdTemplate);
        b bVar = this.OG;
        if (bVar != null) {
            bVar.dismiss();
        }
    }
}
