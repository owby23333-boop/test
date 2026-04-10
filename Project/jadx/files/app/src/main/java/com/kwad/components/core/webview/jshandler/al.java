package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class al implements com.kwad.sdk.core.webview.b.a {
    private a Ud;

    public interface a {
        void ri();
    }

    public al(a aVar) {
        this.Ud = aVar;
    }

    private void rx() {
        if (com.kwad.components.core.d.a.b.na()) {
            return;
        }
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.al.1
            @Override // java.lang.Runnable
            public final void run() {
                if (al.this.Ud != null) {
                    al.this.Ud.ri();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        rx();
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
