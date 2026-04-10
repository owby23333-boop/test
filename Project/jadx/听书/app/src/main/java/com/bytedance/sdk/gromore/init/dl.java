package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.msdk.api.a.gz;
import com.bytedance.msdk.api.a.wp;
import com.bytedance.msdk.api.a.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f869a;
    private static volatile SparseArray<Object> dl;
    private static volatile AtomicBoolean g = new AtomicBoolean(false);
    private static volatile boolean z;
    private long e;
    private com.bytedance.sdk.openadsdk.core.ti.dl gc;
    private com.bytedance.sdk.openadsdk.core.dl m;

    public void z(Context context, com.bytedance.sdk.gromore.z.g.z zVar, com.bytedance.sdk.openadsdk.core.ti.dl dlVar, long j, com.bytedance.sdk.openadsdk.core.dl dlVar2) {
        this.gc = dlVar;
        this.e = j;
        this.m = dlVar2;
        if (zVar != null) {
            com.bytedance.msdk.core.z.kb().dl(zVar.gc());
            if (com.bytedance.msdk.core.z.kb().tb()) {
                com.bytedance.msdk.gz.a.gc.z(zVar);
            }
            com.bytedance.msdk.z.gc.dl.g("TMe", "init csjm " + z);
            if (!z) {
                com.bytedance.msdk.z.gc.dl.g("TMe", "init csjm ");
                z = true;
                g.set(false);
                com.bytedance.msdk.core.kb.z.z().g();
                com.bytedance.msdk.core.kb.z.z().z(new com.bytedance.msdk.core.kb.g() { // from class: com.bytedance.sdk.gromore.init.dl.1
                    @Override // com.bytedance.msdk.core.kb.g
                    public void z() {
                        com.bytedance.msdk.core.kb.z.z().z((com.bytedance.msdk.core.kb.g) null);
                        dl.this.g();
                    }

                    @Override // com.bytedance.msdk.core.kb.g
                    public void z(int i, String str) {
                        com.bytedance.msdk.core.kb.z.z().z((com.bytedance.msdk.core.kb.g) null);
                        dl.this.z(i, str);
                    }
                });
                com.bytedance.msdk.api.a.uy.z(context, z(zVar));
                com.bytedance.msdk.api.a.uy.a();
                return;
            }
            com.bytedance.msdk.z.gc.dl.g("TMe", "init csjm already");
            if (dlVar != null && dl != null) {
                dlVar.z(0, dl);
                return;
            } else {
                com.bytedance.msdk.z.gc.dl.g("TMe", "sdk正在初始化....");
                return;
            }
        }
        com.bytedance.msdk.z.gc.dl.g("TMe", "init csjm configValueSet is null");
    }

    public boolean z() {
        return f869a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        if (!g.get()) {
            g.set(true);
            g(i, str);
        } else {
            com.bytedance.msdk.z.gc.dl.g("TMe", "通知成功或失败了不在通知");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!g.get()) {
            g.set(true);
            com.bytedance.msdk.z.gc.dl.g("TMe", "通知成功=----notifySdkSuccess");
            com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.sdk.gromore.init.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.dl();
                }
            });
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TMe", "通知成功或失败了不在通知");
    }

    private void g(int i, String str) {
        if (i == 40004) {
            com.bytedance.msdk.z.gc.dl.g("TMe", "sdk init call code is 40004 callback success");
            dl();
        } else if (this.gc != null) {
            gc.gc = SystemClock.elapsedRealtime();
            com.bytedance.msdk.z.gc.dl.g("TMe", "sdk init call callback fail");
            dl = com.bytedance.sdk.openadsdk.ls.gc.z().z(false).z(i).z(str).g();
            this.gc.z(0, dl);
            com.bytedance.msdk.m.a.dl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        if (this.gc != null) {
            f869a = true;
            gc.gc = SystemClock.elapsedRealtime();
            if (this.e != 0) {
                gc.e = SystemClock.elapsedRealtime() - this.e;
            }
            com.bytedance.msdk.z.gc.dl.g("TMe", "sdk init call callback success");
            com.bytedance.sdk.openadsdk.ls.gc gcVarZ = com.bytedance.sdk.openadsdk.ls.gc.z().z(true);
            if (this.m != null) {
                com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
                aVarZ.z(23, this.m.dl());
                gcVarZ.z(aVarZ.g());
            }
            dl = gcVarZ.g();
            this.gc.z(0, dl);
            com.bytedance.msdk.m.a.dl();
        }
    }

    private com.bytedance.msdk.api.a.z z(com.bytedance.sdk.gromore.z.g.z zVar) {
        return new z.C0067z().z(zVar.gc()).g(zVar.m()).z(zVar.a()).dl(zVar.pf()).g(zVar.ls()).z(g.z(zVar.p())).z(zVar.fv()).z(zVar.v()).dl(zVar.js()).z(zVar.tb()).a(zVar.wp()).z(new wp.z().z(zVar.e()).g(zVar.gz()).z(zVar.fo()).z(zVar.uy()).g(zVar.kb()).z(zVar.i()).z(g.z(zVar.fv())).z()).z(new gz.z().z(zVar.iq()).z(zVar.q()).g(zVar.zw()).dl(zVar.io()).z()).z(zVar.g()).z();
    }
}
