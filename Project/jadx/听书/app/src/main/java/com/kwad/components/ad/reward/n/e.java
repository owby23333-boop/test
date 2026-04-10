package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bp;

/* JADX INFO: loaded from: classes3.dex */
public class e extends com.kwad.sdk.core.download.a.a implements al.b, as.b {
    private View BO;
    private bf BP;
    private f BQ;
    private KsAdWebView eN;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private com.kwad.sdk.core.webview.d.a.a eT;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.BP != null) {
                e.this.BP.ai(true);
            }
        }
    };

    public e(KsAdWebView ksAdWebView, View view, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.BO = view;
        this.eN = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.eT = aVar;
    }

    public final void a(f fVar) {
        this.BQ = fVar;
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.eN.getBackground() != null) {
                this.eN.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        Y(com.kwad.sdk.core.response.b.b.cw(this.mAdTemplate));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void lc() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
    }

    private void ad(boolean z) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        View view = this.BO;
        if (view != null) {
            view.setVisibility(0);
        }
        ad(false);
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(adTemplate);
        this.eQ.mScreenOrientation = 0;
        this.eQ.aMN = null;
        this.eQ.TG = viewGroup;
        this.eQ.Ta = this.eN;
        this.eQ.mReportExtData = null;
        this.eQ.aMP = true;
    }

    private void Y(String str) {
        if (bp.isNullString(str)) {
            ld();
            return;
        }
        bf();
        this.eN.setClientConfig(this.eN.getClientConfig().eJ(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.eN);
        this.eP = aVar;
        a(aVar, str);
        this.eN.addJavascriptInterface(this.eP, "KwaiAd");
        this.eN.loadUrl(str);
    }

    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + ", " + str);
                e.this.ld();
            }
        };
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new z(this.eQ, this.mApkDownloadHelper, this.eT));
        aVar.a(new af(this.eQ));
        aVar.a(new ae(this.eQ));
        aVar.a(new as(this, str));
        bf bfVar = new bf();
        this.BP = bfVar;
        aVar.a(bfVar);
        aVar.a(new am(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.eQ));
        aVar.a(new ai(this.eQ));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new al(this.eQ, this));
        aVar.a(new bc(this.eQ, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.eN.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ad(true);
        } else {
            ld();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.al.b
    public final void a(al.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }

    private void k(String str, int i) {
        f fVar = this.BQ;
        if (fVar != null) {
            fVar.i(str, i);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            k(com.kwad.sdk.core.response.b.a.dF(i), i);
        }
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        k(com.kwad.sdk.core.response.b.a.dG(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.cl(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate)) : "立即下载", 100);
    }
}
