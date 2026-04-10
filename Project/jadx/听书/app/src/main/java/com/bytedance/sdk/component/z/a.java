package com.bytedance.sdk.component.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<P, R> extends com.bytedance.sdk.component.z.g<P, R> {
    private m dl;
    private z g;
    private boolean z = true;

    public interface g {
        a z();
    }

    interface z {
        void z(Object obj);

        void z(Throwable th);
    }

    protected abstract void a();

    protected abstract void z(P p, m mVar) throws Exception;

    @Override // com.bytedance.sdk.component.z.g
    public /* bridge */ /* synthetic */ String z() {
        return super.z();
    }

    protected final void z(R r) {
        if (e()) {
            this.g.z(r);
            gc();
        }
    }

    protected final void z(Throwable th) {
        if (e()) {
            this.g.z(th);
            gc();
        }
    }

    protected final void dl() {
        z((Throwable) null);
    }

    protected void gc() {
        this.z = false;
        this.dl = null;
    }

    void z(P p, m mVar, z zVar) throws Exception {
        this.dl = mVar;
        this.g = zVar;
        z(p, mVar);
    }

    void m() {
        a();
        gc();
    }

    private boolean e() {
        if (this.z) {
            return true;
        }
        fo.z(new IllegalStateException("Jsb async call already finished: " + z() + ", hashcode: " + hashCode()));
        return false;
    }
}
