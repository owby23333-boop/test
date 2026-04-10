package com.amgcyo.cuttadon.view.webview;

import android.text.TextUtils;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* JADX INFO: compiled from: MkX5WebViewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends WebViewClient {
    private a a;

    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.a.onPageFinished(webView, str);
        super.onPageFinished(webView, str);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        if (i2 == 404) {
            webView.loadUrl("javascript:document.body.innerHTML=\"Page NO FOUND！\"");
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onScaleChanged(WebView webView, float f2, float f3) {
        super.onScaleChanged(webView, f2, f3);
        if (f3 - f2 > 7.0f) {
            webView.setInitialScale((int) ((f2 / f3) * 100.0f));
        }
        this.a.onScaleChanged(f3);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.a.isOpenThirdApp(str);
    }
}
