package com.bytedance.msdk.dl.dl.g.z.g;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g {
    public m(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        if (gVar2 == null) {
            z(new com.bytedance.msdk.api.z("load ad fail adSlot is null"));
        } else {
            new z().z(context.getApplicationContext(), gVar2, gVar, this);
        }
    }

    class z extends com.bytedance.msdk.g.dl {
        com.bytedance.sdk.openadsdk.tb.z.g.z.a fo = new com.bytedance.sdk.openadsdk.tb.z.g.z.a(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.m.z.1
            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
            public void z(int i, String str) {
                z.this.wp = false;
                z.this.pf.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
            public void z(com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar) {
                if (kbVar == null) {
                    z.this.pf.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用"));
                    return;
                }
                z.this.kb = kbVar;
                z.this.e(true);
                z zVar = z.this;
                zVar.wp(zVar.kb.z());
                Map<String, Object> mapG = z.this.kb.g();
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleFullVideoLoader WaterfallPangleFullVideoLoader extraInfo :".concat(String.valueOf(mapG)));
                if (z.this.v.z() && mapG != null) {
                    double dZ = com.bytedance.msdk.z.dl.g.z(mapG.get("price"));
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", com.bytedance.msdk.z.gc.gc.g(z.this.v.g(), z.this.v.wp()) + "pangle 全屏 返回的 cpm价格：" + dZ);
                    z zVar2 = z.this;
                    if (dZ <= 0.0d) {
                        dZ = 0.0d;
                    }
                    zVar2.z(dZ);
                }
                if (mapG != null) {
                    z.this.a(mapG);
                    Object obj = mapG.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        z.this.i = ((Boolean) obj).booleanValue();
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "pangle 全屏 返回的adnPreload：" + z.this.i);
                    }
                }
                Function function = null;
                z.this.kb.z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.m.z.1.1
                    @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
                    public void z() {
                        if (z.this.dl != null) {
                            z.this.dl.z();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
                    public void z(long j, long j2, String str, String str2) {
                        if (z.this.dl != null) {
                            z.this.dl.z(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
                    public void g(long j, long j2, String str, String str2) {
                        if (z.this.dl != null) {
                            z.this.dl.z(j, j2, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
                    public void dl(long j, long j2, String str, String str2) {
                        if (z.this.dl != null) {
                            z.this.dl.g(j, j2, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
                    public void z(long j, String str, String str2) {
                        if (z.this.dl != null) {
                            z.this.dl.z(j, str, str2);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
                    public void z(String str, String str2) {
                        if (z.this.dl != null) {
                            z.this.dl.z(str, str2);
                        }
                    }
                });
                z.this.kb.z(new com.bytedance.sdk.openadsdk.zw.z.g.z.z(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.m.z.1.2
                    @Override // com.bytedance.sdk.openadsdk.zw.z.g.z.z
                    public void z() {
                        if (z.this.e instanceof com.bytedance.msdk.z.g.g) {
                            z.this.qz().g_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zw.z.g.z.z
                    public void g() {
                        if (z.this.e instanceof com.bytedance.msdk.z.g.g) {
                            z.this.qz().h_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zw.z.g.z.z
                    public void dl() {
                        if (z.this.e instanceof com.bytedance.msdk.z.g.g) {
                            z.this.qz().dl();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zw.z.g.z.z
                    public void a() {
                        if (z.this.e instanceof com.bytedance.msdk.z.g.g) {
                            z.this.qz().a();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.zw.z.g.z.z
                    public void gc() {
                        if (z.this.e instanceof com.bytedance.msdk.z.g.g) {
                            z.this.qz().m();
                        }
                    }
                });
                z.this.wp = true;
                z.this.pf.z(z.this);
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
            public void z() {
                com.bytedance.msdk.z.gc.dl.z("TMe", "pangle full cached");
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.a
            public void g(com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar) {
                com.bytedance.msdk.z.gc.dl.z("TMe", "pangle full cached 2");
                z.this.wp = true;
                z.this.pf.z(z.this, (com.bytedance.msdk.api.z) null);
            }
        };
        private boolean i;
        private com.bytedance.sdk.openadsdk.ls.dl.g.kb kb;
        private com.bytedance.msdk.api.z.g ls;
        private com.bytedance.msdk.dl.dl.g.z.g pf;
        private com.bytedance.msdk.dl.m.g.g v;
        private boolean wp;

        @Override // com.bytedance.msdk.g.dl
        public boolean bb() {
            return true;
        }

        z() {
        }

        public void z(Context context, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2, com.bytedance.msdk.dl.dl.g.z.g gVar3) {
            this.v = gVar2;
            this.pf = gVar3;
            this.ls = gVar;
            lq lqVarZ = m.this.z(context);
            if (lqVarZ == null) {
                return;
            }
            g.z zVarZ = com.bytedance.msdk.z.dl.g.z(this.ls, this.v, false);
            zVarZ.z(1080).g(1920).a(this.ls.mc());
            lqVarZ.z(zVarZ.z(), this.fo);
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, Object obj, String str) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleFullVideoLoader WaterfallPangleFullVideoLoader showAd ritScenes:" + obj + "  ritScenesContent: " + str + "  mTTFullScreenVideoAd:" + this.kb + "  activity:" + activity);
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar != null) {
                if (obj != null) {
                    kbVar.z(activity, obj, str);
                } else {
                    kbVar.z(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapG;
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar == null || (mapG = kbVar.g()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapG.get("coupon"));
            map.put("live_room", mapG.get("live_room"));
            map.put("product", mapG.get("product"));
            dl(map);
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public Integer m() {
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar != null && kbVar.a() > System.currentTimeMillis()) {
                return 2;
            }
            return 3;
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean xl() {
            return this.i;
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar != null) {
                kbVar.z((com.bytedance.sdk.openadsdk.zw.z.g.z.z) null);
                this.kb.z((com.bytedance.sdk.openadsdk.ls.dl.z.dl) null);
                this.kb.z((com.bytedance.sdk.openadsdk.ls.dl.z.g) null);
                this.kb = null;
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.kb == null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.z.g.g qz() {
            return (com.bytedance.msdk.z.g.g) this.e;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar != null) {
                return com.bytedance.msdk.z.dl.g.z(kbVar.g());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar != null) {
                return com.bytedance.msdk.z.dl.g.g(kbVar.g());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            return kbVar != null ? com.bytedance.msdk.z.dl.g.dl(kbVar.g()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.sdk.openadsdk.ls.dl.g.kb kbVar = this.kb;
            if (kbVar != null) {
                kbVar.z(gVar);
            }
        }
    }
}
