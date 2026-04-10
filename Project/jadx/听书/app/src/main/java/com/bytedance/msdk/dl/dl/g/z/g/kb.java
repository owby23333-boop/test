package com.bytedance.msdk.dl.dl.g.z.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends g {
    private com.bytedance.msdk.dl.m.g.g dl;
    private com.bytedance.msdk.api.z.g g;

    public kb(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        this.g = gVar2;
        this.dl = gVar;
        if (gVar2 == null) {
            dl();
        } else {
            new z(map).z(context != null ? context.getApplicationContext() : com.bytedance.msdk.core.g.getContext());
        }
    }

    public void dl() {
        z(new com.bytedance.msdk.api.z("load ad fail adSlot is null"));
    }

    class z extends com.bytedance.msdk.g.dl {
        com.bytedance.sdk.openadsdk.tb.z.g.z.e fo = new AnonymousClass1(null);
        private Map<String, Object> i;
        private pf kb;
        private boolean wp;

        @Override // com.bytedance.msdk.g.dl
        public boolean bb() {
            return true;
        }

        z(Map<String, Object> map) {
            this.i = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.a.z.gz.z qz() {
            return (com.bytedance.msdk.api.a.z.gz.z) this.gz;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.bytedance.msdk.api.a.z.gz.z aq() {
            return (com.bytedance.msdk.api.a.z.gz.z) this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void z(android.content.Context r9) {
            /*
                r8 = this;
                com.bytedance.msdk.dl.dl.g.z.g.kb r0 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.sdk.openadsdk.core.lq r9 = r0.z(r9)
                if (r9 != 0) goto L9
                return
            L9:
                com.bytedance.msdk.dl.dl.g.z.g.kb r0 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.api.z.g r0 = com.bytedance.msdk.dl.dl.g.z.g.kb.z(r0)
                java.util.Map r0 = r0.oq()
                if (r0 == 0) goto L28
                java.lang.String r1 = "pangle"
                java.lang.Object r0 = r0.get(r1)
                boolean r1 = r0 instanceof java.lang.String
                if (r1 == 0) goto L28
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L28
                goto L2a
            L28:
                java.lang.String r0 = ""
            L2a:
                com.bytedance.msdk.dl.dl.g.z.g.kb r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.api.z.g r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.z(r1)
                com.bytedance.msdk.dl.dl.g.z.g.kb r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.dl.m.g.g r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.g(r1)
                java.lang.String r3 = r1.wp()
                com.bytedance.msdk.dl.dl.g.z.g.kb r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.dl.m.g.g r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.g(r1)
                java.lang.String r4 = r1.ls()
                com.bytedance.msdk.dl.dl.g.z.g.kb r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.dl.m.g.g r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.g(r1)
                java.lang.String r5 = r1.p()
                com.bytedance.msdk.dl.dl.g.z.g.kb r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.dl.m.g.g r1 = com.bytedance.msdk.dl.dl.g.z.g.kb.g(r1)
                java.lang.String r6 = r1.uf()
                r7 = 0
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r1 = com.bytedance.msdk.z.dl.g.z(r2, r3, r4, r5, r6, r7)
                com.bytedance.msdk.dl.dl.g.z.g.kb r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.api.z.g r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.z(r2)
                java.lang.String r2 = r2.lq()
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r2 = r1.m(r2)
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r0 = r2.gc(r0)
                com.bytedance.msdk.dl.dl.g.z.g.kb r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.api.z.g r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.z(r2)
                java.lang.String r2 = r2.h()
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r0 = r0.uy(r2)
                com.bytedance.msdk.dl.dl.g.z.g.kb r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.api.z.g r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.z(r2)
                int r2 = r2.gk()
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r0 = r0.gz(r2)
                r2 = 1080(0x438, float:1.513E-42)
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r0 = r0.z(r2)
                r2 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.ls.dl.dl.g$z r0 = r0.g(r2)
                com.bytedance.msdk.dl.dl.g.z.g.kb r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.this
                com.bytedance.msdk.api.z.g r2 = com.bytedance.msdk.dl.dl.g.z.g.kb.z(r2)
                int r2 = r2.mc()
                r0.a(r2)
                com.bytedance.sdk.openadsdk.ls.dl.dl.g r0 = r1.z()
                com.bytedance.sdk.openadsdk.tb.z.g.z.e r1 = r8.fo
                r9.z(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.dl.g.z.g.kb.z.z(android.content.Context):void");
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            pf pfVar = this.kb;
            if (pfVar != null) {
                pfVar.z((com.bytedance.sdk.openadsdk.ls.dl.z.dl) null);
                this.kb.z((com.bytedance.sdk.openadsdk.sy.z.g.z.z) null);
                this.kb.z((com.bytedance.sdk.openadsdk.ls.dl.z.g) null);
                this.kb = null;
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.kb == null;
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean xl() {
            return this.wp;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            pf pfVar = this.kb;
            return pfVar != null ? com.bytedance.msdk.z.dl.g.dl(pfVar.g()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public Integer m() {
            pf pfVar = this.kb;
            if (pfVar != null && pfVar.a() > System.currentTimeMillis()) {
                return 2;
            }
            return 3;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, Object obj, String str) {
            pf pfVar = this.kb;
            if (pfVar != null) {
                if (obj != null) {
                    pfVar.z(activity, obj, str);
                } else {
                    pfVar.z(activity);
                }
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            pf pfVar = this.kb;
            if (pfVar != null) {
                dl(pfVar.g());
            }
            return super.h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean mk() {
            return !"0.0".equals(kb.this.z(MediationConstant.ADN_PANGLE)) && "4.4.0.0".compareTo(kb.this.z(MediationConstant.ADN_PANGLE)) > 0;
        }

        /* JADX INFO: renamed from: com.bytedance.msdk.dl.dl.g.z.g.kb$z$1, reason: invalid class name */
        class AnonymousClass1 extends com.bytedance.sdk.openadsdk.tb.z.g.z.e {
            AnonymousClass1(Function function) {
                super(function);
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
            public void z(int i, String str) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward_onError code:" + i + "  message:" + str);
                kb.this.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
            public void z(pf pfVar) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (pfVar != null) {
                    z.this.kb = pfVar;
                    z.this.e(true);
                    z zVar = z.this;
                    zVar.wp(zVar.kb.z());
                    Map<String, Object> mapG = z.this.kb.g();
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleRewardLoader WaterfallPangleRewardLoader extraInfo :".concat(String.valueOf(mapG)));
                    if (kb.this.dl.z() && mapG != null) {
                        double dZ = com.bytedance.msdk.z.dl.g.z(mapG.get("price"));
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", com.bytedance.msdk.z.gc.gc.g(kb.this.dl.g(), kb.this.dl.wp()) + "pangle reward 返回的 cpm价格：" + dZ);
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
                            z.this.wp = ((Boolean) obj).booleanValue();
                            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "pangle 激励 返回的adnPreload：" + z.this.wp);
                        }
                    }
                    Function function = null;
                    z.this.kb.z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.1
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
                    z.this.kb.g(new com.bytedance.sdk.openadsdk.sy.z.g.z.z(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.2
                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void z() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onAdShow-----------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void g() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onAdVideoBarClick---------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().j_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void dl() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onAdClose-----------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().dl();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void a() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onVideoComplete----------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().a();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void gc() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onVideoError-----------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().gc();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        @Deprecated
                        public void z(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (z.this.mk()) {
                                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                                if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                    z.this.qz().z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.2.1
                                        @Override // com.bytedance.msdk.api.dl.z
                                        public boolean z() {
                                            return z;
                                        }

                                        @Override // com.bytedance.msdk.api.dl.z
                                        public float g() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (kb.this.g != null) {
                                                return kb.this.g.gk();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.bytedance.msdk.api.dl.z
                                        public String dl() {
                                            if (TextUtils.isEmpty(str)) {
                                                return kb.this.g != null ? kb.this.g.h() : "";
                                            }
                                            return str;
                                        }

                                        @Override // com.bytedance.msdk.api.dl.z
                                        public Map<String, Object> a() {
                                            HashMap map = new HashMap();
                                            map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(i2));
                                            map.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return map;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void z(final boolean z, final int i, final Bundle bundle) {
                            if (z.this.mk()) {
                                return;
                            }
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.2.2
                                    @Override // com.bytedance.msdk.api.dl.z
                                    public boolean z() {
                                        return z;
                                    }

                                    @Override // com.bytedance.msdk.api.dl.z
                                    public float g() {
                                        float f = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (kb.this.g != null) {
                                            return kb.this.g.gk();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.dl.z
                                    public String dl() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                        return !TextUtils.isEmpty(string) ? string : kb.this.g != null ? kb.this.g.h() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.dl.z
                                    public Map<String, Object> a() {
                                        HashMap map = new HashMap();
                                        map.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                                        return map;
                                    }
                                });
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void m() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onSkippedVideo-------------2");
                            if (z.this.gz instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.qz().m();
                            }
                        }
                    });
                    z.this.kb.z(new com.bytedance.sdk.openadsdk.sy.z.g.z.z(function) { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.3
                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void z() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onAdShow");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().i_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void g() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().j_();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void dl() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onAdClose");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().dl();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void a() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onVideoComplete");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().a();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void gc() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onVideoError");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().gc();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        @Deprecated
                        public void z(final boolean z, final int i, final String str, final int i2, final String str2) {
                            if (z.this.mk()) {
                                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                                if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                    z.this.aq().z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.3.1
                                        @Override // com.bytedance.msdk.api.dl.z
                                        public boolean z() {
                                            return z;
                                        }

                                        @Override // com.bytedance.msdk.api.dl.z
                                        public float g() {
                                            int i3 = i;
                                            if (i3 >= 0) {
                                                return i3;
                                            }
                                            if (kb.this.g != null) {
                                                return kb.this.g.gk();
                                            }
                                            return 0.0f;
                                        }

                                        @Override // com.bytedance.msdk.api.dl.z
                                        public String dl() {
                                            if (TextUtils.isEmpty(str)) {
                                                return kb.this.g != null ? kb.this.g.h() : "";
                                            }
                                            return str;
                                        }

                                        @Override // com.bytedance.msdk.api.dl.z
                                        public Map<String, Object> a() {
                                            HashMap map = new HashMap();
                                            map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(i2));
                                            map.put(MediationConstant.KEY_ERROR_MSG, str2);
                                            return map;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void z(final boolean z, final int i, final Bundle bundle) {
                            if (z.this.mk()) {
                                return;
                            }
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().z(new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.dl.dl.g.z.g.kb.z.1.3.2
                                    @Override // com.bytedance.msdk.api.dl.z
                                    public boolean z() {
                                        return z;
                                    }

                                    @Override // com.bytedance.msdk.api.dl.z
                                    public float g() {
                                        float f = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                        if (f >= 0.0f) {
                                            return f;
                                        }
                                        if (kb.this.g != null) {
                                            return kb.this.g.gk();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.dl.z
                                    public String dl() {
                                        Bundle bundle2 = bundle;
                                        String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                        return !TextUtils.isEmpty(string) ? string : kb.this.g != null ? kb.this.g.h() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.dl.z
                                    public Map<String, Object> a() {
                                        HashMap map = new HashMap();
                                        map.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                                        map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                                        return map;
                                    }
                                });
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.sy.z.g.z.z
                        public void m() {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward:onSkippedVideo");
                            if (z.this.e instanceof com.bytedance.msdk.api.a.z.gz.z) {
                                z.this.aq().m();
                            }
                        }
                    });
                    kb.this.z(z.this);
                    return;
                }
                kb.this.z(new com.bytedance.msdk.api.z("请求成功，但无广告可用"));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
            public void z() {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.e
            public void g(pf pfVar) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "pangle_reward_onRewardVideoCached 2");
                kb.this.z(z.this, (com.bytedance.msdk.api.z) null);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            pf pfVar = this.kb;
            if (pfVar != null) {
                return com.bytedance.msdk.z.dl.g.z(pfVar.g());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            pf pfVar = this.kb;
            if (pfVar != null) {
                return com.bytedance.msdk.z.dl.g.g(pfVar.g());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Object obj) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleRewardLoader WaterfallPangleRewardLoader setRewardAdPlayAgainController rewardAdPlayAgainController:" + obj + "  mTTRewardVideoAd: " + this.kb);
            pf pfVar = this.kb;
            if (pfVar == null || !(obj instanceof com.bytedance.sdk.openadsdk.sy.z.g.z.g)) {
                return;
            }
            pfVar.z((com.bytedance.sdk.openadsdk.sy.z.g.z.g) obj);
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "PangleRewardLoader WaterfallPangleRewardLoader setAdInteractionListener pluginTTAdInteractionListener:" + gVar + "  mTTRewardVideoAd: " + this.kb);
            pf pfVar = this.kb;
            if (pfVar != null) {
                pfVar.z(gVar);
            }
        }
    }
}
