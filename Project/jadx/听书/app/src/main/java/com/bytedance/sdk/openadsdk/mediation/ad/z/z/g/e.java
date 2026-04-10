package com.bytedance.sdk.openadsdk.mediation.ad.z.z.g;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Function<SparseArray<Object>, Object> {
    private final MediationShakeViewListener z;

    public e(MediationShakeViewListener mediationShakeViewListener) {
        this.z = mediationShakeViewListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z != null && com.bykv.z.z.z.z.dl.z(sparseArray).g().intValue(-99999987) == 270012) {
            this.z.onDismissed();
        }
        return null;
    }
}
