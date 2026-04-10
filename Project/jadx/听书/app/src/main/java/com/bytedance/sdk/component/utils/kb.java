package com.bytedance.sdk.component.utils;

import android.os.Looper;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    private static final z z = new g();

    private static class z {
        private z() {
        }

        public void z(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            kb.g(new Runnable() { // from class: com.bytedance.sdk.component.utils.kb.z.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static class g extends z {
        private g() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.kb.z
        public void z(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            kb.g(new Runnable() { // from class: com.bytedance.sdk.component.utils.kb.g.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    boolean z = false;
                    if (str2 != null && str2.startsWith("javascript:")) {
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
            });
        }
    }

    @Deprecated
    public static void z(WebView webView, String str) {
        z.z(webView, str);
    }

    public static void z(com.bytedance.sdk.component.i.dl dlVar, String str) {
        z.z(dlVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            gz.g().post(runnable);
        }
    }
}
