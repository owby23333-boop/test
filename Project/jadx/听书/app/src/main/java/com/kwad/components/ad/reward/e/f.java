package com.kwad.components.ad.reward.e;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final HashMap<String, f> us = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.j.d rt;
    private KsRewardVideoAd.RewardAdInteractionListener ut;

    private static f M(String str) {
        return us.get(str);
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.rt = dVar;
        fVar.ut = rewardAdInteractionListener;
        us.put(str, fVar);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener N(String str) {
        f fVarM = M(str);
        if (fVarM != null) {
            return fVarM.ut;
        }
        return null;
    }

    public static void O(String str) {
        f fVarM = M(str);
        if (fVarM != null) {
            fVarM.ut = fVarM.mInteractionListener;
        }
    }

    public static com.kwad.components.core.j.d P(String str) {
        f fVarM = M(str);
        if (fVarM != null) {
            return fVarM.rt;
        }
        return null;
    }

    public static void Q(String str) {
        f fVarM = M(str);
        if (fVarM != null) {
            fVarM.destroy();
            us.put(str, null);
        }
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.ut = null;
        com.kwad.components.core.j.d dVar = this.rt;
        if (dVar != null) {
            dVar.destroy();
            this.rt = null;
        }
    }
}
