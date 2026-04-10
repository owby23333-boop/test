package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.jshandler.am;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends am {
    private long AH;
    private String AI;
    private WeakReference<com.kwad.components.ad.reward.g> td;

    public p(com.kwad.components.ad.reward.g gVar, String str, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.AI = str;
        this.AH = j;
        if (gVar != null) {
            this.td = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void b(boolean z, AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z, adTemplate, null, bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void a(am.b bVar) {
        if (b(bVar)) {
            return;
        }
        super.a(bVar);
    }

    private boolean b(am.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() != 140 || !com.kwad.sdk.core.config.e.BP() || !X(bVar.uD()) || (weakReference = this.td) == null || weakReference.get() == null) {
            return false;
        }
        final com.kwad.components.ad.reward.g gVar = this.td.get();
        bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.k.p.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                gVar.D(p.this.AI);
            }
        }, 1500L);
        return true;
    }

    private static boolean X(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.td;
        if (weakReference != null && weakReference.get() != null) {
            bVar.aw(this.td.get().rE.getPlayDuration());
            return;
        }
        long j = this.AH;
        if (j > 0) {
            bVar.aw(j);
        }
    }
}
