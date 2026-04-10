package com.bytedance.sdk.openadsdk.mediation.g.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final IMediationDrawAdTokenCallback z;

    public z(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.z = iMediationDrawAdTokenCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        int iIntValue = valueSetG.intValue(-99999987);
        valueSetG.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case 270029:
                this.z.onAdTokenLoaded(valueSetG.stringValue(0), new com.bytedance.sdk.openadsdk.mediation.g.z.z.z(pf.z(valueSetG.objectValue(1, Object.class))));
                return null;
            case 270030:
                this.z.onAdTokenLoadedFail(valueSetG.intValue(0), valueSetG.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
