package com.kwad.components.ad.reward.k;

import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean AC;
    }

    public void V(boolean z) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, com.kwad.sdk.core.webview.c.c cVar) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                boolean z;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z = aVar.AC;
                } catch (Exception unused) {
                    z = false;
                }
                f.this.V(z);
            }
        });
    }
}
