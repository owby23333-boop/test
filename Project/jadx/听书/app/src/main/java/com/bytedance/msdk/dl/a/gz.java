package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.dl.a.uy;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.ls;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes3.dex */
public class gz extends a implements com.bytedance.msdk.z.g.g {
    private com.bytedance.msdk.api.a.z.a.z g;
    private com.bytedance.msdk.api.a.z.a.g z;

    public gz(Context context) {
        super(context);
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.a.g gVar2) {
        super.g(gVar);
        this.z = gVar2;
        this.m = gVar;
        this.fo = this;
        fo();
    }

    public void z(Activity activity) {
        g(activity, null, null);
    }

    public void g(Activity activity, Object obj, String str) {
        z(activity, obj, str);
    }

    @Override // com.bytedance.msdk.dl.a.a
    protected void z(Activity activity, Object obj, String str) {
        super.z(activity, obj, str, new uy.z() { // from class: com.bytedance.msdk.dl.a.gz.1
            @Override // com.bytedance.msdk.dl.a.uy.z
            public void z() {
                gz.this.dl(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
            }
        });
        if (this.g == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        z(this.f428a);
    }

    public void z(com.bytedance.msdk.api.a.z.a.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.msdk.dl.a.uy, com.bytedance.msdk.dl.a.g
    public void z() {
        if (this.f428a == null) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.dl.tb(), this.gc, this.m, js(), this.f428a);
        }
        super.z();
        this.g = null;
        this.z = null;
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        com.bytedance.msdk.api.a.z.a.g gVar = this.z;
        if (gVar != null) {
            gVar.z();
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.api.a.z.a.g gVar = this.z;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void gz() {
        com.bytedance.msdk.api.a.z.a.g gVar = this.z;
        if (gVar != null) {
            gVar.g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    @Override // com.bytedance.msdk.api.a.z.a.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g_() {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.gz.g_():void");
    }

    @Override // com.bytedance.msdk.api.a.z.a.z
    public void z(com.bytedance.msdk.api.z zVar) {
        String strG;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.f428a)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, zVar, 1, q() ? 1 : 0, strG, jCurrentTimeMillis);
        dl(zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    @Override // com.bytedance.msdk.api.a.z.a.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h_() {
        /*
            r10 = this;
            r10.io()
            boolean r0 = com.bytedance.msdk.gz.ls.z()
            r1 = 0
            if (r0 == 0) goto L4f
            com.bytedance.msdk.g.dl r0 = r10.f428a
            if (r0 == 0) goto L3f
            com.bytedance.msdk.g.dl r0 = r10.f428a
            java.lang.String r0 = r0.zx()
            java.lang.String r2 = "pangle"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L3f
            boolean r0 = com.bytedance.msdk.gz.ls.dl()
            if (r0 != 0) goto L34
            java.lang.String r7 = com.bytedance.msdk.gz.js.z()
            com.bytedance.msdk.g.dl r2 = r10.f428a
            com.bytedance.msdk.api.z.g r3 = r10.m
            r4 = 5
            r5 = 1
            boolean r6 = r10.q()
            com.bytedance.msdk.gc.m.z(r2, r3, r4, r5, r6, r7)
            return
        L34:
            boolean r0 = com.bytedance.msdk.gz.ls.gz()
            if (r0 == 0) goto L3f
            java.lang.String r0 = com.bytedance.msdk.gz.js.z()
            goto L40
        L3f:
            r0 = r1
        L40:
            boolean r2 = r10.uf()
            if (r2 != 0) goto L4d
            com.bytedance.msdk.api.a.z.a.z r2 = r10.g
            if (r2 == 0) goto L4d
            r2.h_()
        L4d:
            r8 = r0
            goto L57
        L4f:
            com.bytedance.msdk.api.a.z.a.z r0 = r10.g
            if (r0 == 0) goto L56
            r0.h_()
        L56:
            r8 = r1
        L57:
            long r2 = java.lang.System.currentTimeMillis()
            com.bytedance.msdk.g.dl r0 = r10.f428a
            boolean r0 = com.bytedance.msdk.gz.js.z(r0)
            if (r0 == 0) goto L6f
            java.lang.String r1 = com.bytedance.msdk.gz.js.g()
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r6 = r4
            r5 = r1
            goto L73
        L6f:
            r2 = -1
            r5 = r1
            r6 = r2
        L73:
            com.bytedance.msdk.api.z.g r0 = r10.m
            java.lang.String r0 = r0.zw()
            com.bytedance.msdk.core.g.z.gc(r0)
            com.bytedance.msdk.g.dl r2 = r10.f428a
            com.bytedance.msdk.api.z.g r3 = r10.m
            boolean r4 = r10.q()
            com.bytedance.msdk.g.dl r0 = r10.f428a
            boolean r9 = r0.lq()
            com.bytedance.msdk.gc.m.g(r2, r3, r4, r5, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.gz.h_():void");
    }

    @Override // com.bytedance.msdk.api.a.z.a.z
    public void dl() {
        zw();
        if (this.ls) {
            if (ls.z()) {
                if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                    if (!ls.dl()) {
                        com.bytedance.msdk.gc.m.z(this.f428a, this.m, 2, 1, q() ? 1 : 0, js.z());
                        return;
                    }
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 2, 0, q() ? 1 : 0, (String) null);
                }
                if (uf()) {
                    return;
                }
                sy();
                com.bytedance.msdk.api.a.z.a.z zVar = this.g;
                if (zVar != null) {
                    zVar.dl();
                    return;
                }
                return;
            }
            sy();
            com.bytedance.msdk.api.a.z.a.z zVar2 = this.g;
            if (zVar2 != null) {
                zVar2.dl();
            }
        }
    }

    @Override // com.bytedance.msdk.api.a.z.a.z
    public void a() {
        if (ls.z()) {
            if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                if (!ls.dl()) {
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 1, 1, q() ? 1 : 0, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 1, 0, q() ? 1 : 0, (String) null);
            }
            if (uf()) {
                return;
            }
            sy();
            com.bytedance.msdk.api.a.z.a.z zVar = this.g;
            if (zVar != null) {
                zVar.a();
                return;
            }
            return;
        }
        sy();
        com.bytedance.msdk.api.a.z.a.z zVar2 = this.g;
        if (zVar2 != null) {
            zVar2.a();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.a.z
    public void gc() {
        String strG;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.f428a)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, (com.bytedance.msdk.api.z) null, 2, q() ? 1 : 0, strG, jCurrentTimeMillis);
        com.bytedance.msdk.api.a.z.a.z zVar = this.g;
        if (zVar != null) {
            zVar.gc();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.a.z
    public void m() {
        if (ls.z()) {
            if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                if (!ls.dl()) {
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 3, 1, q() ? 1 : 0, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 3, 0, q() ? 1 : 0, (String) null);
            }
            if (uf()) {
                return;
            }
            sy();
            com.bytedance.msdk.api.a.z.a.z zVar = this.g;
            if (zVar != null) {
                zVar.m();
                return;
            }
            return;
        }
        sy();
        com.bytedance.msdk.api.a.z.a.z zVar2 = this.g;
        if (zVar2 != null) {
            zVar2.m();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.a.z
    public void z(com.bytedance.msdk.api.dl.z zVar) {
        com.bytedance.msdk.api.a.z.a.z zVar2 = this.g;
        if (zVar2 != null) {
            zVar2.z(wp.z(this.m, zVar, this.f428a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.gz.2
            @Override // java.lang.Runnable
            public void run() {
                if (gz.this.g != null) {
                    gz.this.g.z(zVar);
                }
            }
        });
    }
}
