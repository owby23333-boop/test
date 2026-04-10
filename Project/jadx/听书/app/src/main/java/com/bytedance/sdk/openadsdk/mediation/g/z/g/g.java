package com.bytedance.sdk.openadsdk.mediation.g.z.g;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final IMediationInterstitialFullAdListener z;

    public g(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.z = iMediationInterstitialFullAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 131101:
                this.z.onAdShow();
                return null;
            case 131102:
                this.z.onAdVideoBarClick();
                return null;
            case 131103:
                this.z.onAdClose();
                return null;
            case 131104:
                this.z.onVideoComplete();
                return null;
            case 131105:
                this.z.onSkippedVideo();
                return null;
            case 131106:
                this.z.onInterstitialFullShowFail(valueSetG.intValue(0), valueSetG.stringValue(1));
                return null;
            case 131107:
                this.z.onVideoError();
                return null;
            case 131108:
                this.z.onAdOpened();
                return null;
            case 131109:
                this.z.onAdLeftApplication();
                return null;
            case 131110:
                this.z.onRewardVerify((Bundle) valueSetG.objectValue(0, Bundle.class));
                return null;
            default:
                return null;
        }
    }
}
