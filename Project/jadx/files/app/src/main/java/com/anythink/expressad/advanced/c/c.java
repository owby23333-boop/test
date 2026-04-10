package com.anythink.expressad.advanced.c;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.foundation.h.o;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static String a = "ResManager";
    private static int b = 1;

    public interface a {
        void a();

        void b();
    }

    private static com.anythink.expressad.foundation.d.c a(com.anythink.expressad.foundation.d.c cVar) {
        if (!TextUtils.isEmpty(cVar.c()) || (!TextUtils.isEmpty(cVar.d()) && cVar.d().contains("<MBTPLMARK>"))) {
            cVar.a(true);
            cVar.b(false);
        } else {
            cVar.a(false);
            cVar.b(true);
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e3 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.anythink.expressad.advanced.view.ATNativeAdvancedView r12, com.anythink.expressad.foundation.d.c r13, java.lang.String r14, java.lang.String r15, int r16, com.anythink.expressad.advanced.c.c.a r17) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.advanced.c.c.a(com.anythink.expressad.advanced.view.ATNativeAdvancedView, com.anythink.expressad.foundation.d.c, java.lang.String, java.lang.String, int, com.anythink.expressad.advanced.c.c$a):boolean");
    }

    private static void a(ATNativeAdvancedView aTNativeAdvancedView, String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, int i2) {
        a(aTNativeAdvancedView, str, cVar, str2, str3, i2, null);
    }

    private static void a(final ATNativeAdvancedView aTNativeAdvancedView, final String str, final com.anythink.expressad.foundation.d.c cVar, String str2, String str3, int i2, final a aVar) {
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new NativeAdvancedJSBridgeImpl(aTNativeAdvancedView.getContext(), str2, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(i2);
        aTNativeAdvancedView.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        final ATNativeAdvancedWebview advancedNativeWebview = aTNativeAdvancedView.getAdvancedNativeWebview();
        System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.advanced.c.c.1
            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(WebView webView, String str4) {
                super.onPageFinished(webView, str4);
                if (!cVar.s()) {
                    com.anythink.expressad.advanced.a.a.a(cVar.Z());
                    aTNativeAdvancedView.setH5Ready(true);
                    o.a("WindVaneWebView", "======渲染成功：finish");
                }
                NativeAdvancedJsUtils.fireOnJSBridgeConnected(webView);
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(WebView webView, int i3, String str4, String str5) {
                super.onReceivedError(webView, i3, str4, str5);
                aTNativeAdvancedView.setH5Ready(false);
                o.a("WindVaneWebView", "======渲染失败");
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                aTNativeAdvancedView.setH5Ready(false);
                o.a("WindVaneWebView", "======渲染失败");
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void readyState(WebView webView, int i3) {
                super.readyState(webView, i3);
                if (i3 == 1) {
                    com.anythink.expressad.advanced.a.a.a(cVar.Z());
                    aTNativeAdvancedView.setH5Ready(true);
                    o.a("WindVaneWebView", "======渲染成功：ready");
                } else {
                    aTNativeAdvancedView.setH5Ready(false);
                    o.a("WindVaneWebView", "======渲染失败");
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
        if (!advancedNativeWebview.isDestroyed()) {
            o.a(a, "======开始渲染：".concat(String.valueOf(str)));
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anythink.expressad.advanced.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    advancedNativeWebview.loadUrl(str);
                }
            });
        } else {
            aTNativeAdvancedView.setH5Ready(false);
        }
    }

    private static String a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            return "file:///" + file.getAbsolutePath();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e2) {
                e2.getMessage();
                return "";
            }
        }
    }

    public static boolean a(ATNativeAdvancedView aTNativeAdvancedView, com.anythink.expressad.foundation.d.c cVar) {
        boolean z2 = false;
        if (aTNativeAdvancedView == null) {
            o.d(a, "mbAdvancedNativeView  is null");
            return false;
        }
        boolean zB = true;
        if (!TextUtils.isEmpty(cVar.S())) {
            zB = aTNativeAdvancedView.isVideoReady();
            o.d(a, "======isReady isVideoReady:".concat(String.valueOf(zB)));
        }
        if (zB && !TextUtils.isEmpty(cVar.c())) {
            zB = com.anythink.expressad.advanced.a.a.b(cVar.Z());
            o.d(a, "======isReady getAdZip:" + zB + "---requestId:" + cVar.Z());
        }
        if (zB && TextUtils.isEmpty(cVar.c()) && !TextUtils.isEmpty(cVar.d())) {
            zB = com.anythink.expressad.advanced.a.a.b(cVar.Z());
            o.d(a, "======isReady getAdHtml:".concat(String.valueOf(zB)));
        }
        if (TextUtils.isEmpty(cVar.c()) && TextUtils.isEmpty(cVar.d())) {
            o.d(a, "======isReady getAdHtml  getAdZip all are empty");
        } else {
            z2 = zB;
        }
        if (!z2 || TextUtils.isEmpty(cVar.I())) {
            return z2;
        }
        boolean zIsEndCardReady = aTNativeAdvancedView.isEndCardReady();
        o.d(a, "======isReady isEndCardReady:".concat(String.valueOf(zIsEndCardReady)));
        return zIsEndCardReady;
    }
}
