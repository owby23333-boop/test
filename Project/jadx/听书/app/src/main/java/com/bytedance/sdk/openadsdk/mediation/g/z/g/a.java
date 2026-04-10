package com.bytedance.sdk.openadsdk.mediation.g.z.g;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Function<SparseArray<Object>, Object> {
    private final IMediationPreloadRequestInfo z;

    public a(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.z = iMediationPreloadRequestInfo;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        switch (com.bykv.z.z.z.z.dl.z(sparseArray).g().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.z.getAdType()));
            case 271045:
                SparseArray<Object> sparseArrayZ = com.bytedance.sdk.openadsdk.ls.z.dl.g.z(this.z.getAdSlot());
                return sparseArrayZ != null ? sparseArrayZ : new SparseArray();
            case 271046:
                return this.z.getPrimeRitList();
            default:
                return com.bykv.z.z.z.z.dl.dl.apply(sparseArray);
        }
    }
}
