package com.bytedance.msdk.gz.a;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static void z(com.bytedance.sdk.gromore.z.g.z zVar) {
        if (zVar == null) {
            return;
        }
        Function<SparseArray<Object>, Object> functionUf = zVar.uf();
        if (functionUf != null) {
            Object objApply = functionUf.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(10001).z(Boolean.class).g());
            if (objApply instanceof Boolean) {
                z.z(((Boolean) objApply).booleanValue());
            }
        }
        if (zVar.hh() != null) {
            Object objApply2 = functionUf.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB).z(Map.class).g());
            if (objApply2 instanceof Map) {
                System.out.println("onetap " + objApply2.toString());
                dl.z((Map) objApply2);
            }
        }
        g.z(zVar.sy());
        a.z(zVar.l());
    }
}
