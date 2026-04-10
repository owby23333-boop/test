package com.bytedance.sdk.openadsdk.ls.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.CSJSplashAdListener z;

    public g(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.z = cSJSplashAdListener;
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
            case 114102:
                this.z.onSplashLoadSuccess(new com.bytedance.sdk.openadsdk.ls.z.z.g(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 114103:
                this.z.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ls.z.z.z(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 114104:
                this.z.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.ls.z.z.g((Function) valueSetG.objectValue(0, Function.class)));
                return null;
            case 114105:
                this.z.onSplashRenderFail(new com.bytedance.sdk.openadsdk.ls.z.z.g(pf.z(valueSetG.objectValue(0, Object.class))), new com.bytedance.sdk.openadsdk.ls.z.z.z(pf.z(valueSetG.objectValue(1, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
