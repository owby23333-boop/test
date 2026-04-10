package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bi implements com.kwad.sdk.core.webview.c.a {
    private static Handler aeD;
    private com.kwad.components.core.e.d.c Pc;
    private com.kwad.sdk.core.webview.b aeC;
    private b aeE;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int mI;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void ae(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bi(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.aeC = bVar;
        this.Pc = cVar;
        this.aeE = bVar2;
        if (aeD == null) {
            aeD = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.mI;
            aeD.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bi.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (bi.this.aeE != null) {
                        bi.this.aeE.ae(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
