package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class aa implements com.kwad.sdk.core.webview.c.a {
    private Handler acR = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c acS;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return ILivePush.ClickType.CLOSE;
    }

    public aa(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        final WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.aa.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                aa.this.c(webCloseStatus);
                if (aa.this.acS != null) {
                    aa.this.acS.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.acS = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(WebCloseStatus webCloseStatus) {
        com.kwad.sdk.core.webview.d.a.b bVar = this.mWebCardCloseListener;
        if (bVar != null) {
            bVar.b(webCloseStatus);
        }
    }
}
