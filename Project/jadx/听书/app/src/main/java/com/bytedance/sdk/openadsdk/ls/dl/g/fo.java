package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fo extends uy {
    private SparseArray<Object> z;

    public abstract void z(Bitmap bitmap, int i);

    public abstract void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar);

    public abstract void z(boolean z);

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy, com.bytedance.sdk.openadsdk.ls.dl.g.i
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArraySy = sy();
        this.z = sparseArraySy;
        return sparseArraySy;
    }

    private SparseArray<Object> sy() {
        return super.u_();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy, com.bytedance.sdk.openadsdk.ls.dl.g.i, com.bytedance.sdk.openadsdk.ls.dl.g.gz, java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return u_();
        }
        if (iIntValue != 140111) {
            switch (iIntValue) {
                case 170101:
                    z(pluginValueSetG.booleanValue(0));
                    break;
                case 170102:
                    z((Bitmap) pluginValueSetG.objectValue(0, Bitmap.class), pluginValueSetG.intValue(1));
                    break;
                case 170103:
                    z(new com.bytedance.sdk.openadsdk.q.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                    break;
                default:
                    return super.apply(sparseArray);
            }
        } else {
            Function function = (Function) pluginValueSetG.objectValue(0, Function.class);
            if (pluginValueSetG.intValue(1) == 1) {
                dlVar = new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc(function);
            } else {
                dlVar = new com.bytedance.sdk.openadsdk.io.z.g.z.dl(function);
            }
            z(dlVar);
        }
        return null;
    }
}
