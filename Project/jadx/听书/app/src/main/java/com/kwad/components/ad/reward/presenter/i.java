package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static boolean z(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bK(adInfoEl) && gVar.rF != null && gVar.rF.rS()) || com.kwad.components.ad.reward.a.b.k(adInfoEl) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.hL()) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.aF(adInfoEl) && com.kwad.sdk.core.response.b.a.at(adInfoEl);
    }
}
