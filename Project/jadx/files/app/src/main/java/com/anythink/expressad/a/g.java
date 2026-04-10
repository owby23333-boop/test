package com.anythink.expressad.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.expressad.foundation.h.o;
import com.umeng.message.utils.HttpRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static long a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8073d = "g";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f8074p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f8075q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f8076r = 0;
    boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f8077c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8079f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.expressad.d.a f8081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f8082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f8083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WebView f8085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8086m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f8087n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8088o;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f8090t;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8089s = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f8091u = new Runnable() { // from class: com.anythink.expressad.a.g.4
        @Override // java.lang.Runnable
        public final void run() {
            g.n(g.this);
            g.this.f8088o = 1;
            o.d(g.f8073d, "js超时！超时上限：" + g.this.f8079f + "ms");
            g.p(g.this);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Runnable f8092v = new Runnable() { // from class: com.anythink.expressad.a.g.5
        @Override // java.lang.Runnable
        public final void run() {
            g.n(g.this);
            g.this.f8088o = 2;
            o.d(g.f8073d, "http超时！超时上限：" + g.this.f8078e + "ms");
            g.p(g.this);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f8080g = new Handler(Looper.getMainLooper());

    interface a {
        void a(String str, String str2);

        void a(String str, String str2, String str3);

        boolean a();

        boolean a(String str);

        boolean b(String str);
    }

    public g(boolean z2) {
        this.f8078e = 15000;
        this.f8079f = 3000;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        this.f8081h = com.anythink.expressad.d.b.b();
        if (this.f8081h == null) {
            com.anythink.expressad.d.b.a();
            this.f8081h = com.anythink.expressad.d.b.c();
        }
        this.f8086m = this.f8081h.v();
        if (z2) {
            this.f8078e = (int) this.f8081h.q();
            this.f8079f = (int) this.f8081h.q();
        } else {
            this.f8078e = (int) this.f8081h.r();
            this.f8079f = (int) this.f8081h.r();
        }
    }

    private void c() {
        synchronized (f8073d) {
            try {
                f();
                this.f8085l.destroy();
            } catch (Exception unused) {
                o.d(f8073d, "webview colse to failed");
            } catch (Throwable unused2) {
                o.d(f8073d, "webview colse to failed");
            }
            if (this.f8082i != null) {
                this.f8082i.a(this.f8083j, this.f8087n);
            }
        }
    }

    static /* synthetic */ boolean e(g gVar) {
        gVar.f8090t = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        j();
        h();
    }

    static /* synthetic */ void m(g gVar) {
        gVar.j();
        gVar.f8080g.postDelayed(gVar.f8091u, gVar.f8079f);
    }

    static /* synthetic */ boolean n(g gVar) {
        gVar.f8089s = true;
        return true;
    }

    static /* synthetic */ void p(g gVar) {
        synchronized (f8073d) {
            try {
                gVar.f();
                gVar.f8085l.destroy();
            } catch (Exception unused) {
                o.d(f8073d, "webview colse to failed");
            } catch (Throwable unused2) {
                o.d(f8073d, "webview colse to failed");
            }
            if (gVar.f8082i != null) {
                gVar.f8082i.a(gVar.f8083j, gVar.f8087n);
            }
        }
    }

    private void b() {
        synchronized (f8073d) {
            try {
                f();
            } catch (Exception unused) {
                o.d(f8073d, "webview colse to failed");
            } catch (Throwable unused2) {
                o.d(f8073d, "webview colse to failed");
            }
            if (this.f8082i != null) {
                this.f8082i.a(this.f8083j, this.f8087n);
            }
        }
    }

    private void d() {
        h();
        this.f8080g.postDelayed(this.f8092v, this.f8078e);
    }

    private void e() {
        j();
        this.f8080g.postDelayed(this.f8091u, this.f8079f);
    }

    private void g() {
        this.f8080g.postDelayed(this.f8092v, this.f8078e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f8080g.removeCallbacks(this.f8092v);
    }

    private void i() {
        this.f8080g.postDelayed(this.f8091u, this.f8079f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f8080g.removeCallbacks(this.f8091u);
    }

    static /* synthetic */ void f(g gVar) {
        gVar.h();
        gVar.f8080g.postDelayed(gVar.f8092v, gVar.f8078e);
    }

    public final void a(String str, String str2, String str3, Context context, String str4, String str5, a aVar) {
        if (aVar != null) {
            this.f8084k = str5;
            this.f8083j = str4;
            this.f8082i = aVar;
            a(str, str2, str3, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    static /* synthetic */ void c(g gVar) {
        synchronized (f8073d) {
            try {
                gVar.f();
            } catch (Exception unused) {
                o.d(f8073d, "webview colse to failed");
            } catch (Throwable unused2) {
                o.d(f8073d, "webview colse to failed");
            }
            if (gVar.f8082i != null) {
                gVar.f8082i.a(gVar.f8083j, gVar.f8087n);
            }
        }
    }

    public final void a(String str, String str2, String str3, Context context, String str4, a aVar) {
        if (aVar != null) {
            this.f8083j = str4;
            this.f8082i = aVar;
            a(str, str2, str3, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    private void a(final String str, final String str2, final String str3, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str2, str3, context, this.f8083j);
        } else {
            this.f8080g.post(new Runnable() { // from class: com.anythink.expressad.a.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar = g.this;
                    gVar.a(str2, str3, context, gVar.f8083j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.f8084k)) {
                this.f8085l.getSettings().setDefaultTextEncodingName(com.anythink.expressad.foundation.g.a.bN);
                this.f8079f = 2000;
                this.f8078e = 2000;
                o.b(f8073d, this.f8084k);
                this.f8085l.loadDataWithBaseURL(str3, this.f8084k, "*/*", com.anythink.expressad.foundation.g.a.bN, str3);
                return;
            }
            if (this.f8086m) {
                HashMap map = new HashMap();
                if (this.f8085l.getUrl() != null) {
                    map.put(HttpRequest.HEADER_REFERER, this.f8085l.getUrl());
                }
                this.f8085l.loadUrl(str3, map);
                return;
            }
            this.f8085l.loadUrl(str3);
        } catch (Throwable th) {
            try {
                if (this.f8082i != null) {
                    this.f8082i.a(this.f8083j, th.getMessage(), this.f8087n);
                }
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(Context context, final String str, final String str2) {
        this.f8085l = new WebView(context);
        this.f8085l.getSettings().setJavaScriptEnabled(true);
        this.f8085l.getSettings().setCacheMode(2);
        this.f8085l.getSettings().setLoadsImagesAutomatically(false);
        this.f8085l.setWebViewClient(new WebViewClient() { // from class: com.anythink.expressad.a.g.2
            private boolean a() {
                g gVar = g.this;
                return gVar.b || gVar.f8077c;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str3) {
                super.onPageFinished(webView, str3);
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str3, Bitmap bitmap) {
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (g.this.f8090t) {
                        g.this.f8088o = 0;
                        g.c(g.this);
                        return;
                    }
                    g.this.f8077c = false;
                    if (webView.getTag() == null) {
                        webView.setTag("has_first_started");
                    } else {
                        g.this.b = true;
                    }
                    synchronized (g.f8073d) {
                        String str4 = "加载页面-开始：";
                        if (g.this.b || g.this.f8077c) {
                            str4 = "加载页面-开始：（重定向）";
                        }
                        if (URLUtil.isHttpsUrl(str3)) {
                            o.d(g.f8073d, str4 + str3);
                        } else {
                            o.b(g.f8073d, str4 + str3);
                        }
                        g.this.f8083j = str3;
                        if (g.this.f8082i == null || !g.this.f8082i.a(str3)) {
                            g.f(g.this);
                        } else {
                            g.e(g.this);
                            g.c(g.this);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i2, String str3, String str4) {
                o.b(g.f8073d, "onReceivedError: errno = " + i2 + ", url: " + webView.getUrl() + ",\n onReceivedError：, description: " + str3 + ", failingUrl: " + str4);
                synchronized (g.f8073d) {
                    g.e(g.this);
                    g.this.f();
                    g.c(g.this);
                }
                if (g.this.f8082i != null) {
                    g.this.f8082i.a(webView.getUrl(), str3, g.this.f8087n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    o.a(g.f8073d, "onReceivedSslError IS_SP_CBT_CF:" + com.anythink.expressad.a.f7973q);
                    if (com.anythink.expressad.a.f7973q && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    TextUtils.isEmpty(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str3) {
                synchronized (g.f8073d) {
                    o.a(g.f8073d, "override js跳转：".concat(String.valueOf(str3)));
                    g.this.f8077c = true;
                    g.this.j();
                    if (g.this.f8090t) {
                        g.this.h();
                        g.c(g.this);
                        return true;
                    }
                    g.this.f8083j = str3;
                    if (g.this.f8082i != null && g.this.f8082i.b(str3)) {
                        g.e(g.this);
                        g.this.h();
                        g.c(g.this);
                        return true;
                    }
                    if (g.this.f8086m) {
                        HashMap map = new HashMap();
                        if (g.this.f8085l.getUrl() != null) {
                            map.put(HttpRequest.HEADER_REFERER, g.this.f8085l.getUrl());
                        }
                        g.this.f8085l.loadUrl(str3, map);
                    } else {
                        g.this.f8085l.loadUrl(str3);
                    }
                    return true;
                }
            }
        });
        this.f8085l.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.expressad.a.g.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView, String str3, String str4, String str5, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i2) {
                if (i2 == 100) {
                    try {
                        o.b(g.f8073d, "加载页面-进度完成：" + webView.getUrl());
                        webView.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!g.this.f8090t && !g.this.f8077c) {
                            g.m(g.this);
                        }
                        if (g.this.f8082i != null) {
                            a aVar = g.this.f8082i;
                            webView.getUrl();
                            aVar.a();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }
}
