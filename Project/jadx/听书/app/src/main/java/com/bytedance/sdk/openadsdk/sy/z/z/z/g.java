package com.bytedance.sdk.openadsdk.sy.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTRewardVideoAd.RewardAdPlayAgainController z;

    public g(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.z = rewardAdPlayAgainController;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = dl.z(sparseArray).g();
        if (valueSetG.intValue(-99999987) == 122101) {
            this.z.getPlayAgainCondition(valueSetG.intValue(0), new com.bytedance.sdk.openadsdk.p.z.z.z.z.z(pf.z(valueSetG.objectValue(1, Object.class))));
        }
        return null;
    }
}
