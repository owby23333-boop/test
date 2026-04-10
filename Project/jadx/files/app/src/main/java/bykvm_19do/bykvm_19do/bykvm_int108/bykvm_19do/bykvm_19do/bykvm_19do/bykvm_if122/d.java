package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f1894g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a f1895h = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f1896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f1897j;
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Handler f1899d;
    public volatile boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f1898c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1900e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1901f = new PriorityBlockingQueue<>(8, this.f1900e);

    class a implements Comparator<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2) {
            return d.this.a(aVar, aVar2);
        }
    }

    class b extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        final /* synthetic */ g b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f1902c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, g gVar, long j2) {
            super(str);
            this.b = gVar;
            this.f1902c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.b, this.f1902c);
        }
    }

    class c extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        c(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.a != null) {
                d.this.a.a(2);
            }
        }
    }

    static {
        new AtomicLong(0L);
        new AtomicLong(0L);
        f1896i = System.currentTimeMillis();
        f1897j = 0L;
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2) {
        long jC;
        long jB;
        long jB2;
        long jC2;
        if (aVar == null) {
            return aVar2 == null ? 0 : -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        if (aVar.e() != aVar2.e()) {
            return aVar.e() - aVar2.e();
        }
        if (aVar.g() != null) {
            jC = aVar.g().c();
            jB = aVar.g().b();
        } else {
            jC = 0;
            jB = 0;
        }
        if (aVar2.g() != null) {
            jC2 = aVar2.g().c();
            jB2 = aVar2.g().b();
        } else {
            jB2 = 0;
            jC2 = 0;
        }
        if (jC == 0 || jC2 == 0) {
            return 0;
        }
        long j2 = jC - jC2;
        if (Math.abs(j2) > 2147483647L) {
            return 0;
        }
        if (j2 != 0) {
            return (int) j2;
        }
        if (jB == 0 || jB2 == 0) {
            return 0;
        }
        return (int) (jB - jB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, long j2) {
        if (gVar == null || this.a == null) {
            return;
        }
        this.a.a(gVar.a(f1895h.a(j2)), true);
        f1895h.h0();
    }

    private void a(g gVar, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (gVar == null || !gVar.e()) {
            return;
        }
        long jB = 0;
        if (aVar != null && aVar.g() != null) {
            jB = aVar.g().b();
        }
        long j2 = jB;
        if (j2 == 1) {
            f1897j = System.currentTimeMillis();
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(f1895h.f0(), 1);
        if (j2 == 200) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("==> monitor upload index1:" + j2);
                a(gVar, j2);
                return;
            }
            Executor executorA = gVar.a();
            if (executorA == null) {
                executorA = gVar.b();
            }
            if (executorA != null) {
                executorA.execute(new b(AgooConstants.MESSAGE_REPORT, gVar, j2));
            }
        }
    }

    public void a(Handler handler) {
        this.f1899d = handler;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        a();
        g gVarB = j.l().b();
        if (this.a != null) {
            a(gVarB, aVar);
            this.a.a(aVar, aVar.e() == 4);
        }
    }

    public boolean a() {
        boolean z2;
        synchronized (this) {
            try {
            } catch (Throwable th) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(th.getMessage());
            }
            if (this.a != null && this.a.isAlive()) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("LogThread state:" + this.a.getState());
                z2 = false;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("--start LogThread--");
            this.a = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c(this.f1901f);
            this.a.start();
            z2 = true;
        }
        return z2;
    }

    public void b() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(f1895h.C(), 1);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("flushMemoryAndDB()");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.a != null) {
                this.a.a(2);
                return;
            }
            return;
        }
        g gVarB = j.l().b();
        if (gVarB == null) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("discard flush");
            return;
        }
        Executor executorA = gVarB.a();
        if (executorA == null) {
            executorA = gVarB.b();
        }
        if (executorA != null) {
            executorA.execute(new c("flush"));
        }
    }

    public PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> c() {
        return this.f1901f;
    }

    public void d() {
        a();
        b();
    }

    public void e() {
        synchronized (this) {
            if (this.a != null && this.a.isAlive()) {
                if (this.f1899d != null) {
                    this.f1899d.removeCallbacksAndMessages(null);
                }
                this.a.a(false);
                if (Build.VERSION.SDK_INT >= 18) {
                    this.a.quitSafely();
                } else {
                    this.a.quit();
                }
                this.a = null;
            }
        }
    }
}
