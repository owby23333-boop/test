package com.anythink.expressad.splash.c;

import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.splash.js.SplashJSBridgeImpl;
import com.anythink.expressad.splash.js.SplashJsUtils;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.splash.view.ATSplashWebview;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String a = "WebViewRenderManager";
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11310c;

    static class a {
        private static final e a = new e(0);

        a() {
        }
    }

    public interface b {
        void a();

        void a(int i2);

        void a(String str);
    }

    public static class c {
        private String a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f11313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11315e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11316f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f11317g;

        private boolean g() {
            return this.f11317g;
        }

        public final void a(boolean z2) {
            this.f11317g = z2;
        }

        public final String b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }

        public final com.anythink.expressad.foundation.d.c d() {
            return this.f11313c;
        }

        public final boolean e() {
            return this.f11315e;
        }

        public final int f() {
            return this.f11316f;
        }

        public final String a() {
            return this.f11314d;
        }

        public final void b(String str) {
            this.a = str;
        }

        public final void c(String str) {
            this.b = str;
        }

        public final void a(String str) {
            this.f11314d = str;
        }

        public final void b(boolean z2) {
            this.f11315e = z2;
        }

        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            this.f11313c = cVar;
        }

        public final void a(int i2) {
            this.f11316f = i2;
        }
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    static /* synthetic */ boolean a(e eVar) {
        eVar.f11310c = true;
        return true;
    }

    private static e b() {
        return a.a;
    }

    private e() {
        this.b = false;
        this.f11310c = false;
    }

    public final void a() {
        this.b = false;
        this.f11310c = false;
    }

    public final void a(final ATSplashView aTSplashView, c cVar, final b bVar) {
        String strZ;
        if (aTSplashView != null) {
            String strC = cVar.c();
            String strB = cVar.b();
            final com.anythink.expressad.foundation.d.c cVarD = cVar.d();
            String strA = cVar.a();
            boolean zE = cVar.e();
            int iF = cVar.f();
            ATSplashWebview splashWebview = aTSplashView.getSplashWebview();
            if (splashWebview == null) {
                return;
            }
            SplashJSBridgeImpl splashJSBridgeImpl = new SplashJSBridgeImpl(aTSplashView.getContext(), strB, strC);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVarD);
            splashJSBridgeImpl.setCampaignList(arrayList);
            splashJSBridgeImpl.setAllowSkip(zE ? 1 : 0);
            splashJSBridgeImpl.setCountdownS(iF);
            aTSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
            if (TextUtils.isEmpty(cVarD.Z())) {
                strZ = cVarD.aa();
            } else {
                strZ = cVarD.Z();
            }
            String requestId = splashWebview.getRequestId();
            o.d(a, "CampaignEx RequestId = " + strZ + " WebView RequestId = " + requestId);
            if (!TextUtils.isEmpty(requestId) && requestId.equals(strZ) && (this.b || this.f11310c)) {
                aTSplashView.setH5Ready(true);
                if (bVar != null) {
                    bVar.a(1);
                    return;
                }
                return;
            }
            a();
            splashWebview.setRequestId(strZ);
            System.currentTimeMillis();
            splashWebview.setWebViewListener(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.splash.c.e.1
                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    e.a(e.this);
                    if (!cVarD.s()) {
                        aTSplashView.setH5Ready(true);
                        o.a("WindVaneWebView", "======渲染成功：finish");
                    }
                    SplashJsUtils.fireOnJSBridgeConnected(webView);
                }

                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void onReceivedError(WebView webView, int i2, String str, String str2) {
                    super.onReceivedError(webView, i2, str, str2);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(str);
                    }
                    e.this.a();
                    aTSplashView.setH5Ready(false);
                    o.a("WindVaneWebView", "======渲染失败");
                }

                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(sslError.toString());
                    }
                    e.this.a();
                    aTSplashView.setH5Ready(false);
                    o.a("WindVaneWebView", "======渲染失败");
                }

                @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                public final void readyState(WebView webView, int i2) {
                    super.readyState(webView, i2);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(i2);
                    }
                    if (i2 == 1) {
                        e.this.b = true;
                        aTSplashView.setH5Ready(true);
                        o.a("WindVaneWebView", "======渲染成功：ready");
                    } else {
                        e.this.b = false;
                        aTSplashView.setH5Ready(false);
                        o.a("WindVaneWebView", "======渲染失败");
                    }
                }
            });
            if (!splashWebview.isDestroyed()) {
                o.a(a, "======开始渲染：".concat(String.valueOf(strA)));
                splashWebview.loadUrl(strA);
            } else {
                aTSplashView.setH5Ready(false);
            }
        }
    }
}
