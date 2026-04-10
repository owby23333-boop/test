package com.amgcyo.cuttadon.view.webview;

import com.tencent.smtt.sdk.WebView;

/* JADX INFO: compiled from: MkIX5WebPageView.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    boolean isOpenThirdApp(String str);

    void onPageFinished(WebView webView, String str);

    void onReceivedTitle(WebView webView, String str);

    void onScaleChanged(float f2);

    void startProgress(int i2);
}
