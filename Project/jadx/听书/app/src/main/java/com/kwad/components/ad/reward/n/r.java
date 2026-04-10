package com.kwad.components.ad.reward.n;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public static r aa(AdTemplate adTemplate) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        return rVar;
    }

    public static r a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        rVar.setApkDownloadHelper(cVar);
        return rVar;
    }

    private r() {
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final com.kwad.components.core.e.d.c ij() {
        return this.mApkDownloadHelper;
    }

    private void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
