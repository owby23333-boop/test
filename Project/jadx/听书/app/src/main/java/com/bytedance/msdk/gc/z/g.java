package com.bytedance.msdk.gc.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z<com.bytedance.msdk.core.gz.e> {
    private Context z;

    public g(Context context) {
        if (context != null) {
            this.z = context.getApplicationContext();
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    /* JADX INFO: renamed from: z, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void g(com.bytedance.msdk.core.gz.e eVar) {
        if (this.z != null && eVar != null) {
            l lVarZ = l.z("freqctl_" + eVar.g(), this.z);
            String strA = eVar.a();
            JSONObject jSONObjectZ = z(eVar, true);
            if (jSONObjectZ != null) {
                lVarZ.z(strA, jSONObjectZ.toString());
            }
        }
    }

    private JSONObject z(com.bytedance.msdk.core.gz.e eVar, boolean z) {
        if (eVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unity_id", eVar.a());
            if (eVar.z()) {
                jSONObject.put("adn_rit_show_rules_version", eVar.m());
            } else {
                jSONObject.put("waterfall_show_rules_version", eVar.gc());
            }
            jSONObject.put("timing_mode", eVar.e());
            jSONObject.put("show_freqctl_rules", z ? eVar.fo() : eVar.uy());
            return jSONObject;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized com.bytedance.msdk.core.gz.e query(String str) {
        if (this.z == null) {
            return null;
        }
        return z(l.z("freqctl_".concat(String.valueOf(str)), this.z).g(str, ""), false);
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized com.bytedance.msdk.core.gz.e query(String str, String str2) {
        if (this.z == null) {
            return null;
        }
        return z(l.z("freqctl_".concat(String.valueOf(str)), this.z).g(str + "_" + str2, ""), true);
    }

    private com.bytedance.msdk.core.gz.e z(String str, boolean z) {
        String string;
        String string2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split("_");
            String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                string2 = jSONObject.getString("adn_rit_show_rules_version");
                string = "";
            } else {
                string = jSONObject.getString("waterfall_show_rules_version");
                string2 = "";
            }
            return new com.bytedance.msdk.core.gz.e(str2, str3, string, string2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized void delete(String str) {
        if (this.z != null && !TextUtils.isEmpty(str)) {
            l.z("freqctl_".concat(String.valueOf(str)), this.z).m(str);
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized void delete(String str, String str2) {
        if (this.z != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            l.z("freqctl_".concat(String.valueOf(str)), this.z).m(str + "_" + str2);
        }
    }

    @Override // com.bytedance.msdk.gc.z.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized void z(com.bytedance.msdk.core.gz.e eVar) {
        if (eVar != null) {
            dl(eVar);
        }
    }

    private void dl(com.bytedance.msdk.core.gz.e eVar) {
        if (this.z == null || eVar == null) {
            return;
        }
        l lVarZ = l.z("freqctl_" + eVar.g(), this.z);
        JSONObject jSONObjectZ = z(eVar, false);
        if (jSONObjectZ != null) {
            lVarZ.z(eVar.a(), jSONObjectZ.toString());
        }
    }
}
