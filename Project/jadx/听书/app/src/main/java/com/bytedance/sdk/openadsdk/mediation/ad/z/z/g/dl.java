package com.bytedance.sdk.openadsdk.mediation.ad.z.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeToBannerListener z;

    public dl(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.z = iMediationNativeToBannerListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        if (valueSetG.intValue(-99999987) != 266013) {
            return null;
        }
        return this.z.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.z.z.z.z(pf.z(valueSetG.objectValue(0, Object.class))));
    }
}
