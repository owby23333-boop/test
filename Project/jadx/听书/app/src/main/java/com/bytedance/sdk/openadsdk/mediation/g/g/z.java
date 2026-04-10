package com.bytedance.sdk.openadsdk.mediation.g.g;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.lang.reflect.Field;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.ls.dl.dl.g {
    private final PluginValueSet g;

    public z(SparseArray<Object> sparseArray) {
        super(sparseArray);
        this.g = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public boolean hh() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet == null) {
            return false;
        }
        return pluginValueSet.booleanValue(8260030);
    }

    private static Function<SparseArray<Object>, Object> z(PluginValueSet pluginValueSet) {
        Object objObjectValue;
        if (pluginValueSet != null) {
            objObjectValue = pluginValueSet.objectValue(8260028, Object.class);
            if (objObjectValue == null) {
                try {
                    objObjectValue = pluginValueSet.objectValue(260026, Function.class);
                } catch (Throwable unused) {
                }
            }
        } else {
            objObjectValue = null;
        }
        return com.bytedance.sdk.openadsdk.l.dl.z(objObjectValue);
    }

    public g l() {
        Function<SparseArray<Object>, Object> functionZ = z(this.g);
        if (functionZ != null) {
            return new g(functionZ);
        }
        return null;
    }

    public String h() {
        PluginValueSet pluginValueSet = this.g;
        if (pluginValueSet == null) {
            return null;
        }
        return (String) pluginValueSet.objectValue(8260029, String.class);
    }

    public static final PluginValueSet z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        return z(gVar, null, false);
    }

    public static final PluginValueSet z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, boolean z) {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        if (gVar == null) {
            return zVarZ.g();
        }
        zVarZ.z(260001, gVar.z());
        zVarZ.z(260002, gVar.g());
        zVarZ.z(260003, gVar.dl());
        zVarZ.z(260004, gVar.a());
        zVarZ.z(260005, gVar.gc());
        zVarZ.z(260006, gVar.m());
        zVarZ.z(260007, gVar.e());
        zVarZ.z(7, gVar.m());
        zVarZ.z(8, gVar.e());
        zVarZ.z(260008, gVar.gz());
        zVarZ.z(260009, gVar.fo());
        zVarZ.z(10, gVar.gz());
        zVarZ.z(9, gVar.fo());
        zVarZ.z(260010, gVar.uy());
        zVarZ.z(260011, gVar.kb());
        zVarZ.z(2600012, gVar.wp());
        zVarZ.z(260013, gVar.i());
        zVarZ.z(260014, gVar.v());
        zVarZ.z(260015, gVar.pf());
        zVarZ.z(260016, gVar.ls());
        zVarZ.z(260017, gVar.p());
        zVarZ.z(260018, gVar.fv());
        zVarZ.z(260019, gVar.js());
        zVarZ.z(260020, gVar.tb());
        zVarZ.z(260021, gVar.q());
        zVarZ.z(260022, gVar.iq());
        zVarZ.z(260023, gVar.zw());
        PluginValueSet pluginValueSet = null;
        try {
            for (Field field : gVar.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(gVar) instanceof PluginValueSet) {
                    pluginValueSet = (PluginValueSet) field.get(gVar);
                }
                field.setAccessible(false);
            }
        } catch (Exception unused) {
        }
        if (pluginValueSet != null) {
            zVarZ.z(8260028, z(pluginValueSet));
            zVarZ.z(260027, pluginValueSet.objectValue(260027, IMediationAdSlot.class));
        }
        zVarZ.z(260024, gVar.io());
        zVarZ.z(260025, gVar.uf());
        zVarZ.z(260008, gVar.gz());
        if (!TextUtils.isEmpty(str)) {
            zVarZ.z(8260029, str);
            zVarZ.z(8260030, z);
        }
        return zVarZ.g();
    }

    public PluginValueSet gk() {
        return this.g;
    }

    public static PluginValueSet z(PluginValueSet pluginValueSet, String str) {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z(pluginValueSet);
        zVarZ.z(260022, str);
        return zVarZ.g();
    }
}
