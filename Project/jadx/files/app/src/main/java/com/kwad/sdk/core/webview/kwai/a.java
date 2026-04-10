package com.kwad.sdk.core.webview.kwai;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;

/* JADX INFO: loaded from: classes3.dex */
public class a extends WebViewClient {
    private boolean aoZ = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z2) {
        this.aoZ = z2;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.aoZ || !d.uP()) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        String string = webResourceRequest.getUrl().toString();
        com.kwad.sdk.core.d.b.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + string);
        WebResourceResponse webResourceResponseJ = com.kwad.sdk.core.webview.a.a.zl().J(string, this.mUniqueId);
        return webResourceResponseJ == null ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponseJ;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.aoZ || !d.uP()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.b.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse webResourceResponseJ = com.kwad.sdk.core.webview.a.a.zl().J(str, this.mUniqueId);
        return webResourceResponseJ == null ? super.shouldInterceptRequest(webView, str) : webResourceResponseJ;
    }
}
