package com.bytedance.sdk.component.adexpress.z.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.z.dl.z;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends dl {
    private static volatile gc g;
    private static File z;
    private AtomicBoolean dl = new AtomicBoolean(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f620a = new AtomicBoolean(false);
    private boolean gc = false;
    private AtomicBoolean m = new AtomicBoolean(false);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicLong gz = new AtomicLong();

    public static gc g() {
        if (g == null) {
            synchronized (gc.class) {
                if (g == null) {
                    g = new gc();
                }
            }
        }
        return g;
    }

    private gc() {
        gz();
    }

    private void gz() {
        com.bytedance.sdk.component.adexpress.a.gc.g(new fo("init") { // from class: com.bytedance.sdk.component.adexpress.z.g.gc.1
            @Override // java.lang.Runnable
            public void run() {
                gz.z();
                gc.this.dl.set(false);
                gc.this.dl();
                gc.this.m();
                if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() == null || !p.z(com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.z.z.z.z().dl().g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.z.g.gc.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null) {
                            com.bytedance.sdk.component.adexpress.z.z.z.z();
                        }
                    }
                });
            }
        }, 10);
    }

    public void dl() {
        com.bytedance.sdk.component.adexpress.z.dl.z zVarG = gz.g();
        if (zVarG == null || !zVarG.m()) {
            return;
        }
        boolean z2 = z(zVarG);
        if (!z2) {
            gz.a();
        }
        this.gc = z2;
    }

    public boolean z(com.bytedance.sdk.component.adexpress.z.dl.z zVar) {
        if (zVar == null) {
            return false;
        }
        return z(zVar.z()) || z(zVar.gc()) || z(zVar.getResources());
    }

    public boolean a() {
        return this.gc;
    }

    public com.bytedance.sdk.component.adexpress.z.dl.z gc() {
        return gz.g();
    }

    @Override // com.bytedance.sdk.component.adexpress.z.g.dl
    public File z() {
        return e();
    }

    public void m() {
        z(false);
    }

    public void z(boolean z2) {
        List<z.C0124z> listZ;
        boolean z3;
        if (this.dl.get()) {
            return;
        }
        try {
            if (this.f620a.get()) {
                if (z2) {
                    this.e.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z4 = true;
            this.f620a.set(true);
            com.bytedance.sdk.component.adexpress.z.dl.z zVarDl = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().dl();
            com.bytedance.sdk.component.adexpress.z.dl.z zVarG = gz.g();
            if (zVarDl != null && zVarDl.m()) {
                if (!gz.g(zVarDl)) {
                    this.f620a.set(false);
                    this.gz.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null) {
                    com.bytedance.sdk.component.adexpress.z.z.z.z().dl().g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.z.g.gc.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.gc.gc.z().g();
                        }
                    });
                }
                gz.z(zVarDl);
                boolean z5 = (zVarDl.gc() == null || TextUtils.isEmpty(zVarDl.gc().z())) ? false : z(zVarDl.gc().z());
                if (zVarDl.z().size() != 0) {
                    listZ = z(zVarDl, zVarG);
                    z3 = listZ != null;
                } else {
                    listZ = null;
                    z3 = z5;
                }
                if (!z5) {
                    List<z.C0124z> listG = g(zVarDl, zVarG);
                    if (listZ == null || listG == null) {
                        listZ = listG;
                    } else {
                        listZ.addAll(listG);
                    }
                    if (listG == null) {
                        z4 = false;
                    }
                    if (listG == null) {
                        this.f620a.set(false);
                    }
                    z3 = z4;
                }
                if (z3 && z(zVarDl)) {
                    gz.z(zVarDl);
                    gz.dl();
                    g(listZ);
                }
                dl();
                this.f620a.set(false);
                this.gz.set(System.currentTimeMillis());
                fo();
                return;
            }
            this.f620a.set(false);
            z(109);
        } catch (Throwable unused) {
        }
    }

    private void fo() {
        if (this.e.getAndSet(0) <= 0 || System.currentTimeMillis() - this.gz.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
            return;
        }
        m();
    }

    public static File e() {
        if (z == null) {
            try {
                File file = new File(new File(a.z(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                z = file;
            } catch (Throwable th) {
                wp.dl("TemplateManager", "getTemplateDir error", th);
            }
        }
        return z;
    }
}
