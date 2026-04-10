package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.x;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements Function<SparseArray<Object>, Object> {
    private e dl;
    private a g = new a();
    private x z;

    public uy(x xVar) {
        this.z = xVar;
        this.dl = new e(this.z);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        if (iIntValue == -99999986) {
            x xVar = this.z;
            if (xVar != null) {
                return xVar.z();
            }
        } else if (iIntValue != -999800) {
            if (iIntValue == 8303 || iIntValue == 999801) {
                if (iIntValue == 8303) {
                    com.bytedance.msdk.z.gc.dl.g("TMe", "initRequestCondition getBridge");
                    return this.g;
                }
                if (this.z != null) {
                    return this.dl;
                }
            }
        } else if (this.z != null) {
            Context context = (Context) pluginValueSetG.objectValue(-998000, Context.class);
            return new m(context, this.z.z(context));
        }
        return null;
    }
}
