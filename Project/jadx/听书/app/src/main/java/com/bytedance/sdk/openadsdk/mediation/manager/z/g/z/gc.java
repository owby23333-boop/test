package com.bytedance.sdk.openadsdk.mediation.manager.z.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gc extends dl {
    private SparseArray<Object> z;

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.m mVar);

    public abstract void setUseCustomVideo(boolean z);

    private SparseArray<Object> z() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z(super.values());
        aVarZ.z(270008, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(gc.this.hasDislike());
            }
        }));
        aVarZ.z(270011, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(gc.this.isExpress());
            }
        }));
        return aVarZ.g();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                SparseArray<Object> sparseArray2 = this.z;
                if (sparseArray2 != null) {
                    return sparseArray2;
                }
                SparseArray<Object> sparseArrayZ = z();
                this.z = sparseArrayZ;
                return sparseArrayZ;
            case 270009:
                setUseCustomVideo(pluginValueSetG.booleanValue(0));
                return null;
            case 270010:
                setShakeViewListener(new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.m((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            case 271048:
                onResume();
                return null;
            case 271049:
                onPause();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
