package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.lw;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.iq.yx;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements l.z {
    private j dl;
    private int e;
    private com.bytedance.sdk.openadsdk.core.component.splash.z.z fo;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz fv;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g g;
    private Context gc;
    private int gz;
    private long i;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a io;
    private lw iq;
    private com.bytedance.sdk.openadsdk.ls.dl.g.g js;
    private long kb;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m ls;
    private final l m;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc na;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m p;
    private long pf;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo q;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo tb;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a uf;
    private z uy;
    private long v;
    private long wp;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e xl;
    private lw zw;
    private int z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.tb.z.g.z.z f1012a = null;
    private final AtomicBoolean sy = new AtomicBoolean(false);
    private final AtomicBoolean hh = new AtomicBoolean(false);
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean gk = new AtomicBoolean(false);
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicInteger lq = new AtomicInteger(0);
    private final AtomicBoolean mc = new AtomicBoolean(false);
    private final AtomicBoolean un = new AtomicBoolean(false);
    private final AtomicBoolean ti = new AtomicBoolean(false);
    private final AtomicBoolean eo = new AtomicBoolean(false);
    private final AtomicInteger oq = new AtomicInteger(0);
    private boolean wj = false;
    private final g j = new g();

    private gc(Context context) {
        if (context != null) {
            this.gc = context.getApplicationContext();
        } else {
            this.gc = zw.getContext();
        }
        this.m = new l(Looper.getMainLooper(), this);
        this.uy = new z();
        uy.ls().gz(false);
        kb();
    }

    public static gc z(Context context) {
        return new gc(context);
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar, int i) {
        this.f1012a = zVar;
        z(gVar, i);
    }

    private void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, int i) {
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "加载开屏广告--begin ");
        this.kb = System.currentTimeMillis();
        this.dl = g(gVar);
        this.g = gVar;
        this.e = eo.g(gVar);
        this.fo = com.bytedance.sdk.openadsdk.core.component.splash.z.z.z();
        int iZ = this.j.z(this.e);
        this.z = iZ;
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "当前rit位 " + this.e);
        int iM = zw.g().m(gVar.a());
        z(gVar.a(), iM, i);
        long j = i;
        this.dl.fo = j;
        this.dl.uy = iM;
        this.dl.kb = this.gz;
        m.z(gVar, j);
        g();
        z(gVar, this.dl, iZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i) {
        if (gVar == null) {
            return;
        }
        m.z(this.iq, this.zw, jVar, this.z, i);
        z(gVar, jVar, this.uy);
    }

    private void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, final z zVar) {
        if (zVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.z.gc gcVar = new com.bytedance.sdk.openadsdk.core.component.splash.z.gc();
        gcVar.z = this.j.g;
        com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc gcVar2 = new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc(new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gc(gVar, jVar, gcVar), new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                if (mVar == null || mVar.g() == null) {
                    zVar.z(new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e(1, "no ad model", false));
                    return;
                }
                na naVarG = mVar.g();
                if (mVar.gc()) {
                    gc.this.oq.set(1);
                    gc.this.p = mVar;
                    if (!gc.this.wp()) {
                        gc.this.wj = true;
                    }
                } else {
                    gc.this.ls = mVar;
                    gc.this.wj = false;
                }
                if (gc.this.sy.get() || gc.this.uy.dl() || gc.this.lq.get() > 0) {
                    gc.this.z(mVar, mVar.gc(), true);
                    return;
                }
                gc.this.z(mVar);
                if (gc.this.g(naVarG, mVar.gc())) {
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "开始并发加载素材 ");
                    gc.this.g(mVar, zVar);
                } else {
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "开始串行加载素材 getReqId " + mVar.g().aq());
                    gc.this.z(mVar, zVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
            public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
                if (gc.this.z == 1 && gc.this.j.dl == 2) {
                    gc.this.z = 2;
                    gc gcVar3 = gc.this;
                    gcVar3.z(gVar, gcVar3.dl, gc.this.z);
                    return;
                }
                boolean zGz = eVar.gz();
                if (zGz) {
                    gc.this.oq.set(-1);
                }
                if (!gc.this.dl(zGz)) {
                    gc.this.xl = eVar;
                    if (gc.this.wp()) {
                        if (gc.this.oq.get() != -1) {
                            if (gc.this.oq.get() == 1) {
                                gc.this.gc();
                            }
                        } else {
                            zVar.z(eVar);
                        }
                        gc.this.eo.set(true);
                        return;
                    }
                    zVar.z(eVar);
                    return;
                }
                if (gc.this.eo.get()) {
                    zVar.z(gc.this.xl);
                }
            }
        }, this.fo, this.j);
        this.na = gcVar2;
        gcVar2.z(this.z);
    }

    private void g() {
        this.sy.set(false);
        this.hh.set(false);
        this.l.set(false);
        this.h.set(false);
        this.mc.set(false);
        this.un.set(false);
        this.gk.set(false);
        this.x.set(false);
        this.ti.set(false);
        this.eo.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        int i;
        if (com.bytedance.sdk.openadsdk.core.component.splash.z.z.z(this.z) && ((i = this.z) == 1 || i == 3)) {
            return;
        }
        a();
    }

    private void a() {
        com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar = this.fo;
        if (zVar != null) {
            zVar.g(this.g, this.dl);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what == 2) {
            z zVar = this.uy;
            if (zVar != null) {
                zVar.z();
            }
            l lVar = this.m;
            if (lVar != null) {
                lVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        int iOptInt;
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar = this.p;
        if (mVar != null && mVar.g() != null && this.p.g().gl() != null && (iOptInt = this.p.g().gl().optInt("real_drop_cache_type", 0)) == 1) {
            com.bytedance.sdk.openadsdk.core.e.z.z("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + iOptInt);
            m();
        } else if (this.j.z()) {
            com.bytedance.sdk.openadsdk.core.e.z.z("SplashLoadManager", "loadCacheWhenRealAdDrop - 计分模式下允许兜底缓存： ");
            m();
        } else {
            z zVar = this.uy;
            if (zVar != null) {
                zVar.z(this.xl);
            }
        }
    }

    private void m() {
        l lVar = this.m;
        if (lVar != null) {
            lVar.removeMessages(4);
        }
        z zVar = this.uy;
        if (zVar != null) {
            zVar.g();
        }
    }

    private boolean z(na naVar, boolean z2) {
        return (naVar == null || z2 || naVar.yz() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(na naVar) {
        return (naVar != null ? naVar.yz() : 0) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public na z(boolean z2) {
        if (z2) {
            com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar = this.p;
            if (mVar == null) {
                return null;
            }
            return mVar.g();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar2 = this.ls;
        if (mVar2 == null) {
            return null;
        }
        return mVar2.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.uy.z(this.fv);
        this.un.set(true);
        if (!this.h.get() || this.mc.get()) {
            return;
        }
        this.mc.set(true);
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.uy.z(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz() {
        if (this.uy == null) {
            return;
        }
        if (g(z(true), true)) {
            AtomicBoolean atomicBoolean = this.hh;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
            com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar = this.fv;
            if (gzVar != null) {
                gzVar.z(this.js);
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.4
                @Override // java.lang.Runnable
                public void run() {
                    m.a(gc.this.zw, jCurrentTimeMillis);
                    gc.this.e();
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.hh;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
        final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z zVarG = g(this.p, this.fv, this.uy);
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar2 = this.fv;
        if (gzVar2 != null) {
            gzVar2.z(zVarG.z());
        }
        final long jCurrentTimeMillis2 = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.5
            @Override // java.lang.Runnable
            public void run() {
                m.a(gc.this.zw, jCurrentTimeMillis2);
                gc.this.uy.z(gc.this.fv);
                gc gcVar = gc.this;
                gcVar.z(gcVar.p, zVarG, gc.this.fv.gc());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        l lVar = this.m;
        if (lVar != null) {
            lVar.removeMessages(4);
        }
        l lVar2 = this.m;
        if (lVar2 != null) {
            lVar2.removeMessages(2);
        }
    }

    class z {
        private final AtomicBoolean g = new AtomicBoolean(false);

        z() {
        }

        private void a(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
            if (eVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.z.1
                @Override // java.lang.Runnable
                public void run() {
                    if (gc.this.f1012a != null) {
                        gc.this.f1012a.z(eVar.fo(), new com.bytedance.sdk.openadsdk.ls.dl.dl(eVar.a(), eVar.gc()));
                        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "onSplashRenderFail回调 true " + eVar.a());
                    }
                }
            });
            gc.this.dl();
        }

        public void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
            if (eVar == null) {
                return;
            }
            gc.this.fo();
            if (this.g.get()) {
                return;
            }
            this.g.set(true);
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.z.2
                @Override // java.lang.Runnable
                public void run() {
                    if (gc.this.f1012a != null) {
                        if (eVar.a() == 22) {
                            eVar.g(1);
                        }
                        gc.this.f1012a.z(new com.bytedance.sdk.openadsdk.ls.dl.dl(eVar.a(), eVar.gc()));
                        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "onSplashLoadFail 回调");
                    }
                }
            });
            z(false, true, (Object) null);
            gc.this.dl();
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
            m.z(eVar.gz(), gc.this.z(eVar.gz()), gc.this.g, eVar);
        }

        public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
            if (this.g.get() || gzVar == null) {
                return;
            }
            lw lwVar = gzVar.kb() ? gc.this.zw : gc.this.iq;
            if (lwVar != null) {
                lwVar.m(gzVar.z());
                lwVar.fv(gzVar.v());
                lwVar.q(System.currentTimeMillis() - lwVar.io());
            }
            z(gc.this.f1012a, lwVar, gzVar.g(), gzVar.wp(), gzVar.kb(), gzVar.pf());
        }

        private void z(com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar, lw lwVar, na naVar, com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, boolean z, boolean z2) {
            if (zVar == null || lwVar == null || gc.this.lq.get() > 0) {
                return;
            }
            if (gc.this.z(naVar)) {
                gc gcVar = gc.this;
                m.z(z ? gcVar.zw : gcVar.iq, 2);
                gc.this.fo();
            }
            gc.this.ti.set(z);
            gc.this.lq.set(1);
            long jCurrentTimeMillis = System.currentTimeMillis();
            z(gVar, 1);
            zVar.z(gVar);
            gc.this.lq.set(2);
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
            z(z, false, (Object) gVar);
            lwVar.p(System.currentTimeMillis() - jCurrentTimeMillis);
            if (z2) {
                m.z(gc.this.gc, lwVar, naVar, z, jCurrentTimeMillis);
            }
        }

        public void g(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
            if (eVar == null) {
                return;
            }
            gc.this.fo();
            if (this.g.get()) {
                return;
            }
            this.g.set(true);
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.z.3
                @Override // java.lang.Runnable
                public void run() {
                    if (gc.this.f1012a != null) {
                        if (gc.this.lq.get() > 0) {
                            gc.this.f1012a.z(null, new com.bytedance.sdk.openadsdk.ls.dl.dl(1, "load splash material fail"));
                        } else {
                            gc.this.f1012a.z(new com.bytedance.sdk.openadsdk.ls.dl.dl(eVar.a(), eVar.gc()));
                        }
                    }
                }
            });
            gc.this.dl();
            com.bytedance.sdk.openadsdk.core.e.z.a("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + eVar.a());
            m.z(eVar.gz(), gc.this.z(eVar.gz()), gc.this.g, eVar);
        }

        public void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo foVar) {
            gc.this.fo();
            if (this.g.get()) {
                return;
            }
            this.g.set(true);
            boolean z = foVar != null && foVar.dl();
            gc.this.z(foVar);
            gc gcVar = gc.this;
            gcVar.z(z, z ? gcVar.zw : gcVar.iq);
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.z.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo foVar2;
                    if (gc.this.f1012a == null || (foVar2 = foVar) == null) {
                        return;
                    }
                    z.this.z(foVar2.z(), 2);
                    gc.this.f1012a.g(foVar.z());
                }
            });
        }

        public void dl(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
            gc.this.fo();
            if (this.g.get()) {
                return;
            }
            this.g.set(true);
            m.z(eVar.gz(), gc.this.z(eVar.gz()), gc.this.g, eVar);
            a(eVar);
            wp.a("SplashLoadManager", "渲染失败 code " + eVar.a() + " msg " + eVar.gc());
        }

        public void z() {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "onTimeOut start");
            gc.this.sy.set(true);
            if (this.g.get()) {
                return;
            }
            this.g.set(true);
            if (gc.this.na != null) {
                gc.this.na.z();
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "开屏超时");
            if (gc.this.f1012a != null) {
                if (gc.this.lq.get() > 0) {
                    gc.this.f1012a.z(null, new com.bytedance.sdk.openadsdk.ls.dl.dl(3, "load success but render fail"));
                } else {
                    gc.this.f1012a.z(new com.bytedance.sdk.openadsdk.ls.dl.dl(23, "load splash time out"));
                }
                com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "回调开屏超时 true");
                gc.this.dl();
            }
            boolean z = gc.this.wj;
            gc gcVar = gc.this;
            m.z(z, gcVar.z(gcVar.wj), gc.this.g, new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e(23, "load splash time out", gc.this.wj));
            boolean z2 = gc.this.wj;
            gc gcVar2 = gc.this;
            m.z(z2, gcVar2.z(gcVar2.wj), gc.this.g);
        }

        public void g() {
            if (this.g.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            gc.this.gz();
        }

        public boolean dl() {
            return this.g.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, int i) {
            if (gVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.a.z) {
                ((com.bytedance.sdk.openadsdk.core.component.splash.a.z) gVar).z(i);
            }
        }

        private void z(boolean z, boolean z2, Object obj) {
            na naVarZ = gc.this.z(true);
            if (gc.this.fo == null || naVarZ == null) {
                return;
            }
            String strAq = naVarZ.aq();
            gc.this.fo.z(gc.this.g.a(), strAq, z, z2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final boolean z2, final lw lwVar) {
        com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("preloadSplash") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.6
            @Override // java.lang.Runnable
            public void run() {
                if (gc.this.g(z2)) {
                    gc.this.uy();
                } else {
                    gc.this.dl();
                }
                lw lwVar2 = lwVar;
                boolean z3 = lwVar2 != null && lwVar2.un();
                lw lwVar3 = lwVar;
                boolean z4 = lwVar3 != null && lwVar3.lq();
                boolean z5 = z2;
                m.z(z5, gc.this.z(z5), gc.this.g, z3, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy() {
        if (com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.z(this.g, this.dl)) {
            return;
        }
        this.fo.z(new yx(this.ls.a(), this.ls.g(), null), this.g, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z2) {
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar;
        return (z2 || this.fo == null || (mVar = this.ls) == null || mVar.a() == null || this.ls.g() == null || !com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.ls.g())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
        boolean zGc = mVar.gc();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.kb;
        if (zGc) {
            m.z(this.zw);
            this.uf.z(vm.z(z(zGc)));
            this.uf.g(vm.g(z(zGc)));
            this.uf.z(j);
            this.i = jCurrentTimeMillis;
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j);
            return;
        }
        m.z(this.iq);
        this.io.z(vm.z(z(zGc)));
        this.io.g(vm.g(z(zGc)));
        this.io.z(j);
        this.wp = jCurrentTimeMillis;
        m.z(this.iq, mVar);
        com.bytedance.sdk.openadsdk.core.io.gc.z().dl().z(this.iq);
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "实时加载物料--end 耗时S1： " + j);
    }

    private void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, final z zVar) {
        if (gzVar != null && this.lq.get() <= 0) {
            final boolean zKb = gzVar.kb();
            final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z zVarG = g(mVar, gzVar, zVar);
            gzVar.z(zVarG.z());
            if (!dl(gzVar.kb())) {
                com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "不需要等待实时广告 isCacheAd " + zKb);
                if (z()) {
                    zVar.z(gzVar);
                    z(mVar, zVarG, gzVar.gc());
                    return;
                } else {
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.7
                        @Override // java.lang.Runnable
                        public void run() {
                            m.a(zKb ? gc.this.zw : gc.this.iq, jCurrentTimeMillis);
                            zVar.z(gzVar);
                            gc.this.z(mVar, zVarG, gzVar.gc());
                        }
                    });
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + zKb);
            this.fv = gzVar;
            this.js = zVarG.z();
            this.hh.set(true);
            if (this.eo.get()) {
                gc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, final z zVar) {
        if (mVar == null || zVar == null) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        m.dl(mVar.gc() ? this.zw : this.iq, System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar = new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g(mVar.g(), mVar.gc());
        gVar.z(mVar.a());
        gVar.z(mVar.gc());
        gVar.z(mVar.z());
        gVar.z(mVar.dl());
        new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.m(gVar, new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.8
            private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gc;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public void dl(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
                this.gc = gzVar;
                gc.this.z(gzVar, mVar, zVar, (com.bytedance.sdk.openadsdk.ls.dl.g.g) null, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
            public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar2 = this.gc;
                if (gzVar2 != null) {
                    gzVar2.gc(true);
                }
                gc.this.z(gzVar, mVar, zVar, (com.bytedance.sdk.openadsdk.ls.dl.g.g) null, jElapsedRealtime, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
            public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
                gc.this.z(mVar, eVar, zVar, jElapsedRealtime);
            }
        }).g();
        z(mVar.gc(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(boolean z2) {
        return z2 && wp();
    }

    private void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z zVar, boolean z2, final int i) {
        a(z2);
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z zVar2 = zVar;
                if (zVar2 == null) {
                    return;
                }
                zVar2.z(i);
                zVar.g();
            }
        });
    }

    private void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zKb = gzVar.kb();
        if (zKb) {
            m.z(this.zw, gzVar);
            m.z(this.zw, gzVar, j, z(zKb));
            m.z(z(zKb), this.zw, gzVar);
            z(zKb, gzVar, jCurrentTimeMillis - this.i);
            com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar2 = this.fv;
            if (gzVar2 != null) {
                gzVar2.gc(true);
            }
        } else {
            m.z(this.iq, gzVar);
            m.z(this.iq, gzVar, j, z(zKb));
            m.z(z(zKb), this.iq, gzVar);
            z(zKb, gzVar, jCurrentTimeMillis - this.wp);
        }
        g(gzVar, jCurrentTimeMillis);
        if (this.lq.get() <= 0 || this.sy.get()) {
            return;
        }
        if (this.ti.get()) {
            if (zKb) {
                m.z(this.gc, this.zw, gzVar.g(), true, jCurrentTimeMillis);
            }
        } else {
            if (zKb) {
                return;
            }
            m.z(this.gc, this.iq, gzVar.g(), false, jCurrentTimeMillis);
        }
    }

    private void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, long j) {
        if (gzVar.kb()) {
            if (this.x.get()) {
                return;
            }
            this.uf.g(j - this.i);
            this.zw.dl(gzVar.m());
            this.zw.g(gzVar.gc());
            return;
        }
        if (this.gk.get()) {
            return;
        }
        this.io.g(j - this.wp);
        this.iq.dl(gzVar.m());
        this.iq.g(gzVar.gc());
    }

    private void z(boolean z2, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, long j) {
        String str = z2 ? "缓存广告" : "实时广告";
        if (gzVar.gc()) {
            if (gzVar.uy()) {
                com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j);
                return;
            } else {
                com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j);
                return;
            }
        }
        if (gzVar.m()) {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j);
        } else {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, z zVar) {
        if (mVar == null || zVar == null) {
            return;
        }
        na naVarG = mVar.g();
        boolean zGc = mVar.gc();
        com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z zVarZ = z(mVar, new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz(naVarG, zGc), zVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar = new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g(naVarG, zGc);
        gVar.z(zGc);
        gVar.z(mVar.a());
        gVar.z(mVar.z());
        gVar.z(mVar.dl());
        com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.m mVarZ = z(mVar, zVar, zVarZ.z(), gVar, jElapsedRealtime);
        zVarZ.z(mVarZ);
        m.dl(zGc ? this.zw : this.iq, System.currentTimeMillis());
        mVarZ.g();
        int iDl = dl(naVarG);
        if (this.sy.get()) {
            return;
        }
        if (z(naVarG, gVar.a()) && this.m != null && iDl <= 0) {
            iDl = 0;
        }
        z(zGc, 1);
        z(zVarZ, zGc, iDl);
    }

    private void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, final z zVar, com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        if (gzVar != null && this.lq.get() <= 0) {
            final boolean zKb = gzVar.kb();
            if (!dl(zKb)) {
                com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.l.get());
                gzVar.z(gVar);
                if (z()) {
                    zVar.z(gzVar);
                    if (this.l.get()) {
                        zVar.z(this.tb);
                        return;
                    }
                    return;
                }
                final long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.10
                    @Override // java.lang.Runnable
                    public void run() {
                        m.a(zKb ? gc.this.zw : gc.this.iq, jCurrentTimeMillis);
                        zVar.z(gzVar);
                        if (gc.this.l.get()) {
                            zVar.z(gc.this.tb);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
            this.fv = gzVar;
            this.js = gVar;
            this.hh.set(true);
            if (this.eo.get()) {
                gc();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.m z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, final z zVar, final com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar2, final long j) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.m(gVar2, new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.11
            private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz m;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public void dl(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
                this.m = gzVar;
                gc.this.z(gzVar, mVar, zVar, gVar, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
            public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar2 = this.m;
                if (gzVar2 != null) {
                    gzVar2.gc(true);
                }
                gc.this.z(gzVar, mVar, zVar, gVar, j, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
            public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
                gc.this.z(mVar, eVar, zVar, j);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, final z zVar) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z(new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl(this.gc, "splash_ad", mVar, gzVar, this.g), new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.2
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo foVar) {
                gc.this.gc(mVar.gc());
                if (!gc.this.dl(foVar.dl())) {
                    gc.this.l.set(true);
                    gc.this.tb = foVar;
                    if (gc.this.lq.get() == 2) {
                        if (gc.this.wp()) {
                            if (gc.this.ti.get()) {
                                return;
                            }
                            zVar.z(foVar);
                            return;
                        }
                        zVar.z(foVar);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                if (gc.this.un.get() && !gc.this.mc.get()) {
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "已经超时走缓存广告");
                    gc.this.mc.set(true);
                    zVar.z(foVar);
                }
                gc.this.h.set(true);
                gc.this.q = foVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a
            public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
                if (!gc.this.dl(eVar.gz())) {
                    gc.this.l.set(false);
                    zVar.dl(eVar);
                } else {
                    gc.this.h.set(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a
            public void z() {
                gc.this.g(mVar);
            }
        }, this.fo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(na naVar, boolean z2) {
        if (naVar == null) {
            return false;
        }
        if (wp() && z2 && i()) {
            return false;
        }
        if ((com.bytedance.sdk.openadsdk.core.dl.gc.z().i() & 1) == 1) {
            return true;
        }
        return e.g(naVar) && g(naVar) && naVar.sf() == 1;
    }

    private boolean g(na naVar) {
        return naVar != null && vm.z(naVar) == 2;
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z g(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, final z zVar) {
        if (mVar == null || gzVar == null || zVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z(new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl(this.gc, "splash_ad", mVar, gzVar, this.g), new com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.gc.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo foVar) {
                gc.this.gc(mVar.gc());
                if (gc.this.ti.get()) {
                    if (mVar.gc()) {
                        zVar.z(foVar);
                    }
                } else {
                    if (mVar.gc()) {
                        return;
                    }
                    zVar.z(foVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a
            public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar) {
                zVar.dl(eVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a
            public void z() {
                gc.this.g(mVar);
            }
        }, this.fo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.z zVar, boolean z2) {
        if (zVar == null) {
            return;
        }
        int iDl = dl(z(mVar.gc()));
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "渲染 timeout " + iDl);
        if (this.sy.get()) {
            return;
        }
        if (z(mVar.g(), z2) && this.m != null && iDl <= 0) {
            iDl = 0;
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "开始渲染 isCache " + mVar.gc());
        z(zVar, mVar.gc(), iDl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo foVar) {
        if (foVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zDl = foVar.dl();
        if (zDl) {
            m.z(z(zDl), this.uf, foVar);
            this.uf.a(jCurrentTimeMillis - this.kb);
            this.uf.a(this.z);
            this.uf.z(zDl);
            m.z(z(zDl), this.uf);
            m.g(z(zDl), this.uf);
        } else {
            m.z(z(zDl), this.io, foVar);
            this.io.a(jCurrentTimeMillis - this.kb);
            this.io.a(this.z);
            this.io.z(zDl);
            m.z(z(zDl), this.io);
            m.g(z(zDl), this.io);
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (jCurrentTimeMillis - this.v));
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "渲染成功回调 开屏广告类型： ".concat(zDl ? "缓存" : "实时"));
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "加载开屏广告--end，总耗时： " + (jCurrentTimeMillis - this.kb));
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "加载开屏广告--end，getReqId： " + z(zDl).aq());
    }

    private int dl(na naVar) {
        return Math.max(com.bytedance.sdk.openadsdk.core.dl.gc.z().v(), (this.gz - ((int) (System.currentTimeMillis() - this.kb))) - (naVar != null ? vm.gc(naVar) : 100));
    }

    private j g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        j jVar = new j();
        jVar.e = jCurrentTimeMillis;
        jVar.i = uy.ls().f();
        Object obj = this.f1012a;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.z.g)) {
            jVar.gz = ((com.bytedance.sdk.openadsdk.core.z.g) obj).g();
        }
        return jVar;
    }

    private void z(String str, int i, int i2) {
        int iPf = zw.g().pf(str);
        if (iPf == 1) {
            this.gz = i > 0 ? Math.min(i, i2) : Math.max(i2, 500);
        } else if (iPf == 2) {
            this.gz = i > 0 ? i : Math.max(i2, 500);
        } else {
            this.gz = i > 0 ? Math.max(i, i2) : Math.max(i2, 500);
        }
        int iCurrentTimeMillis = (int) (((long) this.gz) - (System.currentTimeMillis() - this.dl.gz));
        if (iCurrentTimeMillis <= 0) {
            iCurrentTimeMillis = this.gz;
        }
        this.gz = iCurrentTimeMillis;
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "splashTimeOutControlType = " + iPf + "; devTimeOut = " + i2 + "; cloudTimeOut = " + i + "; realTimeOut = " + this.gz);
        this.m.sendEmptyMessageDelayed(2, this.gz);
        z(this.gz);
    }

    private void z(int i) {
        int iUy = zw.g().uy(this.e);
        if (iUy >= i || iUy <= 0 || !wp() || this.m == null) {
            return;
        }
        int i2 = i - iUy;
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "buffer time: " + iUy + "  减去buffer time后超时时间：" + i2);
        this.m.sendEmptyMessageDelayed(4, i2);
    }

    private void kb() {
        this.iq = new lw();
        lw lwVar = new lw();
        this.zw = lwVar;
        m.z(this.iq, lwVar);
        this.io = new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a();
        this.uf = new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.a();
    }

    private void a(boolean z2) {
        if (z2) {
            this.pf = System.currentTimeMillis();
        } else {
            this.v = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(boolean z2) {
        if (z2) {
            this.uf.dl(System.currentTimeMillis() - this.pf);
        } else {
            this.io.dl(System.currentTimeMillis() - this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wp() {
        return this.z == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, z zVar, com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, boolean z2) {
        if (this.sy.get()) {
            return;
        }
        g(gzVar, System.currentTimeMillis());
        if (gzVar.kb()) {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存广告： 素材首包回调");
            this.x.set(true);
        } else {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "实时广告： 素材首包回调");
            this.gk.set(true);
        }
        m.z(gzVar.kb() ? this.zw : this.iq, 3);
        m(gzVar.kb());
        if (z2) {
            z(gzVar, mVar, zVar);
        } else {
            z(gzVar, mVar, zVar, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, z zVar, com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, long j, boolean z2) {
        if (gzVar == null) {
            return;
        }
        z(mVar, mVar.gc(), false);
        if (this.sy.get()) {
            return;
        }
        if (gVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.a.z) {
            ((com.bytedance.sdk.openadsdk.core.component.splash.a.z) gVar).z(gzVar, false);
        }
        z(gzVar, j);
        if (gzVar.kb() && this.x.get()) {
            return;
        }
        if (gzVar.kb() || !this.gk.get()) {
            if (z(gzVar.g(), gzVar.gc()) || z(mVar.g())) {
                m.z(gzVar.kb() ? this.zw : this.iq, 2);
                m(gzVar.kb());
            }
            if (z2) {
                z(gzVar, mVar, zVar);
            } else {
                z(gzVar, mVar, zVar, gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e eVar, z zVar, long j) {
        if (eVar == null) {
            return;
        }
        boolean zGz = eVar.gz();
        if (!dl(zGz)) {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            zVar.g(eVar);
        } else {
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存广告: 素材加载失败");
            this.hh.set(false);
            if (this.eo.get()) {
                zVar.g(eVar);
            }
        }
        z(mVar, zGz, false);
        int i = eVar.m() ? -14 : -7;
        if (!eVar.m()) {
            e.z(j, false, false, z(eVar.gz()), i, eVar.gc());
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", (zGz ? "缓存广告" : "实时广告") + "加载素材失败 " + eVar.a());
    }

    private void m(boolean z2) {
        if (this.m != null) {
            if (wp()) {
                if (z2) {
                    return;
                } else {
                    this.m.removeMessages(4);
                }
            }
            this.m.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
        if (mVar != null && mVar.gc()) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar, boolean z2, boolean z3) {
        if (z2) {
            return;
        }
        try {
            if (this.lq.get() > 0 && !this.ti.get()) {
                com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.z(this.g, this.dl)) {
                    return;
                }
                if (this.lq.get() > 0 || this.uy.dl()) {
                    this.fo.z(mVar, this.g, z3, this.z);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void z(boolean z2, int i) {
        (z2 ? this.uf : this.io).gc(i);
    }

    public static boolean z() {
        return (com.bytedance.sdk.openadsdk.core.dl.gc.z().wp() & 256) == 256;
    }

    public static boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        return com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.z(gVar, new j()) && (com.bytedance.sdk.openadsdk.core.dl.gc.z().wp() & 4) == 4;
    }

    private boolean i() {
        return (com.bytedance.sdk.openadsdk.core.dl.gc.z().kb() & 4) == 4;
    }
}
