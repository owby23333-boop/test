package com.bytedance.sdk.openadsdk.js.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTAdDislike.DislikeInteractionCallback z;

    public z(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.z = dislikeInteractionCallback;
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
            case 244101:
                this.z.onShow();
                return null;
            case 244102:
                this.z.onSelected(valueSetG.intValue(0), valueSetG.stringValue(1), valueSetG.booleanValue(2));
                return null;
            case 244103:
                this.z.onCancel();
                return null;
            default:
                return null;
        }
    }
}
