package com.bytedance.sdk.openadsdk.mediation.ad.z.z.g;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Function<SparseArray<Object>, Object> {
    private final MediationExpressRenderListener z;

    public m(MediationExpressRenderListener mediationExpressRenderListener) {
        this.z = mediationExpressRenderListener;
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
            case 142101:
                this.z.onRenderSuccess((View) valueSetG.objectValue(0, View.class), valueSetG.floatValue(1), valueSetG.floatValue(2), valueSetG.booleanValue(3));
                return null;
            case 142102:
                this.z.onRenderFail((View) valueSetG.objectValue(0, View.class), valueSetG.stringValue(1), valueSetG.intValue(2));
                return null;
            case 142103:
                this.z.onAdClick();
                return null;
            case 142104:
                this.z.onAdShow();
                return null;
            default:
                return null;
        }
    }
}
