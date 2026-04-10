package com.kwad.components.core.offline.init.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bm;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BaseKsWebView {
    private KsAdWebView Lg;
    private boolean enableScroll;

    public a(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        this.Lg = new KsAdWebView(context);
        this.Lg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.Lg.setBackgroundColor(0);
        this.Lg.setClientConfig(this.Lg.getClientConfig().b(new KsAdWebView.d() { // from class: com.kwad.components.core.offline.init.c.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onReceivedHttpError(i2, str, str2);
                }
            }
        }).a(new KsAdWebView.b() { // from class: com.kwad.components.core.offline.init.c.a.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onSuccess();
                }
            }
        }));
        addView(this.Lg);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.Lg.addJavascriptInterface(obj, str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str) {
        bm.a(this.Lg, str, (String) null);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str, String str2) {
        bm.a(this.Lg, str, str2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void destroy() {
        this.Lg.destroy();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void loadUrl(String str) {
        this.Lg.loadUrl(str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollBy(int i2, int i3) {
        if (this.enableScroll) {
            this.Lg.scrollBy(i2, i3);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollTo(int i2, int i3) {
        if (this.enableScroll) {
            this.Lg.scrollTo(i2, i3);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAcceptThirdPartyCookies(boolean z2) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.Lg, z2);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowContentAccess(boolean z2) {
        this.Lg.getSettings().setAllowContentAccess(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccess(boolean z2) {
        this.Lg.getSettings().setAllowFileAccess(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccessFromFileURLs(boolean z2) {
        this.Lg.getSettings().setAllowFileAccessFromFileURLs(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowUniversalAccessFromFileURLs(boolean z2) {
        this.Lg.getSettings().setAllowUniversalAccessFromFileURLs(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setCacheMode(int i2) {
        this.Lg.getSettings().setCacheMode(i2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setContextUniqId(int i2) {
        AdTemplate adTemplateAt = com.kwad.components.core.offline.api.a.kwai.a.at(i2);
        if (adTemplateAt != null) {
            this.Lg.getClientConfig().cr(adTemplateAt);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDebugEnabled(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z2);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDeeplinkEnabled(boolean z2) {
        this.Lg.getClientConfig().aY(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableScroll(boolean z2) {
        this.enableScroll = z2;
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableWebCache(boolean z2) {
        this.Lg.setNeedHybridLoad(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setInnerDownloadEnabled(boolean z2) {
        this.Lg.getClientConfig().aZ(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setJavaScriptEnabled(boolean z2) {
        this.Lg.getSettings().setJavaScriptEnabled(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setMixedContentMode(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.Lg.getSettings().setMixedContentMode(i2);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setSavePassword(boolean z2) {
        this.Lg.getSettings().setSavePassword(z2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setTextZoom(int i2) {
        this.Lg.getSettings().setTextZoom(i2);
    }
}
