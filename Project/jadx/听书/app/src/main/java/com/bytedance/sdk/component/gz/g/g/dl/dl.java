package com.bytedance.sdk.component.gz.g.g.dl;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends gc implements Handler.Callback {
    private static int ls = 200;
    private static int pf = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f734a;
    private int e;
    private final long fo;
    private final String fv;
    private m gc;
    private final AtomicInteger gz;
    private final List<com.bytedance.sdk.component.gz.z.g> i;
    private com.bytedance.sdk.component.gz.g.z.g iq;
    private volatile int js;
    private volatile Handler kb;
    private final int m;
    private final String p;
    private final HashMap<String, List<com.bytedance.sdk.component.gz.z.g>> q;
    private volatile String tb;
    private final long uy;
    private volatile boolean v;
    private final List<com.bytedance.sdk.component.gz.z.g> wp;
    protected com.bytedance.sdk.component.gz.g.z.gc z;

    public dl(com.bytedance.sdk.component.gz.z.gc gcVar, com.bytedance.sdk.component.gz.g.g.g gVar) {
        super(gcVar, gVar);
        this.f734a = new Object();
        this.m = 50;
        this.e = 30;
        this.gz = new AtomicInteger(0);
        this.fo = 5000L;
        this.uy = 5000000000L;
        this.wp = new ArrayList();
        this.i = new CopyOnWriteArrayList();
        this.v = false;
        this.p = "after_upload";
        this.fv = "prepare_upload";
        this.js = 0;
        this.tb = "DEFAULT";
        this.q = new HashMap<>();
        this.z = new com.bytedance.sdk.component.gz.g.z.dl(gcVar, this);
        this.gc = new m(this.g, this.dl);
    }

    public com.bytedance.sdk.component.gz.g.z.gc z() {
        return this.z;
    }

    public Handler g() {
        return this.kb;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            boolean z = this.g.a().z(this.g.getContext());
            if (i == 1) {
                synchronized (dl.class) {
                    if (!this.i.isEmpty()) {
                        int size = this.i.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            z(this.i.get(i2), 1, z);
                        }
                    }
                    this.v = true;
                    this.i.clear();
                }
            } else if (i == 3) {
                g(3, z);
            } else if (i == 5) {
                ArrayList arrayList = new ArrayList(this.wp);
                this.wp.clear();
                z(arrayList, false, "timeout_dispatch", 5);
            } else if (i == 74) {
                z((com.bytedance.sdk.component.gz.z.g) message.obj, 74, z);
            } else if (i == 71) {
                z(71, z);
            } else if (i == 72) {
                z(72, z);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_ms", "error:" + th.getMessage(), this.g);
        }
        return true;
    }

    private void z(int i, boolean z) {
        g((com.bytedance.sdk.component.gz.z.g) null, i, z);
    }

    private void g(int i, boolean z) {
        g((com.bytedance.sdk.component.gz.z.g) null, i, z);
    }

    @Override // com.bytedance.sdk.component.gz.g.g.dl.gc
    public void dl() {
        super.dl();
        this.kb = new Handler(e(), this);
        this.dl.z(this.kb);
        this.kb.sendEmptyMessage(1);
    }

    public boolean z(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        if (this.g == null) {
            return false;
        }
        return this.z.z(i, str, gVar);
    }

    public void z(com.bytedance.sdk.component.gz.z.g gVar, boolean z) {
        if (gVar == null) {
            return;
        }
        if (z) {
            if (this.kb != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(gVar);
                z(arrayList, true, "ignore_result_dispatch", -1);
                return;
            }
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "other thread handler is null，ignore is true", this.g);
            return;
        }
        if (this.v) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = gVar;
            messageObtain.what = 74;
            this.kb.sendMessage(messageObtain);
            return;
        }
        this.i.add(gVar);
    }

    public void z(int i, String str) {
        try {
            if (!this.g.a().z(this.g.getContext())) {
                com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "AdThread NET IS NOT AVAILABLE", this.g);
                return;
            }
            boolean z = z(i, str + " check", (com.bytedance.sdk.component.gz.z.g) null);
            com.bytedance.sdk.component.gz.g.dl.dl.g("_flush", "notify runOnce check: ".concat(String.valueOf(z)), this.g);
            if (z) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.kb.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl(th.getMessage(), this.g);
        }
    }

    private void z(com.bytedance.sdk.component.gz.z.g gVar, int i, boolean z) {
        try {
            z(gVar);
            g(gVar, i, z);
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "run exception:" + th.getMessage(), this.g);
            com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.dl(), 1, this.g);
        }
    }

    private void z(com.bytedance.sdk.component.gz.z.g gVar) {
        this.gz.set(0);
        com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.kb(), 1, this.g);
        this.z.z(gVar);
        com.bytedance.sdk.component.gz.g.dl.z.z(gVar, this.g, "_ad");
        com.bytedance.sdk.component.gz.g.dl.z.gz(gVar, this.g);
    }

    private boolean g(com.bytedance.sdk.component.gz.z.g gVar, boolean z) {
        return com.bytedance.sdk.component.gz.g.dl.z.z(this.g) && this.g.dl();
    }

    public boolean a() {
        return com.bytedance.sdk.component.gz.g.dl.z.z(this.g) && this.dl.dl();
    }

    private void g(com.bytedance.sdk.component.gz.z.g gVar, int i, boolean z) {
        if (g(gVar, z)) {
            com.bytedance.sdk.component.gz.g.dl.dl.z("_error", " upload cancel cause config " + com.bytedance.sdk.component.gz.g.dl.z.dl(gVar, this.g), this.g);
            return;
        }
        boolean zA = a();
        boolean z2 = false;
        boolean z3 = com.bytedance.sdk.component.gz.g.dl.z.fo(gVar, this.g) || i == 3;
        boolean z4 = com.bytedance.sdk.component.gz.g.dl.z.z(i);
        com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "serbusy:" + zA + " isCsjBusy:" + z3 + " flush:" + z4, this.g);
        if (zA && !z4 && z3) {
            if (i == 3) {
                com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "start do flush", this.g);
                z(72, z);
                return;
            } else {
                if (i == 74 || i == 1) {
                    boolean zHasMessages = this.kb.hasMessages(3);
                    com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)), this.g);
                    if (zHasMessages) {
                        return;
                    }
                    this.gc.z(3, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, this.kb);
                    return;
                }
                com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "server busy", this.g);
                return;
            }
        }
        if (!z) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "AdThread NET IS NOT AVAILABLE!!!", this.g);
            return;
        }
        boolean z5 = z(i, "needUpload check", gVar);
        if (z5) {
            List<com.bytedance.sdk.component.gz.z.g> listZ = this.z.z(i, gVar, zA, this.js + "_" + this.tb);
            if (listZ != null && listZ.size() != 0) {
                com.bytedance.sdk.component.gz.g.dl.dl.g("_ms", "prepare get size =" + listZ.size(), this.g);
                z(listZ, i);
            } else {
                com.bytedance.sdk.component.gz.g.dl.dl.g("_ms", "prepare get no event need upload", this.g);
                z("prepare_upload");
                com.bytedance.sdk.component.gz.g.dl.dl.z("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.g);
            }
        } else {
            com.bytedance.sdk.component.gz.g.dl.dl.g("_ms", "prepare upload no need", this.g);
            this.q.clear();
            z("prepare_upload");
        }
        z2 = z5;
        com.bytedance.sdk.component.gz.g.dl.dl.z("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)), this.g);
    }

    private void z(String str) {
        if (this.wp.size() != 0) {
            com.bytedance.sdk.component.gz.z.a aVarA = this.g.a();
            if (this.kb.hasMessages(5)) {
                this.kb.removeMessages(5);
            }
            long jDl = ls;
            if (aVarA != null && aVarA.wp() != null) {
                jDl = aVarA.wp().dl();
            }
            this.kb.sendEmptyMessageDelayed(5, jDl);
            this.wp.size();
            return;
        }
        com.bytedance.sdk.component.gz.g.dl.dl.z("_ms", "do nothing", this.g);
    }

    private void z(List<com.bytedance.sdk.component.gz.z.g> list, String str, int i) {
        z(list, false, str, i);
    }

    private void z(List<com.bytedance.sdk.component.gz.z.g> list, int i) {
        com.bytedance.sdk.component.gz.g.dl.z.z(list, this.g);
        com.bytedance.sdk.component.gz.z.g gVar = list.get(0);
        if (gVar == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "adLogEvent is null", this.g);
            return;
        }
        if (list.size() > 1 || com.bytedance.sdk.component.gz.g.dl.z.g(this.g) || com.bytedance.sdk.component.gz.g.dl.z.a(this.g)) {
            if (gVar.a() == 0 && gVar.gc() == 2 && i == 74) {
                if (gVar.g() == 3) {
                    z(list, "version_v3_batch", i);
                    return;
                } else {
                    g(list, "batchOptimize", i);
                    return;
                }
            }
            z(list, "batchRead", i);
            return;
        }
        if (gVar.gc() == 1) {
            z(list, "highPriority", i);
            return;
        }
        if (gVar.a() == 0 && gVar.gc() == 2) {
            if (gVar.g() == 3) {
                z(list, "version_v3_single_directly", i);
                return;
            } else {
                g(list, "singleOptimize", i);
                return;
            }
        }
        if (gVar.a() == 1) {
            z(list, "stats_directly", i);
            return;
        }
        if (gVar.a() == 3) {
            z(list, "adType_v3_directly", i);
        } else if (gVar.a() == 2) {
            z(list, "other_directly", i);
        } else {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "adLogEvent adType error", this.g);
        }
    }

    private void g(List<com.bytedance.sdk.component.gz.z.g> list, String str, int i) {
        this.wp.addAll(list);
        com.bytedance.sdk.component.gz.z.a aVarA = this.g.a();
        if (aVarA != null && aVarA.wp() != null) {
            pf = aVarA.wp().a();
        }
        if (this.wp.size() >= pf) {
            if (this.kb.hasMessages(5)) {
                this.kb.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.wp);
            this.wp.clear();
            z(arrayList, false, "max_size_dispatch", i);
            return;
        }
        z(str);
    }

    private void z(List<com.bytedance.sdk.component.gz.z.g> list, boolean z, String str, int i) {
        this.gc.z(list, z, str, i, this.f734a, this.iq);
        if (z) {
            return;
        }
        z(i);
    }

    private void z(int i) {
        long jNanoTime;
        z("after_upload");
        com.bytedance.sdk.component.gz.g.dl.z.g(i);
        if (i == 72) {
            synchronized (this.f734a) {
                try {
                    try {
                        long jNanoTime2 = System.nanoTime();
                        this.f734a.wait(5000L);
                        jNanoTime = System.nanoTime() - jNanoTime2;
                    } catch (InterruptedException e) {
                        com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "wait exception:" + e.getMessage(), this.g);
                    }
                    if (jNanoTime < 5000000000L && 5000000000L - jNanoTime >= 50000000) {
                        if (a()) {
                            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "return wait serverBusy", this.g);
                            return;
                        }
                        if (this.dl.a()) {
                            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "return wait otherError", this.g);
                            return;
                        }
                        com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.g(), 1, this.g);
                        int i2 = this.e + 1;
                        this.e = i2;
                        if (i2 < 50) {
                            com.bytedance.sdk.component.gz.g.dl.dl.g("_flush", "afterUpload send flush again:" + this.e, this.g);
                            z(72, "continue");
                        } else {
                            this.e = 0;
                            if (this.kb.hasMessages(72)) {
                                this.kb.removeMessages(72);
                            }
                            com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "afterUpload send flush end:" + this.e, this.g);
                        }
                        return;
                    }
                    com.bytedance.sdk.component.gz.g.dl.dl.dl("_error", "return wait timeout", this.g);
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.e = 0;
        if (this.kb.hasMessages(72)) {
            this.kb.removeMessages(72);
        }
    }
}
