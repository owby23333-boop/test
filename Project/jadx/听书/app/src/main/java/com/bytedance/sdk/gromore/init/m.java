package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Function<SparseArray<Object>, Object> {
    private Context g;
    private Function<SparseArray<Object>, Object> z;

    public m(Context context, Function<SparseArray<Object>, Object> function) {
        this.z = function;
        this.g = context;
    }

    private PluginValueSet z(PluginValueSet pluginValueSet) {
        JSONArray jSONArray;
        if (pluginValueSet == null) {
            return null;
        }
        String strIq = new com.bytedance.sdk.openadsdk.ls.dl.dl.g(pluginValueSet.sparseArray()).iq();
        try {
            if (TextUtils.isEmpty(strIq)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(strIq);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals("personal_ads_type", jSONObjectOptJSONObject.optString("name"))) {
                    return pluginValueSet;
                }
            }
            JSONObject jSONObject = new JSONObject();
            com.bytedance.msdk.z.dl.dl dlVarG = com.bytedance.msdk.core.z.kb().g();
            if (dlVarG != null) {
                String str = dlVarG.e() ? "0" : "1";
                jSONObject.put("name", "personal_ads_type");
                jSONObject.put("value", str);
                jSONArray.put(jSONObject);
                return com.bytedance.sdk.openadsdk.mediation.g.g.z.z(pluginValueSet, jSONArray.toString());
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return pluginValueSet;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        g(sparseArray);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(android.util.SparseArray<java.lang.Object> r17) {
        /*
            Method dump skipped, instruction units count: 1171
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.m.g(android.util.SparseArray):void");
    }

    private void z(int i, PluginValueSet pluginValueSet) {
        if (this.z instanceof lq) {
            Object objObjectValue = z(pluginValueSet).objectValue(1, Object.class);
            if (objObjectValue == null) {
                wp.dl("apply->load with null callback");
            } else {
                ((lq) this.z).z(i, pluginValueSet, com.bytedance.sdk.openadsdk.l.dl.z(objObjectValue));
            }
        }
    }

    private void z(com.bytedance.sdk.gromore.z.z zVar, g.z zVar2) {
        zVar2.a(zVar.gc());
        zVar2.z(zVar.dl());
        zVar2.g(zVar.a());
        zVar2.g(zVar.g());
        zVar2.z(zVar.z());
    }

    private PluginValueSet z(PluginValueSet pluginValueSet, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z(pluginValueSet);
        zVarZ.z(260009, gVar.fo());
        zVarZ.z(260008, gVar.gz());
        zVarZ.z(260007, gVar.e());
        zVarZ.z(260006, gVar.m());
        zVarZ.z(260004, gVar.a());
        return zVarZ.g();
    }
}
