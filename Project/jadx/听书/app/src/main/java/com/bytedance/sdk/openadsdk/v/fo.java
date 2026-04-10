package com.bytedance.sdk.openadsdk.v;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    private static void g(com.bytedance.sdk.component.i.dl dlVar) {
        try {
            dlVar.removeJavascriptInterface("searchBoxJavaBridge_");
            dlVar.removeJavascriptInterface("accessibility");
            dlVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            e.z("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void z(com.bytedance.sdk.component.i.dl dlVar) {
        g(dlVar);
        try {
            dlVar.setJavaScriptEnabled(true);
            dlVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            e.z("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            dlVar.setSupportZoom(false);
        } catch (Throwable th2) {
            e.z("WebViewSettings", "setSupportZoom error", th2);
        }
        dlVar.setLoadWithOverviewMode(true);
        dlVar.setUseWideViewPort(true);
        dlVar.setDomStorageEnabled(true);
        dlVar.setAllowFileAccess(false);
        dlVar.setBlockNetworkImage(false);
        dlVar.setDisplayZoomControls(false);
        dlVar.setAllowFileAccessFromFileURLs(false);
        dlVar.setAllowUniversalAccessFromFileURLs(false);
        dlVar.setSavePassword(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
        } catch (Throwable th3) {
            e.z("WebViewSettings", "setLayerType error", th3);
        }
        if (!z) {
            dlVar.setLayerType(0, null);
        } else {
            if (z) {
                dlVar.setLayerType(2, null);
            }
            dlVar.setMixedContentMode(0);
        }
        dlVar.setMixedContentMode(0);
    }
}
