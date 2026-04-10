package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private static final e e = new bf();

    @TargetApi(19)
    public static class bf extends e {
        private bf() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.m.e
        public void e(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z = false;
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    z = true;
                } catch (Throwable th) {
                    boolean z2 = th instanceof IllegalStateException;
                }
            }
            if (z) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static class e {
        private e() {
        }

        public void e(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(WebView webView, String str) {
        e.e(webView, str);
    }
}
