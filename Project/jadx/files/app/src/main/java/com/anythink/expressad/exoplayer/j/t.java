package com.anythink.expressad.exoplayer.j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements u {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9746c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9747d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExecutorService f9748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b<? extends c> f9749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IOException f9750g;

    public interface a<T extends c> {
        int a(T t2, long j2, long j3, IOException iOException);

        void a(T t2, long j2, long j3);

        void a(T t2, long j2, long j3, boolean z2);
    }

    public interface c {
        void a();

        void b();
    }

    public interface d {
        void g();
    }

    private static final class e implements Runnable {
        private final d a;

        public e(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.g();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    public static final class g extends IOException {
        public g(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public t(String str) {
        this.f9748e = af.a(str);
    }

    private void d() {
        a((d) null);
    }

    @Override // com.anythink.expressad.exoplayer.j.u
    public final void c() throws IOException {
        a(Integer.MIN_VALUE);
    }

    @SuppressLint({"HandlerLeak"})
    private final class b<T extends c> extends Handler implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f9751c = "LoadTask";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f9752d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f9753e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f9754f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f9755g = 3;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f9756h = 4;
        public final int a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final T f9757i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f9758j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private a<T> f9759k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private IOException f9760l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f9761m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private volatile Thread f9762n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private volatile boolean f9763o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private volatile boolean f9764p;

        public b(Looper looper, T t2, a<T> aVar, int i2, long j2) {
            super(looper);
            this.f9757i = t2;
            this.f9759k = aVar;
            this.a = i2;
            this.f9758j = j2;
        }

        private void b() {
            t.this.f9749f = null;
        }

        private long c() {
            return Math.min((this.f9761m - 1) * 1000, 5000);
        }

        public final void a(int i2) throws IOException {
            IOException iOException = this.f9760l;
            if (iOException != null && this.f9761m > i2) {
                throw iOException;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.f9764p) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                a();
                return;
            }
            if (i2 == 4) {
                throw ((Error) message.obj);
            }
            b();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = jElapsedRealtime - this.f9758j;
            if (this.f9763o) {
                this.f9759k.a((c) this.f9757i, jElapsedRealtime, j2, false);
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                this.f9759k.a((c) this.f9757i, jElapsedRealtime, j2, false);
                return;
            }
            if (i3 == 2) {
                try {
                    this.f9759k.a(this.f9757i, jElapsedRealtime, j2);
                    return;
                } catch (RuntimeException e2) {
                    t.this.f9750g = new g(e2);
                    return;
                }
            }
            if (i3 != 3) {
                return;
            }
            this.f9760l = (IOException) message.obj;
            int iA = this.f9759k.a(this.f9757i, jElapsedRealtime, j2, this.f9760l);
            if (iA == 3) {
                t.this.f9750g = this.f9760l;
            } else if (iA != 2) {
                this.f9761m = iA == 1 ? 1 : this.f9761m + 1;
                a(Math.min((this.f9761m - 1) * 1000, 5000));
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f9762n = Thread.currentThread();
                if (!this.f9763o) {
                    ad.a("load:" + this.f9757i.getClass().getSimpleName());
                    try {
                        this.f9757i.b();
                        ad.a();
                    } catch (Throwable th) {
                        ad.a();
                        throw th;
                    }
                }
                if (this.f9764p) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                if (this.f9764p) {
                    return;
                }
                obtainMessage(3, e2).sendToTarget();
            } catch (InterruptedException unused) {
                com.anythink.expressad.exoplayer.k.a.b(this.f9763o);
                if (this.f9764p) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e3) {
                if (this.f9764p) {
                    return;
                }
                obtainMessage(3, new g(e3)).sendToTarget();
            } catch (OutOfMemoryError e4) {
                if (this.f9764p) {
                    return;
                }
                obtainMessage(3, new g(e4)).sendToTarget();
            } catch (Error e5) {
                if (!this.f9764p) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            }
        }

        public final void a(long j2) {
            com.anythink.expressad.exoplayer.k.a.b(t.this.f9749f == null);
            t.this.f9749f = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                a();
            }
        }

        public final void a(boolean z2) {
            this.f9764p = z2;
            this.f9760l = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f9763o = true;
                this.f9757i.a();
                if (this.f9762n != null) {
                    this.f9762n.interrupt();
                }
            }
            if (z2) {
                b();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f9759k.a((c) this.f9757i, jElapsedRealtime, jElapsedRealtime - this.f9758j, true);
                this.f9759k = null;
            }
        }

        private void a() {
            this.f9760l = null;
            t.this.f9748e.execute(t.this.f9749f);
        }
    }

    public final void b() {
        this.f9749f.a(false);
    }

    public final <T extends c> long a(T t2, a<T> aVar, int i2) {
        Looper looperMyLooper = Looper.myLooper();
        com.anythink.expressad.exoplayer.k.a.b(looperMyLooper != null);
        this.f9750g = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new b(looperMyLooper, t2, aVar, i2, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    public final boolean a() {
        return this.f9749f != null;
    }

    public final void a(@Nullable d dVar) {
        b<? extends c> bVar = this.f9749f;
        if (bVar != null) {
            bVar.a(true);
        }
        if (dVar != null) {
            this.f9748e.execute(new e(dVar));
        }
        this.f9748e.shutdown();
    }

    @Override // com.anythink.expressad.exoplayer.j.u
    public final void a(int i2) throws IOException {
        IOException iOException = this.f9750g;
        if (iOException == null) {
            b<? extends c> bVar = this.f9749f;
            if (bVar != null) {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = bVar.a;
                }
                bVar.a(i2);
                return;
            }
            return;
        }
        throw iOException;
    }
}
