package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class u1 extends t1 {
    u1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        return this.a.c().z() + com.anythink.expressad.d.a.b.aD;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long[] c() {
        return z1.f797e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() throws JSONException {
        JSONObject jSONObjectA = this.a.d().a();
        if (this.a.d().k() != 0 && jSONObjectA != null && this.a.c().z() + com.anythink.expressad.d.a.b.aD <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", jSONObjectA);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject jSONObjectC = s.c(s.a(t.a(this.a.a(), this.a.d().a(), this.a.f().e(), true, a.j()), s.f743e), jSONObject);
            a.f().a(!m0.a(jSONObjectC, this.a.c().y()), jSONObjectC);
            if (jSONObjectC != null) {
                this.a.c().a(jSONObjectC);
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    String e() {
        return "c";
    }
}
