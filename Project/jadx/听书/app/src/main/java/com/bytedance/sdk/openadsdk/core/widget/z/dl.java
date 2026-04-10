package com.bytedance.sdk.openadsdk.core.widget.z;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.lq;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends WebChromeClient {
    private static final String z = WebChromeClient.class.getSimpleName();
    private gc dl;
    private final mc g;

    public dl(mc mcVar) {
        this.g = mcVar;
    }

    public dl(mc mcVar, gc gcVar) {
        this.g = mcVar;
        this.dl = gcVar;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            z(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !z(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    private boolean z(String str) {
        uy.ls().t();
        try {
            Uri uri = Uri.parse(str);
            if (!"bytedance".equals(uri.getScheme().toLowerCase())) {
                return false;
            }
            q.z(uri, this.g);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        gc gcVar;
        super.onProgressChanged(webView, i);
        gc gcVar2 = this.dl;
        if (gcVar2 != null) {
            gcVar2.z(webView, i);
        }
        if (i <= 90 || (gcVar = this.dl) == null) {
            return;
        }
        gcVar.z(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!lq.z(this.g, 1, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!lq.z(this.g, 2, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!lq.z(this.g, 3, str2)) {
            return false;
        }
        jsPromptResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!lq.z(this.g, 4, str2)) {
            return false;
        }
        jsResult.confirm();
        return true;
    }
}
