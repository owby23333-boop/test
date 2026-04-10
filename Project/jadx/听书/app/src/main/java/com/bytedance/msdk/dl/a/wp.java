package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.msdk.dl.a.uy;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.ls;
import com.bytedance.msdk.gz.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends uy implements com.bytedance.msdk.z.g.a {
    private com.bytedance.msdk.api.a.z.gz.g g;
    private boolean io;
    private com.bytedance.msdk.core.admanager.reward.z iq;
    private com.bytedance.msdk.api.a.z.gz.z ls;
    private com.bytedance.msdk.core.admanager.reward.z q;
    private com.bytedance.msdk.api.a.z.gz.z tb;
    private final com.bytedance.msdk.z.g.g uf;
    com.bytedance.msdk.api.a.z.gz.z z;
    private com.bytedance.msdk.core.admanager.reward.rewardagain.dl zw;

    public wp(Context context) {
        super(context);
        this.z = new AnonymousClass2();
        this.uf = new AnonymousClass6();
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.gz.g gVar2) {
        z(gVar);
        this.q = new com.bytedance.msdk.core.admanager.reward.z(this.gc);
        this.iq = new com.bytedance.msdk.core.admanager.reward.z(this.gc);
        this.g = gVar2;
        this.fo = this;
        this.js = this.z;
        if (com.bytedance.msdk.core.admanager.reward.rewardagain.dl.fo(this.gc) != null) {
            this.zw = new com.bytedance.msdk.core.admanager.reward.rewardagain.dl(this.gz.get(), this.m, this.ls, this.tb);
        }
        fo();
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.api.a.z.gz.g gVar = this.g;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        com.bytedance.msdk.api.a.z.gz.g gVar = this.g;
        if (gVar != null) {
            gVar.z();
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void gz() {
        com.bytedance.msdk.api.a.z.gz.g gVar = this.g;
        if (gVar != null) {
            gVar.g();
        }
    }

    public void z(Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.dl dlVar = this.zw;
        if (dlVar != null) {
            dlVar.z(activity, obj, str);
        }
        z(activity, obj, str, new uy.z() { // from class: com.bytedance.msdk.dl.a.wp.1
            @Override // com.bytedance.msdk.dl.a.uy.z
            public void z() {
                wp.this.a(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
            }
        });
        if (this.ls == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        z(this.f428a);
    }

    public void z(Activity activity) {
        z(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.dl.a.uy
    public void z(com.bytedance.msdk.g.dl dlVar, Activity activity, Object obj, String str) {
        if (dlVar != null) {
            if (dlVar.j() != 6 && dlVar.j() == 7) {
                this.fo = this.uf;
            } else {
                this.fo = this;
            }
        }
        super.z(dlVar, activity, obj, str);
    }

    public void z(com.bytedance.msdk.api.a.z.gz.z zVar) {
        this.ls = zVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.dl dlVar = this.zw;
        if (dlVar != null) {
            dlVar.z(zVar);
        }
    }

    public void g(com.bytedance.msdk.api.a.z.gz.z zVar) {
        this.tb = zVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.dl dlVar = this.zw;
        if (dlVar != null) {
            dlVar.g(zVar);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.dl.a.wp$2, reason: invalid class name */
    class AnonymousClass2 implements com.bytedance.msdk.api.a.z.gz.z {
        AnonymousClass2() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
        @Override // com.bytedance.msdk.api.a.z.gz.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i_() {
            /*
                Method dump skipped, instruction units count: 348
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.wp.AnonymousClass2.i_():void");
        }

        @Override // com.bytedance.msdk.api.a.z.gz.z
        public void z(com.bytedance.msdk.api.z zVar) {
            String strG;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (js.z(wp.this.f428a)) {
                strG = js.g();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strG = null;
                jCurrentTimeMillis = -1;
            }
            com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, zVar, 1, 1, strG, jCurrentTimeMillis);
            wp.this.dl(zVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
        @Override // com.bytedance.msdk.api.a.z.gz.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void j_() {
            /*
                r10 = this;
                boolean r0 = com.bytedance.msdk.gz.ls.z()
                r1 = 0
                if (r0 == 0) goto L5d
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                if (r0 == 0) goto L41
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                java.lang.String r0 = r0.zx()
                java.lang.String r2 = "pangle"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L41
                boolean r0 = com.bytedance.msdk.gz.ls.g()
                if (r0 != 0) goto L36
                java.lang.String r7 = com.bytedance.msdk.gz.js.z()
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r2 = r0.f428a
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.z.g r3 = r0.m
                r4 = 5
                r5 = 1
                r6 = 1
                com.bytedance.msdk.gc.m.z(r2, r3, r4, r5, r6, r7)
                return
            L36:
                boolean r0 = com.bytedance.msdk.gz.ls.gc()
                if (r0 == 0) goto L41
                java.lang.String r0 = com.bytedance.msdk.gz.js.z()
                goto L42
            L41:
                r0 = r1
            L42:
                com.bytedance.msdk.dl.a.wp r2 = com.bytedance.msdk.dl.a.wp.this
                boolean r2 = r2.uf()
                if (r2 != 0) goto L5b
                com.bytedance.msdk.dl.a.wp r2 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r2 = com.bytedance.msdk.dl.a.wp.z(r2)
                if (r2 == 0) goto L5b
                com.bytedance.msdk.dl.a.wp r2 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r2 = com.bytedance.msdk.dl.a.wp.z(r2)
                r2.j_()
            L5b:
                r8 = r0
                goto L6f
            L5d:
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r0 = com.bytedance.msdk.dl.a.wp.z(r0)
                if (r0 == 0) goto L6e
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r0 = com.bytedance.msdk.dl.a.wp.z(r0)
                r0.j_()
            L6e:
                r8 = r1
            L6f:
                long r2 = java.lang.System.currentTimeMillis()
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                boolean r0 = com.bytedance.msdk.gz.js.z(r0)
                if (r0 == 0) goto L89
                java.lang.String r1 = com.bytedance.msdk.gz.js.g()
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r2
                r6 = r4
                r5 = r1
                goto L8d
            L89:
                r2 = -1
                r5 = r1
                r6 = r2
            L8d:
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r2 = r0.f428a
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.z.g r3 = r0.m
                r4 = 1
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                boolean r9 = r0.mc()
                com.bytedance.msdk.gc.m.g(r2, r3, r4, r5, r6, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.wp.AnonymousClass2.j_():void");
        }

        @Override // com.bytedance.msdk.api.a.z.gz.z
        public void dl() {
            if (!ls.z()) {
                if (wp.this.tb != null) {
                    wp.this.tb.dl();
                    return;
                }
                return;
            }
            if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 2, 1, 1, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 2, 0, 1, (String) null);
            }
            if (wp.this.uf() || wp.this.tb == null) {
                return;
            }
            wp.this.tb.dl();
        }

        @Override // com.bytedance.msdk.api.a.z.gz.z
        public void a() {
            if (!ls.z()) {
                if (wp.this.iq.z()) {
                    wp.this.iq.gc();
                }
                if (wp.this.tb != null) {
                    wp.this.tb.a();
                    return;
                }
                return;
            }
            if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 1, 1, 1, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 1, 0, 1, (String) null);
            }
            if (wp.this.uf()) {
                return;
            }
            if (wp.this.iq.z()) {
                wp.this.iq.gc();
            }
            if (wp.this.tb != null) {
                wp.this.tb.a();
            }
        }

        @Override // com.bytedance.msdk.api.a.z.gz.z
        public void gc() {
            String strG;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (js.z(wp.this.f428a)) {
                strG = js.g();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strG = null;
                jCurrentTimeMillis = -1;
            }
            com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, (com.bytedance.msdk.api.z) null, 2, 1, strG, jCurrentTimeMillis);
            if (wp.this.tb != null) {
                wp.this.tb.gc();
            }
        }

        @Override // com.bytedance.msdk.api.a.z.gz.z
        public void z(com.bytedance.msdk.api.dl.z zVar) {
            if (!ls.z()) {
                if (wp.this.iq.z()) {
                    wp.this.iq.a();
                    return;
                } else {
                    if (wp.this.tb != null) {
                        wp.this.tb.z(wp.z(wp.this.m, zVar, wp.this.f428a));
                        wp.this.z((com.bytedance.msdk.api.dl.z) null, 1);
                        return;
                    }
                    return;
                }
            }
            if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 4, 1, 1, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 4, 0, 1, ls.m() ? js.z() : null);
            }
            if (wp.this.uf()) {
                return;
            }
            if (wp.this.iq.z()) {
                wp.this.iq.a();
            } else if (wp.this.tb != null) {
                wp.this.tb.z(wp.z(wp.this.m, zVar, wp.this.f428a));
                wp.this.z((com.bytedance.msdk.api.dl.z) null, 1);
            }
        }

        @Override // com.bytedance.msdk.api.a.z.gz.z
        public void m() {
            if (!ls.z()) {
                if (wp.this.iq.z()) {
                    wp.this.iq.g();
                }
                if (wp.this.tb != null) {
                    wp.this.tb.m();
                    return;
                }
                return;
            }
            if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 3, 1, 1, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 3, 0, 1, (String) null);
            }
            if (wp.this.uf()) {
                return;
            }
            if (wp.this.iq.z()) {
                wp.this.iq.g();
            }
            if (wp.this.tb != null) {
                wp.this.tb.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.wp.3
            @Override // java.lang.Runnable
            public void run() {
                if (wp.this.tb != null) {
                    wp.this.tb.z(zVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.msdk.api.dl.z zVar, int i) {
        String strG;
        long jCurrentTimeMillis;
        int i2;
        int iIntValue;
        String str;
        Map<String, Object> mapA;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.f428a)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        String str2 = strG;
        long j = jCurrentTimeMillis;
        if (zVar == null || (mapA = zVar.a()) == null) {
            i2 = 0;
            iIntValue = 0;
            str = "";
        } else {
            Integer num = (Integer) mapA.get(MediationConstant.KEY_REASON);
            int iIntValue2 = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) mapA.get(MediationConstant.KEY_ERROR_CODE);
            iIntValue = num2 != null ? num2.intValue() : 0;
            str = (String) mapA.get(MediationConstant.KEY_ERROR_MSG);
            i2 = iIntValue2;
        }
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, i, str2, j, i2, iIntValue, str);
    }

    public static com.bytedance.msdk.api.dl.z z(final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.api.dl.z zVar, final com.bytedance.msdk.g.dl dlVar) {
        if (zVar == null) {
            return null;
        }
        return new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.a.wp.4
            @Override // com.bytedance.msdk.api.dl.z
            public boolean z() {
                return zVar.z();
            }

            @Override // com.bytedance.msdk.api.dl.z
            public float g() {
                return zVar.g();
            }

            @Override // com.bytedance.msdk.api.dl.z
            public String dl() {
                return zVar.dl();
            }

            @Override // com.bytedance.msdk.api.dl.z
            public Map<String, Object> a() {
                HashMap map;
                Map<String, Object> mapA = zVar.a();
                if (mapA != null && mapA.size() > 0) {
                    map = new HashMap(mapA);
                } else {
                    map = new HashMap();
                }
                com.bytedance.msdk.api.dl dlVarZ = v.z(gVar, dlVar, true);
                map.put(MediationConstant.KEY_ADN_NAME, dlVarZ != null ? dlVarZ.wp() : "");
                map.put(MediationConstant.KEY_ECPM, dlVarZ != null ? dlVarZ.i() : "");
                return map;
            }
        };
    }

    @Override // com.bytedance.msdk.dl.a.uy, com.bytedance.msdk.dl.a.g
    public void z() {
        if (this.f428a == null) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.dl.tb(), this.gc, this.m, this.m.gc(), this.f428a);
        }
        super.z();
        this.q.dl();
        this.iq.dl();
        this.g = null;
        this.ls = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.wp.5
            @Override // java.lang.Runnable
            public void run() {
                if (wp.this.ls != null) {
                    wp.this.ls.z(zVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iq() {
        int i;
        if (this.m == null || this.m.gz() == 1) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得，一次链路只展示一次激励再得: " + this.gc);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.z zVarFo = com.bytedance.msdk.core.admanager.reward.rewardagain.dl.fo(this.gc);
        if (zVarFo == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得开关未开启: " + this.gc);
            return false;
        }
        if (this.io) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得，adn已经触发了再看一个: " + this.gc);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.dl dlVar = this.zw;
        if (dlVar != null) {
            int iZ = dlVar.z(this.m, zVarFo, this.f428a);
            if (com.bytedance.msdk.core.gc.g.a.z().dl(this.gc, this.m.gc())) {
                i = this.fv ? 4 : 2;
            } else {
                i = 1;
            }
            com.bytedance.msdk.gc.m.z(this.m, iZ, i);
            if (iZ == 0) {
                this.zw.z(zVarFo, this.f428a);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.dl.a.wp$6, reason: invalid class name */
    class AnonymousClass6 implements com.bytedance.msdk.z.g.g {
        private volatile boolean g = false;
        private volatile boolean dl = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f432a = new Handler(Looper.getMainLooper());

        @Override // com.bytedance.msdk.api.a.z.a.z
        public void z(com.bytedance.msdk.api.dl.z zVar) {
        }

        AnonymousClass6() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
        @Override // com.bytedance.msdk.api.a.z.a.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void g_() {
            /*
                Method dump skipped, instruction units count: 412
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.wp.AnonymousClass6.g_():void");
        }

        @Override // com.bytedance.msdk.api.a.z.a.z
        public void z(com.bytedance.msdk.api.z zVar) {
            String strG;
            long jCurrentTimeMillis;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (js.z(wp.this.f428a)) {
                strG = js.g();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                strG = null;
                jCurrentTimeMillis = -1;
            }
            com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, zVar, 1, 0, strG, jCurrentTimeMillis);
            wp.this.a(zVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
        @Override // com.bytedance.msdk.api.a.z.a.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void h_() {
            /*
                r10 = this;
                boolean r0 = com.bytedance.msdk.gz.ls.z()
                r1 = 0
                if (r0 == 0) goto L5d
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                if (r0 == 0) goto L41
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                java.lang.String r0 = r0.zx()
                java.lang.String r2 = "pangle"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L41
                boolean r0 = com.bytedance.msdk.gz.ls.dl()
                if (r0 != 0) goto L36
                java.lang.String r7 = com.bytedance.msdk.gz.js.z()
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r2 = r0.f428a
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.z.g r3 = r0.m
                r4 = 5
                r5 = 1
                r6 = 0
                com.bytedance.msdk.gc.m.z(r2, r3, r4, r5, r6, r7)
                return
            L36:
                boolean r0 = com.bytedance.msdk.gz.ls.gz()
                if (r0 == 0) goto L41
                java.lang.String r0 = com.bytedance.msdk.gz.js.z()
                goto L42
            L41:
                r0 = r1
            L42:
                com.bytedance.msdk.dl.a.wp r2 = com.bytedance.msdk.dl.a.wp.this
                boolean r2 = r2.uf()
                if (r2 != 0) goto L5b
                com.bytedance.msdk.dl.a.wp r2 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r2 = com.bytedance.msdk.dl.a.wp.dl(r2)
                if (r2 == 0) goto L5b
                com.bytedance.msdk.dl.a.wp r2 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r2 = com.bytedance.msdk.dl.a.wp.dl(r2)
                r2.j_()
            L5b:
                r8 = r0
                goto L6f
            L5d:
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r0 = com.bytedance.msdk.dl.a.wp.dl(r0)
                if (r0 == 0) goto L6e
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.a.z.gz.z r0 = com.bytedance.msdk.dl.a.wp.dl(r0)
                r0.j_()
            L6e:
                r8 = r1
            L6f:
                long r2 = java.lang.System.currentTimeMillis()
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                boolean r0 = com.bytedance.msdk.gz.js.z(r0)
                if (r0 == 0) goto L89
                java.lang.String r1 = com.bytedance.msdk.gz.js.g()
                long r4 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r2
                r6 = r4
                r5 = r1
                goto L8d
            L89:
                r2 = -1
                r5 = r1
                r6 = r2
            L8d:
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                java.lang.String r0 = r0.gc
                com.bytedance.msdk.core.g.z.gc(r0)
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r2 = r0.f428a
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.api.z.g r3 = r0.m
                r4 = 0
                com.bytedance.msdk.dl.a.wp r0 = com.bytedance.msdk.dl.a.wp.this
                com.bytedance.msdk.g.dl r0 = r0.f428a
                boolean r9 = r0.lq()
                com.bytedance.msdk.gc.m.g(r2, r3, r4, r5, r6, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.wp.AnonymousClass6.h_():void");
        }

        @Override // com.bytedance.msdk.api.a.z.a.z
        public void dl() {
            e();
            this.dl = true;
            if (ls.z()) {
                if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                    if (!ls.dl()) {
                        com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 2, 1, 0, js.z());
                        return;
                    }
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 2, 0, 0, (String) null);
                }
                if (wp.this.uf()) {
                    return;
                }
                wp.this.sy();
                if (wp.this.iq() || wp.this.ls == null) {
                    return;
                }
                wp.this.ls.dl();
                return;
            }
            wp.this.sy();
            if (wp.this.iq() || wp.this.ls == null) {
                return;
            }
            wp.this.ls.dl();
        }

        @Override // com.bytedance.msdk.api.a.z.a.z
        public void a() {
            if (ls.z()) {
                if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                    if (!ls.dl()) {
                        com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 1, 1, 0, js.z());
                        return;
                    }
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 1, 0, 0, (String) null);
                }
                if (wp.this.uf()) {
                    return;
                }
                wp.this.sy();
                if (wp.this.q.z()) {
                    wp.this.q.gc();
                }
                if (wp.this.ls != null) {
                    wp.this.ls.a();
                    return;
                }
                return;
            }
            wp.this.sy();
            if (wp.this.q.z()) {
                wp.this.q.gc();
            }
            if (wp.this.ls != null) {
                wp.this.ls.a();
            }
        }

        @Override // com.bytedance.msdk.api.a.z.a.z
        public void gc() {
            wp.this.gc();
        }

        @Override // com.bytedance.msdk.api.a.z.a.z
        public void m() {
            e();
            this.g = true;
            if (ls.z()) {
                if (wp.this.f428a != null && MediationConstant.ADN_PANGLE.equals(wp.this.f428a.zx())) {
                    if (!ls.dl()) {
                        com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 3, 1, 0, js.z());
                        return;
                    }
                    com.bytedance.msdk.gc.m.z(wp.this.f428a, wp.this.m, 3, 0, 0, (String) null);
                }
                if (wp.this.uf()) {
                    return;
                }
                wp.this.sy();
                if (wp.this.q.z()) {
                    wp.this.q.g();
                }
                if (wp.this.ls != null) {
                    wp.this.ls.m();
                    return;
                }
                return;
            }
            wp.this.sy();
            if (wp.this.q.z()) {
                wp.this.q.g();
            }
            if (wp.this.ls != null) {
                wp.this.ls.m();
            }
        }

        private void gz() {
            this.f432a.postDelayed(new Runnable() { // from class: com.bytedance.msdk.dl.a.wp.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass6.this.dl || AnonymousClass6.this.g) {
                        AnonymousClass6.this.e();
                        return;
                    }
                    wp.this.z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.a.wp.6.2.1
                        @Override // com.bytedance.msdk.api.dl.z
                        public boolean z() {
                            return true;
                        }

                        @Override // com.bytedance.msdk.api.dl.z
                        public float g() {
                            if (wp.this.m != null) {
                                return wp.this.m.gk();
                            }
                            return 0.0f;
                        }

                        @Override // com.bytedance.msdk.api.dl.z
                        public String dl() {
                            return wp.this.m != null ? wp.this.m.h() : "";
                        }

                        @Override // com.bytedance.msdk.api.dl.z
                        public Map<String, Object> a() {
                            return new HashMap();
                        }
                    });
                    AnonymousClass6.this.e();
                }
            }, com.bytedance.msdk.e.z.z.z().m());
        }

        public void e() {
            this.f432a.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    @Override // com.bytedance.msdk.api.a.z.gz.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i_() {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.wp.i_():void");
    }

    @Override // com.bytedance.msdk.api.a.z.gz.z
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
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, zVar, 1, 0, strG, jCurrentTimeMillis);
        a(zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    @Override // com.bytedance.msdk.api.a.z.gz.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j_() {
        /*
            r10 = this;
            com.bytedance.msdk.api.z.g r0 = r10.m
            java.lang.String r0 = r0.zw()
            com.bytedance.msdk.core.g.z.gc(r0)
            boolean r0 = com.bytedance.msdk.gz.ls.z()
            r1 = 0
            if (r0 == 0) goto L52
            com.bytedance.msdk.g.dl r0 = r10.f428a
            if (r0 == 0) goto L42
            com.bytedance.msdk.g.dl r0 = r10.f428a
            java.lang.String r0 = r0.zx()
            java.lang.String r2 = "pangle"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L42
            boolean r0 = com.bytedance.msdk.gz.ls.g()
            if (r0 != 0) goto L37
            java.lang.String r7 = com.bytedance.msdk.gz.js.z()
            com.bytedance.msdk.g.dl r2 = r10.f428a
            com.bytedance.msdk.api.z.g r3 = r10.m
            r4 = 5
            r5 = 1
            r6 = 0
            com.bytedance.msdk.gc.m.z(r2, r3, r4, r5, r6, r7)
            return
        L37:
            boolean r0 = com.bytedance.msdk.gz.ls.gc()
            if (r0 == 0) goto L42
            java.lang.String r0 = com.bytedance.msdk.gz.js.z()
            goto L43
        L42:
            r0 = r1
        L43:
            boolean r2 = r10.uf()
            if (r2 != 0) goto L50
            com.bytedance.msdk.api.a.z.gz.z r2 = r10.ls
            if (r2 == 0) goto L50
            r2.j_()
        L50:
            r8 = r0
            goto L5a
        L52:
            com.bytedance.msdk.api.a.z.gz.z r0 = r10.ls
            if (r0 == 0) goto L59
            r0.j_()
        L59:
            r8 = r1
        L5a:
            long r2 = java.lang.System.currentTimeMillis()
            com.bytedance.msdk.g.dl r0 = r10.f428a
            boolean r0 = com.bytedance.msdk.gz.js.z(r0)
            if (r0 == 0) goto L72
            java.lang.String r1 = com.bytedance.msdk.gz.js.g()
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r6 = r4
            r5 = r1
            goto L76
        L72:
            r2 = -1
            r5 = r1
            r6 = r2
        L76:
            com.bytedance.msdk.g.dl r2 = r10.f428a
            com.bytedance.msdk.api.z.g r3 = r10.m
            r4 = 0
            com.bytedance.msdk.g.dl r0 = r10.f428a
            boolean r9 = r0.lq()
            com.bytedance.msdk.gc.m.g(r2, r3, r4, r5, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.wp.j_():void");
    }

    @Override // com.bytedance.msdk.api.a.z.gz.z
    public void dl() {
        com.bytedance.msdk.api.a.z.gz.z zVar;
        com.bytedance.msdk.api.a.z.gz.z zVar2;
        if (ls.z()) {
            if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 2, 1, 0, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 2, 0, 0, (String) null);
            }
            if (uf()) {
                return;
            }
            sy();
            if (iq() || (zVar2 = this.ls) == null) {
                return;
            }
            zVar2.dl();
            return;
        }
        sy();
        if (iq() || (zVar = this.ls) == null) {
            return;
        }
        zVar.dl();
    }

    @Override // com.bytedance.msdk.api.a.z.gz.z
    public void a() {
        if (ls.z()) {
            if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 1, 1, 0, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 1, 0, 0, (String) null);
            }
            if (uf()) {
                return;
            }
            sy();
            if (this.q.z()) {
                this.q.gc();
            }
            com.bytedance.msdk.api.a.z.gz.z zVar = this.ls;
            if (zVar != null) {
                zVar.a();
                return;
            }
            return;
        }
        sy();
        if (this.q.z()) {
            this.q.gc();
        }
        com.bytedance.msdk.api.a.z.gz.z zVar2 = this.ls;
        if (zVar2 != null) {
            zVar2.a();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.gz.z
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
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, (com.bytedance.msdk.api.z) null, 2, 0, strG, jCurrentTimeMillis);
        com.bytedance.msdk.api.a.z.gz.z zVar = this.ls;
        if (zVar != null) {
            zVar.gc();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.gz.z
    public void z(com.bytedance.msdk.api.dl.z zVar) {
        if (ls.z()) {
            if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 4, 1, 0, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 4, 0, 0, ls.m() ? js.z() : null);
            }
            if (uf()) {
                return;
            }
            com.bytedance.msdk.core.admanager.reward.rewardagain.dl dlVar = this.zw;
            if (dlVar != null) {
                dlVar.g();
            }
            if (this.q.z()) {
                this.q.a();
                return;
            }
            com.bytedance.msdk.api.a.z.gz.z zVar2 = this.ls;
            if (zVar2 != null) {
                zVar2.z(z(this.m, zVar, this.f428a));
                z((com.bytedance.msdk.api.dl.z) null, 0);
                return;
            }
            return;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.dl dlVar2 = this.zw;
        if (dlVar2 != null) {
            dlVar2.g();
        }
        if (this.q.z()) {
            this.q.a();
            return;
        }
        com.bytedance.msdk.api.a.z.gz.z zVar3 = this.ls;
        if (zVar3 != null) {
            zVar3.z(z(this.m, zVar, this.f428a));
            z((com.bytedance.msdk.api.dl.z) null, 0);
        }
    }

    @Override // com.bytedance.msdk.api.a.z.gz.z
    public void m() {
        if (ls.z()) {
            if (this.f428a != null && MediationConstant.ADN_PANGLE.equals(this.f428a.zx())) {
                if (!ls.g()) {
                    com.bytedance.msdk.gc.m.z(this.f428a, this.m, 3, 1, 0, js.z());
                    return;
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 3, 0, 0, (String) null);
            }
            if (uf()) {
                return;
            }
            sy();
            if (this.q.z()) {
                this.q.g();
            }
            com.bytedance.msdk.api.a.z.gz.z zVar = this.ls;
            if (zVar != null) {
                zVar.m();
                return;
            }
            return;
        }
        sy();
        if (this.q.z()) {
            this.q.g();
        }
        com.bytedance.msdk.api.a.z.gz.z zVar2 = this.ls;
        if (zVar2 != null) {
            zVar2.m();
        }
    }
}
