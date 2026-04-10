package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static void m(j jVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = jVar.mAdTemplate;
        Context context = jVar.mContext;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.bu(adInfoCb) && (aVar = jVar.py) != null && aVar.pp()) || com.kwad.components.ad.reward.kwai.b.l(adInfoCb) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.ay(adInfoCb) || !com.kwad.sdk.core.response.a.a.al(adInfoCb) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        jVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
