package com.kwad.components.ad.reward.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.webview.b.a {
    private d qP;

    public f(d dVar) {
        this.qP = dVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.qP != null) {
                        f.this.qP.a(bVar);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.qP = null;
    }
}
