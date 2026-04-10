package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    private final int a;
    private final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f1201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Deque<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c> f1202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d f1203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f1204f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f1200h = !j.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Executor f1199g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp ConnectionPool", true));

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long jA = j.this.a(System.nanoTime());
                if (jA == -1) {
                    return;
                }
                if (jA > 0) {
                    long j2 = jA / 1000000;
                    synchronized (j.this) {
                        try {
                            j jVar = j.this;
                            Long.signum(j2);
                            jVar.wait(j2, (int) (jA - (1000000 * j2)));
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int i2, long j2, TimeUnit timeUnit) {
        this.f1201c = new a();
        this.f1202d = new ArrayDeque();
        this.f1203e = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d();
        this.a = i2;
        this.b = timeUnit.toNanos(j2);
        if (j2 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
    }

    private int a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar, long j2) {
        List<Reference<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g>> list = cVar.f969n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a("A connection to " + cVar.a().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).a);
                list.remove(i2);
                cVar.f966k = true;
                if (list.isEmpty()) {
                    cVar.f970o = j2 - this.b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j2) {
        long j3;
        synchronized (this) {
            long j4 = Long.MIN_VALUE;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar = null;
            int i2 = 0;
            int i3 = 0;
            for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2 : this.f1202d) {
                if (a(cVar2, j2) > 0) {
                    i3++;
                } else {
                    long j5 = j2 - cVar2.f970o;
                    if (j5 > j4) {
                        cVar = cVar2;
                        j4 = j5;
                    }
                    i2++;
                }
            }
            if (j4 < this.b && i2 <= this.a) {
                if (i2 > 0) {
                    return this.b - j4;
                }
                if (i3 > 0) {
                    j3 = this.b;
                } else {
                    this.f1204f = false;
                    j3 = -1;
                }
                return j3;
            }
            this.f1202d.remove(cVar);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVar.e());
            return 0L;
        }
    }

    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c0 c0Var) {
        if (!f1200h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar : this.f1202d) {
            if (cVar.a(aVar, c0Var)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    Socket a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar) {
        if (!f1200h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar : this.f1202d) {
            if (cVar.a(aVar, null) && cVar.c() && cVar != gVar.b()) {
                return gVar.a(cVar);
            }
        }
        return null;
    }

    boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
        if (!f1200h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (cVar.f966k || this.a == 0) {
            this.f1202d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
        if (!f1200h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f1204f) {
            this.f1204f = true;
            f1199g.execute(this.f1201c);
        }
        this.f1202d.add(cVar);
    }
}
