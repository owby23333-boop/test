package com.bytedance.sdk.component.dl.z;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class z extends tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f699a;
    private static final long g;
    static z z;
    private long e;
    private boolean gc;
    private z m;

    protected void m_() {
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        g = millis;
        f699a = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void z() {
        if (this.gc) {
            return;
        }
        long jN_ = n_();
        boolean zDl = dl();
        if (jN_ != 0 || zDl) {
            this.gc = true;
            z(this, jN_, zDl);
        }
    }

    private static synchronized void z(z zVar, long j, boolean z2) {
        if (z == null) {
            z = new z();
            C0129z c0129z = new C0129z();
            c0129z.setName("csj_watch_dog");
            try {
                c0129z.start();
            } catch (Throwable unused) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z2) {
            zVar.e = Math.min(j, zVar.o_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            zVar.e = j + jNanoTime;
        } else if (z2) {
            zVar.e = zVar.o_();
        } else {
            throw new AssertionError();
        }
        long jG = zVar.g(jNanoTime);
        z zVar2 = z;
        while (true) {
            z zVar3 = zVar2.m;
            if (zVar3 == null || jG < zVar3.g(jNanoTime)) {
                break;
            } else {
                zVar2 = zVar2.m;
            }
        }
        zVar.m = zVar2.m;
        zVar2.m = zVar;
        if (zVar2 == z) {
            z.class.notify();
        }
    }

    public final boolean g() {
        if (!this.gc) {
            return false;
        }
        this.gc = false;
        return z(this);
    }

    private static synchronized boolean z(z zVar) {
        z zVar2 = z;
        while (zVar2 != null) {
            z zVar3 = zVar2.m;
            if (zVar3 == zVar) {
                zVar2.m = zVar.m;
                zVar.m = null;
                return false;
            }
            zVar2 = zVar3;
        }
        return true;
    }

    private long g(long j) {
        return this.e - j;
    }

    public final fv z(final fv fvVar) {
        return new fv() { // from class: com.bytedance.sdk.component.dl.z.z.1
            @Override // com.bytedance.sdk.component.dl.z.fv
            public void a_(dl dlVar, long j) throws IOException {
                try {
                    q.z(dlVar.g, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j <= 0) {
                            return;
                        }
                        pf pfVar = dlVar.z;
                        while (true) {
                            if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                break;
                            }
                            j2 += (long) (pfVar.dl - pfVar.g);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            pfVar = pfVar.m;
                        }
                        z.this.z();
                        try {
                            try {
                                fvVar.a_(dlVar, j2);
                                j -= j2;
                                z.this.z(true);
                            } catch (IOException e) {
                                throw z.this.z(e);
                            }
                        } catch (Throwable th) {
                            z.this.z(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
            public void flush() throws IOException {
                z.this.z();
                try {
                    try {
                        fvVar.flush();
                        z.this.z(true);
                    } catch (IOException e) {
                        throw z.this.z(e);
                    }
                } catch (Throwable th) {
                    z.this.z(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                z.this.z();
                try {
                    try {
                        fvVar.close();
                        z.this.z(true);
                    } catch (IOException e) {
                        throw z.this.z(e);
                    }
                } catch (Throwable th) {
                    z.this.z(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.fv
            public tb z() {
                return z.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + fvVar + ")";
            }
        };
    }

    public final js z(final js jsVar) {
        return new js() { // from class: com.bytedance.sdk.component.dl.z.z.2
            @Override // com.bytedance.sdk.component.dl.z.js
            public long z(dl dlVar, long j) throws IOException {
                z.this.z();
                try {
                    try {
                        long jZ = jsVar.z(dlVar, j);
                        z.this.z(true);
                        return jZ;
                    } catch (IOException e) {
                        throw z.this.z(e);
                    }
                } catch (Throwable th) {
                    z.this.z(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                z.this.z();
                try {
                    try {
                        jsVar.close();
                        z.this.z(true);
                    } catch (IOException e) {
                        throw z.this.z(e);
                    }
                } catch (Throwable th) {
                    z.this.z(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.dl.z.js
            public tb z() {
                return z.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + jsVar + ")";
            }
        };
    }

    final void z(boolean z2) throws IOException {
        if (g() && z2) {
            throw g((IOException) null);
        }
    }

    final IOException z(IOException iOException) throws IOException {
        return !g() ? iOException : g(iOException);
    }

    protected IOException g(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.dl.z.z$z, reason: collision with other inner class name */
    private static final class C0129z extends com.bytedance.sdk.component.uy.a.dl {
        C0129z() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.m_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.component.dl.z.z> r0 = com.bytedance.sdk.component.dl.z.z.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                com.bytedance.sdk.component.dl.z.z r1 = com.bytedance.sdk.component.dl.z.z.a()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.bytedance.sdk.component.dl.z.z r2 = com.bytedance.sdk.component.dl.z.z.z     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.bytedance.sdk.component.dl.z.z.z = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.m_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
            L1c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.z.z.C0129z.run():void");
        }
    }

    static z a() throws InterruptedException {
        z zVar = z.m;
        if (zVar == null) {
            long jNanoTime = System.nanoTime();
            z.class.wait(g);
            if (z.m != null || System.nanoTime() - jNanoTime < f699a) {
                return null;
            }
            return z;
        }
        long jG = zVar.g(System.nanoTime());
        if (jG > 0) {
            long j = jG / 1000000;
            z.class.wait(j, (int) (jG - (1000000 * j)));
            return null;
        }
        z.m = zVar.m;
        zVar.m = null;
        return zVar;
    }
}
