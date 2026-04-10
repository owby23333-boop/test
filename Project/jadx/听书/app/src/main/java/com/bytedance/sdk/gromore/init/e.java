package com.bytedance.sdk.gromore.init;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.ti.z.a;
import com.bytedance.sdk.openadsdk.core.x;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.sdk.openadsdk.core.ti.a {
    private gz g;
    private final x z;

    public e(x xVar) {
        this.z = xVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Object objApply;
        if (i == -99999986) {
            x xVar = this.z;
            if (xVar != null) {
                return (T) xVar.z();
            }
        } else if (i == 6) {
            Bundle bundle = pluginValueSet != null ? (Bundle) pluginValueSet.objectValue(10, Bundle.class) : null;
            Class cls2 = pluginValueSet != null ? (Class) pluginValueSet.objectValue(9, Class.class) : null;
            if (bundle != null && TextUtils.equals(bundle.getString("mediation_manager"), "mediation_manager")) {
                if (this.g == null) {
                    this.g = new gz();
                }
                return (T) this.g;
            }
            if (com.bytedance.sdk.openadsdk.core.ti.z.a.z(cls2, bundle)) {
                x xVar2 = this.z;
                if (xVar2 != null) {
                    Object objApply2 = xVar2.apply(pluginValueSet.sparseArray());
                    if (objApply2 instanceof a.z) {
                        return (T) com.bytedance.sdk.openadsdk.core.ti.z.a.z(new fo((a.z) objApply2), cls2, bundle);
                    }
                }
                return null;
            }
            x xVar3 = this.z;
            if (xVar3 != null) {
                return (T) xVar3.apply(pluginValueSet.sparseArray());
            }
        } else if (i == 4) {
            Object objObjectValue = pluginValueSet != null ? pluginValueSet.objectValue(8, Object.class) : null;
            if (gk.e() && (objObjectValue instanceof Function)) {
                Function function = (Function) objObjectValue;
                PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(com.bytedance.sdk.openadsdk.ls.dl.z((Function<SparseArray<Object>, Object>) function)).g();
                if (pluginValueSetG != null && pluginValueSetG.intValue(10000) == 1 && (objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(5).z(Object.class).g())) != null) {
                    com.bytedance.msdk.core.z.kb().z(objApply);
                }
            }
            x xVar4 = this.z;
            if (xVar4 != null) {
                return (T) xVar4.apply(pluginValueSet.sparseArray());
            }
        } else {
            x xVar5 = this.z;
            if (xVar5 != null) {
                return (T) xVar5.apply(pluginValueSet.sparseArray());
            }
        }
        return null;
    }
}
