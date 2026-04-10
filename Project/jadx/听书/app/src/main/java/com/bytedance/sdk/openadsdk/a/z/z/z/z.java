package com.bytedance.sdk.openadsdk.a.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final CSJSplashAd.SplashAdListener z;

    public z(CSJSplashAd.SplashAdListener splashAdListener) {
        this.z = splashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z != null && sparseArray != null) {
            ValueSet valueSetG = dl.z(sparseArray).g();
            switch (valueSetG.intValue(-99999987)) {
                case 111101:
                    this.z.onSplashAdShow(new com.bytedance.sdk.openadsdk.ls.z.z.g(pf.z(valueSetG.objectValue(0, Object.class))));
                    break;
                case 111102:
                    this.z.onSplashAdClick(new com.bytedance.sdk.openadsdk.ls.z.z.g(pf.z(valueSetG.objectValue(0, Object.class))));
                    break;
                case 111103:
                    this.z.onSplashAdClose(new com.bytedance.sdk.openadsdk.ls.z.z.g(pf.z(valueSetG.objectValue(0, Object.class))), valueSetG.intValue(1));
                    break;
            }
        }
        return null;
    }
}
