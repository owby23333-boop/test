package com.kwad.components.core.webview.kwai;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private com.kwad.components.core.d.b.c IZ;
    private WebView Lk;
    private boolean RK;
    private KsAppDownloadListener RS;
    private int RT = -100;
    private int RU = 0;
    private AdTemplate mAdTemplate;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.kwai.a$a, reason: collision with other inner class name */
    public static final class C0420a extends com.kwad.sdk.core.response.kwai.a {
        public String packageName;
        public String url;
    }

    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.Lk = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.mJsBridgeContext = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(String str) {
        try {
            C0420a c0420a = new C0420a();
            c0420a.parseJson(new JSONObject(str));
            if (k(c0420a.url, c0420a.packageName)) {
                return;
            }
            if (this.IZ == null) {
                j(c0420a.url, c0420a.packageName);
            }
            if (this.IZ.nF()) {
                return;
            }
            this.IZ.d(this.RS);
            this.IZ.m(new a.C0395a(this.mJsBridgeContext.Lk.getContext()).al(true).am(false).J(this.mAdTemplate).ao(false));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private void h(String str, String str2) {
        WebView webView;
        if (this.RK || TextUtils.isEmpty(str) || (webView = this.Lk) == null) {
            return;
        }
        bm.a(webView, str, str2);
    }

    private synchronized void j(String str, String str2) {
        this.IZ = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, str, str2);
        if (this.RS == null) {
            this.RS = rm();
            this.IZ.b(this.RS);
        }
    }

    private static boolean k(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i2, int i3) {
        this.RU = i3;
        if (this.RT != i2) {
            this.RT = i2;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            h("onDownLoadStatusCallback", sb.toString());
        }
    }

    private KsAppDownloadListener rm() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.kwai.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.m(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.m(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.m(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.m(12, 100);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                a.this.m(4, i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                if (i2 == 0) {
                    a.this.m(1, 0);
                } else {
                    a.this.m(2, i2);
                }
            }
        };
    }

    public final void destroy() {
        this.RK = true;
        com.kwad.components.core.d.b.c cVar = this.IZ;
        if (cVar != null) {
            cVar.c(this.RS);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (k(str, str2)) {
            return 0;
        }
        if (this.IZ == null) {
            j(str, str2);
        }
        return this.IZ.nw();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (k(str, str2)) {
            return 0;
        }
        if (this.IZ == null) {
            j(str, str2);
        }
        return this.RU;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.kwai.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aE(str);
            }
        });
    }
}
