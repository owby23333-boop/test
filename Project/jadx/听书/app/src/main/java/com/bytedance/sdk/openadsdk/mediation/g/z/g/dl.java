package com.bytedance.sdk.openadsdk.mediation.g.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeAdTokenCallback z;

    public dl(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.z = iMediationNativeAdTokenCallback;
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
            case 270026:
                this.z.onAdTokenLoaded(valueSetG.stringValue(0), new com.bytedance.sdk.openadsdk.mediation.g.z.z.dl(pf.z(valueSetG.objectValue(1, Object.class))));
                return null;
            case 270027:
                this.z.onAdTokenLoadedFail(valueSetG.intValue(0), valueSetG.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
