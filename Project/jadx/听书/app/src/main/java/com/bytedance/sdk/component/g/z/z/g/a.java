package com.bytedance.sdk.component.g.z.z.g;

import com.bytedance.sdk.component.g.z.z.g.z;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.component.g.z.a {
    private ExecutorService z;
    private final Deque<z.C0134z> g = new ArrayDeque();
    private final Deque<z.C0134z> dl = new ArrayDeque();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Deque<z> f725a = new ArrayDeque();
    private AtomicInteger gc = new AtomicInteger(64);

    @Override // com.bytedance.sdk.component.g.z.a
    public void g(int i) {
    }

    public a() {
        if (this.z == null) {
            this.z = new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.g.z.z.g.a.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable, "systemHttp Dispatcher");
                    dlVar.setDaemon(false);
                    dlVar.setPriority(10);
                    return dlVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.z.a
    public ExecutorService g() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.g.z.a
    public void z(int i) {
        this.gc.set(i);
    }

    @Override // com.bytedance.sdk.component.g.z.a
    public int z() {
        return this.gc.get();
    }

    public synchronized void z(z.C0134z c0134z) {
        try {
            if (this.dl.size() < z()) {
                this.dl.add(c0134z);
                if (c0134z != null) {
                    c0134z.z();
                }
                g().submit(c0134z);
                return;
            }
            this.g.add(c0134z);
        } catch (Throwable unused) {
        }
    }

    synchronized void z(z zVar) {
        this.f725a.add(zVar);
    }

    void g(z.C0134z c0134z) {
        z(this.dl, c0134z, true);
    }

    void g(z zVar) {
        z(this.f725a, zVar, false);
    }

    private <T> void z(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                dl();
            }
        }
    }

    private void dl() {
        if (this.dl.size() < z() && !this.g.isEmpty()) {
            Iterator<z.C0134z> it = this.g.iterator();
            while (it.hasNext()) {
                z.C0134z next = it.next();
                it.remove();
                this.dl.add(next);
                if (next != null) {
                    next.z();
                }
                g().submit(next);
                if (this.dl.size() >= z()) {
                    return;
                }
            }
        }
    }
}
