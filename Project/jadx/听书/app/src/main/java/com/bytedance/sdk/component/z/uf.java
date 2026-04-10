package com.bytedance.sdk.component.z;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class uf extends z {
    static final /* synthetic */ boolean uy = true;
    protected com.bytedance.sdk.component.i.dl fo;
    protected String gz;

    @Override // com.bytedance.sdk.component.z.z
    protected Context getContext(uy uyVar) {
        if (uyVar.gc != null) {
            return uyVar.gc;
        }
        if (uyVar.z != null) {
            View view = uyVar.z.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = uyVar.z.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.z.z
    protected String z() {
        return this.fo.getUrl();
    }

    @Override // com.bytedance.sdk.component.z.z
    protected void z(uy uyVar) {
        this.fo = uyVar.z;
        this.gz = uyVar.dl;
        if (uyVar.v) {
            return;
        }
        dl();
    }

    private void z(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f867a.post(runnable);
        }
    }

    protected void dl() {
        if (!uy && this.fo == null) {
            throw new AssertionError();
        }
        com.bytedance.sdk.component.i.dl dlVar = this.fo;
        if (dlVar != null) {
            dlVar.addJavascriptInterface(this, this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.z.z
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.z.z
    protected void g() {
        super.g();
        a();
    }

    protected void a() {
        com.bytedance.sdk.component.i.dl dlVar = this.fo;
        if (dlVar != null) {
            dlVar.removeJavascriptInterface(this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.z.z
    protected void z(String str, ls lsVar) {
        if (lsVar != null && !TextUtils.isEmpty(lsVar.gz)) {
            String str2 = lsVar.gz;
            z(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.z(str, lsVar);
    }

    @Override // com.bytedance.sdk.component.z.z
    protected void z(String str) {
        z(str, "javascript:" + this.gz + "._handleMessageFromToutiao(" + str + ")");
    }

    private void z(String str, final String str2) {
        if (this.m || TextUtils.isEmpty(str2)) {
            return;
        }
        z(new Runnable() { // from class: com.bytedance.sdk.component.z.uf.1
            @Override // java.lang.Runnable
            public void run() {
                if (uf.this.m) {
                    return;
                }
                try {
                    fo.z("Invoking Jsb using evaluateJavascript: " + str2);
                    uf.this.fo.evaluateJavascript(str2, null);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        });
    }
}
