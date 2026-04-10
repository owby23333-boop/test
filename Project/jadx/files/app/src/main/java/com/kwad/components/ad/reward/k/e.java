package com.kwad.components.ad.reward.k;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ba;

/* JADX INFO: loaded from: classes3.dex */
public class e extends com.kwad.sdk.core.download.kwai.a implements s.b, z.b {
    private KsAdWebView cS;
    private com.kwad.sdk.core.webview.c.kwai.a cV;

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.k.e.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (e.this.yr != null) {
                e.this.yr.ai(true);
            }
        }
    };
    private View yq;
    private aj yr;
    private f ys;

    public e(KsAdWebView ksAdWebView, View view, @Nullable com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.yq = view;
        this.cS = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.cV = aVar;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new com.kwad.components.core.webview.jshandler.g(this.mJsBridgeContext, this.mApkDownloadHelper, this.cV));
        aVar.a(new com.kwad.components.core.webview.jshandler.m(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new z(this, str));
        this.yr = new aj();
        aVar.a(this.yr);
        aVar.a(new com.kwad.components.core.webview.jshandler.t(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new com.kwad.components.core.webview.jshandler.s(this.mJsBridgeContext, this));
        aVar.a(new ah(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.f.b(this.cS.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void ae(boolean z2) {
        com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", "switchWebView: " + z2);
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z2 ? 0 : 8);
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        bVar.aoM = null;
        bVar.LI = viewGroup;
        bVar.Lk = this.cS;
        bVar.mReportExtData = null;
        bVar.aoO = true;
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.k.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i2 + ", " + str);
                e.this.m67if();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public void m67if() {
        View view = this.yq;
        if (view != null) {
            view.setVisibility(0);
        }
        ae(false);
    }

    private void k(String str, int i2) {
        f fVar = this.ys;
        if (fVar != null) {
            fVar.i(str, i2);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v(String str) {
        if (ba.isNullString(str)) {
            m67if();
            return;
        }
        clearJsInterfaceRegister();
        this.cS.setClientConfig(this.cS.getClientConfig().cr(this.mAdTemplate).b(getWebErrorListener()));
        this.mJsInterface = new com.kwad.components.core.webview.a(this.cS);
        a(this.mJsInterface, str);
        this.cS.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.cS.loadUrl(str);
    }

    public final void a(f fVar) {
        this.ys = fVar;
    }

    @Override // com.kwad.components.core.webview.jshandler.s.b
    public final void a(@NonNull s.a aVar) {
        com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }

    @Override // com.kwad.components.core.webview.jshandler.z.b
    public final void a(z.a aVar) {
        com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ae(true);
        } else {
            m67if();
        }
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.cS.getBackground() != null) {
                this.cS.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        v(com.kwad.sdk.core.response.a.b.aQ(this.mAdTemplate));
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void ke() {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aI(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.a.a.U(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i2) {
        k(com.kwad.sdk.core.response.a.a.bv(i2), i2);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i2) {
        if (i2 != 0) {
            k(com.kwad.sdk.core.response.a.a.bu(i2), i2);
        }
    }
}
