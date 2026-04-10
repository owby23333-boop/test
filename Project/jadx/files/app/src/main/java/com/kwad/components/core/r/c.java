package com.kwad.components.core.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static volatile c PO;

    private c() {
    }

    @NonNull
    public static c qa() {
        if (PO == null) {
            synchronized (c.class) {
                if (PO == null) {
                    PO = new c();
                }
            }
        }
        return PO;
    }

    public final void a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.i iVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.b.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        com.kwad.sdk.core.report.a.b(adTemplate, (JSONObject) null, iVar);
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.r.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.b.a aVarMr = com.kwad.components.core.b.a.mr();
                if (aVarMr != null) {
                    aVarMr.m(com.kwad.sdk.core.response.a.d.ck(adTemplate));
                }
            }
        });
        com.kwad.components.core.b.f.mF().G(adTemplate);
    }
}
