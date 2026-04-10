package com.kwad.components.ad.reward.c;

import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d tc;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateExtraReward";
    }

    public f(d dVar) {
        this.tc = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (f.this.tc != null) {
                        f.this.tc.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.tc = null;
    }
}
