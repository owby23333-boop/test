package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.tachikoma.b.w;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAggregationDataListener";
    }

    public final void g(List<AdTemplate> list) {
        AdResultData adResultData = new AdResultData();
        adResultData.setAdTemplateList(list);
        b(new af.a(adResultData));
    }
}
