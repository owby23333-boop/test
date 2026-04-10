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

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public void z(final boolean z2, lq lqVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.msdk.dl.dl.g.z.g gVar2) {
        if (lqVar == null || gVar2 == null) {
            return;
        }
        lqVar.z(gVar, new com.bytedance.sdk.openadsdk.tb.z.g.z.g(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.dl.1
            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.g
            public void z(int i, String str) {
                gVar2.z(new com.bytedance.msdk.api.z(i, str));
            }

            @Override // com.bytedance.sdk.openadsdk.tb.z.g.z.g
            public void z(List<com.bytedance.sdk.openadsdk.ls.dl.g.fo> list) {
                if (list == null || list.isEmpty()) {
                    gVar2.z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.bytedance.sdk.openadsdk.ls.dl.g.fo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new z(it.next(), z2));
                }
                gVar2.z(arrayList);
            }
        });
    }

    private static class z extends com.bytedance.msdk.g.dl {
        private com.bytedance.sdk.openadsdk.ls.dl.g.fo kb;
        private int wp;
        com.bytedance.sdk.openadsdk.io.z.g.z.z fo = new com.bytedance.sdk.openadsdk.io.z.g.z.z(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.dl.dl.g.z.g.dl.z.3
            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(View view, i iVar) {
                if (z.this.m != null) {
                    z.this.m.z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void g(View view, i iVar) {
                if (z.this.m != null) {
                    z.this.m.z(view);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(i iVar) {
                if (z.this.m != null) {
                    z.this.m.z();
                }
            }
        };
        com.bytedance.sdk.openadsdk.iq.z.g.z.z uy = new com.bytedance.sdk.openadsdk.iq.z.g.z.z(0 == true ? 1 : 0) { // from class: com.bytedance.msdk.dl.dl.g.z.g.dl.z.4
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

        @Override // com.bytedance.msdk.g.dl
        public boolean tb() {
            return true;
        }

        z(com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar, boolean z) {
            Map<String, Object> mapIq;
            this.kb = foVar;
            com.bytedance.sdk.openadsdk.ls.dl.g.dl dlVarJs = foVar.js();
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
            x(foVar.e());
            lq(foVar.gz());
            h(foVar.fo());
            hh(foVar.v() != null ? foVar.v().dl() : null);
            kb(foVar.p());
            wp(foVar.ls());
            mc(foVar.i());
            a(foVar.uy());
            gz(foVar.ls() == 4);
            e(false);
            if (foVar.p() == 16 || foVar.p() == 3 || foVar.p() == 2 || foVar.p() == 131) {
                if (foVar.pf() != null && !foVar.pf().isEmpty() && foVar.pf().get(0) != null) {
                    com.bytedance.sdk.openadsdk.ls.dl.g.wp wpVar = foVar.pf().get(0);
                    l(wpVar.dl());
                    js(wpVar.z());
                    fv(wpVar.g());
                }
            } else if (foVar.p() == 4) {
                if (foVar.pf() != null && foVar.pf().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.bytedance.sdk.openadsdk.ls.dl.g.wp> it = foVar.pf().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().dl());
                    }
                    z((List<String>) arrayList);
                }
            } else {
                com.bytedance.sdk.openadsdk.ls.dl.g.wp wpVarGc = foVar.gc();
                if (wpVarGc == null && foVar.pf() != null && !foVar.pf().isEmpty() && foVar.pf().get(0) != null) {
                    wpVarGc = foVar.pf().get(0);
                }
                if (wpVarGc != null) {
                    l(wpVarGc.dl());
                    js(wpVarGc.z());
                    fv(wpVarGc.g());
                }
            }
            if (z && (mapIq = foVar.iq()) != null) {
                double dZ = com.bytedance.msdk.z.dl.g.z(mapIq.get("price"));
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_ECMP", "pangle draw 返回的 cpm价格：".concat(String.valueOf(dZ)));
                z(dZ <= 0.0d ? 0.0d : dZ);
            }
            this.kb.z(this.uy);
            z(MediationConstant.EXTRA_ADID, Long.valueOf(gm()));
            z(MediationConstant.EXTRA_CID, Long.valueOf(pd()));
            z("duration", Double.valueOf(this.kb.z()));
            Map<String, Object> mapIq2 = this.kb.iq();
            if (mapIq2 != null) {
                a(mapIq2);
                z(MediationConstant.EXTRA_LOG_EXTRA, mapIq2.toString());
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public Map<String, Object> h() {
            Map<String, Object> mapIq;
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar == null || (mapIq = foVar.iq()) == null) {
                return null;
            }
            dl(mapIq);
            return super.h();
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.z(viewGroup, list, list2, list3, list4, view);
            g(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar, List<View> list4) {
            FrameLayout frameLayout;
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar;
            View viewQ;
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar2;
            View viewFindViewById;
            super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
            g(viewGroup, null, list, list2, list3, null);
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar3 = this.kb;
            if (foVar3 != null && foVar3.m() != null && uyVar != null && (viewFindViewById = viewGroup.findViewById(uyVar.wp)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.kb.m());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.bytedance.msdk.z.gc.e.g(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.bytedance.msdk.z.gc.e.g(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.kb.m());
                }
            }
            if ((ti() && (foVar2 = this.kb) != null && foVar2.g() != null && !TextUtils.isEmpty(this.kb.g().z())) || uyVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(uyVar.e)) == null || (foVar = this.kb) == null || (viewQ = foVar.q()) == null) {
                return;
            }
            g(viewQ);
            frameLayout.removeAllViews();
            frameLayout.addView(viewQ, -1, -1);
        }

        private void g(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                try {
                    foVar.z(new com.bytedance.sdk.openadsdk.iq.z.g.z.g(null) { // from class: com.bytedance.msdk.dl.dl.g.z.g.dl.z.1
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
                this.kb.z(viewGroup, list, list2, list3, list4, view, this.fo);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public int jz() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                return foVar.dl();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.g.dl
        public int oz() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                return foVar.a();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.g.dl
        public String e() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar;
            if (!ti() || (foVar = this.kb) == null || foVar.g() == null) {
                return null;
            }
            return this.kb.g().z();
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.msdk.api.a.z.e.gc gz() {
            if (ti()) {
                return new com.bytedance.msdk.api.a.z.e.gc() { // from class: com.bytedance.msdk.dl.dl.g.z.g.dl.z.2
                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z(long j) {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().z(j);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void g(long j) {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().g(j);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z() {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().dl();
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void dl(long j) {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().dl(j);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void g() {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().a();
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z(int i, int i2) {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().z(i, i2);
                    }

                    @Override // com.bytedance.msdk.api.a.z.e.gc
                    public void z(long j, int i, int i2) {
                        if (z.this.kb == null || z.this.kb.g() == null) {
                            return;
                        }
                        z.this.kb.g().z(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.g.dl
        public void fv() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                foVar.z((com.bytedance.sdk.openadsdk.iq.z.g.z.z) null);
                this.kb = null;
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public boolean gc() {
            return this.kb == null;
        }

        @Override // com.bytedance.msdk.g.dl
        public String mn() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            return foVar != null ? com.bytedance.msdk.z.dl.g.dl(foVar.iq()) : "";
        }

        @Override // com.bytedance.msdk.g.dl
        public void z() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar == null || foVar.tb() == null || this.wp != 2) {
                return;
            }
            this.kb.tb().z();
        }

        @Override // com.bytedance.msdk.g.dl
        public void g() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar == null || foVar.tb() == null || this.wp != 3) {
                return;
            }
            this.kb.tb().z();
        }

        @Override // com.bytedance.msdk.g.dl
        public void dl() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar == null || foVar.tb() == null) {
                return;
            }
            this.kb.tb().g();
        }

        @Override // com.bytedance.msdk.g.dl
        public int a() {
            return this.wp;
        }

        @Override // com.bytedance.msdk.g.dl
        public long pd() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                return com.bytedance.msdk.z.dl.g.z(foVar.iq());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public long gm() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                return com.bytedance.msdk.z.dl.g.g(foVar.iq());
            }
            return 0L;
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw :  activity = " + activity + " pluginDislikeInteractionCallback:" + zVar);
                this.kb.z(activity, zVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Dialog dialog, Integer[] numArr) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.kb.g(dialog, numArr);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getDislikeDialog = ".concat(String.valueOf(activity)));
                return this.kb.z(activity);
            }
            return super.z(activity);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Dialog dialog, Integer[] numArr) {
            if (this.kb == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.kb.z(dialog, numArr);
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
            if (this.kb == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getDislikeInfo");
            return this.kb.fv();
        }

        @Override // com.bytedance.msdk.g.dl
        public void ti(String str) {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.kb.z(str);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public View uy() {
            if (this.kb == null) {
                return null;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getVideoView = " + this.kb.q());
            return this.kb.q();
        }

        @Override // com.bytedance.msdk.g.dl
        public void uy(boolean z) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                foVar.z(z);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(Bitmap bitmap, int i) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : setPauseIcon bitmap = " + bitmap + " i = " + i);
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                foVar.z(bitmap, i);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : setDrawVideoListener pluginDrawVideoListener = ".concat(String.valueOf(zVar)));
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                foVar.z(zVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public double no() {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getVideoDuration = " + this.kb.z());
                return this.kb.z();
            }
            return super.no();
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.wp c() {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getVideoCoverImage = " + this.kb.gc());
                return this.kb.gc();
            }
            return super.c();
        }

        @Override // com.bytedance.msdk.g.dl
        public Bitmap mj() {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getAdLogo = " + this.kb.m());
                return this.kb.m();
            }
            return super.mj();
        }

        @Override // com.bytedance.msdk.g.dl
        public int vy() {
            if (this.kb != null) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getAppCommentNum = " + this.kb.kb());
                return this.kb.kb();
            }
            return super.vy();
        }

        @Override // com.bytedance.msdk.g.dl
        public com.bytedance.sdk.openadsdk.ls.dl.g.gc vk() {
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                com.bytedance.sdk.openadsdk.ls.dl.g.gc gcVarTb = foVar.tb();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : getDownloadStatusController = ".concat(String.valueOf(gcVarTb)));
                return gcVarTb;
            }
            return super.vk();
        }

        @Override // com.bytedance.msdk.g.dl
        public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(dlVar)));
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                foVar.z(dlVar);
            }
        }

        @Override // com.bytedance.msdk.g.dl
        public void g(Activity activity) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "pangle draw : setActivityForDownloadApp  activity = ".concat(String.valueOf(activity)));
            com.bytedance.sdk.openadsdk.ls.dl.g.fo foVar = this.kb;
            if (foVar != null) {
                foVar.g(activity);
            }
        }
    }
}
