package bykvm_19do.bykvm_19do.bykvm_19do;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class k1 extends t1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f723d;

    k1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        long jK = this.a.c().K();
        if (jK < TTAdConstant.AD_MAX_EVENT_TIME) {
            jK = 600000;
        }
        return jK + this.f723d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long[] c() {
        return z1.f797e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean d() throws JSONException {
        JSONObject jSONObjectA = this.a.d().a();
        if (this.a.d().k() != 0 && jSONObjectA != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.a.d().a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", jCurrentTimeMillis);
            JSONObject jSONObjectD = s.d(s.a(t.a(this.a.a(), this.a.d().a(), this.a.f().a(), true, a.j()), s.f743e), jSONObject);
            if (jSONObjectD != null) {
                a.f().b(!m0.a(a.b(), jSONObjectD), jSONObjectD);
                if (l0.a) {
                    l0.a("getAbConfig " + jSONObjectD, null);
                }
                this.a.d().a(jSONObjectD);
                this.f723d = jCurrentTimeMillis;
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    String e() {
        return "ab";
    }
}
