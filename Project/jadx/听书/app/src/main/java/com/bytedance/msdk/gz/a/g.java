package com.bytedance.msdk.gz.a;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static Function<SparseArray<Object>, Object> z;

    public static void z(Function<SparseArray<Object>, Object> function) {
        z = function;
    }

    public static void z(com.bytedance.msdk.gc.z zVar, boolean z2) {
        if (zVar != null && com.bytedance.msdk.core.z.kb().tb()) {
            g(zVar, z2);
        }
    }

    private static void g(com.bytedance.msdk.gc.z zVar, boolean z2) {
        if (z != null) {
            com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
            if (z2) {
                aVarZ.z(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS).z(Void.class);
                aVarZ.z(20003, zVar.dl());
                z.apply(aVarZ.g());
            } else {
                aVarZ.z(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS).z(Void.class);
                aVarZ.z(20002, zVar.dl());
                z.apply(aVarZ.g());
            }
        }
    }
}
