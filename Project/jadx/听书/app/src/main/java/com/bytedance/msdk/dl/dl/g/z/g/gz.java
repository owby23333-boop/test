package com.bytedance.msdk.dl.dl.g.z.g;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    public void z(final boolean z2, lq lqVar, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.msdk.dl.dl.g.z.g gVar2) {
        if (lqVar == null || gVar2 == null || gVar == null) {
            return;
        }
        lqVar.z(gVar, new com.bytedance.sdk.openadsdk.tb.z.g.z.dl(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.1
            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.dl
            public void z(int i, String str) {
                gVar2.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.dl
            public void z(List<com.bytedance.sdk.openadsdk.ls.dl.g.uy> list) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + gVar.kb());
                if (list == null || list.isEmpty()) {
                    gVar2.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                if (gVar.kb()) {
                    gz.this.z(list, gVar2, z2);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.ls.dl.g.uy> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new z(it.next(), z2, false));
                }
                gVar2.z(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<com.bytedance.sdk.openadsdk.ls.dl.g.uy> list, final com.bytedance.msdk.dl.dl.g.z.g gVar, final boolean z2) {
        int size = list.size();
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_adNum:".concat(String.valueOf(size)));
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar : list) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final int i = size;
            uyVar.z(new com.bytedance.sdk.openadsdk.io.z.g.z.dl(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.2
                @Override // com.bytedance.sdk.openadsdk.io.z.g.z.dl
                public void z(View view, float f, float f2, boolean z3) {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z3 + " duration:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    arrayList.add(new z(uyVar, z2, z3));
                    if (atomicInteger.incrementAndGet() != i || gVar == null) {
                        return;
                    }
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    gVar.z(arrayList);
                }
            });
            uyVar.zw();
            size = size;
        }
    }

    private static class z extends com.bytedance.msdk.g.dl {
        private int i;
        private com.bytedance.sdk.openadsdk.ls.dl.g.uy wp;
        com.bytedance.sdk.openadsdk.io.z.g.z.z fo = new com.bytedance.sdk.openadsdk.io.z.g.z.z(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.z.2
            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(View view, i iVar) {
                if (z.this.z != null) {
                    z.this.z.z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void g(View view, i iVar) {
                if (z.this.z != null) {
                    z.this.z.z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(i iVar) {
                if (z.this.z != null) {
                    z.this.z.z();
                }
            }
        };
        com.bytedance.sdk.openadsdk.iq.z.g.z.z uy = new com.bytedance.sdk.openadsdk.iq.z.g.z.z(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.z.3
            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void z(com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar) {
                if (z.this.g != null) {
                    z.this.g.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void z(int i, int i2) {
                if (z.this.g != null) {
                    z.this.g.z(new com.bytedance.msdk.api.z(i, "Android MediaPlay Error Code :".concat(String.valueOf(i2))));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void g(com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar) {
                if (z.this.g != null) {
                    z.this.g.g();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void dl(com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar) {
                if (z.this.g != null) {
                    z.this.g.dl();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void a(com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar) {
                if (z.this.g != null) {
                    z.this.g.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void z(long j, long j2) {
                if (z.this.g != null) {
                    z.this.g.z(j, j2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.z
            public void gc(com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar) {
                if (z.this.g != null) {
                    z.this.g.gc();
                }
            }
        };
        com.bytedance.sdk.openadsdk.ls.dl.z.dl kb = new com.bytedance.sdk.openadsdk.ls.dl.z.dl(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.z.4
            @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
            public void z() {
                z.this.i = 0;
                if (z.this.dl != null) {
                    z.this.dl.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
            public void z(long j, long j2, String str, String str2) {
                z.this.i = 2;
                if (z.this.dl != null) {
                    z.this.dl.z(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
            public void g(long j, long j2, String str, String str2) {
                z.this.i = 3;
                if (z.this.dl != null) {
                    z.this.dl.z(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
            public void dl(long j, long j2, String str, String str2) {
                z.this.i = 4;
                if (z.this.dl != null) {
                    z.this.dl.g(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
            public void z(long j, String str, String str2) {
                z.this.i = 5;
                if (z.this.dl != null) {
                    z.this.dl.z(j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ls.dl.z.dl
            public void z(String str, String str2) {
                z.this.i = 6;
                if (z.this.dl != null) {
                    z.this.dl.z(str, str2);
                }
            }
        };

        @Override // com.bytedance.msdk.g.dl
        public boolean tb() {
            return true;
        }

        z(com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar, boolean z, boolean z2) {
            Map<String, Object> mapIq;
            List<com.bytedance.sdk.openadsdk.ls.dl.g.wp> listPf;
            this.wp = uyVar;
            com.bytedance.sdk.openadsdk.ls.dl.g.dl dlVarJs = uyVar.js();
            if (dlVarJs != null) {
                iq(dlVarJs.z());
                zw(dlVarJs.dl());
                uf(dlVarJs.a());
                sy(dlVarJs.g());
                HashMap map = new HashMap();
                Map<String, String> mapGc = dlVarJs.gc();
                if (mapGc != null && mapGc.size() > 0) {
                    map.putAll(mapGc);
                }
                gc(map);
                if (com.bytedance.msdk.z.dl.g.z("5.1.0.0")) {
                    io(dlVarJs.m());
                }
                if (com.bytedance.msdk.z.dl.g.z("5.4.0.3")) {
                    wp(dlVarJs.e());
                }
                if (com.bytedance.msdk.z.dl.g.z("6.8.1.6")) {
                    uy(dlVarJs.gz());
                }
                kb(dlVarJs.fo());
            }
            g(z2 ? 1 : 0);
            x(uyVar.e());
            lq(uyVar.gz());
            h(uyVar.fo());
            hh(uyVar.v() != null ? uyVar.v().dl() : null);
            kb(uyVar.p());
            wp(uyVar.ls());
            mc(uyVar.i());
            a(uyVar.uy());
            gz(uyVar.ls() == 4);
            e(false);
            if (uyVar.p() == 16 || uyVar.p() == 3 || uyVar.p() == 2 || uyVar.p() == 131) {
                List<com.bytedance.sdk.openadsdk.ls.dl.g.wp> listPf2 = uyVar.pf();
                if (listPf2 != null && !listPf2.isEmpty() && listPf2.get(0) != null) {
                    com.bytedance.sdk.openadsdk.ls.dl.g.wp wpVar = listPf2.get(0);
                    l(wpVar.dl());
                    js(wpVar.z());
                    fv(wpVar.g());
                }
            } else if (uyVar.p() == 4) {
                List<com.bytedance.sdk.openadsdk.ls.dl.g.wp> listPf3 = uyVar.pf();
                if (listPf3 != null && listPf3.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.bytedance.sdk.openadsdk.ls.dl.g.wp> it = listPf3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().dl());
                    }
                    z((List<String>) arrayList);
                }
            } else {
                com.bytedance.sdk.openadsdk.ls.dl.g.wp wpVarGc = uyVar.gc();
                if ((wpVarGc == null || TextUtils.isEmpty(wpVarGc.dl())) && (listPf = uyVar.pf()) != null && !listPf.isEmpty() && listPf.get(0) != null) {
                    wpVarGc = listPf.get(0);
                }
                if (wpVarGc != null) {
                    l(wpVarGc.dl());
                    js(wpVarGc.z());
                    fv(wpVarGc.g());
                }
            }
            if (z && (mapIq = uyVar.iq()) != null) {
                double dZ = com.bytedance.msdk.z.dl.g.z(mapIq.get("price"));
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(dZ)));
                z(dZ <= 0.0d ? 0.0d : dZ);
            }
            this.wp.z(this.uy);
            this.wp.z(this.kb);
            new HashMap();
            z(MediationConstant.EXTRA_ADID, Long.valueOf(gm()));
            z(MediationConstant.EXTRA_CID, Long.valueOf(pd()));
            z("duration", Double.valueOf(this.wp.z()));
            Map<String, Object> mapIq2 = this.wp.iq();
            if (mapIq2 != null) {
                a(mapIq2);
                z(MediationConstant.EXTRA_LOG_EXTRA, mapIq2.toString());
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapIq;
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar == null || (mapIq = uyVar.iq()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapIq.get("coupon"));
            map.put("live_room", mapIq.get("live_room"));
            map.put("product", mapIq.get("product"));
            dl(map);
            return super.h();
        }

        private void g(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                uyVar.z(this.kb);
                try {
                    this.wp.z(new com.bytedance.sdk.openadsdk.iq.z.g.z.g(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.z.1
                        @Override // com.bytedance.sdk.openadsdk.iq.z.g.z.g
                        public void z(int i) {
                            if (z.this.gc != null) {
                                z.this.gc.z(i);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
                this.wp.z(viewGroup, list, list2, list3, list4, view, this.fo);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.z(viewGroup, list, list2, list3, list4, view);
            g(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
            this.wp.z(gVar);
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar2;
            View viewQ;
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar3;
            View viewFindViewById;
            super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
            g(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar4 = this.wp;
            if (uyVar4 != null && uyVar4.m() != null && uyVar != null && (viewFindViewById = viewGroup.findViewById(uyVar.wp)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.wp.m());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.z.gc.e.g(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.z.gc.e.g(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.wp.m());
                }
            }
            if ((ti() && (uyVar3 = this.wp) != null && uyVar3.g() != null && !TextUtils.isEmpty(this.wp.g().z())) || uyVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(uyVar.e)) == null || (uyVar2 = this.wp) == null || (viewQ = uyVar2.q()) == null) {
                return;
            }
            g(viewQ);
            frameLayout.removeAllViews();
            frameLayout.addView(viewQ, -1, -1);
        }

        @Override // com.bytedance.msdk.g.dl
        public int jz() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.dl();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.g.dl
        public int oz() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.a();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.g.dl
        public View uy() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.q();
            }
            return null;
        }

        @Override // com.bytedance.msdk.g.dl
        public String e() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar;
            if (!ti() || (uyVar = this.wp) == null || uyVar.g() == null) {
                return null;
            }
            return this.wp.g().z();
        }

        @Override // com.bytedance.msdk.g.dl
        public Bitmap mj() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.m();
            }
            return super.mj();
        }

        @Override // com.bytedance.msdk.g.dl
        public double no() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.z();
            }
            return super.no();
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.wp c() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.gc();
            }
            return super.c();
        }

        @Override // com.bytedance.msdk.g.dl
        public int vy() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return uyVar.kb();
            }
            return super.vy();
        }

        @Override // com.bytedance.msdk.g.dl
        public void g(Activity activity) {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                uyVar.g(activity);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                uyVar.z((com.bytedance.sdk.openadsdk.iq.z.g.z.z) null);
                this.wp.io();
                this.wp = null;
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.wp == null;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return com.bytedance.msdk.z.dl.g.dl(uyVar.iq());
            }
            return null;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar == null || uyVar.tb() == null || this.i != 2) {
                return;
            }
            this.wp.tb().z();
        }

        @Override // com.bytedance.msdk.g.dl
        public void g() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar == null || uyVar.tb() == null || this.i != 3) {
                return;
            }
            this.wp.tb().z();
        }

        @Override // com.bytedance.msdk.g.dl
        public void dl() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar == null || uyVar.tb() == null) {
                return;
            }
            this.wp.tb().g();
        }

        @Override // com.bytedance.msdk.g.dl
        public int a() {
            return this.i;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return com.bytedance.msdk.z.dl.g.z(uyVar.iq());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            com.bytedance.sdk.openadsdk.ls.dl.g.uy uyVar = this.wp;
            if (uyVar != null) {
                return com.bytedance.msdk.z.dl.g.g(uyVar.iq());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            if (this.wp != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + zVar);
                this.wp.z(activity, zVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Dialog dialog, Integer[] numArr) {
            if (this.wp != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.wp.g(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
            if (this.wp == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle native : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.wp.z(activity);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Dialog dialog, Integer[] numArr) {
            if (this.wp == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.wp.z(dialog, numArr);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
            if (this.wp == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle native : getDislikeInfo");
            return this.wp.fv();
        }

        @Override // com.bytedance.msdk.g.dl
        public void ti(String str) {
            if (this.wp != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle native : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.wp.z(str);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.msdk.api.a.z.e.gc gz() {
            if (ti()) {
                return new com.bytedance.msdk.api.a.z.e.gc() { // from class: com.bytedance.msdk.dl.dl.g.z.g.gz.z.5
                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z(long j) {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().z(j);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void g(long j) {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().g(j);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z() {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().dl();
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void dl(long j) {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().dl(j);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void g() {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().a();
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z(int i, int i2) {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().z(i, i2);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z(long j, int i, int i2) {
                        if (z.this.wp == null || z.this.wp.g() == null) {
                            return;
                        }
                        z.this.wp.g().z(j, i, i2);
                    }
                };
            }
            return null;
        }
    }
}
