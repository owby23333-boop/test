package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean u(com.kwad.components.ad.reward.j jVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.bu(adInfoCb) && (aVar = jVar.py) != null && aVar.pp()) || com.kwad.components.ad.reward.kwai.b.l(adInfoCb) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.kwai.b.ha()) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.ay(adInfoCb) && com.kwad.sdk.core.response.a.a.al(adInfoCb);
    }
}
