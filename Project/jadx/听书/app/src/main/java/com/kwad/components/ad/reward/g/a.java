package com.kwad.components.ad.reward.g;

import android.content.Context;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e implements h {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        if (!l.Cf().CG()) {
            rewardVideoAdListener.onError(com.kwad.sdk.core.network.e.aEz.errorCode, com.kwad.sdk.core.network.e.aEz.msg);
        } else {
            b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
        }
    }

    @Override // com.kwad.components.ad.b.h
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.gk().notifyRewardVerify();
    }
}
