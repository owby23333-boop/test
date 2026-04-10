package com.bytedance.sdk.openadsdk.mediation.g.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements Function<SparseArray<Object>, Object> {
    private final MediationAppDialogClickListener z;

    public gc(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.z = mediationAppDialogClickListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        if (valueSetG.intValue(-99999987) == 270025) {
            this.z.onButtonClick(valueSetG.intValue(0));
        }
        return null;
    }
}
