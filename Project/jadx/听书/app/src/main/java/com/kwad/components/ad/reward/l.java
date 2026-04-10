package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static void j(g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bK(adInfoEl) && gVar.rF != null && gVar.rF.rS()) || com.kwad.components.ad.reward.a.b.k(adInfoEl) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.b.a.aF(adInfoEl) || !com.kwad.sdk.core.response.b.a.at(adInfoEl) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
