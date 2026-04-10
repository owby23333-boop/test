package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements e<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i> {
    private Context a;

    public f(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i a(String str, boolean z2) {
        String str2;
        String string;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String[] strArrSplit = jSONObject.getString("unity_id").split("_");
                String str3 = strArrSplit.length > 0 ? strArrSplit[0] : "";
                String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
                if (z2) {
                    str2 = "";
                    string = str2;
                } else {
                    String string2 = jSONObject.getString("waterfall_show_rules_version");
                    string = jSONObject.getString("adn_rit_show_rules_version");
                    str2 = string2;
                }
                return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i(str3, str4, str2, string, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVar) {
        synchronized (this) {
            if (this.a != null && iVar != null) {
                e0 e0VarA = e0.a("pacing_" + iVar.d(), this.a);
                String strG = iVar.g();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("unity_id", iVar.g());
                    if (!iVar.h()) {
                        jSONObject.put("waterfall_show_rules_version", iVar.e());
                        jSONObject.put("adn_rit_show_rules_version", iVar.b());
                    }
                    jSONObject.put("timing_mode", iVar.f());
                    jSONObject.put("show_pacing", iVar.i() + "");
                    jSONObject.put("show_pacing_rule_id", iVar.j());
                    jSONObject.put("show_time", iVar.k() + "");
                    e0VarA.b(strG, jSONObject.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(String str) {
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (this.a != null && !TextUtils.isEmpty(str)) {
                e0.a("pacing_" + str, this.a).f(str);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.e
    public void a(String str, long j2) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVarB = b(str);
                iVarB.a(j2);
                a(iVarB);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(String str, String str2) {
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                e0.a("pacing_" + str, this.a).f(str + "_" + str2);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.e
    public void a(String str, String str2, long j2) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVarB = b(str, str2);
                iVarB.a(j2);
                a(iVarB);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i b(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVarA;
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (TextUtils.isEmpty(str)) {
                iVarA = null;
            } else {
                iVarA = a(e0.a("pacing_" + str, this.a).a(str, ""), false);
            }
        }
        return iVarA;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i b(String str, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVarA;
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (TextUtils.isEmpty(str)) {
                iVarA = null;
            } else {
                iVarA = a(e0.a("pacing_" + str, this.a).a(str + "_" + str2, ""), true);
            }
        }
        return iVarA;
    }
}
