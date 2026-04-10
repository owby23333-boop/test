package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ak implements com.kwad.sdk.core.webview.c.a {
    private final Handler acR = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c acS;
    private b eV;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int ady = -1;
        public int type;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "hide";
    }

    public ak(b bVar) {
        this.eV = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.acS = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ak.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ak.this.acS != null) {
                        ak.this.acS.a(null);
                    }
                    ak.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.acS.onError(-1, e.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.eV = null;
        this.acS = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.eV;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
