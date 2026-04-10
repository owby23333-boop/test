package com.bytedance.sdk.component.e;

import com.bytedance.component.sdk.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class tg<P, R> extends com.bytedance.sdk.component.e.bf<P, R> {
    private e bf;
    private vn d;
    private boolean e = true;

    public interface bf {
        tg e();
    }

    public interface e {
        void e(Object obj);

        void e(Throwable th);
    }

    private boolean p() {
        if (this.e) {
            return true;
        }
        zk.e(new IllegalStateException("Jsb async call already finished: " + e() + ", hashcode: " + hashCode()));
        return false;
    }

    public final void d() {
        e((Throwable) null);
    }

    @Override // com.bytedance.sdk.component.e.bf
    public /* bridge */ /* synthetic */ String e() {
        return super.e();
    }

    public abstract void e(P p, vn vnVar) throws Exception;

    @CallSuper
    public void ga() {
        this.e = false;
        this.d = null;
    }

    public abstract void tg();

    public void vn() {
        tg();
        ga();
    }

    public final void e(R r) {
        if (p()) {
            this.bf.e(r);
            ga();
        }
    }

    public final void e(Throwable th) {
        if (p()) {
            this.bf.e(th);
            ga();
        }
    }

    public void e(P p, vn vnVar, e eVar) throws Exception {
        this.d = vnVar;
        this.bf = eVar;
        e(p, vnVar);
    }
}
