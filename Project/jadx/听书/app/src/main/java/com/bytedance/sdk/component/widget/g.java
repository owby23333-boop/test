package com.bytedance.sdk.component.widget;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes2.dex */
public class g extends WebViewClient {
    private String g;
    private final WebViewClient z;

    public WebViewClient z() {
        return this.z;
    }

    public void z(String str) {
        this.g = str;
    }

    public String g() {
        return this.g;
    }

    public g(WebViewClient webViewClient) {
        this.z = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.z.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return this.z.shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.g = str;
        this.z.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.z.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        this.z.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        this.z.onPageCommitVisible(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return this.z.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return this.z.shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.z.onTooManyRedirects(webView, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.z.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.z.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.z.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.z.onFormResubmission(webView, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.z.doUpdateVisitedHistory(webView, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.z.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        this.z.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.z.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.z.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.z.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        this.z.onScaleChanged(webView, f, f2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        this.z.onReceivedLoginRequest(webView, str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.z.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        this.z.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
    }
}
