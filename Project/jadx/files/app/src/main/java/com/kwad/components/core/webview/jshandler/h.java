package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.kwad.sdk.core.webview.b.a {
    private Handler Ss = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.b.c St;
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    public h(com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(WebCloseStatus webCloseStatus) {
        com.kwad.sdk.core.webview.c.kwai.b bVar = this.mWebCardCloseListener;
        if (bVar != null) {
            bVar.a(webCloseStatus);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.St = cVar;
        final WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.h.1
            @Override // java.lang.Runnable
            public final void run() {
                h.this.b(webCloseStatus);
                if (h.this.St != null) {
                    h.this.St.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return com.anythink.expressad.foundation.d.c.cf;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.St = null;
        this.Ss.removeCallbacksAndMessages(null);
    }
}
