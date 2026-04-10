package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private final a aed;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void c(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void d(com.kwad.components.core.webview.tachikoma.f.d dVar);

        void e(com.kwad.components.core.webview.tachikoma.f.d dVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerFeedMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ax(a aVar) {
        this.aed = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final com.kwad.components.core.webview.tachikoma.c.i iVar = new com.kwad.components.core.webview.tachikoma.c.i();
        try {
            iVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.core.webview.tachikoma.f.d dVar = new com.kwad.components.core.webview.tachikoma.f.d() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.components.core.webview.tachikoma.f.d
            public final void p(int i, String str2) {
                iVar.ahb = str2;
                iVar.aha = i;
                cVar.a(iVar);
            }
        };
        int i = iVar.agZ;
        if (i == 1) {
            this.aed.d(dVar);
        } else if (i == 2) {
            this.aed.c(dVar);
        } else {
            if (i != 3) {
                return;
            }
            this.aed.e(dVar);
        }
    }
}
