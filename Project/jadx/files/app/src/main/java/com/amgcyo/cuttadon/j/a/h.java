package com.amgcyo.cuttadon.j.a;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: SimpleFutureTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h<T> extends FutureTask<T> {
    public h(Callable<T> callable) {
        super(callable);
    }

    public abstract void a();

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        a();
    }
}
