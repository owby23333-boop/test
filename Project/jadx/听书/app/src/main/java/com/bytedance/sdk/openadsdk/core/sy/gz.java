package com.bytedance.sdk.openadsdk.core.sy;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.UUID;
import java.util.function.LongSupplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gz extends com.bytedance.sdk.openadsdk.core.ti.a implements LongSupplier {
    protected PluginValueSet g(int i, SparseArray<Object> sparseArray) {
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    protected PluginValueSet z(int i, fo foVar) {
        return null;
    }

    protected PluginValueSet z(int i, gc gcVar) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        z(i, (SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class));
        return null;
    }

    public PluginValueSet z(int i, SparseArray<Object> sparseArray) {
        if (i == 1) {
            return z(i);
        }
        if (i == 6) {
            return z(i, new gc(sparseArray, i));
        }
        if (i == 3) {
            return dl(i, sparseArray);
        }
        if (i == 4) {
            return g(i);
        }
        switch (i) {
            case 8:
                return z(i, new fo(sparseArray, i));
            case 9:
                return g(i, sparseArray);
            case 10:
                z(sparseArray);
                return null;
            default:
                return null;
        }
    }

    private void z(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            try {
                PluginValueSet pluginValueSetA = new com.bytedance.sdk.openadsdk.ls.z(sparseArray).a();
                if (pluginValueSetA != null) {
                    String strStringValue = pluginValueSetA.stringValue(6);
                    JSONObject jSONObject = (JSONObject) pluginValueSetA.objectValue(7, JSONObject.class);
                    jSONObject.put("label", strStringValue);
                    com.bytedance.sdk.component.gz.g.a.z.z zVar = new com.bytedance.sdk.component.gz.g.a.z.z(UUID.randomUUID().toString(), jSONObject);
                    zVar.z((byte) 0);
                    zVar.g((byte) 2);
                    com.bytedance.sdk.component.gz.g.z.z(zVar, "csj");
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    public PluginValueSet z(int i) {
        return com.bykv.z.z.z.z.z.z().z(31, tb.dl()).g();
    }

    public PluginValueSet g(int i) {
        return com.bykv.z.z.z.z.z.z().z(32, String.valueOf(eo.gc())).g();
    }

    public PluginValueSet dl(int i, SparseArray<Object> sparseArray) {
        JSONObject jSONObjectNh = zw.g().nh();
        if (jSONObjectNh != null) {
            return com.bykv.z.z.z.z.z.z().z(33, jSONObjectNh).g();
        }
        return null;
    }
}
