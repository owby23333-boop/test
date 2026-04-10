package com.qmuiteam.qmui.widget.webview;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIWebViewClient extends WebViewClient {
    public static final int JS_FAKE_KEY_CODE_EVENT = 112;
    private boolean mDisableVideoFullscreenBtnAlways;
    private boolean mIsPageFinished = false;
    private boolean mNeedDispatchSafeAreaInset;

    private String getJsCodeForDisableVideoFullscreenBtn() {
        return "(function(){\n   var head = document.getElementsByTagName('head')[0];\n   var style = document.createElement('style');\n   style.type = 'text/css';   style.innerHTML = 'video::-webkit-media-controls-fullscreen-button{display: none !important;}'\n   head.appendChild(style);\n})()";
    }

    private String getJsCodeForFullscreenHtml() {
        return "(function(){\n   document.body.addEventListener('keydown', function(e){\n        if(e.keyCode == 112){\n             var html = document.documentElement;\n             var requestFullscreen = html.requestFullscreen || html.webkitRequestFullscreen;\n             requestFullscreen.call(html);\n        }\n    })\n})()";
    }

    public QMUIWebViewClient(boolean z, boolean z2) {
        this.mNeedDispatchSafeAreaInset = z;
        this.mDisableVideoFullscreenBtnAlways = z2;
    }

    public void setNeedDispatchSafeAreaInset(QMUIWebView qMUIWebView) {
        if (this.mNeedDispatchSafeAreaInset) {
            return;
        }
        this.mNeedDispatchSafeAreaInset = true;
        if (this.mIsPageFinished) {
            dispatchFullscreenRequestAction(qMUIWebView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mIsPageFinished = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.mIsPageFinished = true;
        if (this.mDisableVideoFullscreenBtnAlways) {
            runJsCode(webView, getJsCodeForDisableVideoFullscreenBtn(), null);
        }
        if (this.mNeedDispatchSafeAreaInset && (webView instanceof QMUIWebView)) {
            dispatchFullscreenRequestAction((QMUIWebView) webView);
        }
    }

    private void dispatchFullscreenRequestAction(final QMUIWebView qMUIWebView) {
        if (qMUIWebView.isNotSupportChangeCssEnv()) {
            return;
        }
        if (!this.mDisableVideoFullscreenBtnAlways) {
            runJsCode(qMUIWebView, getJsCodeForDisableVideoFullscreenBtn(), null);
        }
        runJsCode(qMUIWebView, getJsCodeForFullscreenHtml(), new Runnable() { // from class: com.qmuiteam.qmui.widget.webview.QMUIWebViewClient.1
            @Override // java.lang.Runnable
            public void run() {
                QMUIWebViewClient.this.dispatchFullscreenRequestEvent(qMUIWebView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchFullscreenRequestEvent(WebView webView) {
        webView.dispatchKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 131, 0, 0, -1, 0));
    }

    private void runJsCode(WebView webView, String str, final Runnable runnable) {
        if (runnable == null) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.qmuiteam.qmui.widget.webview.QMUIWebViewClient.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                    runnable.run();
                }
            });
        }
    }
}
