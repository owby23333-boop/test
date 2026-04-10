package com.yuewen;

import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes15.dex */
public class og4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15274a = 8388608;

    public static void a(WebSettings webSettings) {
        if (webSettings == null) {
            return;
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        boolean z = false;
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setSaveFormData(true);
        webSettings.setSavePassword(false);
        webSettings.setUseWideViewPort(false);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setAllowContentAccess(false);
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        if (g72.h().n()) {
            webSettings.setCacheMode(-1);
        } else {
            webSettings.setCacheMode(1);
        }
        if (mj.a() != null && !mj.a().L()) {
            z = true;
        }
        if (z) {
            webSettings.setCacheMode(2);
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setUserAgentString(null);
        webSettings.setUserAgentString(webSettings.getUserAgentString() + " XiaoMi/MiuiBrowser/2.1.1");
        webSettings.setMixedContentMode(1);
    }
}
