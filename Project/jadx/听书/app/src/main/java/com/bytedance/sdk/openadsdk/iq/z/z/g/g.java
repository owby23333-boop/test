package com.bytedance.sdk.openadsdk.iq.z.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTFeedAd.VideoRewardListener z;

    public g(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.z = videoRewardListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = dl.z(sparseArray).g();
        if (valueSetG.intValue(-99999987) == 163101) {
            this.z.onFeedRewardCountDown(valueSetG.intValue(0));
        }
        return null;
    }
}
