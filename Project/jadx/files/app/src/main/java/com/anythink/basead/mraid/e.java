package com.anythink.basead.mraid;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.anythink.expressad.atsignalcommon.base.b {
    final String a = e.class.getSimpleName();
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f6084c;

    public e(String str) {
        this.b = str;
    }

    private void a(b bVar) {
        this.f6084c = bVar;
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
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.basead.mraid.e.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            o.b(this.a, "onPageStarted", th);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (TextUtils.equals(str, this.b)) {
                return true;
            }
            o.d(this.a, "Use html to open url.");
            if (this.f6084c != null) {
                this.f6084c.open(str);
            }
            return true;
        } catch (Throwable th) {
            o.b(this.a, "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
