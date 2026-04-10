package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.c Pc;
    private KsAppDownloadListener abU;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c qn;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String acu;
        public String packageName;
    }

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int acv;
        public int progress;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "installAppForDownload";
    }

    public m(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (q(aVar.acu, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.Pc == null) {
                p(aVar.acu, aVar.packageName);
            }
            a.C0333a c0333aAt = new a.C0333a(this.mContext).aq(true).ar(false).aB(this.mAdTemplate).at(false);
            if (this.Pc.s(c0333aAt)) {
                return;
            }
            this.Pc.d(this.abU);
            this.Pc.r(c0333aAt);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private synchronized void p(String str, String str2) {
        this.Pc = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.abU == null) {
            KsAppDownloadListener ksAppDownloadListenerUz = uz();
            this.abU = ksAppDownloadListenerUz;
            this.Pc.b(ksAppDownloadListenerUz);
        }
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.m.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                m.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    m.this.q(1, 0);
                } else {
                    m.this.q(2, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                m.this.q(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                m.this.q(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                m.this.q(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                m.this.q(4, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, int i2) {
        if (this.qn != null) {
            b bVar = new b();
            bVar.status = i;
            bVar.progress = i2;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                bVar.totalBytes = com.kwad.sdk.core.response.b.e.el(adTemplate).totalBytes;
                bVar.soFarBytes = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate).soFarBytes;
                if (bVar.totalBytes > 0) {
                    bVar.acv = (int) ((bVar.soFarBytes * 100.0f) / bVar.totalBytes);
                } else {
                    bVar.acv = 0;
                }
            }
            this.qn.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }
}
