package com.bytedance.sdk.component.dl.g;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.dl.g.z.g.e;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f646a = new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.dl.g.z.dl.z("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean dl = true;
    private List<String> e;
    private final Runnable fo;
    boolean g;
    private int gc;
    private long gz;
    private long m;
    private final Deque<com.bytedance.sdk.component.dl.g.z.g.dl> uy;
    final com.bytedance.sdk.component.dl.g.z.g.a z;

    public uy() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public uy(int i, long j, TimeUnit timeUnit) {
        this.fo = new Runnable() { // from class: com.bytedance.sdk.component.dl.g.uy.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jZ = uy.this.z(System.nanoTime());
                    if (jZ == -1) {
                        return;
                    }
                    if (jZ > 0) {
                        long j2 = jZ / 1000000;
                        long j3 = jZ - (1000000 * j2);
                        synchronized (uy.this) {
                            try {
                                uy.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.uy = new ArrayDeque();
        this.z = new com.bytedance.sdk.component.dl.g.z.g.a();
        this.gc = i;
        this.m = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public void z(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.gc;
                    }
                    this.gc = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.m = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.m;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.e = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.gz = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    com.bytedance.sdk.component.dl.g.z.g.dl z(z zVar, com.bytedance.sdk.component.dl.g.z.g.e eVar, x xVar) {
        if (!dl && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.dl.g.z.g.dl dlVar : this.uy) {
            if (dlVar.z(zVar, xVar)) {
                if (eVar != null) {
                    eVar.z(dlVar, true);
                }
                return dlVar;
            }
        }
        return null;
    }

    Socket z(z zVar, com.bytedance.sdk.component.dl.g.z.g.e eVar) {
        if (!dl && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.dl.g.z.g.dl dlVar : this.uy) {
            if (dlVar.z(zVar, null) && dlVar.gc() && dlVar != eVar.g()) {
                return eVar.z(dlVar);
            }
        }
        return null;
    }

    void z(com.bytedance.sdk.component.dl.g.z.g.dl dlVar) {
        if (!dl && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.g) {
            this.g = true;
            f646a.execute(this.fo);
        }
        this.uy.add(dlVar);
    }

    boolean g(com.bytedance.sdk.component.dl.g.z.g.dl dlVar) {
        if (!dl && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (dlVar.z || this.gc == 0) {
            this.uy.remove(dlVar);
            return true;
        }
        notifyAll();
        return false;
    }

    long z(long j) {
        try {
            synchronized (this) {
                com.bytedance.sdk.component.dl.g.z.g.dl dlVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.bytedance.sdk.component.dl.g.z.g.dl dlVar2 : this.uy) {
                    if (z(dlVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - dlVar2.gc;
                        com.bytedance.sdk.component.dl.g.z.g.dl dlVar3 = dlVar;
                        if (this.gz > 0 && dl(dlVar2)) {
                            j3 -= this.gz;
                        }
                        if (j3 > j2) {
                            dlVar = dlVar2;
                            j2 = j3;
                        } else {
                            dlVar = dlVar3;
                        }
                    }
                }
                com.bytedance.sdk.component.dl.g.z.g.dl dlVar4 = dlVar;
                long j4 = this.m;
                if (j2 < j4 && i <= this.gc) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.g = false;
                    com.bytedance.sdk.component.utils.wp.z("ConnectionPool", "cleanup: ");
                    return -1L;
                }
                this.uy.remove(dlVar4);
                com.bytedance.sdk.component.dl.g.z.dl.z(dlVar4.dl());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.m;
        }
    }

    private int z(com.bytedance.sdk.component.dl.g.z.g.dl dlVar, long j) {
        List<Reference<com.bytedance.sdk.component.dl.g.z.g.e>> list = dlVar.f659a;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.component.dl.g.z.g.e> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.component.dl.g.z.e.gc.g().z("A connection to " + dlVar.z().z().z() + " was leaked. Did you forget to close a response body?", ((e.z) reference).z);
                list.remove(i);
                dlVar.z = true;
                if (list.isEmpty()) {
                    dlVar.gc = j - this.m;
                    return 0;
                }
            }
        }
        return list.size();
    }

    private boolean dl(com.bytedance.sdk.component.dl.g.z.g.dl dlVar) {
        try {
            List<String> list = this.e;
            if (list != null && !list.isEmpty() && dlVar.z() != null && dlVar.z().z() != null && dlVar.z().z().z() != null && dlVar.z().z().z().e() != null) {
                String strE = dlVar.z().z().z().e();
                if (!TextUtils.isEmpty(strE)) {
                    if (this.e.contains(strE)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
