package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bg implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c acS;
    private b aeu;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setHeaderBar";
    }

    public bg(b bVar) {
        this.aeu = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        bw.postOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bg.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                bg.this.b(aVar);
                if (bg.this.acS != null) {
                    bg.this.acS.a(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.aeu;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeu = null;
        this.acS = null;
    }
}
