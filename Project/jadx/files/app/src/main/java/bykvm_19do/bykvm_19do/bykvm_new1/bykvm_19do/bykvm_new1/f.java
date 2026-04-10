package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements Handler.Callback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Printer f2000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static f f2001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Printer f2002k = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2003c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2008h;
    private int b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<List<Runnable>> f2004d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Printer> f2005e = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Printer> f2006f = new LinkedList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2007g = false;
    private Handler a = new Handler(h.b().getLooper(), this);

    static final class a implements Printer {
        a() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                f.e().a(str);
            } else if (str.startsWith("<<<<< Finished")) {
                f.e().b(str);
            }
            if (f.f2000i == null || f.f2000i == f.f2002k) {
                return;
            }
            f.f2000i.println(str);
        }
    }

    private f() {
        a();
    }

    private static void a(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.a(e2);
        }
    }

    private void a(List<? extends Printer> list, String str) {
        synchronized (this) {
            if (list != null) {
                if (!list.isEmpty()) {
                    try {
                        Iterator<? extends Printer> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().println(str);
                        }
                    } catch (Exception e2) {
                        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.a(e2);
                    }
                }
            }
        }
    }

    private Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.b(e2);
            return null;
        }
    }

    public static f e() {
        if (f2001j == null) {
            synchronized (f.class) {
                try {
                    if (f2001j == null) {
                        f2001j = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2001j;
    }

    public void a() {
        if (this.f2007g) {
            return;
        }
        this.f2007g = true;
        f2000i = d();
        if (f2000i == f2002k) {
            f2000i = null;
        }
        Looper.getMainLooper().setMessageLogging(f2002k);
    }

    public void a(long j2, Runnable runnable) {
        a(j2, runnable, 1, 0L);
    }

    public void a(long j2, Runnable runnable, int i2, long j3) {
        if (j2 < 0) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (int) j2;
            List<Runnable> linkedList = this.f2004d.get(i4);
            if (linkedList == null) {
                synchronized (this.f2004d) {
                    linkedList = this.f2004d.get(i4);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.f2004d.put(i4, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j2 += j3;
        }
    }

    public void a(Printer printer) {
        this.f2006f.add(printer);
    }

    void a(String str) {
        if (!this.f2008h) {
            g.a(32L);
            this.f2008h = true;
        }
        this.f2003c = SystemClock.uptimeMillis();
        try {
            a(this.f2005e, str);
            this.a.sendEmptyMessage(0);
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.a(e2);
        }
    }

    public void b(Printer printer) {
        synchronized (this) {
            this.f2005e.add(printer);
        }
    }

    void b(String str) {
        SystemClock.uptimeMillis();
        try {
            this.a.removeMessages(2);
            a(this.f2006f, str);
            this.a.sendEmptyMessage(1);
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j.b(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            android.os.Handler r0 = r7.a
            r1 = 0
            boolean r0 = r0.hasMessages(r1)
            r2 = 1
            if (r0 == 0) goto Lc
            goto L88
        Lc:
            int r8 = r8.what
            r0 = 2
            if (r8 == 0) goto L44
            if (r8 == r2) goto L1b
            if (r8 == r0) goto L16
            goto L66
        L16:
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            int r1 = r7.b
            goto L58
        L1b:
            android.os.Handler r8 = r7.a
            r8.removeMessages(r0)
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            int r8 = r8.size()
            if (r8 == 0) goto L88
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            int r0 = r8.size()
            int r0 = r0 - r2
            int r8 = r8.keyAt(r0)
            if (r8 != 0) goto L88
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            r0 = 2147483647(0x7fffffff, float:NaN)
            java.lang.Object r8 = r8.get(r0)
            java.util.List r8 = (java.util.List) r8
            a(r8)
            goto L88
        L44:
            r7.b = r1
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            int r8 = r8.size()
            if (r8 == 0) goto L66
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            int r8 = r8.keyAt(r1)
            if (r8 != 0) goto L66
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
        L58:
            java.lang.Object r8 = r8.valueAt(r1)
            java.util.List r8 = (java.util.List) r8
            a(r8)
            int r8 = r7.b
            int r8 = r8 + r2
            r7.b = r8
        L66:
            int r8 = r7.b
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r1 = r7.f2004d
            int r1 = r1.size()
            if (r8 >= r1) goto L88
            android.util.SparseArray<java.util.List<java.lang.Runnable>> r8 = r7.f2004d
            int r1 = r7.b
            int r8 = r8.keyAt(r1)
            long r3 = (long) r8
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L88
            android.os.Handler r8 = r7.a
            long r5 = r7.f2003c
            long r3 = r3 + r5
            r8.sendEmptyMessageAtTime(r0, r3)
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.handleMessage(android.os.Message):boolean");
    }
}
