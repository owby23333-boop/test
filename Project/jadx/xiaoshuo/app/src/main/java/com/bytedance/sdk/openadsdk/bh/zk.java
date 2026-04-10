package com.bytedance.sdk.openadsdk.bh;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes10.dex */
public class zk {
    private static void bf(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            p.e("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    private static void e(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            p.e("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    public static void e(WebView webView) {
        bf(webView);
        WebSettings settings = webView.getSettings();
        e(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable th) {
            p.e("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            settings.setSupportZoom(false);
        } catch (Throwable th2) {
            p.e("WebViewSettings", "setSupportZoom error", th2);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSavePassword(false);
        try {
            webView.setLayerType(2, null);
        } catch (Throwable th3) {
            p.e("WebViewSettings", "setLayerType error", th3);
        }
        webView.getSettings().setMixedContentMode(0);
    }
}
