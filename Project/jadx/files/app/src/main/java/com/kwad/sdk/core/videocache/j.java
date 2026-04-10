package com.kwad.sdk.core.videocache;

import android.support.v4.media.session.PlaybackStateCompat;
import com.kwad.sdk.utils.an;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
class j {
    private volatile Thread anB;
    private final l anw;
    private final com.kwad.sdk.core.videocache.a anx;
    private volatile boolean lg;
    private final Object any = new Object();
    private final Object anz = new Object();
    private volatile int anC = -1;
    private final AtomicInteger anA = new AtomicInteger();

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.yU();
        }
    }

    public j(l lVar, com.kwad.sdk.core.videocache.a aVar) {
        this.anw = (l) an.checkNotNull(lVar);
        this.anx = (com.kwad.sdk.core.videocache.a) an.checkNotNull(aVar);
    }

    private void e(long j2, long j3) {
        f(j2, j3);
        synchronized (this.any) {
            this.any.notifyAll();
        }
    }

    private void f(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j2 / j3) * 100.0f);
        boolean z2 = i2 != this.anC;
        if ((j3 >= 0) && z2) {
            by(i2);
        }
        this.anC = i2;
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.lg;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.b.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.b.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.anz) {
            if (!isStopped() && this.anx.yH() == this.anw.length()) {
                this.anx.complete();
            }
        }
    }

    private void yR() throws ProxyCacheException {
        int i2 = this.anA.get();
        if (i2 <= 0) {
            return;
        }
        this.anA.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private synchronized void yS() {
        byte b = 0;
        boolean z2 = (this.anB == null || this.anB.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.lg && !this.anx.isCompleted() && !z2) {
            this.anB = new Thread(new a(this, b), "Source reader for " + this.anw);
            this.anB.start();
        }
    }

    private void yT() {
        synchronized (this.any) {
            try {
                try {
                    this.any.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r2 = r2 + ((long) r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void yU() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.anx     // Catch: java.lang.Throwable -> L49
            long r2 = r4.yH()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.l r4 = r8.anw     // Catch: java.lang.Throwable -> L49
            r4.U(r2)     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.l r4 = r8.anw     // Catch: java.lang.Throwable -> L49
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L49
            r4 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L49
        L19:
            com.kwad.sdk.core.videocache.l r5 = r8.anw     // Catch: java.lang.Throwable -> L49
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = -1
            if (r5 == r6) goto L42
            java.lang.Object r6 = r8.anz     // Catch: java.lang.Throwable -> L49
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L49
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
        L2c:
            r8.yW()
            r8.e(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.anx     // Catch: java.lang.Throwable -> L3f
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.e(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.yV()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.anA     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.yW()
            r8.e(r2, r0)
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.j.yU():void");
    }

    private void yV() {
        this.anC = 100;
        by(this.anC);
    }

    private void yW() {
        try {
            this.anw.close();
        } catch (ProxyCacheException e2) {
            onError(new ProxyCacheException("Error closing source " + this.anw, e2));
        }
    }

    public final int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        k.b(bArr, j2, 8192);
        while (!this.anx.isCompleted() && this.anx.yH() < PlaybackStateCompat.ACTION_PLAY_FROM_URI + j2 && !this.lg) {
            yS();
            yT();
            yR();
        }
        int iA = this.anx.a(bArr, j2, 8192);
        if (this.anx.isCompleted() && this.anC != 100) {
            this.anC = 100;
            by(100);
        }
        return iA;
    }

    protected void by(int i2) {
    }

    public final void shutdown() {
        synchronized (this.anz) {
            com.kwad.sdk.core.d.b.d("ProxyCache", "Shutdown proxy for " + this.anw);
            try {
                this.lg = true;
                if (this.anB != null) {
                    this.anB.interrupt();
                }
                this.anx.close();
            } catch (ProxyCacheException e2) {
                onError(e2);
            }
        }
    }
}
