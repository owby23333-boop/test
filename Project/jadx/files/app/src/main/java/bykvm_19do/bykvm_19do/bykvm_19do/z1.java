package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class z1 extends t1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final long[] f796d = {60000, 60000, 60000, 120000, 120000, 120000, 180000, 180000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final long[] f797e = {180000, 180000, 360000, 360000, 540000, 540000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long[] f798f = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    z1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        return ((long) (this.a.e().c() ? 21600000 : 43200000)) + this.a.d().l();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long[] c() {
        int iK = this.a.d().k();
        if (iK == 0) {
            return f798f;
        }
        if (iK != 1) {
            if (iK == 2) {
                return f796d;
            }
            l0.a(null);
        }
        return f797e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = this.a.d().a();
        if (jSONObjectA != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", jSONObjectA);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject jSONObjectA2 = s.a(t.a(this.a.a(), this.a.d().a(), this.a.f().c(), true, a.j()), jSONObject);
            if (jSONObjectA2 != null) {
                return this.a.d().a(jSONObjectA2, jSONObjectA2.optString("device_id", ""), jSONObjectA2.optString("install_id", ""), jSONObjectA2.optString("ssid", ""));
            }
        } else {
            l0.a(null);
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    String e() {
        return "r";
    }
}
