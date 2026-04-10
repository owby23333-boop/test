package com.bytedance.sdk.openadsdk.uf.z.z.z;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.ExpressAdInteractionListener g;
    private final ValueSet z = com.bykv.z.z.z.z.dl.z;

    public g(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.g = expressAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.g == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 151101:
                this.g.onAdClicked((View) valueSetG.objectValue(0, View.class), valueSetG.intValue(1));
                return null;
            case 151102:
                this.g.onAdShow((View) valueSetG.objectValue(0, View.class), valueSetG.intValue(1));
                return null;
            case 151103:
                this.g.onRenderFail((View) valueSetG.objectValue(0, View.class), valueSetG.stringValue(1), valueSetG.intValue(2));
                return null;
            case 151104:
                this.g.onRenderSuccess((View) valueSetG.objectValue(0, View.class), valueSetG.floatValue(1), valueSetG.floatValue(2));
                return null;
            default:
                return null;
        }
    }
}
