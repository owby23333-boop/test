package com.bytedance.sdk.openadsdk.core.component.splash.dl.dl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.iq.j;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f999a;
    volatile boolean dl;
    private e e;
    private com.bytedance.sdk.openadsdk.core.component.splash.z.z fo;
    volatile boolean g;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gc gc;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m gz;
    private g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e> m;
    private com.bytedance.sdk.openadsdk.core.component.splash.g uy;
    volatile boolean z;

    public gc(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gc gcVar, g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e> gVar, com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar, com.bytedance.sdk.openadsdk.core.component.splash.g gVar2) {
        if (gcVar == null || gVar == null) {
            return;
        }
        this.gc = gcVar;
        this.m = gVar;
        this.fo = zVar;
        this.uy = gVar2;
    }

    public void z(final int i) {
        if (this.gc == null || this.m == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        if (i == 0) {
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.dl().z(this.gc, this.m);
            return;
        }
        if (i == 1) {
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.z(this.fo).z(this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                    gc.this.m.g(mVar);
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.z.z.z(i) || gc.this.fo == null || gc.this.gc == null) {
                        return;
                    }
                    gc.this.fo.g(gc.this.gc.a(), gc.this.gc.gc());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                public void z(e eVar) {
                    if (eVar != null && gc.this.gc != null) {
                        gc.this.gc.z(eVar.a());
                        gc.this.gc.z(eVar.dl());
                    }
                    if (gc.this.uy == null || !gc.this.uy.g()) {
                        new com.bytedance.sdk.openadsdk.core.component.splash.g.z.dl().z(gc.this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                            public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                                if (gc.this.f999a) {
                                    if (gc.this.fo == null || gc.this.gc == null) {
                                        return;
                                    }
                                    gc.this.fo.z(mVar, gc.this.gc.a(), true, 1);
                                    return;
                                }
                                gc.this.m.g(mVar);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                            public void z(e eVar2) {
                                gc.this.m.z(eVar2);
                                if (!com.bytedance.sdk.openadsdk.core.component.splash.z.z.z(i) || gc.this.fo == null || gc.this.gc == null) {
                                    return;
                                }
                                gc.this.fo.g(gc.this.gc.a(), gc.this.gc.gc());
                            }
                        });
                    } else {
                        gc.this.m.z(eVar);
                    }
                }
            });
            return;
        }
        if (i == 2) {
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.dl().z(this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                    gc.this.gz = mVar;
                    if (gc.this.e != null && mVar != null) {
                        mVar.z(gc.this.e.a());
                        mVar.z(gc.this.e.dl());
                    }
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "实时物料加载成功 isCache " + mVar.gc());
                    gc.this.m.g(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                public void z(e eVar) {
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "实时物料加载失败 ");
                    gc.this.m.z(eVar);
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.z(this.fo).z(this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.3
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存物料加载成功 isCache " + mVar.gc());
                    gc.this.m.g(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                public void z(e eVar) {
                    gc.this.e = eVar;
                    com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "缓存物料加载失败  ");
                    if (gc.this.gz != null && eVar != null) {
                        gc.this.gz.z(eVar.a());
                        gc.this.gz.z(eVar.dl());
                    }
                    gc.this.m.z(eVar);
                }
            });
        } else if (i == 3) {
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.dl().z(this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.4
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                    gc.this.gz = mVar;
                    if (gc.this.dl || gc.this.f999a) {
                        if (gc.this.fo == null || gc.this.gc == null) {
                            return;
                        }
                        gc.this.fo.z(mVar, gc.this.gc.a(), true, 3);
                        return;
                    }
                    if (gc.this.e != null && mVar != null) {
                        mVar.z(gc.this.e.a());
                        mVar.z(gc.this.e.dl());
                    }
                    gc.this.dl = true;
                    gc.this.m.g(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                public void z(e eVar) {
                    gc.this.z = true;
                    if (gc.this.g) {
                        gc.this.m.z(eVar);
                    }
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.z.z.z(i) || gc.this.fo == null || gc.this.gc == null) {
                        return;
                    }
                    gc.this.fo.g(gc.this.gc.a(), gc.this.gc.gc());
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.z(this.fo).z(this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.5
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                    if (gc.this.dl) {
                        return;
                    }
                    gc.this.dl = true;
                    gc.this.m.g(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                public void z(e eVar) {
                    gc.this.e = eVar;
                    if (gc.this.gz != null && eVar != null) {
                        gc.this.gz.z(eVar.a());
                        gc.this.gz.z(eVar.dl());
                    }
                    gc.this.g = true;
                    if (gc.this.z) {
                        gc.this.m.z(eVar);
                    }
                }
            });
        } else {
            if (i != 4) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.component.splash.g.z.z(this.fo).z(this.gc, new g<com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.6
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void g(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar) {
                    gc.this.m.g(mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g
                public void z(e eVar) {
                    gc.this.m.z(eVar);
                }
            });
        }
    }

    public void z() {
        this.f999a = true;
    }

    public static boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar) {
        return (gVar == null || jVar == null || TextUtils.isEmpty(gVar.q()) || jVar.f1172a > 0) ? false : true;
    }
}
