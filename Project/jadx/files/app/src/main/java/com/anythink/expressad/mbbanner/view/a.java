package com.anythink.expressad.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.base.BaseWebView;
import com.anythink.expressad.atsignalcommon.base.b;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    String a;
    List<c> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.anythink.expressad.mbbanner.a.c.a f10878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10879d = "BannerWebViewClient";

    public a(String str, List<c> list, com.anythink.expressad.mbbanner.a.c.a aVar) {
        this.a = str;
        this.b = list;
        this.f10878c = aVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.mbbanner.view.a.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            o.b("BannerWebViewClient", "onPageStarted", th);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            o.d("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) webView;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > com.anythink.expressad.a.b.a.f8029c) {
                c cVar = this.b.get(0);
                baseWebView.getUrl();
                if (com.anythink.expressad.a.b.a.a(cVar)) {
                    return false;
                }
            }
            String str2 = null;
            if (this.b.size() > 1) {
                n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                str2 = str;
            }
            if (this.f10878c != null) {
                this.f10878c.a(false, str2);
            }
            return true;
        } catch (Throwable th) {
            o.b("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
