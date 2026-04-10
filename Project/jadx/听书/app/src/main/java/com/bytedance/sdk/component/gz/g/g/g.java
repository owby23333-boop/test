package com.bytedance.sdk.component.gz.g.g;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.gz.g.g.dl.dl;
import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.fo;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.utils.wp;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class g implements fo {
    private gc e;
    private volatile dl gc;
    private volatile Handler m;
    public static final com.bytedance.sdk.component.gz.g.g.z.z z = new com.bytedance.sdk.component.gz.g.g.z.z();
    public static final long dl = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f739a = 0;
    public volatile int g = 0;
    private final Comparator<com.bytedance.sdk.component.gz.z.g> gz = new Comparator<com.bytedance.sdk.component.gz.z.g>() { // from class: com.bytedance.sdk.component.gz.g.g.g.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.sdk.component.gz.z.g gVar, com.bytedance.sdk.component.gz.z.g gVar2) {
            return g.this.z(gVar, gVar2);
        }
    };

    public g(gc gcVar) {
        this.e = gcVar;
    }

    public void z(int i) {
        this.g = i;
    }

    public boolean dl() {
        return this.g == 1;
    }

    public boolean a() {
        return this.g == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z(com.bytedance.sdk.component.gz.z.g gVar, com.bytedance.sdk.component.gz.z.g gVar2) {
        long jZ;
        long jG;
        long jG2;
        long jZ2;
        if (gVar == null) {
            return gVar2 == null ? 0 : -1;
        }
        if (gVar2 == null) {
            return 1;
        }
        if (gVar.gc() == gVar2.gc()) {
            if (gVar.z() != null) {
                jZ = gVar.z().z();
                jG = gVar.z().g();
            } else {
                jZ = 0;
                jG = 0;
            }
            if (gVar2.z() != null) {
                jZ2 = gVar2.z().z();
                jG2 = gVar2.z().g();
            } else {
                jG2 = 0;
                jZ2 = 0;
            }
            if (jZ == 0 || jZ2 == 0) {
                return 0;
            }
            long j = jZ - jZ2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jG == 0 || jG2 == 0) {
                return 0;
            }
            return (int) (jG - jG2);
        }
        return gVar.gc() - gVar2.gc();
    }

    @Override // com.bytedance.sdk.component.gz.z.fo
    public void z() {
        gc gcVar = this.e;
        if (gcVar == null) {
            return;
        }
        z(gcVar.gc());
        g();
    }

    public dl gc() {
        return this.gc;
    }

    public void z(Handler handler) {
        this.m = handler;
    }

    public boolean z(String str) {
        try {
            if (this.gc != null || com.bytedance.sdk.component.gz.g.z.z(str) || this.e == null) {
                return false;
            }
            synchronized (this) {
                if (this.gc != null) {
                    return false;
                }
                this.gc = new dl(this.e, this);
                this.gc.m();
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl(th.getMessage(), this.e);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.fo
    public void z(com.bytedance.sdk.component.gz.z.g gVar) {
        gc gcVar;
        if (gVar == null || (gcVar = this.e) == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.a("error : log config is null", this.e);
            return;
        }
        String strGc = gcVar.gc();
        gVar.z(System.currentTimeMillis());
        z(strGc);
        a aVarA = this.e.a();
        dl dlVar = this.gc;
        if (dlVar != null) {
            z(aVarA, gVar);
            dlVar.z(gVar, gVar.gc() == 4);
        }
    }

    private void z(final a aVar, com.bytedance.sdk.component.gz.z.g gVar) {
        if (aVar != null) {
            try {
                if (aVar.dl()) {
                    final long jG = (gVar == null || gVar.z() == null) ? 0L : gVar.z().g();
                    if (jG == 1) {
                        f739a = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongP = z.p();
                    com.bytedance.sdk.component.gz.g.dl.g.z(atomicLongP, 1, this.e);
                    if (atomicLongP.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorGz = aVar.gz();
                            if (executorGz == null) {
                                executorGz = aVar.fo();
                            }
                            if (executorGz != null) {
                                executorGz.execute(new com.bytedance.sdk.component.gz.g.gc.g("report") { // from class: com.bytedance.sdk.component.gz.g.g.g.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        g.this.z(aVar, jG);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z(aVar, jG);
                    }
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(a aVar, long j) {
        dl dlVar = this.gc;
        if (aVar == null || dlVar == null) {
            return;
        }
        com.bytedance.sdk.component.gz.g.g.z.z zVar = z;
        dlVar.z(aVar.z(zVar.z(j, this.e)), true);
        zVar.m();
    }

    @Override // com.bytedance.sdk.component.gz.z.fo
    public void g() {
        gc gcVar = this.e;
        if (gcVar == null || gcVar.a() == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.g("discard flush config is null", gcVar);
            return;
        }
        com.bytedance.sdk.component.gz.g.dl.dl.g("flushMemoryAndDB", gcVar);
        a aVarA = gcVar.a();
        final dl dlVar = this.gc;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (dlVar != null) {
                dlVar.z(72, "start_child2");
                return;
            }
            return;
        }
        Executor executorGz = aVarA.gz();
        if (executorGz == null) {
            executorGz = aVarA.fo();
        }
        if (executorGz == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.g("discard flush executor is null", gcVar);
        } else {
            executorGz.execute(new com.bytedance.sdk.component.gz.g.gc.g("flush") { // from class: com.bytedance.sdk.component.gz.g.g.g.3
                @Override // java.lang.Runnable
                public void run() {
                    dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(72, "start_child1");
                    }
                }
            });
        }
    }
}
