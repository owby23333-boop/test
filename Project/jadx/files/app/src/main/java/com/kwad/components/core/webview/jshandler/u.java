package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;
    private final Handler Ss;

    @Nullable
    private final b Tq;

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean Tw;
        public String Tx;
        public int Ty;
        public com.kwad.sdk.core.webview.c.a.c Tz;
    }

    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        final com.kwad.components.core.d.b.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Tx));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (com.kwad.sdk.core.response.a.d.bT(adTemplate)) {
            if (this.Sk.aoN != null) {
                cVar2 = (com.kwad.components.core.d.b.c) this.Sk.aoN.en(com.kwad.sdk.core.response.a.d.cb(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.Sk.aoO) {
                this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.u.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.b bVar = new y.b();
                        bVar.To = aVar.Tz.To;
                        com.kwad.components.core.d.b.a.a(new a.C0395a(u.this.Sk.LI.getContext()).J(adTemplate).b(cVar2).ap(aVar.Ty).al(true).a(bVar).an(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.u.1.1
                            @Override // com.kwad.components.core.d.b.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.Tq != null) {
                this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Ss.removeCallbacksAndMessages(null);
    }
}
