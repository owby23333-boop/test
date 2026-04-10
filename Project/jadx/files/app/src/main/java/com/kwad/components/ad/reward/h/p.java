package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.j xw;

    public p(com.kwad.components.ad.reward.j jVar, AdTemplate adTemplate) {
        this.xw = jVar;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.mAdTemplate.isPlayAgainData = true;
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.h.p.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (p.this.xw != null) {
                        p.this.xw.C(true);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "neoDidShowPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.isPlayAgainData = false;
        }
    }
}
