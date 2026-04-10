package com.bytedance.sdk.openadsdk.mediation.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final MediationAdDislike z;

    public g(MediationAdDislike mediationAdDislike) {
        this.z = mediationAdDislike;
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
            case 270032:
                this.z.showDislikeDialog();
                return null;
            case 270033:
                this.z.setDislikeCallback(new z(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
