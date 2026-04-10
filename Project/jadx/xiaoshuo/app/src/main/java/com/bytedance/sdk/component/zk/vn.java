package com.bytedance.sdk.component.zk;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class vn<V> extends FutureTask<V> implements Comparable<vn<V>> {
    private int bf;
    private int e;

    public vn(Callable<V> callable, int i, int i2) {
        super(callable);
        this.e = i == -1 ? 5 : i;
        this.bf = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(vn vnVar) {
        if (e() < vnVar.e()) {
            return 1;
        }
        return e() > vnVar.e() ? -1 : 0;
    }

    public int e() {
        return this.e;
    }

    public vn(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.e = i == -1 ? 5 : i;
        this.bf = i2;
    }
}
