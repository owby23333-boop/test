package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b acc;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    public static class C0354a extends com.kwad.sdk.core.response.a.a {
        public String NN;
        public String acf;
        public String acg;
    }

    public interface b {
        void c(C0354a c0354a);
    }

    public static class c extends com.kwad.sdk.core.response.a.a {
        public int ach;
        public long aci;
        public boolean acj;
        public int errorCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public a(b bVar) {
        this.acc = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0354a c0354a = new C0354a();
            c0354a.parseJson(new JSONObject(str));
            b(c0354a);
        } catch (Throwable unused) {
        }
    }

    private void b(final C0354a c0354a) {
        bw.postOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.this.acc != null) {
                    a.this.acc.c(c0354a);
                }
            }
        });
    }
}
