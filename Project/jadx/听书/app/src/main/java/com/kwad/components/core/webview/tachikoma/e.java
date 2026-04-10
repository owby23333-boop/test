package com.kwad.components.core.webview.tachikoma;

import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c qn;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    public final void b(final com.kwad.sdk.core.response.a.a aVar) {
        if (this.qn != null) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    e.this.qn.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }
}
