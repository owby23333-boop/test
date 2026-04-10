package com.bytedance.sdk.openadsdk.io.z.z.z;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.ls.z.z.wp;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.AdInteractionListener g;
    private final ValueSet z = com.bykv.z.z.z.z.dl.z;

    public z(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
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
            case 141101:
                this.g.onAdClicked((View) valueSetG.objectValue(0, View.class), new wp(pf.z(valueSetG.objectValue(1, Object.class))));
                return null;
            case 141102:
                this.g.onAdCreativeClick((View) valueSetG.objectValue(0, View.class), new wp(pf.z(valueSetG.objectValue(1, Object.class))));
                return null;
            case 141103:
                this.g.onAdShow(new wp(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
