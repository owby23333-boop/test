package com.anythink.expressad.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class BrowserView extends LinearLayout {
    private static final String a = "BrowserView";
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ProgressBar f10728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebView f10729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ToolBar f10730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f10731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f10732g;

    public interface a {
        void a();

        boolean a(WebView webView, String str);

        void b();
    }

    public BrowserView(Context context, c cVar) {
        super(context);
        this.f10732g = cVar;
        init();
    }

    public void destroy() {
        WebView webView = this.f10729d;
        if (webView != null) {
            webView.stopLoading();
            this.f10729d.setWebViewClient(null);
            this.f10729d.destroy();
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f10728c = new ProgressBar(getContext());
        this.f10728c.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f10729d == null) {
                this.f10729d = b();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f10729d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o.b(a, "webview is error", th);
        }
        this.f10730e = new ToolBar(getContext());
        this.f10730e.setLayoutParams(new LinearLayout.LayoutParams(-1, t.b(getContext(), 40.0f)));
        this.f10730e.setBackgroundColor(-1);
        addView(this.f10728c);
        WebView webView = this.f10729d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f10730e);
        this.f10728c.initResource(true);
        this.f10730e.getItem("backward").setEnabled(false);
        this.f10730e.getItem("forward").setEnabled(false);
        this.f10730e.setOnItemClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BrowserView.this.f10729d != null) {
                    BrowserView.this.f10729d.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z2 = false;
                if (TextUtils.equals(str, "backward")) {
                    BrowserView.this.f10730e.getItem("forward").setEnabled(true);
                    if (BrowserView.this.f10729d != null && BrowserView.this.f10729d.canGoBack()) {
                        BrowserView.this.f10729d.goBack();
                    }
                    View item = BrowserView.this.f10730e.getItem("backward");
                    if (BrowserView.this.f10729d != null && BrowserView.this.f10729d.canGoBack()) {
                        z2 = true;
                    }
                    item.setEnabled(z2);
                    return;
                }
                if (TextUtils.equals(str, "forward")) {
                    BrowserView.this.f10730e.getItem("backward").setEnabled(true);
                    if (BrowserView.this.f10729d != null && BrowserView.this.f10729d.canGoForward()) {
                        BrowserView.this.f10729d.goForward();
                    }
                    View item2 = BrowserView.this.f10730e.getItem("forward");
                    if (BrowserView.this.f10729d != null && BrowserView.this.f10729d.canGoForward()) {
                        z2 = true;
                    }
                    item2.setEnabled(z2);
                    return;
                }
                if (!TextUtils.equals(str, "refresh")) {
                    if (!TextUtils.equals(str, "exits") || BrowserView.this.f10731f == null) {
                        return;
                    }
                    BrowserView.this.f10731f.a();
                    return;
                }
                BrowserView.this.f10730e.getItem("backward").setEnabled(BrowserView.this.f10729d != null && BrowserView.this.f10729d.canGoBack());
                View item3 = BrowserView.this.f10730e.getItem("forward");
                if (BrowserView.this.f10729d != null && BrowserView.this.f10729d.canGoForward()) {
                    z2 = true;
                }
                item3.setEnabled(z2);
                if (BrowserView.this.f10729d != null) {
                    BrowserView.this.f10729d.loadUrl(BrowserView.this.b);
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f10729d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(a aVar) {
        this.f10731f = aVar;
    }

    public void setWebView(WebView webView) {
        this.f10729d = webView;
    }

    public static final class DownloadListener implements android.webkit.DownloadListener {
        private c campaignEx;
        private String title;

        public DownloadListener(c cVar) {
            this.campaignEx = cVar;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public DownloadListener() {
        }
    }

    private WebView b() {
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable th) {
                    o.d(a, th.getMessage());
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            try {
                settings.setAllowUniversalAccessFromFileURLs(true);
            } catch (Throwable th2) {
                o.d(a, th2.getMessage());
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
            settings.setDatabaseEnabled(true);
            String path = getContext().getDir("database", 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e3) {
                o.d(a, e3.getMessage());
            }
        } catch (Throwable th3) {
            o.d(a, th3.getMessage());
        }
        webView.setDownloadListener(new DownloadListener(this.f10732g));
        webView.setWebViewClient(new WebViewClient() { // from class: com.anythink.expressad.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                o.b(BrowserView.a, "开始! = ".concat(String.valueOf(str)));
                BrowserView.this.b = str;
                if (BrowserView.this.f10731f != null) {
                    a unused = BrowserView.this.f10731f;
                }
                BrowserView.this.f10728c.setVisible(true);
                BrowserView.this.f10728c.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                o.b(BrowserView.a, "js大跳! = ".concat(String.valueOf(str)));
                BrowserView.this.f10730e.getItem("backward").setEnabled(true);
                BrowserView.this.f10730e.getItem("forward").setEnabled(false);
                if (BrowserView.this.f10731f != null) {
                    BrowserView.this.f10731f.a(webView2, str);
                }
                return false;
            }
        });
        webView.setWebChromeClient(k.d() <= 10 ? new WebChromeClient() { // from class: com.anythink.expressad.foundation.webview.BrowserView.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i2) {
                if (i2 == 100) {
                    BrowserView.this.f10728c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.anythink.expressad.foundation.webview.BrowserView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.f10728c.setVisible(false);
                        }
                    }, 200L);
                }
            }
        } : new WebChromeClient() { // from class: com.anythink.expressad.foundation.webview.BrowserView.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i2) {
                if (i2 == 100) {
                    BrowserView.this.f10728c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.anythink.expressad.foundation.webview.BrowserView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.f10728c.setVisible(false);
                        }
                    }, 200L);
                }
            }
        });
        return webView;
    }

    private void a() {
        this.f10728c = new ProgressBar(getContext());
        this.f10728c.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f10729d == null) {
                this.f10729d = b();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f10729d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o.b(a, "webview is error", th);
        }
        this.f10730e = new ToolBar(getContext());
        this.f10730e.setLayoutParams(new LinearLayout.LayoutParams(-1, t.b(getContext(), 40.0f)));
        this.f10730e.setBackgroundColor(-1);
        addView(this.f10728c);
        WebView webView = this.f10729d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f10730e);
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
