package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108;

import android.os.SystemClock;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f1970e;
    private Thread.UncaughtExceptionHandler a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f1971c;
    private HashSet<Thread.UncaughtExceptionHandler> b = new HashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1972d = -1;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_int108.a$a, reason: collision with other inner class name */
    static final class C0063a extends bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122.c {
        final /* synthetic */ String b;

        C0063a(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a();
                aVar.a("data", this.b);
                aVar.a("userdefine", (Object) 1);
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVarA = e.a().a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.CUSTOM_JAVA, aVar);
                if (aVarA != null) {
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.a.a().c(aVarA.a());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private a() {
        b();
    }

    public static a a() {
        if (f1970e == null) {
            f1970e = new a();
        }
        return f1970e;
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122.a.a().a(new C0063a(str));
    }

    private void a(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.a.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    private void b() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.a == null) {
                this.a = defaultUncaughtExceptionHandler;
            } else {
                this.b.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    private void b(Thread thread, Throwable th) {
        List<f> listC = i.d().c();
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.JAVA;
        Iterator<f> it = listC.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(cVar, m.a(th), thread);
            } catch (Throwable th2) {
                j.b(th2);
            }
        }
    }

    private boolean c(Thread thread, Throwable th) {
        g gVarB = i.d().b();
        if (gVarB != null) {
            try {
                if (!gVarB.a(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public void a(b bVar) {
        this.f1971c = bVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (SystemClock.uptimeMillis() - this.f1972d < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.f1972d = SystemClock.uptimeMillis();
            boolean zC = c(thread, th);
            if (zC) {
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.JAVA;
                b(thread, th);
                if (zC && this.f1971c != null && this.f1971c.a(th)) {
                    this.f1971c.a(jCurrentTimeMillis, thread, th);
                    String str = "end dispose " + th;
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
