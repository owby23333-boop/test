package com.bytedance.e.e.ga;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vn implements Handler.Callback {
    private static vn bf;
    private static Printer e;
    private static final Printer m = new Printer() { // from class: com.bytedance.e.e.ga.vn.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                vn.e().e(str);
            } else if (str.startsWith("<<<<< Finished")) {
                vn.e().bf(str);
            }
            if (vn.e == null || vn.e == vn.m) {
                return;
            }
            vn.e.println(str);
        }
    };
    private long ga;
    private long vn;
    private boolean xu;
    private int tg = 0;
    private final SparseArray<List<Runnable>> p = new SparseArray<>();
    private final List<Printer> v = new LinkedList();
    private final List<Printer> zk = new LinkedList();
    private boolean wu = false;
    private Handler d = new Handler(v.e().getLooper(), this);

    private vn() {
        bf();
    }

    public static vn e() {
        if (bf == null) {
            synchronized (vn.class) {
                if (bf == null) {
                    bf = new vn();
                }
            }
        }
        return bf;
    }

    private Printer ga() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e2) {
            com.bytedance.e.e.v.m.bf(e2);
            return null;
        }
    }

    public void bf() {
        if (this.wu) {
            return;
        }
        this.wu = true;
        Printer printerGa = ga();
        e = printerGa;
        Printer printer = m;
        if (printerGa == printer) {
            e = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.d.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            this.tg = 0;
            if (this.p.size() != 0 && this.p.keyAt(0) == 0) {
                e(this.p.valueAt(0));
                this.tg++;
            }
        } else {
            if (i == 1) {
                this.d.removeMessages(2);
                if (this.p.size() != 0) {
                    SparseArray<List<Runnable>> sparseArray = this.p;
                    if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                        e(this.p.get(Integer.MAX_VALUE));
                    }
                }
                return true;
            }
            if (i == 2) {
                e(this.p.valueAt(this.tg));
                this.tg++;
            }
        }
        if (this.tg >= this.p.size()) {
            return true;
        }
        long jKeyAt = this.p.keyAt(this.tg);
        if (jKeyAt != 2147483647L) {
            this.d.sendEmptyMessageAtTime(2, this.ga + jKeyAt);
        }
        return true;
    }

    public synchronized void bf(Printer printer) {
        this.v.add(printer);
    }

    public void e(long j, Runnable runnable) {
        e(j, runnable, 1, 0L);
    }

    public void e(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.p.get(i3);
            if (linkedList == null) {
                synchronized (this.p) {
                    linkedList = this.p.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.p.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    public void bf(String str) {
        this.vn = SystemClock.uptimeMillis();
        try {
            this.d.removeMessages(2);
            e(this.zk, str);
            this.d.sendEmptyMessage(1);
        } catch (Exception e2) {
            com.bytedance.e.e.v.m.bf(e2);
        }
    }

    public void e(Printer printer) {
        this.zk.add(printer);
    }

    public void e(String str) {
        if (!this.xu) {
            p.e(32L);
            this.xu = true;
        }
        this.ga = SystemClock.uptimeMillis();
        try {
            e(this.v, str);
            this.d.sendEmptyMessage(0);
        } catch (Exception e2) {
            com.bytedance.e.e.v.m.e(e2);
        }
    }

    private static void e(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e2) {
            com.bytedance.e.e.v.m.e(e2);
        }
    }

    private synchronized void e(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e2) {
                    com.bytedance.e.e.v.m.e(e2);
                }
            }
        }
    }
}
