package com.bytedance.sdk.openadsdk.uf.z.z.z;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.AdInteractionListener z;

    public z(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.z = adInteractionListener;
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
            case 151101:
                this.z.onAdClicked((View) valueSetG.objectValue(0, View.class), valueSetG.intValue(1));
                return null;
            case 151102:
                this.z.onAdShow((View) valueSetG.objectValue(0, View.class), valueSetG.intValue(1));
                return null;
            case 151103:
                this.z.onRenderFail((View) valueSetG.objectValue(0, View.class), valueSetG.stringValue(1), valueSetG.intValue(2));
                return null;
            case 151104:
                this.z.onRenderSuccess((View) valueSetG.objectValue(0, View.class), valueSetG.floatValue(1), valueSetG.floatValue(2));
                return null;
            case 151105:
                this.z.onAdDismiss();
                return null;
            default:
                return null;
        }
    }
}
