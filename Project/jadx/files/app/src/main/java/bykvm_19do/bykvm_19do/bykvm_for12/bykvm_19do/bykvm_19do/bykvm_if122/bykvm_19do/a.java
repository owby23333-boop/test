package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a extends t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f858h = TimeUnit.SECONDS.toMillis(60);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f859i = TimeUnit.MILLISECONDS.toNanos(f858h);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static a f860j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f863g;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$a, reason: collision with other inner class name */
    class C0026a implements r {
        final /* synthetic */ r a;

        C0026a(r rVar) {
            this.a = rVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return a.this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                u.a(cVar.b, 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    o oVar = cVar.a;
                    while (true) {
                        if (j3 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            break;
                        }
                        j3 += (long) (oVar.f877c - oVar.b);
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        oVar = oVar.f880f;
                    }
                    a.this.g();
                    try {
                        try {
                            this.a.b(cVar, j3);
                            j2 -= j3;
                            a.this.a(true);
                        } catch (IOException e2) {
                            throw a.this.a(e2);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                throw new IOException(e3);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            a.this.g();
            try {
                try {
                    this.a.flush();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.a + ad.f20406s;
        }
    }

    class b implements s {
        final /* synthetic */ s a;

        b(s sVar) {
            this.a = sVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            a.this.g();
            try {
                try {
                    long jA = this.a.a(cVar, j2);
                    a.this.a(true);
                    return jA;
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return a.this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.a + ad.f20406s;
        }
    }

    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
                java.lang.Class<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
            L2:
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L2
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L2
            Lb:
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f860j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f860j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.i()     // Catch: java.lang.InterruptedException -> L2
                goto L2
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L1d
            L1c:
                throw r1
            L1d:
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c.run():void");
        }
    }

    private static void a(a aVar, long j2, boolean z2) {
        synchronized (a.class) {
            if (f860j == null) {
                f860j = new a();
                c cVar = new c();
                cVar.setName("gm_t_watch_dog");
                try {
                    cVar.start();
                } catch (Throwable unused) {
                }
            }
            long jNanoTime = System.nanoTime();
            if (j2 != 0 && z2) {
                aVar.f863g = Math.min(j2, aVar.c() - jNanoTime) + jNanoTime;
            } else if (j2 != 0) {
                aVar.f863g = j2 + jNanoTime;
            } else {
                if (!z2) {
                    throw new AssertionError();
                }
                aVar.f863g = aVar.c();
            }
            long jB = aVar.b(jNanoTime);
            a aVar2 = f860j;
            while (true) {
                a aVar3 = aVar2.f862f;
                if (aVar3 == null || jB < aVar3.b(jNanoTime)) {
                    break;
                } else {
                    aVar2 = aVar2.f862f;
                }
            }
            aVar.f862f = aVar2.f862f;
            aVar2.f862f = aVar;
            if (aVar2 == f860j) {
                a.class.notify();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
    
        r1.f862f = r3.f862f;
        r3.f862f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r3) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f860j     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L16
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r1.f862f     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L14
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r3.f862f     // Catch: java.lang.Throwable -> L19
            r1.f862f = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.f862f = r1     // Catch: java.lang.Throwable -> L19
            r3 = 0
            goto L17
        L14:
            r1 = r2
            goto L5
        L16:
            r3 = 1
        L17:
            monitor-exit(r0)
            return r3
        L19:
            r3 = move-exception
            monitor-exit(r0)
            goto L1d
        L1c:
            throw r3
        L1d:
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a):boolean");
    }

    private long b(long j2) {
        return this.f863g - j2;
    }

    static a j() throws InterruptedException {
        a aVar = f860j.f862f;
        long jNanoTime = System.nanoTime();
        if (aVar == null) {
            a.class.wait(f858h);
            if (f860j.f862f == null && System.nanoTime() - jNanoTime >= f859i) {
                return f860j;
            }
        } else {
            long jB = aVar.b(jNanoTime);
            if (jB <= 0) {
                f860j.f862f = aVar.f862f;
                aVar.f862f = null;
                return aVar;
            }
            long j2 = jB / 1000000;
            a.class.wait(j2, (int) (jB - (1000000 * j2)));
        }
        return null;
    }

    public final r a(r rVar) {
        return new C0026a(rVar);
    }

    public final s a(s sVar) {
        return new b(sVar);
    }

    final IOException a(IOException iOException) throws IOException {
        return !h() ? iOException : b(iOException);
    }

    final void a(boolean z2) throws IOException {
        if (h() && z2) {
            throw b((IOException) null);
        }
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void g() {
        if (this.f861e) {
            return;
        }
        long jF = f();
        boolean zD = d();
        if (jF != 0 || zD) {
            this.f861e = true;
            a(this, jF, zD);
        }
    }

    public final boolean h() {
        if (!this.f861e) {
            return false;
        }
        this.f861e = false;
        return a(this);
    }

    protected void i() {
    }
}
