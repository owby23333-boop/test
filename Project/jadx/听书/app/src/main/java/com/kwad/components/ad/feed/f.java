package com.kwad.components.ad.feed;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static String l(AdTemplate adTemplate) {
        String strAu = com.kwad.sdk.core.response.b.a.au(com.kwad.sdk.core.response.b.e.el(adTemplate));
        if (com.kwad.components.core.c.b.oc()) {
            return (adTemplate.fromCache ? "【cache】" : "") + strAu;
        }
        return strAu;
    }
}
