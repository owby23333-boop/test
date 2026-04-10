package com.bytedance.z.g.a;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.z.g.gc.z.gc;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.uy;
import com.bytedance.z.g.gz.v;
import com.bytedance.z.g.m;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Thread.UncaughtExceptionHandler {
    private static z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1506a;
    private Thread.UncaughtExceptionHandler g;
    private HashSet<Thread.UncaughtExceptionHandler> dl = new HashSet<>();
    private long gc = -1;

    private z() {
        g();
    }

    public static z z() {
        if (z == null) {
            z = new z();
        }
        return z;
    }

    public void z(g gVar) {
        this.f1506a = gVar;
    }

    private void g() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.g == null) {
                this.g = defaultUncaughtExceptionHandler;
            } else {
                this.dl.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        g gVar;
        if (SystemClock.uptimeMillis() - this.gc < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.gc = SystemClock.uptimeMillis();
            boolean z2 = z(thread, th);
            if (z2) {
                com.bytedance.z.g.dl dlVar = com.bytedance.z.g.dl.JAVA;
                g(thread, th);
                if (z2 && (gVar = this.f1506a) != null && gVar.z(th)) {
                    this.f1506a.z(jCurrentTimeMillis, thread, th);
                    wp.z("crash_dispatcher", "end dispose ".concat(String.valueOf(th)));
                }
            }
        } catch (Throwable th2) {
            try {
                uy.z(th2);
            } finally {
                dl(thread, th);
            }
        }
    }

    private boolean z(Thread thread, Throwable th) {
        m mVarA = gz.g().a();
        if (mVarA != null) {
            try {
                if (!mVarA.z(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void g(Thread thread, Throwable th) {
        List<Object> listG = gz.g().g();
        com.bytedance.z.g.dl dlVar = com.bytedance.z.g.dl.JAVA;
        Iterator<Object> it = listG.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                v.z(th);
            } catch (Throwable th2) {
                uy.g(th2);
            }
        }
    }

    private void dl(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.dl.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.g.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public static void z(final String str) {
        if (str == null) {
            return;
        }
        com.bytedance.z.dl.z.g.z.z().z(new com.bytedance.z.dl.z.g.dl() { // from class: com.bytedance.z.g.a.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.z.g.dl.z zVar = new com.bytedance.z.g.dl.z();
                    zVar.z("data", str);
                    zVar.z("userdefine", (Object) 1);
                    com.bytedance.z.g.dl.z zVarZ = gc.z().z(com.bytedance.z.g.dl.CUSTOM_JAVA, zVar);
                    if (zVarZ != null) {
                        com.bytedance.z.g.e.z.z().dl(zVarZ.z());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
