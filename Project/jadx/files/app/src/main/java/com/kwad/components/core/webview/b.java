package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.a.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.a.a.r;
import com.kwad.components.core.webview.a.kwai.f;
import com.kwad.components.core.webview.a.kwai.k;
import com.kwad.components.core.webview.a.kwai.l;
import com.kwad.components.core.webview.a.kwai.s;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private KsAdWebView GB;
    private KsAdWebView.c LN;
    private c Mn;
    private com.kwad.components.core.webview.kwai.a RN;
    private ad RO;
    private z.b RP = new z.b() { // from class: com.kwad.components.core.webview.b.8
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            if (b.this.Mn != null) {
                b.this.Mn.a(aVar);
            }
        }
    };
    private AdTemplate mAdTemplate;
    private e mDownloadSyncInterfaceAdapter;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private String mPageUrl;
    private ViewGroup mWebContainer;

    public static class a {
        private KsAdWebView GB;
        private KsAdWebView.c LN;
        private c Mn;
        private AdTemplate mAdTemplate;
        private String mPageUrl;
        private ViewGroup mWebContainer;

        @Nullable
        public final a R(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @Nullable
        public final a a(c cVar) {
            this.Mn = cVar;
            return this;
        }

        @NonNull
        public final a aD(String str) {
            this.mPageUrl = str;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.LN = cVar;
            return this;
        }

        @NonNull
        public final a e(KsAdWebView ksAdWebView) {
            this.GB = ksAdWebView;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final KsAdWebView.c getOnWebViewScrollChangeListener() {
            return this.LN;
        }

        @NonNull
        public final a j(ViewGroup viewGroup) {
            this.mWebContainer = viewGroup;
            return this;
        }

        public final String ot() {
            return this.mPageUrl;
        }

        public final ViewGroup rj() {
            return this.mWebContainer;
        }

        public final KsAdWebView rk() {
            return this.GB;
        }

        public final c rl() {
            return this.Mn;
        }
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.oP()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        ae aeVar = new ae();
        aVar.a(aeVar);
        onRegisterLifecycleLisener(aeVar);
        aVar.a(new t(bVar));
        aVar.a(new m(bVar));
        aVar.a(new f());
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        aVar.a(new j(this.mJsBridgeContext, cVar, getClickListener(), rc(), false));
        aVar.a(new g(this.mJsBridgeContext, cVar, getClickListener(), rc(), 0, rd()));
        aVar.a(new ah(this.mJsBridgeContext, cVar));
        aVar.a(new ab(this.mJsBridgeContext));
        aVar.a(new y(this.mJsBridgeContext.Lk.getContext(), this.mAdTemplate));
        aVar.a(new al(new al.a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.al.a
            public final void ri() {
                if (com.kwad.sdk.core.response.a.b.bC(b.this.mAdTemplate)) {
                    com.kwad.components.core.d.a.b.a(b.this.mJsBridgeContext.Lk.getContext(), new b.a().I(b.this.mAdTemplate).al(com.kwad.sdk.core.response.a.b.bB(b.this.mAdTemplate)).nd());
                }
            }
        }));
        aVar.a(new q(this.mJsBridgeContext));
        aVar.a(new z(this.RP, this.mPageUrl));
        this.RO = new ad();
        aVar.a(this.RO);
        aVar.a(new h(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                if (b.this.Mn != null) {
                    b.this.Mn.pageClose(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.components.core.webview.a.kwai.s.a
            public final void a(r rVar) {
                if (TextUtils.isEmpty(rVar.message)) {
                    return;
                }
                u.d(b.this.mJsBridgeContext.Lk.getContext(), rVar.message, 0L);
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new p(bVar));
        if (com.kwad.sdk.core.response.a.a.ay(d.cb(this.mAdTemplate))) {
            final l lVar = new l();
            aVar.a(lVar);
            this.mDownloadSyncInterfaceAdapter = new e(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.5
                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void a(String str, int i2, com.kwad.sdk.core.download.f fVar) {
                    super.a(str, i2, fVar);
                    com.kwad.components.core.webview.a.a.b bVar2 = new com.kwad.components.core.webview.a.a.b();
                    bVar2.UO = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.c.vG().a(this.mDownloadSyncInterfaceAdapter, this.mAdTemplate);
            aVar.a(new com.kwad.components.core.webview.a.kwai.d() { // from class: com.kwad.components.core.webview.b.6
                @Override // com.kwad.components.core.webview.a.kwai.d
                public final void a(com.kwad.components.core.webview.a.a.g gVar) {
                    super.a(gVar);
                    com.kwad.components.core.m.a.pr().a(gVar.Tn, b.this.mAdTemplate, gVar.To);
                }
            });
            aVar.a(new com.kwad.components.core.webview.a.kwai.j() { // from class: com.kwad.components.core.webview.b.7
                @Override // com.kwad.components.core.webview.a.kwai.j
                public final void a(com.kwad.components.core.webview.a.a.l lVar2) {
                    super.a(lVar2);
                    AdWebViewActivityProxy.launch(b.this.mJsBridgeContext.Lk.getContext(), new AdWebViewActivityProxy.a.C0405a().ar(lVar2.title).as(lVar2.url).ax(true).M(b.this.mAdTemplate).ow());
                }
            });
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void c(KsAdWebView ksAdWebView) {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(ksAdWebView);
        b(this.mJsInterface, this.mJsBridgeContext);
        c cVar = this.Mn;
        if (cVar != null) {
            cVar.a(this.mJsInterface, this.mJsBridgeContext);
        }
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
        com.kwad.components.core.webview.kwai.a aVar2 = this.RN;
        if (aVar2 != null) {
            aVar2.destroy();
            this.RN = null;
        }
    }

    private void d(KsAdWebView ksAdWebView) {
        clearJsInterfaceRegister();
        this.RN = new com.kwad.components.core.webview.kwai.a(ksAdWebView, this.mJsBridgeContext);
        ksAdWebView.addJavascriptInterface(this.RN, "KwaiAdForThird");
    }

    private void eP() {
        this.GB.setClientConfig(this.GB.getClientConfig().cr(this.mAdTemplate).b(rf()).b(rg()).a(re()).c(this.LN));
    }

    @NonNull
    private com.kwad.sdk.core.webview.c.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        bVar.Lk = this.GB;
        bVar.LI = this.mWebContainer;
    }

    private void onRegisterLifecycleLisener(ae aeVar) {
        c cVar = this.Mn;
        if (cVar == null) {
            return;
        }
        cVar.onRegisterLifecycleLisener(aeVar);
    }

    private boolean rc() {
        c cVar = this.Mn;
        if (cVar == null) {
            return false;
        }
        return cVar.oQ();
    }

    private boolean rd() {
        c cVar = this.Mn;
        return false;
    }

    @NonNull
    private KsAdWebView.b re() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.RO != null) {
                    b.this.RO.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.RO != null) {
                    b.this.RO.onSuccess();
                }
            }
        };
    }

    private y.b rf() {
        y.b bVar = new y.b();
        bVar.ajX = 0;
        bVar.aki = rh();
        return bVar;
    }

    private KsAdWebView.d rg() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (b.this.Mn != null) {
                    b.this.Mn.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                if (b.this.Mn != null) {
                    b.this.Mn.oR();
                }
            }
        };
    }

    private int rh() {
        return com.kwad.sdk.core.response.a.a.M(d.cb(this.mAdTemplate)) ? 5 : 1;
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.ot();
        this.mAdTemplate = aVar.getAdTemplate();
        this.mWebContainer = aVar.rj();
        this.GB = aVar.rk();
        this.Mn = aVar.rl();
        this.LN = aVar.getOnWebViewScrollChangeListener();
        eP();
        a(this.Mn, this.GB);
        inflateJsBridgeContext();
        if (com.kwad.sdk.core.response.a.a.I(d.cb(this.mAdTemplate))) {
            d(this.GB);
        } else if (com.kwad.sdk.core.response.a.b.cp(this.mPageUrl)) {
            c(this.GB);
        }
    }

    public final void unBind() {
        if (this.mDownloadSyncInterfaceAdapter != null) {
            com.kwad.sdk.core.download.c.vG().a(this.mDownloadSyncInterfaceAdapter);
        }
    }
}
