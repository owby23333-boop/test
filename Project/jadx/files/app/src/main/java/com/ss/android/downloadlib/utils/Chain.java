package com.ss.android.downloadlib.utils;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes3.dex */
public class Chain<P, R> implements Runnable {

    @ThreadType
    private int b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Chain<?, P> f18043h;
    private SoftReference<mb<P, R>> hj;
    private P mb;
    private R ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Chain<R, ?> f18044u;

    /* JADX INFO: loaded from: classes.dex */
    public @interface ThreadType {
        public static final int CPU = 1;
        public static final int IO = 2;
        public static final int MAIN = 0;
    }

    public interface mb<PARAM, RESULT> {
        RESULT mb(PARAM param);
    }

    private Chain(@ThreadType int i2, mb<P, R> mbVar, P p2) {
        this.b = i2;
        this.hj = new SoftReference<>(mbVar);
        this.mb = p2;
    }

    public static <P, R> Chain<P, R> mb(mb<P, R> mbVar, P p2) {
        return new Chain<>(2, mbVar, p2);
    }

    private R ox() {
        return this.ox;
    }

    @Override // java.lang.Runnable
    public void run() {
        Chain<?, P> chain;
        if (this.b == 0 && !jb.mb()) {
            com.ss.android.downloadlib.ko.mb().ox().post(this);
            return;
        }
        if (this.b == 1 && jb.mb()) {
            com.ss.android.downloadlib.hj.mb().mb(this);
            return;
        }
        if (this.b == 2 && jb.mb()) {
            com.ss.android.downloadlib.hj.mb().ox(this);
            return;
        }
        if (this.mb == null && (chain = this.f18043h) != null) {
            this.mb = chain.ox();
        }
        mb<P, R> mbVar = this.hj.get();
        if (mbVar == null) {
            return;
        }
        this.ox = mbVar.mb(this.mb);
        Chain<R, ?> chain2 = this.f18044u;
        if (chain2 != null) {
            chain2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> Chain<R, NR> mb(@ThreadType int i2, mb<R, NR> mbVar) {
        Chain chain = (Chain<R, ?>) new Chain(i2, mbVar, null);
        this.f18044u = chain;
        chain.f18043h = this;
        return chain;
    }

    public <NR> Chain<R, NR> mb(mb<R, NR> mbVar) {
        return mb(0, mbVar);
    }

    public void mb() {
        Chain<?, P> chain = this.f18043h;
        if (chain != null) {
            chain.mb();
        } else {
            run();
        }
    }
}
