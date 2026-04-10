package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class s1 extends t1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f746d;

    s1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        return this.f746d ? Long.MAX_VALUE : 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long[] c() {
        return z1.f796d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean d() {
        if (this.a.d().k() != 0) {
            JSONObject jSONObjectA = this.a.d().a();
            if (jSONObjectA != null) {
                this.f746d = s.b(t.a(this.a.a(), this.a.d().a(), this.a.f().b(), true, a.j()), jSONObjectA);
            } else {
                l0.a(null);
            }
        }
        return this.f746d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    String e() {
        return com.anythink.expressad.d.a.b.da;
    }
}
