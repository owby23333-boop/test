package com.bytedance.sdk.component.uy;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class gz<V> extends FutureTask<V> implements Comparable<gz<V>> {
    private int g;
    private int z;

    public gz(Callable<V> callable, int i, int i2) {
        super(callable);
        this.z = i == -1 ? 5 : i;
        this.g = i2;
    }

    public gz(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.z = i == -1 ? 5 : i;
        this.g = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
        if (z() < gzVar.z()) {
            return 1;
        }
        return z() > gzVar.z() ? -1 : 0;
    }

    public int z() {
        return this.z;
    }
}
