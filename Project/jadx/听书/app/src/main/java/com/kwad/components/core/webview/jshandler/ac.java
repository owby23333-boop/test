package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    private boolean acJ;
    private Handler acR;
    private boolean acV;
    private boolean acW;
    private final com.kwad.sdk.core.webview.b acw;
    private com.kwad.sdk.core.webview.d.a.a eT;
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "convert";
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, boolean z2, boolean z3) {
        this.acV = false;
        this.acW = false;
        this.acJ = z;
        this.acR = new Handler(Looper.getMainLooper());
        this.acw = bVar;
        this.mApkDownloadHelper = cVar;
        this.acV = false;
        if (cVar != null) {
            cVar.aG(1);
        }
        this.eT = aVar;
        this.acW = z3;
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, byte b) {
        this(bVar, cVar, aVar, false, false, false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.acw.KJ()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.OU = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.acw.aMP) {
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ac.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ac.this.acw.aMQ || aVar.adL) {
                        ac.this.acw.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(ac.this.acw.TG.getContext(), ac.this.acw.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.ac.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (ac.this.eT != null) {
                                    ac.this.eT.a(aVar);
                                }
                            }
                        }, ac.this.mApkDownloadHelper, aVar.adL, ac.this.acJ, ac.this.acV, ac.this.acW);
                    }
                }
            });
        } else if (this.eT != null) {
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ac.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ac.this.eT != null) {
                        ac.this.eT.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acR.removeCallbacksAndMessages(null);
        this.eT = null;
    }
}
