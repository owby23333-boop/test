package com.bytedance.sdk.openadsdk.p.z.z.z.z;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 123101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, bundle);
        this.z.apply(sparseArray);
    }
}
