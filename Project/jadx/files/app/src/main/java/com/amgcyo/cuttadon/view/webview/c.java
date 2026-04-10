package com.amgcyo.cuttadon.view.webview;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: compiled from: MkX5WebChromeClient.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends WebChromeClient {
    private a a;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        this.a.startProgress(i2);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        this.a.onReceivedTitle(webView, str);
    }
}
