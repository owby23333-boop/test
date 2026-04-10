package com.bytedance.sdk.openadsdk.tb.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.ls.z.z.v;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.RewardVideoAdListener z;

    public m(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.z = rewardVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetG;
        if (this.z != null && (valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g()) != null) {
            switch (valueSetG.intValue(-99999987)) {
                case 124101:
                    this.z.onError(valueSetG.intValue(0), valueSetG.stringValue(1));
                    break;
                case 124102:
                    this.z.onRewardVideoAdLoad(new v(pf.z(valueSetG.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.z.onRewardVideoCached(new v(pf.z(valueSetG.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.z.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
