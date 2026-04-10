package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes8.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f8308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f8309b;
    private static long c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final a f1044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final c f1045a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f8310a;

        public a(c cVar) {
            this.f8310a = cVar;
        }

        public void finalize() throws Throwable {
            try {
                synchronized (this.f8310a) {
                    this.f8310a.c = true;
                    this.f8310a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f8311a;

        public b(int i) {
            this.f8311a = i;
        }
    }

    public static final class c extends Thread {

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f1048b;
        private boolean c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile long f8312a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private volatile boolean f1047a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f8313b = 50;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f1046a = new a();

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f8314a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private d[] f1049a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f8315b;
            private int c;

            private a() {
                this.f8314a = 256;
                this.f1049a = new d[256];
                this.f8315b = 0;
                this.c = 0;
            }

            private void c() {
                int i = this.f8315b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f1049a;
                    d dVar = dVarArr[i];
                    long j = dVar.f1050a;
                    d dVar2 = dVarArr[i2];
                    if (j >= dVar2.f1050a) {
                        return;
                    }
                    dVarArr[i] = dVar2;
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.f8315b)) {
                    return;
                }
                d[] dVarArr = this.f1049a;
                int i3 = i2 - 1;
                this.f8315b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }

            public d a() {
                return this.f1049a[0];
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m808a() {
                return this.f8315b == 0;
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m807a(d dVar) {
                d[] dVarArr = this.f1049a;
                int length = dVarArr.length;
                int i = this.f8315b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f1049a = dVarArr2;
                }
                d[] dVarArr3 = this.f1049a;
                int i2 = this.f8315b;
                this.f8315b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            public void b() {
                int i = 0;
                while (i < this.f8315b) {
                    if (this.f1049a[i].f1053a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.f8315b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f1049a;
                        if (dVarArr[i4].f1050a < dVarArr[i2].f1050a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f1049a;
                    d dVar = dVarArr2[i];
                    long j = dVar.f1050a;
                    d dVar2 = dVarArr2[i2];
                    if (j < dVar2.f1050a) {
                        return;
                    }
                    dVarArr2[i] = dVar2;
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m809a(int i) {
                for (int i2 = 0; i2 < this.f8315b; i2++) {
                    if (this.f1049a[i2].f8316a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.f8315b; i2++) {
                    d dVar = this.f1049a[i2];
                    if (dVar.f8316a == i) {
                        dVar.a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.f8315b; i2++) {
                    d dVar = this.f1049a[i2];
                    if (dVar.f1051a == bVar) {
                        dVar.a();
                    }
                }
                b();
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m806a() {
                this.f1049a = new d[this.f8314a];
                this.f8315b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f1049a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0092, code lost:
        
            r10.f8312a = android.os.SystemClock.uptimeMillis();
            r10.f1047a = true;
            r2.f1051a.run();
            r10.f1047a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
        
            r10.f1048b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a8, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r10 = this;
            L0:
                monitor-enter(r10)
                boolean r0 = r10.f1048b     // Catch: java.lang.Throwable -> Lb2
                if (r0 == 0) goto L7
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                return
            L7:
                com.xiaomi.push.service.r$c$a r0 = r10.f1046a     // Catch: java.lang.Throwable -> Lb2
                boolean r0 = r0.m808a()     // Catch: java.lang.Throwable -> Lb2
                if (r0 == 0) goto L1a
                boolean r0 = r10.c     // Catch: java.lang.Throwable -> Lb2
                if (r0 == 0) goto L15
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                return
            L15:
                r10.wait()     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lb2
            L18:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                goto L0
            L1a:
                long r0 = com.xiaomi.push.service.r.a()     // Catch: java.lang.Throwable -> Lb2
                com.xiaomi.push.service.r$c$a r2 = r10.f1046a     // Catch: java.lang.Throwable -> Lb2
                com.xiaomi.push.service.r$d r2 = r2.a()     // Catch: java.lang.Throwable -> Lb2
                java.lang.Object r3 = r2.f1052a     // Catch: java.lang.Throwable -> Lb2
                monitor-enter(r3)     // Catch: java.lang.Throwable -> Lb2
                boolean r4 = r2.f1053a     // Catch: java.lang.Throwable -> Laf
                r5 = 0
                if (r4 == 0) goto L34
                com.xiaomi.push.service.r$c$a r0 = r10.f1046a     // Catch: java.lang.Throwable -> Laf
                r0.b(r5)     // Catch: java.lang.Throwable -> Laf
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Laf
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                goto L0
            L34:
                long r6 = r2.f1050a     // Catch: java.lang.Throwable -> Laf
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Laf
                r0 = 0
                int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                r8 = 50
                if (r3 <= 0) goto L57
                long r0 = r10.f8313b     // Catch: java.lang.Throwable -> Lb2
                int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r2 <= 0) goto L47
                r6 = r0
            L47:
                long r0 = r0 + r8
                r10.f8313b = r0     // Catch: java.lang.Throwable -> Lb2
                r2 = 500(0x1f4, double:2.47E-321)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L52
                r10.f8313b = r2     // Catch: java.lang.Throwable -> Lb2
            L52:
                r10.wait(r6)     // Catch: java.lang.InterruptedException -> L55 java.lang.Throwable -> Lb2
            L55:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                goto L0
            L57:
                r10.f8313b = r8     // Catch: java.lang.Throwable -> Lb2
                java.lang.Object r3 = r2.f1052a     // Catch: java.lang.Throwable -> Lb2
                monitor-enter(r3)     // Catch: java.lang.Throwable -> Lb2
                com.xiaomi.push.service.r$c$a r4 = r10.f1046a     // Catch: java.lang.Throwable -> Lac
                com.xiaomi.push.service.r$d r4 = r4.a()     // Catch: java.lang.Throwable -> Lac
                long r6 = r4.f1050a     // Catch: java.lang.Throwable -> Lac
                long r8 = r2.f1050a     // Catch: java.lang.Throwable -> Lac
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L71
                com.xiaomi.push.service.r$c$a r4 = r10.f1046a     // Catch: java.lang.Throwable -> Lac
                int r4 = com.xiaomi.push.service.r.c.a.a(r4, r2)     // Catch: java.lang.Throwable -> Lac
                goto L72
            L71:
                r4 = r5
            L72:
                boolean r6 = r2.f1053a     // Catch: java.lang.Throwable -> Lac
                if (r6 == 0) goto L83
                com.xiaomi.push.service.r$c$a r0 = r10.f1046a     // Catch: java.lang.Throwable -> Lac
                int r1 = com.xiaomi.push.service.r.c.a.a(r0, r2)     // Catch: java.lang.Throwable -> Lac
                r0.b(r1)     // Catch: java.lang.Throwable -> Lac
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lac
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                goto L0
            L83:
                long r6 = r2.f1050a     // Catch: java.lang.Throwable -> Lac
                r2.a(r6)     // Catch: java.lang.Throwable -> Lac
                com.xiaomi.push.service.r$c$a r6 = r10.f1046a     // Catch: java.lang.Throwable -> Lac
                r6.b(r4)     // Catch: java.lang.Throwable -> Lac
                r2.f1050a = r0     // Catch: java.lang.Throwable -> Lac
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lac
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> La3
                r10.f8312a = r3     // Catch: java.lang.Throwable -> La3
                r10.f1047a = r0     // Catch: java.lang.Throwable -> La3
                com.xiaomi.push.service.r$b r1 = r2.f1051a     // Catch: java.lang.Throwable -> La3
                r1.run()     // Catch: java.lang.Throwable -> La3
                r10.f1047a = r5     // Catch: java.lang.Throwable -> La3
                goto L0
            La3:
                r1 = move-exception
                monitor-enter(r10)
                r10.f1048b = r0     // Catch: java.lang.Throwable -> La9
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La9
                throw r1
            La9:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La9
                throw r0
            Lac:
                r0 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lac
                throw r0     // Catch: java.lang.Throwable -> Lb2
            Laf:
                r0 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Laf
                throw r0     // Catch: java.lang.Throwable -> Lb2
            Lb2:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb2
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.r.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f1046a.m807a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f1048b = true;
            this.f1046a.m806a();
            notify();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m805a() {
            return this.f1047a && SystemClock.uptimeMillis() - this.f8312a > 600000;
        }
    }

    static {
        long jElapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f8308a = jElapsedRealtime;
        f8309b = jElapsedRealtime;
    }

    public r(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f1045a = cVar;
        this.f1044a = new a(cVar);
    }

    public static synchronized long a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = f8309b;
        if (jElapsedRealtime > j) {
            f8308a += jElapsedRealtime - j;
        }
        f8309b = jElapsedRealtime;
        return f8308a;
    }

    private static synchronized long b() {
        long j;
        j = c;
        c = 1 + j;
        return j;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m803b() {
        synchronized (this.f1045a) {
            this.f1045a.f1046a.m806a();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8316a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        long f1050a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        b f1051a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final Object f1052a = new Object();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f1053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f8317b;

        public void a(long j) {
            synchronized (this.f1052a) {
                this.f8317b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1052a) {
                z = !this.f1053a && this.f1050a > 0;
                this.f1053a = true;
            }
            return z;
        }
    }

    public r(String str) {
        this(str, false);
    }

    private void b(b bVar, long j) {
        synchronized (this.f1045a) {
            if (!this.f1045a.f1048b) {
                long jA = j + a();
                if (jA >= 0) {
                    d dVar = new d();
                    dVar.f8316a = bVar.f8311a;
                    dVar.f1051a = bVar;
                    dVar.f1050a = jA;
                    this.f1045a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jA);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public r(boolean z) {
        this("Timer-" + b(), z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m800a() {
        com.xiaomi.channel.commonutils.logger.b.m106a("quit. finalizer:" + this.f1044a);
        this.f1045a.a();
    }

    public r() {
        this(false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m802a(int i) {
        boolean zM809a;
        synchronized (this.f1045a) {
            zM809a = this.f1045a.f1046a.m809a(i);
        }
        return zM809a;
    }

    public void a(int i) {
        synchronized (this.f1045a) {
            this.f1045a.f1046a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f1045a) {
            this.f1045a.f1046a.a(i, bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m801a() {
        return this.f1045a.m805a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f1045a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }
}
