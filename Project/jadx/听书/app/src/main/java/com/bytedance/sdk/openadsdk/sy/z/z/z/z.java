package com.bytedance.sdk.openadsdk.sy.z.z.z;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTRewardVideoAd.RewardAdInteractionListener z;

    public z(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.z = rewardAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 121101:
                this.z.onAdShow();
                return null;
            case 121102:
                this.z.onAdVideoBarClick();
                return null;
            case 121103:
                this.z.onAdClose();
                return null;
            case 121104:
                this.z.onVideoComplete();
                return null;
            case 121105:
                this.z.onVideoError();
                return null;
            case 121106:
                this.z.onRewardVerify(valueSetG.booleanValue(0), valueSetG.intValue(1), valueSetG.stringValue(2), valueSetG.intValue(3), valueSetG.stringValue(4));
                return null;
            case 121107:
                this.z.onRewardArrived(valueSetG.booleanValue(0), valueSetG.intValue(1), (Bundle) valueSetG.objectValue(2, Bundle.class));
                return null;
            case 121108:
                this.z.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
