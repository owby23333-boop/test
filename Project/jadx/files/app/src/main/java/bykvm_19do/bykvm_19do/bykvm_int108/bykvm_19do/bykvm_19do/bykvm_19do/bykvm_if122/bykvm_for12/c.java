package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends HandlerThread implements e, d, Handler.Callback {
    private volatile boolean a;
    private final Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d f1877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c f1878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f1880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f1881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f1882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f1883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicInteger f1884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile Handler f1885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicInteger f1887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicInteger f1888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1889o;

    class a extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        final /* synthetic */ List b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f1890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f1891d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, List list, boolean z2, long j2) {
            super(str);
            this.b = list;
            this.f1890c = z2;
            this.f1891d = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) this.b, this.f1890c, this.f1891d, cVar.f1880f);
        }
    }

    class b implements bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b {
        final /* synthetic */ boolean a;
        final /* synthetic */ long b;

        b(boolean z2, long j2) {
            this.a = z2;
            this.b = j2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b
        public void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
            try {
                c.this.f1884j.decrementAndGet();
                if (list == null || list.size() == 0) {
                    return;
                }
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar = list.get(i2);
                    if (aVar != null) {
                        c.this.a(this.a, aVar.b(), aVar.a(), this.b);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public c(PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> priorityBlockingQueue) {
        super("csj_log");
        this.a = true;
        this.b = new Object();
        this.f1881g = 0L;
        this.f1882h = 0L;
        this.f1883i = new AtomicInteger(0);
        this.f1884j = new AtomicInteger(0);
        this.f1886l = new ArrayList();
        this.f1887m = new AtomicInteger(0);
        this.f1888n = new AtomicInteger(0);
        this.f1889o = 10;
        this.f1879e = priorityBlockingQueue;
        this.f1877c = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0089 A[Catch: all -> 0x0159, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:54:0x0118, B:56:0x011c, B:57:0x0126, B:23:0x003c, B:25:0x0051, B:26:0x0058, B:28:0x0065, B:29:0x006c, B:31:0x007f, B:32:0x0084, B:33:0x0089, B:35:0x008f, B:37:0x0095, B:39:0x00a5, B:40:0x00aa, B:42:0x00b2, B:43:0x00b7, B:44:0x00d9, B:46:0x00e9, B:47:0x00ef, B:49:0x00fc, B:50:0x0102, B:52:0x0110, B:53:0x0115, B:59:0x0157), top: B:64:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c A[Catch: all -> 0x0159, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:54:0x0118, B:56:0x011c, B:57:0x0126, B:23:0x003c, B:25:0x0051, B:26:0x0058, B:28:0x0065, B:29:0x006c, B:31:0x007f, B:32:0x0084, B:33:0x0089, B:35:0x008f, B:37:0x0095, B:39:0x00a5, B:40:0x00aa, B:42:0x00b2, B:43:0x00b7, B:44:0x00d9, B:46:0x00e9, B:47:0x00ef, B:49:0x00fc, B:50:0x0102, B:52:0x0110, B:53:0x0115, B:59:0x0157), top: B:64:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r6, java.util.List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> r7, long r8) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(int, java.util.List, long):void");
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        if (bVar == null || !bVar.a) {
            return;
        }
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.e> listB = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.b();
        if (list == null || listB == null || listB.size() == 0) {
            return;
        }
        for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
            if (aVar.e() == 1) {
                String strC = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.c(aVar);
                String strE = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.e(aVar);
                for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.e eVar : listB) {
                    if (eVar != null) {
                        eVar.a(strC, strE);
                    }
                }
            }
        }
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        this.f1883i.set(0);
        this.f1880f = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b ? 5 : bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.f1898c ? 7 : 4;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.n(), 1);
        this.f1877c.a(aVar, this.f1880f);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.k(aVar);
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        this.f1883i.set(0);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("handleThreadMessage()");
        if (i2 == 0) {
            this.f1880f = ((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) aVar).j();
            if (this.f1880f == 6) {
                return;
            } else {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.d0(), 1);
            }
        } else {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b bVar = (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) aVar;
            if (bVar.j() == 1) {
                this.f1880f = 1;
            } else {
                if (bVar.j() != 2) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("before size:" + i2);
                f();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("after size :" + i2);
                this.f1880f = 2;
            }
        }
        b(aVar);
    }

    private void a(String str) {
        if (this.f1885k.hasMessages(11)) {
            this.f1885k.removeMessages(11);
        }
        if (this.f1886l.size() == 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ensureUploadOptBatch empty：" + str);
            return;
        }
        ArrayList arrayList = new ArrayList(this.f1886l);
        this.f1886l.clear();
        a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, false, "before_" + str);
        b();
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        this.f1886l.addAll(list);
        g gVarB = j.l().b();
        if (gVarB != null && gVarB.h() != null) {
            this.f1889o = gVarB.h().c();
        }
        if (this.f1886l.size() >= this.f1889o) {
            if (this.f1885k.hasMessages(11)) {
                this.f1885k.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.f1886l);
            this.f1886l.clear();
            a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, false, "max_size_dispatch");
            b();
            return;
        }
        if (this.f1879e.size() != 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("uploadBatchOptimize nothing：" + this.f1879e.size() + "  " + this.a);
            return;
        }
        a(false);
        if (this.f1885k.hasMessages(11)) {
            this.f1885k.removeMessages(11);
        }
        if (this.f1885k.hasMessages(1)) {
            this.f1885k.removeMessages(1);
        }
        long jB = 200;
        if (gVarB != null && gVarB.h() != null) {
            jB = gVarB.h().b();
        }
        this.f1885k.sendEmptyMessageDelayed(11, jB);
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, String str) {
        a(str);
        a(list, false, str);
        b();
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z2, long j2) {
        g gVarB = j.l().b();
        if (gVarB != null) {
            Executor executorB = gVarB.b();
            if (list.get(0).e() == 1) {
                executorB = gVarB.a();
            }
            if (executorB == null) {
                return;
            }
            this.f1884j.incrementAndGet();
            executorB.execute(new a("csj_log_upload", list, z2, j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z2, long j2, int i2) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVarA;
        try {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar = list.get(0);
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.K(), 1);
            if (aVar.b() == 0) {
                bVarA = j.m().a(list);
                a(bVarA, list);
                if (bVarA != null) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(list, bVarA.f1875c);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().d());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e2) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("json exception:" + e2.getMessage());
                }
                bVarA = j.m().a(jSONObject);
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar = bVarA;
            this.f1884j.decrementAndGet();
            a(z2, bVar, list, j2);
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("inner exception:" + th.getMessage());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.I(), 1);
            this.f1884j.decrementAndGet();
        }
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z2, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(list, this.f1880f, str);
        this.f1878d = j.l().i();
        if (this.f1878d != null) {
            b(list, z2, jCurrentTimeMillis);
        } else {
            a(list, z2, jCurrentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, long j2) {
        if (z2 || bVar == null) {
            return;
        }
        int i2 = bVar.b;
        if (bVar.f1876d) {
            i2 = -1;
        }
        if (i2 == 510 || i2 == 511) {
            i2 = -2;
        }
        if (list != null) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("preprocessResult code is " + i2 + " sz:" + list.size() + "  count:" + this.f1884j.get());
        }
        a(i2, list, j2);
    }

    private void b() {
        if (this.f1885k.hasMessages(11)) {
            d();
        } else {
            b(1);
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("afterUpload message:" + this.f1880f);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.h(), 1);
        if (this.f1880f == 2) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.e(), 1);
            synchronized (this.b) {
                try {
                    long jNanoTime = System.nanoTime();
                    this.b.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    StringBuilder sb = new StringBuilder();
                    sb.append("afterUpload delta:");
                    sb.append(jNanoTime2);
                    sb.append(" start:");
                    sb.append(jNanoTime);
                    sb.append(" condition:");
                    sb.append(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b || bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.f1898c);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(sb.toString());
                    if (jNanoTime2 >= 5000000000L || 5000000000L - jNanoTime2 < 50000000) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("afterUpload wait timeout");
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.e0(), 1);
                    } else if (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b || bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.f1898c) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.U(), 1);
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("afterUpload wait serverBusy");
                    } else {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("afterUpload meet notifyRunOnce again");
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.g(), 1);
                        a(2);
                    }
                } catch (InterruptedException e2) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("wait exception:" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    private void b(int i2) {
        AtomicLong atomicLongH;
        if (a()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.w(), 1);
            return;
        }
        if (this.f1885k == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.N(), 1);
        if (this.f1885k.hasMessages(1)) {
            return;
        }
        if (i2 == 1) {
            atomicLongH = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.f();
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    atomicLongH = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.H();
                }
                this.f1885k.sendEmptyMessage(1);
            }
            atomicLongH = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.v();
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongH, 1);
        this.f1885k.sendEmptyMessage(1);
    }

    private void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (g()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("upload cancel:" + bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(this.f1880f));
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.q(), 1);
            if (this.f1879e.size() != 0) {
                return;
            }
            if (this.f1885k.hasMessages(2)) {
                a(false);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b = false;
            this.f1882h = 0L;
            this.f1881g = 0L;
            this.f1887m.set(0);
            this.f1888n.set(0);
        }
        boolean zA = a(this.f1880f, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(zA, this.f1880f, aVar);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.p(), 1);
        if (zA) {
            List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listA = this.f1877c.a(this.f1880f, -1);
            if (listA != null) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("upload size:" + listA.size());
                b(listA);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.c("no need upload");
        }
        d();
    }

    private void b(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        String str;
        String str2;
        if (list.size() != 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(list, this.f1879e.size());
            if (list.size() > 1 || bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.d()) {
                str2 = "batchRead";
            } else {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar = list.get(0);
                if (aVar == null) {
                    str = "upload adLogEvent is null";
                } else if (aVar.e() == 1) {
                    str2 = "highPriority";
                } else if (aVar.b() == 0 && aVar.e() == 2) {
                    if (aVar.c() != 3) {
                        a(list);
                        return;
                    }
                    str2 = "version_v3";
                } else if (aVar.b() == 1) {
                    str2 = "stats";
                } else if (aVar.b() == 3) {
                    str2 = "adType_v3";
                } else if (aVar.b() == 2) {
                    str2 = "other";
                } else {
                    str = "upload adLogEvent adType error";
                }
            }
            a(list, str2);
            return;
        }
        d();
        str = "upload list is empty";
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(str);
    }

    private void b(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z2, long j2) {
        this.f1884j.incrementAndGet();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.K(), 1);
        try {
            this.f1878d.a(list, new b(z2, j2));
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("outer exception：" + e2.getMessage());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.I(), 1);
            this.f1884j.decrementAndGet();
        }
    }

    private void c() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.Z(), 1);
        a(false);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.e();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("exit log thread");
    }

    private boolean c(int i2) {
        return i2 >= 4 && this.f1884j.get() == 0 && !bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b && !bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.f1898c;
    }

    private void d() {
        try {
            if (this.f1879e.size() == 0 && this.f1885k.hasMessages(11) && a()) {
                a(false);
            }
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(e2.getMessage());
        }
    }

    private void e() {
        while (a()) {
            try {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.F(), 1);
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVarPoll = this.f1879e.poll(60000L, TimeUnit.MILLISECONDS);
                int size = this.f1879e.size();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("poll size:" + size);
                if (aVarPoll instanceof bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) {
                    a(aVarPoll, size);
                } else if (aVarPoll == null) {
                    int iIncrementAndGet = this.f1883i.incrementAndGet();
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.o(), 1);
                    if (c(iIncrementAndGet)) {
                        c();
                        return;
                    } else if (iIncrementAndGet < 4) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("timeoutCount:" + iIncrementAndGet);
                        this.f1880f = 1;
                        b((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a) null);
                    }
                } else {
                    a(aVarPoll);
                    b(aVarPoll);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("run exception:" + th.getMessage());
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.I(), 1);
            }
        }
    }

    private void f() {
        if (this.f1879e.size() >= 100) {
            for (int i2 = 0; i2 < 100; i2++) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVarPoll = this.f1879e.poll();
                if (aVarPoll instanceof bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ignore tm");
                } else if (aVarPoll != null) {
                    a(aVarPoll);
                } else {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("event == null");
                }
            }
        }
    }

    private boolean g() {
        return bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b && (this.f1880f == 4 || this.f1880f == 7 || this.f1880f == 6 || this.f1880f == 5 || this.f1880f == 2);
    }

    private void h() {
        if (!isAlive()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("th dead");
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.a();
        } else {
            if (a()) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("monitor  mLogThread ");
            a(6);
        }
    }

    private void i() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sendServerBusyOrRoutineErrorRetryMessage");
        h();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.G(), 1);
        a(1);
    }

    public void a(int i2) {
        try {
            boolean zA = a(i2, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b);
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("notify flush : " + zA + " " + i2);
            if (i2 == 6 || zA) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b bVar = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b();
                bVar.a(i2);
                this.f1879e.add(bVar);
                b(3);
            }
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(th.getMessage());
        }
    }

    public void a(int i2, long j2) {
        String str;
        if (this.f1885k == null) {
            str = "mHandler == null";
        } else {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            if (i2 == 2) {
                int iIncrementAndGet = this.f1887m.incrementAndGet();
                long j3 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j2;
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sendMonitorMessage:" + i2 + "  busy:" + iIncrementAndGet + "  l:" + j3);
                this.f1885k.sendMessageDelayed(messageObtain, j3);
                return;
            }
            if (i2 == 3) {
                int iIncrementAndGet2 = this.f1888n.incrementAndGet();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sendMonitorMessage:" + i2 + "  error:" + iIncrementAndGet2);
                this.f1885k.sendMessageDelayed(messageObtain, ((long) (((iIncrementAndGet2 + (-1)) % 4) + 1)) * j2);
                return;
            }
            str = "sendMonitorMessage error state";
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(str);
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, boolean z2) {
        if (aVar == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ignore result : " + z2 + ":" + this.a + " adType: " + ((int) aVar.b()));
        if (!z2) {
            this.f1879e.add(aVar);
            b(2);
        } else {
            if (this.f1885k == null) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("handler is null，ignore is true");
                return;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(aVar);
            a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, true, "ignore_result_dispatch");
        }
    }

    public void a(boolean z2) {
        this.a = z2;
    }

    public boolean a() {
        return this.a;
    }

    public boolean a(int i2, boolean z2) {
        g gVarB = j.l().b();
        if (gVarB != null && gVarB.a(j.l().d())) {
            return this.f1877c.a(i2, z2);
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("AdThread NET IS NOT AVAILABLE!!!");
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("HANDLER_MESSAGE_INIT");
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.u(), 1);
            a(true);
            e();
        } else if (i2 == 2 || i2 == 3) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("-----------------server busy handleMessage---------------- ");
            i();
        } else if (i2 == 11) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("opt upload");
            ArrayList arrayList = new ArrayList(this.f1886l);
            this.f1886l.clear();
            a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, false, "timeout_dispatch");
            b();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.f1885k = new Handler(getLooper(), this);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.a(this.f1885k);
        this.f1885k.sendEmptyMessage(1);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("onLooperPrepared");
    }
}
