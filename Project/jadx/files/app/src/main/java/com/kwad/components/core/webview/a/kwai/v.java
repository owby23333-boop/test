package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c UG;

    @NonNull
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> UH = new CopyOnWriteArrayList<>();

    @Override // com.kwad.sdk.core.webview.b.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.UG = cVar;
        if (this.UH.size() > 0) {
            for (com.kwad.sdk.core.b bVar : this.UH) {
                b(bVar);
                this.UH.remove(bVar);
            }
        }
    }

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.UG != null) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.kwai.v.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (v.this.UG != null) {
                        v.this.UG.a(bVar);
                    }
                }
            });
        } else {
            this.UH.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.UG = null;
    }
}
