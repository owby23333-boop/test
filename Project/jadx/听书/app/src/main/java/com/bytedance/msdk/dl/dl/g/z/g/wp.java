package com.bytedance.msdk.dl.dl.g.z.g;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends g {
    private int g;

    public wp(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
        this.g = 3000;
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        if (gVar2 == null) {
            z(new com.bytedance.msdk.api.z("load ad fail adSlot is null"));
        } else {
            new z(map).z(context != null ? context.getApplicationContext() : com.bytedance.msdk.core.g.getContext(), gVar2, gVar, this);
        }
    }

    class z extends com.bytedance.msdk.g.dl {
        private com.bytedance.msdk.dl.dl.g.z.g i;
        private Map<String, Object> kb;
        private com.bytedance.sdk.openadsdk.ls.dl.g.g uy;
        private com.bytedance.msdk.api.z.g v;
        private com.bytedance.msdk.dl.m.g.g wp;

        z(Map<String, Object> map) {
            this.kb = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.z.g.gc qz() {
            return (com.bytedance.msdk.z.g.gc) this.e;
        }

        void z(Context context, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2, com.bytedance.msdk.dl.dl.g.z.g gVar3) {
            this.wp = gVar2;
            this.i = gVar3;
            this.v = gVar;
            lq lqVarZ = wp.this.z(context);
            if (lqVarZ == null) {
                return;
            }
            Map<String, Object> map = this.kb;
            if (map == null) {
                wp.this.g = 3000;
            } else {
                wp.this.g = map.get("ad_load_timeout") != null ? ((Integer) this.kb.get("ad_load_timeout")).intValue() : 3000;
            }
            g.z zVarZ = com.bytedance.msdk.z.dl.g.z(this.v, this.wp, false);
            zVarZ.z(this.v.uf()).g(this.v.sy()).z(this.v.v()).g(this.v.pf());
            z(lqVarZ, zVarZ.z());
        }

        private void z(lq lqVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
            com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar = new com.bytedance.sdk.openadsdk.tb.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.wp.z.1
                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
                public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar2) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashLoadSuccess 111");
                    if (gVar2 == null) {
                        z.this.i.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "渲染成功但广告是空"));
                        return;
                    }
                    z.this.uy = gVar2;
                    z.this.e(true);
                    z zVar2 = z.this;
                    zVar2.wp(zVar2.uy.a());
                    Map<String, Object> mapGc = z.this.uy.gc();
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleSplashLoader WaterfallPangleSplashLoader extraInfo :".concat(String.valueOf(mapGc)));
                    if (mapGc != null) {
                        z.this.a(mapGc);
                    }
                    if (z.this.wp.z() && mapGc != null) {
                        double dZ = com.bytedance.msdk.z.dl.g.z(mapGc.get("price"));
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", com.bytedance.msdk.z.gc.gc.g(z.this.wp.g(), z.this.wp.wp()) + "pangle Splash 返回的 cpm价格：" + dZ);
                        z zVar3 = z.this;
                        if (dZ <= 0.0d) {
                            dZ = 0.0d;
                        }
                        zVar3.z(dZ);
                    }
                    Function function = null;
                    z.this.uy.z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.wp.z.1.1
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
                    z.this.uy.z(new com.bytedance.sdk.openadsdk.a.z.g.z.z(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.wp.z.1.2
                        @Override // com.bytedance.sdk.openadsdk.a.z.g.z.z
                        public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar3) {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashAdShow");
                            if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                z.this.qz().gc();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.z.g.z.z
                        public void g(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar3) {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashAdClick");
                            if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                z.this.qz().a();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.z.g.z.z
                        public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar3, int i) {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashAdClose closeType = ".concat(String.valueOf(i)));
                            if (i == 1 || i == 3) {
                                if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                    z.this.qz().z(i);
                                }
                            } else if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                z.this.qz().g(i);
                            }
                        }
                    });
                    z.this.uy.z(new com.bytedance.sdk.openadsdk.a.z.g.z.g(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.wp.z.1.3
                        @Override // com.bytedance.sdk.openadsdk.a.z.g.z.g
                        public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar3) {
                            if (gVar3 != null) {
                                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + gVar3.dl());
                            }
                            if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                z.this.qz();
                            }
                            if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                z.this.qz().k_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.z.g.z.g
                        public void z() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashCardClick");
                            try {
                                if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                    z.this.qz().dl();
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.wp.z(th);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.a.z.g.z.g
                        public void g() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashCardClose");
                            if (z.this.e instanceof com.bytedance.msdk.z.g.gc) {
                                z.this.qz().l_();
                            }
                        }
                    });
                    z.this.i.z(z.this);
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
                public void z(com.bytedance.sdk.openadsdk.ls.dl.g.z zVar2) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashLoadFail");
                    if (zVar2 != null) {
                        z.this.i.z(new com.bytedance.msdk.api.z(zVar2.z(), zVar2.g()));
                    } else {
                        z.this.i.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
                public void g(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar2) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashRenderSuccess");
                }

                @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.z
                public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar2, com.bytedance.sdk.openadsdk.ls.dl.g.z zVar2) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "new api onSplashRenderFail");
                    if (zVar2 != null) {
                        z.this.i.z(new com.bytedance.msdk.api.z(zVar2.z(), zVar2.g()));
                    } else {
                        z.this.i.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }
            };
            if (lqVar != null) {
                lqVar.z(gVar, zVar, wp.this.g);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(ViewGroup viewGroup) {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar == null || viewGroup == null) {
                return;
            }
            gVar.z(viewGroup);
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(ViewGroup viewGroup, Activity activity) {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar != null) {
                gVar.z(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapGc;
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar != null && (mapGc = gVar.gc()) != null) {
                HashMap map = new HashMap();
                map.put("coupon", mapGc.get("coupon"));
                map.put("live_room", mapGc.get("live_room"));
                map.put("product", mapGc.get("product"));
                dl(map);
            }
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar != null) {
                gVar.z((com.bytedance.sdk.openadsdk.a.z.g.z.z) null);
                this.uy.z((com.bytedance.sdk.openadsdk.ls.dl.z.dl) null);
                this.uy.z((com.bytedance.sdk.openadsdk.a.z.g.z.g) null);
                this.uy = null;
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.uy == null;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar != null) {
                return com.bytedance.msdk.z.dl.g.z(gVar.gc());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar != null) {
                return com.bytedance.msdk.z.dl.g.g(gVar.gc());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            return gVar != null ? com.bytedance.msdk.z.dl.g.dl(gVar.gc()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar2 = this.uy;
            if (gVar2 != null) {
                gVar2.z(gVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void gw() {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleSplashLoader hideSkipButton   WaterfallPangleSplashLoader  mCSJSplashAd:" + this.uy);
            com.bytedance.sdk.openadsdk.ls.dl.g.g gVar = this.uy;
            if (gVar != null) {
                gVar.m();
            }
        }
    }
}
