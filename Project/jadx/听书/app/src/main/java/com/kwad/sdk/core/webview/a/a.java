package com.kwad.sdk.core.webview.a;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.e;

/* JADX INFO: loaded from: classes4.dex */
public class a extends WebViewClient {
    private boolean aNa = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.aNa = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.aNa || !e.FF()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse webResourceResponseAa = com.kwad.sdk.core.webview.b.a.KT().aa(str, this.mUniqueId);
        return webResourceResponseAa == null ? super.shouldInterceptRequest(webView, str) : webResourceResponseAa;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.aNa || !e.FF()) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        String string = webResourceRequest.getUrl().toString();
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + string);
        WebResourceResponse webResourceResponseAa = com.kwad.sdk.core.webview.b.a.KT().aa(string, this.mUniqueId);
        return webResourceResponseAa == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponseAa;
    }
}
