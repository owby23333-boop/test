package com.bytedance.msdk.gc.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.gz.fo;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements dl<fo> {
    private Context z;

    public a(Context context) {
        if (context != null) {
            this.z = context.getApplicationContext();
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public synchronized void g(fo foVar) {
        if (this.z != null && foVar != null) {
            l lVarZ = l.z("pacing_" + foVar.g(), this.z);
            String strA = foVar.a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("unity_id", foVar.a());
                if (!foVar.z()) {
                    jSONObject.put("waterfall_show_rules_version", foVar.gc());
                    jSONObject.put("adn_rit_show_rules_version", foVar.m());
                }
                jSONObject.put("timing_mode", foVar.e());
                jSONObject.put("show_pacing", new StringBuilder().append(foVar.fo()).toString());
                jSONObject.put("show_pacing_rule_id", foVar.uy());
                jSONObject.put("show_time", new StringBuilder().append(foVar.kb()).toString());
                lVarZ.z(strA, jSONObject.toString());
            } catch (JSONException e) {
                wp.z(e);
            }
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized fo query(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z(l.z("pacing_".concat(String.valueOf(str)), this.z).g(str, ""), false);
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized fo query(String str, String str2) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z(l.z("pacing_".concat(String.valueOf(str)), this.z).g(str + "_" + str2, ""), true);
    }

    private fo z(String str, boolean z) {
        String str2;
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split("_");
            String str3 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                str2 = "";
                string = str2;
            } else {
                String string2 = jSONObject.getString("waterfall_show_rules_version");
                string = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string2;
            }
            return new fo(str3, str4, str2, string, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized void delete(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (this.z != null && !TextUtils.isEmpty(str)) {
            l.z("pacing_".concat(String.valueOf(str)), this.z).m(str);
        }
    }

    @Override // com.bytedance.msdk.gc.z.gc
    public synchronized void delete(String str, String str2) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (this.z != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            l.z("pacing_".concat(String.valueOf(str)), this.z).m(str + "_" + str2);
        }
    }

    @Override // com.bytedance.msdk.gc.z.dl
    public synchronized void z(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fo foVarQuery = query(str);
        if (foVarQuery != null) {
            foVarQuery.z(j);
            g(foVarQuery);
        }
    }

    @Override // com.bytedance.msdk.gc.z.dl
    public synchronized void z(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fo foVarQuery = query(str, str2);
            if (foVarQuery != null) {
                foVarQuery.z(j);
                g(foVarQuery);
            }
        }
    }
}
