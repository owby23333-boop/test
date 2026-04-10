package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* JADX INFO: loaded from: classes3.dex */
class i extends X5ProxyWebChromeClient {
    private WebView a;
    private WebChromeClient b;

    class a implements WebStorage.QuotaUpdater {
        QuotaUpdater a;

        a(QuotaUpdater quotaUpdater) {
            this.a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j2) {
            this.a.updateQuota(j2);
        }
    }

    public i(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.a = webView;
        this.b = webChromeClient;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.b.getDefaultVideoPoster();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(android.webkit.ValueCallback<String[]> valueCallback) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.a.a(iX5WebViewBase);
        this.b.onCloseWindow(this.a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(String str, int i2, String str2) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z2, boolean z3, final Message message) {
        WebView webView = this.a;
        webView.getClass();
        final WebView.WebViewTransport webViewTransport = webView.new WebViewTransport();
        Message messageObtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.i.1
            @Override // java.lang.Runnable
            public void run() {
                WebView webView2 = webViewTransport.getWebView();
                if (webView2 != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView2.b());
                }
                message.sendToTarget();
            }
        });
        messageObtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.a, z2, z3, messageObtain);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j2, j3, j4, new a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsAlert(this.a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsBeforeUnload(this.a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsConfirm(this.a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsPrompt(this.a, str, str2, str3, jsPromptResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i2) {
        this.a.a(iX5WebViewBase);
        this.b.onProgressChanged(this.a, i2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j2, long j3, QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j2, j3, new a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedIcon(this.a, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTitle(this.a, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z2) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTouchIconUrl(this.a, str, z2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.a.a(iX5WebViewBase);
        this.b.onRequestFocus(this.a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, int i2, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i2, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, final android.webkit.ValueCallback<Uri[]> valueCallback, final IX5WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.i.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.i.4
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.a.a(iX5WebViewBase);
        return this.b.onShowFileChooser(this.a, valueCallback2, fileChooserParams2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(final android.webkit.ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z2) {
        this.b.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.i.2
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(new Uri[]{uri});
            }
        }, str, str2);
    }
}
