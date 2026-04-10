package com.bytedance.sdk.openadsdk.core.component.splash.z;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.lw;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.yx;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.fv;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    protected gc m;
    protected long z = 0;
    protected long g = 0;
    protected AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AtomicBoolean f1020a = new AtomicBoolean(false);
    protected AtomicBoolean gc = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0167z {
        void z();

        void z(m mVar);
    }

    public abstract void dl();

    public abstract void g();

    public abstract void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<fo, e> aVar, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z);

    public abstract void z(e eVar, String str, InterfaceC0167z interfaceC0167z, gc gcVar);

    public abstract void z(yx yxVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z);

    public abstract void z(String str, na naVar);

    public abstract void z(String str, String str2, boolean z, boolean z2, Object obj);

    public static z z() {
        return (com.bytedance.sdk.openadsdk.core.dl.gc.z().kb() & 16) == 16 ? new dl() : new a();
    }

    public void z(m mVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z, int i) {
        if (z(i) && com.bytedance.sdk.openadsdk.core.gc.a.gc.z(mVar.g()) && !this.dl.get()) {
            this.dl.set(true);
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            z(new yx(mVar.a(), mVar.g(), null), gVar, false);
            if (z) {
                z(mVar.a(), mVar.g(), gVar);
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean z(int i) {
        int iKb = com.bytedance.sdk.openadsdk.core.dl.gc.z().kb();
        return i == 2 ? (iKb & 2) == 2 : (i == 3 || i == 1) && (iKb & 32) == 32;
    }

    protected void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar) {
        if (this.dl.get()) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.f1020a.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (zw.g().kb(gVar.a()) && jVar != null) {
            jVar.m = 2;
        }
        zw.z().z(gVar, jVar, 4, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.z.1
            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                z.this.f1020a.set(false);
                gVar2.z(i);
                com.bytedance.sdk.openadsdk.core.iq.g.z(gVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                if (com.bytedance.sdk.openadsdk.core.component.splash.e.g(zVar)) {
                    na naVar = zVar.g().get(0);
                    if (naVar.ts()) {
                        if ((z.this.dl == null || !z.this.dl.get()) && com.bytedance.sdk.openadsdk.core.gc.a.gc.z(naVar)) {
                            z.this.z(new yx(zVar, naVar, null), gVar, false);
                            z.this.z(zVar, naVar, gVar);
                            return;
                        }
                        return;
                    }
                    gVar2.z(-4);
                    com.bytedance.sdk.openadsdk.core.iq.g.z(gVar2);
                    return;
                }
                z.this.f1020a.set(false);
            }
        });
    }

    public void z(final com.bytedance.sdk.openadsdk.core.iq.z zVar, final na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (naVar.jz() == null || naVar.jz().size() <= 0) {
            return;
        }
        gk gkVar = naVar.jz().get(0);
        String strZ = gkVar.z();
        int iG = gkVar.g();
        int iDl = gkVar.dl();
        this.z = System.currentTimeMillis();
        this.g = SystemClock.elapsedRealtime();
        lw lwVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().dl().dl();
        if (lwVarDl != null) {
            lwVarDl.z(false);
        }
        final boolean z = tf.v(naVar) != null;
        fv.z(new com.bytedance.sdk.openadsdk.i.g(strZ, gkVar.e()), iG, iDl, new fv.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.z.2
            @Override // com.bytedance.sdk.openadsdk.core.un.fv.z
            public void z(com.bytedance.sdk.openadsdk.core.io.z.g gVar2, ls lsVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.e.z(zVar);
                if (!z) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(naVar, "splash_ad", System.currentTimeMillis() - z.this.z);
                }
                z.this.z = 0L;
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.e.z(z.this.g, false, true, naVar, 0L, "preLoadImageSuccess");
                }
                z.this.f1020a.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.fv.z
            public void z() {
                com.bytedance.sdk.openadsdk.core.component.splash.e.z(zVar);
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.e.z(z.this.g, false, false, naVar, -7L, "preLoadImageFailed");
                }
                z.this.f1020a.set(false);
            }
        }, com.bytedance.sdk.openadsdk.hh.fo.gc(), 4, null, false);
    }

    public void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar) {
        if (zw.g().g(eo.g(gVar)) && gVar != null && TextUtils.isEmpty(gVar.q())) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "preLoadSplashAd... ");
            j jVar2 = jVar == null ? new j() : jVar.z();
            jVar2.e = System.currentTimeMillis();
            jVar2.i = uy.ls().f();
            z(gVar, jVar2);
        }
    }
}
