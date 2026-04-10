package com.bytedance.sdk.component.gz.g.g.dl;

import android.os.Handler;
import com.bytedance.sdk.component.gz.z.uy;
import com.bytedance.sdk.component.utils.wp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private dl dl;
    private final com.bytedance.sdk.component.gz.z.gc gc;
    private final com.bytedance.sdk.component.gz.g.g.g m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f736a = 0;
    public final AtomicInteger z = new AtomicInteger(0);
    public final AtomicInteger g = new AtomicInteger(0);

    public m(com.bytedance.sdk.component.gz.z.gc gcVar, com.bytedance.sdk.component.gz.g.g.g gVar) {
        this.gc = gcVar;
        this.m = gVar;
    }

    public void z(List<com.bytedance.sdk.component.gz.z.g> list, boolean z, String str, int i, Object obj, com.bytedance.sdk.component.gz.g.z.g gVar) {
        this.dl = this.m.gc();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.gz.g.dl.z.z(list, i, str, this.gc);
        if (this.gc.uy() != null) {
            z(list, z, jCurrentTimeMillis, obj, i);
        } else {
            com.bytedance.sdk.component.gz.g.dl.z.z(list, str, gVar);
            z(list, z, jCurrentTimeMillis, i, obj);
        }
    }

    private void z(final List<com.bytedance.sdk.component.gz.z.g> list, final boolean z, final long j, final int i, final Object obj) {
        com.bytedance.sdk.component.gz.z.a aVarA = this.gc.a();
        if (aVarA != null) {
            Executor executorFo = aVarA.fo();
            if (list.get(0).gc() == 1) {
                executorFo = aVarA.gz();
            }
            Executor executor = executorFo;
            if (executor == null) {
                return;
            }
            this.g.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.gz.g.gc.g("csj_log_upload") { // from class: com.bytedance.sdk.component.gz.g.g.dl.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.g(list, z, j, i, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<com.bytedance.sdk.component.gz.z.g> list, boolean z, long j, int i, Object obj) {
        g gVarZ;
        try {
            com.bytedance.sdk.component.gz.z.g gVar = list.get(0);
            com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.tb(), 1, this.gc);
            if (gVar.a() == 0) {
                gVarZ = com.bytedance.sdk.component.gz.g.g.m().z(list);
                z(gVarZ, list);
                if (gVarZ != null) {
                    com.bytedance.sdk.component.gz.g.dl.z.z(list, gVarZ.f735a, this.gc);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().e());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "json exception:" + e.getMessage(), this.gc);
                }
                gVarZ = com.bytedance.sdk.component.gz.g.g.m().z(jSONObject);
            }
            g gVar2 = gVarZ;
            this.g.decrementAndGet();
            z(z, gVar2, list, j, obj, i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "inner exception:" + th.getMessage(), this.gc);
            com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.dl(), 1, this.gc);
            this.g.decrementAndGet();
        }
    }

    private void z(g gVar, List<com.bytedance.sdk.component.gz.z.g> list) {
        if (gVar == null || !gVar.z) {
            return;
        }
        List<com.bytedance.sdk.component.gz.z.dl> listZ = com.bytedance.sdk.component.gz.g.z.z();
        if (list == null || listZ == null || listZ.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.gz.z.g gVar2 : list) {
            if (gVar2.gc() == 1) {
                String strZ = com.bytedance.sdk.component.gz.g.dl.z.z(gVar2, this.gc);
                String strM = com.bytedance.sdk.component.gz.g.dl.z.m(gVar2, this.gc);
                for (com.bytedance.sdk.component.gz.z.dl dlVar : listZ) {
                    if (dlVar != null) {
                        dlVar.z(strZ, strM);
                    }
                }
            }
        }
    }

    private void z(List<com.bytedance.sdk.component.gz.z.g> list, final boolean z, final long j, final Object obj, final int i) {
        this.g.incrementAndGet();
        com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.tb(), 1, this.gc);
        try {
            this.gc.uy().z(list, new uy() { // from class: com.bytedance.sdk.component.gz.g.g.dl.m.2
                @Override // com.bytedance.sdk.component.gz.z.uy
                public void z(List<z> list2) {
                    try {
                        m.this.g.decrementAndGet();
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        int size = list2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            z zVar = list2.get(i2);
                            if (zVar != null) {
                                m.this.z(z, zVar.z(), zVar.g(), j, obj, i);
                            }
                        }
                    } catch (Exception e) {
                        wp.z(e);
                    }
                }
            });
        } catch (Exception e) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "outer exception：" + e.getMessage(), this.gc);
            com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.dl(), 1, this.gc);
            this.g.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, g gVar, List<com.bytedance.sdk.component.gz.z.g> list, long j, Object obj, int i) {
        if (z) {
            return;
        }
        if (gVar != null) {
            int i2 = gVar.g;
            if (gVar.gc) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            int i3 = (gVar.z || ((i2 < 500 || i2 >= 509) && i2 <= 513)) ? i2 : -2;
            if (list != null) {
                list.size();
                this.g.get();
            }
            z(i3, list, j, obj, i, gVar);
            return;
        }
        z(-1, list, j, obj, i, (g) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00c0, B:36:0x00c3, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b5, B:38:0x00c5), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(int r9, java.util.List<com.bytedance.sdk.component.gz.z.g> r10, long r11, java.lang.Object r13, int r14, com.bytedance.sdk.component.gz.g.g.dl.g r15) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gz.g.g.dl.m.z(int, java.util.List, long, java.lang.Object, int, com.bytedance.sdk.component.gz.g.g.dl.g):void");
    }

    private void z(Handler handler, List<com.bytedance.sdk.component.gz.z.g> list, dl dlVar) {
        boolean zA = dlVar.a();
        boolean zG = com.bytedance.sdk.component.gz.g.dl.z.g(list, this.gc);
        if (zA && zG) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.z.set(0);
            this.f736a = 0L;
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_flush", "send reset busy", this.gc);
            com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.a(), 1, this.gc);
            dlVar.z(72, "handle_result");
        }
    }

    public void z(int i, long j, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "mHandler == null", this.gc);
            return;
        }
        if (i == 3) {
            if (handler.hasMessages(i)) {
                handler.removeMessages(i);
            }
            int iIncrementAndGet = this.z.incrementAndGet();
            long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "sendBusyMsg:" + i + "  retryCount:" + iIncrementAndGet + " delayTime:" + (j2 / 1000), this.gc);
            handler.sendEmptyMessageDelayed(i, j2);
            return;
        }
        com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "sendBusyMsg error state", this.gc);
    }
}
