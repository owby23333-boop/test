package com.bytedance.sdk.openadsdk.core.widget.z;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.hh.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private WeakReference<Context> z;
    private boolean g = true;
    private boolean dl = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1430a = true;
    private boolean gc = true;
    private boolean m = true;
    private boolean e = true;
    private boolean gz = true;

    public static g z(Context context) {
        return new g(context);
    }

    private g(Context context) {
        this.z = new WeakReference<>(context);
    }

    public g z(boolean z) {
        this.gz = z;
        return this;
    }

    public g g(boolean z) {
        this.dl = z;
        return this;
    }

    public void z(final com.bytedance.sdk.component.i.dl dlVar) {
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.z(dlVar.getWebView());
            }
        });
    }

    public void z(WebView webView) {
        if (webView == null || this.z.get() == null) {
            return;
        }
        g(webView);
        WebSettings settings = webView.getSettings();
        z(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            wp.z(e);
        }
        try {
            if (this.dl) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f1430a);
        settings.setDomStorageEnabled(this.gc);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.e);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.gz = false;
        }
        try {
            if (!this.gz) {
                webView.setLayerType(0, null);
            } else if (this.gz) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }

    private void g(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            wp.dl(th.toString());
        }
    }

    private void z(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            wp.dl(th.toString());
        }
    }

    public static String z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
