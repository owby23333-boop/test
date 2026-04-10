package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.dl.a.uy;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.ls;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes3.dex */
public class z extends a {
    com.bytedance.msdk.z.g.dl g;
    private com.bytedance.msdk.api.a.z.m.z q;
    private com.bytedance.msdk.api.a.z.m.g tb;
    com.bytedance.msdk.z.g.g z;

    public z(Context context) {
        super(context);
        this.z = new com.bytedance.msdk.z.g.g() { // from class: com.bytedance.msdk.dl.a.z.3
            /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
            @Override // com.bytedance.msdk.api.a.z.a.z
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void g_() {
                /*
                    Method dump skipped, instruction units count: 381
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.z.AnonymousClass3.g_():void");
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void z(com.bytedance.msdk.api.z zVar) {
                String strG;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(z.this.f428a)) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strG = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, zVar, 1, z.this.q() ? 1 : 0, strG, jCurrentTimeMillis);
                z.this.z(zVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
            @Override // com.bytedance.msdk.api.a.z.a.z
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void h_() {
                /*
                    r10 = this;
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    r0.io()
                    boolean r0 = com.bytedance.msdk.gz.ls.z()
                    r1 = 0
                    if (r0 == 0) goto L67
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.g.dl r0 = r0.f428a
                    if (r0 == 0) goto L4b
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.g.dl r0 = r0.f428a
                    java.lang.String r0 = r0.zx()
                    java.lang.String r2 = "pangle"
                    boolean r0 = r2.equals(r0)
                    if (r0 == 0) goto L4b
                    boolean r0 = com.bytedance.msdk.gz.ls.dl()
                    if (r0 != 0) goto L40
                    java.lang.String r7 = com.bytedance.msdk.gz.js.z()
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.g.dl r2 = r0.f428a
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.api.z.g r3 = r0.m
                    r4 = 5
                    r5 = 1
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    boolean r6 = r0.q()
                    com.bytedance.msdk.gc.m.z(r2, r3, r4, r5, r6, r7)
                    return
                L40:
                    boolean r0 = com.bytedance.msdk.gz.ls.gz()
                    if (r0 == 0) goto L4b
                    java.lang.String r0 = com.bytedance.msdk.gz.js.z()
                    goto L4c
                L4b:
                    r0 = r1
                L4c:
                    com.bytedance.msdk.dl.a.z r2 = com.bytedance.msdk.dl.a.z.this
                    boolean r2 = r2.uf()
                    if (r2 != 0) goto L65
                    com.bytedance.msdk.dl.a.z r2 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.api.a.z.m.z r2 = com.bytedance.msdk.dl.a.z.z(r2)
                    if (r2 == 0) goto L65
                    com.bytedance.msdk.dl.a.z r2 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.api.a.z.m.z r2 = com.bytedance.msdk.dl.a.z.z(r2)
                    r2.g()
                L65:
                    r8 = r0
                    goto L79
                L67:
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.api.a.z.m.z r0 = com.bytedance.msdk.dl.a.z.z(r0)
                    if (r0 == 0) goto L78
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.api.a.z.m.z r0 = com.bytedance.msdk.dl.a.z.z(r0)
                    r0.g()
                L78:
                    r8 = r1
                L79:
                    long r2 = java.lang.System.currentTimeMillis()
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.g.dl r0 = r0.f428a
                    boolean r0 = com.bytedance.msdk.gz.js.z(r0)
                    if (r0 == 0) goto L93
                    java.lang.String r1 = com.bytedance.msdk.gz.js.g()
                    long r4 = java.lang.System.currentTimeMillis()
                    long r4 = r4 - r2
                    r6 = r4
                    r5 = r1
                    goto L97
                L93:
                    r2 = -1
                    r5 = r1
                    r6 = r2
                L97:
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    java.lang.String r0 = r0.gc
                    com.bytedance.msdk.core.g.z.gc(r0)
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.g.dl r2 = r0.f428a
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.api.z.g r3 = r0.m
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    boolean r4 = r0.q()
                    com.bytedance.msdk.dl.a.z r0 = com.bytedance.msdk.dl.a.z.this
                    com.bytedance.msdk.g.dl r0 = r0.f428a
                    boolean r9 = r0.lq()
                    com.bytedance.msdk.gc.m.g(r2, r3, r4, r5, r6, r8, r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.z.AnonymousClass3.h_():void");
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void dl() {
                z.this.zw();
                if (z.this.ls) {
                    if (ls.z()) {
                        if (z.this.f428a != null && MediationConstant.ADN_PANGLE.equals(z.this.f428a.zx())) {
                            if (!ls.dl()) {
                                com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, 2, 1, z.this.q() ? 1 : 0, js.z());
                                return;
                            }
                            com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, 2, 0, z.this.q() ? 1 : 0, (String) null);
                        }
                        if (z.this.uf()) {
                            return;
                        }
                        z.this.sy();
                        if (z.this.q != null) {
                            z.this.q.dl();
                            return;
                        }
                        return;
                    }
                    z.this.sy();
                    if (z.this.q != null) {
                        z.this.q.dl();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void a() {
                if (ls.z()) {
                    if (z.this.f428a != null && MediationConstant.ADN_PANGLE.equals(z.this.f428a.zx())) {
                        if (!ls.dl()) {
                            com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, 1, 1, z.this.q() ? 1 : 0, js.z());
                            return;
                        }
                        com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, 1, 0, z.this.q() ? 1 : 0, (String) null);
                    }
                    if (z.this.uf()) {
                        return;
                    }
                    z.this.sy();
                    if (z.this.q != null) {
                        z.this.q.a();
                        return;
                    }
                    return;
                }
                z.this.sy();
                if (z.this.q != null) {
                    z.this.q.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void gc() {
                String strG;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(z.this.f428a)) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strG = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, (com.bytedance.msdk.api.z) null, 2, z.this.q() ? 1 : 0, strG, jCurrentTimeMillis);
                if (z.this.q != null) {
                    z.this.q.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void m() {
                if (ls.z()) {
                    if (z.this.f428a != null && MediationConstant.ADN_PANGLE.equals(z.this.f428a.zx())) {
                        if (!ls.dl()) {
                            com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, 3, 1, z.this.q() ? 1 : 0, js.z());
                            return;
                        }
                        com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, 3, 0, z.this.q() ? 1 : 0, (String) null);
                    }
                    if (z.this.uf()) {
                        return;
                    }
                    z.this.sy();
                    if (z.this.q != null) {
                        z.this.q.m();
                        return;
                    }
                    return;
                }
                z.this.sy();
                if (z.this.q != null) {
                    z.this.q.m();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void z(com.bytedance.msdk.api.dl.z zVar) {
                if (z.this.q != null) {
                    z.this.q.z(wp.z(z.this.m, zVar, z.this.f428a));
                }
            }
        };
        this.g = new com.bytedance.msdk.z.g.dl() { // from class: com.bytedance.msdk.dl.a.z.4
            @Override // com.bytedance.msdk.api.a.z.gc.z
            public void z() {
                String strG;
                long jCurrentTimeMillis;
                z.this.iq();
                if (z.this.q != null) {
                    z.this.q.z();
                }
                com.bytedance.msdk.core.gz.i.z().e(z.this.gc);
                if (z.this.f428a != null) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(z.this.gc, "show_listen") + "adSlotId：" + z.this.f428a.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(z.this.f428a.r()));
                    com.bytedance.msdk.core.gz.kb.z().g(z.this.gc, z.this.f428a.yz());
                }
                z zVar = z.this;
                zVar.z(zVar.dl);
                z zVar2 = z.this;
                zVar2.dl(zVar2.f428a);
                if (z.this.f428a != null) {
                    com.bytedance.msdk.core.dl.dl.z(z.this.f428a.lw(), z.this.gc, z.this.f428a.yz());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(z.this.f428a)) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strG = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, z.this.q() ? 1 : 0, strG, jCurrentTimeMillis, false);
                com.bytedance.msdk.core.e.dl.z(z.this.gc, z.this.f428a);
            }

            @Override // com.bytedance.msdk.api.a.z.gc.z
            public void z(com.bytedance.msdk.api.z zVar) {
                String strG;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(z.this.f428a)) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strG = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.gc.m.z(z.this.f428a, z.this.m, zVar, 1, z.this.q() ? 1 : 0, strG, jCurrentTimeMillis);
                z.this.z(zVar);
            }

            @Override // com.bytedance.msdk.api.a.z.gc.z
            public void g() {
                String strG;
                long jCurrentTimeMillis;
                z.this.io();
                if (z.this.q != null) {
                    z.this.q.g();
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(z.this.f428a)) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strG = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.g.dl dlVar = z.this.f428a;
                com.bytedance.msdk.api.z.g gVar = z.this.m;
                boolean zQ = z.this.q();
                boolean zLq = z.this.f428a.lq();
                com.bytedance.msdk.gc.m.g(dlVar, gVar, zQ ? 1 : 0, strG, jCurrentTimeMillis, zLq);
            }

            @Override // com.bytedance.msdk.api.a.z.gc.z
            public void dl() {
                z.this.zw();
                if (z.this.ls) {
                    z.this.sy();
                    if (z.this.q != null) {
                        z.this.q.dl();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gc.z
            public void a() {
                if (z.this.q != null) {
                    z.this.q.e();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gc.z
            public void gc() {
                if (z.this.q != null) {
                    z.this.q.gz();
                }
            }
        };
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.m.g gVar2) {
        super.g(gVar);
        this.m = gVar;
        this.tb = gVar2;
        this.fo = this.z;
        fo();
    }

    public void z(Activity activity) {
        z(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.dl.a.a
    public void z(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "activity can not be null !");
        } else {
            g(activity, obj, str);
            z(this.f428a);
        }
    }

    private void g(Activity activity, Object obj, String str) {
        super.z(activity, obj, str, new uy.z() { // from class: com.bytedance.msdk.dl.a.z.1
            @Override // com.bytedance.msdk.dl.a.uy.z
            public void z() {
                z.this.z(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
            }
        });
    }

    public void z(com.bytedance.msdk.api.a.z.m.z zVar) {
        this.q = zVar;
    }

    @Override // com.bytedance.msdk.dl.a.uy, com.bytedance.msdk.dl.a.g
    public void z() {
        if (this.f428a == null) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.dl.tb(), this.gc, this.m, js(), this.f428a);
        }
        super.z();
        this.q = null;
        this.tb = null;
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        com.bytedance.msdk.api.a.z.m.g gVar = this.tb;
        if (gVar != null) {
            gVar.z();
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.api.a.z.m.g gVar = this.tb;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void gz() {
        com.bytedance.msdk.api.a.z.m.g gVar = this.tb;
        if (gVar != null) {
            gVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.z.2
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.q != null) {
                    z.this.q.z(zVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.dl.a.a, com.bytedance.msdk.dl.a.uy
    public void z(com.bytedance.msdk.g.dl dlVar, Activity activity, Object obj, String str) {
        if (dlVar != null) {
            if (dlVar.j() == 1) {
                this.fo = this.g;
            } else if (dlVar.j() == 2) {
                this.fo = this.z;
            }
        }
        super.z(dlVar, activity, obj, str);
    }
}
