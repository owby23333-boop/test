package com.bytedance.sdk.openadsdk.tb.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ls.z.z.uy;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.FullScreenVideoAdListener z;

    public dl(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.z = fullScreenVideoAdListener;
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
            case 132101:
                this.z.onError(valueSetG.intValue(0), valueSetG.stringValue(1));
                return null;
            case 132102:
                this.z.onFullScreenVideoAdLoad(new uy((Function) valueSetG.objectValue(0, Function.class)));
                return null;
            case 132103:
                this.z.onFullScreenVideoCached(new uy((Function) valueSetG.objectValue(0, Function.class)));
                return null;
            case 132104:
                this.z.onFullScreenVideoCached();
                return null;
            default:
                return null;
        }
    }
}
