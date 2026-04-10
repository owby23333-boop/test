package bykvm_19do.bykvm_19do.bykvm_19do;

/* JADX INFO: loaded from: classes.dex */
class x1 extends a2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f778g;

    x1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a2, bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        return this.f778g ? Long.MAX_VALUE : 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a2, bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() throws Throwable {
        boolean zD = super.d();
        this.f778g = zD;
        return zD;
    }
}
