package com.bytedance.sdk.openadsdk.core.widget.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.wu;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private WeakReference<Context> e;
    private boolean bf = true;
    private boolean d = true;
    private boolean tg = true;
    private boolean ga = true;
    private boolean vn = true;
    private boolean p = true;
    private boolean v = true;

    private bf(Context context) {
        this.e = new WeakReference<>(context);
    }

    public static bf e(Context context) {
        return new bf(context);
    }

    public bf bf(boolean z) {
        this.d = z;
        return this;
    }

    private void bf(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            wu.d(th.toString());
        }
    }

    public bf e(boolean z) {
        this.v = z;
        return this;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void e(WebView webView) {
        if (webView == null || this.e.get() == null) {
            return;
        }
        bf(webView);
        WebSettings settings = webView.getSettings();
        e(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.tg);
        settings.setDomStorageEnabled(this.ga);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.p);
        settings.setDisplayZoomControls(false);
        try {
            boolean z = this.v;
            if (!z) {
                webView.setLayerType(0, null);
            } else if (z) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void e(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            wu.d(th.toString());
        }
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
