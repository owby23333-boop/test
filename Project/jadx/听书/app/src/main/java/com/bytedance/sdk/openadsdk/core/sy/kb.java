package com.bytedance.sdk.openadsdk.core.sy;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.un;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    public static boolean z() {
        JSONObject jSONObjectTf = zw.g().tf();
        return jSONObjectTf != null && jSONObjectTf.optInt("video_cache", 0) == 1;
    }

    public static boolean g() {
        JSONObject jSONObjectTf = zw.g().tf();
        return jSONObjectTf != null && jSONObjectTf.optInt("pre_drop", 0) == 1;
    }

    public static boolean dl() {
        return com.bytedance.sdk.openadsdk.core.dl.gc.z().pf() == 1;
    }

    public static void z(final Function<SparseArray<Object>, Object> function) {
        dl dlVar;
        Function<SparseArray<Object>, Object> functionGb = com.bytedance.sdk.openadsdk.core.uy.ls().gb();
        if (zw.g().uf()) {
            Object objApply = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, "com.byted.csj.ext").g());
            if (objApply != null ? ((Boolean) objApply).booleanValue() : false) {
                Object objApply2 = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(7).z(Boolean.class).z(0, "com.byted.csj.ext").g());
                if (((objApply2 != null ? ((Boolean) objApply2).booleanValue() : false) || un.z().z(functionGb, false)) && (dlVar = (dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya")) != null) {
                    dlVar.init(zw.getContext(), new com.bytedance.sdk.openadsdk.core.ti.a() { // from class: com.bytedance.sdk.openadsdk.core.sy.kb.1
                        @Override // com.bytedance.sdk.openadsdk.core.ti.a
                        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                            if (function == null) {
                                return null;
                            }
                            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z(Void.class).z(-99999979, (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).g());
                            return null;
                        }
                    });
                }
            }
        }
    }
}
