package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class as implements com.kwad.sdk.core.webview.c.a {
    private Handler acR = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c acS;
    private b eW;
    private String mUrl;

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "pageStatus";
    }

    @Deprecated
    public as(b bVar) {
        this.eW = bVar;
    }

    public as(b bVar, String str) {
        this.eW = bVar;
        this.mUrl = str;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.as.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    as.this.b(aVar);
                    if (as.this.acS != null) {
                        as.this.acS.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.sdk.core.webview.b.c.b.ag(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.eW = null;
        this.acS = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.eW;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }
}
