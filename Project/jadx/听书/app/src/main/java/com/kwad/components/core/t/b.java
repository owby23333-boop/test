package com.kwad.components.core.t;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static volatile b YH;

    public static b sY() {
        if (YH == null) {
            synchronized (b.class) {
                if (YH == null) {
                    YH = new b();
                }
            }
        }
        return YH;
    }

    private b() {
    }

    public final boolean a(final AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean zB = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            boolean z = false;
            if (adTemplate.mAdScene != null && adTemplate.mAdScene.adStyle == 10000) {
                z = true;
            }
            if (adTemplate.adStyle == 3 || adTemplate.adStyle == 2 || adTemplate.adStyle == 13 || z) {
                com.kwad.sdk.core.response.b.e.el(adTemplate);
                if (zB && com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.c.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.t.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.c.a aVarNZ = com.kwad.components.core.c.a.nZ();
                if (aVarNZ != null) {
                    aVarNZ.w(com.kwad.sdk.core.response.b.e.ev(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.om().av(adTemplate);
        return zB;
    }
}
