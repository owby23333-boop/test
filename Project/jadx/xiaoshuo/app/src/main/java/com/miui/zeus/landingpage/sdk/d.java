package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.miui.zeus.landingpage.sdk.activity.WebViewActivity;
import com.yuewen.rr3;

/* JADX INFO: loaded from: classes3.dex */
public class d extends WebView {

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            h.a("CommonWebView", "shouldOverrideUrlLoading : url ", str);
            if (!n.a(str)) {
                return false;
            }
            Intent intent = new Intent(d.this.getContext(), (Class<?>) WebViewActivity.class);
            intent.putExtra(rr3.i, str);
            intent.setFlags(268435456);
            d.this.getContext().startActivity(intent);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                h.b("CommonWebView", String.format("onReceivedError failingUrl : %s, errorCode : %s", webResourceRequest.getUrl().toString(), Integer.valueOf(webResourceError.getErrorCode())));
            }
        }
    }

    public d(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setScrollBarSize((int) ((getContext().getResources().getDisplayMetrics().density * 3.0f) + 0.5f));
        setScrollBarStyle(33554432);
        setVerticalScrollBarEnabled(true);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        getSettings().setMixedContentMode(1);
        setWebViewClient(new a());
    }
}
