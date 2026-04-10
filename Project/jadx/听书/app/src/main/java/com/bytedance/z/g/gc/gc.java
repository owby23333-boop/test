package com.bytedance.z.g.gc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.z.g.gz.uy;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements Handler.Callback {
    private static gc g;
    private static final Printer uy = new Printer() { // from class: com.bytedance.z.g.gc.gc.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                gc.z().z(str);
            } else if (str.startsWith("<<<<< Finished")) {
                gc.z().g(str);
            }
            if (gc.z == null || gc.z == gc.uy) {
                return;
            }
            gc.z.println(str);
        }
    };
    private static Printer z;
    private long gc;
    private long m;
    private boolean wp;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1516a = 0;
    private final SparseArray<List<Runnable>> e = new SparseArray<>();
    private final List<Printer> gz = new LinkedList();
    private final List<Printer> fo = new LinkedList();
    private boolean kb = false;
    private Handler dl = new Handler(e.z().getLooper(), this);

    private gc() {
        g();
    }

    public static gc z() {
        if (g == null) {
            synchronized (gc.class) {
                if (g == null) {
                    g = new gc();
                }
            }
        }
        return g;
    }

    public void g() {
        if (this.kb) {
            return;
        }
        this.kb = true;
        Printer printerGc = gc();
        z = printerGc;
        Printer printer = uy;
        if (printerGc == printer) {
            z = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private Printer gc() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            uy.g(e);
            return null;
        }
    }

    public void z(long j, Runnable runnable) {
        z(j, runnable, 1, 0L);
    }

    public void z(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.e.get(i3);
            if (linkedList == null) {
                synchronized (this.e) {
                    linkedList = this.e.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.e.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    void z(String str) {
        if (!this.wp) {
            m.z(32L);
            this.wp = true;
        }
        this.gc = SystemClock.uptimeMillis();
        try {
            z(this.gz, str);
            this.dl.sendEmptyMessage(0);
        } catch (Exception e) {
            uy.z(e);
        }
    }

    void g(String str) {
        this.m = SystemClock.uptimeMillis();
        try {
            this.dl.removeMessages(2);
            z(this.fo, str);
            this.dl.sendEmptyMessage(1);
        } catch (Exception e) {
            uy.g(e);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.dl.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            this.f1516a = 0;
            if (this.e.size() != 0 && this.e.keyAt(0) == 0) {
                z(this.e.valueAt(0));
                this.f1516a++;
            }
        } else {
            if (i == 1) {
                this.dl.removeMessages(2);
                if (this.e.size() != 0) {
                    SparseArray<List<Runnable>> sparseArray = this.e;
                    if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                        z(this.e.get(Integer.MAX_VALUE));
                    }
                }
                return true;
            }
            if (i == 2) {
                z(this.e.valueAt(this.f1516a));
                this.f1516a++;
            }
        }
        if (this.f1516a >= this.e.size()) {
            return true;
        }
        long jKeyAt = this.e.keyAt(this.f1516a);
        if (jKeyAt != 2147483647L) {
            this.dl.sendEmptyMessageAtTime(2, this.gc + jKeyAt);
        }
        return true;
    }

    private static void z(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            uy.z(e);
        }
    }

    private synchronized void z(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    uy.z(e);
                }
            }
        }
    }
}
