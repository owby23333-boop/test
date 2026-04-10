package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c agJ;
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> agK = new CopyOnWriteArrayList<>();

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.agJ != null) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.b.w.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (w.this.agJ != null) {
                        w.this.agJ.a(bVar);
                    }
                }
            });
        } else {
            this.agK.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.agJ = cVar;
        if (this.agK.size() > 0) {
            for (com.kwad.sdk.core.b bVar : this.agK) {
                b(bVar);
                this.agK.remove(bVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.agJ = null;
    }
}
