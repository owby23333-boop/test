package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.kwai.v;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends v {
    public final void f(@NonNull List<AdTemplate> list) {
        b(new m.a(list));
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerAggregationDataListener";
    }
}
