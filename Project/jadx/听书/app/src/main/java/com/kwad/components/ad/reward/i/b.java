package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bj;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends bj implements bj.a {
    private PlayableSource vw;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.vw = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bj.a
    public final boolean eM() {
        com.kwad.components.ad.reward.a.gg().c(this.vw, new a(this.mContext));
        return false;
    }
}
