package com.bytedance.sdk.openadsdk.a.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final CSJSplashAd.SplashCardListener z;

    public g(CSJSplashAd.SplashCardListener splashCardListener) {
        this.z = splashCardListener;
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
            case 112102:
                this.z.onSplashCardClick();
                return null;
            case 112103:
                this.z.onSplashCardClose();
                return null;
            case 121201:
                this.z.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.ls.z.z.g(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
