package com.bytedance.sdk.component.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class lc extends e {
    static final /* synthetic */ boolean m = true;
    protected String v;
    protected WebView zk;

    @Override // com.bytedance.sdk.component.e.e
    public void bf() {
        super.bf();
        tg();
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void d() {
        if (!m && this.zk == null) {
            throw new AssertionError();
        }
        this.zk.addJavascriptInterface(this, this.v);
    }

    @Override // com.bytedance.sdk.component.e.e
    public String e() {
        return this.zk.getUrl();
    }

    @Override // com.bytedance.sdk.component.e.e
    public Context getContext(m mVar) {
        Context context = mVar.ga;
        if (context != null) {
            return context;
        }
        WebView webView = mVar.e;
        if (webView != null) {
            return webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.e.e
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    public void tg() {
        this.zk.removeJavascriptInterface(this.v);
    }

    @Override // com.bytedance.sdk.component.e.e
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void e(m mVar) {
        this.zk = mVar.e;
        this.v = mVar.d;
        if (mVar.t) {
            return;
        }
        d();
    }

    @Override // com.bytedance.sdk.component.e.e
    public void e(String str, l lVar) {
        if (lVar != null && !TextUtils.isEmpty(lVar.v)) {
            String str2 = lVar.v;
            e(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.e(str, lVar);
    }

    @Override // com.bytedance.sdk.component.e.e
    public void e(String str) {
        e(str, "javascript:" + this.v + "._handleMessageFromToutiao(" + str + ")");
    }

    private void e(String str, final String str2) {
        if (this.vn || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.e.lc.1
            @Override // java.lang.Runnable
            public void run() {
                if (lc.this.vn) {
                    return;
                }
                try {
                    zk.e("Invoking Jsb using evaluateJavascript: " + str2);
                    lc.this.zk.evaluateJavascript(str2, null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            zk.e("Received call on sub-thread, posting to main thread: " + str2);
            this.tg.post(runnable);
            return;
        }
        runnable.run();
    }
}
