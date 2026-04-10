package com.kwad.components.core.page.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends c {
    private int LH = -1;
    private ViewGroup LI;
    private final a LJ;
    private WebView Lk;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;

    public interface a {
        void aw(int i2);
    }

    public f(a aVar, boolean z2) {
        this.LJ = aVar;
        this.mIsRewardLandPage = z2;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.b.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.LF.mAdTemplate);
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new ah(this.mJsBridgeContext, cVar));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new ae());
        aVar.a(new z(oD(), com.kwad.sdk.core.response.a.b.bc(this.mAdTemplate)));
        aVar.a(new t(this.mJsBridgeContext));
        aVar.a(new x(getOpenNewPageListener()));
        aVar.a(new j(this.mJsBridgeContext, cVar, null));
        aVar.a(new g(this.mJsBridgeContext, cVar, null, 2, this.mIsRewardLandPage));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.Lk);
        a(this.mJsInterface);
        this.Lk.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void at(String str) {
        aG();
        this.Lk.loadUrl(str);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private x.a getOpenNewPageListener() {
        return new x.a() { // from class: com.kwad.components.core.page.a.f.2
            @Override // com.kwad.components.core.webview.jshandler.x.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(f.this.Lk.getContext(), new AdWebViewActivityProxy.a.C0405a().ar(bVar.title).as(bVar.url).ax(true).M(f.this.mAdTemplate).ow());
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.LI = this.LI;
        bVar.Lk = this.Lk;
    }

    private z.b oD() {
        return new z.b() { // from class: com.kwad.components.core.page.a.f.1
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar) {
                f.this.LH = aVar.status;
                if (f.this.LJ != null) {
                    f.this.LJ.aw(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.LI.setVisibility(0);
                } else {
                    f.this.Lk.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.a.c, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.LF.mAdTemplate;
        String strBc = com.kwad.sdk.core.response.a.b.bc(this.mAdTemplate);
        if (!TextUtils.isEmpty(strBc)) {
            inflateJsBridgeContext();
            at(strBc);
        } else {
            a aVar = this.LJ;
            if (aVar != null) {
                aVar.aw(this.LH);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Lk = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.LI = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.Lk.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        clearJsInterfaceRegister();
    }
}
