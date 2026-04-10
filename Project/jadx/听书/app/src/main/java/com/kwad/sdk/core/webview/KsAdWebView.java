package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: classes4.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    private long Gn;
    private c.a Mh;
    private com.kwad.sdk.core.webview.a.c aMU;
    private String aMV;
    private com.kwad.sdk.core.webview.d aMW;
    private String mUniqueId;

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public interface c {
        void rn();
    }

    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    private void setAccessibilityStateDisable(Context context) {
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }

    public void setClientConfig(c.a aVar) {
        this.aMU.setClientConfig(aVar);
        c.a aVar2 = this.Mh;
        if (aVar2 == null || !aVar2.KP()) {
            return;
        }
        this.aMW = new com.kwad.sdk.core.webview.d();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c.a aVar;
        if (motionEvent.getAction() == 1 && (aVar = this.Mh) != null) {
            aVar.aM(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public String getLoadUrl() {
        return this.aMV;
    }

    public long getLoadTime() {
        return this.Gn;
    }

    public c.a getClientConfig() {
        return this.Mh;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(getContext(), getSettings());
        com.kwad.sdk.core.webview.b.c.b.ff(this.mUniqueId);
        this.aMV = str;
        this.Gn = System.currentTimeMillis();
        super.loadUrl(str);
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.c.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings webSettingsA = cb.a(this);
        webSettingsA.setUseWideViewPort(true);
        webSettingsA.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.aMW != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aMW;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.Mh);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aMW != null) {
                    KsAdWebView.this.aMW.c(KsAdWebView.this.Mh);
                }
            }
        };
        this.aMU = cVar;
        cVar.R(this.mUniqueId);
        setWebViewClient(this.aMU);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        this.Mh = new c.a(getContext());
    }

    private void a(Context context, WebSettings webSettings) {
        boolean zKR;
        boolean zKS;
        String userAgentString = webSettings.getUserAgentString();
        c.a aVar = this.Mh;
        if (aVar != null) {
            zKR = aVar.KR();
            zKS = this.Mh.KS();
        } else {
            zKR = false;
            zKS = false;
        }
        com.kwad.sdk.core.i.c cVarJ = com.kwad.sdk.core.i.a.j(zKR, zKS);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: uaGetter：" + cVarJ);
        String str = userAgentString + cVarJ.bJ(context);
        com.kwad.sdk.core.d.c.d("KsAdWebView", "setWebViewUserAgent: " + str);
        webSettings.setUserAgentString(str);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.oz.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.oz.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // com.kwad.sdk.core.webview.c, android.webkit.WebView
    public void destroy() {
        super.destroy();
        c.a aVar = this.Mh;
        if (aVar != null) {
            aVar.release();
            this.Mh = null;
        }
        com.kwad.sdk.core.webview.a.c cVar = this.aMU;
        if (cVar != null) {
            cVar.destroy();
            this.aMU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.aMU;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.aMU.getClientConfig();
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.aMW;
        if (dVar != null) {
            dVar.a(this.Mh);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.aMW;
        if (dVar != null) {
            dVar.b(this.Mh);
        }
    }

    class a implements DownloadListener {
        private a() {
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            boolean zO = bz.o(KsAdWebView.this, 100);
            com.kwad.sdk.core.d.c.d("KsAdWebView", "onDownloadStart: currentVisible " + zO);
            if (zO) {
                if (KsAdWebView.this.Mh == null || KsAdWebView.this.Mh.KQ()) {
                    if (KsAdWebView.this.Mh != null && KsAdWebView.this.Mh.getAdTemplate() != null && KsAdWebView.this.Mh.KO()) {
                        com.kwad.sdk.core.response.b.e.el(KsAdWebView.this.Mh.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                        KsAdWebView.this.Mh.getAdTemplate().isWebViewDownload = true;
                        c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                        if (readyClientConfig != null) {
                            readyClientConfig.eJ(KsAdWebView.this.Mh.getAdTemplate());
                        }
                        ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).h(m.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.Mh.getAdTemplate());
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        KsAdWebView.this.getContext().startActivity(intent);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c.a aVar = this.Mh;
        if (aVar == null || aVar.rm() == null) {
            return;
        }
        this.Mh.rm().rn();
    }
}
