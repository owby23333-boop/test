package com.bytedance.sdk.openadsdk.io.z.z.z;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.ExpressRenderListener z;

    public dl(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.z = expressRenderListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        if (valueSetG.intValue(-99999987) == 142101) {
            this.z.onRenderSuccess((View) valueSetG.objectValue(0, View.class), valueSetG.floatValue(1), valueSetG.floatValue(2), valueSetG.booleanValue(3));
        }
        return null;
    }
}
