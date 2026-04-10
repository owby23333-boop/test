package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements c {
    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new j(aVar));
    }

    public static void a(final com.kwad.components.core.request.model.a aVar, j jVar) {
        new com.kwad.components.core.n.a(aVar.Rw) { // from class: com.kwad.components.core.c.n.1
            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: ou */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.i.class);
                    aVar.Xe = iVar.S();
                }
                return new com.kwad.components.core.request.a(aVar);
            }

            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: af, reason: merged with bridge method [inline-methods] */
            public final AdResultData parseData(String str) {
                AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(str, aVar.Rw.adScene);
                adResultDataCreateFromResponseJson.setAdSource("network");
                return adResultDataCreateFromResponseJson;
            }
        }.request(jVar);
    }
}
