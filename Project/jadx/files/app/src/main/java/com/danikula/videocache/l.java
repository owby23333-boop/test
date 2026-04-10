package com.danikula.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ProxyCache.java */
/* JADX INFO: loaded from: classes2.dex */
class l {
    private final n a;
    private final com.danikula.videocache.a b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f14785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Thread f14786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f14787g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f14783c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f14784d = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f14788h = -1;

    /* JADX INFO: compiled from: ProxyCache.java */
    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f();
        }
    }

    public l(n nVar, com.danikula.videocache.a aVar) {
        k.a(nVar);
        this.a = nVar;
        k.a(aVar);
        this.b = aVar;
        this.f14785e = new AtomicInteger();
    }

    private void b() throws ProxyCacheException {
        int i2 = this.f14785e.get();
        if (i2 < 1) {
            return;
        }
        this.f14785e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void c() {
        try {
            this.a.close();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.a, e2));
        }
    }

    private boolean d() {
        return Thread.currentThread().isInterrupted() || this.f14787g;
    }

    private void e() {
        this.f14788h = 100;
        a(this.f14788h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        long length = -1;
        long jAvailable = 0;
        try {
            jAvailable = this.b.available();
            this.a.a(jAvailable);
            length = this.a.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = this.a.read(bArr);
                if (i2 == -1) {
                    h();
                    e();
                    break;
                }
                synchronized (this.f14784d) {
                    if (d()) {
                        return;
                    } else {
                        this.b.a(bArr, i2);
                    }
                }
                jAvailable += (long) i2;
                b(jAvailable, length);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private synchronized void g() throws ProxyCacheException {
        boolean z2 = (this.f14786f == null || this.f14786f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f14787g && !this.b.isCompleted() && !z2) {
            this.f14786f = new Thread(new b(), "Source reader for " + this.a);
            this.f14786f.start();
        }
    }

    private void h() throws ProxyCacheException {
        synchronized (this.f14784d) {
            if (!d() && this.b.available() == this.a.length()) {
                this.b.complete();
            }
        }
    }

    private void i() throws ProxyCacheException {
        synchronized (this.f14783c) {
            try {
                try {
                    this.f14783c.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void a(int i2) {
        throw null;
    }

    public int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        m.a(bArr, j2, i2);
        while (!this.b.isCompleted() && this.b.available() < ((long) i2) + j2 && !this.f14787g) {
            g();
            i();
            b();
        }
        int iA = this.b.a(bArr, j2, i2);
        if (this.b.isCompleted() && this.f14788h != 100) {
            this.f14788h = 100;
            a(100);
        }
        return iA;
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.f14783c) {
            this.f14783c.notifyAll();
        }
    }

    public void a() {
        synchronized (this.f14784d) {
            j.a("Shutdown proxy for " + this.a);
            try {
                this.f14787g = true;
                if (this.f14786f != null) {
                    this.f14786f.interrupt();
                }
                this.b.close();
            } catch (ProxyCacheException e2) {
                a(e2);
            }
        }
    }

    protected void a(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j2 / j3) * 100.0f);
        boolean z2 = i2 != this.f14788h;
        if ((j3 >= 0) && z2) {
            a(i2);
        }
        this.f14788h = i2;
    }

    protected final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            j.a("ProxyCache is interrupted");
        } else {
            j.b("ProxyCache error");
        }
    }
}
