package com.anythink.core.basead.ui.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.anythink.core.common.b.p;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.u;
import com.kwai.sodler.lib.ext.PluginError;

/* JADX INFO: loaded from: classes2.dex */
public class BaseWebView extends WebView {
    private static boolean b = false;
    protected boolean a;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        com.anythink.core.basead.ui.a.a.a(this);
        g.a(this);
        if (b) {
            return;
        }
        Context context2 = getContext();
        if (Build.VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context2.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = PluginError.ERROR_UPD_CAPACITY;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = 8388659;
            ((WindowManager) context2.getSystemService("window")).addView(webView, layoutParams);
        }
        b = true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAppCacheEnabled(true);
        getSettings().setAppCachePath(getContext().getCacheDir().getAbsolutePath());
    }

    private void b() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.a) {
            return;
        }
        this.a = true;
        u.a(this);
        removeAllViews();
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(this, p.a(getContext()).b());
        }
    }

    private static void a(Context context) {
        if (Build.VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = PluginError.ERROR_UPD_CAPACITY;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = 8388659;
            ((WindowManager) context.getSystemService("window")).addView(webView, layoutParams);
        }
    }
}
