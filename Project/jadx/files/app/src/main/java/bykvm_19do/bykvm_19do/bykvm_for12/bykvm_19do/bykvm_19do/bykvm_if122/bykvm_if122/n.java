package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f1223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f1224d;
    private int a = 64;
    private int b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<x.a> f1225e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Deque<x.a> f1226f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Deque<x> f1227g = new ArrayDeque();

    private <T> void a(Deque<T> deque, T t2, boolean z2) {
        int iB;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t2)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z2) {
                c();
            }
            iB = b();
            runnable = this.f1223c;
        }
        if (iB != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int c(x.a aVar) {
        Iterator<x.a> it = this.f1226f.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().c().equals(aVar.c())) {
                i2++;
            }
        }
        return i2;
    }

    private void c() {
        if (this.f1226f.size() < this.a && !this.f1225e.isEmpty()) {
            Iterator<x.a> it = this.f1225e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (c(next) < this.b) {
                    it.remove();
                    this.f1226f.add(next);
                    a().execute(next);
                }
                if (this.f1226f.size() >= this.a) {
                    return;
                }
            }
        }
    }

    public ExecutorService a() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.f1224d == null) {
                this.f1224d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("OkHttp Dispatcher", false));
            }
            executorService = this.f1224d;
        }
        return executorService;
    }

    public void a(int i2) {
        synchronized (this) {
            if (i2 < 1) {
                throw new IllegalArgumentException("max < 1: " + i2);
            }
            this.a = i2;
            c();
        }
    }

    void a(x.a aVar) {
        synchronized (this) {
            if (this.f1226f.size() >= this.a || c(aVar) >= this.b) {
                this.f1225e.add(aVar);
            } else {
                this.f1226f.add(aVar);
                a().execute(aVar);
            }
        }
    }

    void a(x xVar) {
        synchronized (this) {
            this.f1227g.add(xVar);
        }
    }

    public int b() {
        int size;
        int size2;
        synchronized (this) {
            size = this.f1226f.size();
            size2 = this.f1227g.size();
        }
        return size + size2;
    }

    void b(x.a aVar) {
        a(this.f1226f, aVar, true);
    }

    void b(x xVar) {
        a(this.f1227g, xVar, false);
    }
}
