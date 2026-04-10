package bykvm_19do.bykvm_19do.bykvm_19do;

/* JADX INFO: loaded from: classes.dex */
class w1 extends y1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f775f;

    w1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.y1, bykvm_19do.bykvm_19do.bykvm_19do.t1
    long b() {
        return this.f775f ? Long.MAX_VALUE : 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.y1, bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        boolean zD = super.d();
        this.f775f = zD;
        return zD;
    }
}
