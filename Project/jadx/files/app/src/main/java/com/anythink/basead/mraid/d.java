package com.anythink.basead.mraid;

import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.basead.c.f;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static String a = "d";

    public interface a {
        void a();

        void a(com.anythink.basead.c.e eVar);
    }

    public static String a(j jVar, i iVar) {
        if (!TextUtils.isEmpty(iVar.i())) {
            return iVar.i();
        }
        if (TextUtils.isEmpty(iVar.h())) {
            return "";
        }
        File fileB = com.anythink.core.common.res.d.a(n.a().g()).b(jVar, iVar);
        if (fileB == null) {
            return com.anythink.core.common.res.d.a(n.a().g()).a(iVar.h(), jVar, iVar);
        }
        String str = "loadMraidResource: html exists: " + fileB.toURI().toString();
        return fileB.toURI().toString();
    }

    public static void a(final String str, final String str2, final MraidWebView mraidWebView, final a aVar) {
        if (mraidWebView == null) {
            return;
        }
        n.a().a(new Runnable() { // from class: com.anythink.basead.mraid.d.1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(", start load mraid webview");
                com.anythink.basead.mraid.a aVar2 = new com.anythink.basead.mraid.a();
                e eVar = new e(str2);
                eVar.a(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.basead.mraid.d.1.1
                    boolean a = false;

                    @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                    public final void onPageFinished(WebView webView, String str3) {
                        if (this.a) {
                            return;
                        }
                        this.a = true;
                        if (com.anythink.core.common.res.d.a.equals(str3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append(", about:blank");
                            a aVar3 = aVar;
                            if (aVar3 != null) {
                                aVar3.a(f.a(f.f5910n, f.I));
                                return;
                            }
                            return;
                        }
                        com.anythink.expressad.mbbanner.a.a.a.a(webView);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        MraidWebView mraidWebView2 = mraidWebView;
                        if (mraidWebView2 != null) {
                            com.anythink.basead.a.b.c.a(str, mraidWebView2);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(", load success");
                        a aVar4 = aVar;
                        if (aVar4 != null) {
                            aVar4.a();
                        }
                    }

                    @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                    public final void onReceivedError(WebView webView, int i2, String str3, String str4) {
                        if (this.a) {
                            return;
                        }
                        this.a = true;
                        super.onReceivedError(webView, i2, str3, str4);
                        com.anythink.basead.c.e eVarA = f.a("10000", i2 + "_" + str3);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(", load failed: ");
                        sb2.append(eVarA.c());
                        a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.a(eVarA);
                        }
                    }

                    @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        if (this.a) {
                            return;
                        }
                        this.a = true;
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        com.anythink.basead.c.e eVarA = f.a("10000", sslError != null ? sslError.toString() : "onReceivedSslError");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(", load failed: ");
                        sb2.append(eVarA.c());
                        a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.a(eVarA);
                        }
                    }
                });
                mraidWebView.setWebViewClient(eVar);
                mraidWebView.setObject(aVar2);
                mraidWebView.loadUrl(str2);
            }
        });
    }
}
