package com.anythink.core.basead.ui.a;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static void a(WebView webView, boolean z2) {
        if (z2) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    private static void b(WebView webView) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, p.a(webView.getContext()).b());
        }
    }

    public static void a(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.core.basead.ui.a.a.1
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsBeforeUnload(WebView webView2, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                jsPromptResult.confirm();
                return true;
            }
        });
    }

    private static void a() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (p.a(n.a().g()).b()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.removeSessionCookies(null);
            cookieManager.removeAllCookies(null);
            cookieManager.flush();
        } else {
            cookieManager.removeSessionCookie();
            cookieManager.removeAllCookie();
        }
    }
}
