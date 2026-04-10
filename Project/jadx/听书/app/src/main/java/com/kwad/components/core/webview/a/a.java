package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.cc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private com.kwad.components.core.e.d.c Pc;
    private WebView Ta;
    private boolean abI;
    private KsAppDownloadListener abU;
    private int abV = -100;
    private int abW = 0;
    private com.kwad.sdk.core.webview.b eQ;
    private AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    public static final class C0353a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.Ta = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.eQ = bVar;
    }

    private synchronized void p(String str, String str2) {
        this.Pc = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.abU == null) {
            KsAppDownloadListener ksAppDownloadListenerUz = uz();
            this.abU = ksAppDownloadListenerUz;
            this.Pc.b(ksAppDownloadListenerUz);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.Pc == null) {
            p(str, str2);
        }
        return this.Pc.pB();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.Pc == null) {
            p(str, str2);
        }
        return this.abW;
    }

    @JavascriptInterface
    public final void handleAdClick(final String str) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.aQ(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str) {
        try {
            C0353a c0353a = new C0353a();
            c0353a.parseJson(new JSONObject(str));
            if (q(c0353a.url, c0353a.packageName)) {
                return;
            }
            if (this.Pc == null) {
                p(c0353a.url, c0353a.packageName);
            }
            a.C0333a c0333aAt = new a.C0333a(this.eQ.Ta.getContext()).aq(true).ar(false).aB(this.mAdTemplate).at(false);
            if (this.Pc.s(c0333aAt)) {
                return;
            }
            this.Pc.d(this.abU);
            this.Pc.r(c0333aAt);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.q(1, 0);
                } else {
                    a.this.q(2, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.q(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.q(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.q(4, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, int i2) {
        this.abW = i2;
        if (this.abV != i) {
            this.abV = i;
            o("onDownLoadStatusCallback", new StringBuilder().append(i).toString());
        }
    }

    private void o(String str, String str2) {
        WebView webView;
        if (this.abI || TextUtils.isEmpty(str) || (webView = this.Ta) == null) {
            return;
        }
        cc.a(webView, str, str2);
    }

    public final void destroy() {
        this.abI = true;
        com.kwad.components.core.e.d.c cVar = this.Pc;
        if (cVar != null) {
            cVar.c(this.abU);
        }
    }
}
