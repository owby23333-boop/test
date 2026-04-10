package bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.mapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class v1 implements Handler.Callback, Comparator<u> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static v1 f759l;
    private k1 a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Application f760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j2 f761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<u> f762e = new ArrayList<>(32);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private v f763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k2 f764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b2 f766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.mapplog.util.a f767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f768k;

    private v1() {
    }

    public static void a(u uVar) {
        int size;
        Handler handler;
        v1 v1Var = f759l;
        if (v1Var == null) {
            l0.b("Init comes First!", null);
            d2.a(uVar);
            return;
        }
        if (uVar.a == 0) {
            l0.a(null);
        }
        if (uVar instanceof c0) {
            ((c0) uVar).f661k = v1Var.f761d.A();
        }
        synchronized (v1Var.f762e) {
            size = v1Var.f762e.size();
            v1Var.f762e.add(uVar);
        }
        if (size % 10 != 0 || (handler = v1Var.f768k) == null) {
            return;
        }
        handler.removeMessages(4);
        v1Var.f768k.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void a(String[] strArr) {
        v1 v1Var = f759l;
        if (v1Var == null) {
            l0.a(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = v1Var.f768k;
        if (handler != null) {
            handler.removeMessages(4);
            v1Var.f768k.obtainMessage(5, strArr).sendToTarget();
        }
    }

    private void b(String[] strArr) {
        ArrayList<u> arrayList;
        synchronized (this.f762e) {
            arrayList = (ArrayList) this.f762e.clone();
            this.f762e.clear();
        }
        int i2 = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(u.a(str));
            }
        }
        boolean zA = this.f761d.a(arrayList);
        if (arrayList.size() > 0) {
            if (!this.f761d.J()) {
                Intent intent = new Intent(this.f760c, (Class<?>) Collector.class);
                int size = arrayList.size();
                String[] strArr2 = new String[size];
                int length = 0;
                while (i2 < size) {
                    strArr2[i2] = arrayList.get(i2).e().toString();
                    length += strArr2[i2].length();
                    i2++;
                }
                if (length >= 307200) {
                    l0.a(null);
                }
                intent.putExtra("EMBED_K_DATA", strArr2);
                try {
                    this.f760c.sendBroadcast(intent);
                    return;
                } catch (Exception e2) {
                    l0.a(e2);
                    return;
                }
            }
            if (!zA && arrayList.size() <= 100) {
                synchronized (this.f762e) {
                    this.f762e.addAll(arrayList);
                }
                return;
            }
            Collections.sort(arrayList, this);
            ArrayList<u> arrayList2 = new ArrayList<>(arrayList.size());
            boolean zB = false;
            for (u uVar : arrayList) {
                if (this.f766i.a(uVar, arrayList2)) {
                    l();
                }
                if (uVar instanceof b0) {
                    zB = b2.b(uVar);
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                Handler handler = this.f768k;
                if (zB) {
                    handler.removeMessages(7);
                } else {
                    handler.sendEmptyMessageDelayed(7, this.f761d.P());
                }
            }
            this.f763f.a(arrayList2);
            if (this.b || !this.f766i.b() || this.f765h == null || !a.e()) {
                return;
            }
            g();
        }
    }

    public static void h() {
        v1 v1Var = f759l;
        if (v1Var != null) {
            v1Var.b(null);
        }
    }

    public static v1 i() {
        if (f759l == null) {
            synchronized (v1.class) {
                try {
                    if (f759l == null) {
                        f759l = new v1();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f759l;
    }

    public static String j() {
        b2 b2Var;
        v1 v1Var = f759l;
        if (v1Var == null || (b2Var = v1Var.f766i) == null) {
            return null;
        }
        return b2Var.f649e;
    }

    private void k() {
        if (this.f761d.N()) {
            if (this.a == null) {
                this.a = new k1(this);
                this.f765h.obtainMessage(6, this.a).sendToTarget();
                return;
            }
            return;
        }
        k1 k1Var = this.a;
        if (k1Var != null) {
            k1Var.f();
            this.a = null;
        }
    }

    private void l() {
        if (l0.a) {
            l0.a("packAndSend once, " + this.f766i.f649e + ", hadUI:" + this.f766i.b(), null);
        }
        Handler handler = this.f765h;
        if (handler != null) {
            handler.sendMessage(this.f768k.obtainMessage(6, new w1(this)));
            this.f765h.sendMessage(this.f768k.obtainMessage(6, new x1(this)));
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(u uVar, u uVar2) {
        long j2 = uVar.a - uVar2.a;
        if (j2 < 0) {
            return -1;
        }
        return j2 > 0 ? 1 : 0;
    }

    public Context a() {
        return this.f760c;
    }

    public void a(Application application, j2 j2Var, k2 k2Var, j0 j0Var) {
        l0.a("E.start", null);
        this.f760c = application;
        this.f763f = new v(application, k2Var, j2Var);
        this.f761d = j2Var;
        this.f764g = k2Var;
        this.f766i = new b2(this.f764g, this.f761d);
        this.f760c.registerActivityLifecycleCallbacks(j0Var);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        this.f768k = new Handler(handlerThread.getLooper(), this);
        this.f768k.sendEmptyMessage(1);
        k0.a(j2Var.A() != 0);
    }

    public v b() {
        return this.f763f;
    }

    public j2 c() {
        return this.f761d;
    }

    public k2 d() {
        return this.f764g;
    }

    public b2 e() {
        return this.f766i;
    }

    public com.bytedance.mapplog.util.a f() {
        if (this.f767j == null) {
            this.f767j = this.f761d.p().v();
            if (this.f767j == null) {
                this.f767j = com.bytedance.mapplog.util.b.a(0);
            }
        }
        return this.f767j;
    }

    public boolean g() {
        this.b = true;
        s1 s1Var = new s1(this);
        Handler handler = this.f765h;
        if (handler == null) {
            return false;
        }
        handler.obtainMessage(6, s1Var).sendToTarget();
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        l0.a("E.handleMessage" + message, null);
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 == 2) {
                ArrayList<t1> arrayList = new ArrayList(4);
                arrayList.add(new z1(this));
                arrayList.add(new u1(this));
                arrayList.add(new y1(this));
                arrayList.add(new a2(this));
                for (t1 t1Var : arrayList) {
                    long jH = t1Var.h();
                    if (jH < 864000000) {
                        this.f765h.sendMessageDelayed(this.f768k.obtainMessage(6, t1Var), jH);
                    }
                }
            } else if (i2 == 4) {
                b(null);
            } else if (i2 == 5) {
                b((String[]) message.obj);
            } else if (i2 == 6) {
                t1 t1Var2 = (t1) message.obj;
                if (!t1Var2.g()) {
                    long jH2 = t1Var2.h();
                    if (jH2 < 864000000) {
                        this.f765h.sendMessageDelayed(this.f768k.obtainMessage(6, t1Var2), jH2);
                    }
                }
            } else if (i2 != 7) {
                l0.a(null);
            } else {
                synchronized (this.f762e) {
                    this.f762e.add(b2.d());
                }
                b(null);
            }
            k();
        } else {
            this.f761d.O();
            if (!this.f764g.e()) {
                this.f768k.removeMessages(1);
                this.f768k.sendEmptyMessageDelayed(1, 1000L);
            } else if (this.f761d.J()) {
                HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                handlerThread.start();
                this.f765h = new Handler(handlerThread.getLooper(), this);
                this.f765h.sendEmptyMessage(2);
                if (this.f762e.size() > 0) {
                    this.f768k.removeMessages(4);
                    this.f768k.sendEmptyMessageDelayed(4, 1000L);
                }
                l0.d("net|worker start", null);
            }
            d2.a();
        }
        return true;
    }
}
