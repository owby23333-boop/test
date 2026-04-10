package com.kwad.components.core.page.a;

import android.annotation.SuppressLint;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Presenter {
    private z.b cY = new z.b() { // from class: com.kwad.components.core.page.a.b.1
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new z(this.cY, com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))));
        aVar.a(new t(this.mJsBridgeContext));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.mAdWebView);
        a(this.mJsInterface);
        this.mAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
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
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        bVar.Lk = this.mAdWebView;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) Bs()).adTemplate;
        this.mAdWebView = (KsAdWebView) getRootView().findViewById(R.id.ksad_video_webView);
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().cr(this.mAdTemplate));
        inflateJsBridgeContext();
        aG();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        clearJsInterfaceRegister();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
