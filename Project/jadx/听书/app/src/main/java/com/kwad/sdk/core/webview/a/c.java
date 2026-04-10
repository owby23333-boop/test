package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes4.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a Mh;

    public final void R(String str) {
        this.mUniqueId = str;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.d.c.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.Mh;
        if (aVar != null && aVar.ju() != null) {
            this.Mh.ju().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ag(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageStart");
        a aVar = this.Mh;
        if (aVar == null || aVar.ju() == null) {
            return;
        }
        this.Mh.ju().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageFinished");
        a aVar = this.Mh;
        if (aVar == null || aVar.ju() == null) {
            return;
        }
        this.Mh.ju().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.Mh;
        if (aVar == null || !aVar.KQ() || ((this.Mh.KK() != null && this.Mh.KK().shouldOverrideUrlLoading(webView, str)) || eT(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private boolean eT(String str) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                a aVar = this.Mh;
                if (aVar != null) {
                    if (aVar.KM()) {
                        a(this.Mh, str);
                        return true;
                    }
                    if (eU(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.Mh;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    public static int a(a aVar, String str) {
        int iF = com.kwad.sdk.core.download.a.b.F(aVar.getContext(), str);
        if (iF == 1) {
            if (aVar.nK() != null) {
                aVar.nK().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
        } else {
            if (aVar.nK() != null) {
                aVar.nK().onFailed();
            }
            if (iF == -1) {
                com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), "", 2, null);
            }
        }
        return iF;
    }

    private static boolean eU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith("intent://");
    }

    public final void setClientConfig(a aVar) {
        this.Mh = aVar;
        setNeedHybridLoad(aVar.KN());
    }

    public final a getClientConfig() {
        return this.Mh;
    }

    public final void destroy() {
        a aVar = this.Mh;
        if (aVar != null) {
            aVar.release();
            this.Mh = null;
        }
    }

    public static class a {
        private KsAdWebView.c TL;
        private int To;
        private KsAdWebView.e aNb;
        private KsAdWebView.d aNc;
        private boolean aNd;
        private boolean aNg;
        private KsAdWebView.b afR;
        private AdTemplate mAdTemplate;
        private Context mContext;
        private boolean aNe = true;
        private boolean aNf = true;
        private boolean aNa = true;
        private boolean aNh = false;
        private long aNi = 600;
        private long aNj = 0;

        public a(Context context) {
            this.mContext = context;
        }

        public final void release() {
            this.afR = null;
            this.aNc = null;
            this.TL = null;
            this.aNb = null;
            this.mContext = null;
            this.mAdTemplate = null;
        }

        public final a eJ(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e ju() {
            return this.aNb;
        }

        public final KsAdWebView.d KK() {
            return this.aNc;
        }

        public final a b(KsAdWebView.e eVar) {
            this.aNb = eVar;
            return this;
        }

        public final a a(KsAdWebView.d dVar) {
            this.aNc = dVar;
            return this;
        }

        public final KsAdWebView.b nK() {
            return this.afR;
        }

        public final a a(KsAdWebView.b bVar) {
            this.afR = bVar;
            return this;
        }

        private boolean KL() {
            return this.aNh;
        }

        public final a bz(boolean z) {
            this.aNh = true;
            return this;
        }

        public final com.kwad.sdk.core.adlog.c.a pq() {
            return com.kwad.sdk.core.adlog.c.a.EK().db(this.To).dc(this.aNd ? 1 : 0);
        }

        public final a bA(boolean z) {
            this.aNd = true;
            return this;
        }

        public final a dS(int i) {
            this.To = i;
            return this;
        }

        public final boolean KM() {
            return this.aNf;
        }

        public final a bB(boolean z) {
            this.aNf = z;
            return this;
        }

        public final boolean KN() {
            return this.aNa;
        }

        public final boolean KO() {
            return this.aNe;
        }

        public final a bC(boolean z) {
            this.aNe = z;
            return this;
        }

        public final KsAdWebView.c rm() {
            return this.TL;
        }

        public final a c(KsAdWebView.c cVar) {
            this.TL = cVar;
            return this;
        }

        public final boolean KP() {
            return this.aNg;
        }

        public final a bD(boolean z) {
            this.aNg = true;
            return this;
        }

        public final void aM(long j) {
            this.aNj = j;
        }

        public final boolean KQ() {
            if (!KL()) {
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.aNj;
            return j > 0 && jCurrentTimeMillis - j <= this.aNi;
        }

        public final boolean KR() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dw(e.el(adTemplate));
        }

        public final boolean KS() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dx(e.el(adTemplate));
        }
    }
}
