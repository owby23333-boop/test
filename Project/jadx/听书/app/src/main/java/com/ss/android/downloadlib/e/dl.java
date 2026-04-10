package com.ss.android.downloadlib.e;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes4.dex */
public class dl<P, R> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoftReference<z<P, R>> f2004a;
    private int dl;
    private R g;
    private dl<?, P> gc;
    private dl<R, ?> m;
    private P z;

    public interface z<PARAM, RESULT> {
        RESULT z(PARAM param);
    }

    private dl(int i, z<P, R> zVar, P p) {
        this.dl = i;
        this.f2004a = new SoftReference<>(zVar);
        this.z = p;
    }

    public static <P, R> dl<P, R> z(z<P, R> zVar, P p) {
        return new dl<>(2, zVar, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> dl<R, NR> z(int i, z<R, NR> zVar) {
        dl dlVar = (dl<R, ?>) new dl(i, zVar, null);
        this.m = dlVar;
        dlVar.gc = this;
        return dlVar;
    }

    public <NR> dl<R, NR> z(z<R, NR> zVar) {
        return z(0, zVar);
    }

    public void z() {
        dl<?, P> dlVar = this.gc;
        if (dlVar != null) {
            dlVar.z();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        dl<?, P> dlVar;
        if (this.dl == 0 && !i.g()) {
            com.ss.android.downloadlib.gz.z().g().post(this);
            return;
        }
        if (this.dl == 1 && i.g()) {
            com.ss.android.downloadlib.gc.z().z(this);
            return;
        }
        if (this.dl == 2 && i.g()) {
            com.ss.android.downloadlib.gc.z().g(this);
            return;
        }
        if (this.z == null && (dlVar = this.gc) != null) {
            this.z = dlVar.g();
        }
        z<P, R> zVar = this.f2004a.get();
        if (zVar == null) {
            return;
        }
        this.g = zVar.z(this.z);
        dl<R, ?> dlVar2 = this.m;
        if (dlVar2 != null) {
            dlVar2.run();
        }
    }

    private R g() {
        return this.g;
    }
}
