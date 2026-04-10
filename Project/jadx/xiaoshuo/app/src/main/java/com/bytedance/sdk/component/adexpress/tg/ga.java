package com.bytedance.sdk.component.adexpress.tg;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.e.lc;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    private static int ga = 10;
    private static volatile ga p;
    private static final byte[] tg = new byte[0];
    private final AtomicBoolean vn = new AtomicBoolean(false);
    private List<SSWebView> e = new ArrayList();
    private Map<Integer, d> bf = new HashMap();
    private Map<Integer, tg> d = new HashMap();

    private ga() {
        com.bytedance.sdk.component.adexpress.e.e.d dVarD = com.bytedance.sdk.component.adexpress.e.e.e.e().d();
        if (dVarD != null) {
            ga = dVarD.zk();
        }
    }

    public static ga e() {
        if (p == null) {
            synchronized (ga.class) {
                if (p == null) {
                    p = new ga();
                }
            }
        }
        return p;
    }

    public SSWebView bf() {
        SSWebView sSWebViewRemove;
        if (tg() <= 0 || (sSWebViewRemove = this.e.remove(0)) == null) {
            return null;
        }
        wu.bf("WebViewPool", "get WebView from pool; current available count: " + tg());
        return sSWebViewRemove;
    }

    public boolean d(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        wu.bf("WebViewPool", "WebView render fail and abandon");
        sSWebView.m();
        return true;
    }

    public int ga() {
        return this.e.size();
    }

    public int tg() {
        return this.e.size();
    }

    private void ga(SSWebView sSWebView) {
        sSWebView.removeAllViews();
        sSWebView.tg();
        sSWebView.setWebChromeClient(null);
        sSWebView.setWebViewClient(null);
        sSWebView.setDownloadListener(null);
        sSWebView.setJavaScriptEnabled(true);
        sSWebView.setAppCacheEnabled(false);
        sSWebView.setSupportZoom(false);
        sSWebView.setUseWideViewPort(true);
        sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.setDomStorageEnabled(true);
        sSWebView.setBuiltInZoomControls(false);
        sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        sSWebView.setLoadWithOverviewMode(false);
        sSWebView.setUserAgentString("android_client");
        sSWebView.setDefaultTextEncodingName("UTF-8");
        sSWebView.setDefaultFontSize(16);
    }

    public void tg(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        d dVar = this.bf.get(Integer.valueOf(sSWebView.hashCode()));
        if (dVar != null) {
            dVar.e(null);
        }
        sSWebView.bf("SDK_INJECT_GLOBAL");
    }

    public void d() {
        for (SSWebView sSWebView : this.e) {
            if (sSWebView != null) {
                sSWebView.m();
            }
        }
        this.e.clear();
    }

    public void bf(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.e.size() >= ga) {
            wu.bf("WebViewPool", "WebView pool is full，destroy webview");
            sSWebView.m();
        } else {
            if (this.e.contains(sSWebView)) {
                return;
            }
            this.e.add(sSWebView);
            wu.bf("WebViewPool", "recycle WebView，current available count: " + tg());
        }
    }

    @UiThread
    public void e(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        ga(sSWebView);
        sSWebView.bf("SDK_INJECT_GLOBAL");
        tg(sSWebView);
        bf(sSWebView);
    }

    @SuppressLint({"JavascriptInterface"})
    public void e(SSWebView sSWebView, bf bfVar) {
        if (sSWebView == null || bfVar == null) {
            return;
        }
        d dVar = this.bf.get(Integer.valueOf(sSWebView.hashCode()));
        if (dVar != null) {
            dVar.e(bfVar);
        } else {
            dVar = new d(bfVar);
            this.bf.put(Integer.valueOf(sSWebView.hashCode()), dVar);
        }
        sSWebView.e(dVar, "SDK_INJECT_GLOBAL");
    }

    @SuppressLint({"JavascriptInterface"})
    public void e(WebView webView, lc lcVar, String str) {
        if (webView == null || lcVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        tg tgVar = this.d.get(Integer.valueOf(webView.hashCode()));
        if (tgVar != null) {
            tgVar.e(lcVar);
        } else {
            tgVar = new tg(lcVar);
            this.d.put(Integer.valueOf(webView.hashCode()), tgVar);
        }
        webView.addJavascriptInterface(tgVar, str);
    }

    public void e(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        tg tgVar = this.d.get(Integer.valueOf(webView.hashCode()));
        if (tgVar != null) {
            tgVar.e(null);
        }
        webView.removeJavascriptInterface(str);
    }
}
