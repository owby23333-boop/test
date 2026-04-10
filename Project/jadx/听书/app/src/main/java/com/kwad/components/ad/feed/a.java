package com.kwad.components.ad.feed;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.d {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.d.class;
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        if (!l.Cf().CG()) {
            feedAdListener.onError(com.kwad.sdk.core.network.e.aEz.errorCode, com.kwad.sdk.core.network.e.aEz.msg);
        } else {
            e.a(ksScene, feedAdListener, !com.kwad.components.ad.feed.a.b.cg());
        }
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        e.a(ksScene, feedAdListener, true);
    }
}
