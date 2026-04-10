package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
class k {
    private final m aLt;
    private final com.kwad.sdk.core.videocache.a aLu;
    private volatile Thread aLy;
    private volatile boolean ng;
    private final Object aLv = new Object();
    private final Object aLw = new Object();
    private volatile int aLz = -1;
    private final AtomicInteger aLx = new AtomicInteger();

    protected void dM(int i) {
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aLt = (m) ax.checkNotNull(mVar);
        this.aLu = (com.kwad.sdk.core.videocache.a) ax.checkNotNull(aVar);
    }

    public final int a(byte[] bArr, long j, int i) throws ProxyCacheException {
        l.b(bArr, j, 1024);
        while (!this.aLu.isCompleted() && this.aLu.Kk() < 1024 + j && !this.ng) {
            Kx();
            Ky();
            Kw();
        }
        int iA = this.aLu.a(bArr, j, 1024);
        if (this.aLu.isCompleted() && this.aLz != 100) {
            this.aLz = 100;
            dM(100);
        }
        return iA;
    }

    private void Kw() throws ProxyCacheException {
        int i = this.aLx.get();
        if (i <= 0) {
            return;
        }
        this.aLx.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    public final void shutdown() {
        synchronized (this.aLw) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.aLt);
            try {
                this.ng = true;
                if (this.aLy != null) {
                    this.aLy.interrupt();
                }
                this.aLu.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }

    private synchronized void Kx() {
        byte b = 0;
        boolean z = (this.aLy == null || this.aLy.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.ng && !this.aLu.isCompleted() && !z) {
            this.aLy = new Thread(new a(this, b), "Source reader for " + this.aLt);
            this.aLy.start();
        }
    }

    private void Ky() {
        synchronized (this.aLv) {
            try {
                try {
                    this.aLv.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(long j, long j2) {
        k(j, j2);
        synchronized (this.aLv) {
            this.aLv.notifyAll();
        }
    }

    private void k(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.aLz;
        if ((j2 >= 0) && z) {
            dM(i);
        }
        this.aLz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r2 = r2 + ((long) r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Kz() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aLu     // Catch: java.lang.Throwable -> L49
            long r2 = r4.Kk()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aLt     // Catch: java.lang.Throwable -> L49
            r4.aK(r2)     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aLt     // Catch: java.lang.Throwable -> L49
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L49
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L49
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aLt     // Catch: java.lang.Throwable -> L49
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = -1
            if (r5 == r6) goto L42
            java.lang.Object r6 = r8.aLw     // Catch: java.lang.Throwable -> L49
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L49
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
        L2c:
            r8.KB()
            r8.j(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.aLu     // Catch: java.lang.Throwable -> L3f
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.KA()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aLx     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.KB()
            r8.j(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.Kz():void");
    }

    private void KA() {
        this.aLz = 100;
        dM(this.aLz);
    }

    private void tryComplete() {
        synchronized (this.aLw) {
            if (!isStopped() && this.aLu.Kk() == this.aLt.length()) {
                this.aLu.complete();
            }
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.ng;
    }

    private void KB() {
        try {
            this.aLt.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aLt, e));
        }
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Kz();
        }
    }
}
