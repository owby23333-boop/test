package com.anythink.expressad.atsignalcommon.windvane;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends com.anythink.expressad.atsignalcommon.base.b {
    public static final String a = "WindVaneWebViewClient";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8340c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8341d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8342e = "mmusdk_cache";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8343f = "1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f8344g = true;
    protected String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e f8346i;

    public p() {
        this.b = null;
        this.f8345h = 0;
    }

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line + "\n");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    private void b(e eVar) {
        this.f8346i = eVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.b = str;
        e eVar = this.f8346i;
        if (eVar != null) {
            eVar.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponseA = a(str);
        return webResourceResponseA != null ? webResourceResponseA : super.shouldInterceptRequest(webView, str);
    }

    private p(int i2) {
        this.b = null;
        this.f8345h = 0;
        this.f8345h = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.webkit.WebResourceResponse a(java.lang.String r5) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L5d
            boolean r1 = com.anythink.expressad.atsignalcommon.windvane.n.d(r5)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L5d
            com.anythink.expressad.foundation.b.a r1 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Throwable -> L5d
            android.content.Context r1 = r1.d()     // Catch: java.lang.Throwable -> L5d
            com.anythink.expressad.foundation.g.d.b r1 = com.anythink.expressad.foundation.g.d.b.a(r1)     // Catch: java.lang.Throwable -> L5d
            boolean r2 = com.anythink.expressad.foundation.h.t.a(r5)     // Catch: java.lang.Throwable -> L5d
            if (r2 != 0) goto L44
            java.lang.String r2 = com.anythink.expressad.foundation.h.s.a(r5)     // Catch: java.lang.Throwable -> L5d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L5d
            android.graphics.Bitmap r4 = r1.a(r5)     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L33
            android.graphics.Bitmap r1 = r1.a(r5)     // Catch: java.lang.Throwable -> L5d
            goto L45
        L33:
            boolean r3 = r3.exists()     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L44
            android.graphics.Bitmap r2 = com.anythink.expressad.foundation.g.d.a.a(r2)     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L44
            r1.a(r5, r2)     // Catch: java.lang.Throwable -> L5d
            r1 = r2
            goto L45
        L44:
            r1 = r0
        L45:
            if (r1 == 0) goto L5d
            boolean r2 = r1.isRecycled()     // Catch: java.lang.Throwable -> L5d
            if (r2 != 0) goto L5d
            android.webkit.WebResourceResponse r2 = new android.webkit.WebResourceResponse     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = com.anythink.expressad.atsignalcommon.windvane.n.e(r5)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "utf-8"
            java.io.InputStream r1 = com.anythink.expressad.foundation.g.d.a.a(r1)     // Catch: java.lang.Throwable -> L5d
            r2.<init>(r5, r3, r1)     // Catch: java.lang.Throwable -> L5d
            return r2
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.windvane.p.a(java.lang.String):android.webkit.WebResourceResponse");
    }
}
