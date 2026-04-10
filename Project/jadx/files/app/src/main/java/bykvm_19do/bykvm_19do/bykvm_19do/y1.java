package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class y1 extends t1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long[] f782e = {60000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f783d;

    y1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    boolean a() {
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        return this.f783d + 60000;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    long[] c() {
        return f782e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        Bundle bundleA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b2 b2VarE = this.a.e();
        if (b2VarE != null && (bundleA = b2VarE.a(jCurrentTimeMillis, 50000L)) != null) {
            a.a("play_session", bundleA);
            a.a();
        }
        if (this.a.d().k() == 0) {
            return false;
        }
        JSONObject jSONObjectB = this.a.d().b();
        if (jSONObjectB == null) {
            l0.a(null);
            return false;
        }
        boolean zA = this.a.b().a(jSONObjectB);
        this.f783d = System.currentTimeMillis();
        return zA;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    String e() {
        return "p";
    }
}
