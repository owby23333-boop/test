package com.anythink.expressad.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anythink.expressad.advanced.d.c;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.atsignalcommon.base.b;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    String a;
    com.anythink.expressad.advanced.d.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8257c = "NativeAdvancedWebViewClient";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f8258d;

    public a(String str, com.anythink.expressad.advanced.d.a aVar, c cVar) {
        this.a = str;
        this.b = aVar;
        this.f8258d = cVar;
    }

    private WebResourceResponse a(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && "mb-h5".equals(uri.getScheme())) {
            z2 = true;
        }
        if (!z2 || this.f8258d == null) {
            return null;
        }
        String strA = this.f8258d.a(URLDecoder.decode(Uri.parse(str).getQueryParameter("uri")));
        try {
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            o.a("webviewclient", "relace url".concat(String.valueOf(strA)));
            if (strA.contains("127.0.0.1") || strA.startsWith("http")) {
                return null;
            }
            return new WebResourceResponse(com.anythink.expressad.exoplayer.k.o.f9860e, com.anythink.expressad.foundation.g.a.bN, new FileInputStream(strA));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean b(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || !"mb-h5".equals(uri.getScheme())) ? false : true;
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
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.advanced.view.a.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            o.b("NativeAdvancedWebViewClient", "onPageStarted", th);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        o.a("NativeAdvancedWebViewClient", "============shouldInterceptRequest:".concat(String.valueOf(str)));
        return a(str);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            try {
                WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
                if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.f8029c) {
                    com.anythink.expressad.foundation.d.c cVar = ((NativeAdvancedJSBridgeImpl) windVaneWebView.getObject()).getmCampaignList().get(0);
                    windVaneWebView.getUrl();
                    if (com.anythink.expressad.a.b.a.a(cVar)) {
                        return false;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            o.d("NativeAdvancedWebViewClient", "Use html to open url.");
            if (this.b == null) {
                return true;
            }
            this.b.a(str);
            return true;
        } catch (Throwable th) {
            o.b("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(Build.VERSION.SDK_INT >= 21 ? webResourceRequest.getUrl().toString() : "");
    }

    public final void a() {
        if (this.f8258d != null) {
            this.f8258d = null;
        }
    }
}
