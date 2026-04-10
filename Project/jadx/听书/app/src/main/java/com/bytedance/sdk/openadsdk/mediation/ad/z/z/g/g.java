package com.bytedance.sdk.openadsdk.mediation.ad.z.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final IMediationDislikeCallback z;

    public g(IMediationDislikeCallback iMediationDislikeCallback) {
        this.z = iMediationDislikeCallback;
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
            case 268013:
                this.z.onSelected(valueSetG.intValue(0), valueSetG.stringValue(1));
                return null;
            case 268014:
                this.z.onCancel();
                return null;
            case 268015:
                this.z.onShow();
                return null;
            default:
                return null;
        }
    }
}
