package com.kwad.sdk.core.webview.kwai;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.sdk.core.webview.kwai.a {
    private long aoU;
    private boolean apa;
    private a kj;

    public static class a {
        private KsAdWebView.c LN;
        private y.b ajz;
        private boolean aoX;
        private KsAdWebView.b apb;
        private AdTemplate mAdTemplate;
        private final Context mContext;
        private KsAdWebView.d tS;
        private boolean apc = true;
        private boolean apd = true;
        private boolean aoZ = true;

        public a(Context context) {
            this.mContext = context;
        }

        public final a a(KsAdWebView.b bVar) {
            this.apb = bVar;
            return this;
        }

        public final a aY(boolean z2) {
            this.apd = z2;
            return this;
        }

        public final a aZ(boolean z2) {
            this.apc = z2;
            return this;
        }

        public final a b(y.b bVar) {
            this.ajz = bVar;
            return this;
        }

        public final a b(KsAdWebView.d dVar) {
            this.tS = dVar;
            return this;
        }

        public final a ba(boolean z2) {
            this.aoX = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.LN = cVar;
            return this;
        }

        public final a cr(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final y.b getClientParams() {
            return this.ajz;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.c getOnWebViewScrollChangeListener() {
            return this.LN;
        }

        public final KsAdWebView.d getWebListener() {
            return this.tS;
        }

        public final KsAdWebView.b md() {
            return this.apb;
        }

        public final boolean zh() {
            return this.apd;
        }

        public final boolean zi() {
            return this.aoZ;
        }

        public final boolean zj() {
            return this.apc;
        }

        public final boolean zk() {
            return this.aoX;
        }
    }

    public final void W(long j2) {
        this.aoU = j2;
    }

    public final void cK(String str) {
        this.mUniqueId = str;
    }

    public final a getClientConfig() {
        return this.kj;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.a.b.b.N(this.mUniqueId, "onPageFinished");
        a aVar = this.kj;
        if (aVar != null && aVar.zk() && !this.apa) {
            this.apa = true;
            if (this.aoU > 0) {
                if (this.kj.getClientParams() == null) {
                    this.kj.b(new y.b());
                }
                this.kj.getClientParams().akc = System.currentTimeMillis() - this.aoU;
                this.aoU = -1L;
            }
            com.kwad.sdk.core.report.a.c(this.kj.getAdTemplate(), this.kj.getClientParams());
        }
        a aVar2 = this.kj;
        if (aVar2 == null || aVar2.getWebListener() == null) {
            return;
        }
        this.kj.getWebListener().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.a.b.b.N(this.mUniqueId, "onPageStart");
        a aVar = this.kj;
        if (aVar == null || aVar.getWebListener() == null) {
            return;
        }
        this.kj.getWebListener().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        com.kwad.sdk.core.d.b.d("KsAdWebViewClient", "onReceivedError " + i2);
        a aVar = this.kj;
        if (aVar != null && aVar.getWebListener() != null) {
            this.kj.getWebListener().onReceivedHttpError(i2, str, str2);
        }
        com.kwad.sdk.core.webview.a.b.b.P(str2, str);
        a aVar2 = this.kj;
        if (aVar2 == null || !aVar2.zk()) {
            return;
        }
        com.kwad.sdk.core.report.a.e(this.kj.getAdTemplate(), this.kj.getClientParams());
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.kj = aVar;
        setNeedHybridLoad(this.kj.zi());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.b.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.a.b.b.N(this.mUniqueId, "shouldOverrideUrlLoading");
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL) && !str.startsWith("sms:")) {
                if (this.kj != null && this.kj.zh()) {
                    int iG = ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).g(this.kj.getContext(), str);
                    if (iG == 1) {
                        if (this.kj.md() != null) {
                            this.kj.md().onSuccess();
                        }
                        com.kwad.sdk.core.report.a.a(this.kj.getAdTemplate(), "", 2, (y.b) null);
                        return true;
                    }
                    if (this.kj.md() != null) {
                        this.kj.md().onFailed();
                    }
                    if (iG == -1) {
                        com.kwad.sdk.core.report.a.b(this.kj.getAdTemplate(), "", 2, (y.b) null);
                    }
                }
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (this.kj != null) {
                this.kj.getContext().startActivity(intent);
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
