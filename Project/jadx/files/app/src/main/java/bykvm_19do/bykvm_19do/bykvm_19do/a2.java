package bykvm_19do.bykvm_19do.bykvm_19do;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class a2 extends t1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long[] f638f = {60000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f640e;

    a2(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        long jQ = this.a.c().Q();
        if (jQ > 60000 || jQ <= 0) {
            jQ = 60000;
        }
        f638f[0] = jQ;
        return jQ + this.f639d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long[] c() {
        return f638f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() throws Throwable {
        z zVarA;
        if (System.currentTimeMillis() > this.f640e + this.a.c().Q()) {
            JSONObject jSONObjectB = this.a.d().b();
            b2 b2VarE = this.a.e();
            if (b2VarE != null && jSONObjectB != null && (zVarA = b2VarE.a()) != null) {
                this.a.b().a(jSONObjectB, zVarA, b2VarE.b());
                this.f640e = System.currentTimeMillis();
            }
        }
        ArrayList<a0> arrayListA = this.a.b().a();
        ArrayList<a0> arrayList = new ArrayList<>(arrayListA.size());
        ArrayList<a0> arrayList2 = new ArrayList<>(arrayListA.size());
        v1 v1Var = this.a;
        String[] strArrA = t.a(v1Var, v1Var.a(), this.a.d().a());
        for (a0 a0Var : arrayListA) {
            int iA = s.a(strArrA, a0Var.f628i, this.a.c());
            if (iA == 200) {
                arrayList.add(a0Var);
            } else {
                a0Var.f630k = iA;
                arrayList2.add(a0Var);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.a.b().a(arrayList, arrayList2);
        }
        l0.d(e() + arrayList.size() + " " + arrayListA.size(), null);
        if (arrayList.size() != arrayListA.size()) {
            return false;
        }
        this.f639d = System.currentTimeMillis();
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    String e() {
        return "s";
    }
}
