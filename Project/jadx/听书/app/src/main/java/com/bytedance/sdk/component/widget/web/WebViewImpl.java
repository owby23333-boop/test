package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.i.dl;
import com.bytedance.sdk.component.i.g;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.widget.SSWebView;
import com.funny.audio.core.utils.FileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewImpl extends BaseWebView implements dl {
    private static boolean gk;
    private volatile boolean lq;
    private final com.bytedance.sdk.component.i.z mc;
    private Map<String, z> x;

    private void dl(Context context) {
    }

    private static Context z(Context context) {
        return context;
    }

    @Override // com.bytedance.sdk.component.i.dl
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.component.i.dl
    public WebView getWebView() {
        return this;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public WebViewImpl(com.bytedance.sdk.component.i.z zVar, Context context) {
        super(z(context));
        this.lq = false;
        this.mc = zVar;
        g(context);
    }

    public WebViewImpl(com.bytedance.sdk.component.i.z zVar, Context context, AttributeSet attributeSet) {
        super(z(context), attributeSet);
        this.lq = false;
        this.mc = zVar;
        g(context);
    }

    public WebViewImpl(com.bytedance.sdk.component.i.z zVar, Context context, AttributeSet attributeSet, int i) {
        super(z(context), attributeSet, i);
        this.lq = false;
        this.mc = zVar;
        g(context);
    }

    private void g(Context context) {
        dl(context);
        a();
        dl();
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public Map<String, z> getJavascriptInterfaces() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public com.bytedance.sdk.component.widget.g getClient() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public WebChromeClient getChromeClient() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public void g() {
        super.g();
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebSettings settings = WebViewImpl.this.getSettings();
                    WebViewImpl.this.removeAllViews();
                    WebViewImpl.this.stopLoading();
                    WebViewImpl.this.setWebChromeClient(null);
                    WebViewImpl.this.setWebViewClient(null);
                    WebViewImpl.this.setDownloadListener(null);
                    settings.setJavaScriptEnabled(true);
                    settings.setAppCacheEnabled(false);
                    settings.setSupportZoom(false);
                    settings.setUseWideViewPort(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setDomStorageEnabled(true);
                    settings.setBuiltInZoomControls(false);
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    settings.setLoadWithOverviewMode(false);
                    settings.setDefaultTextEncodingName("UTF-8");
                    settings.setDefaultFontSize(16);
                    if (WebViewImpl.this.x != null) {
                        Iterator it = WebViewImpl.this.x.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.this.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.x = null;
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void setNetworkAvailable(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.l = Boolean.valueOf(z);
                    WebViewImpl.super.setNetworkAvailable(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String str, final Map<String, String> map) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str, map);
                    if (WebViewImpl.this.g != null) {
                        WebViewImpl.this.g.z(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void loadUrl(final String str) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str);
                    if (WebViewImpl.this.g != null) {
                        WebViewImpl.this.g.z(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void postUrl(final String str, final byte[] bArr) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.postUrl(str, bArr);
                    if (WebViewImpl.this.g != null) {
                        WebViewImpl.this.g.z(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadData(final String str, final String str2, final String str3) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.loadData(str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.stopLoading();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.reload();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public boolean canGoBack() {
        if (!z()) {
            return false;
        }
        try {
            return super.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void goBack() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBack();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goForward();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void onResume() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                WebViewImpl.super.onResume();
            }
        });
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i) {
        try {
            return super.canGoBackOrForward(i);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(final int i) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBackOrForward(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public String getUrl() {
        if (z()) {
            try {
                return super.getUrl();
            } catch (Throwable unused) {
            }
        }
        if (this.g != null) {
            return this.g.g();
        }
        return null;
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public int getProgress() {
        if (z()) {
            try {
                return super.getProgress();
            } catch (Throwable unused) {
                return 100;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.6
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getProgress();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public int getContentHeight() {
        if (z()) {
            try {
                return super.getContentHeight();
            } catch (Throwable unused) {
                return 1;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.7
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getContentHeight();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void clearCache(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearCache(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearFormData();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void clearHistory() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearHistory();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void setWebViewClient(final WebViewClient webViewClient) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewClient webViewClientZ = webViewClient;
                    if (webViewClientZ == null) {
                        webViewClientZ = new SSWebView.z();
                    } else if (webViewClientZ instanceof com.bytedance.sdk.component.widget.g) {
                        webViewClientZ = ((com.bytedance.sdk.component.widget.g) webViewClientZ).z();
                    }
                    WebViewImpl.this.g = new com.bytedance.sdk.component.widget.g(webViewClientZ);
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebViewImpl.super.setWebViewClient(webViewImpl.g);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void setDownloadListener(final DownloadListener downloadListener) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f846a = downloadListener;
                    WebViewImpl.super.setDownloadListener(downloadListener);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.dl = webChromeClient;
                    WebViewImpl.super.setWebChromeClient(webChromeClient);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.i.dl
    public void setBackgroundColor(final int i) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.gc = Integer.valueOf(i);
                    WebViewImpl.super.setBackgroundColor(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.i.dl
    public void computeScroll() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.computeScroll();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.i.dl
    public void setLayerType(final int i, final Paint paint) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setLayerType(i, paint);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.i.dl
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        gz.g().post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setOverScrollMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void dl() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void addJavascriptInterface(final Object obj, final String str) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.x == null) {
                        WebViewImpl.this.x = new HashMap();
                    }
                    g gVar = new g(obj, str, WebViewImpl.this.mc, WebViewImpl.this);
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.addJavascriptInterface(gVar, str);
                    WebViewImpl.this.x.put(str, gVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setJavaScriptEnabled(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.hh = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDisplayZoomControls(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.sy = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDisplayZoomControls(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setCacheMode(final int i) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.uf = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setCacheMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void a() {
        try {
            WebSettings settings = getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = getSettings()) == null || gk) {
                return;
            }
            if (Uri.parse(str).getScheme().equals(FileUtils.URI_TYPE_FILE)) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void onPause() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.onPause();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public String getUserAgentString() {
        if (z()) {
            try {
                return getSettings().getUserAgentString();
            } catch (Throwable unused) {
                return "";
            }
        }
        final Object obj = new Object();
        final String[] strArr = {""};
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.25
            @Override // java.lang.Runnable
            public void run() {
                strArr[0] = WebViewImpl.this.getSettings().getUserAgentString();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                synchronized (obj) {
                    obj.wait(5000L);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return strArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.evaluateJavascript(str, valueCallback);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView, android.webkit.WebView
    public void destroy() {
        if (this.lq) {
            return;
        }
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.lq) {
                        return;
                    }
                    WebViewImpl.this.g();
                    if (WebViewImpl.this.x != null) {
                        Iterator it = WebViewImpl.this.x.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.super.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.x = null;
                    }
                    WebViewImpl.super.destroy();
                    WebViewImpl.this.hashCode();
                    WebViewImpl.this.mc.hashCode();
                    WebViewImpl.this.lq = true;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void removeJavascriptInterface(final String str) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.lq) {
                        return;
                    }
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.removeJavascriptInterface(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAppCacheEnabled(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.io = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAppCacheEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setSupportZoom(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.iq = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSupportZoom(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setUseWideViewPort(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.zw = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setUseWideViewPort(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.q = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDomStorageEnabled(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.tb = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDomStorageEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setBuiltInZoomControls(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.js = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBuiltInZoomControls(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.fv = layoutAlgorithm;
                    WebViewImpl.this.getSettings().setLayoutAlgorithm(layoutAlgorithm);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setLoadWithOverviewMode(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.p = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setLoadWithOverviewMode(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setUserAgentString(final String str) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.getSettings().setUserAgentString(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDefaultTextEncodingName(final String str) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ls = str;
                    WebViewImpl.this.getSettings().setDefaultTextEncodingName(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDefaultFontSize(final int i) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.pf = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setDefaultFontSize(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setMixedContentMode(final int i) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.v = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setMixedContentMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDatabaseEnabled(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.i = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setDatabaseEnabled(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setVisibility(final int i) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setVisibility(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setAlpha(final float f) {
        super.setAlpha(f);
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setAlpha(f);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAllowFileAccess(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.wp = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccess(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void clearView() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearView();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void pauseTimers() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.pauseTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.i.dl
    public void resumeTimers() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.resumeTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.ViewGroup, com.bytedance.sdk.component.i.dl
    public void removeAllViews() {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.removeAllViews();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setBlockNetworkImage(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.kb = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setBlockNetworkImage(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.uy = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowFileAccessFromFileURLs(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.fo = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setAllowUniversalAccessFromFileURLs(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setSavePassword(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.gz = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setSavePassword(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.e = Boolean.valueOf(z);
                    WebViewImpl.this.getSettings().setMediaPlaybackRequiresUserGesture(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        z(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.m = onScrollChangeListener;
                    WebViewImpl.super.setOnScrollChangeListener(onScrollChangeListener);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void z(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, str2);
            jSONObject.putOpt("param", obj);
            g(str, "csjEventListener", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.i.g
    public void setTouchEventListener(g.z zVar) {
        this.h = zVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Pair<Boolean, Boolean> pairZ;
        if (this.h != null && (pairZ = this.h.z(this, motionEvent)) != null && ((Boolean) pairZ.first).booleanValue()) {
            return ((Boolean) pairZ.second).booleanValue();
        }
        return super.onTouchEvent(motionEvent);
    }
}
