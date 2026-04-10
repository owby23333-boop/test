package com.kwad.components.ad.reward.f;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends an implements an.a {
    private PlayableSource sm;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.sm = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.an.a
    public final boolean dC() {
        com.kwad.components.ad.reward.b.fz().c(this.sm, new a(this.mContext));
        return false;
    }
}
