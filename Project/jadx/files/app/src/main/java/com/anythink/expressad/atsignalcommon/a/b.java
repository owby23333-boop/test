package com.anythink.expressad.atsignalcommon.a;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.windvane.e;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class b implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final String f8259d = "WindVaneWebView";

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void loadingResourceStatus(WebView webView, int i2) {
        o.a(f8259d, "loadingResourceStatus");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onPageFinished(WebView webView, String str) {
        o.a(f8259d, "onPageFinished");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        o.a(f8259d, "onPageStarted");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onProgressChanged(WebView webView, int i2) {
        o.a(f8259d, "onProgressChanged");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        o.a(f8259d, "onReceivedError");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        o.a(f8259d, "onReceivedSslError");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public void readyState(WebView webView, int i2) {
        o.a(f8259d, "readyState");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.e
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        o.a(f8259d, "shouldOverrideUrlLoading");
        return true;
    }
}
