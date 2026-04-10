package com.bytedance.sdk.openadsdk.tools;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private static volatile dl z;

    private dl() {
    }

    public static dl z() {
        if (z == null) {
            z = new dl();
        }
        return z;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        if (iIntValue == 10001) {
            uy.ls().fo(pluginValueSetG.booleanValue(1));
            return null;
        }
        if (iIntValue == 10002) {
            return Boolean.valueOf(uy.ls().b());
        }
        if (iIntValue == 10003) {
            zw.z().z((Function<SparseArray<Object>, Object>) pluginValueSetG.objectValue(0, Function.class));
            return null;
        }
        if (iIntValue != 10004) {
            if (iIntValue != 10005) {
                return null;
            }
            com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
            zVarZ.z(0, uy.ls().rv());
            zVarZ.z(1, uy.ls().tc());
            return zVarZ.g().sparseArray();
        }
        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetG.objectValue(0, Function.class);
        String str = (String) pluginValueSetG.objectValue(1, String.class);
        String str2 = (String) pluginValueSetG.objectValue(2, String.class);
        String str3 = (String) pluginValueSetG.objectValue(3, String.class);
        String str4 = (String) pluginValueSetG.objectValue(4, String.class);
        HashMap map = new HashMap();
        map.put("adtype", str2);
        map.put("rit", str);
        map.put("image_mode", str3);
        map.put("preview_extra", str4);
        zw.z().z(map, function);
        return null;
    }
}
