package com.kwad.components.core.o.b.d;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.cc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BaseKsWebView {
    private KsAdWebView SR;
    private boolean enableScroll;

    public a(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        this.SR = new KsAdWebView(context);
        this.SR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.SR.setBackgroundColor(0);
        this.SR.setClientConfig(this.SR.getClientConfig().b(new KsAdWebView.e() { // from class: com.kwad.components.core.o.b.d.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onReceivedHttpError(i, str, str2);
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageFinished();
                }
            }
        }).a(new KsAdWebView.b() { // from class: com.kwad.components.core.o.b.d.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onFailed();
                }
            }
        }).a(new KsAdWebView.d() { // from class: com.kwad.components.core.o.b.d.a.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (a.this.mWebLoadListener != null) {
                    return a.this.mWebLoadListener.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
        }));
        addView(this.SR);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setContextUniqId(int i) {
        AdTemplate adTemplateR = c.r(com.kwad.components.core.o.a.e.a.a.aI(i));
        if (adTemplateR == null || this.SR.getClientConfig() == null) {
            return;
        }
        this.SR.getClientConfig().eJ(adTemplateR);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdCacheId(int i, String str) {
        AdTemplate adTemplateA = c.a(com.kwad.components.core.o.a.e.a.a.aI(i), str);
        if (adTemplateA == null || this.SR.getClientConfig() == null) {
            return;
        }
        this.SR.getClientConfig().eJ(adTemplateA);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdTemplateString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(jSONObject);
            this.SR.getClientConfig().eJ(adTemplate);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableWebCache(boolean z) {
        this.SR.setNeedHybridLoad(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str) {
        cc.a(this.SR, str, (String) null);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str, String str2) {
        cc.a(this.SR, str, str2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoBack() {
        return this.SR.canGoBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoForward() {
        return this.SR.canGoForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goBack() {
        this.SR.goBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goForward() {
        this.SR.goForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDeeplinkEnabled(boolean z) {
        if (this.SR.getClientConfig() != null) {
            this.SR.getClientConfig().bB(z);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setInnerDownloadEnabled(boolean z) {
        if (this.SR.getClientConfig() != null) {
            this.SR.getClientConfig().bC(z);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccess(boolean z) {
        this.SR.getSettings().setAllowFileAccess(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setCacheMode(int i) {
        this.SR.getSettings().setCacheMode(i);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowContentAccess(boolean z) {
        this.SR.getSettings().setAllowContentAccess(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setJavaScriptEnabled(boolean z) {
        this.SR.getSettings().setJavaScriptEnabled(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setSavePassword(boolean z) {
        this.SR.getSettings().setSavePassword(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setTextZoom(int i) {
        this.SR.getSettings().setTextZoom(i);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccessFromFileURLs(boolean z) {
        this.SR.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        this.SR.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setMixedContentMode(int i) {
        this.SR.getSettings().setMixedContentMode(i);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDebugEnabled(boolean z) {
        WebView.setWebContentsDebuggingEnabled(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAcceptThirdPartyCookies(boolean z) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.SR, z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableScroll(boolean z) {
        this.enableScroll = z;
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollTo(int i, int i2) {
        if (this.enableScroll) {
            this.SR.scrollTo(i, i2);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollBy(int i, int i2) {
        if (this.enableScroll) {
            this.SR.scrollBy(i, i2);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void loadUrl(String str) {
        this.SR.loadUrl(str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void addJavascriptInterface(Object obj, String str) {
        this.SR.addJavascriptInterface(obj, str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void destroy() {
        this.SR.destroy();
    }
}
