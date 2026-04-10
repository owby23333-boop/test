package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.r;

/* JADX INFO: loaded from: classes3.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    private com.kwad.sdk.core.webview.kwai.c aoT;
    private long aoU;
    private String aoV;
    private long aoW;
    private boolean aoX;
    private c.a kj;
    private String mUniqueId;

    class a implements DownloadListener {
        private a() {
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            if (KsAdWebView.this.kj == null || KsAdWebView.this.kj.getAdTemplate() == null || !KsAdWebView.this.kj.zj()) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                    return;
                }
            }
            com.kwad.sdk.core.response.a.d.cb(KsAdWebView.this.kj.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
            KsAdWebView.this.kj.getAdTemplate().isWebViewDownload = true;
            c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
            if (readyClientConfig != null) {
                readyClientConfig.cr(KsAdWebView.this.kj.getAdTemplate());
            }
            ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).g(KsAdWebView.this.getContext2(), KsAdWebView.this.kj.getAdTemplate());
        }
    }

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public interface c {
        void op();
    }

    public interface d {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i2, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i2, boolean z2) {
        super(context, attributeSet, i2, z2);
        init(context);
    }

    private void cJ(String str) {
        c.a aVar = this.kj;
        if (aVar == null || aVar.getAdTemplate() == null) {
            return;
        }
        this.aoX = TextUtils.equals(com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(this.kj.getAdTemplate())), str);
        if (this.aoX) {
            this.kj.ba(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.kwai.c cVar = this.aoT;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.aoT.getClientConfig();
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.b.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings webSettingsA = bl.a(this);
        webSettingsA.setUseWideViewPort(true);
        webSettingsA.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        this.aoT = new com.kwad.sdk.core.webview.kwai.c();
        this.aoT.cK(this.mUniqueId);
        setWebViewClient(this.aoT);
        setWebChromeClient(new com.kwad.sdk.core.webview.kwai.b());
        setDownloadListener(new a(this, (byte) 0));
        webSettingsA.setUserAgentString(webSettingsA.getUserAgentString() + zg());
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                r.a((Object) accessibilityManager, "setState", 0);
            }
        } catch (Throwable unused) {
        }
    }

    private String zg() {
        return "KSADSDK_V3.3.38_" + getContext().getPackageName() + "_" + k.bS(getContext());
    }

    public c.a getClientConfig() {
        if (this.kj == null) {
            this.kj = new c.a(getContext());
        }
        return this.kj;
    }

    public long getLoadTime() {
        return this.aoW;
    }

    public String getLoadUrl() {
        return this.aoV;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        cJ(str);
        com.kwad.sdk.core.webview.a.b.b.cV(this.mUniqueId);
        this.aoV = str;
        this.aoW = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityCreate() {
        c.a aVar = this.kj;
        if (aVar != null && aVar.zk()) {
            com.kwad.sdk.core.report.a.b(this.kj.getAdTemplate(), this.kj.getClientParams());
        }
        if (this.aoT != null) {
            this.aoU = System.currentTimeMillis();
            this.aoT.W(this.aoU);
        }
    }

    public final void onActivityDestroy() {
        release();
        c.a aVar = this.kj;
        if (aVar == null || !aVar.zk()) {
            return;
        }
        y.b clientParams = this.kj.getClientParams();
        if (clientParams == null) {
            clientParams = new y.b();
        }
        clientParams.Jz = System.currentTimeMillis() - this.aoU;
        com.kwad.sdk.core.report.a.d(this.kj.getAdTemplate(), clientParams);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        c.a aVar = this.kj;
        if (aVar == null || aVar.getOnWebViewScrollChangeListener() == null) {
            return;
        }
        this.kj.getOnWebViewScrollChangeListener().op();
    }

    public void setClientConfig(c.a aVar) {
        this.aoT.setClientConfig(aVar);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.kwai.kwai.a.bI.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.kwai.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.kwai.kwai.a.bI.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.kwai.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }
}
