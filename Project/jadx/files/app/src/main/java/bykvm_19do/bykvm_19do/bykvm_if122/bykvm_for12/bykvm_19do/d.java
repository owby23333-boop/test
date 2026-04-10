package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements c<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g> {
    private Context a;

    public d(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g a(String str, boolean z2) {
        String string;
        String string2;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String[] strArrSplit = jSONObject.getString("unity_id").split("_");
                String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "";
                String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
                if (z2) {
                    string2 = jSONObject.getString("adn_rit_show_rules_version");
                    string = "";
                } else {
                    string = jSONObject.getString("waterfall_show_rules_version");
                    string2 = "";
                }
                return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g(str2, str3, string, string2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private JSONObject a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVar, boolean z2) {
        String str;
        String strE;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("unity_id", gVar.g());
                if (gVar.h()) {
                    str = "adn_rit_show_rules_version";
                    strE = gVar.b();
                } else {
                    str = "waterfall_show_rules_version";
                    strE = gVar.e();
                }
                jSONObject.put(str, strE);
                jSONObject.put("timing_mode", gVar.f());
                jSONObject.put("show_freqctl_rules", z2 ? gVar.k() : gVar.j());
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private void c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVar) {
        if (this.a == null || gVar == null) {
            return;
        }
        e0 e0VarA = e0.a("freqctl_" + gVar.d(), this.a);
        JSONObject jSONObjectA = a(gVar, false);
        if (jSONObjectA != null) {
            e0VarA.b(gVar.g(), jSONObjectA.toString());
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVar) {
        synchronized (this) {
            if (this.a != null && gVar != null) {
                e0 e0VarA = e0.a("freqctl_" + gVar.d(), this.a);
                String strG = gVar.g();
                JSONObject jSONObjectA = a(gVar, true);
                if (jSONObjectA != null) {
                    e0VarA.b(strG, jSONObjectA.toString());
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(String str) {
        synchronized (this) {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                e0.a("freqctl_" + str, this.a).f(str);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(String str, String str2) {
        synchronized (this) {
            if (this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                e0.a("freqctl_" + str, this.a).f(str + "_" + str2);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g b(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVarA;
        synchronized (this) {
            if (this.a == null) {
                gVarA = null;
            } else {
                gVarA = a(e0.a("freqctl_" + str, this.a).a(str, ""), false);
            }
        }
        return gVarA;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g b(String str, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVarA;
        synchronized (this) {
            if (this.a == null) {
                gVarA = null;
            } else {
                gVarA = a(e0.a("freqctl_" + str, this.a).a(str + "_" + str2, ""), true);
            }
        }
        return gVarA;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.c
    public void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVar) {
        synchronized (this) {
            if (gVar != null) {
                c(gVar);
            }
        }
    }
}
