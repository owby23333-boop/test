package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.i.dl;
import com.bytedance.sdk.component.i.g;
import com.bytedance.sdk.component.utils.gz;

/* JADX INFO: loaded from: classes2.dex */
public class BizWebView extends MultiWebview implements dl {
    @Override // com.bytedance.sdk.component.i.dl
    public View getView() {
        return this;
    }

    public BizWebView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        super.G_();
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setNetworkAvailable(final boolean z) {
        if (this.g != null) {
            this.g.setNetworkAvailable(z);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setNetworkAvailable(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void loadUrl(final String str) {
        if (this.g != null) {
            this.g.loadUrl(str);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.loadUrl(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public boolean canGoBack() {
        if (this.g != null) {
            if (this.g.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && z() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void goBack() {
        if (this.g != null) {
            this.g.goBack();
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public String getUrl() {
        return this.g != null ? this.g.getUrl() : "";
    }

    @Override // com.bytedance.sdk.component.i.dl
    public int getProgress() {
        if (this.g != null) {
            return this.g.getProgress();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.i.dl
    public int getContentHeight() {
        if (this.g != null) {
            return this.g.getContentHeight();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.i.dl
    public String getUserAgentString() {
        return this.g != null ? this.g.getUserAgentString() : "";
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setUserAgentString(final String str) {
        if (this.g != null) {
            this.g.setUserAgentString(str);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void onResume() {
        if (this.g != null) {
            this.g.onResume();
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void clearCache(boolean z) {
        if (this.g != null) {
            this.g.clearCache(z);
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void clearHistory() {
        if (this.g != null) {
            this.g.clearHistory();
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.g != null) {
            this.g.setWebViewClient(webViewClient);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.g != null) {
            this.g.setDownloadListener(downloadListener);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.g != null) {
            this.g.setWebChromeClient(webChromeClient);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.g != null) {
            this.g.addJavascriptInterface(obj, str);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setJavaScriptEnabled(final boolean z) {
        if (this.g != null) {
            this.g.setJavaScriptEnabled(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDisplayZoomControls(final boolean z) {
        if (this.g != null) {
            this.g.setDisplayZoomControls(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setCacheMode(final int i) {
        if (this.g != null) {
            this.g.setCacheMode(i);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setCacheMode(i);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.g != null) {
            this.g.onPause();
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.g != null) {
            this.g.evaluateJavascript(str, valueCallback);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public WebView getWebView() {
        if (this.g != null) {
            return this.g.getWebView();
        }
        if (gc()) {
            return null;
        }
        long j = 500;
        while (this.z.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.g != null) {
            return this.g.getWebView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.i.dl
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void removeJavascriptInterface(String str) {
        dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAppCacheEnabled(final boolean z) {
        if (this.g != null) {
            this.g.setAppCacheEnabled(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setSupportZoom(final boolean z) {
        if (this.g != null) {
            this.g.setSupportZoom(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setUseWideViewPort(final boolean z) {
        if (this.g != null) {
            this.g.setUseWideViewPort(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.g != null) {
            this.g.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDomStorageEnabled(final boolean z) {
        if (this.g != null) {
            this.g.setDomStorageEnabled(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setBuiltInZoomControls(final boolean z) {
        if (this.g != null) {
            this.g.setBuiltInZoomControls(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.g != null) {
            this.g.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.g != null) {
            this.g.setLoadWithOverviewMode(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDefaultTextEncodingName(final String str) {
        if (this.g != null) {
            this.g.setDefaultTextEncodingName(str);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDefaultFontSize(final int i) {
        if (this.g != null) {
            this.g.setDefaultFontSize(i);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setMixedContentMode(final int i) {
        if (this.g != null) {
            this.g.setMixedContentMode(i);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setDatabaseEnabled(final boolean z) {
        if (this.g != null) {
            this.g.setDatabaseEnabled(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAllowFileAccess(final boolean z) {
        if (this.g != null) {
            this.g.setAllowFileAccess(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void clearView() {
        if (this.g != null) {
            this.g.clearView();
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void pauseTimers() {
        if (this.g != null) {
            this.g.pauseTimers();
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void resumeTimers() {
        if (this.g != null) {
            this.g.resumeTimers();
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setBlockNetworkImage(final boolean z) {
        if (this.g != null) {
            this.g.setBlockNetworkImage(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.g != null) {
            this.g.setAllowFileAccessFromFileURLs(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.g != null) {
            this.g.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setSavePassword(final boolean z) {
        if (this.g != null) {
            this.g.setSavePassword(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.g != null) {
            this.g.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.z.get() < 3) {
            g(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.g != null) {
            this.g.setBackgroundColor(i);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setBackgroundColor(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void computeScroll() {
        if (this.g != null) {
            this.g.computeScroll();
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.28
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.computeScroll();
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setLayerType(final int i, final Paint paint) {
        if (this.g != null) {
            this.g.setLayerType(i, paint);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.29
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setLayerType(i, paint);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.g != null) {
            this.g.setOverScrollMode(i);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.30
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setOverScrollMode(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.g != null) {
            this.g.setVisibility(i);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.31
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setVisibility(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.g != null) {
            this.g.setAlpha(f);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.32
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setAlpha(f);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.i.dl
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.g != null) {
            this.g.setOnScrollChangeListener(onScrollChangeListener);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.33
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setOnScrollChangeListener(onScrollChangeListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.g
    public void setTouchEventListener(final g.z zVar) {
        if (this.g != null) {
            this.g.setTouchEventListener(zVar);
        } else {
            if (this.z == null || this.z.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.34
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.g != null) {
                        BizWebView.this.g.setTouchEventListener(zVar);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.i.dl
    public void z(String str, String str2, Object obj) {
        if (this.g != null) {
            this.g.z(str, str2, obj);
        }
    }

    private void g(Runnable runnable) {
        gz.g().post(runnable);
    }
}
